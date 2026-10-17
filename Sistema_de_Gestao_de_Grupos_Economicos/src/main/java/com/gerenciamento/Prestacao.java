package com.gerenciamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Prestacao {

    // Guarda somente os serviços escolhidos para este atendimento.
    ArrayList<Servico> servicos = new ArrayList<>();

    Cliente cliente = new Cliente(null);
    Scanner sc = new Scanner(System.in);

    public void adicionarServicoPrestacao(ArrayList<Servico> servicosCadastrados) {
        if (servicosCadastrados.size() > 0) {
            for (int index = 0; index < servicosCadastrados.size(); index++) {
                System.out.println("-------------------------------");
                System.out.println("Índice do serviço: " + index);
                servicosCadastrados.get(index).exibirDadosDoServico();
            }

            System.out.println("Qual serviço foi prestado? Escreva o índice.");
            int indexScanner = sc.nextInt();
            sc.nextLine();

            if (indexScanner >= 0 && indexScanner < servicosCadastrados.size()) {
                Servico s = servicosCadastrados.get(indexScanner);

                // Registra o preço deste atendimento sem alterar o cadastro.
                servicos.add(new Servico(s.getTipo(), s.getPreco()));
                System.out.println("Serviço adicionado à prestação.");
            } else {
                System.out.println("Índice inválido.");
            }
        } else {
            System.out.println("Não há serviços cadastrados nesta entidade.");
        }
    }

    public void adicionarCliente() {
        System.out.println("Digite o nome do Cliente:");

        do {
            cliente.setNome(sc.nextLine());
        } while (cliente.getNome().isBlank() == true);
    }

    public void listarServicosPrestadosPrestacao() {
        System.out.println("Cliente: " + cliente.getNome());

        for (int index = 0; index < servicos.size(); index++) {
            servicos.get(index).exibirDadosDoServico();
        }

        System.out.println("Total desta prestação: R$ " + calcularTotalPrestacao());
    }

    public float calcularTotalPrestacao() {
        float total = 0;

        for (int index = 0; index < servicos.size(); index++) {
            total = total + servicos.get(index).getPreco();
        }

        return total;
    }
}
