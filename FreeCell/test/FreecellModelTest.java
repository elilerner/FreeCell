

import org.junit.Test;

import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellModel;
import cs3500.hw02.PileType;
import cs3500.hw02.Suit;
import cs3500.hw02.Value;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The test class for the FreeCell Model.
 */
public class FreecellModelTest {
  private List<Card> deck;
  private FreecellModel fcm;


  void init() {
    fcm = new FreecellModel();
    this.deck = fcm.getDeck();
    fcm.getGameState();

  }


  @Test
  public void getDeck() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertTrue(deck.size() == 52);
  }

  @Test
  public void getDeck1() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertTrue(deck.get(0).getSuit().equals(Suit.HEART));
  }

  @Test
  public void getDeck2() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertTrue(deck.get(51).getSuit().equals(Suit.CLUB));
  }

  @Test
  public void getDeck3() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertTrue(deck.get(12).getSuit().equals(Suit.HEART));
  }

  @Test
  public void getDeck4() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertTrue(deck.get(25).getSuit().equals(Suit.SPADE));
  }

  @Test
  public void getDeck5() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertTrue(deck.get(38).getSuit().equals(Suit.DIAMOND));

  }

  @Test
  public void getDeck6() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertTrue(deck.get(51).getValue().equals(Value.KING));

  }

  @Test
  public void getDeck7() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertTrue(deck.get(0).getValue().equals(Value.ACE));

  }

  @Test
  public void getDeck8() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertTrue(deck.get(3).getValue().equals(Value.FOUR));

  }

  @Test
  public void getDeck9() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertTrue(deck.get(12).getValue().equals(Value.KING));

  }

  @Test
  public void getDeck10() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertTrue(deck.get(38).getValue().equals(Value.KING));

  }


  @Test(expected = IllegalArgumentException.class)
  public void testFailStartGame() {
    this.init();
    fcm.startGame(this.deck, 3, 4, false);


  }

  @Test(expected = IllegalArgumentException.class)
  public void testFailStartGame1() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    this.deck.add(new Card(Suit.CLUB, Value.ACE));
    fcm.startGame(this.deck, 5, 1, true);


  }


  @Test
  public void testGetGameState1() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertEquals("F1:" + "\n" +
            "F2:" + "\n" +
            "F3:" + "\n" +
            "F4:" + "\n" +
            "O1:" + "\n" +
            "O2:" + "\n" +
            "O3:" + "\n" +
            "O4:" + "\n" +
            "C1: A♥, 9♥, 4♠, Q♠, 7♦, 2♣, 10♣" + "\n" +
            "C2: 2♥, 10♥, 5♠, K♠, 8♦, 3♣, J♣" + "\n" +
            "C3: 3♥, J♥, 6♠, A♦, 9♦, 4♣, Q♣" + "\n" +
            "C4: 4♥, Q♥, 7♠, 2♦, 10♦, 5♣, K♣" + "\n" +
            "C5: 5♥, K♥, 8♠, 3♦, J♦, 6♣" + "\n" +
            "C6: 6♥, A♠, 9♠, 4♦, Q♦, 7♣" + "\n" +
            "C7: 7♥, 2♠, 10♠, 5♦, K♦, 8♣" + "\n" +
            "C8: 8♥, 3♠, J♠, 6♦, A♣, 9♣", fcm.getGameState());
  }


  @Test
  public void testGetGameState3() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    this.fcm.move(PileType.CASCADE, 6, 5, PileType.OPEN, 0);
    this.fcm.move(PileType.CASCADE, 2, 6, PileType.CASCADE, 6);
    assertEquals("F1:" + "\n" +
            "F2:" + "\n" +
            "F3:" + "\n" +
            "F4:" + "\n" +
            "O1: 8♣" + "\n" +
            "O2:" + "\n" +
            "O3:" + "\n" +
            "O4:" + "\n" +
            "C1: A♥, 9♥, 4♠, Q♠, 7♦, 2♣, 10♣" + "\n" +
            "C2: 2♥, 10♥, 5♠, K♠, 8♦, 3♣, J♣" + "\n" +
            "C3: 3♥, J♥, 6♠, A♦, 9♦, 4♣" + "\n" +
            "C4: 4♥, Q♥, 7♠, 2♦, 10♦, 5♣, K♣" + "\n" +
            "C5: 5♥, K♥, 8♠, 3♦, J♦, 6♣" + "\n" +
            "C6: 6♥, A♠, 9♠, 4♦, Q♦, 7♣" + "\n" +
            "C7: 7♥, 2♠, 10♠, 5♦, K♦, Q♣" + "\n" +
            "C8: 8♥, 3♠, J♠, 6♦, A♣, 9♣", fcm.getGameState());
    this.fcm.getGameState();
  }

  @Test
  public void testGetGameStateWithInvalidStartGame() {
    fcm = new FreecellModel();
    assertEquals("", fcm.getGameState());

  }


  @Test
  public void testGetCard() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertEquals(Value.TEN, this.fcm.getCard(PileType.CASCADE, 0, 6).getValue());
  }

  @Test
  public void testGetCard1() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    assertEquals(Suit.CLUB, this.fcm.getCard(PileType.CASCADE, 1, 6).getSuit());
  }


  @Test(expected = IllegalArgumentException.class)
  public void failGetCard() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    this.fcm.getCard(PileType.CASCADE, 5, 4);
  }

  @Test(expected = IllegalArgumentException.class)
  public void failGetCard1() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    this.fcm.getCard(PileType.CASCADE, 2, 7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void failPlaceCard() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    this.fcm.placeCard(new Card(Suit.HEART, Value.FIVE), PileType.FOUNDATION, 0);
  }


  @Test(expected = IndexOutOfBoundsException.class)
  public void failPlaceCard2() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    this.fcm.placeCard(new Card(Suit.HEART, Value.FIVE), PileType.FOUNDATION, 4);
  }


  @Test(expected = IllegalArgumentException.class)
  public void failPlaceCard1() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    this.fcm.placeCard(new Card(Suit.CLUB, Value.TEN), PileType.CASCADE, 1);
  }

  @Test(expected = IllegalArgumentException.class)
  public void failPlaceCard3() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    this.fcm.placeCard(new Card(Suit.CLUB, Value.QUEEN), PileType.CASCADE, 3);
  }

  @Test
  public void testMove() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    this.fcm.move(PileType.CASCADE, 0, 6, PileType.OPEN, 0);
    assertEquals("F1:" + "\n" +
            "F2:" + "\n" +
            "F3:" + "\n" +
            "F4:" + "\n" +
            "O1: 10♣" + "\n" +
            "O2:" + "\n" +
            "O3:" + "\n" +
            "O4:" + "\n" +
            "C1: A♥, 9♥, 4♠, Q♠, 7♦, 2♣" + "\n" +
            "C2: 2♥, 10♥, 5♠, K♠, 8♦, 3♣, J♣" + "\n" +
            "C3: 3♥, J♥, 6♠, A♦, 9♦, 4♣, Q♣" + "\n" +
            "C4: 4♥, Q♥, 7♠, 2♦, 10♦, 5♣, K♣" + "\n" +
            "C5: 5♥, K♥, 8♠, 3♦, J♦, 6♣" + "\n" +
            "C6: 6♥, A♠, 9♠, 4♦, Q♦, 7♣" + "\n" +
            "C7: 7♥, 2♠, 10♠, 5♦, K♦, 8♣" + "\n" +
            "C8: 8♥, 3♠, J♠, 6♦, A♣, 9♣", this.fcm.getGameState());
  }

  @Test
  public void testMove1() {
    this.init();
    fcm.startGame(this.deck, 8, 4, false);
    this.fcm.move(PileType.CASCADE, 0, 6, PileType.OPEN, 0);
    this.fcm.move(PileType.CASCADE, 7, 5, PileType.OPEN, 1);
    this.fcm.move(PileType.CASCADE, 7, 4, PileType.FOUNDATION, 0);
    this.fcm.move(PileType.CASCADE, 0, 5, PileType.FOUNDATION, 0);


    assertEquals("F1: A♣, 2♣" + "\n" +
            "F2:" + "\n" +
            "F3:" + "\n" +
            "F4:" + "\n" +
            "O1: 10♣" + "\n" +
            "O2: 9♣" + "\n" +
            "O3:" + "\n" +
            "O4:" + "\n" +
            "C1: A♥, 9♥, 4♠, Q♠, 7♦" + "\n" +
            "C2: 2♥, 10♥, 5♠, K♠, 8♦, 3♣, J♣" + "\n" +
            "C3: 3♥, J♥, 6♠, A♦, 9♦, 4♣, Q♣" + "\n" +
            "C4: 4♥, Q♥, 7♠, 2♦, 10♦, 5♣, K♣" + "\n" +
            "C5: 5♥, K♥, 8♠, 3♦, J♦, 6♣" + "\n" +
            "C6: 6♥, A♠, 9♠, 4♦, Q♦, 7♣" + "\n" +
            "C7: 7♥, 2♠, 10♠, 5♦, K♦, 8♣" + "\n" +
            "C8: 8♥, 3♠, J♠, 6♦", this.fcm.getGameState());
  }

  @Test
  public void testMove2() {
    this.init();
    this.fcm.startGame(this.deck, 52, 4, false);

    this.fcm.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION, 0);
    this.fcm.move(PileType.CASCADE, 13, 0, PileType.FOUNDATION, 1);
    this.fcm.move(PileType.CASCADE, 26, 0, PileType.FOUNDATION, 2);
    this.fcm.move(PileType.CASCADE, 39, 0, PileType.FOUNDATION, 3);
    assertEquals("F1: A♥" + "\n" +
            "F2: A♠" + "\n" +
            "F3: A♦" + "\n" +
            "F4: A♣" + "\n" +
            "O1:" + "\n" +
            "O2:" + "\n" +
            "O3:" + "\n" +
            "O4:" + "\n" +
            "C1:" + "\n" +
            "C2: 2♥" + "\n" +
            "C3: 3♥" + "\n" +
            "C4: 4♥" + "\n" +
            "C5: 5♥" + "\n" +
            "C6: 6♥" + "\n" +
            "C7: 7♥" + "\n" +
            "C8: 8♥" + "\n" +
            "C9: 9♥" + "\n" +
            "C10: 10♥" + "\n" +
            "C11: J♥" + "\n" +
            "C12: Q♥" + "\n" +
            "C13: K♥" + "\n" +
            "C14:" + "\n" +
            "C15: 2♠" + "\n" +
            "C16: 3♠" + "\n" +
            "C17: 4♠" + "\n" +
            "C18: 5♠" + "\n" +
            "C19: 6♠" + "\n" +
            "C20: 7♠" + "\n" +
            "C21: 8♠" + "\n" +
            "C22: 9♠" + "\n" +
            "C23: 10♠" + "\n" +
            "C24: J♠" + "\n" +
            "C25: Q♠" + "\n" +
            "C26: K♠" + "\n" +
            "C27:" + "\n" +
            "C28: 2♦" + "\n" +
            "C29: 3♦" + "\n" +
            "C30: 4♦" + "\n" +
            "C31: 5♦" + "\n" +
            "C32: 6♦" + "\n" +
            "C33: 7♦" + "\n" +
            "C34: 8♦" + "\n" +
            "C35: 9♦" + "\n" +
            "C36: 10♦" + "\n" +
            "C37: J♦" + "\n" +
            "C38: Q♦" + "\n" +
            "C39: K♦" + "\n" +
            "C40:" + "\n" +
            "C41: 2♣" + "\n" +
            "C42: 3♣" + "\n" +
            "C43: 4♣" + "\n" +
            "C44: 5♣" + "\n" +
            "C45: 6♣" + "\n" +
            "C46: 7♣" + "\n" +
            "C47: 8♣" + "\n" +
            "C48: 9♣" + "\n" +
            "C49: 10♣" + "\n" +
            "C50: J♣" + "\n" +
            "C51: Q♣" + "\n" +
            "C52: K♣", this.fcm.getGameState());
  }

  @Test
  public void isGameOver() throws Exception {
    this.init();
    this.fcm.startGame(this.deck, 52, 4, false);
    assertEquals(false, this.fcm.isGameOver());
  }

  @Test
  public void isGameOver1() throws Exception {
    this.init();
    this.fcm.startGame(this.deck, 8, 4, false);
    this.fcm.move(PileType.CASCADE, 4, 5, PileType.OPEN, 0);
    assertEquals(false, this.fcm.isGameOver());
  }

  @Test
  public void isGameOver2() throws Exception {
    this.init();
    this.fcm.startGame(this.deck, 23, 13, false);
    assertEquals(false, this.fcm.isGameOver());
  }



}