package cs3500.hw03;

import java.io.InputStreamReader;

import cs3500.hw02.FreecellModel;

/**
 * The main method that runs the console.
 */
public class Main {
  /**
   *
   * @param args The arguements passed into the main method.
   */
  public static void main(String[] args) {
    FreecellModel model = new FreecellModel();
    FreecellController controller = new FreecellController(new InputStreamReader(System.in),
            System.out);
    controller.getGoing();
  }
}
