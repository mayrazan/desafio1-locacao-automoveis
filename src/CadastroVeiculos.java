import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class CadastroVeiculos {

    private ArrayList<Veiculo> veiculos = new ArrayList<>();
    private Map<String, String> categoria = new HashMap<String, String>();
    Scanner in = new Scanner(System.in);

    public void cadastraVeiculo(Veiculo v) {
        if (v instanceof Carro) {
            tipoCarro((Carro) v);
            categoria.put("B", v.getPlaca());
        } else if (v instanceof Moto) {
            tipoMoto((Moto) v);
            categoria.put("A", v.getPlaca());
        } else if (v instanceof Caminhao) {
            tipoCaminhao((Caminhao) v);
            categoria.put("C", v.getPlaca());
        } else if (v instanceof Onibus) {
            tipoOnibus((Onibus) v);
            categoria.put("D", v.getPlaca());
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

    public void mostra() {
        for (String c : categoria.keySet()) {
            String placa = categoria.get(c);
            System.out.println("categoria: " + c + ", placa: " + placa);
        }
    }

    public ArrayList<Veiculo> getVeiculos() {
        return this.veiculos;
    }

    public Map<String, String> getCategorias() {
        return this.categoria;
    }
}
