package snake_vs_block_5;




import java.io.FileInputStream;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
/**
 * <p>Coin class for coin token</p>
 *<p>image for the coin image</p>
 *<p>imageview for image of coin</p>
 *<p>GameClass t is an  instance of GameClass</p>
 *<p>distancesq of int type is square of the max distance of coin from magnet for it to be collected by snake</p>
 */
public class Coin implements Collidable {
	/**
	 * image for the coin image
	 */
	private Image image;
	/**
	 * imageview for image of coin
	 */
	private ImageView imageview;
	/**
	 * instance of GameClass
	 */
	private GameClass t;
	/**
	 * square of the max distance of coin from magnet for it to be collected by snake
	 */
	private final int distancesq=20000;
	/**
	 * 
	 * @param x xcoordinate of coin image
	 * @param y ycoordinate of coin image
	 * @param t reference of the the GameClass
	 */
	public Coin(double x,double y,GameClass t)  {
		try {
			this.t=t;
		this.image = new Image(new FileInputStream("coin2.jpg")); 
	    this.imageview = new ImageView(image); 
	    this.imageview.setX(x); 
	    this.imageview.setY(y); 
	    this.imageview.setFitHeight(40); 
	    this.imageview.setFitWidth(40);
		}
		catch (Exception e) {
			
		}
	}
	/**
	 * 
	 * @return image of the coin
	 */
	public Image getim() {
		return image;
	}
	/**
	 *  
	 * @return imageview of the coin
	 */
	public ImageView getimv() {
		return imageview;
	}
	
	
	
	/**
	 * <p>Animation for coin when snake collides with it</p>
	 * @param s Snake on the game screen  
	 */
	@Override
	public void collide(snake s) {
		this.imageview.setOpacity(0);
		Rectangle gg=new Rectangle(this.imageview.getX(),200,5,5);
    	Rectangle h=new Rectangle(this.imageview.getX(),200,5,5);
    	Rectangle i=new Rectangle(this.imageview.getX(),200,5,5);
    	Rectangle j=new Rectangle(this.imageview.getX(),200,5,5);
    	Rectangle k=new Rectangle(this.imageview.getX(),200,5,5);
    	Rectangle l=new Rectangle(this.imageview.getX(),200,5,5);
	    gg.setFill(Color.BLACK);

	    gg.setStroke(Color.YELLOW);
	    h.setFill(Color.BLACK);

	    h.setStroke(Color.YELLOW);
	    i.setFill(Color.BLACK);

	    i.setStroke(Color.YELLOW);
	    j.setFill(Color.BLACK);

	    j.setStroke(Color.YELLOW);
	    k.setFill(Color.BLACK);

	    k.setStroke(Color.YELLOW);
	    l.setFill(Color.BLACK);

	    l.setStroke(Color.YELLOW);
    t.bp().getChildren().add(gg);
    	t.bp().getChildren().add(h);
    	t.bp().getChildren().add(i);

    	t.bp().getChildren().add(j);

    	t.bp().getChildren().add(k);

    	t.bp().getChildren().add(l);

    	
    	KeyValue r1=new KeyValue(gg.xProperty(),gg.getX()-40);
    	KeyValue r2=new KeyValue(gg.yProperty(),gg.getY()-40);
    	KeyValue r3=new KeyValue(h.xProperty(),h.getX()+40);
    	KeyValue r4=new KeyValue(h.yProperty(),h.getY()+40);
    	KeyValue r5=new KeyValue(i.xProperty(),i.getX()-40);
    	KeyValue r6=new KeyValue(i.yProperty(),i.getY()+40);
    	KeyValue r7=new KeyValue(j.xProperty(),j.getX()+40);
    	KeyValue r8=new KeyValue(j.yProperty(),j.getY()-40);
    	KeyValue r9=new KeyValue(k.yProperty(),k.getY()+40);
    	KeyValue r10=new KeyValue(l.yProperty(),l.getY()-40);
    	KeyValue r11=new KeyValue(gg.opacityProperty(),0);
    	KeyValue r12=new KeyValue(h.opacityProperty(),0);
    	KeyValue r13=new KeyValue(i.opacityProperty(),0);
    	KeyValue r14=new KeyValue(j.opacityProperty(),0);
    	KeyValue r15=new KeyValue(k.opacityProperty(),0);
    	KeyValue r16=new KeyValue(l.opacityProperty(),0);
    	KeyFrame rr=new KeyFrame(Duration.millis(1000),r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16);
    	Timeline xx=new Timeline();
		xx.getKeyFrames().add(rr);
    	xx.play();
		t.bp().getChildren().remove(this);
		
		
		
	}

}