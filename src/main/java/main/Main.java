package main;

import entity.Deck;
import entity.FiveCardDrawHand;
import entity.Hand;
import entity.HandException;

public class Main {

    public static void main(String[] args) throws HandException {

        Deck deck = new Deck();
        deck.shuffle();
        System.out.println("Shuffling ... Shuffling ... Shuffling ...");
        Hand hand = new FiveCardDrawHand();
        hand.addCard(deck.dealCard());
        hand.addCard(deck.dealCard());
        hand.addCard(deck.dealCard());
        hand.addCard(deck.dealCard());
        hand.addCard(deck.dealCard());
        System.out.println("Your Hand: " + hand);
        System.out.println("You Have: " + hand.getHandStrength().getDisplayString());
    }

}
