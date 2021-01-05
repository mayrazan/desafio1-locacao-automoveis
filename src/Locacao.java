import java.util.Map;
import java.util.HashMap;

public class Locacao {

    private boolean disponivel = true;
    private String cnh;
    private String whatsapp;
    private Veiculo veiculo;
    private Map<Veiculo, String> locacao = new HashMap<Veiculo, String>();

    public boolean estaDisponivel(String placa) {
        if (this.veiculo.getPlaca() != placa) {
            return this.disponivel;
        } else {
            return this.disponivel = false;
        }
    }

}