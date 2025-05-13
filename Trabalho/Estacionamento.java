import java.time.Duration;
import java.time.LocalTime;

public class Estacionamento {
    private Carro[] vagas;

    public Estacionamento(int tamanho) {
        vagas = new Carro[tamanho];
    }

    public boolean adicionarCarro(Carro carro, int vaga) {
        if (vaga < 0 || vaga >= vagas.length) {
            System.out.println("Vaga inválida.");
            return false;
        }
        if (vagas[vaga] != null) {
            System.out.println("Erro: Vaga já ocupada.");
            return false;
        }
        vagas[vaga] = carro;
        System.out.println("Carro estacionado na vaga " + vaga);
        return true;
    }

    public boolean removerCarroPorPlaca(String placa) {
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] != null && vagas[i].getPlaca().equalsIgnoreCase(placa)) {
                LocalTime horaSaida = LocalTime.now();
                LocalTime horaEntrada = vagas[i].getHoraEntrada();
                
                long minutos = Duration.between(horaEntrada, horaSaida).toMinutes();
    
                double precoPorMinuto = 0.0;
                String tipo = vagas[i].getTipo();
    
                switch (tipo) {
                    case "pequeno":
                        precoPorMinuto = 0.26;
                        break;
                    case "grande":
                        precoPorMinuto = 0.42;
                        break;
                    case "moto":
                        precoPorMinuto = 0.13;
                        break;
                    default:
                        break;
                }
    
                double total = minutos * precoPorMinuto;
    
                System.out.println("Veículo removido da vaga " + i);
                System.out.println("Tempo de permanência: " + minutos + " minutos.");
                System.out.printf("Total a pagar: R$ %.2f\n", total);
                vagas[i] = null;
                return true;
            }
        }
        System.out.println("Veículo com placa " + placa + " não encontrado.");
        return false;
    }

    public void listarVagas() {
        for (int i = 0; i < vagas.length; i++) {
            if (vagas[i] == null) {
                System.out.println("Vaga " + i + ": Livre");
            } else {
                System.out.println("Vaga " + i + ": Ocupada por " + vagas[i]);
            }
        }
    }

    public int totalCarros() {
        int total = 0;
        for (Carro c : vagas) {
            if (c != null) total++;
        }
        return total;
    }
}
