package snake_vs_block_5;
import javafx.application.Application;
import java.util.concurrent.*;
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.Stage;
/**
 * <p>Class for snake</p>
 *<p>length field of int type denoteds the length of snake</p>
 *<p>headx field of double type denotes the x-coordinate of snake head</p>
 *<p>heady field of double type denotes the y-coordinate of snake head</p>
 *<p>sp field of boolean volatile type is to check if snake collided with shield or not</p>
 *<p>mb field of boolean volatile type is to check if snake collided with magnet or not</p>
 *<p>b is an ArrayList of balls used to create the snake</p>
 * <p>t is an instance of GameClass</p>
 *<p> k is required for internal implementation of the game</p>
 * <p>colorn of int type is choose snake color </p>
 */
public class snake extends Group {

	/**
	 * length field of int type denoted=s the length of snake
	 */
	private int length;
	/**
	 * headx field of double type denotes the x-coordinate of snake head
	 */
	private double headx;
	/**
	 * heady field of double type denotes the y-coordinate of snake head
	 */
	private double heady;
	/**
	 * sp field of boolean volatile type is to check if snake collided with shield or not
	 */
    private volatile boolean sp;
    /**
     * mb field of boolean volatile type is to check if snake collided with magnet or not
     */
    private volatile boolean mb;
    /**
     * b is an ArrayList of balls used to create the snake
     */
	private ArrayList<ball> b;
	/**
	 * t is an instance of GameClass
	 */
	private GameClass t;
	/**
	 *  k is required for internal implementation of the game
	 */
	 private int k;
	 /**
	  * colorn of int type is choose snake color 
	  */
	 private int colorn;
	 /**
	  * 
	  * @return returns color of snake
	  */
	 public int getc() {
		 return this.colorn;
	 }
	 /**
	  * 
	  * @return returns length of snake
	  */
	
	public int getl() {
		return length;
	}
	/**
	 * 
	 * @return returns X-coordinate of snake head
	 */
	public double getheadx() {
		return headx;
	}
	/**
	 * 
	 * @return returns Y-coordinate of snake head
	 */
	public double getheady() {
		return heady;
		
	}
	/**
	 * 
	 * @param a Sets the value of 'k' reqd for internal implementation
	 */
	public void setk(int a) {
		this.k=a;
	}
	/**
	 * 
	 * @return Returns shield property which checks whether shield is active or not
	 */
	
	public boolean getsp() {
		return sp;
	}
	/**
	 * 
	 * @return Returns magnet property which checks whether magnet is active or not
	 */
	
	public boolean getmb() {
		return sp;
	}
	/**
	 * 
	 * @param a sets the x-coordinate of snake head 
	 */
	
	public void sethx(double a) {
		this.headx=a;
	}
	/**
	 * 
	 * @param a sets the shield property
	 */
	
	public void setsp(boolean a) {
		this.sp=a;
	
	}
	/**
	 * 
	 * @param a sets the y-coordinate of snake head
	 */
	
	public void sethy(double a) {
		this.heady=a;
	
	}
	/**
	 * 
	 * @param a sets the magnet property
	 */
	
