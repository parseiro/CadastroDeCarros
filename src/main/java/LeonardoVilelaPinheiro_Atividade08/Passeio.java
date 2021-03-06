package LeonardoVilelaPinheiro_Atividade08;

public final class Passeio
        extends Veiculo
        implements Calc {
    int qtdePassageiros;

    @Override
    protected float setVelocidadeMaxPadrao() {
        return 100;
    }

    @Override
    public float calcVel(float velocMax) {
        return this.getVelocMax() * 1000; // converte km/h para m/h
    }

    public Passeio() {
//        this.qtdePassageiros = 0; // desnecessário
    }

    public Passeio(int qtdePassageiros) {
        this.qtdePassageiros = qtdePassageiros;
    }

    public Passeio(String placa, String marca, String modelo, String cor, int qtdRodas, float velocMax, Motor motor, int qtdePassageiros) {
        super(placa, marca, modelo, cor, qtdRodas, velocMax, motor);
        this.qtdePassageiros = qtdePassageiros;
    }

    public int getQtdePassageiros() {
        return qtdePassageiros;
    }

    public final void setQtdePassageiros(int qtdePassageiros) {
        this.qtdePassageiros = qtdePassageiros;
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Passeio{"
                + "qtdePassageiros=" + qtdePassageiros
                + ", velocMax calculada (m/h)=" + calcVel(getVelocMax())
                + ", calcular=" + this.calcular()
                + "}";
    }

    @Override
    public int calcular() {
        return this.getPlaca().length()
                + this.getMarca().length()
                + this.getModelo().length()
                + this.getCor().length()
                ;
    }
}
