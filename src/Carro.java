public class Carro extends Veiculo{
    private int portas;
    private boolean arCondicionado;
    private Cambio cambio;
    private Direcao direcao;

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
}
