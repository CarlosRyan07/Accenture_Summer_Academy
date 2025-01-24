package JogoXadrez;

import javax.swing.*;

public class ChessBoard {
    public static void main(String[] args) {
        Peca[][] tabuleiro = new Peca[8][8];

        // Inicialização das peças
        tabuleiro[0][0] = new Rook("R");
        tabuleiro[0][1] = new Cavalo("N");
        tabuleiro[0][2] = new Bishop("B");
        tabuleiro[0][3] = new Queen("Q");
        tabuleiro[0][4] = new King("K");
        tabuleiro[0][5] = new Bishop("B");
        tabuleiro[0][6] = new Cavalo("N");
        tabuleiro[0][7] = new Rook("R");

        tabuleiro[1][0] = new Peao("P");
        tabuleiro[1][1] = new Peao("P");
        tabuleiro[1][2] = new Peao("P");
        tabuleiro[1][3] = new Peao("P");
        tabuleiro[1][4] = new Peao("P");
        tabuleiro[1][5] = new Peao("P");
        tabuleiro[1][6] = new Peao("P");
        tabuleiro[1][7] = new Peao("P");

        tabuleiro[6][0] = new Peao("p");
        tabuleiro[6][1] = new Peao("p");
        tabuleiro[6][2] = new Peao("p");
        tabuleiro[6][3] = new Peao("p");
        tabuleiro[6][4] = new Peao("p");
        tabuleiro[6][5] = new Peao("p");
        tabuleiro[6][6] = new Peao("p");
        tabuleiro[6][7] = new Peao("p");

        tabuleiro[7][0] = new Rook("r");
        tabuleiro[7][1] = new Cavalo("n");
        tabuleiro[7][2] = new Bishop("b");
        tabuleiro[7][3] = new Queen("q");
        tabuleiro[7][4] = new King("k");
        tabuleiro[7][5] = new Bishop("b");
        tabuleiro[7][6] = new Cavalo("n");
        tabuleiro[7][7] = new Rook("r");

        boolean jogoAtivo = true;

        while (jogoAtivo) {
            // Exibir o tabuleiro atual
            exibirTabuleiro(tabuleiro);

            // Solicitar a peça e o movimento do jogador
            String origem = JOptionPane.showInputDialog("Digite a posição da peça que deseja mover (ex: A1):");

            // Verificar se o usuário cancelou ou fechou a janela
            if (origem == null) {
                JOptionPane.showMessageDialog(null, "Jogo encerrado pelo jogador!");
                break; // Sai do jogo
            }

            // Validação da entrada para posição de origem
            if (origem.length() < 2) {
                JOptionPane.showMessageDialog(null, "Entrada inválida para a posição da peça!");
                continue;
            }

            // Conversão da linha de letra (A-H) para número (0-7)
            int origemLinha = origem.charAt(0) - 'A';
            // Conversão da coluna (1-8) para índice (0-7)
            int origemColuna = Integer.parseInt(origem.substring(1)) - 1;

            if (origemLinha < 0 || origemLinha >= 8 || origemColuna < 0 || origemColuna >= 8) {
                JOptionPane.showMessageDialog(null, "Posição fora dos limites do tabuleiro!");
                continue;
            }

            // Verificar se há uma peça na posição de origem
            Peca pecaOrigem = tabuleiro[origemLinha][origemColuna];
            if (pecaOrigem == null) {
                JOptionPane.showMessageDialog(null, "Não há peça na posição escolhida! Tente novamente.");
                continue;
            }

            // Solicitar a posição de destino
            String destino = JOptionPane.showInputDialog("Digite a posição de destino (ex: A3):");

            // Verificar se o usuário cancelou ou fechou a janela
            if (destino == null) {
                JOptionPane.showMessageDialog(null, "Jogo encerrado pelo jogador!");
                break; // Sai do jogo
            }

            // Validação da entrada para posição de destino
            if (destino.length() < 2) {
                JOptionPane.showMessageDialog(null, "Entrada inválida para a posição de destino!");
                continue;
            }

            // Conversão da linha de letra (A-H) para número (0-7)
            int destinoLinha = destino.charAt(0) - 'A';
            // Conversão da coluna (1-8) para índice (0-7)
            int destinoColuna = Integer.parseInt(destino.substring(1)) - 1;

            if (destinoLinha < 0 || destinoLinha >= 8 || destinoColuna < 0 || destinoColuna >= 8) {
                JOptionPane.showMessageDialog(null, "Posição fora dos limites do tabuleiro!");
                continue;
            }

            // Validar o movimento da peça
            if (pecaOrigem.validarMovimento(origemLinha, origemColuna, destinoLinha, destinoColuna, tabuleiro)) {
                tabuleiro[destinoLinha][destinoColuna] = pecaOrigem;
                tabuleiro[origemLinha][origemColuna] = null;
                JOptionPane.showMessageDialog(null, "Movimento realizado!");
            } else {
                JOptionPane.showMessageDialog(null, "Movimento inválido para essa peça! Tente novamente.");
                continue;
            }

            // Perguntar se o jogador quer continuar jogando
            int continuar = JOptionPane.showConfirmDialog(null, "Deseja continuar jogando?", "Jogo de Xadrez", JOptionPane.YES_NO_OPTION);
            if (continuar == JOptionPane.NO_OPTION) {
                jogoAtivo = false;
            }
        }

        JOptionPane.showMessageDialog(null, "Jogo encerrado!");
    }

    // Função para exibir o tabuleiro
    public static void exibirTabuleiro(Peca[][] tabuleiro) {
        StringBuilder tabuleiroVisual = new StringBuilder();

        // Adiciona a linha com os números de coluna (0 a 7)
        tabuleiroVisual.append("    ---1----2-----3-----4----5-----6----7----8\n");
        tabuleiroVisual.append("   ┌───┬───┬───┬───┬───┬───┬───┬───┐\n");

        // Adiciona as linhas do tabuleiro com números nas laterais (A a H)
        for (int i = 0; i < tabuleiro.length; i++) {
            tabuleiroVisual.append((char) ('A' + i)).append(" │ "); // Letras A a H nas laterais
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (tabuleiro[i][j] == null) {
                    tabuleiroVisual.append("   │");
                } else {
                    tabuleiroVisual.append(" ").append(tabuleiro[i][j].getSimbolo()).append(" │");
                }
            }
            tabuleiroVisual.append("\n");

            if (i < tabuleiro.length - 1) {
                tabuleiroVisual.append("   ├───┼───┼───┼───┼───┼───┼───┼───┤\n");
            }
        }
        tabuleiroVisual.append("   └───┴───┴───┴───┴───┴───┴───┴───┘\n");

        JOptionPane.showMessageDialog(null, tabuleiroVisual.toString(), "Tabuleiro de Xadrez", JOptionPane.PLAIN_MESSAGE);
    }
}
