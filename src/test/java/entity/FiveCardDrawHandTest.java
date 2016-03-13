package entity;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FiveCardDrawHandTest {

    private FiveCardDrawHand hand;

    @Before
    public void setUp() {
        hand = new FiveCardDrawHand();
    }

    @Test(expected = HandException.class)
    public void hasTooManyCards() throws HandException {
        try {
            hand.addCard(new Card(Rank.ACE, Suit.HEART));
            hand.addCard(new Card(Rank.KING, Suit.HEART));
            hand.addCard(new Card(Rank.QUEEN, Suit.HEART));
            hand.addCard(new Card(Rank.JACK, Suit.HEART));
            hand.addCard(new Card(Rank.TEN, Suit.HEART));
            hand.addCard(new Card(Rank.NINE, Suit.HEART));
        } catch (HandException ex) {
            Assert.assertEquals("A maximum of 5 cards may be assigned to a hand", ex.getMessage());
            throw ex;
        }
    }
    
    @Test
    public void isStraigthtflush() throws HandException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.KING, Suit.HEART));
        hand.addCard(new Card(Rank.QUEEN, Suit.HEART));
        hand.addCard(new Card(Rank.JACK, Suit.HEART));
        hand.addCard(new Card(Rank.TEN, Suit.HEART));
        Assert.assertEquals(HandStrenth.STRAIGHT_FLUSH, hand.getHandStrength());
    }

    @Test
    public void isFourOfKind() throws HandException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.ACE, Suit.SPADE));
        hand.addCard(new Card(Rank.ACE, Suit.DIAMOND));
        hand.addCard(new Card(Rank.ACE, Suit.CLUB));
        hand.addCard(new Card(Rank.TEN, Suit.HEART));
        Assert.assertEquals(HandStrenth.FOUR_OF_A_KIND, hand.getHandStrength());
    }

    @Test
    public void isFullHouse() throws HandException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.ACE, Suit.SPADE));
        hand.addCard(new Card(Rank.ACE, Suit.DIAMOND));
        hand.addCard(new Card(Rank.KING, Suit.HEART));
        hand.addCard(new Card(Rank.KING, Suit.CLUB));
        Assert.assertEquals(HandStrenth.FULL_HOUSE, hand.getHandStrength());
    }

    @Test
    public void isFlush() throws HandException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.JACK, Suit.HEART));
        hand.addCard(new Card(Rank.NINE, Suit.HEART));
        hand.addCard(new Card(Rank.SIX, Suit.HEART));
        hand.addCard(new Card(Rank.THREE, Suit.HEART));
        Assert.assertEquals(HandStrenth.FLUSH, hand.getHandStrength());
    }

    @Test
    public void isStraightAceHigh() throws HandException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.KING, Suit.SPADE));
        hand.addCard(new Card(Rank.QUEEN, Suit.DIAMOND));
        hand.addCard(new Card(Rank.JACK, Suit.CLUB));
        hand.addCard(new Card(Rank.TEN, Suit.HEART));
        Assert.assertEquals(HandStrenth.STRAIGHT, hand.getHandStrength());
    }
    
    @Test
    public void isStraightKingHigh() throws HandException {
        hand.addCard(new Card(Rank.KING, Suit.HEART));
        hand.addCard(new Card(Rank.QUEEN, Suit.SPADE));
        hand.addCard(new Card(Rank.JACK, Suit.DIAMOND));
        hand.addCard(new Card(Rank.TEN, Suit.CLUB));
        hand.addCard(new Card(Rank.NINE, Suit.HEART));
        Assert.assertEquals(HandStrenth.STRAIGHT, hand.getHandStrength());
    }
    
    @Test
    public void isStraightSixHigh() throws HandException {
        hand.addCard(new Card(Rank.SIX, Suit.HEART));
        hand.addCard(new Card(Rank.FIVE, Suit.SPADE));
        hand.addCard(new Card(Rank.FOUR, Suit.DIAMOND));
        hand.addCard(new Card(Rank.THREE, Suit.CLUB));
        hand.addCard(new Card(Rank.TWO, Suit.HEART));
        Assert.assertEquals(HandStrenth.STRAIGHT, hand.getHandStrength());
    }

    @Test
    public void isThreeOfKind() throws HandException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.ACE, Suit.SPADE));
        hand.addCard(new Card(Rank.ACE, Suit.DIAMOND));
        hand.addCard(new Card(Rank.THREE, Suit.CLUB));
        hand.addCard(new Card(Rank.TWO, Suit.HEART));
        Assert.assertEquals(HandStrenth.THREE_OF_A_KIND, hand.getHandStrength());
    }

    @Test
    public void isTwoPair() throws HandException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.ACE, Suit.SPADE));
        hand.addCard(new Card(Rank.KING, Suit.DIAMOND));
        hand.addCard(new Card(Rank.KING, Suit.CLUB));
        hand.addCard(new Card(Rank.TWO, Suit.HEART));
        Assert.assertEquals(HandStrenth.TWO_PAIR, hand.getHandStrength());
    }

    @Test
    public void isOnePair() throws HandException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.ACE, Suit.SPADE));
        hand.addCard(new Card(Rank.FOUR, Suit.DIAMOND));
        hand.addCard(new Card(Rank.THREE, Suit.CLUB));
        hand.addCard(new Card(Rank.TWO, Suit.HEART));
        Assert.assertEquals(HandStrenth.ONE_PAIR, hand.getHandStrength());
    }

    @Test
    public void isHighCard() throws HandException {
        hand.addCard(new Card(Rank.ACE, Suit.HEART));
        hand.addCard(new Card(Rank.FIVE, Suit.SPADE));
        hand.addCard(new Card(Rank.FOUR, Suit.DIAMOND));
        hand.addCard(new Card(Rank.THREE, Suit.CLUB));
        hand.addCard(new Card(Rank.TWO, Suit.HEART));
        Assert.assertEquals(HandStrenth.HIGH_CARD, hand.getHandStrength());
    }

}
