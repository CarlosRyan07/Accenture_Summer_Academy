import java.util.Scanner;

public class LocalizaNumero {
    public static void main(String[] args) {
        // Vetor com os valores dados
        int vetor[] = {1, 3, 5, 8, 9, 10};

        // Usar o Scanner para pegar o número a ser pesquisado
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número a ser pesquisado: ");
        int numero = scanner.nextInt();  // Lê o número do usuário
        boolean achou = false;
        int posicao = -1;  // Variável para armazenar a posição do número

        // Percorrer o vetor para encontrar o número
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == numero) {
                achou = true;
                posicao = i;  // Armazena a posição
                break;  // Sai do loop assim que encontrar o número
            }
        }

        // Exibir resultado
        if (achou) {
            System.out.println("Achei");
            System.out.printf("O número %d está localizado na posição %d.%n", numero, posicao);
        } else {
            System.out.println("Número não encontrado no vetor.");
        }

        // Fechar o scanner
        scanner.close();
    }
}
