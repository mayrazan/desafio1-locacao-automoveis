import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

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

    public void locaVeiculo() {
        System.out.println("Informe categoria da sua cnh: (A, B, C ou D)");
        String cnh = in.next().toUpperCase();
        System.out.println("Informe a placa do veiculo a ser locado: ");
        String placa = in.next().toUpperCase();

        for (Veiculo veiculo : cv.getVeiculos()) {
            if (verificacaoPlaca(veiculo.getPlaca(), placa)) {

                if (estaDisponivel(placa)) {

                    if (veiculo instanceof Caminhao || veiculo instanceof Carro && cnh.contains("C")) {
                        informaWpp(placa);
                        break;
                    } else if (veiculo instanceof Caminhao || veiculo instanceof Carro
                            || veiculo instanceof Onibus && cnh.contains("D")) {
                        informaWpp(placa);
                        break;
                    } else if (veiculo instanceof Carro && cnh.contains("B")) {
                        informaWpp(placa);
                        break;
                    } else if (veiculo instanceof Moto && cnh.contains("A")) {
                        informaWpp(placa);
                        break;
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
                liberaAutomatico(placa);
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
        System.out.println("Informe a placa do veiculo a ser liberado: ");
        String placa = in.next().toUpperCase();

        if (locacao.containsKey(placa)) {
            locacao.remove(placa);
           // datas.remove(placa);
            System.out.println("Veiculo liberado.");
        } else {
            System.out.println("Placa não existe.");
        }
    }

    public void informaData(String placa) {
        System.out.println("Informe data limite de locação: (Ex: 01/01/2021)");
        String dl = in.next();

        try {
            dataLocacao = new Date();
            dataLimite = formato.parse(dl);
        } catch (Exception e) {
            System.out.println("Data incorreta.");
        }
        historicoVencidas.put(placa, dataLimite);
    }

    public void mostraDatas() {
        if (historicoVencidas.isEmpty()) {
            System.out.println("Nenhuma locação vencida ainda.");
        } else {
            for (String placa : historicoVencidas.keySet()) {
                Date data = historicoVencidas.get(placa);
                if (dataLocacao.after(data)) {
                    System.out.println("Locação vencida. Placa: " + placa + ", data: " + data);
                }
            }
        }
    }

    public void liberaAutomatico(String placa) {
        if (dataLocacao.after(dataLimite)) {
            locacao.remove(placa);
        }
    }
}