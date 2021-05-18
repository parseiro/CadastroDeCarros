package LeonardoVilelaPinheiro_Atividade08;

import java.util.Objects;

public abstract class Veiculo {
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int qtdRodas;
    private float velocMax; // velocidade em km/h
    private Motor motor;

    public String getPlaca() {
        return placa;
    }

    public final void setPlaca(String placa) {
        this.placa = placa.toUpperCase();
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getVelocMax() {
        return velocMax;
    }

    public final void setVelocMax(float velocMax) throws VelocException {

        // a velocidade tem que estar entre 80 e 110 (inclusive)
        if (80 <= velocMax && velocMax <= 110) {
            this.velocMax = velocMax;
        } else {
            this.velocMax = setVelocidadeMaxPadrao();

            throw new VelocException();
        }
    }

    protected abstract float setVelocidadeMaxPadrao();

    abstract float calcVel(float velocMax);

    public String getCor() {
        return cor;
    }

    public final void setCor(String cor) {
        this.cor = cor;
    }

    public int getQtdRodas() {
        return qtdRodas;
    }

    public final void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public Motor getMotor() {
        return motor;
    }

    public final void setMotor(Motor motor) {
        this.motor = motor;
    }

    Veiculo() {
        this.placa = " ";
        this.marca = " ";
        this.modelo = " ";
        this.velocMax = 0;
        this.cor = " ";
        this.qtdRodas = 0;
        this.motor = new Motor();
    }

    Veiculo(String placa, String marca, String modelo, String cor, int qtdRodas, float velocMax, Motor motor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.qtdRodas = qtdRodas;
        this.velocMax = velocMax;
        this.motor = motor;
    }

    public void setPistoes(int pistoes) {
        if (this.motor != null) {
            this.motor.setQtdPist(pistoes);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return getQtdRodas() == veiculo.getQtdRodas() && Float.compare(veiculo.getVelocMax(), getVelocMax()) == 0 && Objects.equals(getPlaca(), veiculo.getPlaca()) && Objects.equals(getMarca(), veiculo.getMarca()) && Objects.equals(getModelo(), veiculo.getModelo()) && Objects.equals(getCor(), veiculo.getCor()) && Objects.equals(getMotor(), veiculo.getMotor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlaca(), getMarca(), getModelo(), getCor(), getQtdRodas(), getVelocMax(), getMotor());
    }

    public int getPistoes() {
        return this.motor != null ? this.motor.getQtdPist() : 0;
    }

    public void setPotencia(int potencia) {
        if (this.motor != null) {
            this.motor.setPotencia(potencia);
        }
    }

    public int getPotencia() {
        return this.motor != null ? this.motor.getPotencia() : 0;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cor='" + cor + '\'' +
                ", qtdRodas=" + qtdRodas +
                ", motor=" + motor +
                '}';
    }
}
