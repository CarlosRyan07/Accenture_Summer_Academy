package JogoXadrez;

// Classe para o Rei (King)
public class King extends Peca {
    public King(String simbolo) {
        super(simbolo);
    }

    @Override
    public boolean validarMovimento(int origemLinha, int origemColuna, int destinoLinha, int destinoColuna, Peca[][] tabuleiro) {
        // Lógica de movimento do Rei (sem implementação completa para esse exercício)
        return false;
    }
}
