package cs3500.hw02;

/**
 * This is the suit Enum representing all of the possible suits
 * in a deck of cards.
 */
public enum Suit {

  HEART("♥"), SPADE("♠"), DIAMOND("♦"), CLUB("♣");
  private String suit;

  Suit(String suit) {
    this.suit = suit;
  }

  public String toString() {
    return this.suit;
  }
}
