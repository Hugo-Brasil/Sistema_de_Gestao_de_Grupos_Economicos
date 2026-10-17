package com.gerenciamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Venda {

    ArrayList<Produto> produtos = new ArrayList<>();
    
    Cliente cliente = new Cliente(null);

    Scanner sc = new Scanner(System.in);

   

    public void listarProdutosVendidos() {
        System.out.println("Cliente: " + cliente.getNome());
        for (int index = 0; index < produtos.size(); index++) {
            produtos.get(index).exibirDadosDoProduto();
        }
        System.out.println("Total desta venda: R$ " + calcularTotalVenda());

    }

    public void adicionaProduto(Produto v){

        produtos.add(v);




    }

    public void adicionarCliente(){

        Cliente c = new Cliente(null);

        System.out.println("Digite o nome do Cliente: ");
        c.setNome(sc.nextLine());


        cliente = c;





    }













    public float calcularTotalVenda() {
        float total = 0;

        for (int index = 0; index < produtos.size(); index++) {
            total = total + produtos.get(index).getPreco();
        }

        return total;
    }
}
