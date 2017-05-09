package cs3500.hw04;

import cs3500.hw02.FreecellModel;
import cs3500.hw02.FreecellOperations;


// the FreeCell Model creator class that allows for selection between models
public class FreecellModelCreator extends FreecellModel {
  static FreecellModel fcm = new FreecellModel();
  static MultiCardMoveModel mcmm = new MultiCardMoveModel();


  // returns the selected move model type
  public enum GameType {

    SINGLEMOVE(fcm), MULTIMOVE(mcmm);
    public FreecellModel gameType1;
    public MultiCardMoveModel gameType2;

    GameType(FreecellModel fcm) {
      this.gameType1 = fcm;
    }

    GameType(MultiCardMoveModel mcmm) {
      this.gameType2 = mcmm;
    }
  }


  /**
   * @param gameType the gameType Model to be used.
   * @return game with the specified move model.
   */
  public static FreecellOperations create(GameType gameType) {

    FreecellOperations fco = new FreecellModel();

    if (gameType == GameType.SINGLEMOVE) {
      fco = new FreecellModel();
    }
    if (gameType == GameType.MULTIMOVE) {
      fco = new MultiCardMoveModel();
    }
    return fco;
  }
}
