public class Carro extends Veiculo {
    private int portas;
    private boolean arCondicionado;
    private Cambio cambio;
    private Direcao direcao;

    public Carro(String placa, String marca, int ano, String cor, int portas, boolean arCondicionado, Cambio cambio,
            Direcao direcao) {
        super(placa, marca, ano, cor);
        this.portas = portas;
        this.arCondicionado = arCondicionado;
        this.cambio = cambio;
        this.direcao = direcao;
    }

	public int getPortas() {
        return this.portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public boolean getArCondicionado() {
        return this.arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public Direcao getDirecao() {
        return this.direcao;
    }

    public void setDirecao(Direcao direcao) {
        this.direcao = direcao;
    }

    public Cambio getCambio() {
        return this.cambio;
    }

    public void setCambio(Cambio cambio) {
        this.cambio = cambio;
    }

    public void escolheCambio(String escolha) {
        if (escolha.charAt(0) == 'M') {
            setCambio(Cambio.MANUAL);
        } else if (escolha.charAt(0) == 'A') {
            setCambio(Cambio.AUTOMATICO);
        }
    }

    @Override
    public String mostraInformacoesVeiculo() {
        return this.getPortas() + " " + this.getArCondicionado() + " " + this.getCambio().toString() + " "
                + this.getDirecao();
    }
}
