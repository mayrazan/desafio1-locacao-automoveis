import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

public class Locacao {
    private Map<String, String> locacao = new HashMap<String, String>();
    private Map<String, Date> historicoVencidas = new HashMap<String, Date>();
    Scanner in = new Scanner(System.in);
    private CadastroVeiculos cv = CadastroVeiculos.getInstance();
    private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    private Date dataLocacao = null;
    private Date dataLimite = null;

    public boolean estaDisponivel(String placa) {
        if (locacao.containsKey(placa)) {
            System.out.println("Veiculo já locado.");
            return false;
        } else {
            return true;
        }
    }

    public void locaVeiculo() throws IOException {
        System.out.println("Informe categoria da sua cnh: (A, B, C ou D)");
        String cnh = in.next().toUpperCase();
        System.out.println("Informe a placa do veiculo a ser locado: ");
        String placa = in.next().toUpperCase();

        for (Veiculo veiculo : cv.getVeiculos()) {
            if (verificacaoPlaca(veiculo.getPlaca(), placa)) {
                if (estaDisponivel(placa)) {
                    if (veiculo instanceof Caminhao && cnh.equalsIgnoreCase("C")
                            || veiculo instanceof Carro && cnh.equalsIgnoreCase("C")) {
                        informaWpp(placa);
                    } else if (veiculo instanceof Caminhao && cnh.equalsIgnoreCase("D")
                            || veiculo instanceof Carro && cnh.equalsIgnoreCase("D")
                            || veiculo instanceof Onibus && cnh.equalsIgnoreCase("D")) {
                        informaWpp(placa);
                    } else if (veiculo instanceof Carro && cnh.equalsIgnoreCase("B")) {
                        informaWpp(placa);
                    } else if (cnh.equalsIgnoreCase("A") && veiculo instanceof Moto) {
                        informaWpp(placa);
                    } else {
                        System.out.println("Categoria não corresponde ao veiculo informado.");
                    }
                }
            }
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

    public boolean verificacaoPlaca(String veiculo, String placa) {
        if (veiculo.equals(placa)) {
            return true;
        }
        return false;
    }

    public void informaWpp(String placa) {
        System.out.println("Informe numero de whatsapp: ");
        String wpp = in.next();
        locacao.put(placa, wpp);
        informaData(placa);
        System.out.println("Veiculo locado com sucesso.");
    }

    public void liberaVeiculo() {
        if (locacao.isEmpty()) {
            System.out.println("Nenhum veiculo a ser liberado ainda.");
        } else {
            System.out.println("Informe a placa do veiculo a ser liberado: ");
            String placa = in.next().toUpperCase();

            if (locacao.containsKey(placa)) {
                locacao.remove(placa);
                historicoVencidas.remove(placa);
                System.out.println("Veiculo liberado.");
            } else {
                System.out.println("Placa não existe.");
            }
        }
    }

    public void informaData(String placa) {
        dataLocacao = new Date();
        while (dataLimite == null) {
            System.out.println("Informe data limite de locação: (Ex: 01/01/2021)");
            String dl = in.next();
            try {
                dataLimite = formato.parse(dl);
            } catch (ParseException e) {
                System.out.println("Data no formato incorreto.");
            }
        }
        if (dataLocacao.after(dataLimite)) {
            historicoVencidas.put(placa, dataLimite);
        }

        dataLimite = null;
    }

    public void mostraDatas() {
        if (historicoVencidas.isEmpty()) {
            System.out.println("Nenhuma locação vencida ainda.");
        } else {
            for (String placa : historicoVencidas.keySet()) {
                Date data = historicoVencidas.get(placa);
                System.out.println("Locação vencida. Placa: " + placa + ", data: " + data);
            }
        }
    }

    public void liberaTodasVencidas() {
        for (Object placa : new HashSet<>(historicoVencidas.keySet())) {
            historicoVencidas.remove(placa);
            locacao.remove(placa);
        }
        System.out.println("Locações vencidas liberadas.");
    }
}