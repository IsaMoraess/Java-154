package EXERCICIO_1;

import java.util.ArrayList;
import java.util.List;

class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

class Carrinho {
    private List<Produto> produtos;

    public Carrinho() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    public void exibirProdutos() {
        for (Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome() + ", Preço: " + produto.getPreco());
        }
    }
}

class Loja {
    private Carrinho carrinho;

    public Loja() {
        carrinho = new Carrinho();
    }

    public void adicionarProdutoAoCarrinho(String nome, double preco) {
        Produto produto = new Produto(nome, preco);
        carrinho.adicionarProduto(produto);
    }

    public void calcularTotal() {
        System.out.println("Total da compra: " + carrinho.calcularTotal());
    }

    public void exibirCarrinho() {
        carrinho.exibirProdutos();
    }

    public static void main(String[] args) {
        Loja loja = new Loja();
        loja.adicionarProdutoAoCarrinho("Camiseta", 49.99);
        loja.adicionarProdutoAoCarrinho("Tênis", 199.99);

        loja.exibirCarrinho();
        loja.calcularTotal();
    }
}

