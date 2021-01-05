public class Moto extends Veiculo {

    private int quantidadeCilindradas;

    public Moto(String placa, String marca, int ano, String cor, int quantidadeCilindradas) {
        super(placa, marca, ano, cor);
        this.quantidadeCilindradas = quantidadeCilindradas;
    }

    public int getCilindradas() {
        return this.quantidadeCilindradas;
    }

    public void setCilindradas(int quantidadeCilindradas) {
        this.quantidadeCilindradas = quantidadeCilindradas;
    }

    @Override
    public String mostraInformacoesVeiculo() {
        // TODO Auto-generated method stub
        return null;
    }
}