import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    private static final String API_KEY = System.getenv("GOOGLE_API_KEY"); // Adicione sua chave
    private static final String URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:streamGenerateContent";
    private static final ArrayList<String> history = new ArrayList<>();
    private static final int CAPACITY = 5; // Quantidade máxima de interações no histórico

    public static void main(String[] args) {
        while (true) {
            String userInput = JOptionPane.showInputDialog(null, "Você:", "Chat com API", JOptionPane.QUESTION_MESSAGE);

            if (userInput == null || userInput.equalsIgnoreCase("sair")) {
                JOptionPane.showMessageDialog(null, "Até mais!", "Encerrando", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

            try {
                String response = sendRequest(userInput);
                JOptionPane.showMessageDialog(null, response, "Resposta", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private static String sendRequest(String prompt) throws IOException, InterruptedException {
        // Mantém o histórico limitado
        if (history.size() == CAPACITY) {
            history.remove(0);
        }
        history.add("Você: " + prompt);

        String context = history.stream().collect(Collectors.joining("\n"));
        String fullPrompt = context + "\nResponda exclusivamente à última pergunta: " + prompt;

        String jsonRequest = "{\"contents\":[{\"parts\":[{\"text\":\"" + fullPrompt + "\"}],\"role\":\"user\"}]}";

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + "?alt=sse&key=" + API_KEY))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return processResponse(response);
    }

    private static String processResponse(HttpResponse<String> response) throws IOException {
        if (response.statusCode() != 200) {
            throw new IOException("Erro da API: Código " + response.statusCode());
        }

        // Extrai a resposta do JSON retornado pela API
        Pattern pattern = Pattern.compile("\"text\"\\s*:\\s*\"([^\"]+)\"");
        StringBuilder answer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new StringReader(response.body()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) continue;
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    answer.append(matcher.group(1)).append("\n");
                }
            }
        }
        String result = answer.toString().trim();
        history.add("API: " + result); // Adiciona a resposta ao histórico
        return result;
    }
}
