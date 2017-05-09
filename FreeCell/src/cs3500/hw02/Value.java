package cs3500.hw02;

/**
 * This is the value enum representing all of the possible values
 * in a deck of cards.
 */
public enum Value {
  ACE("A"), TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"),
  SEVEN("7"), EIGHT("8"), NINE("9"), TEN("10"), JACK("J"), QUEEN("Q"), KING("K");
  private String value;
  Value(String value) {
    this.value = value;
  }

  public String toString() {
    return this.value;
  }
}
