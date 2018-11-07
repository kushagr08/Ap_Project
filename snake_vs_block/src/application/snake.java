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


public class snake extends Group {
	private int length;
	private double headx;
	double heady;
	
	
	
	public snake(int n) {
		super();
		this.length=n;
		
		for (int i=0;i<n;i++) {
			
			Circle aa=new Circle();
			this.headx=200;
			this.heady=200;
			aa.setRadius(10);
			aa.setCenterX(200);
			aa.setCenterY(200+i*20);
			aa.setFill(Color.BROWN);
			this.getChildren().add(aa);
		}
		GameClass.root.getChildren().add(this);
		
		
		
		
		
	}
	
	public void turnleftorright(KeyEvent event) {
		Timeline o=new Timeline();
		
        if (event.getCode() == KeyCode.RIGHT) {
        	
        	int jj=1;
        	 
        	
        	
        	for (Object d:this.getChildren()) {
        		Circle ff= (Circle) d;
        		KeyValue r1=new KeyValue(ff.centerXProperty(),ff.getCenterX()+5);
        		KeyFrame rr=new KeyFrame(Duration.millis(0.1),r1);
        		jj+=1;
        		o.getKeyFrames().add(rr);
        		
        		
        		
        		//ff.setCenterX(ff.getCenterX()+1);
        		
        	}
           
        }
        
        
        else if (event.getCode() == KeyCode.LEFT) {
        	int jj=1;
        	
        	for (Object d:this.getChildren()) {
        		Circle ff= (Circle) d;
        		KeyValue r1=new KeyValue(ff.centerXProperty(),ff.getCenterX()-5);
        		KeyFrame rr=new KeyFrame(Duration.millis(0.1),r1);
        		jj+=1;
        		
        		
        		o.getKeyFrames().add(rr);
        		
        		//ff.setCenterX(ff.getCenterX()+1);
        		
        	}
           
        	
        }
        
        /*if ((((Circle)this.getChildren().get(0)).getCenterX()==300)&&(oo.getOpacity()!=0)){
        	oo.setOpacity(0);
        	
        	p3.setOpacity(0);

        	Rectangle g=new Rectangle(300,200,5,5);
        	Rectangle h=new Rectangle(300,200,5,5);
        	Rectangle i=new Rectangle(300,200,5,5);
        	Rectangle j=new Rectangle(300,200,5,5);
        	Rectangle k=new Rectangle(300,200,5,5);
        	Rectangle l=new Rectangle(300,200,5,5);
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
        	
        	
        	
			
			
		}*/
        
        o.play();
		this.headx=((Circle)(this.getChildren().get(0))).getCenterX();
	}
	
	
	
	

}
