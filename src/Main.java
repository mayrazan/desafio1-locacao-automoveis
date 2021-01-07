import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        CadastroVeiculos cv = CadastroVeiculos.getInstance();
        Locacao locacao = new Locacao();

        do {
            try {
                System.out.println("1\t Cadastrar Veiculo: ");
                System.out.println("2\t Mostrar veiculos cadastrados: ");
                System.out.println("3\t Mostrar veiculos locados: ");
                System.out.println("4\t Locar Veiculo: ");
                System.out.println("5\t Liberar veiculo locado: ");
                System.out.println("6\t Mostrar locações vencidas: ");
                System.out.println("7\t Liberar todas as locações vencidas: ");
                System.out.println("0\t Sair: ");

                System.out.println("Entre com sua escolha: ");

                int escolha = in.nextInt();

                switch (escolha) {
                    case 1:
                        System.out.println("1\t Carro: ");
                        System.out.println("2\t Moto: ");
                        System.out.println("3\t Caminhão: ");
                        System.out.println("4\t Ônibus");
                        int opcao = in.nextInt();

                        cv.chamaCadastro(opcao);
                        break;
                    case 2:
                        cv.mostraVeiculos();
                        break;
                    case 3:
                        locacao.mostraVeiculosLocados();
                        break;
                    case 4:
                        locacao.locaVeiculo();
                        break;
                    case 5:
                        locacao.liberaVeiculo();
                        break;
                    case 6:
                        locacao.mostraDatas();
                        break;
                    case 7:
                        locacao.liberaTodasVencidas();
                        break;
                }

                System.out.println();
                if (escolha == 0 || escolha > 7) {
                    in.close();
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Informe somente números!");
                in.nextLine();
            }

        } while (true);
    }
}