import java.util.ArrayList;
import java.util.Scanner;

public class CadastroVeiculos {

    private ArrayList<Veiculo> veiculos = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    private static CadastroVeiculos instancia;

    private CadastroVeiculos() {
    }

    public static synchronized CadastroVeiculos getInstance() {
        if (instancia == null)
            instancia = new CadastroVeiculos();

        return instancia;
    }

    public void cadastraVeiculo(Veiculo v) {
        if (v instanceof Carro) {
            tipoCarro((Carro) v);
        } else if (v instanceof Moto) {
            tipoMoto((Moto) v);
        } else if (v instanceof Caminhao) {
            tipoCaminhao((Caminhao) v);
        } else if (v instanceof Onibus) {
            tipoOnibus((Onibus) v);
        }
        veiculos.add(v);
        System.out.println("Veiculo cadastrado com sucesso!");
    }

    public void tipoCarro(Carro c) {
        System.out.println("Informe quantidade de portas: ");
        int portas = in.nextInt();
        c.setPortas(portas);
        System.out.println("Informe se possui ar-condicionado: (S ou N)");
        String arCondicionado = in.next().toUpperCase();
        c.possuiArCondicionado(arCondicionado);
        System.out.println("Informe cambio: (M ou A)");
        String cambio = in.next().toUpperCase();
        c.escolheCambio(cambio);
        System.out.println("Informe direção: (M, H ou E)");
        String direcao = in.next().toUpperCase();
        c.escolheDirecao(direcao);
    }

    public void tipoMoto(Moto m) {
        System.out.println("Informe quantidade de cilindradas: ");
        int cilindradas = in.nextInt();
        m.setCilindradas(cilindradas);
    }

    public void tipoCaminhao(Caminhao c) {
        System.out.println("Informe capacidade em toneladas: ");
        double capacidade = in.nextDouble();
        c.setCapacidade(capacidade);
    }

    public void tipoOnibus(Onibus o) {
        System.out.println("Informe quantidade de assentos: ");
        int assentos = in.nextInt();
        o.setQuantidadeAssentos(assentos);
    }

    public void mostraVeiculos() {
        if (!veiculos.isEmpty()) {
            System.out.println("--- VEICULOS CADASTRADOS ---");
            for (Veiculo veiculo : veiculos) {
                System.out.println(veiculo.mostraInformacoesVeiculo());
            }
        } else {
            System.out.println("Nenhum veiculo cadastrado ainda.");
        }
    }

    public boolean verificaPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                System.out.println("Placa já cadastrada! Tente novamente.");
                return false;
            }
            break;
        }
        return true;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }
}