package cs3500.hw04;

import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellModel;
import cs3500.hw02.FreecellOperations;
import cs3500.hw02.PileType;
import cs3500.hw02.Value;


public class MultiCardMoveModel extends FreecellModel implements FreecellOperations<Card> {

  @Override
  public void move(PileType source, int pileNumber, int cardIndex, PileType destination,
                   int destPileNumber) {

    List<Card> p = cascadePile.get(pileNumber);
    int numOfCards = p.size() - cardIndex;

    moveMultiCards(source, pileNumber, cardIndex, destination, destPileNumber, numOfCards);
  }

  /**
   * @param source         the source pile.
   * @param pileNumber     the pile number to get the card from.
   * @param cardIndex      the card index of the card to move.
   * @param dest           the destination pile type.
   * @param destPileNumber the number of the destination pile.
   * @param numOfCards     the number of cards being moved.
   */
  private void moveMultiCards(PileType source, int pileNumber, int cardIndex,
                              PileType dest, int destPileNumber, int numOfCards) {


    // throw an error if a multiCard move is attempted to anything but a cascade pile
    if (numOfCards > 1 && source != PileType.CASCADE && dest != PileType.CASCADE) {
      throw new IllegalArgumentException("cannot do a multiCard move to anything but a cascade");
    }

    // if the source and destination piles are cascade
    if ((source == PileType.CASCADE && dest == PileType.CASCADE)) {


      // the maximum number of cards that can be moved at one time with N Free Piles and
      // K open piles is (N+1)*2 ^ K.
      if (numOfCards > (numberEmptyOpens() + 1) * (Math.pow(2, numberEmptyCascades()))) {

        throw new IllegalArgumentException("cannot move this number of cards" +
                " either not enough empty open or empty cascade piles");
      }


      // throw an error if numOfCards exceeds the Pile size
      if (cascadePile.get(pileNumber).size() < numOfCards) {
        throw new IllegalArgumentException("Cannot remove this number of cards" +
                " from the Pile");
      }


      List<Card> p = cascadePile.get(pileNumber);

      // check that the cards in the source pile selected are in order
      for (int i = 0; i < numOfCards; i++) {
        int index = p.size() - numOfCards + i;

        if (!validBuild(numOfCards, p, pileNumber, index)) {
          throw new IllegalArgumentException("The selected cards are not in order");
        }
      }


      // do the selected cards to be moved form a valid build with the top card
      // in the destination pile?
      if (!formValidBuildCascade(p, destPileNumber, numOfCards, dest)) {
        throw new IllegalArgumentException("The cards selected do not form a valid build with the"
                + " destination pile");
      }

      // moves the selected cards one by one and appends them to the dest pile
      for (int i = 0; i < numOfCards; i++) {

        int index = p.size() - numOfCards + i;
        Card c = p.remove(index);

        cascadePile.get(destPileNumber).add(c);

      }
    }

    // throw an error if the open pile is full and a card is placed there, else allow move
    if (dest == PileType.OPEN) {
      List<Card> pile = openPile.get(destPileNumber);
      Card card = this.getCard(source, pileNumber, cardIndex);


      if (!pile.isEmpty()) {
        throw new IllegalArgumentException("cannot place a card here, the open pile if full");
      } else {
        removeFromSource(card, source, pileNumber);
        pile.add(card);


      }
    }

    // move a card to a foundation pile
    if (dest == PileType.FOUNDATION) {
      List<Card> pile = foundationPile.get(destPileNumber);
      Card card = this.getCard(source, pileNumber, cardIndex);

      if (pile.isEmpty() && (!card.getValue().equals(Value.ACE))) {
        throw new IllegalArgumentException("this card must be an Ace");

      } else if (!pile.isEmpty() && !formValidBuildFoundation(getSource(source).get(pileNumber),
              destPileNumber, numOfCards, dest)) {
        throw new IllegalArgumentException("placed card must form a valid build");
      } else {
        pile.add(card);
        removeFromSource(card, source, pileNumber);
      }
    }

  }