	public void setmb(boolean a) {
		this.mb=a;
	
	}
	/**
	 * 	<p>Class constructor which creates snake of length n using an array of balls </p>
	 * @param n length of snake to be created
	 * @param d GameClass instance
	 */
	public snake(int n,GameClass d) {
		super();
		this.length=n;
		this.k=1;
		this.colorn=18;
		this.t=d;
		this.b=new ArrayList<ball>(n);
		this.sp=false;
		this.mb=false;
		
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
		t.bp().getChildren().add(this);
		Circle aa=new Circle();
		this.headx=200;
		this.heady=200;
		aa.setRadius(10);
		aa.setCenterX(200);
		aa.setCenterY(200+5*20);
		aa.setFill(Color.BROWN);
		this.getChildren().add(aa);
		
		
		
		
		
		
	}
	/**
	 * <p>For movement of snake on the screen.</p>
	 * <p>Restricts movement across wall</p>
	 * @param event for movement of snake to left or right depending upon keyboard key pressed
	 */
	public void turnleftorright(KeyEvent event) {
		Timeline o=new Timeline();
		ArrayList<Wall> wall=t.getwall();
		
		if (event.getCode() == KeyCode.RIGHT) {
        	
        	int jj=1;
        	 
        	
        	int wallCollide=-1;
        	for (Object d:this.getChildren()) {
        		Circle ff= (Circle) d;
        		for(int i=0;i<t.getwall().size();i++) {
        			if(wall.get(i).getY()<=600) {
		            	if((wall.get(i).getY()>=90 && (wall.get(i).getY()<=(190+this.length*20))) && ((wall.get(i).getX()-headx<=10 && wall.get(i).getX()-headx>=0))||(this.headx>=595)) {
		            		//ff.setFill(Color.YELLOW);
		            		//if(wall.get(i).getY()<=600) {
			            		KeyValue r11=new KeyValue(ff.centerXProperty(),ff.getCenterX()+0);
			            		KeyFrame rr1=new KeyFrame(Duration.millis(0.1),r11);
			            		jj+=1;
			            		o.getKeyFrames().add(rr1); 
			            		wallCollide=1;
		            	//} 
		            		/*else {
		    	        		KeyValue r1=new KeyValue(ff.centerXProperty(),ff.getCenterX()+9);
		    	        		KeyFrame rr=new KeyFrame(Duration.millis(0.1),r1);
		    	        		jj+=1;
		    	        		o.getKeyFrames().add(rr);
		    	        		wallCollide=1;
		            		}*/
			           
		            	}
        			}	
        		}
        		if(wallCollide==-1) {
	        		KeyValue r1=new KeyValue(ff.centerXProperty(),ff.getCenterX()+9);
	        		KeyFrame rr=new KeyFrame(Duration.millis(0.1),r1);
	        		jj+=1;
	        		o.getKeyFrames().add(rr);
        		
        		
        		}
        		//ff.setCenterX(ff.getCenterX()+1);
        		
        	}
           
        }
        
        
        else if (event.getCode() == KeyCode.LEFT) {
        	int jj=1;
        	
        	
        	 
        	
        	int wallCollide=-1;
        	for (Object d:this.getChildren()) {
        		Circle ff= (Circle) d;
        		for(int i=0;i<wall.size();i++) {
        			if(wall.get(i).getY()<=600) {
		            	if((wall.get(i).getY()>=90 && (wall.get(i).getY()<=(190+this.length*20))) && ( (this.headx-wall.get(i).getX()<=15 && this.headx-wall.get(i).getX()>=0))||(this.headx<=5)) {
		            		//ff.setFill(Color.YELLOW);
		            		//if(wall.get(i).getY()<=600) {
			            		KeyValue r11=new KeyValue(ff.centerXProperty(),ff.getCenterX()-0);
			            		KeyFrame rr1=new KeyFrame(Duration.millis(0.1),r11);
			            		jj+=1;
			            		o.getKeyFrames().add(rr1); 
			            		wallCollide=1;
		            	//} 
		            		/*else {
		    	        		KeyValue r1=new KeyValue(ff.centerXProperty(),ff.getCenterX()-9);
		    	        		KeyFrame rr=new KeyFrame(Duration.millis(0.1),r1);
		    	        		jj+=1;
		    	        		o.getKeyFrames().add(rr);
		    	        		wallCollide=1;
		            		}*/
		            	}
        			}
        		}
        		if(wallCollide==-1) {
	        		KeyValue r1=new KeyValue(ff.centerXProperty(),ff.getCenterX()-9);
	        		KeyFrame rr=new KeyFrame(Duration.millis(0.1),r1);
	        		jj+=1;
	        		o.getKeyFrames().add(rr);
        		
        		
        		}
        		
        		
        		//ff.setCenterX(ff.getCenterX()+1);
        		
        	}
           
        	
        }
		
        

        
        o.play();
        if (this.length>0) {
		this.headx=((Circle)(this.getChildren().get(0))).getCenterX();
        }
	}
	/**
	 * 
	 * @param m To increase the length of snake by 'm'
	 * @param r To change the color of snake to that of ball with which it collides
	 */
	public void incl(int m,int r) {
		int d=length+m;
		this.colorn=r;
		
		length=d;
		this.colorn=r+4;
		this.getChildren().clear();
		for (int y=0;y<d;y++) {
			Circle aa=new Circle();
			
			aa.setRadius(10);
			aa.setCenterX(this.headx);
			aa.setCenterY(this.heady+y*20);
			if (r==13) {
				aa.setFill(Color.CORAL);
				
			}
			else if (r==14) {
				aa.setFill(Color.BROWN);
				
			}
			
			else if (r==15) {
				aa.setFill(Color.GREEN);
			}
			else {
				aa.setFill(Color.VIOLET);
				
			}
			
			this.getChildren().add(aa);
			
			
			
			
		}
		
	}
	/**
	 * 
	 * @param m Sets the length of snake to 'm'
	 * @param u Sets the color of snake to 'u'
	 */
	public void setl(int m,int u) {
		
		
		length=m;
		this.colorn=u;
		this.getChildren().clear();
		for (int y=0;y<m;y++) {
			Circle aa=new Circle();
			if (u==17) {
			aa.setRadius(10);
			aa.setCenterX(this.headx);
			aa.setCenterY(this.heady+y*20);
			aa.setFill(Color.CORAL);
			this.getChildren().add(aa);
			}
			
			else if (u==18) {
				aa.setRadius(10);
				aa.setCenterX(this.headx);
				aa.setCenterY(this.heady+y*20);
				aa.setFill(Color.BROWN);
				this.getChildren().add(aa);
				
			}
			
			else if (u==19) {
				aa.setRadius(10);
				aa.setCenterX(this.headx);
				aa.setCenterY(this.heady+y*20);
				aa.setFill(Color.GREEN);
				this.getChildren().add(aa);
			}
			
			else if (u==20) {
				aa.setRadius(10);
				aa.setCenterX(this.headx);
				aa.setCenterY(this.heady+y*20);
				aa.setFill(Color.VIOLET);
				this.getChildren().add(aa);
			}
			
			
		}
		
	}
	/**
	 * 
	 * @param m To decrease length of snake by 'm'
	 * @throws IOException deserialize method being called inside the body
	 * @throws ClassNotFoundException deserialize method being called inside the body
	 */
	public void decl(int m) throws IOException, ClassNotFoundException{
		int d=length-m;
		
		if (d>0) {
			length=d;
		}
		else {
			length=0;
		}
		this.getChildren().clear();
		if (d>0) {
			for (int y=0;y<d;y++) {
				Circle aa=new Circle();
				
				aa.setRadius(10);
				aa.setCenterX(this.headx);
				aa.setCenterY(this.heady+y*20);
				if (this.colorn==17) {
					aa.setFill(Color.CORAL);
				}
				else if (this.colorn==18) {
					aa.setFill(Color.BROWN);
				}
				else if (this.colorn==19) {
					aa.setFill(Color.GREEN);
				}
				else if (this.colorn==20) {
					aa.setFill(Color.VIOLET);
				}
				this.getChildren().add(aa);
				
				
				
				
			}
			
		}
		else if ((k==1) && (d<=0)) {
			k=0;
			//System.out.println("GAME OVER");
			
			List<Score> retScore=Main.getlb().scoreDeserialize();
			
			Main.getlb().scores=retScore;
			
			Main.getlb().serializeGameOver(t.getScore());
			
			Main.setres(false);
			t.gameover();
			
			
			
			
			
			
			
			
			
			
		}
		
		
	}
	
	
	
	

}
