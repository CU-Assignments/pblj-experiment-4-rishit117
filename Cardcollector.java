import java.util.*;

// Card class representing a single card
class Card {
    private String symbol;
    private String name;

    public Card(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Card{" + "symbol='" + symbol + '\'' + ", name='" + name + '\'' + '}';
    }
}

// CardCollection class to manage the collection of cards
class CardCollection {
    private Collection<Card> cards;

    public CardCollection() {
        this.cards = new ArrayList<>(); // Using ArrayList to store the cards
    }

    // Method to add a card to the collection
    public void addCard(String symbol, String name) {
        cards.add(new Card(symbol, name));
    }

    // Method to find cards by symbol
    public List<Card> findCardsBySymbol(String symbol) {
        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                result.add(card);
            }
        }
        return result;
    }

    // Method to display all cards
    public void displayAllCards() {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}

// Main class to test the functionality
public class CardCollectorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();

        // Adding some sample cards
        collection.addCard("Heart", "Ace");
        collection.addCard("Heart", "King");
        collection.addCard("Spade", "Queen");
        collection.addCard("Diamond", "Jack");

        System.out.println("Enter a symbol to search for cards (e.g., Heart, Spade): ");
        String symbol = scanner.nextLine();

        List<Card> foundCards = collection.findCardsBySymbol(symbol);

        if (foundCards.isEmpty()) {
            System.out.println("No cards found with the symbol: " + symbol);
        } else {
            System.out.println("Cards found with symbol " + symbol + ":");
            for (Card card : foundCards) {
                System.out.println(card);
            }
        }
    }
}
