package cs3500.hw03;

import java.util.List;

import cs3500.hw02.FreecellOperations;

/**
 * Created by elilerner on 2/2/17.
 */
public interface IFreecellController<K> {

  /**
   *
   * @param deck the FreeCell Model to be dealt.
   * @param model starts a new game given the provided model.
   * @param numCascades the number of cascade piles to be specified by the user.
   * @param numOpens the number of open piles to be specified by the user.
   * @param shuffle should the deck be shuffled?
   */
  void playGame(List<K> deck, FreecellOperations<K> model, int numCascades,
                int numOpens, boolean shuffle);

}