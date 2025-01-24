package JogoXadrez;

// Classe para a Torre (Rook)
public class Rook extends Peca {
    public Rook(String simbolo) {
        super(simbolo);
    }

    @Override
    public boolean validarMovimento(int origemLinha, int origemColuna, int destinoLinha, int destinoColuna, Peca[][] tabuleiro) {
        // Lógica de movimento da Torre (sem implementação completa para esse exercício)
        return false;
    }
}

