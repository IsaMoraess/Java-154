package EXERCICIO_1;

import java.util.ArrayList;
import java.util.List;

class Contato {
    private String nome;
    private String telefone;
    private String email;

    public Contato(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}

class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        contatos = new ArrayList<>();
    }

    public void adicionarContato(String nome, String telefone, String email) {
        Contato contato = new Contato(nome, telefone, email);
        contatos.add(contato);
    }

    public void removerContato(String nome) {
        contatos.removeIf(contato -> contato.getNome().equals(nome));
    }

    public Contato pesquisarContato(String nome) {
        for (Contato contato : contatos) {
            if (contato.getNome().equals(nome)) {
                return contato;
            }
        }
        return null;
    }

    public void listarContatos() {
        for (Contato contato : contatos) {
            System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone() + ", Email: " + contato.getEmail());
        }
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.adicionarContato("Carlos", "123456789", "carlos@example.com");
        agenda.adicionarContato("Maria", "987654321", "maria@example.com");

        System.out.println("Lista de contatos:");
        agenda.listarContatos();

        System.out.println("\nPesquisando contato 'Carlos':");
        Contato contato = agenda.pesquisarContato("Carlos");
        if (contato != null) {
            System.out.println("Nome: " + contato.getNome() + ", Telefone: " + contato.getTelefone() + ", Email: " + contato.getEmail());
        } else {
            System.out.println("Contato não encontrado.");
        }
    }
}


