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
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.IOException;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
/**
 * 
 * block class for blocks
 *<p>value of int type for value of the block</p>
 *<p>p textbox for text on the block representing value of block</p>
 *<p>GameClass t is an  instance of GameClass</p>
 *<p>colorn of int type for color of block</p>
 */
public class block extends Rectangle implements Collidable {
	/**
	 * value of the block
	 */
      private int value;
      /**
       * text on the block representing value of block
       */
      private Text p;
      /**
       * instance of GameClass
       */
      private GameClass t;
      /**
       * color of block
       */
      private int colorn;
     
      /**
       * 
       * @param value is the value of the block
       * @param xcoord the xcoordinate of block
       * @param ycoord the ycoordinate of block
       * @param width the width of the block
       * @param height the height of the block
       * @param t reference of GameClass
       */
      
      public block(int value,double xcoord,double ycoord,int width,int height,GameClass t) {
    	  super(xcoord,ycoord,width,height);
    	  this.t=t;
    	  this.value=value;
    	  Random f=new Random();
    	  this.setArcHeight(10);
    	  this.setArcWidth(10);
    	  int u=f.nextInt(4)+9;
    	  this.colorn=u;
    	  
    	  if (u==9) {
    		  this.setFill(Color.PURPLE);
    	  }
    	  else if(u==10) {
    		  this.setFill(Color.YELLOW);
    	  }
    	  else if(u==11) {
    		  this.setFill(Color.RED);
    	  }
    	  else if(u==12) {
    		  this.setFill(Color.ORANGE);
    	  }
    	  
    	  this.p=new Text(Integer.toString(value));
			this.p.setX(xcoord+25);
			this.p.setY(ycoord+25);
			
			
			this.p.setFill(Color.BLACK);
			
			//this.p.setStyle("-fx-color: green");
		 // p.setFill(Color.BLACK);
		  
		  //p.setStyle("-fx-color: green");
	
     
		  
		  
		  
		  
		  
    	  
    	  
    	  
    	  
    	  
    	  
      }
      /**
       * 
       * @return color of the block
       * 
       */
      public int getc() {
    	  return this.colorn;
      }
      /**
       * 
       * @return text on the block representing value of block
       */
      public Text gettex() {
    	  return this.p;
      }
      /**
       * 
       * @return value of the block
       */
      public int getvalue() {
    	  return this.value;
      }
      /**
       * 
       * @param g sets the value of the block
       */
      public void setvalue(int g) {
    	  this.value=g;
      }

	/**
	 * <p>Bursting animation of block when snake collides with a block and decreasing snake length accordingly</p>
	 * @param s snake on the game screen
	 */
	public void collide(snake s) {
		this.setOpacity(0);
		this.gettex().setOpacity(0);

		try {
			if (s.getsp()==false) {
				s.decl(this.value);
				
			}
		}
		catch(IOException ex) {
			System.out.println("exception caughtg");
			ex.printStackTrace();
		}
		catch( ClassNotFoundException EX2) {
			System.out.println("exception caughtgg");
		}
		
		
		Rectangle g=new Rectangle(this.getX(),200,5,5);
    	Rectangle h=new Rectangle(this.getX(),200,5,5);
    	Rectangle i=new Rectangle(this.getX(),200,5,5);
    	Rectangle j=new Rectangle(this.getX(),200,5,5);
    	Rectangle k=new Rectangle(this.getX(),200,5,5);
    	Rectangle l=new Rectangle(this.getX(),200,5,5);
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
		t.bp().getChildren().remove(this);
		t.bp().getChildren().remove(this.gettex());
		
	}
      
    
      
      

}


