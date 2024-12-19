package EXERCICIO_1;

class Assento {
    private int numero;
    private boolean reservado;

    public Assento(int numero) {
        this.numero = numero;
        this.reservado = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void reservar() {
        if (!reservado) {
            reservado = true;
            System.out.println("Assento " + numero + " reservado com sucesso.");
        } else {
            System.out.println("Assento " + numero + " já está reservado!");
        }
    }
}

class SistemaDeReservas {
    private Assento[] assentos;

    public SistemaDeReservas(int quantidadeAssentos) {
        assentos = new Assento[quantidadeAssentos];
        for (int i = 0; i < quantidadeAssentos; i++) {
            assentos[i] = new Assento(i + 1); // Criando assentos numerados de 1 até quantidadeAssentos
        }
    }

    // Reservar um assento
    public void reservarAssento(int numeroAssento) {
        if (numeroAssento > 0 && numeroAssento <= assentos.length) {
            assentos[numeroAssento - 1].reservar();
        } else {
            System.out.println("Número de assento inválido!");
        }
    }

    // Exibir assentos disponíveis
    public void exibirAssentosDisponiveis() {
        System.out.println("Assentos disponíveis:");
        for (Assento assento : assentos) {
            if (!assento.isReservado()) {
                System.out.print(assento.getNumero() + " ");
            }
        }
        System.out.println();
    }

    // Calcular a receita total (assumindo que cada assento custa 50)
    public double calcularReceitaTotal() {
        double receita = 0;
        for (Assento assento : assentos) {
            if (assento.isReservado()) {
                receita += 50;  // Vamos supor que cada assento reservado custa 50
            }
        }
        return receita;
    }

    public static void main(String[] args) {
        SistemaDeReservas sistema = new SistemaDeReservas(10);  // 10 assentos no cinema

        // Exibindo assentos disponíveis
        sistema.exibirAssentosDisponiveis();

        // Reservando alguns assentos
        sistema.reservarAssento(2);
        sistema.reservarAssento(5);
        sistema.reservarAssento(10);

        // Exibindo assentos disponíveis novamente
        sistema.exibirAssentosDisponiveis();

        // Calculando a receita total do cinema
        System.out.println("Receita total: R$ " + sistema.calcularReceitaTotal());
    }
}


