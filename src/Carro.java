public class Carro extends Veiculo {
    private int portas;
    private String arCondicionado;
    private Cambio cambio;
    private Direcao direcao;

    public Carro(String placa, String marca, int ano, String cor, int portas, String arCondicionado, Cambio cambio,
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

    public String getArCondicionado() {
        return this.arCondicionado;
    }

    public void setArCondicionado(String arCondicionado) {
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

    public void escolheDirecao(String escolha) {
        if (escolha.charAt(0) == 'M') {
            setDirecao(Direcao.MECANICA);
        } else if (escolha.charAt(0) == 'H') {
            setDirecao(Direcao.HIDRAULICA);
        } else if (escolha.charAt(0) == 'E') {
            setDirecao(Direcao.ELETRICA);
        }
    }

    public void possuiArCondicionado(String escolha) {
        if (escolha.charAt(0) == 'S') {
            setArCondicionado("Sim");
        } else if (escolha.charAt(0) == 'N') {
            setArCondicionado("Não");
        }
    }

    @Override
    public String mostraInformacoesVeiculo() {
        System.out.println("--- Informações do Carro ---");
        return "Placa: " + this.getPlaca() + ", Marca: " + this.getMarca() + ", Cor: " + this.getCor() + ", Ano: "
                + this.getAno() + ", Portas: " + this.getPortas() + ", Ar-Condicionado: " + this.getArCondicionado()
                + ", Cambio: " + this.getCambio().toString() + ", Direção: " + this.getDirecao();
    }
}