import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class Locacao {
    private Map<String, String> locacao = new HashMap<String, String>();
    Scanner in = new Scanner(System.in);
    CadastroVeiculos cv = new CadastroVeiculos();

    public boolean estaDisponivel(String placa) {
        if (locacao.containsKey(placa)) {
            return false;
        } else {
            return true;
        }
    }

    public void locaVeiculo(String p, String c) {
        System.out.println("Informe categoria da cnh: (A, B, C ou D)");
        String cnh = in.next().toUpperCase();

        System.out.println("Informe a placa do veiculo a ser locado: ");
        String placa = in.next().toUpperCase();

        if (estaDisponivel(placa)) {
            if (p.equals(placa.toUpperCase()) && c.equals(cnh.toUpperCase())) {
                System.out.println("Informe numero de whatsapp: ");
                String wpp = in.next();
                locacao.put(placa, wpp);
                System.out.println("Veiculo locado com sucesso.");
            } else {
                System.out.println("Categoria não corresponde ao veiculo informado.");
            }
        } else {
            System.out.println("Veiculo já locado.");
        }
    }

    public void mostraVeiculosLocados() {
        if (locacao.isEmpty()) {
            System.out.println("Nenhum veiculo locado ainda.");
        } else {
            System.out.println("--- VEICULOS LOCADOS ---");
            for (String placa : locacao.keySet()) {
                String whatsapp = locacao.get(placa);
                System.out.println("Placa: " + placa + ", Whatsapp: " + whatsapp);
            }
        }
    }



}