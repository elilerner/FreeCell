import org.junit.Test;

import java.util.List;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellModel;
import cs3500.hw02.PileType;
import cs3500.hw04.FreecellModelCreator;
import cs3500.hw04.MultiCardMoveModel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class FreecellModelCreatorTest extends FreecellModelTest {
  private List<Card> deck;
  private MultiCardMoveModel mcmm;


  void init1() {
    mcmm = new MultiCardMoveModel();
    this.deck = mcmm.getDeck();

  }


  @Test
  // move multiple cards between cascade piles
  public void testmultiMove() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 52, 4, false);

    this.mcmm.move(PileType.CASCADE, 10, 0, PileType.CASCADE,
            24);
    this.mcmm.move(PileType.CASCADE, 24, 0, PileType.CASCADE,
            12);
    this.mcmm.move(PileType.CASCADE, 22, 0, PileType.CASCADE,
            12);
    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♥\n" +
            "C2: 2♥\n" +
            "C3: 3♥\n" +
            "C4: 4♥\n" +
            "C5: 5♥\n" +
            "C6: 6♥\n" +
            "C7: 7♥\n" +
            "C8: 8♥\n" +
            "C9: 9♥\n" +
            "C10: 10♥\n" +
            "C11:\n" +
            "C12: Q♥\n" +
            "C13: K♥, Q♠, J♥, 10♠\n" +
            "C14: A♠\n" +
            "C15: 2♠\n" +
            "C16: 3♠\n" +
            "C17: 4♠\n" +
            "C18: 5♠\n" +
            "C19: 6♠\n" +
            "C20: 7♠\n" +
            "C21: 8♠\n" +
            "C22: 9♠\n" +
            "C23:\n" +
            "C24: J♠\n" +
            "C25:\n" +
            "C26: K♠\n" +
            "C27: A♦\n" +
            "C28: 2♦\n" +
            "C29: 3♦\n" +
            "C30: 4♦\n" +
            "C31: 5♦\n" +
            "C32: 6♦\n" +
            "C33: 7♦\n" +
            "C34: 8♦\n" +
            "C35: 9♦\n" +
            "C36: 10♦\n" +
            "C37: J♦\n" +
            "C38: Q♦\n" +
            "C39: K♦\n" +
            "C40: A♣\n" +
            "C41: 2♣\n" +
            "C42: 3♣\n" +
            "C43: 4♣\n" +
            "C44: 5♣\n" +
            "C45: 6♣\n" +
            "C46: 7♣\n" +
            "C47: 8♣\n" +
            "C48: 9♣\n" +
            "C49: 10♣\n" +
            "C50: J♣\n" +
            "C51: Q♣\n" +
            "C52: K♣", this.mcmm.getGameState());
  }

  @Test
  // move two cards cascade
  public void testMoveTwoCardsOneOpenZeroCascade() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 20, 1, false);

    mcmm.move(PileType.CASCADE, 7, 2, PileType.CASCADE, 15);
    mcmm.move(PileType.CASCADE, 15, 1, PileType.CASCADE, 9);

    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "C1: A♥, 8♠, 2♣\n" +
            "C2: 2♥, 9♠, 3♣\n" +
            "C3: 3♥, 10♠, 4♣\n" +
            "C4: 4♥, J♠, 5♣\n" +
            "C5: 5♥, Q♠, 6♣\n" +
            "C6: 6♥, K♠, 7♣\n" +
            "C7: 7♥, A♦, 8♣\n" +
            "C8: 8♥, 2♦\n" +
            "C9: 9♥, 3♦, 10♣\n" +
            "C10: 10♥, 4♦, J♣, 10♦, 9♣\n" +
            "C11: J♥, 5♦, Q♣\n" +
            "C12: Q♥, 6♦, K♣\n" +
            "C13: K♥, 7♦\n" +
            "C14: A♠, 8♦\n" +
            "C15: 2♠, 9♦\n" +
            "C16: 3♠\n" +
            "C17: 4♠, J♦\n" +
            "C18: 5♠, Q♦\n" +
            "C19: 6♠, K♦\n" +
            "C20: 7♠, A♣", mcmm.getGameState());
  }

  // try to move a card to a full open piles
  @Test(expected = IllegalArgumentException.class)
  public void testFailMoveToFullOpen() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 52, 4, false);

    this.mcmm.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    this.mcmm.move(PileType.CASCADE, 1, 0, PileType.OPEN, 0);

  }

  @Test
  // move to an open pile
  public void testMoveToOpen() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 52, 4, false);

    this.mcmm.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1: A♥\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1:\n" +
            "C2: 2♥\n" +
            "C3: 3♥\n" +
            "C4: 4♥\n" +
            "C5: 5♥\n" +
            "C6: 6♥\n" +
            "C7: 7♥\n" +
            "C8: 8♥\n" +
            "C9: 9♥\n" +
            "C10: 10♥\n" +
            "C11: J♥\n" +
            "C12: Q♥\n" +
            "C13: K♥\n" +
            "C14: A♠\n" +
            "C15: 2♠\n" +
            "C16: 3♠\n" +
            "C17: 4♠\n" +
            "C18: 5♠\n" +
            "C19: 6♠\n" +
            "C20: 7♠\n" +
            "C21: 8♠\n" +
            "C22: 9♠\n" +
            "C23: 10♠\n" +
            "C24: J♠\n" +
            "C25: Q♠\n" +
            "C26: K♠\n" +
            "C27: A♦\n" +
            "C28: 2♦\n" +
            "C29: 3♦\n" +
            "C30: 4♦\n" +
            "C31: 5♦\n" +
            "C32: 6♦\n" +
            "C33: 7♦\n" +
            "C34: 8♦\n" +
            "C35: 9♦\n" +
            "C36: 10♦\n" +
            "C37: J♦\n" +
            "C38: Q♦\n" +
            "C39: K♦\n" +
            "C40: A♣\n" +
            "C41: 2♣\n" +
            "C42: 3♣\n" +
            "C43: 4♣\n" +
            "C44: 5♣\n" +
            "C45: 6♣\n" +
            "C46: 7♣\n" +
            "C47: 8♣\n" +
            "C48: 9♣\n" +
            "C49: 10♣\n" +
            "C50: J♣\n" +
            "C51: Q♣\n" +
            "C52: K♣", this.mcmm.getGameState());

  }

  @Test
  // move to a foundation pile
  public void testMoveToFoundation() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 52, 4, false);

    this.mcmm.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION,
            0);
    assertEquals("F1: A♥\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1:\n" +
            "C2: 2♥\n" +
            "C3: 3♥\n" +
            "C4: 4♥\n" +
            "C5: 5♥\n" +
            "C6: 6♥\n" +
            "C7: 7♥\n" +
            "C8: 8♥\n" +
            "C9: 9♥\n" +
            "C10: 10♥\n" +
            "C11: J♥\n" +
            "C12: Q♥\n" +
            "C13: K♥\n" +
            "C14: A♠\n" +
            "C15: 2♠\n" +
            "C16: 3♠\n" +
            "C17: 4♠\n" +
            "C18: 5♠\n" +
            "C19: 6♠\n" +
            "C20: 7♠\n" +
            "C21: 8♠\n" +
            "C22: 9♠\n" +
            "C23: 10♠\n" +
            "C24: J♠\n" +
            "C25: Q♠\n" +
            "C26: K♠\n" +
            "C27: A♦\n" +
            "C28: 2♦\n" +
            "C29: 3♦\n" +
            "C30: 4♦\n" +
            "C31: 5♦\n" +
            "C32: 6♦\n" +
            "C33: 7♦\n" +
            "C34: 8♦\n" +
            "C35: 9♦\n" +
            "C36: 10♦\n" +
            "C37: J♦\n" +
            "C38: Q♦\n" +
            "C39: K♦\n" +
            "C40: A♣\n" +
            "C41: 2♣\n" +
            "C42: 3♣\n" +
            "C43: 4♣\n" +
            "C44: 5♣\n" +
            "C45: 6♣\n" +
            "C46: 7♣\n" +
            "C47: 8♣\n" +
            "C48: 9♣\n" +
            "C49: 10♣\n" +
            "C50: J♣\n" +
            "C51: Q♣\n" +
            "C52: K♣", this.mcmm.getGameState());


  }

  // try to move multiple cards to a foundation pile
  @Test(expected = IllegalArgumentException.class)
  public void testMove2To6CardsShouldFail() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 52, 1, false);

    this.mcmm.move(PileType.CASCADE, 1, 0, PileType.CASCADE, 0);
    this.mcmm.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION,
            0);
  }

  // move to foundation from open piles single card
  @Test
  public void testMoveFromFoundationToOpen() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 52, 1, false);

    this.mcmm.move(PileType.CASCADE, 0, 0, PileType.OPEN, 0);
    this.mcmm.move(PileType.OPEN, 0, 0, PileType.FOUNDATION, 0);
    assertEquals("F1: A♥\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "C1:\n" +
            "C2: 2♥\n" +
            "C3: 3♥\n" +
            "C4: 4♥\n" +
            "C5: 5♥\n" +
            "C6: 6♥\n" +
            "C7: 7♥\n" +
            "C8: 8♥\n" +
            "C9: 9♥\n" +
            "C10: 10♥\n" +
            "C11: J♥\n" +
            "C12: Q♥\n" +
            "C13: K♥\n" +
            "C14: A♠\n" +
            "C15: 2♠\n" +
            "C16: 3♠\n" +
            "C17: 4♠\n" +
            "C18: 5♠\n" +
            "C19: 6♠\n" +
            "C20: 7♠\n" +
            "C21: 8♠\n" +
            "C22: 9♠\n" +
            "C23: 10♠\n" +
            "C24: J♠\n" +
            "C25: Q♠\n" +
            "C26: K♠\n" +
            "C27: A♦\n" +
            "C28: 2♦\n" +
            "C29: 3♦\n" +
            "C30: 4♦\n" +
            "C31: 5♦\n" +
            "C32: 6♦\n" +
            "C33: 7♦\n" +
            "C34: 8♦\n" +
            "C35: 9♦\n" +
            "C36: 10♦\n" +
            "C37: J♦\n" +
            "C38: Q♦\n" +
            "C39: K♦\n" +
            "C40: A♣\n" +
            "C41: 2♣\n" +
            "C42: 3♣\n" +
            "C43: 4♣\n" +
            "C44: 5♣\n" +
            "C45: 6♣\n" +
            "C46: 7♣\n" +
            "C47: 8♣\n" +
            "C48: 9♣\n" +
            "C49: 10♣\n" +
            "C50: J♣\n" +
            "C51: Q♣\n" +
            "C52: K♣", mcmm.getGameState());
  }

  //test game over MultiMove Model
  @Test
  public void testGameOverMultiMove() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 52, 1, false);

    this.mcmm.move(PileType.CASCADE, 0, 0, PileType.FOUNDATION,
            0);
    this.mcmm.move(PileType.CASCADE, 1, 0, PileType.FOUNDATION,
            0);
    this.mcmm.move(PileType.CASCADE, 2, 0, PileType.FOUNDATION,
            0);
    this.mcmm.move(PileType.CASCADE, 3, 0, PileType.FOUNDATION,
            0);
    this.mcmm.move(PileType.CASCADE, 4, 0, PileType.FOUNDATION,
            0);
    this.mcmm.move(PileType.CASCADE, 5, 0, PileType.FOUNDATION,
            0);
    this.mcmm.move(PileType.CASCADE, 6, 0, PileType.FOUNDATION,
            0);
    this.mcmm.move(PileType.CASCADE, 7, 0, PileType.FOUNDATION,
            0);
    this.mcmm.move(PileType.CASCADE, 8, 0, PileType.FOUNDATION,
            0);
    this.mcmm.move(PileType.CASCADE, 9, 0, PileType.FOUNDATION,
            0);
    this.mcmm.move(PileType.CASCADE, 10, 0, PileType.FOUNDATION,
            0);
    this.mcmm.move(PileType.CASCADE, 11, 0, PileType.FOUNDATION,
            0);
    this.mcmm.move(PileType.CASCADE, 12, 0, PileType.FOUNDATION,
            0);

    this.mcmm.move(PileType.CASCADE, 13, 0, PileType.FOUNDATION,
            1);
    this.mcmm.move(PileType.CASCADE, 14, 0, PileType.FOUNDATION,
            1);
    this.mcmm.move(PileType.CASCADE, 15, 0, PileType.FOUNDATION,
            1);
    this.mcmm.move(PileType.CASCADE, 16, 0, PileType.FOUNDATION,
            1);
    this.mcmm.move(PileType.CASCADE, 17, 0, PileType.FOUNDATION,
            1);
    this.mcmm.move(PileType.CASCADE, 18, 0, PileType.FOUNDATION,
            1);
    this.mcmm.move(PileType.CASCADE, 19, 0, PileType.FOUNDATION,
            1);
    this.mcmm.move(PileType.CASCADE, 20, 0, PileType.FOUNDATION,
            1);
    this.mcmm.move(PileType.CASCADE, 21, 0, PileType.FOUNDATION,
            1);
    this.mcmm.move(PileType.CASCADE, 22, 0, PileType.FOUNDATION,
            1);
    this.mcmm.move(PileType.CASCADE, 23, 0, PileType.FOUNDATION,
            1);
    this.mcmm.move(PileType.CASCADE, 24, 0, PileType.FOUNDATION,
            1);
    this.mcmm.move(PileType.CASCADE, 25, 0, PileType.FOUNDATION,
            1);

    this.mcmm.move(PileType.CASCADE, 26, 0, PileType.FOUNDATION,
            2);
    this.mcmm.move(PileType.CASCADE, 27, 0, PileType.FOUNDATION,
            2);
    this.mcmm.move(PileType.CASCADE, 28, 0, PileType.FOUNDATION,
            2);
    this.mcmm.move(PileType.CASCADE, 29, 0, PileType.FOUNDATION,
            2);
    this.mcmm.move(PileType.CASCADE, 30, 0, PileType.FOUNDATION,
            2);
    this.mcmm.move(PileType.CASCADE, 31, 0, PileType.FOUNDATION,
            2);
    this.mcmm.move(PileType.CASCADE, 32, 0, PileType.FOUNDATION,
            2);
    this.mcmm.move(PileType.CASCADE, 33, 0, PileType.FOUNDATION,
            2);
    this.mcmm.move(PileType.CASCADE, 34, 0, PileType.FOUNDATION,
            2);
    this.mcmm.move(PileType.CASCADE, 35, 0, PileType.FOUNDATION,
            2);
    this.mcmm.move(PileType.CASCADE, 36, 0, PileType.FOUNDATION,
            2);
    this.mcmm.move(PileType.CASCADE, 37, 0, PileType.FOUNDATION,
            2);
    this.mcmm.move(PileType.CASCADE, 38, 0, PileType.FOUNDATION,
            2);

    this.mcmm.move(PileType.CASCADE, 39, 0, PileType.FOUNDATION,
            3);
    this.mcmm.move(PileType.CASCADE, 40, 0, PileType.FOUNDATION,
            3);
    this.mcmm.move(PileType.CASCADE, 41, 0, PileType.FOUNDATION,
            3);
    this.mcmm.move(PileType.CASCADE, 42, 0, PileType.FOUNDATION,
            3);
    this.mcmm.move(PileType.CASCADE, 43, 0, PileType.FOUNDATION,
            3);
    this.mcmm.move(PileType.CASCADE, 44, 0, PileType.FOUNDATION,
            3);
    this.mcmm.move(PileType.CASCADE, 45, 0, PileType.FOUNDATION,
            3);
    this.mcmm.move(PileType.CASCADE, 46, 0, PileType.FOUNDATION,
            3);
    this.mcmm.move(PileType.CASCADE, 47, 0, PileType.FOUNDATION,
            3);
    this.mcmm.move(PileType.CASCADE, 48, 0, PileType.FOUNDATION,
            3);
    this.mcmm.move(PileType.CASCADE, 49, 0, PileType.FOUNDATION,
            3);
    this.mcmm.move(PileType.CASCADE, 50, 0, PileType.FOUNDATION,
            3);
    this.mcmm.move(PileType.CASCADE, 51, 0, PileType.FOUNDATION,
            3);


    assertTrue(mcmm.isGameOver());
    assertEquals("F1: A♥, 2♥, 3♥, 4♥, 5♥, 6♥, 7♥, 8♥, 9♥, 10♥, J♥, Q♥, K♥\n" +
            "F2: A♠, 2♠, 3♠, 4♠, 5♠, 6♠, 7♠, 8♠, 9♠, 10♠, J♠, Q♠, K♠\n" +
            "F3: A♦, 2♦, 3♦, 4♦, 5♦, 6♦, 7♦, 8♦, 9♦, 10♦, J♦, Q♦, K♦\n" +
            "F4: A♣, 2♣, 3♣, 4♣, 5♣, 6♣, 7♣, 8♣, 9♣, 10♣, J♣, Q♣, K♣\n" +
            "O1:\n" +
            "C1:\n" +
            "C2:\n" +
            "C3:\n" +
            "C4:\n" +
            "C5:\n" +
            "C6:\n" +
            "C7:\n" +
            "C8:\n" +
            "C9:\n" +
            "C10:\n" +
            "C11:\n" +
            "C12:\n" +
            "C13:\n" +
            "C14:\n" +
            "C15:\n" +
            "C16:\n" +
            "C17:\n" +
            "C18:\n" +
            "C19:\n" +
            "C20:\n" +
            "C21:\n" +
            "C22:\n" +
            "C23:\n" +
            "C24:\n" +
            "C25:\n" +
            "C26:\n" +
            "C27:\n" +
            "C28:\n" +
            "C29:\n" +
            "C30:\n" +
            "C31:\n" +
            "C32:\n" +
            "C33:\n" +
            "C34:\n" +
            "C35:\n" +
            "C36:\n" +
            "C37:\n" +
            "C38:\n" +
            "C39:\n" +
            "C40:\n" +
            "C41:\n" +
            "C42:\n" +
            "C43:\n" +
            "C44:\n" +
            "C45:\n" +
            "C46:\n" +
            "C47:\n" +
            "C48:\n" +
            "C49:\n" +
            "C50:\n" +
            "C51:\n" +
            "C52:", mcmm.getGameState());
  }

  // fail move multiple cards to foundation/ non valid build in foundation
  @Test(expected = IllegalArgumentException.class)
  public void testMoveMultipleToFoundationFail() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 52, 1, false);

    this.mcmm.move(PileType.CASCADE, 0, 0, PileType.CASCADE, 40);
    this.mcmm.move(PileType.CASCADE, 40, 0,
            PileType.FOUNDATION, 1);

  }

  // fail move multiple cards to open
  @Test(expected = IllegalArgumentException.class)
  public void testMoveMultipleToOpenFail() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 52, 1, false);

    this.mcmm.move(PileType.CASCADE, 0, 0, PileType.CASCADE, 40);
    this.mcmm.move(PileType.CASCADE, 40, 0,
            PileType.OPEN, 0);
  }

  // fail valid build foundation
  @Test(expected = IllegalArgumentException.class)
  public void testFoundationValidBuildFail() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 52, 1, false);

    this.mcmm.move(PileType.CASCADE, 0, 0,
            PileType.FOUNDATION, 0);
    this.mcmm.move(PileType.CASCADE, 2, 0,
            PileType.FOUNDATION, 0);

  }

  // valid build foundation
  @Test
  public void testFoundationValidBuild() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 52, 1, false);

    this.mcmm.move(PileType.CASCADE, 0, 0,
            PileType.FOUNDATION, 0);
    this.mcmm.move(PileType.CASCADE, 1, 0,
            PileType.FOUNDATION, 0);

    assertEquals("F1: A♥, 2♥\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "C1:\n" +
            "C2:\n" +
            "C3: 3♥\n" +
            "C4: 4♥\n" +
            "C5: 5♥\n" +
            "C6: 6♥\n" +
            "C7: 7♥\n" +
            "C8: 8♥\n" +
            "C9: 9♥\n" +
            "C10: 10♥\n" +
            "C11: J♥\n" +
            "C12: Q♥\n" +
            "C13: K♥\n" +
            "C14: A♠\n" +
            "C15: 2♠\n" +
            "C16: 3♠\n" +
            "C17: 4♠\n" +
            "C18: 5♠\n" +
            "C19: 6♠\n" +
            "C20: 7♠\n" +
            "C21: 8♠\n" +
            "C22: 9♠\n" +
            "C23: 10♠\n" +
            "C24: J♠\n" +
            "C25: Q♠\n" +
            "C26: K♠\n" +
            "C27: A♦\n" +
            "C28: 2♦\n" +
            "C29: 3♦\n" +
            "C30: 4♦\n" +
            "C31: 5♦\n" +
            "C32: 6♦\n" +
            "C33: 7♦\n" +
            "C34: 8♦\n" +
            "C35: 9♦\n" +
            "C36: 10♦\n" +
            "C37: J♦\n" +
            "C38: Q♦\n" +
            "C39: K♦\n" +
            "C40: A♣\n" +
            "C41: 2♣\n" +
            "C42: 3♣\n" +
            "C43: 4♣\n" +
            "C44: 5♣\n" +
            "C45: 6♣\n" +
            "C46: 7♣\n" +
            "C47: 8♣\n" +
            "C48: 9♣\n" +
            "C49: 10♣\n" +
            "C50: J♣\n" +
            "C51: Q♣\n" +
            "C52: K♣", mcmm.getGameState());

  }

  // test valid build Cascade after move
  @Test
  public void testCascadeFormValidBuild() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 52, 1, false);

    this.mcmm.move(PileType.CASCADE, 0, 0,
            PileType.CASCADE, 40);
    this.mcmm.move(PileType.CASCADE, 40, 0,
            PileType.CASCADE, 2);

    assertEquals("F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "C1:\n" +
            "C2: 2♥\n" +
            "C3: 3♥, 2♣, A♥\n" +
            "C4: 4♥\n" +
            "C5: 5♥\n" +
            "C6: 6♥\n" +
            "C7: 7♥\n" +
            "C8: 8♥\n" +
            "C9: 9♥\n" +
            "C10: 10♥\n" +
            "C11: J♥\n" +
            "C12: Q♥\n" +
            "C13: K♥\n" +
            "C14: A♠\n" +
            "C15: 2♠\n" +
            "C16: 3♠\n" +
            "C17: 4♠\n" +
            "C18: 5♠\n" +
            "C19: 6♠\n" +
            "C20: 7♠\n" +
            "C21: 8♠\n" +
            "C22: 9♠\n" +
            "C23: 10♠\n" +
            "C24: J♠\n" +
            "C25: Q♠\n" +
            "C26: K♠\n" +
            "C27: A♦\n" +
            "C28: 2♦\n" +
            "C29: 3♦\n" +
            "C30: 4♦\n" +
            "C31: 5♦\n" +
            "C32: 6♦\n" +
            "C33: 7♦\n" +
            "C34: 8♦\n" +
            "C35: 9♦\n" +
            "C36: 10♦\n" +
            "C37: J♦\n" +
            "C38: Q♦\n" +
            "C39: K♦\n" +
            "C40: A♣\n" +
            "C41:\n" +
            "C42: 3♣\n" +
            "C43: 4♣\n" +
            "C44: 5♣\n" +
            "C45: 6♣\n" +
            "C46: 7♣\n" +
            "C47: 8♣\n" +
            "C48: 9♣\n" +
            "C49: 10♣\n" +
            "C50: J♣\n" +
            "C51: Q♣\n" +
            "C52: K♣", mcmm.getGameState());
  }

  // test make valid multiple cards but not enough empty piles to make move
  @Test(expected = IllegalArgumentException.class)
  public void testMaxCardsMovedFail() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 20, 1, false);

    mcmm.move(PileType.CASCADE, 4, 2, PileType.OPEN, 0);
    mcmm.move(PileType.CASCADE, 16, 1, PileType.CASCADE, 4);
    mcmm.move(PileType.CASCADE, 4, 1, PileType.CASCADE, 19);


  }

  // test selected Cards Valid Build fail
  @Test(expected = IllegalArgumentException.class)
  public void testSelectedCardsBuildFail() {
    this.init1();
    FreecellModelCreator.create(FreecellModelCreator.GameType.MULTIMOVE);
    mcmm.startGame(this.deck, 20, 1, false);

    mcmm.move(PileType.CASCADE, 0, 1, PileType.CASCADE, 2);

  }

  // test the single move model
  @Test(expected = IllegalArgumentException.class)
  public void testMoveMultipleFail() {
    this.init1();
    FreecellModel fcm = new FreecellModel();
    FreecellModelCreator.create(FreecellModelCreator.GameType.SINGLEMOVE);
    fcm.startGame(this.deck, 20, 1, false);

    fcm.move(PileType.CASCADE, 15, 1, PileType.CASCADE, 9);
    fcm.move(PileType.CASCADE, 10, 2, PileType.CASCADE, 17);
    assertEquals("", fcm.getGameState());

  }


}