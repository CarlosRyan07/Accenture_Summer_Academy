package JogoXadrez;
// Classe para o Cavalo
public class Cavalo extends Peca {
    public Cavalo(String simbolo) {
        super(simbolo);
    }

    @Override
    public boolean validarMovimento(int origemLinha, int origemColuna, int destinoLinha, int destinoColuna, Peca[][] tabuleiro) {
        int deltaLinha = Math.abs(destinoLinha - origemLinha);
        int deltaColuna = Math.abs(destinoColuna - origemColuna);

        // Movimento em "L"
        return (deltaLinha == 2 && deltaColuna == 1) || (deltaLinha == 1 && deltaColuna == 2);
    }
}
