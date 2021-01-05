public enum Cambio {

    MANUAL("MANUAL"), AUTOMATICO("AUTOMATICO");

    private String cambio;

    private Cambio(String cambio) {
        this.cambio = cambio;
    }

    public String toString() {
        return cambio;
    }

}