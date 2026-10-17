package com.gerenciamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Entidade {

    ArrayList<Venda> vendas = new ArrayList<>();
    Estoque e = new Estoque();

    // Cadastro dos serviços disponíveis nesta entidade.
    ArrayList<Servico> servicosCadastrados = new ArrayList<>();

    // Cada Prestacao contém os serviços de um atendimento realizado.
    ArrayList<Prestacao> servicos = new ArrayList<>();

    private String nomeDaEntidade;
    private String cidade;

    Scanner sc = new Scanner(System.in);

    public Entidade(String nomeDaEntidade, String cidade) {
        this.nomeDaEntidade = nomeDaEntidade;
        this.cidade = cidade;
    }

    public String getNomeDaEntidade() {
        return nomeDaEntidade;
    }

    public void setNomeDaEntidade(String nomeDaEntidade) {
        this.nomeDaEntidade = nomeDaEntidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void adicionarProdutoEstoque() {
        int maisProdutos = 1;
        e.sc = sc;

        do {
            e.adicionarProduto();
            System.out.println("Ainda deseja adicionar outro produto?");
            System.out.println("0- Não;");
            System.out.println("1- Sim.");
            maisProdutos = sc.nextInt();
            sc.nextLine();
        } while (maisProdutos == 1);
    }

    public void cadastrarServico() {
        int maisServicos = 1;

        do {
            Servico s = new Servico(null, 0);

            System.out.println("Digite o tipo do serviço:");
            s.setTipo(sc.nextLine());
            System.out.println("Digite o preço do serviço:");
            s.setPreco(sc.nextFloat());
            sc.nextLine();

            if (s.getTipo().isBlank() == false && s.getPreco() > 0) {
                servicosCadastrados.add(s);
                System.out.println("Serviço cadastrado.");
            } else {
                System.out.println("Erro de Preenchimento, coloque os dados corretamente.");
            }

            System.out.println("Ainda deseja cadastrar outro serviço?");
            System.out.println("0- Não;");
            System.out.println("1- Sim.");
            maisServicos = sc.nextInt();
            sc.nextLine();
        } while (maisServicos == 1);
    }

    public void realizarPrestacaoServico() {
        if (servicosCadastrados.size() > 0) {
            Prestacao p = new Prestacao();
            p.sc = sc;
            int maisServicos = 1;

            do {
                p.adicionarServicoPrestacao(servicosCadastrados);
                System.out.println("Ainda deseja adicionar outro serviço a este atendimento?");
                System.out.println("0- Não;");
                System.out.println("1- Sim.");
                maisServicos = sc.nextInt();
                sc.nextLine();
            } while (maisServicos == 1);

            if (p.servicos.size() > 0) {
                p.adicionarCliente();
                servicos.add(p);
                System.out.println("Prestação registrada.");
            }
        } else {
            System.out.println("Não há serviços cadastrados nesta entidade.");
        }
    }

    public void listarServicosPrestadosEntidade() {
        for (int index = 0; index < servicos.size(); index++) {
            System.out.println("--- Prestação " + (index + 1) + " ---");
            servicos.get(index).listarServicosPrestadosPrestacao();
        }
    }

    public void listarProdutosVendidos() {
        for (int index = 0; index < vendas.size(); index++) {
            System.out.println("--- Venda " + (index + 1) + " ---");
            vendas.get(index).listarProdutosVendidos();
        }
    }

    public void realizarVenda() {
        if (e.produtos.size() <= 0) {
            System.out.println("Sem produtos no estoque. . .");
        } else {
            Venda v = new Venda();
            v.sc = sc;
            int escolharepetir = 1;

            do {
                // Os índices são mostrados novamente após cada remoção.
                for (int index = 0; index < e.produtos.size(); index++) {
                    System.out.println("-------------------------------");
                    System.out.println("Nome do produto: " + e.produtos.get(index).getNome());
                    System.out.println("Tipo do produto: " + e.produtos.get(index).getTipo());
                    System.out.println("Preço do produto: " + e.produtos.get(index).getPreco());
                    System.out.println("Índice do produto: " + index);
                    System.out.println("-------------------------------");
                }

                System.out.println("Qual o produto para realizar a venda? Escreva o índice.");
                int indexScanner = sc.nextInt();
                sc.nextLine();

                if (indexScanner >= 0 && indexScanner < e.produtos.size()) {
                    v.adicionaProduto(e.produtos.get(indexScanner));
                    e.removerProduto(e.produtos.get(indexScanner));
                } else {
                    System.out.println("Índice inválido.");
                }

                if (e.produtos.size() > 0) {
                    System.out.println("Quer adicionar mais um produto a venda? 1 = sim, 0 = não");
                    escolharepetir = sc.nextInt();
                    sc.nextLine();
                } else {
                    escolharepetir = 0;
                    System.out.println("Não há mais produtos no estoque.");
                }
            } while (escolharepetir == 1);

            // Registra a venda somente uma vez, depois de selecionar os produtos.
            if (v.produtos.size() > 0) {
                v.adicionarCliente();
                vendas.add(v);
                System.out.println("Venda registrada.");
            }
        }
    }

    public float calcularTotalServicos() {
        float total = 0;

        for (int index = 0; index < servicos.size(); index++) {
            total = total + servicos.get(index).calcularTotalPrestacao();
        }

        return total;
    }

    public float calcularTotalVendas() {
        float total = 0;

        for (int index = 0; index < vendas.size(); index++) {
            total = total + vendas.get(index).calcularTotalVenda();
        }

        return total;
    }

    public float calcularTotalArrecadado() {
        return calcularTotalVendas() + calcularTotalServicos();
    }

    public void exibirInfoEntidade() {
        System.out.println("Nome da Entidade: " + this.nomeDaEntidade);
        System.out.println("Cidade da entidade: " + this.cidade);
    }

    public void editarNomeDaEntidade(String novoNome) {
        this.nomeDaEntidade = novoNome;
    }

    public Produto produtoMaiorValorEstoque() {
        Produto maior = e.produtos.get(0);

        for (int index = 0; index < e.produtos.size(); index++) {
            if (e.produtos.get(index).getPreco() > maior.getPreco()) {
                maior = e.produtos.get(index);
            }
        }

        return maior;
    }

    public void mudarNome() {
        System.out.println("Para qual nome voce deseja mudar?");
        String n = sc.nextLine();
        nomeDaEntidade = n.strip();
    }

    public void mudarCidade() {
        System.out.println("Para qual cidade voce deseja mudar?");
        String c = sc.nextLine();
        cidade = c.strip();
    }
}
