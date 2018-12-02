package snake_vs_block_5;


import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.image.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.animation.Animation;
import javafx.animation.Animation.*;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.FileInputStream;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

/**
 * <p>Shield class for shield token</p>
 *<p>image for the shield image</p>
 *<p>imageview for image of shield</p>
 *<p>GameClass t is an  instance of GameClass</p>
 *<p>time represents the time duration for which shield property will be active</p>
 */
public class shield implements Collidable {
	/**
	 * instance of GameClass
	 */
	private GameClass t;
	/**
	 * image for the shield image
	 */
	private Image image;
	/**
	 * imageview for image of shield
	 */
	private ImageView imageview;
	/**
	 * represents the time duration for which shield property will be active
	 */
	private final int time=8;
	/**
	 * 
	 * @param x X-Coordinate of the coin image
	 * @param y Y-Coordinate of the coin image
	 * @param t GameClass instance
	 */
	public shield(double x,double y,GameClass t)  {
		try {
			this.t=t;
		this.image = new Image(new FileInputStream("shield2.jpg")); 
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
	 * @return Returns the image of shield
	 */
	public Image getim() {
		return this.image;
	}
	/**
	 * 
	 * @return Returns the Imageview for shield
	 */
	public ImageView getimv() {
		return this.imageview;
	}
	/**
	 * <p>Animation for shield when it snake collides with it</p>
	 * @param s Snake on the game screen  
	 */
	@Override
	public void collide(snake s) {
		this.imageview.setOpacity(0);
		Timeline g=new Timeline();
		s.setsp(true);
		KeyFrame ss=new KeyFrame(Duration.seconds(8),new EventHandler<ActionEvent>() {
	        public void handle(ActionEvent event) {
	        	s.setsp(false);
	            
	        }
	    });
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
		g.getKeyFrames().add(ss);
		g.play();
		Timeline xx=new Timeline();
		xx.getKeyFrames().add(rr);
    	xx.play();
		
		
		
		
	}


}