  /**
   * @param source the source pile.
   * @return the source pile.
   */
  private List<List<Card>> getSource(PileType source) {
    List<List<Card>> s = cascadePile;
    switch (source) {

      case CASCADE:
        s = cascadePile;
        break;

      case OPEN:
        s = openPile;
        break;

      case FOUNDATION:
        s = foundationPile;
        break;

      default:
        s = cascadePile;

    }
    return s;
  }


  /**
   * @param dest the destination pile type.
   * @return gets the destination pile.
   */
  private List<List<Card>> getDestination(PileType dest) {
    List<List<Card>> s = cascadePile;
    switch (dest) {

      case CASCADE:
        s = cascadePile;
        break;

      case OPEN:
        s = openPile;
        break;

      case FOUNDATION:
        s = foundationPile;
        break;

      default:
        s = cascadePile;

    }
    return s;
  }


  // Helper to remove the card from the source pile

  /**
   * @param c          the card to be removed.
   * @param source     the source pile.
   * @param pileNumber the source pileNumber.
   */
  private void removeFromSource(Card c, PileType source, int pileNumber) {
    switch (source) {

      case CASCADE:
        cascadePile.get(pileNumber).remove(c);
        break;

      case OPEN:
        openPile.get(pileNumber).remove(c);
        break;

      case FOUNDATION:
        foundationPile.get(pileNumber).remove(c);
        break;

      default:
        cascadePile.get(pileNumber).remove(c);
        break;
    }

  }


  // Helper that finds the number of open free piles and empty Cascade Piles

  private int numberEmptyOpens() {
    int opens = 0;

    for (int i = 0; i < openPile.size(); i++) {
      if (openPile.get(i).size() == 0) {
        opens++;
      }
    }
    return opens;
  }


  // Helper that find the number of Empty free Cascade Piles
  private int numberEmptyCascades() {
    int cascades = 0;

    for (int i = 0; i < cascadePile.size(); i++) {
      if (cascadePile.get(i).size() == 0) {
        cascades++;
      }
    }
    return cascades;
  }


  /**
   * @param numCards   the number of cards to be moved.
   * @param pile       the source pile.
   * @param pileNumber the source pile number.
   * @param index      the index of the bottom card from the selected.
   * @return whether the selected cards form a valid build.
   */
  private boolean validBuild(int numCards, List<Card> pile, int pileNumber, int index) {

    boolean b = false;

    if (index != pile.size() - 1) {
      b = (pile.get(index).getSuit().ordinal() % 2 !=
              pile.get(index + 1).getSuit().ordinal() % 2 &&
              pile.get(index).getValue().ordinal() ==
                      pile.get(index + 1).getValue().ordinal() + 1);


    } else {
      b = true;
    }
    return b;
  }


  /**
   * @param sourcePile     the source pile.
   * @param destPileNumber the destination pile number.
   * @param numCards       the number of cards to be moved.
   * @return whether a valid build will be formed in the cascade pile.
   */

  private boolean formValidBuildCascade(List<Card> sourcePile, int destPileNumber,
                                        int numCards, PileType dest) {

    List<Card> destPile = getDestination(dest).get(destPileNumber);


    return (destPile.get(destPile.size() - 1).getSuit().ordinal() % 2 !=
            sourcePile.get(sourcePile.size() - numCards).getSuit().ordinal() % 2
            && destPile.get(destPile.size() - 1).getValue().ordinal() - 1 ==
            sourcePile.get(sourcePile.size() - numCards).getValue().ordinal());


  }


  /**
   * @param sourcePile     the source pile.
   * @param destPileNumber the destination pile number.
   * @param numCards       the number of cards to be moved.
   * @return whether a valid build will be formed in the foundation pile.
   */

  private boolean formValidBuildFoundation(List<Card> sourcePile, int destPileNumber,
                                           int numCards, PileType dest) {

    List<Card> destPile = getDestination(dest).get(destPileNumber);


    return (destPile.get(destPile.size() - 1).getSuit().ordinal() % 2 ==
            sourcePile.get(sourcePile.size() - numCards).getSuit().ordinal() % 2
            && destPile.get(destPile.size() - 1).getValue().ordinal() + 1 ==
            sourcePile.get(sourcePile.size() - numCards).getValue().ordinal());

  }

}



