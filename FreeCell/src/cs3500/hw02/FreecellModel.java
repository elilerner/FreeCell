package cs3500.hw02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class represents the model of the FreeCell game.
 */

public class FreecellModel implements FreecellOperations<Card> {
  protected List<List<Card>> cascadePile;
  protected List<List<Card>> foundationPile;
  protected List<List<Card>> openPile;


  @Override
  /**
   * returns a valid and complete FreecellModel of cards for the game FreeCell
   */
  public List<Card> getDeck() {

    List<Card> deck = new ArrayList<Card>();

    for (int i = 0; i < Suit.values().length; i++) {
      for (int j = 0; j < Value.values().length; j++) {
        deck.add(new Card(Suit.values()[i], Value.values()[j]));
      }
    }
    return deck;
  }

  /**
   * @param deck            the FreecellModel to be dealt.
   * @param numCascadePiles number of cascade piles(can be in the range of 4 minimum to 52
   *                        maximum).
   * @param numOpenPiles    number of open piles (can be in the range of 1 minimum to 52 maximum).
   * @param shuffle         if true, shuffle the FreecellModel else deal the FreecellModel as-is.
   */
  @Override

  public void startGame(List<Card> deck, int numCascadePiles, int numOpenPiles, boolean shuffle) {

    Set s = new HashSet(deck);

    if (s.size() < deck.size()) {
      throw new IllegalArgumentException("Duplicate cards in deck");
    }
    if (deck.size() != 52) {
      throw new IllegalArgumentException("Not a proper deck");
    }
    if (numCascadePiles < 4 || numCascadePiles > 52) {
      throw new IllegalArgumentException("Invalid number of cascade piles");
    }
    if (numOpenPiles < 1 || numOpenPiles > 52) {
      throw new IllegalArgumentException("Invalid number of open piles");
    }

    cascadePile = new ArrayList<List<Card>>();
    foundationPile = new ArrayList<List<Card>>();
    openPile = new ArrayList<List<Card>>();

    if (shuffle) {
      Collections.shuffle(deck);
    }

    for (int i = 0; i < 4; i++) {
      List<Card> pile = new ArrayList<Card>();
      this.foundationPile.add(pile);
    }

    for (int y = 0; y < numOpenPiles; y++) {
      List<Card> pile = new ArrayList<Card>();
      this.openPile.add(pile);
    }

    for (int j = 0; j < numCascadePiles; j++) {
      List<Card> pile = new ArrayList<Card>();
      this.cascadePile.add(pile);

    }

    for (int x = 0; x < deck.size(); x++) {
      cascadePile.get(x % numCascadePiles).add(deck.get(x));

    }

  }

