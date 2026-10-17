package com.gerenciamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Estoque {

     ArrayList<Produto> produtos = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


     public void adicionarProduto() {

        Produto p = new Produto(null, null, 0);
        
        System.out.println();
        System.out.println("------------------------");
        System.out.println("Digite o tipo de produto:");
        p.setTipo(sc.nextLine());
        System.out.println("------------------------");
        System.out.println("Digite o nome do produto:");
        p.setNome(sc.nextLine());
        System.out.println("------------------------");
        System.out.println("Digite o preço do produto:");
        p.setPreco(sc.nextFloat());
        sc.nextLine();//limpa o buffer, estava dando erro do \n :()
        


        if (p.getTipo().isBlank() == false && p.getNome().isBlank() == false && p.getPreco() > 0) {

            produtos.add(p);
            
        } else {

            System.out.println("Erro de Preenchimento, coloque os dados corretamente.");

        }

        

    }


    public void removerProduto(Produto p){


        produtos.remove(p);




    }


    public void listarProdutosEstoque(){

        for (int index = 0; index < produtos.size(); index++) {

           
            System.out.println("Nome do produto: "+produtos.get(index).getNome());
            System.out.println("Tipo do produto: "+produtos.get(index).getTipo());
            System.out.println("preço do produto: "+produtos.get(index).getPreco());


            
        }





    }















}
