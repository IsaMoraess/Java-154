package EXERCICIO_1;

import java.util.HashMap;
import java.util.Map;

class ProdutoEstoque {
    private String nome;
    private int quantidade;
    private double preco;

    public ProdutoEstoque(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void adicionarEstoque(int quantidade) {
        this.quantidade += quantidade;
    }

    public void removerEstoque(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
        } else {
            System.out.println("Estoque insuficiente!");
        }
    }
}

class SistemaDeEstoque {
    private Map<String, ProdutoEstoque> estoque;

    public SistemaDeEstoque() {
        estoque = new HashMap<>();
    }

    public void adicionarProduto(String nome, int quantidade, double preco) {
        ProdutoEstoque produto = new ProdutoEstoque(nome, quantidade, preco);
        estoque.put(nome, produto);
    }

    public void removerProduto(String nome) {
        estoque.remove(nome);
    }

    public void atualizarQuantidade(String nome, int quantidade) {
        ProdutoEstoque produto = estoque.get(nome);
        if (produto != null) {
            produto.setQuantidade(quantidade);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void verificarEstoqueMinimo(String nome, int minimo) {
        ProdutoEstoque produto = estoque.get(nome);
        if (produto != null) {
            if (produto.getQuantidade() < minimo) {
                System.out.println("Estoque de " + nome + " abaixo do mínimo!");
            } else {
                System.out.println("Estoque de " + nome + " está ok.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void exibirEstoque() {
        for (ProdutoEstoque produto : estoque.values()) {
            System.out.println("Produto: " + produto.getNome() + ", Quantidade: " + produto.getQuantidade() + ", Preço: R$ " + produto.getPreco());
        }
    }

    public static void main(String[] args) {
        SistemaDeEstoque sistema = new SistemaDeEstoque();

        // Adicionando produtos ao estoque
        sistema.adicionarProduto("Camiseta", 100, 59.90);
        sistema.adicionarProduto("Calça Jeans", 50, 129.90);
        sistema.adicionarProduto("Tênis", 200, 199.90);

        // Exibindo o estoque
        System.out.println("Estoque atual:");
        sistema.exibirEstoque();

        // Atualizando a quantidade de um produto
        sistema.atualizarQuantidade("Camiseta", 120);

        // Verificando o estoque mínimo
        sistema.verificarEstoqueMinimo("Calça Jeans", 60);
        sistema.verificarEstoqueMinimo("Tênis", 150);

        // Removendo um produto do estoque
        sistema.removerProduto("Camiseta");

        // Exibindo o estoque após remoção
        System.out.println("\nEstoque após remoção:");
        sistema.exibirEstoque();
    }
}


