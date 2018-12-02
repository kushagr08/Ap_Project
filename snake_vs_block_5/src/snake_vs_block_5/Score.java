package snake_vs_block_5;
import java.util.*;
import java.io.Serializable;
/**
 * <p>Score class for score of the player</p>
 * @author abhiv
 *<p>points of int type represents the point scored by player</p>
 *<p>dateOfGame of date type  is the date of played game</p>
 */

public class Score implements Serializable {
	/**
	 * represents the point scored by player
	 */
  private int points;
  /**
   * date of played game
   */
  private Date dateOfGame;
  /**
   * Class constructor initializes score and date
   */
  public Score() {
	  points=0;
	  dateOfGame=new Date();
  }
  /**
   * 
   * @return returns player points
   */
  public int getPoints() {
	  return points;
  }
  /**
   * 
   * @param x Increments the player points by 'x'
   */
  public void addTopoints(int x) {
	  points+=x;
  }
  /**
   * 
   * @return Returns date and time of game play
   */
  public Date getDate() {
	  return dateOfGame;
  }
}
