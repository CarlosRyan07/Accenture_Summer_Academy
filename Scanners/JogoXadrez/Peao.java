package JogoXadrez;

public class Peao extends Peca {
    public Peao(String simbolo) {
        super(simbolo);
    }

    @Override
    public boolean validarMovimento(int origemLinha, int origemColuna, int destinoLinha, int destinoColuna, Peca[][] tabuleiro) {
        int direcao = simbolo.equals("P") ? 1 : -1; // Peão branco sobe, preto desce

        // Movimento simples (uma casa para frente)
        if (destinoLinha == origemLinha + direcao && destinoColuna == origemColuna && tabuleiro[destinoLinha][destinoColuna] == null) {
            return true;
        }

        // Movimento inicial (duas casas para frente)
        if ((origemLinha == 1 && simbolo.equals("P")) || (origemLinha == 6 && simbolo.equals("p"))) {
            if (destinoLinha == origemLinha + 2 * direcao && destinoColuna == origemColuna && tabuleiro[destinoLinha][destinoColuna] == null) {
                return true;
            }
        }

        // Captura diagonal
        if (destinoLinha == origemLinha + direcao && Math.abs(destinoColuna - origemColuna) == 1 && tabuleiro[destinoLinha][destinoColuna] != null) {
            return true;
        }

        return false;
    }
}
