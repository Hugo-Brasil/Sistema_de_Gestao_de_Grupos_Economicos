package com.gerenciamento;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        int escolha;

        PrestacaoGrupoEconomico pGe1 = new PrestacaoGrupoEconomico();
        VendasGrupoEconomico vGe1 = new VendasGrupoEconomico();

        GrupoEconomico g = new GrupoEconomico("Computação do futuro");

        pGe1.prestacoesDoGrupoEconomico.add(g);
        vGe1.vendasDoGrupoEconomicos.add(g);

        Entidade e1 = new Entidade("Rafael", "Curitiba");
        Entidade e2 = new Entidade("Hugo", "Belem");

        
        





        g.adicionarEntidadeCodigo(e1); // para termos umas entidades já prontas
        g.adicionarEntidadeCodigo(e2);

        // Compartilha a mesma entrada com os métodos do grupo e das entidades.
        Scanner sc = g.sc;

        do {

            System.out.println("\n");
            System.out.println("\n");
            System.out.println("\n");
            // so reiniciando a variavel escolha
            escolha = 1234;

            System.out.println("=== Sistema de Gestão de Grupos Econômicos ===");

            separarBlocos();
            System.out.println("--- MENU ---");

            separarBlocos();
            System.out.println("--- Cadastros ---");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Cadastrar serviço");

            separarBlocos();
            System.out.println("--- Operações ---");
            System.out.println("3 - Vender Produto");
            System.out.println("4 - Prestar serviço");

            separarBlocos();
            System.out.println("--- Consultas ---");

            System.out.println("5 - Listar produtos que são vendidos pela entidade");
            System.out.println("6 - Listar produtos que são vendidos pelo grupo econômico");
            System.out.println("7 - Listar serviços que são prestados pela entidade");
            System.out.println("8 - Listar serviços que são prestados pelo Grupo");
            System.out.println("9 - Listar entidades");
            System.out.println("10 - Pesquisar por tipo do produto em estoque nas entidades");
            System.out.println("12 - Produto de maior valor em estoque na entidade");

            separarBlocos();
            System.out.println("--- Relatórios ---");
            System.out.println("13 - Relatório total arrecadado entidade");
            System.out.println("14 - Relatório total arrecadado grupo");
            System.out.println("15 - Média de arrecadação por entidade");
            System.out.println("16 - Ranking de entidades em arrecadações");
            System.out.println("20 - Exportar relatório de entidades para CSV");
            System.out.println("21 - Relatorio de quantidade de vendas realizadas por entidade.");

            separarBlocos();
            System.out.println("--- Editar ---");

            System.out.println("17 - Nome da entidade ");
            System.out.println("18 - Cidade de entidade");

            separarBlocos();
            System.out.println("--- Remover ---");

            System.out.println("19 - Entidade");

            separarBlocos();
            System.out.println("--- Sair do Sistema ---");
            System.out.println("0 - sair");

            separarBlocos();
            System.out.println("Escolha:");
            

            escolha = sc.nextInt();
            sc.nextLine();

            if (escolha == 1) { // se digitar 11, vc adiciona um produto
                g.adicionarProdutoEntidade();

            } else if (escolha == 2) {
                g.adicionarPrestacaoServico();

            } else if (escolha == 3) {
                g.venderProdutoEntidade();

            } else if (escolha == 4) {
                g.prestarServicoEntidade();

            } else if (escolha == 5) {
                g.listarVendasDaEntidade();

            } else if (escolha == 6) {
                vGe1.listarVendasDoGrupoEconomico();

            } else if (escolha == 7) {
                g.listarPrestacoesDaEntidade();

            } else if (escolha == 8) {
                pGe1.listarPrestacoesDoGrupoEconomico();

            } else if (escolha == 9) {
                g.listarEntidadesDoGrupoEconomico();

            } else if (escolha == 10) {
                g.pesquisarProdutoTipo();
            } else if (escolha == 11) {
                // FALTA
            } else if (escolha == 12) {
                g.maiorValorEstoque();
            } else if (escolha == 13) {
                g.relatorioTotalArrecadadoEntidade();
            } else if (escolha == 14) {
                g.relatorioTotalArrecadadoGrupo();
            } else if (escolha == 15) {
                g.relatorioMediaArrecadacao();
            } else if (escolha == 16) {
                g.rankingEntidadesArrecadacao();
            } else if (escolha == 17) {
                g.editarNomeEntidade();
            } else if (escolha == 18) {
                g.editarcidadeEntidade();
            } else if (escolha == 19) {
                g.removerEntidade();
            }else if (escolha == 20) {
                g.exportarCSV();
            }else if (escolha == 21) {
                g.QuantidadeVendasEntidade();
            }

            if (escolha != 0) {
                System.out.println("Pressione enter para continuar . . .");
                sc.nextLine();
            }

        } while (escolha != 0); // para fechar o programa tem que digitar 0 na escolha do terminal

    }

    // Serve apenas para melhorar a visualização das diferentes seções do menu; está
    // fora do
    // método main, porém dentro da classe main, pois o Java não permite um método
    // dentro de
    // outro.
    private static void separarBlocos() {
        System.out.println();
        System.out.println("------------------------------------------------------------");
        System.out.println();
    }

}
