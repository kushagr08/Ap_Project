package application;
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
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.control.*;

public class block extends Rectangle implements Runnable {
      private int value;
      private Text p;
      
      
      public block(int value,Color color,int xcoord,int ycoord,int width,int height) {
    	  super(xcoord,ycoord,width,height);
    	  this.value=value;
    	  this.p=new Text(Integer.toString(value));
			this.p.setX(xcoord+25);
			this.p.setY(ycoord+25);
			
			
			this.p.setFill(Color.GREEN);
			
			this.p.setStyle("-fx-color: green");
		 // p.setFill(Color.BLACK);
		  
		  //p.setStyle("-fx-color: green");
	
     
		  
		  
		  
		  
		  
    	  
    	  
    	  
    	  
    	  
    	  
      }
      
      public Text gettex() {
    	  return this.p;
      }

	@Override
	public void run() {
		
		
	}
	public void collide() {
		this.setOpacity(0);
		this.gettex().setOpacity(0);
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
    	GameClass.root.getChildren().add(g);
    	GameClass.root.getChildren().add(h);
    	GameClass.root.getChildren().add(i);
    	GameClass.root.getChildren().add(j);
    	GameClass.root.getChildren().add(k);
    	GameClass.root.getChildren().add(l);
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
		
		
	}
      
    
      
      

}
