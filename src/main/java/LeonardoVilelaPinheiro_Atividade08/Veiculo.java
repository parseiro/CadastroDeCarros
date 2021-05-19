package LeonardoVilelaPinheiro_Atividade08;

import lombok.NonNull;

import java.util.Objects;

public abstract class Veiculo {
    @NonNull private String placa;
    @NonNull private String marca;
    @NonNull private String modelo;
    @NonNull private String cor;
    private int qtdRodas;
    private float velocMax; // velocidade em km/h
    @NonNull private Motor motor;

    public String getPlaca() {
        return placa;
    }

    public final void setPlaca(String placa) {

        if (placa == null || placa.isBlank()) {
            throw new IllegalArgumentException();
        }
        else placa = placa.strip();

        this.placa = placa.toUpperCase();
    }

    public String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException();
        }
        else marca = marca.strip();

        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public final void setModelo(String modelo) {
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException();
        }
        else modelo = modelo.strip();

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

    public String getCor() { return cor; }

    public final void setCor(String cor) {
        if (cor == null || cor.isBlank()) {
            throw new IllegalArgumentException();
        }
        else cor = cor.strip();

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
//        this.velocMax = 0; // desnecessário
        this.cor = " ";
//        this.qtdRodas = 0; // desnecessário
        this.motor = new Motor();
    }

    Veiculo(String placa, String marca, String modelo, String cor, int qtdRodas, float velocMax, Motor motor) {
        super();

        this.setPlaca(placa);
        this.setMarca(marca);
        this.setModelo(modelo);
        this.setCor(cor);
        this.setQtdRodas(qtdRodas);
        try {
            this.setVelocMax(velocMax);
        } catch (VelocException e) {

        }
        this.setMotor(motor);
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
