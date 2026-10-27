package com.projeto.prf.view;

import com.projeto.prf.model.Acidente;
import com.projeto.prf.service.AcidenteService;
import com.projeto.prf.service.PessoaService;
import com.projeto.prf.service.VeiculoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class Menu implements CommandLineRunner {

    private final AcidenteService acidenteService;
    private final PessoaService pessoaService;
    private final VeiculoService veiculoService;

    private final Scanner scanner = new Scanner(System.in);

    public Menu(
            AcidenteService acidenteService,
            PessoaService pessoaService,
            VeiculoService veiculoService) {

        this.acidenteService = acidenteService;
        this.pessoaService = pessoaService;
        this.veiculoService = veiculoService;
    }

    @Override
    public void run(String... args) {

        int opcao = -1;

        while (opcao != 0) {

            exibirMenu();

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {

                    case 1:
                        estatisticasGerais();
                        break;

                    case 2:
                        buscarPorId();
                        break;

                    case 3:
                        buscarPorUf();
                        break;

                    case 4:
                        buscarPorMunicipio();
                        break;

                    case 5:
                        buscarPorPeriodo();
                        break;

                    case 6:
                        System.out.println("\nFuncionalidade será implementada.");
                        break;

                    case 7:
                        System.out.println("\nFuncionalidade será implementada.");
                        break;

                    case 8:
                        System.out.println("\nFuncionalidade será implementada.");
                        break;

                    case 0:
                        System.out.println("\nEncerrando o sistema...");
                        break;

                    default:
                        System.out.println("\nOpção inválida.");
                }

            } catch (NumberFormatException e) {
                System.out.println("\nDigite apenas números.");
            }
        }
    }

    private void exibirMenu() {

        System.out.println("\n======================================");
        System.out.println("       SISTEMA DE ACIDENTES PRF");
        System.out.println("======================================");

        System.out.println("1 - Estatísticas gerais");
        System.out.println("2 - Buscar acidente por ID");
        System.out.println("3 - Consultar acidentes por UF");
        System.out.println("4 - Consultar acidentes por município");
        System.out.println("5 - Consultar acidentes por período");
        System.out.println("6 - Principais causas de acidentes");
        System.out.println("7 - Tipos de acidentes mais frequentes");
        System.out.println("8 - Detalhes completos de um acidente");

        System.out.println("0 - Sair");

        System.out.println("======================================");
        System.out.print("Escolha uma opção: ");
    }

    // OPÇÃO 1
    private void estatisticasGerais() {

        System.out.println("\n===== ESTATÍSTICAS GERAIS =====");

        System.out.println(
                "Total de acidentes: "
                        + acidenteService.contarAcidentes()
        );

        System.out.println(
                "Total de veículos: "
                        + veiculoService.contarVeiculos()
        );

        System.out.println(
                "Total de pessoas: "
                        + pessoaService.contarPessoas()
        );
    }

    // OPÇÃO 2
    private void buscarPorId() {

        System.out.print("\nDigite o ID do acidente: ");

        try {

            Integer id = Integer.parseInt(scanner.nextLine());

            Optional<Acidente> acidente =
                    acidenteService.buscarPorId(id);

            if (acidente.isPresent()) {

                mostrarAcidente(acidente.get());

            } else {

                System.out.println("Acidente não encontrado.");

            }

        } catch (NumberFormatException e) {

            System.out.println("ID inválido.");

        }
    }

    // OPÇÃO 3
    private void buscarPorUf() {

        System.out.print("\nDigite a UF (ex: PB): ");

        String uf = scanner.nextLine();

        List<Acidente> acidentes =
                acidenteService.buscarPorUf(uf);

        mostrarLista(acidentes);
    }

    // OPÇÃO 4
    private void buscarPorMunicipio() {

        System.out.print("\nDigite o município: ");

        String municipio = scanner.nextLine();

        List<Acidente> acidentes =
                acidenteService.buscarPorMunicipio(municipio);

        mostrarLista(acidentes);
    }

    // OPÇÃO 5
    private void buscarPorPeriodo() {

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {

            System.out.print("\nData inicial (dd/MM/yyyy): ");
            LocalDate inicio =
                    LocalDate.parse(scanner.nextLine(), formato);

            System.out.print("Data final (dd/MM/yyyy): ");
            LocalDate fim =
                    LocalDate.parse(scanner.nextLine(), formato);

            List<Acidente> acidentes =
                    acidenteService.buscarPorPeriodo(inicio, fim);

            mostrarLista(acidentes);

        } catch (Exception e) {

            System.out.println(
                    "Data inválida. Utilize dd/MM/yyyy."
            );
        }
    }

    // Mostra uma lista de acidentes
    private void mostrarLista(List<Acidente> acidentes) {

        if (acidentes.isEmpty()) {

            System.out.println("\nNenhum acidente encontrado.");
            return;
        }

        System.out.println(
                "\nForam encontrados "
                        + acidentes.size()
                        + " acidentes."
        );

        System.out.println("--------------------------------------");

        for (Acidente acidente : acidentes) {

            System.out.println(
                    "ID: " + acidente.getIdAcidente()
                            + " | Data: " + acidente.getDataAcidente()
                            + " | UF: " + acidente.getUf()
                            + " | Município: " + acidente.getMunicipio()
            );
        }
    }

    // Mostra os dados principais de um acidente
    private void mostrarAcidente(Acidente acidente) {

        System.out.println("\n===== ACIDENTE =====");

        System.out.println("ID: " + acidente.getIdAcidente());
        System.out.println("Data: " + acidente.getDataAcidente());
        System.out.println("Horário: " + acidente.getHorario());
        System.out.println("Dia da semana: " + acidente.getDiaSemana());

        System.out.println(
                "Local: "
                        + acidente.getMunicipio()
                        + " - "
                        + acidente.getUf()
        );

        System.out.println("BR: " + acidente.getBr());
        System.out.println("KM: " + acidente.getKm());

        System.out.println(
                "Classificação: "
                        + acidente.getClassificacaoAcidente()
        );

        System.out.println(
                "Condição meteorológica: "
                        + acidente.getCondicaoMeteorologica()
        );

        System.out.println(
                "Tipo de pista: "
                        + acidente.getTipoPista()
        );

        System.out.println(
                "Traçado da via: "
                        + acidente.getTracadoVia()
        );
    }
}