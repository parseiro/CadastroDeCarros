package LeonardoVilelaPinheiro_Atividade08;

public final class Carga
        extends Veiculo
        implements Calc {
    int tara;
    int cargaMax;

    public Carga() {
        this.tara = 0;
        this.cargaMax = 0;
    }

    public Carga(int tara, int cargaMax) {
        this.tara = tara;
        this.cargaMax = cargaMax;
    }

    public Carga(String placa, String marca, String modelo, String cor, int qtdRodas, float velocMax, Motor motor, int tara, int cargaMax) {
        super(placa, marca, modelo, cor, qtdRodas, velocMax, motor);
        this.tara = tara;
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    protected float setVelocidadeMaxPadrao() {
        return 90;
    }

    @Override
    public float calcVel(float velocMax) {
        return this.getVelocMax() * 1000 * 100; // converte km/h para cm/h
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Carga{"
                + "tara=" + tara
                + ", cargaMax=" + cargaMax
                + ", velocMax calculada (cm/h)=" + calcVel(getVelocMax())
                + ", calcular=" + this.calcular()
                + "}";
    }

    @Override
    public int calcular() {
        int total = (int) (this.getQtdRodas() + this.getVelocMax()
                        + this.tara + this.cargaMax);
        return total;
    }
}
