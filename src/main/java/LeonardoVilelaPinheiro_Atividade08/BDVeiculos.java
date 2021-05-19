package LeonardoVilelaPinheiro_Atividade08;

import java.util.*;

public class BDVeiculos {
    public static boolean TEST_MODE = true;

    private static BDVeiculos instance;

    private final List<Carga> BDCarg = new ArrayList<>();
    private final List<Passeio> BDPas = new ArrayList<>();

    static public BDVeiculos getBDVeiculos() {
        if (instance == null) {
            instance = new BDVeiculos();

            if (TEST_MODE) {
                instance.BDPas.add(new Passeio("ABC-0A12", "Toyota", "Etios", "prata", 4, 100, new Motor(8, 140), 5));
                instance.BDPas.add(new Passeio("BLABLABLA", "Volkswagen", "Gol", "azul", 4, 100, new Motor(12, 180), 5));

                instance.BDCarg.add(new Carga("CARG-PESAD", "Volvo", "Caminhão LX", "preto", 22, 100, new Motor(100, 2500), 500, 4000));
                instance.BDCarg.add(new Carga("PESO-PESADO", "Volkswagen", "Carreta X", "branco", 36, 100, new Motor(112, 4700), 600, 7000));
            }
        }
        return instance;
    }

    private BDVeiculos() {

    }

    static public List<Passeio> getBDPasseio() {
        return getBDVeiculos().BDPas;
    }

    static public List<Carga> getBDCarga() {
        return getBDVeiculos().BDCarg;
    }

    public void cadastrarPasseio() throws VeicExistException, MaxVeiculosExceptions {
/*        if (this.passeioList.size() == 5) {
            System.out.println("Já atingimos o limite de 5 veículos de passeio");
            throw new MaxVeiculosExceptions();
        }*/

        System.out.println("Adicionando um veículo Passeio");

        final Passeio novoPasseio = new Passeio();

        cadastrarVeiculo(novoPasseio);

        novoPasseio.setQtdePassageiros(Leitura.entDadosInt("Número máximo de passageiros: "));
        this.BDPas.add(novoPasseio);
    }

    public void cadastrarCarga() throws VeicExistException, MaxVeiculosExceptions {
/*        if (this.cargaList.size() == 5) {
            System.out.println("Já atingimos o limite de 5 veículos de carga");
            throw new MaxVeiculosExceptions();
        }*/

        System.out.println("Adicionando um veículo Carga");

        final Carga novoCarga = new Carga();

        cadastrarVeiculo(novoCarga);

        novoCarga.setTara(Leitura.entDadosInt("Digite a tara: "));
        novoCarga.setCargaMax(Leitura.entDadosInt("Digite a carga máxima: "));
        this.BDCarg.add(novoCarga);
    }

    private void cadastrarVeiculo(final Veiculo novoVeiculo) throws VeicExistException {

        final String placa = Leitura.entDados("Digite a placa: ").toUpperCase();
        if (BDPas.stream().anyMatch(x -> x.getPlaca().compareToIgnoreCase(placa) == 0)
                || BDCarg.stream().anyMatch(x -> x.getPlaca().compareToIgnoreCase(placa) == 0)) {
            System.out.println("Já existe um veículo com esta placa");
            throw new VeicExistException();
        }

        novoVeiculo.setPlaca(placa);

        novoVeiculo.setMarca(Leitura.entDados("Digite a marca: "));

        novoVeiculo.setModelo(Leitura.entDados("Digite o modelo: "));

        novoVeiculo.setCor(Leitura.entDados("Digite a cor: "));

        novoVeiculo.setQtdRodas(Leitura.entDadosInt("Digite o número de rodas: "));

        try {
            novoVeiculo.setVelocMax(Leitura.entDadosFloat("Digite a velocidade máxima (km/h): "));
        } catch (VelocException e) {
            System.out.format("A velocidade máxima está fora dos limites brasileiros. Assumindo o valor padrão de %.2f km/h%n", novoVeiculo.getVelocMax());
        }

        novoVeiculo.setPistoes(Leitura.entDadosInt("Digite o número de pistões: "));

        novoVeiculo.setPotencia(Leitura.entDadosInt("Digite a potência do motor (CV): "));

//        System.out.println("Resumo do veículo: " + novoVeiculo);
    }

    private static <T extends Veiculo> void questionaPlacaEExcluiVeiculos(final List<T> veiculos) {
        var veiculo = questionaPlacaEPegaVeiculo(veiculos);
        if (veiculo.isPresent()) {
            veiculos.remove(veiculo.get());
            System.out.println("Exclui o veículo de placa " + veiculo.get().getPlaca());
        }
    }

    public void questionaPlacaEExcluiPasseio() {
        questionaPlacaEExcluiVeiculos(BDPas);
    }

    public void questionaPlacaEExcluiCarga() {
        questionaPlacaEExcluiVeiculos(BDCarg);
    }

    private static <T extends Veiculo> void questionaPlacaEFiltraVeiculos(final List<T> veiculos) {
        var veiculo = questionaPlacaEPegaVeiculo(veiculos);
        veiculo.ifPresent(System.out::println);
    }

    public void questionaPlacaEFiltraPasseio() {
        questionaPlacaEExcluiVeiculos(this.BDPas);
    }

    public void questionaPlacaEFiltraCarga() {
        questionaPlacaEExcluiVeiculos(this.BDCarg);
    }

    private static <T extends Veiculo> Optional<T> questionaPlacaEPegaVeiculo(List<T> veiculos) {
        final String placa = Leitura.entDados("Qual é a placa desejada?").toUpperCase();
        var veiculoPorPlaca = veiculos.stream()
                .filter(x -> x.getPlaca().compareToIgnoreCase(placa) == 0)
                .findAny();
        if (veiculoPorPlaca.isEmpty()) {
            System.out.println("Nenhum veículo deste tipo encontrado com a placa \"" + placa.toUpperCase() + "\"");
        }
        return veiculoPorPlaca;
    }
}
