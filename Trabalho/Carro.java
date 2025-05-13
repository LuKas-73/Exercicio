import java.time.LocalTime;

public class Carro {
    private String placa;
    private String modelo;
    private String marca;
    private String tipo;
    private LocalTime horaEntrada;

    public Carro(String placa, String modelo, String marca, String tipo, LocalTime tempo) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo.toLowerCase();
        this.horaEntrada = tempo;
    }

    public String getPlaca() { 
        return placa; 
    }

    public String getModelo() { 
        return modelo; 
    }

    public String getMarca() { 
        return marca; 
    }

    public String getTipo() { 
        return tipo; 
    }

    public LocalTime getHoraEntrada() { 
        return horaEntrada; 
    }

    @Override
    public String toString() {
        return "Placa: " + placa + " | Modelo: " + modelo + " | Marca: " + marca + " | Tipo: " + tipo + " | hora entrada:" + horaEntrada;
    }

}
