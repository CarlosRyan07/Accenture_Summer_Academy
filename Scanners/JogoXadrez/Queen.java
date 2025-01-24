package JogoXadrez;

// Classe para a Rainha (Queen)
public class Queen extends Peca {
    public Queen(String simbolo) {
        super(simbolo);
    }

    @Override
    public boolean validarMovimento(int origemLinha, int origemColuna, int destinoLinha, int destinoColuna, Peca[][] tabuleiro) {
        // Lógica de movimento da Rainha (sem implementação completa para esse exercício)
        return false;
    }
}
