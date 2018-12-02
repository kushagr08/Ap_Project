package snake_vs_block_5;


import javafx.application.Application;
import javafx.scene.image.*;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.animation.Animation.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import java.util.*;


import javafx.scene.text.*;
import javafx.scene.control.*;


/**
 * ball class for ball token
 *<p>value of int type for value of the ball</p>
 *<p>text on ball for value of ball</p>
 *<p>GameClass t for associated gameclass instance of the ball</p>
 *<p>colorn of int type for ball's color number</p>
 */
public class ball extends Circle implements Collidable{
	
	/**
	 * value of the ball
	 */
	private int value;
	/**
	 * text box of the ball
	 */
	private Text p;
	/**
	 * associated gameclass instance of the ball
	 */
	private GameClass t;
	/**
	 * ball's color number.
	 */
	private int colorn;
	
	
	
	/**
	 * @param r value of the ball
	 * @param a initial xcoordinate of the centre of the ball
	 * @param b initial ycoordinate of the centre of the ball
	 * @param t instance of GameClass with which the ball is associated
	 * 
	 * <p>the ball constructor assigns radius,position and random color to the ball</p>
	 * 
	 */
	public ball(int r,double a,double b,GameClass t) {
		
		super();
		Random y=new Random();
		int s=y.nextInt(4)+13;
		this.colorn=s;
		if (this.colorn==13) {
			this.setFill(Color.CORAL);
			
		}
		
		else if (this.colorn==14) {
			this.setFill(Color.BROWN);
		}
		
		else if (this.colorn==15) {
			this.setFill(Color.GREEN);
		}
		
		else if (this.colorn==16) {
			this.setFill(Color.VIOLET);
		}
		
		this.t=t;
		this.value=r;
		this.p=new Text(Integer.toString(value));
		p.setX(a);
		p.setY(b+15);
		t.bp().getChildren().add(p);
		this.setRadius(8);
		this.setCenterX(a);
		this.setCenterY(b);
		
		
		
		
		
	}
	
	/**
	 * @return value of the ball
	 */
	public int getvalue() {
		return this.value;
	}
	
	
	
	/**
	 * @param r to set the color of the ball after deserialization
	 */
	public void setcolorn(int r) {
		if (r==13) {
			this.setFill(Color.CORAL);
		}
		
		else if (r==14) {
			this.setFill(Color.BROWN);
		}
		
		else if (r==15) {
			this.setFill(Color.GREEN);
		}
		
		else if (r==16) {
			this.setFill(Color.VIOLET);
		}
	}
	
	
	
	/**
	 * @return getter for ball color number
	 */
	public int colorn() {
		return this.colorn;
	}
	
	
	/**
	 * @return getter for textbox of ball having it's value
	 */
	public Text gettex() {
		return this.p;
	}
	
	/** 
	 * 	 * <p>collision of a ball with snake leads to increment of snake's length by the length of the ball.</p>
	 * <p>Also snake has same color as that of the lastest ball it collides with</p>
	 * <p>ball implements collidable interface</p>

	 */
	@Override
	public void collide(snake s) {
		this.setOpacity(0);
		this.gettex().setOpacity(0);
		s.incl(this.value,this.colorn);
		Rectangle g=new Rectangle(this.getCenterX(),200,5,5);
    	Rectangle h=new Rectangle(this.getCenterX(),200,5,5);
    	Rectangle i=new Rectangle(this.getCenterX(),200,5,5);
    	Rectangle j=new Rectangle(this.getCenterX(),200,5,5);
    	Rectangle k=new Rectangle(this.getCenterX(),200,5,5);
    	Rectangle l=new Rectangle(this.getCenterX(),200,5,5);
	    g.setFill(Color.BLACK);

	    g.setStroke(Color.YELLOW);
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
    	t.bp().getChildren().add(g);
    	t.bp().getChildren().add(h);
    	t.bp().getChildren().add(i);
    	t.bp().getChildren().add(j);
    	t.bp().getChildren().add(k);
    	t.bp().getChildren().add(l);
    	KeyValue r1=new KeyValue(g.xProperty(),g.getX()-40);
    	KeyValue r2=new KeyValue(g.yProperty(),g.getY()-40);
    	KeyValue r3=new KeyValue(h.xProperty(),h.getX()+40);
    	KeyValue r4=new KeyValue(h.yProperty(),h.getY()+40);
    	KeyValue r5=new KeyValue(i.xProperty(),i.getX()-40);
    	KeyValue r6=new KeyValue(i.yProperty(),i.getY()+40);
    	KeyValue r7=new KeyValue(j.xProperty(),j.getX()+40);
    	KeyValue r8=new KeyValue(j.yProperty(),j.getY()-40);
    	KeyValue r9=new KeyValue(k.yProperty(),k.getY()+40);
    	KeyValue r10=new KeyValue(l.yProperty(),l.getY()-40);
    	KeyValue r11=new KeyValue(g.opacityProperty(),0);
    	KeyValue r12=new KeyValue(h.opacityProperty(),0);
    	KeyValue r13=new KeyValue(i.opacityProperty(),0);
    	KeyValue r14=new KeyValue(j.opacityProperty(),0);
    	KeyValue r15=new KeyValue(k.opacityProperty(),0);
    	KeyValue r16=new KeyValue(l.opacityProperty(),0);
    	KeyFrame rr=new KeyFrame(Duration.millis(1000),r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16);
    	Timeline xx=new Timeline();
    	xx.getKeyFrames().add(rr);
    	xx.play();
    	t.bp().getChildren().remove(this.gettex());
    	t.bp().getChildren().remove(this);
		
		
	
		
	}
	
	
	
	
	
	

}
