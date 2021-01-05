public enum Direcao {
    MECANICA("MECANICA"), HIDRAULICA("HIDRAULICA"), ELETRICA("ELETRICA");

    private String direcao;

    private Direcao(String direcao) {
        this.direcao = direcao;
    }

    public String toString() {
        return direcao;
    }

}