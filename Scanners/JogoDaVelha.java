import javax.swing.JOptionPane;

public class JogoDaVelha {

    public static void main(String[] args) {
        String[][] tabuleiro = { 
                        {" ", " ", " "},
                        {" ", " ", " "},
                        {" ", " ", " "}};
        
        String jogadorAtual = "X"; 
        boolean ganhou = false;

        while (!ganhou) {
            // Optei por melhorar o design do tabuleiro para ficar mais dinâmico
            imprimirTabuleiro(tabuleiro);

            String input = JOptionPane.showInputDialog("Jogador " + jogadorAtual + ", insira sua jogada (linha e coluna) separados por espaço:");
            String[] posicao = input.split(" ");
            int linha = -1, coluna = -1;

            // Validação da entrada
            while (true) {
                try {
                    linha = Integer.parseInt(posicao[0]);
                    coluna = Integer.parseInt(posicao[1]);

                    if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna].equals(" ")) {
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Posição inválida ou já ocupada! Tente novamente.");
                        input = JOptionPane.showInputDialog("Jogador " + jogadorAtual + ", insira sua jogada (linha e coluna) separados por espaço:");
                        posicao = input.split(" ");
                    }
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida! Por favor, insira dois números entre 0 e 2.");
                    input = JOptionPane.showInputDialog("Jogador " + jogadorAtual + ", insira sua jogada (linha e coluna) separados por espaço:");
                    posicao = input.split(" ");
                }
            }

            tabuleiro[linha][coluna] = jogadorAtual;

            ganhou = verificarVencedor(tabuleiro, jogadorAtual);

            if (ganhou) {
                imprimirTabuleiro(tabuleiro);
                JOptionPane.showMessageDialog(null, "Parabéns! O jogador " + jogadorAtual + " venceu!");
                break;
            }

            jogadorAtual = jogadorAtual.equals("X") ? "O" : "X";
        }
    }

    public static void imprimirTabuleiro(String[][] tabuleiro) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n  ╔═══╦═══╦═══╗\n");
        for (int i = 0; i < 3; i++) {
            sb.append("  ║");
            for (int j = 0; j < 3; j++) {
                sb.append(" " + tabuleiro[i][j] + "    ║");
            }
            sb.append("\n");
            if (i < 2) {
                sb.append("  ╠═══╬═══╬═══╣\n");
            }
        }
        sb.append("  ╚═══╩═══╩═══╝\n");
        sb.append("     0   1   2\n");
        
        // Aqui usamos "\n" para garantir que a formatação fique correta
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public static boolean verificarVencedor(String[][] tabuleiro, String jogador) {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0].equals(jogador) && tabuleiro[i][1].equals(jogador) && tabuleiro[i][2].equals(jogador)) {
                return true; // Linha completa
            }
            if (tabuleiro[0][i].equals(jogador) && tabuleiro[1][i].equals(jogador) && tabuleiro[2][i].equals(jogador)) {
                return true; // Coluna completa
            }
        }
        if (tabuleiro[0][0].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][2].equals(jogador)) {
            return true; // Diagonal principal
        }
        if (tabuleiro[0][2].equals(jogador) && tabuleiro[1][1].equals(jogador) && tabuleiro[2][0].equals(jogador)) {
            return true; // Diagonal secundária
        }
        return false;
    }
}
