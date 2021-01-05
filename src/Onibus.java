public class Onibus extends Veiculo {

    private int quantidadeAssentos;

    public Onibus(String placa, String marca, int ano, String cor, int quantidadeAssentos) {
        super(placa, marca, ano, cor);
        this.quantidadeAssentos = quantidadeAssentos;
    }

    public int getQuantidadeAssentos() {
        return this.quantidadeAssentos;
    }

    public void setQuantidadeAssentos(int quantidadeAssentos) {
        this.quantidadeAssentos = quantidadeAssentos;
    }

    @Override
    public String mostraInformacoesVeiculo() {
        System.out.println("--- Informações do Ônibus ---");
        return "Placa: " + this.getPlaca() + ", Marca: " + this.getMarca() + ", Cor: " + this.getCor() + ", Ano: "
                + this.getAno() + ", Quantidade de assentos: " + this.getQuantidadeAssentos();
    }
}