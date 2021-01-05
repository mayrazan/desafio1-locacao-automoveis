import java.util.ArrayList;
import java.util.Scanner;

public class CadastroVeiculos {

    private ArrayList<Veiculo> veiculos = new ArrayList<>();
    Scanner in = new Scanner(System.in);

    public void cadastraVeiculo(Veiculo v) {
        if (v instanceof Carro) {
            tipoCarro((Carro) v);
        }
        veiculos.add(v);
        System.out.println("Veiculo cadastrado com sucesso!");
    }

    public void tipoCarro(Carro c) {
        System.out.println("Informe cambio: ");
        String cambio = in.next().toUpperCase();
        c.escolheCambio(cambio);
        System.out.println("Informe placa: ");
        String placa = in.next();
        c.setPlaca(placa);
        System.out.println("Informe marca: ");
        String marca = in.next();
        c.setMarca(marca);
        c.mostraInformacoesVeiculo();
    }

    public void mostraVeiculos() {
        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo.mostraInformacoesVeiculo());
            System.out.println(
                    veiculo.getPlaca() + ", " + veiculo.getMarca() + ", " + veiculo.getCor() + ", " + veiculo.getAno());
        }
    }

}
