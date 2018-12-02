package snake_vs_block_5;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * 
 *<p>destroyblock class for destroyblock token</p>
 *<p>image for the coin image</p>
 *<p>imageview for image of coin</p>
 *
 */
public class destroyblock implements Collidable  {
	/**
	 * image for the coin image
	 * 
	 */
	private Image image;
	/**
	 * imageview for image of coin
	 */
	private ImageView imageview;
	/**
	 * 
	 * @param x xcoordinate of the destroyblock token
	 * @param y ycoordinate of the destroyblock token
	 */
	public destroyblock(double x,double y)  {
		try {
		this.image = new Image(new FileInputStream("explode.gif_c200")); 
	    this.imageview = new ImageView(image); 
	    this.imageview.setX(x); 
	    this.imageview.setY(y); 
	    this.imageview.setFitHeight(60); 
	    this.imageview.setFitWidth(60);
		}
		catch (Exception e) {
			
		}
	}
	/**
	 * 
	 * @return image of the coin
	 */
	
	public Image getim() {
		return this.image;
	}
	
	/**
	 * 
	 * @return imageview of the coin
	 */
	public ImageView getimv() {
		return this.imageview;
	}
	/**
	 * <p>Animation of destroyblock token when snake collides with it</p>
	 * @param s snake on the gamescreen
	 */
	@Override
	public void collide(snake s) {
		this.imageview.setOpacity(0);
		
		
		
	}

}

