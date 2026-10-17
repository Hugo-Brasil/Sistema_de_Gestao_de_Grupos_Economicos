package com.gerenciamento;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;


public class GrupoEconomico {

    ArrayList<Entidade> entidades = new ArrayList<>();

    private String marca;

    Scanner sc = new Scanner(System.in);

    public GrupoEconomico(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public ArrayList<Entidade> getEntidades(){ //para funcionar o teste basico do Junit



        return entidades;

    }

    public void adicionarProdutoEntidade() {

        int indexScanner = 123; // variavel para selecionar a entidade para entrar com o metodo de outra classe

        for (int index = 0; index < entidades.size(); index++) {
            System.out.println("-------------------------------");
            System.out.println("Nome da Entidade: " + entidades.get(index).getNomeDaEntidade());
            System.out.println("Cidade da Entidade: " + entidades.get(index).getCidade());
            System.out.println("Indice da entidade: " + index);
            System.out.println("-------------------------------");

        }

        System.out.println("Qual a entidade para adicionar o produto? Escreva o índice.");
        indexScanner = sc.nextInt();
        sc.nextLine();

        if (indexScanner < entidades.size() && indexScanner >= 0) {

            entidades.get(indexScanner).adicionarProdutoEstoque();
            ;

        } else {

            System.out.println("Índice inválido.");

        }

    }

    public void adicionarEntidadeCodigo(Entidade e) { // Nao é usado para ser usado no menu, só diretamente pelo codigo
                                                      // do main

        e.sc = sc;
        entidades.add(e);

    }

    public void listarVendasDaEntidade() {
        for (int index = 0; index < entidades.size(); index++) {
            entidades.get(index).listarProdutosVendidos();
        }

    }

    public void adicionarPrestacaoServico() {
        if (entidades.size() == 0) {
            System.out.println("Não há entidades cadastradas.");
        } else {
            for (int index = 0; index < entidades.size(); index++) {
                System.out.println("-------------------------------");
                System.out.println("Nome da Entidade: " + entidades.get(index).getNomeDaEntidade());
                System.out.println("Cidade da Entidade: " + entidades.get(index).getCidade());
                System.out.println("Indice da entidade: " + index);
                System.out.println("-------------------------------");
            }

            System.out.println("Qual a entidade para cadastrar o serviço? Escreva o índice.");
            int indexScanner = sc.nextInt();
            sc.nextLine();

            if (indexScanner < entidades.size() && indexScanner >= 0) {
                entidades.get(indexScanner).cadastrarServico();
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }

    public void prestarServicoEntidade() {
        if (entidades.size() == 0) {
            System.out.println("Não há entidades cadastradas.");
        } else {
            for (int index = 0; index < entidades.size(); index++) {
                System.out.println("-------------------------------");
                System.out.println("Nome da Entidade: " + entidades.get(index).getNomeDaEntidade());
                System.out.println("Cidade da Entidade: " + entidades.get(index).getCidade());
                System.out.println("Indice da entidade: " + index);
                System.out.println("-------------------------------");
            }

            System.out.println("Qual a entidade para realizar a prestação de serviço? Escreva o índice.");
            int indexScanner = sc.nextInt();
            sc.nextLine();

            if (indexScanner < entidades.size() && indexScanner >= 0) {
                entidades.get(indexScanner).realizarPrestacaoServico();
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }

    public float calcularTotalArrecadado() {
        float total = 0;

        for (int index = 0; index < entidades.size(); index++) {
            total = total + entidades.get(index).calcularTotalArrecadado();
        }

        return total;
    }

    public float calcularMediaArrecadacao() {
        float media = 0;

        if (entidades.size() > 0) {
            media = calcularTotalArrecadado() / entidades.size();
        }

        return media;
    }

    public void relatorioMediaArrecadacao() {
        if (entidades.size() == 0) {
            System.out.println("Não há entidades cadastradas.");
        } else {
            System.out.println("-----------MÉDIA DE ARRECADAÇÃO-----------");
            System.out.println("Marca do grupo: " + marca);
            System.out.println("Quantidade de entidades: " + entidades.size());
            System.out.println("Total arrecadado pelo grupo: R$ " + calcularTotalArrecadado());
            System.out.println("Média de arrecadação por entidade: R$ " + calcularMediaArrecadacao());
            System.out.println("------------------------------------------");
        }
    }

    public void rankingEntidadesArrecadacao() {
        if (entidades.size() == 0) {
            System.out.println("Não há entidades cadastradas.");
        } else {
            // A lista temporária permite montar o ranking sem mudar os índices
            // das entidades usados nas outras opções do menu.
            ArrayList<Entidade> classificacao = new ArrayList<>();

            for (int index = 0; index < entidades.size(); index++) {
                classificacao.add(entidades.get(index));
            }

            int quantidadeEntidades = classificacao.size();
            int posicao = 1;
            float totalAnterior = 0;

            System.out.println("-----------RANKING DE ARRECADAÇÃO-----------");
            System.out.println("Marca do grupo: " + marca);
            System.out.println("Entidades com o mesmo total compartilham a posição.");

            for (int index = 0; index < quantidadeEntidades; index++) {
                Entidade maior = classificacao.get(0);

                for (int i = 1; i < classificacao.size(); i++) {
                    if (classificacao.get(i).calcularTotalArrecadado() > maior.calcularTotalArrecadado()) {
                        maior = classificacao.get(i);
                    }
                }

                float total = maior.calcularTotalArrecadado();

                // Em caso de empate, mantém a mesma posição: 1, 1, 3.
                if (index > 0) {
                    if (total < totalAnterior) {
                        posicao = index + 1;
                    }
                }

                System.out.println("-------------------------------");
                System.out.println("Posição: " + posicao);
                System.out.println("Nome da Entidade: " + maior.getNomeDaEntidade());
                System.out.println("Cidade da Entidade: " + maior.getCidade());
                System.out.println("Total arrecadado: R$ " + total);

                totalAnterior = total;
                classificacao.remove(maior);
            }

            System.out.println("--------------------------------------------");
        }
    }

    public void relatorioTotalArrecadadoEntidade() {
        if (entidades.size() == 0) {
            System.out.println("Não há entidades cadastradas.");
        } else {
            for (int index = 0; index < entidades.size(); index++) {
                System.out.println("-------------------------------");
                System.out.println("Nome da Entidade: " + entidades.get(index).getNomeDaEntidade());
                System.out.println("Cidade da Entidade: " + entidades.get(index).getCidade());
                System.out.println("Indice da entidade: " + index);
                System.out.println("-------------------------------");
            }

            System.out.println("Qual a entidade para consultar a arrecadação? Escreva o índice.");
            int indexScanner = sc.nextInt();
            sc.nextLine();

            if (indexScanner < entidades.size() && indexScanner >= 0) {
                System.out.println("-----------ARRECADAÇÃO DA ENTIDADE-----------");
                System.out.println("Nome da Entidade: " + entidades.get(indexScanner).getNomeDaEntidade());
                System.out.println("Total de vendas: R$ " + entidades.get(indexScanner).calcularTotalVendas());
                System.out.println("Total de serviços: R$ " + entidades.get(indexScanner).calcularTotalServicos());
                System.out.println("Total arrecadado: R$ " + entidades.get(indexScanner).calcularTotalArrecadado());
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("Índice inválido.");
            }
        }
    }

    public void relatorioTotalArrecadadoGrupo() {
        if (entidades.size() == 0) {
            System.out.println("Não há entidades cadastradas.");
        } else {
            System.out.println("-----------ARRECADAÇÃO DO GRUPO-----------");
            System.out.println("Marca do grupo: " + marca);

            for (int index = 0; index < entidades.size(); index++) {
                System.out.println("-------------------------------");
                System.out.println("Nome da Entidade: " + entidades.get(index).getNomeDaEntidade());
                System.out.println("Total de vendas: R$ " + entidades.get(index).calcularTotalVendas());
                System.out.println("Total de serviços: R$ " + entidades.get(index).calcularTotalServicos());
                System.out.println("Total arrecadado: R$ " + entidades.get(index).calcularTotalArrecadado());
                System.out.println("-------------------------------");
            }

            System.out.println("Total arrecadado pelo grupo: R$ " + calcularTotalArrecadado());
            System.out.println("------------------------------------------");
        }
    }

    public void listarPrestacoesDaEntidade() {
        for (int index = 0; index < entidades.size(); index++) {
            entidades.get(index).listarServicosPrestadosEntidade();
        }

    }

    public void listarEntidadesDoGrupoEconomico() {

        for (int index = 0; index < entidades.size(); index++) {
            System.out.println("-------------------------------");
            System.out.println("Nome da Entidade: " + entidades.get(index).getNomeDaEntidade());
            System.out.println("Cidade da Entidade: " + entidades.get(index).getCidade());
            System.out.println("-------------------------------");
        }

    }

    public void venderProdutoEntidade() {

        int indexScanner = 123; // variavel para selecionar a entidade para entrar com o metodo de outra classe

        for (int index = 0; index < entidades.size(); index++) {
            System.out.println("-------------------------------");
            System.out.println("Nome da Entidade: " + entidades.get(index).getNomeDaEntidade());
            System.out.println("Cidade da Entidade: " + entidades.get(index).getCidade());
            System.out.println("Indice da entidade: " + index);
            System.out.println("-------------------------------");

        }

        System.out.println("Qual a entidade para realizar a venda? Escreva o índice.");
        indexScanner = sc.nextInt();
        sc.nextLine();

        if (indexScanner < entidades.size() && indexScanner >= 0) {

            entidades.get(indexScanner).realizarVenda();
            ;

        } else {

            System.out.println("Índice inválido.");

        }

    }

    public void pesquisarProdutoTipo() {

        String tipoComparado;
        System.out.println("Por qual tipo voce que pesquisar?");
        tipoComparado = sc.nextLine();
        tipoComparado.strip();

        for (int index = 0; index < entidades.size(); index++) {

            for (int i = 0; i < entidades.get(index).e.produtos.size(); i++) {

                if (entidades.get(index).e.produtos.get(i).getTipo().equalsIgnoreCase(tipoComparado)) {

                    System.out.println("-----------ESTOQUE-----------\n");
                    System.out.println("Nome do produto: " + entidades.get(index).e.produtos.get(i).getNome());
                    System.out.println("Tipo do produto: " + entidades.get(index).e.produtos.get(i).getTipo());
                    System.out.println("Preço do produto: " + entidades.get(index).e.produtos.get(i).getPreco());
                    System.out.println("Cidade da Entidade: " + entidades.get(index).getCidade());
                    System.out.println("Dono da Entidade: " + entidades.get(index).getNomeDaEntidade());
                    System.out.println("-----------------------------\n");
                }

            }

        }

    }

    public void maiorValorEstoque() {

        int indexScanner = 123; // variavel para selecionar a entidade para entrar com o metodo de outra classe

        for (int index = 0; index < entidades.size(); index++) {
            System.out.println("-------------------------------");
            System.out.println("Nome da Entidade: " + entidades.get(index).getNomeDaEntidade());
            System.out.println("Cidade da Entidade: " + entidades.get(index).getCidade());
            System.out.println("Indice da entidade: " + index);
            System.out.println("-------------------------------");

        }

        System.out.println("Qual a entidade para ver o produto de maior valor? Escreva o índice.");
        indexScanner = sc.nextInt();
        sc.nextLine();

        if (indexScanner < entidades.size() && indexScanner >= 0) {

            entidades.get(indexScanner).produtoMaiorValorEstoque().exibirDadosDoProduto();///// metodo para o maior do
                                                                                          ///// estoque

        } else {

            System.out.println("Índice inválido.");

        }

    }

    public void editarNomeEntidade() {

        int indexScanner = 123; // variavel para selecionar a entidade para entrar com o metodo de outra classe

        for (int index = 0; index < entidades.size(); index++) {
            System.out.println("-------------------------------");
            System.out.println("Nome da Entidade: " + entidades.get(index).getNomeDaEntidade());
            System.out.println("Cidade da Entidade: " + entidades.get(index).getCidade());
            System.out.println("Indice da entidade: " + index);
            System.out.println("-------------------------------");

        }

        System.out.println("Qual a entidade para mudar o nome? Escreva o índice.");
        indexScanner = sc.nextInt();
        sc.nextLine();

        if (indexScanner < entidades.size() && indexScanner >= 0) {

            entidades.get(indexScanner).mudarNome();
            ;///// metodo para mudar o nome
             ///// estoque

        } else {

            System.out.println("Índice inválido.");

        }

    }

    public void editarcidadeEntidade() {

        int indexScanner = 123; // variavel para selecionar a entidade para entrar com o metodo de outra classe

        for (int index = 0; index < entidades.size(); index++) {
            System.out.println("-------------------------------");
            System.out.println("Nome da Entidade: " + entidades.get(index).getNomeDaEntidade());
            System.out.println("Cidade da Entidade: " + entidades.get(index).getCidade());
            System.out.println("Indice da entidade: " + index);
            System.out.println("-------------------------------");

        }

        System.out.println("Qual a entidade para mudar a cidade? Escreva o índice.");
        indexScanner = sc.nextInt();
        sc.nextLine();

        if (indexScanner < entidades.size() && indexScanner >= 0) {

            entidades.get(indexScanner).mudarCidade();
            ;///// metodo para mudar o nome
             ///// estoque

        } else {

            System.out.println("Índice inválido.");

        }

    }




    public void removerEntidade(){

        int indexScanner = 123; // variavel para selecionar a entidade para entrar com o metodo de outra classe

        for (int index = 0; index < entidades.size(); index++) {
            System.out.println("-------------------------------");
            System.out.println("Nome da Entidade: " + entidades.get(index).getNomeDaEntidade());
            System.out.println("Cidade da Entidade: " + entidades.get(index).getCidade());
            System.out.println("Indice da entidade: " + index);
            System.out.println("-------------------------------");

        }

        System.out.println("Qual a entidade remover? Escreva o índice.");
        indexScanner = sc.nextInt();
        sc.nextLine();

        if (indexScanner < entidades.size() && indexScanner >= 0) {

            entidades.remove(entidades.get(indexScanner));
            ///// metodo para mudar o nome
             ///// estoque

        } else {

            System.out.println("Índice inválido.");

        }







    }

    public void exportarCSV(){
        try {
            FileWriter papel = new FileWriter("entidade.cvs");

            papel.write("Nome | Entidade\n");

            for (int index = 0; index < entidades.size(); index++) {



                papel.write(entidades.get(index).getNomeDaEntidade()+" | "+entidades.get(index).getCidade()+"\n");

                
            }

            papel.close();
            System.out.println("Ocorreu tudo corretamente na exportação :)");

            
        } catch (Exception e) {
            System.out.println("Deu erro na exportação CSV . . .");
        }
        











    } 


public void QuantidadeVendasEntidade(){

     int indexScanner = 123; // variavel para selecionar a entidade para entrar com o metodo de outra classe

        for (int index = 0; index < entidades.size(); index++) {
            System.out.println("-------------------------------");
            System.out.println("Nome da Entidade: " + entidades.get(index).getNomeDaEntidade());
            System.out.println("Cidade da Entidade: " + entidades.get(index).getCidade());
            System.out.println("Indice da entidade: " + index);
            System.out.println("-------------------------------");

        }

        System.out.println("Qual a entidade para vereficar numero de vendas? Escreva o índice.");
        indexScanner = sc.nextInt();
        sc.nextLine();

        if (indexScanner < entidades.size() && indexScanner >= 0) {

            System.out.println("Numero de vendas: "+entidades.get(indexScanner).vendas.size()); 
            ;

        } else {

            System.out.println("Índice inválido.");

        }











}

   
















}
