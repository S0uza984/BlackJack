public class Player {
    private Card[] hand; // Mão do jogador, um array fixo de cartas
    private int pontos; // Soma dos valores das cartas na mão
    private int currentCard; // Índice para acompanhar a próxima posição disponível na mão

    public Player(int maxCards) {
        hand = new Card[maxCards]; // Inicializa a mão com o tamanho máximo especificado
        pontos = 0; // Inicializa os pontos em 0
        currentCard = 0; // Inicializa o índice de cartas na mão
    }

    // Método para adicionar uma carta à mão do jogador
    public void addCard(Card card) {
        if (currentCard < hand.length) { // Verifica se ainda há espaço na mão
            hand[currentCard] = card; // Adiciona a carta à mão
            this.pontos += card.getValor(); // Atualiza os pontos ao adicionar a carta
            currentCard++; // Incrementa o índice para a próxima carta
        } else {
            System.out.println("Mão cheia, não é possível adicionar mais cartas!");
        }
    }

    // Método para obter a mão do jogador
    public Card[] getHand() {
        return hand; // Retorna o array de cartas
    }

    // Método para obter a soma dos pontos
    public int getPoints() {
        return pontos; // Retorna os pontos acumulados
    }

    // Método para representar o jogador e suas cartas
    @Override
    public String toString() {
        StringBuilder handString = new StringBuilder("Mão: ");
        for (int i = 0; i < currentCard; i++) {
            handString.append(hand[i]).append(", "); // Constrói a representação da mão
        }
        handString.append("Pontuação: ").append(pontos);
        return handString.toString();
    }

    // Método para verificar se o jogador estourou
    public boolean estourou() {
        return pontos > 21; // Retorna true se os pontos excederem 21
    }
}