  /**
   * @param source         the type of the source pile see @link{PileType}
   * @param pileNumber     the pile number of the given type, starting at 0
   * @param cardIndex      the index of the card to be moved from the source pile, starting at 0
   * @param destination    the type of the destination pile (see
   * @param destPileNumber the pile number of the given type, starting at 0
   *
   *                       Moves the card from the source at the pile number and card index to the
   *                       destination pile at the destination pile number.
   */
  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
                   int destPileNumber) {

    if (cascadePile == null || openPile == null || foundationPile == null) {
      throw new IllegalArgumentException("the game has not started");
    }

    if (this.isGameOver()) {
      throw new IllegalArgumentException("the game is over");
    }

    if ((pileNumber < 0) || (destPileNumber < 0)) {
      throw new IllegalArgumentException("No such pile exists");
    }


    switch (source) {
      case FOUNDATION:

        if ((pileNumber > foundationPile.size() - 1)) {
          throw new IllegalArgumentException("no such pile exists");
        }
        this.placeCard(this.getCard(PileType.FOUNDATION, pileNumber, cardIndex), destination,
                destPileNumber);
        foundationPile.get(pileNumber).remove(this.getCard(PileType.FOUNDATION, pileNumber,
                cardIndex));

        break;
      case CASCADE:

        if ((pileNumber > cascadePile.size() - 1)) {
          throw new IllegalArgumentException("no such pile exists");
        }

        this.placeCard(this.getCard(PileType.CASCADE, pileNumber, cardIndex), destination,
                destPileNumber);
        cascadePile.get(pileNumber).remove(this.getCard(PileType.CASCADE, pileNumber, cardIndex));
        break;
      case OPEN:

        if ((pileNumber > openPile.size() - 1)) {
          throw new IllegalArgumentException("no such pile exists");
        }

        this.placeCard(this.getCard(PileType.OPEN, pileNumber, cardIndex), destination,
                destPileNumber);
        openPile.get(pileNumber).remove(this.getCard(PileType.OPEN, pileNumber, cardIndex));
        break;
      default:
        break;
    }
  }

  /**
   * @param source     the source pile
   * @param pileNumber the pile Number you are removing from
   * @param cardIndex  the card index of the card you are removing Gets the card from the given
   *                   source pile at the specified card index.
   */
  public Card getCard(PileType source, int pileNumber, int cardIndex) {
    Card c = null;

    switch (source) {
      case FOUNDATION:
        if (!foundationPile.isEmpty() && cardIndex == (foundationPile.get(pileNumber).size() - 1)) {
          c = foundationPile.get(pileNumber).get(cardIndex);

        } else {
          throw new IllegalArgumentException("cannot get card");
        }
        break;
      case CASCADE:
        if (!cascadePile.isEmpty() && cardIndex == (cascadePile.get(pileNumber).size() - 1)) {
          c = cascadePile.get(pileNumber).get(cardIndex);
        } else {
          throw new IllegalArgumentException("cannot get card");
        }
        break;
      case OPEN:
        if (!openPile.isEmpty() && cardIndex == (openPile.get(pileNumber).size() - 1)) {
          c = openPile.get(pileNumber).get(cardIndex);
        } else {
          throw new IllegalArgumentException("cannot get card");
        }
        break;
      default:
        throw new IllegalArgumentException("no such card");
    }
    return c;
  }

  /**
   * @param card           the card that you are placing
   * @param destination    the destination pile of the placed card
   * @param destPileNumber the pile number of the destination pile Places the card in the
   *                       destination pile at the specified pile number.
   */
  public void placeCard(Card card, PileType destination, int destPileNumber) {
    switch (destination) {

      case FOUNDATION:

        List<Card> pile = foundationPile.get(destPileNumber);

        if (pile.isEmpty() && !(card.getValue().equals(Value.ACE))) {
          throw new IllegalArgumentException("cannot put any card but an ace here");

        }
        if (pile.isEmpty() && (card.getValue().equals(Value.ACE))) {
          pile.add(card);
        }

        if ((!card.getSuit().equals(
                this.getCard(destination, destPileNumber, pile.size() - 1).getSuit())) &&
                ((card.getValue().ordinal() + 1) !=
                        (this.getCard(destination, destPileNumber, pile.size() - 1))
                                .getValue().ordinal())) {
          throw new IllegalArgumentException("cannot place this card here");
        } else if (!pile.isEmpty() && !(card.getValue().equals(Value.ACE))) {
          pile.add(card);
        }
        break;


      case CASCADE:

        List<Card> pile1 = cascadePile.get(destPileNumber);

        if (!pile1.isEmpty()
                && ((card.getValue().ordinal() + 1) !=
                (this.getCard(destination, destPileNumber, pile1.size() - 1)
                        .getValue().ordinal()))
                || ((card.getSuit().ordinal() % 2) ==
                (this.getCard(destination, destPileNumber, pile1.size() - 1)
                        .getSuit().ordinal() % 2))) {
          throw new IllegalArgumentException("cannot place this card here");
        } else {
          pile1.add(card);
        }
        break;


      case OPEN:

        List<Card> pile2 = openPile.get(destPileNumber);

        if (!pile2.isEmpty()) {
          throw new IllegalArgumentException("cannot place a card here");
        } else {
          pile2.add(card);
        }
        break;

      default:
        break;
    }
  }


  @Override
  public boolean isGameOver() {
    return foundationPile.get(0).size() == 13
            && foundationPile.get(1).size() == 13
            && foundationPile.get(2).size() == 13
            && foundationPile.get(3).size() == 13;

  }


  @Override
  // calls the helper for the three types of file types
  public String getGameState() {
    if (cascadePile == null) {
      return "";
    }
    String gameState = "";
    gameState = gameState + getPartialGS(PileType.FOUNDATION);
    gameState = gameState + getPartialGS(PileType.OPEN);
    gameState = gameState + getPartialGS(PileType.CASCADE);
    return gameState;
  }

  /**
   * @param pileType the pile type to be converted to the gameState
   * @return the partial gameState of one PileType as a string.
   */


  private String getPartialGS(PileType pileType) {
    String str = "";

    if (pileType.equals(PileType.FOUNDATION)) {
      for (int i = 0; i < foundationPile.size(); i++) {
        str = str + "F" + (i + 1) + ":";
        for (int j = 0; j < foundationPile.get(i).size(); j++) {
          str = str + " ";
          str = str + foundationPile.get(i).get(j).toString();
          if (j != foundationPile.get(i).size() - 1) {
            str = str + ",";
          } else {
            str = str + "\n";
          }
        }
        if (foundationPile.get(i).isEmpty()) {
          str = str + "\n";
        }
      }
      return str;
    }

    if (pileType.equals(PileType.OPEN)) {
      for (int i = 0; i < openPile.size(); i++) {
        str = str + "O" + (i + 1) + ":";
        if (openPile.get(i).isEmpty()) {
          str = str + "\n";
        } else {
          str = str + " " + openPile.get(i).get(0).toString() + "\n";
        }
      }
      return str;
    }


    if (pileType.equals(PileType.CASCADE)) {
      for (int i = 0; i < cascadePile.size(); i++) {
        str = str + "C" + (i + 1) + ":";
        for (int j = 0; j < cascadePile.get(i).size(); j++) {
          str = str + " ";
          str = str + cascadePile.get(i).get(j).toString();
          if (j != cascadePile.get(i).size() - 1) {
            str = str + ",";
          }
        }
        if (i != cascadePile.size() - 1) {
          str = str + "\n";
        }
      }
    }
    return str;
  }
}
