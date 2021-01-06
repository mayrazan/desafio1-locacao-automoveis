import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        CadastroVeiculos cv = CadastroVeiculos.getInstance();
        Locacao locacao = new Locacao();

        do {
            System.out.println("1\t Cadastrar Veiculo: ");
            System.out.println("2\t Mostrar veiculos cadastrados: ");
            System.out.println("3\t Mostrar veiculos locados: ");
            System.out.println("4\t Locar Veiculo: ");
            System.out.println("5\t Liberar veiculo locado: ");
            System.out.println("6\t Mostrar locações vencidas: ");
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

                    System.out.println("Informe placa: ");
                    String placa = in.next().toUpperCase();

                    if (cv.verificaPlaca(placa)) {
                        System.out.println("Informe marca: ");
                        String marca = in.next();
                        System.out.println("Informe ano: ");
                        int ano = in.nextInt();
                        System.out.println("Informe cor: ");
                        String cor = in.next();

                        if (opcao == 1) {
                            Carro carro = new Carro(placa, marca, ano, cor, 0, null, null, null);
                            cv.cadastraVeiculo(carro);
                        } else if (opcao == 2) {
                            Moto moto = new Moto(placa, marca, ano, cor, 0);
                            cv.cadastraVeiculo(moto);
                        } else if (opcao == 3) {
                            Caminhao caminhao = new Caminhao(placa, marca, ano, cor, 0.0);
                            cv.cadastraVeiculo(caminhao);
                        } else if (opcao == 4) {
                            Onibus onibus = new Onibus(placa, marca, ano, cor, 0);
                            cv.cadastraVeiculo(onibus);
                        }
                    }
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
            }

            System.out.println();
            if (escolha == 0 || escolha > 6) {
                in.close();
                break;
            }
        } while (true);
    }
}