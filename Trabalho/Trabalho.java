import java.util.Scanner;
import java.time.LocalTime;

public class Trabalho {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento(10);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Estacionar veículo");
            System.out.println("2 - Remover veículo");
            System.out.println("3 - Listar vagas");
            System.out.println("4 - Total de veículos");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    LocalTime horaAtual = LocalTime.now();
                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Marca: ");
                    String marca = scanner.nextLine();
                    String tipo;
                    while(true){
                        System.out.print("Tipo (pequeno/grande/moto): ");
                        tipo = scanner.nextLine();

                        if (tipo.equals("pequeno") || tipo.equals("grande") || tipo.equals("moto")) {
                            break;
                        } else {
                            System.out.println("LEIA DIREITO PANACA\n");
                        }
                    }
                    System.out.print("Vaga (0 a 9): ");
                    int vaga = scanner.nextInt();
                    scanner.nextLine();

                    Carro novoCarro = new Carro(placa, modelo, marca, tipo, horaAtual);
                    estacionamento.adicionarCarro(novoCarro, vaga);
                    break;

                case 2:
                    System.out.print("Placa do veículo a remover: ");
                    String placaRemover = scanner.nextLine();
                    estacionamento.removerCarroPorPlaca(placaRemover);
                    break;

                case 3:
                    estacionamento.listarVagas();
                    break;

                case 4:
                    System.out.println("Total de veículos: " + estacionamento.totalCarros());
                    break;

                case 5:
                    System.out.println("Encerrando...");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
