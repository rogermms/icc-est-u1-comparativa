package modelos;

public class Resultado {
    private String metodo;
    private int sample;
    private long duracionNs;

    public Resultado(String metodo, int sample, long duracionNs) {
        this.metodo = metodo;
        this.sample = sample;
        this.duracionNs = duracionNs;
    }

    public String getMetodo() {
        return metodo;
    }

    public int getSample() {
        return sample;
    }

    public long getDuracionNs() {
        return duracionNs;
    }

    public double getDuracionMs() {
        return duracionNs / 1_000_000.0;
    }

    @Override
    public String toString() {
        return metodo + " | sample: " + sample + " | tiempo: " + getDuracionMs() + " ms";
    }
}