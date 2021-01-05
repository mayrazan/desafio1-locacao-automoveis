public class Caminhao extends Veiculo {

    private double capacidade;

    public Caminhao(String placa, String marca, int ano, String cor, double capacidade) {
        super(placa, marca, ano, cor);
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
        // TODO Auto-generated method stub
        return null;
    }
}
