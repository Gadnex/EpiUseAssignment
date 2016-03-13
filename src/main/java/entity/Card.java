package entity;

public class Card {

    private Rank rank;
    private Suit suit;

    // private to prevent invalid card instantiation
    private Card() {
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
         return rank.getDisplayValue() + suit.getUnicodeCharacter();
    }

}
