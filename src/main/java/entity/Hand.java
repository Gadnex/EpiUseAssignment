package entity;

public interface Hand {

    void addCard(Card card) throws HandException;

    HandStrenth getHandStrength();

}
