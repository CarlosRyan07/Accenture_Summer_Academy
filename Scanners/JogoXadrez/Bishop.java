package JogoXadrez;

// Classe para o Bispo (Bishop)
public class Bishop extends Peca {
    public Bishop(String simbolo) {
        super(simbolo);
    }

    @Override
    public boolean validarMovimento(int origemLinha, int origemColuna, int destinoLinha, int destinoColuna, Peca[][] tabuleiro) {
        // Lógica de movimento do Bispo (sem implementação completa para esse exercício)
        return false;
    }
}
