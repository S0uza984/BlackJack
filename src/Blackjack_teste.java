import java.util.Scanner;

public class Blackjack_teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Cria e embaralha o baralho
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        // Cartas do jogador
        Card[] jogadorCartas = new Card[5]; // Suponha no máximo 5 cartas
        int jogadorPontos = 0;
        int jogadorContador = 0;

        // Cartas do dealer
        Card[] dealerCartas = new Card[5];
        int dealerPontos = 0;
        int dealerContador = 0;

        // Distribui duas cartas para o jogador e o dealer
        jogadorCartas[jogadorContador] = deck.dealCard();
        jogadorPontos += jogadorCartas[jogadorContador++].getValor();
        jogadorCartas[jogadorContador] = deck.dealCard();
        jogadorPontos += jogadorCartas[jogadorContador++].getValor();

        dealerCartas[dealerContador] = deck.dealCard();
        dealerPontos += dealerCartas[dealerContador++].getValor();
        dealerCartas[dealerContador] = deck.dealCard();
        dealerPontos += dealerCartas[dealerContador++].getValor();

        // Exibe as cartas do jogador e a carta visível do dealer
        System.out.println("Suas cartas: ");
        for (int i = 0; i < jogadorContador; i++) {
            System.out.println(jogadorCartas[i]);
        }
        System.out.println("Pontuação do jogador: " + jogadorPontos);

        System.out.println("\nCarta visível do dealer: " + dealerCartas[0]);

        // Jogador decide se quer "comprar" ou "parar"
        while (jogadorPontos < 21) {
            System.out.println("\nVocê quer 'comprar' (digite '1') ou 'parar' (digite '2')?");
            int escolha = scanner.nextInt();

            if (escolha == 1) { // Jogador compra mais uma carta
                jogadorCartas[jogadorContador] = deck.dealCard();
                jogadorPontos += jogadorCartas[jogadorContador++].getValor();
                System.out.println("Você recebeu: " + jogadorCartas[jogadorContador - 1]);
                System.out.println("Pontuação do jogador: " + jogadorPontos);

                if (jogadorPontos > 21) {
                    System.out.println("Você estourou! Pontuação final: " + jogadorPontos);
                    System.out.println("Você perdeu!");
                    return; // Termina o jogo se o jogador estourou
                }
            } else {
                break; // Jogador escolheu parar
            }
        }

        // Turno do dealer (dealer compra até atingir 17 ou mais pontos)
        System.out.println("\nTurno do dealer...");
        while (dealerPontos < 17) {
            dealerCartas[dealerContador] = deck.dealCard();
            dealerPontos += dealerCartas[dealerContador++].getValor();
            System.out.println("Dealer comprou: " + dealerCartas[dealerContador - 1]);
            System.out.println("Pontuação do dealer: " + dealerPontos);
        }

        // Exibe as cartas finais do dealer
        System.out.println("\nCartas finais do dealer: ");
        for (int i = 0; i < dealerContador; i++) {
            System.out.println(dealerCartas[i]);
        }
        System.out.println("Pontuação final do dealer: " + dealerPontos);

        // Determina o vencedor
        if (dealerPontos > 21) {
            System.out.println("Dealer estourou! Você venceu!");
        } else if (jogadorPontos > dealerPontos) {
            System.out.println("Você venceu com " + jogadorPontos + " pontos!");
        } else if (jogadorPontos < dealerPontos) {
            System.out.println("Dealer venceu com " + dealerPontos + " pontos.");
        } else {
            System.out.println("Empate! Ambos têm " + jogadorPontos + " pontos.");
        }
    }
}
