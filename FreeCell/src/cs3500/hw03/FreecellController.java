package cs3500.hw03;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import cs3500.hw02.Card;
import cs3500.hw02.FreecellModel;
import cs3500.hw02.FreecellOperations;
import cs3500.hw02.PileType;

public class FreecellController implements IFreecellController<Card> {
  private FreecellOperations model;
  private Readable rd;
  private Appendable ap;
  private Scanner scan;

  /**
   * @param rd What the scanner is reading in.
   * @param ap What the scanner is outputing to the console.
   */

  public FreecellController(Readable rd, Appendable ap) {
    this.model = new FreecellModel();
    if (rd == null || ap == null) {
      throw new IllegalStateException();
    }
    this.ap = ap;

    scan = new Scanner(rd);
  }

  // runs the game by passing it to the controller

  @Override
  public void playGame(List<Card> deck, FreecellOperations<Card> model, int numCascades,
                       int numOpens, boolean shuffle) {


    if (deck == null || model == null) {
      throw new IllegalArgumentException("the game was not started correctly");
    }

    String source = "";
    char sourcePile = '-';
    int sourceNumber = 0;
    int cardIndex = 0;
    String dest = "";
    char destPile = '-';
    int destNumber = 0;
    int actualIndex = 0;

    try {
      this.model.startGame(model.getDeck(), numCascades, numOpens, shuffle);
    } catch (IllegalArgumentException e) {
      write("Could not start game.");
      return;
    }


    try {
      ap.append(model.getGameState());
    } catch (IOException e) {
      return;
    }


    while (!this.model.isGameOver()) {


      // if the game is ongoing, waiting for valid user move
      while (sourcePile == '-') {
        write("\nEnter the Source Pile(i.e. C1):");

        source = scan.next();


        if (source.equals("Q") || source.equals("q")) {
          write("\nGame quit prematurely.");
          return;
        }

        int sourcePileNumberInput = 0;

        if ((source.length() > 1) && ((source.charAt(0) == 'C') || (source.charAt(0) == 'O') ||
                source.charAt(0) == ('F'))) {

          sourcePile = source.charAt(0);
          String s = source.substring(1);
          try {
            sourcePileNumberInput = Integer.parseInt(s) - 1;
          } catch (NumberFormatException e) {
            sourcePile = '-';
          }

          sourceNumber = sourcePileNumberInput;

        }
      }


      while ((cardIndex == 0)) {
        write("\nEnter the card Index:");

        if (scan.hasNext()) {

          String s = scan.next();


          try {
            if (s.charAt(0) == 'Q' || s.charAt(0) == 'q') {
              write("\nGame quit prematurely.");
              return;
            }
            actualIndex = Integer.parseInt(s) - 1;
            cardIndex = Integer.parseInt(s);
          } catch (NumberFormatException e) {
            cardIndex = 0;
          }
        }
      }


      while (destPile == '-') {
        write("\nEnter the Destination Pile(i.e. C1):");

        dest = scan.next();


        if (dest.equals("Q") || dest.equals("q")) {
          write("\nGame quit prematurely.");
          return;
        }

        int destPileNumberInput = 0;

        if ((dest.length() > 1) && ((dest.charAt(0) == 'C') || (dest.charAt(0) == 'O') ||
                dest.charAt(0) == ('F'))) {

          destPile = dest.charAt(0);
          String s = dest.substring(1);

          try {
            destPileNumberInput = Integer.parseInt(s) - 1;
          } catch (NumberFormatException e) {
            destPile = '-';
          }
          destNumber = destPileNumberInput;
        }
      }


      try {
        model.move(charPileType(sourcePile), sourceNumber, actualIndex,
                charPileType(destPile), destNumber);
      } catch (IllegalArgumentException e) {
        write("\nInvalid Move Try Again...\n");
        source = "";
        sourcePile = '-';
        sourceNumber = 0;
        cardIndex = 0;
        dest = "";
        destPile = '-';
        destNumber = 0;
        actualIndex = 0;
        continue;
      }

      try {
        ap.append("\n" + model.getGameState() + "\n");
      } catch (IOException e) {
        continue;
      }
      source = "";
      sourcePile = '-';
      sourceNumber = 0;
      cardIndex = 0;
      dest = "";
      destPile = '-';
      destNumber = 0;
      actualIndex = 0;

      if (model.isGameOver()) {
        write("You Won the Game!");
      }
    }
  }


  // helper to determine which character from the user input represents which PileType

  private PileType charPileType(char c) {

    if (c == 'F') {
      return PileType.FOUNDATION;

    }
    if (c == 'O') {
      return PileType.OPEN;
    }
    if (c == 'C') {
      return PileType.CASCADE;
    } else {
      throw new IllegalArgumentException("no such pileType");
    }
  }


  // helper to catch the exceptions and write the message
  private void write(String msg) {
    try {
      ap.append(msg);
    } catch (IOException e) {
      return;
    }
  }

  // does this type of pile have a valid number of piles?
  private boolean hasCorrectNumPiles(int numPiles, int lower, int upper) {
    boolean temp = false;
    temp = !(numPiles < lower || numPiles > upper);
    return temp;
  }

  /**
   * Starts the game by asking the user to input cascades, opens, shuffled.
   */
  // everything to start the game
  public void getGoing() {
    int cascades = 0;
    int opens = 0;
    boolean shuffleOutput = false;

    while ((cascades == 0)) {
      write("Enter the number of cascade piles:\n");

      if (scan.hasNext()) {
        String s = scan.next();
        try {
          cascades = Integer.parseInt(s);
        } catch (NumberFormatException e) {
          cascades = 0;
        }
        if (!hasCorrectNumPiles(cascades, 4, 52)) {
          cascades = 0;
        }
      }
    }


    while ((opens == 0)) {
      write("Enter the number of Open piles:\n");

      if (scan.hasNext()) {
        String s = scan.next();
        try {
          opens = Integer.parseInt(s);
        } catch (NumberFormatException e) {
          opens = 0;
        }
        if (!hasCorrectNumPiles(opens, 1, 52)) {
          opens = 0;
        }
      }
    }


    write("Do you want the Deck to be Shuffled? (enter true or false)\n");

    String temp1 = scan.next();
    while (!(temp1.equals("true") || temp1.equals("false"))) {
      write("Do you want the Deck to be Shuffled? (enter true or false)\n");
      temp1 = scan.next();
    }
    shuffleOutput = Boolean.parseBoolean(temp1);


    this.playGame(this.model.getDeck(), this.model, cascades, opens, shuffleOutput);

  }

}

