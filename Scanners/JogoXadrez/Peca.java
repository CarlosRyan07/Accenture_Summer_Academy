package JogoXadrez;

// Classe base para as peças
public abstract class Peca {
    String simbolo;

    public Peca(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return simbolo;
    }

    // Método abstrato para validar movimentos
    public abstract boolean validarMovimento(int origemLinha, int origemColuna, int destinoLinha, int destinoColuna, Peca[][] tabuleiro);
}
