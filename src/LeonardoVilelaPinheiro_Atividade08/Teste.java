package LeonardoVilelaPinheiro_Atividade08;

import java.io.IOException;
import java.util.List;

public class Teste {

    public static BDVeiculos bancoDeVeiculos = new BDVeiculos();

    private static String bemvindo =
            "Sistema de Gestão de Veículos - Menu Inicial%n" +
                    "1. Cadastrar Veículo de Passeio%n" +
                    "2. Cadastrar Veículo de Carga%n" +
                    "3. Imprimir Todos os Veículos de Passeio%n" +
                    "4. Imprimir Todos os Veículos de Carga%n" +
                    "5. Imprimir Veículo de Passeio pela Placa%n" +
                    "6. Imprimir Veículo de Carga pela Placa%n" +
                    "7. Excluir Veículo de Passeio pela Placa%n" +
                    "8. Excluir Veículo de Carga pela Placa%n" +
                    "9. Sair do Sistema%n";

    public static void main(String[] args)
            throws IOException, InterruptedException {

        final List<Passeio> veiculosPasseio = bancoDeVeiculos.getBDPas();
        final List<Carga> veiculosCarga = bancoDeVeiculos.getBDCarg();

        String command;

        LupeInfinito:
        while (true) {
            System.out.format(bemvindo);
            command = Leitura.entDados();

            switch (command) {
                case "1":
                    Lupe:
                    while (true) {
                        try {
                            bancoDeVeiculos.cadastrarPasseio();
                        } catch (VeicExistException e) {

                        } catch (MaxVeiculosExceptions maxVeiculosExceptions) {
                            break Lupe;
                        }

                        String lido = Leitura.entDados("Deseja cadastrar mais um veículo de passeio?");
                        if (lido.equalsIgnoreCase("não")) break Lupe;
                    }
                    break;
                case "2":
                    Lupe:
                    while (true) {
                        try {
                            bancoDeVeiculos.cadastrarCarga();
                        } catch (VeicExistException e) {

                        } catch (MaxVeiculosExceptions maxVeiculosExceptions) {
                            break Lupe;
                        }

                        String lido = Leitura.entDados("Deseja cadastrar mais um veículo de carga?");
                        if (lido.equalsIgnoreCase("não")) break Lupe;
                    }
                    break;
                case "3":
                    if (veiculosPasseio.isEmpty()) {
                        System.out.println("Nenhum veículo de passeio cadastrado!");
                    } else {
                        System.out.println("Veja a seguir todos os veículos de passeio");
                        veiculosPasseio.forEach(System.out::println);
                    }
                    break;
                case "4":
                    if (veiculosCarga.isEmpty()) {
                        System.out.println("Nenhum veículo de carga cadastrado!");
                    } else {
                        System.out.println("Veja a seguir todos os veículos de carga");
                        veiculosCarga.forEach(System.out::println);
                    }
                    break;
                case "5":
                    if (veiculosPasseio.isEmpty()) {
                        System.out.println("Nenhum veículo de passeio cadastrado!");
                    } else {
                        bancoDeVeiculos.questionaPlacaEFiltraPasseio();
                    }
                    break;
                case "6":
                    if (veiculosCarga.isEmpty()) {
                        System.out.println("Nenhum veículo de carga cadastrado!");
                    } else {
                        bancoDeVeiculos.questionaPlacaEFiltraCarga();
                    }
                    break;
                case "7":
                    if (veiculosPasseio.isEmpty()) {
                        System.out.println("Nenhum veículo de passeio cadastrado!");
                    } else {
                        bancoDeVeiculos.questionaPlacaEExcluiPasseio();
                    }
                    break;
                case "8":
                    if (veiculosCarga.isEmpty()) {
                        System.out.println("Nenhum veículo de carga cadastrado!");
                    } else {
                        bancoDeVeiculos.questionaPlacaEExcluiCarga();
                    }
                    break;
                case "9":
                    System.out.println("Obrigado por usar nosso sistema!");
                    break LupeInfinito;
                default:
                    System.err.println("Comando inválido");
                    break;
            }
            System.out.println("Pressione Enter para continuar...");
            Leitura.entDados();
        }
    }
}
