package cs3500.hw02;

/**
 * Represents the cards in a FreecellModel in the game of free cell.
 *
 * @param suit the suit of the card
 * @param value the value of the card
 */

public class Card {
  private Suit suit;
  private Value value;

  public Card(Suit suit, Value value) {
    this.suit = suit;
    this.value = value;
  }

  @Override
  public String toString() {
    return this.value.toString() + this.suit.toString();

  }

  public Value getValue() {
    return this.value;
  }

  public Suit getSuit() {
    return this.suit;
  }



}


