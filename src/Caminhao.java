public class Caminhao extends Veiculo {

    private double capacidade;

    public Caminhao(String placa, String marca, int ano, String cor, String categoria, double capacidade) {
        super(placa, marca, ano, cor, categoria);
        this.capacidade = capacidade;
    }

    public double getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    @Override
    public String mostraInformacoesVeiculo() {
        System.out.println("--- Informações do Caminhão ---");
        return "Placa: " + this.getPlaca() + ", Marca: " + this.getMarca() + ", Cor: " + this.getCor() + ", Ano: "
                + this.getAno() + ", Capacidade: " + this.getCapacidade() + " toneladas.";
    }
}