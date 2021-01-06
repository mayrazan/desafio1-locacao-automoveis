import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Locacao {
    private Map<String, String> locacao = new HashMap<String, String>();
    private Map<String, Date> datas = new HashMap<String, Date>();
    Scanner in = new Scanner(System.in);
    CadastroVeiculos cv = CadastroVeiculos.getInstance();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Date dataLocacao = null;
    Date dataLimite = null;

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
        liberaPorData(placa);
        System.out.println("Veiculo locado com sucesso.");
        mostraDatas();
    }

    public void liberaVeiculo() {
        System.out.println("Informe a placa do veiculo a ser liberado: ");
        String placa = in.next().toUpperCase();

        if (locacao.containsKey(placa)) {
            locacao.remove(placa);
            System.out.println("Veiculo liberado.");
        } else {
            System.out.println("Placa não existe.");
        }
    }

    public void liberaPorData(String placa) {

        System.out.println("Informe data limite: (Ex: 01/01/2021)");
        String dl = in.next();

        try {
            dataLocacao = formato.parse("06/01/2021");
            dataLimite = formato.parse(dl);
        } catch (Exception e) {
            System.out.println("Data incorreta.");
        }
        String dataFormatada = formato.format(dataLimite);
        System.out.println(dataFormatada);
        datas.put(placa, dataLimite);

        if (dataLocacao.after(dataLimite)) {
            System.out.println("Locação vencida");
        }
        // utilize a biblioteca Date para criar uma locação com data limite, e indique
        // em tela quando essa locação tiver vencido.
    }

    public void mostraDatas() {
        for (String placa : datas.keySet()) {
            Date data = datas.get(placa);
            System.out.println("Placa: " + placa + ", data: " + data);
        }
    }
}