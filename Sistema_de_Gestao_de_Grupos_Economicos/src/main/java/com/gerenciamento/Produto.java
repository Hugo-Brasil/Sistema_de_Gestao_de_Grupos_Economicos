package com.gerenciamento;

public class Produto {

    private String tipo;
    private String nome;
    private float preco;

    


    
    public Produto(String tipo, String nome, float preco) {
        this.tipo = tipo;
        this.nome = nome;
        this.preco = preco;
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    public void exibirDadosDoProduto() {
        System.out.println("-------------------------------");
        System.out.println("DADOS DO PRODUTO");
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Preço: " + this.preco);
        System.out.println("-------------------------------");

    }
    

}
