package com.gerenciamento;

public class Servico {

     //Cliente cliente = new Cliente(null);

     private String tipo;
     private float preco;

     public Servico(String tipo, float preco) {
        this.tipo = tipo;
        this.preco = preco;
     }
     
     public String getTipo() {
         return tipo;
     }
     public void setTipo(String tipo) {
         this.tipo = tipo;
     }
     public float getPreco() {
         return preco;
     }
     public void setPreco(float preco) {
         this.preco = preco;
     }

     public void exibirDadosDoServico() {
        System.out.println("-------------------------------");
        System.out.println("DADOS DO SERVIÇO");
        System.out.println("Tipo: " + this.tipo);
        System.out.println("Preço: " + this.preco);
        System.out.println("-------------------------------");
     }
     
    
        

}
