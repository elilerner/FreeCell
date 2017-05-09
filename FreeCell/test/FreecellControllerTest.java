import org.junit.Test;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;

import cs3500.hw02.FreecellModel;
import cs3500.hw03.FreecellController;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class FreecellControllerTest {
  FreecellModel model = new FreecellModel();
  Readable read = new InputStreamReader(System.in);
  Appendable append = new OutputStreamWriter(System.out);
  FreecellController controller = new FreecellController(read, append);


  @Test
  public void playGameTest1() {
    String input = "6 4 false q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();


    assertEquals("Enter the number of cascade piles:\n" +
            "Enter the number of Open piles:\n" +
            "Do you want the Deck to be Shuffled? (enter true or false)\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♥, 7♥, K♥, 6♠, Q♠, 5♦, J♦, 4♣, 10♣\n" +
            "C2: 2♥, 8♥, A♠, 7♠, K♠, 6♦, Q♦, 5♣, J♣\n" +
            "C3: 3♥, 9♥, 2♠, 8♠, A♦, 7♦, K♦, 6♣, Q♣\n" +
            "C4: 4♥, 10♥, 3♠, 9♠, 2♦, 8♦, A♣, 7♣, K♣\n" +
            "C5: 5♥, J♥, 4♠, 10♠, 3♦, 9♦, 2♣, 8♣\n" +
            "C6: 6♥, Q♥, 5♠, J♠, 4♦, 10♦, 3♣, 9♣\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Game quit prematurely.", writer.toString());

    assertEquals(true, writer.toString().contains("Game quit prematurely."));
  }


  @Test
  public void playGameTest2() {
    String input = "6 4 false C1 9 O2 q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();

    assertEquals("Enter the number of cascade piles:\n" +
            "Enter the number of Open piles:\n" +
            "Do you want the Deck to be Shuffled? (enter true or false)\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2:\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♥, 7♥, K♥, 6♠, Q♠, 5♦, J♦, 4♣, 10♣\n" +
            "C2: 2♥, 8♥, A♠, 7♠, K♠, 6♦, Q♦, 5♣, J♣\n" +
            "C3: 3♥, 9♥, 2♠, 8♠, A♦, 7♦, K♦, 6♣, Q♣\n" +
            "C4: 4♥, 10♥, 3♠, 9♠, 2♦, 8♦, A♣, 7♣, K♣\n" +
            "C5: 5♥, J♥, 4♠, 10♠, 3♦, 9♦, 2♣, 8♣\n" +
            "C6: 6♥, Q♥, 5♠, J♠, 4♦, 10♦, 3♣, 9♣\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Enter the card Index:\n" +
            "Enter the Destination Pile(i.e. C1):\n" +
            "F1:\n" +
            "F2:\n" +
            "F3:\n" +
            "F4:\n" +
            "O1:\n" +
            "O2: 10♣\n" +
            "O3:\n" +
            "O4:\n" +
            "C1: A♥, 7♥, K♥, 6♠, Q♠, 5♦, J♦, 4♣\n" +
            "C2: 2♥, 8♥, A♠, 7♠, K♠, 6♦, Q♦, 5♣, J♣\n" +
            "C3: 3♥, 9♥, 2♠, 8♠, A♦, 7♦, K♦, 6♣, Q♣\n" +
            "C4: 4♥, 10♥, 3♠, 9♠, 2♦, 8♦, A♣, 7♣, K♣\n" +
            "C5: 5♥, J♥, 4♠, 10♠, 3♦, 9♦, 2♣, 8♣\n" +
            "C6: 6♥, Q♥, 5♠, J♠, 4♦, 10♦, 3♣, 9♣\n" +
            "\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Game quit prematurely.", writer.toString());

  }

  @Test
  public void playGameTest3() {
    String input = "52 4 false C1 1 F1 q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();


    assertEquals("Enter the number of cascade piles:\n" +
            "Enter the number of Open piles:\n" +
            "Do you want the Deck to be Shuffled? (enter true or false)\n" +
            "F1:\n" +
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
            "C52: K♣\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Enter the card Index:\n" +
            "Enter the Destination Pile(i.e. C1):\n" +
            "F1: A♥\n" +
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
            "C52: K♣\n" +
            "\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Game quit prematurely.", writer.toString());

  }

  @Test
  public void playGameTest4() {
    String input = "52 4 false C1 1 F1 F1 1 O1 q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();

    assertEquals("Enter the number of cascade piles:\n" +
            "Enter the number of Open piles:\n" +
            "Do you want the Deck to be Shuffled? (enter true or false)\n" +
            "F1:\n" +
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
            "C52: K♣\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Enter the card Index:\n" +
            "Enter the Destination Pile(i.e. C1):\n" +
            "F1: A♥\n" +
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
            "C52: K♣\n" +
            "\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Enter the card Index:\n" +
            "Enter the Destination Pile(i.e. C1):\n" +
            "F1:\n" +
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
            "C52: K♣\n" +
            "\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Game quit prematurely.", writer.toString());

  }

  @Test
  public void playGameTest5() {
    String input = "52 4 false C1 1 F1 C14 1 F2 C27 1 F3 C40 1 F4 q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();

    assertEquals("Enter the number of cascade piles:\n" +
            "Enter the number of Open piles:\n" +
            "Do you want the Deck to be Shuffled? (enter true or false)\n" +
            "F1:\n" +
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
            "C52: K♣\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Enter the card Index:\n" +
            "Enter the Destination Pile(i.e. C1):\n" +
            "F1: A♥\n" +
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
            "C52: K♣\n" +
            "\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Enter the card Index:\n" +
            "Enter the Destination Pile(i.e. C1):\n" +
            "F1: A♥\n" +
            "F2: A♠\n" +
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
            "C14:\n" +
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
            "C52: K♣\n" +
            "\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Enter the card Index:\n" +
            "Enter the Destination Pile(i.e. C1):\n" +
            "F1: A♥\n" +
            "F2: A♠\n" +
            "F3: A♦\n" +
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
            "C14:\n" +
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
            "C27:\n" +
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
            "C52: K♣\n" +
            "\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Enter the card Index:\n" +
            "Enter the Destination Pile(i.e. C1):\n" +
            "F1: A♥\n" +
            "F2: A♠\n" +
            "F3: A♦\n" +
            "F4: A♣\n" +
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
            "C14:\n" +
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
            "C27:\n" +
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
            "C40:\n" +
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
            "C52: K♣\n" +
            "\n" +
            "Enter the Source Pile(i.e. C1):\n" +
            "Game quit prematurely.", writer.toString());

  }


  // if a card other than an Ace is attempted to be placed in a Foundation pile.
  @Test
  public void testplayGameError1() {
    String input = "52 4 false " +
            "C2 1 F1 q";


    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();

    assertEquals(true, writer.toString().contains("Invalid Move Try Again..."));
  }


  // if the the user inputs a pile number that does not exist
  @Test
  public void testplayGameError2() {
    String input = "8 4 false " +
            "C9 8 O1 q";


    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();

    assertEquals(true, writer.toString().contains("Invalid Move Try Again..."));

  }

  // if the user inputs a pile number that is not valid
  @Test
  public void testplayGameError3() {
    String input = "8 4 false " +
            "C-1 8 O1 q";


    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();

    assertEquals(true, writer.toString().contains("Invalid Move Try Again..."));

  }

  // if the game is not started with valid inputs(number of piles)
  @Test
  public void testplayGameError4() {
    String input = "8 4 false Q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);


    c.playGame(m.getDeck(), m, 53, 4, true);
    assertEquals(true, writer.toString()
            .contains("Could not start game."));
  }


  // if the game is not started with valid inputs(number of piles)
  @Test
  public void testplayGameError5() {
    String input = "8 4 false q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);


    c.playGame(m.getDeck(), m, 50, 53, true);
    assertEquals(true, writer.toString()
            .contains("Could not start game."));
  }

  // test for invalid moves
  @Test
  public void testInvalidMoves() {
    String input = "52 4 false O2 1 F1 q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();
    assertEquals(true, writer.toString()
            .contains("Invalid Move Try Again..."));
  }

  // test for invalid moves
  @Test
  public void testInvalidMoves2() {
    String input = "52 4 false C2 1 F2 q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();
    assertEquals(true, writer.toString()
            .contains("Invalid Move Try Again..."));
  }

  // quit the game
  @Test
  public void testquitGame() {
    String input = "52 4 false C2 q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();
    assertEquals(true, writer.toString()
            .contains("Game quit prematurely."));
  }

  // quit the game
  @Test
  public void testquitGame1() {
    String input = "52 4 false C2 Q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();
    assertEquals(true, writer.toString()
            .contains("Game quit prematurely."));
  }

  // quit the game
  @Test
  public void testquitGame3() {
    String input = "52 4 true C1 1 q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();
    assertEquals(true, writer.toString()
            .contains("Game quit prematurely."));
  }

  // quit the game
  @Test
  public void testquitGame4() {
    String input = "52 4 false C1 1 F1 q";

    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();
    assertEquals(true, writer.toString()
            .contains("Game quit prematurely."));
  }


  // if the user inputs a pile number that is not valid
  @Test
  public void testShuffle() {
    String input1 = "8 4 true Q";
    String input2 = "8 4 false Q";

    Appendable writer1 = new StringWriter();
    Appendable writer2 = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c1 = new FreecellController(new StringReader(input1), writer1);
    FreecellController c2 = new FreecellController(new StringReader(input2), writer2);
    c1.getGoing();
    c2.getGoing();

    assertNotEquals(writer1.toString(), writer2.toString());

  }

  //to test that the game has been won
  @Test
  public void winGameTest() {
    String input =
            "52 4 false C1 1 F1 C2 1 F1 C3 1 F1 C4 1 F1" +
                    " C5 1 F1 C6 1 F1 C7 1 F1 C8 1 F1 C9 1 F1 C10 1 F1 C11 1 F1 C12 1 F1 C13 1 F1" +
                    " C14 1 F2 C15 1 F2 C16 1 F2 C17 1 F2 C18 1 F2 C19 1 F2" +
                    " C20 1 F2 C21 1 F2 C22 1 F2 C23 1 F2 C24 1 F2 C25 1 F2 C26 1 F2 " +
                    "C27 1 F3 C28 1 F3 C29 1 F3 C30 1 F3 C31 1 F3 C32 1 F3 C33 1 F3 C34 1 F3" +
                    " C35 1 F3 C36 1 F3 C37 1 F3 C38 1 F3 C39 1 F3" +
                    " C40 1 F4 C41 1 F4 C42 1 F4 C43 1 F4 C44 1 F4 C45 1 F4 C46 1 F4 C47 1 F4" +
                    " C48 1 F4 C49 1 F4 C50 1 F4 C51 1 F4 C52 1 F4";


    Appendable writer = new StringWriter();

    FreecellModel m = new FreecellModel();
    FreecellController c = new FreecellController(new StringReader(input), writer);
    c.getGoing();

    assertEquals(true, writer.toString().contains("You Won the Game!"));
  }

}
