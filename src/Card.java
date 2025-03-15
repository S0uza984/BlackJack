public class Card {
    private final String face; // face of card ("Ace", "Deuce", ...)
    private final String suit; // suit of card ("Hearts", "Diamonds", ...)

    // two-argument constructor initializes card's face and suit
    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    // Método para determinar o valor da carta com base na face
    public int getValor() {
        switch(face) {
            case "Ace":
                return 1; // Por padrão, retornamos 1 (no Blackjack pode ser 1 ou 11)
            case "Deuce": return 2;
            case "Three": return 3;
            case "Four": return 4;
            case "Five": return 5;
            case "Six": return 6;
            case "Seven": return 7;
            case "Eight": return 8;
            case "Nine": return 9;
            case "Ten": 
            case "Jack": 
            case "Queen": 
            case "King":
                return 10; // J, Q e K valem 10 pontos
            default:
                return 0; // Para evitar erros
        }
    }

    // return String representation of Card
    public String toString() { 
        return face + " of " + suit;
    }
}
