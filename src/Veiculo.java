public abstract class Veiculo {

    private String placa;
    private String marca;
    private int ano;
    private String cor;

    public Veiculo(String placa, String marca, int ano, String cor) {
        this.placa = placa;
        this.marca = marca;
        this.ano = ano;
        this.cor = cor;
    }

    public abstract String mostraInformacoesVeiculo();
    
    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

}
