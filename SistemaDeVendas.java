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

    public void exibirCarrinho() {
        for (Produto produto : produtos) {
            System.out.println("Produto: " + produto.getNome() + ", Preço: R$ " + produto.getPreco());
        }
    }
}

class SistemaDeVendas {
    private Carrinho carrinho;

    public SistemaDeVendas() {
        carrinho = new Carrinho();
    }

    public void adicionarProdutoAoCarrinho(String nome, double preco) {
        Produto produto = new Produto(nome, preco);
        carrinho.adicionarProduto(produto);
    }

    public void exibirTotal() {
        System.out.println("Total da compra: R$ " + carrinho.calcularTotal());
    }

    public void emitirNotaFiscal() {
        double total = carrinho.calcularTotal();
        System.out.println("\n--- Nota Fiscal ---");
        carrinho.exibirCarrinho();
        System.out.println("Total a pagar: R$ " + total);
        System.out.println("-------------------");
    }

    public static void main(String[] args) {
        SistemaDeVendas sistema = new SistemaDeVendas();

        // Adicionando produtos ao carrinho
        sistema.adicionarProdutoAoCarrinho("Camiseta", 59.90);
        sistema.adicionarProdutoAoCarrinho("Calça Jeans", 129.90);
        sistema.adicionarProdutoAoCarrinho("Tênis", 199.90);

        // Exibindo total da compra
        sistema.exibirTotal();

        // Emitindo nota fiscal
        sistema.emitirNotaFiscal();
    }
}


