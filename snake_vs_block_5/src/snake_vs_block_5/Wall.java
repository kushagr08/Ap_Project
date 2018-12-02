package snake_vs_block_5;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
/**
 * <p>Wall class for walls</p>
 * <p>length of double type is the length of wall</p>
 * 
 * @author abhiv
 *
 */
public class Wall extends Rectangle   {
	/**
	 * length of wall
	 */
	private double length;
	/**
	 * 
	 * @return length of wall
	 */
	public double getl() {
		return this.length;
	}
	/**
	 * 
	 * @param xWall xcoordinate of wall on the screen
	 * @param yWall ycoordinate of wall on the screen
	 * @param l lenf=gth of wall to be created
	 */
	public Wall(double xWall,double yWall,double l) {
		super(xWall,yWall,5,l);
		this.setFill(Color.WHITE);
		this.length=l;
	}
	
	
}