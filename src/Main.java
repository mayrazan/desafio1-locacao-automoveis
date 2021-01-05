import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        CadastroVeiculos cv = new CadastroVeiculos();

        do {
            System.out.println("1\t Cadastrar Veiculo: ");
            System.out.println("2\t Mostrar veiculos cadastrados: ");
            System.out.println("3\t Locar Veiculo: ");
            System.out.println("4\t Liberar veiculo locado");
            System.out.println("0\t Sair: ");

            System.out.println("Entre com sua escolha: ");

            int escolha = in.nextInt();

            switch (escolha) {
                case 1:
                    Carro carro = new Carro(null, null, 0, null, 0, false, null, null);
                    cv.cadastraVeiculo(carro);
                    break;
                case 2:
                    cv.mostraVeiculos();
                    break;

                case 3:

                    break;

                case 4:

                    break;
            }

            System.out.println();
            if (escolha == 0 || escolha > 4) {
                in.close();
                break;
            }
        } while (true);
    }
}