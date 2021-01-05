public enum Direcao {
    MECANICA("M"), HIDRAULICA("H"), ELETRICA("E");

    private final String direcao;

    private Direcao(String direcao) {
        this.direcao = direcao;
    }

    public String getDirecao() {
        return direcao;
    }

    

    public String toString(){
        return direcao;
      }

}
