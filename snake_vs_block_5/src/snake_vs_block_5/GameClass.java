package snake_vs_block_5;
import java.io.*;



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.animation.AnimationTimer;
import javafx.scene.image.*;
import javafx.beans.value.*;
import javafx.collections.ObservableList;
import javafx.scene.media.MediaView;
import java.io.File; 
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.stage.Stage;
import javafx.util.Duration;
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
import java.util.*;


import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;






/**
 * <p>GameClass for the game scene </p>
 * <p>It has composition relationship with the classes- snake,block,ball,destroy block,magnet,shield,wall,coin,
 * player score.</p>
 * <p>In addition to the above mentioned fields, it has a border pane field, tokens( collide interface objects),
 *   text box for displaying score, a stage, a scene and a drop down with 2 choices as fields.</p>
 *   
 * 
 *
 */


public class GameClass extends Application {
	 private snake p;
	 private BorderPane root;
	 private ArrayList<block> blo;
	
	 private ArrayList<ball> balls;
	 private ArrayList<Collidable> tokens;
	 private ArrayList<destroyblock> dest;
	 private ArrayList<Magnet> magt;
	 private ArrayList<shield> shield;
	 private ArrayList<Wall> wall;
	 private ArrayList<Coin> coinss;
	 private Score playerScore;
	 private Text displayScore;
	 private Text displayLength;
	 private Stage m;
	 private String musicFile;
		private Media sound;
		private MediaPlayer mediaPlayer;
		MediaView mediaView;
	 private Scene scene;
	 private ObservableList<String> choices= FXCollections.observableArrayList("Options","EXIT AND GO TO MAIN","START AGAIN");
	 private ChoiceBox<String> locationchoiceBox=new ChoiceBox<String>(choices);
	 private int flag=0;
	 
	 
	 /**
	 * @return reference to the wall objects currently on the gamescene
	 */
	public ArrayList<Wall> getwall(){
		 return wall;
	 }
	
	
	
	 
	/**
	 * @return reference to the snake object of the gamescene
	 */ 
	 public snake gets() {
		 return this.p;
	 }
	 
	 
	 /**
		 * @return reference to the border pane of the gamescene
		 */ 
	 public BorderPane bp() {
		 return this.root;
	 }
	 
	 
	 
	 /**
	 * <p>creates xmlparse object to read the item numbers from savedata.xml file which were there on the screen when the game instance was closed</p>
	 *<p> item no. 8 for score 9 to 12 for blocks, 13 to 16 for balls,  17 to 20 for snake (4 numbers because 4 possible colours for each)</p>
	 * <p>3-shield, 4-coin, 5-wall, 6-magnet,7-destroy block</p>
	 * <p>After that the javafx components for these objects are added to the screen and the game begins with the last state it exited.</p>
	 * <p>this method is called only if the last game was not completed</p>
	 */
	public void resume() {
		 ArrayList<itemObj> itmobjArr; 
			itmobjArr = new ArrayList<itemObj>();
			xmlparse xm=new xmlparse();
			itmobjArr=xm.ReadXml();
			ArrayList<KeyValue> g=new ArrayList<KeyValue>();
			for(itemObj i : itmobjArr) {
				//this loop is collecting all the data and it can be used to resume game
			if ((Integer.parseInt(i.getItem())>=17)&&(Integer.parseInt(i.getItem())<=20)) {
				p.sethx(Double.parseDouble(i.getXpos()));
				p.sethy(Double.parseDouble(i.getYpos()));
				
				p.setl(Integer.parseInt(i.getValue()),Integer.parseInt(i.getItem()));
				displayLength.setText("Length: "+Integer.toString(p.getl()));
			}
			
			if (Integer.parseInt(i.getItem())==8) {
				displayScore.setX(Double.parseDouble(i.getXpos()));
				displayScore.setY(Double.parseDouble("30"));
				this.playerScore.addTopoints(Integer.parseInt(i.getValue()));
				displayScore.setText("Score: "+i.getValue());
				
				
			}
			if ((Integer.parseInt(i.getItem())>=9)&&(Integer.parseInt(i.getItem())<=12)) {
				block a=new block(Integer.parseInt(i.getValue()),Double.parseDouble(i.getXpos()),Double.parseDouble(i.getYpos()),50,50,this);
				if (Integer.parseInt(i.getItem())==9) {
					a.setFill(Color.PURPLE);
					
				}
				
				else if (Integer.parseInt(i.getItem())==10) {
					a.setFill(Color.YELLOW);
					
				}
				
				else if (Integer.parseInt(i.getItem())==11) {
					a.setFill(Color.RED);
					
				}
				
				else if (Integer.parseInt(i.getItem())==12) {
					a.setFill(Color.ORANGE);
					
				}
				this.blo.add(a);
				
				KeyValue gg=new KeyValue(a.yProperty(),a.getY()+700);
				KeyValue ss=new KeyValue(a.gettex().yProperty(),a.gettex().getY()+700);
				g.add(gg);
				g.add(ss);
				root.getChildren().add(a);
				root.getChildren().add(a.gettex());
			}
			
			else if ((Integer.parseInt(i.getItem())>=13)&&(Integer.parseInt(i.getItem())<=16)) {
				
				ball b=new ball(Integer.parseInt(i.getValue()),Double.parseDouble(i.getXpos()),Double.parseDouble(i.getYpos()),this);
				b.setcolorn(Integer.parseInt(i.getItem()));
				KeyValue u=new KeyValue(b.centerYProperty(),b.getCenterY()+641);
    			KeyValue m=new KeyValue(b.gettex().yProperty(),b.gettex().getY()+641);
    			g.add(u);
    			g.add(m);
    			root.getChildren().add(b);
    			tokens.add(b);
    			balls.add(b);
				
			}
			
			else if (Integer.parseInt(i.getItem())==3) {
				shield c=new shield(Double.parseDouble(i.getXpos()),Double.parseDouble(i.getYpos()),this);
				
				//this.shieldd.add(f);
				shield.add(c);
				tokens.add(c);
				root.getChildren().add(c.getimv());
				KeyValue u=new KeyValue(c.getimv().yProperty(),c.getimv().getY()+671);
    			
    			g.add(u);
				this.shield.add(c);
			}
			
			
			else if (Integer.parseInt(i.getItem())==4) {
				Coin c=new Coin(Double.parseDouble(i.getXpos()),Double.parseDouble(i.getYpos()),this);
				tokens.add(c);
				root.getChildren().add(c.getimv());
				KeyValue u=new KeyValue(c.getimv().yProperty(),c.getimv().getY()+671);
    			
    			g.add(u);
				this.coinss.add(c);
			}
			
			else if (Integer.parseInt(i.getItem())==5) {
				Wall e=new Wall(Double.parseDouble(i.getXpos()),Double.parseDouble(i.getYpos()),Double.parseDouble(i.getValue()));
				KeyValue u=new KeyValue(e.yProperty(),e.getY()+700);
    			
    			
    			g.add(u);
    			
    			root.getChildren().add(e);
    			
    			
				this.wall.add(e);
			}
			
			else if (Integer.parseInt(i.getItem())==6) {
				Magnet e=new Magnet(Double.parseDouble(i.getXpos()),Double.parseDouble(i.getYpos()),this);
				tokens.add(e);
				root.getChildren().add(e.getimv());
				KeyValue u=new KeyValue(e.getimv().yProperty(),e.getimv().getY()+671);
    			
    			g.add(u);
				this.magt.add(e);
			}
			
			else if (Integer.parseInt(i.getItem())==7) {
				destroyblock e=new destroyblock(Double.parseDouble(i.getXpos()),Double.parseDouble(i.getYpos()));
				tokens.add(e);
				root.getChildren().add(e.getimv());
				KeyValue u=new KeyValue(e.getimv().yProperty(),e.getimv().getY()+671);
    			
    			g.add(u);
				this.dest.add(e);
			}
			
			
				
			Timeline gst=new Timeline();
			KeyValue[] arr=new KeyValue[g.size()];
			for (int y=0;y<g.size();y++) {
				arr[y]=g.get(y);
				
				
			}
 			KeyFrame s=new KeyFrame(Duration.seconds(4),arr);
 			gst.getKeyFrames().add(s);
 			gst.play();
 			
 			this.start(this.m);
			
			}
		 
	 }
	 
	
	
	 /**
	 * @return score of the player- score object has points and date
	 */
	public  Score getScore() {
			
			return playerScore;
		}
	
	
	 /**
	 * code to return to the Main Page once the length of snake becomes less than 0
	 */
	public void gameover() {
		 Timeline g=new Timeline();
		 mediaPlayer.stop();
		 Score p=this.playerScore;
			
			KeyFrame ss=new KeyFrame(Duration.seconds(1.5),new EventHandler<ActionEvent>() {
		        public void handle(ActionEvent event) {
		        	m.close();
		        	Main f=new Main(true,p);
		        	
		            
		        }
		    });
		 g.getKeyFrames().add(ss);
		 g.play();
		 
		
		 
		 
	    	
	    }
	 
	 /**
	 * <p>animation timer thread is created in the GameClass constructor and it checks whether the objects currently on the screen are colliding
	 * with the head of the snake or not. This is where multithreading takes place internally.</p>
	 * <p>Animation Timer handle method called approx 60 times every second</p>
	 * <p>for every element it removes it from the root if it leaves the scene/collides with the snake</p>
	 * <p>else it saves it's state in savedata.xml</p>
	 * <p>savedata.xml overwritten every time animation timer is called to save only the latest state of the game</p>
	 *<p>collision for destroy block results in all destroying all bricks currently on the screen</p>
	 */
	private class MyTimer extends AnimationTimer {

		    @Override
		    public void handle(long now) {
		    
		        doHandle();
		    }
		    
		    

		    
		    private void doHandle() {
		    	Iterator itr1=blo.iterator();
		    	Iterator itr2=balls.iterator();
		    	Iterator itr3=shield.iterator();
		    	Iterator itr4=coinss.iterator();
		    	Iterator itr5=wall.iterator();
		    	Iterator itr6=magt.iterator();
		    	Iterator itr7=dest.iterator();
		    //	StringBuilder tmpStrB 
		    	StringBuilder tmpStrB= new StringBuilder("<game>"); 
		    	int item=0; //Declare item variable and initialize it
		    	tmpStrB.append("<items>\n<item>" +p.getc() +"</item>\n<xpos>"+ p.getheadx()+ "</xpos>\n<ypos>"+p.getheady()+"</ypos>\n<value>"+p.getl()+"</value></items>");
		    	tmpStrB.append("<items>\n<item>" + 8 +"</item>\n<xpos>"+ 355+ "</xpos>\n<ypos>"+10+"</ypos>\n<value>"+playerScore.getPoints()+"</value></items>");
		    	while (itr5.hasNext()) {
		    		Wall k=(Wall) itr5.next();
		    		if (k.getY()>=600) {
		    			itr5.remove();
		    			k.setOpacity(0);
		    			root.getChildren().remove(this);
		    		}
		    		
		    		else {
		    			item=5; //5 for Wall
		    			tmpStrB.append("<items>\n<item>" + item +"</item>\n<xpos>"+ k.getX()+ "</xpos>\n<ypos>"+k.getY()+"</ypos>\n<value>"+k.getl()+"</value></items>");
		        		
		    			
		    		}
		    		
		    		
		    	}
		   
		    	
		        while (itr1.hasNext()) {
		        	block d=(block)(itr1.next());
		        	double y=d.getY();
		        	double x=d.getX();
		        	double m=p.getheadx();
		        	
		        	if ((d.getOpacity()==1)&&((y+60)>200)&&(y+60<205)&&(m-x<=50)&&(m-x>=0)){
		        		if (p.getl()>0) {
		        		d.collide(p);
		        		if (p.getl()>0) {
		        			playerScore.addTopoints(d.getvalue());
		        			
		        		}
		        		
		        		displayScore.setText("Score: "+Integer.toString(playerScore.getPoints()));
		        		displayLength.setText("Length: "+Integer.toString(p.getl()));
		        		itr1.remove();
		        		}
		        		else {
		        			displayLength.setText("Length: "+Integer.toString(0));
		        			
		        		}
		        		
		        		
		        	}
		        	else if ((d.getY()>600)&&(d.getOpacity()==1)) {
		        		d.setOpacity(0);
		        		d.gettex().setOpacity(0);
		        		root.getChildren().remove(d);
		        		root.getChildren().remove(d.gettex());
		        		itr1.remove();
		        		
		        	}
		        	else {
		        		//Optimized code
		        		//Store the value in tmpStrB and append it in RAM
		        		//Update item and the next line for every item you create on screen.. like Ball, Magnet ete.. and share with me the code
		        		
		        		item=1; //1 for Box
		        		tmpStrB.append("<items>\n<item>" + d.getc() +"</item>\n<xpos>"+ d.getX()+ "</xpos>\n<ypos>"+d.getY()+"</ypos>\n<value>"+d.getvalue()+"</value></items>");
		        		//End
		        	}
		        }
		        
		        while (itr6.hasNext()) {
		        	Magnet r=(Magnet) itr6.next();
		        	double m=p.getheadx();
		        	double dBx=r.getimv().getX();
		        	double dBy=r.getimv().getY();
		        	if ((m-dBx<=60) &&(m-dBx>=0) && (dBy>=140 && dBy<=220))  {
		        		r.collide(p);
		        		root.getChildren().remove(r);
		        		root.getChildren().remove(r.getim());
		        		root.getChildren().remove(r.getimv());
		        		itr6.remove();
		        		
		        		
		        	}
		        	else if ((dBy>600)&&(r.getimv().getOpacity()==1)) {
		        		r.getimv().setOpacity(0);
		        		
		        		root.getChildren().remove(r);
		        		root.getChildren().remove(r.getim());
		        root.getChildren().remove(r.getimv());
		        		itr6.remove();
		        		
		        	}
		        	
		        	else {
		        		//Optimized code
		        		//Store the value in tmpStrB and append it in RAM
		        		//Update item and the next line for every item you create on screen.. like Ball, Magnet ete.. and share with me the code
		        		
		        		item=6; //6 for magnet
		        		tmpStrB.append("<items>\n<item>" + item +"</item>\n<xpos>"+ r.getimv().getX()+ "</xpos>\n<ypos>"+r.getimv().getY()+"</ypos>\n<value>0</value>\n</items>");
		        		//End
		        	}
		        	
		        }
		        
		        while (itr3.hasNext()) {
		        	shield s=(shield) itr3.next();
		        	double m=p.getheadx();
		        	double dBx=s.getimv().getX();
		        	double dBy=s.getimv().getY();
		        	if ((m-dBx<=30) &&(m-dBx>=0) && (dBy>=140 && dBy<=220))  {
		        		s.collide(p);
		        		root.getChildren().remove(s);
		        		root.getChildren().remove(s.getim());
		        		root.getChildren().remove(s.getimv());
		        		itr3.remove();
		        		
		        		
		        	}
		        	else if ((dBy>600)&&(s.getimv().getOpacity()==1)) {
		        		s.getimv().setOpacity(0);
		        		
		        		root.getChildren().remove(s);
		        		root.getChildren().remove(s.getim());
		        		root.getChildren().remove(s.getimv());
		        		itr3.remove();
		        		
		        	}
		        	
		        	else {
		        		//Optimized code
		        		//Store the value in tmpStrB and append it in RAM
		        		//Update item and the next line for every item you create on screen.. like Ball, Magnet ete.. and share with me the code
		        		
		        		item=3; //3 for shield
		        		tmpStrB.append("<items>\n<item>" + item +"</item>\n<xpos>"+ s.getimv().getX()+ "</xpos>\n<ypos>"+s.getimv().getY()+"</ypos>\n<value>0</value>\n</items>");
		        		//End
		        	}
		        	
		        }
		        while (itr4.hasNext()) {
		        	Coin xx=(Coin) itr4.next();
		        	double m=p.getheadx();
		        	double dBx=xx.getimv().getX();
		        	double dBy=xx.getimv().getY();
		        	double xxx=Math.pow(m-dBx,2);
		        	double yyy=Math.pow(200-dBy,2);
		        	double t=xxx+yyy;
		        	
		        	if ((m-dBx<=30) &&(m-dBx>=0) && (dBy>=140 && dBy<=220))  {
		        		xx.collide(p);
		        		root.getChildren().remove(xx);
		        		if (p.getl()>0) {
		        			playerScore.addTopoints(5);
		        			
		        		}
		        		
		        		displayScore.setText("Score: "+Integer.toString(playerScore.getPoints()));
		        		root.getChildren().remove(xx.getim());
		        		root.getChildren().remove(xx.getimv());
		        		itr4.remove();
		        		
		        		
		        	}
		        	else if ((t<=20000)&&(p.getmb()==true)&&(xx.getimv().getY()>=0)&&(xx.getimv().getY()<=600)&&(xx.getimv().getOpacity()==1)) {
		        		xx.collide(p);
		        		root.getChildren().remove(xx);
		        		if (p.getl()>0) {
		        			playerScore.addTopoints(5);
		        			
		        		}
		        		
		        		displayScore.setText("Score: "+Integer.toString(playerScore.getPoints()));
		        		root.getChildren().remove(xx.getim());
		        		root.getChildren().remove(xx.getimv());
		        		itr4.remove();
		        	}
		        	
		        	else if ((dBy>600)&&(xx.getimv().getOpacity()==1)) {
		        		xx.getimv().setOpacity(0);
		        		
		        		root.getChildren().remove(xx);
		        		root.getChildren().remove(xx.getim());
		        	root.getChildren().remove(xx.getimv());
		        		itr4.remove();
		        		
		        	}
		        	
		        	else {
		        		//Optimized code
		        		//Store the value in tmpStrB and append it in RAM
		        		//Update item and the next line for every item you create on screen.. like Ball, Magnet ete.. and share with me the code
		        		
		        		item=4; //4 for coin
		        		tmpStrB.append("<items>\n<item>" + item +"</item>\n<xpos>"+ xx.getimv().getX()+ "</xpos>\n<ypos>"+xx.getimv().getY()+"</ypos>\n<value>0</value>\n</items>");
		        		//End
		        	}
		        	
		        }
		        
		        while (itr2.hasNext()) {
		        	ball dd=(ball)(itr2.next());
		        	double y=dd.getCenterY();
		        	double x=dd.getCenterX();
		        	double mm=p.getheadx();
		        	double nn=p.getheady();
		        	boolean d=((x-mm<15)&&(x-mm>0))||((x-mm>-15)&&(x-mm<0));
		        	boolean e=((nn-y<15)&&(nn-y>=0));
		        	if ((dd.getOpacity()==1)&&(d)&&(e)) {
		        		dd.collide(p);
		        		if (p.getl()>0) {
		        			displayLength.setText("Length: "+Integer.toString(p.getl()));
		        			
		        		}
		        		else {
		        			displayLength.setText("Length: "+Integer.toString(0));
		        		}
		        		itr2.remove();
		        	}
		        	
		        	else if ((dd.getCenterY()>600)&&(dd.getOpacity()==1)) {
		        		dd.setOpacity(0);
		        		dd.gettex().setOpacity(0);
		        		root.getChildren().remove(dd);
		        		root.getChildren().remove(dd.gettex());
		        		itr2.remove();
		        		
		        	}
		        	else {
		        		//Optimized code
		        		//Store the value in tmpStrB and append it in RAM
		        		//Update item and the next line for every item you create on screen.. like Ball, Magnet ete.. and share with me the code
		        		
		        		item=2; //2 for Ball
		        		tmpStrB.append("<items>\n<item>" +dd.colorn() +"</item>\n<xpos>"+ dd.getCenterX()+ "</xpos>\n<ypos>"+dd.getCenterY()+"</ypos>\n<value>"+dd.getvalue()+"</value></items>");
		        		//End
		        	}
		        	
		        }
		        
		        
		        while (itr7.hasNext()) {
		        	destroyblock gs=(destroyblock) itr7.next();
		        	double m=p.getheadx();
		        	double dBx=gs.getimv().getX();
		        	double dBy=gs.getimv().getY();
		        	
		        	if ((m-dBx<=30) &&(m-dBx>=0) && (dBy>=140 && dBy<=220))  {
		        		gs.collide(p);
		        		root.getChildren().remove(gs);
		        		root.getChildren().remove(gs.getim());
		        		root.getChildren().remove(gs.getimv());
		        		itr7.remove();
		        		Timeline xx=new Timeline();
		        		for (block r:blo) {
		        			if ((r.getY()>=-2)&&(r.getY()<=600)&&(r.getOpacity()==1)){
		        				r.setOpacity(0);
		        				if (p.getl()>0) {
				        			playerScore.addTopoints(r.getvalue());
				        			
				        		}
		        				
				        		displayScore.setText("Score: "+Integer.toString(playerScore.getPoints()));
		        				r.gettex().setOpacity(0);
		        				//s.decl(this.value);
		        				
		        				
		        				Rectangle g=new Rectangle(r.getX(),r.getY(),5,5);
		        		    	Rectangle h=new Rectangle(r.getX(),r.getY(),5,5);
		        		    	Rectangle i=new Rectangle(r.getX(),r.getY(),5,5);
		        		    	Rectangle jj=new Rectangle(r.getX(),r.getY(),5,5);
		        		    	Rectangle k=new Rectangle(r.getX(),r.getY(),5,5);
		        		    	Rectangle l=new Rectangle(r.getX(),r.getY(),5,5);
		        			    g.setFill(Color.BLACK);

		        			    g.setStroke(Color.YELLOW);
		        			    h.setFill(Color.BLACK);

		        			    h.setStroke(Color.YELLOW);
		        			    i.setFill(Color.BLACK);

		        			    i.setStroke(Color.YELLOW);
		        			    jj.setFill(Color.BLACK);

		        			    jj.setStroke(Color.YELLOW);
		        			    k.setFill(Color.BLACK);

		        			    k.setStroke(Color.YELLOW);
		        			    l.setFill(Color.BLACK);

		        			    l.setStroke(Color.YELLOW);
		        		    	root.getChildren().add(g);
		        		    	root.getChildren().add(h);
		        		    	root.getChildren().add(i);
		        		    	root.getChildren().add(jj);
		        		    	root.getChildren().add(k);
		        		    	root.getChildren().add(l);
		        		    	KeyValue r1=new KeyValue(g.xProperty(),g.getX()-40);
		        		    	KeyValue r2=new KeyValue(g.yProperty(),g.getY()-40);
		        		    	KeyValue r3=new KeyValue(h.xProperty(),h.getX()+40);
		        		    	KeyValue r4=new KeyValue(h.yProperty(),h.getY()+40);
		        		    	KeyValue r5=new KeyValue(i.xProperty(),i.getX()-40);
		        		    	KeyValue r6=new KeyValue(i.yProperty(),i.getY()+40);
		        		    	KeyValue r7=new KeyValue(jj.xProperty(),jj.getX()+40);
		        		    	KeyValue r8=new KeyValue(jj.yProperty(),jj.getY()-40);
		        		    	KeyValue r9=new KeyValue(k.yProperty(),k.getY()+40);
		        		    	KeyValue r10=new KeyValue(l.yProperty(),l.getY()-40);
		        		    	KeyValue r11=new KeyValue(g.opacityProperty(),0);
		        		    	KeyValue r12=new KeyValue(h.opacityProperty(),0);
		        		    	KeyValue r13=new KeyValue(i.opacityProperty(),0);
		        		    	KeyValue r14=new KeyValue(jj.opacityProperty(),0);
		        		    	KeyValue r15=new KeyValue(k.opacityProperty(),0);
		        		    	KeyValue r16=new KeyValue(l.opacityProperty(),0);
		        		    	KeyFrame rr=new KeyFrame(Duration.millis(1000),r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12,r13,r14,r15,r16);
		        		    	
		        		    	xx.getKeyFrames().add(rr);
		        			}
		        				
		        			}
		        		xx.play();
		        	}
		        	else if ((gs.getimv().getY()>600)&&(gs.getimv().getOpacity()==1)) {
		        		gs.getimv().setOpacity(0);
		        		
		        		root.getChildren().remove(gs);
		        		root.getChildren().remove(gs.getim());
		        		root.getChildren().remove(gs.getimv());
		        		itr7.remove();
		        		
		        	}
		        	else {
		        		//Optimized code
		        		//Store the value in tmpStrB and append it in RAM
		        		//Update item and the next line for every item you create on screen.. like Ball, Magnet ete.. and share with me the code
		        		
		        		item=7; //7 for 
		        		tmpStrB.append("<items>\n<item>" + item +"</item>\n<xpos>"+ gs.getimv().getX()+ "</xpos>\n<ypos>"+gs.getimv().getY()+"</ypos>\n<value>0</value>\n</items>");
		        		//End
		        	}
		        	
		        }
		        /*while (itr5.hasNext()) {
		        	Wall d=(Wall) itr5.next();
		        if ((d.getY()>600)&&(d.getOpacity()==1)) {
	        		d.setOpacity(0);
	        		
	        		root.getChildren().remove(d);
	        		
	        		itr5.remove();
	        		
	        	}
	        	else {
	        		//Optimized code
	        		//Store the value in tmpStrB and append it in RAM
	        		//Update item and the next line for every item you create on screen.. like Ball, Magnet ete.. and share with me the code
	        		
	        		item=5; //5 for wall
	        		tmpStrB.append("<items>\n<item>" + item +"</item>\n<xpos>"+ d.getX()+ "</xpos>\n<ypos>"+d.getY()+"</ypos>\n<value>"+d.getl()+"</value></items>");
	        		//End
	        	}
		        }*/
		        
		        try {
		        	//Save the game data
		        	tmpStrB.append("</game>");
		        	BufferedWriter writer = new BufferedWriter(new FileWriter("savedata.xml"));
		        	
		        	writer.append(tmpStrB);
		    		writer.close();
		          } catch (IOException e1) {
					e1.printStackTrace();
				}
		    }
		    
		}
	 
	
	/**
	 * @param x stage for the GameClass instance
	 * <p>initializes all components of the game scene</p>
	 * <p>starts the Animation Timer to check for collisions</p>
	 */
	public GameClass(Stage x) {
		 root=new BorderPane();
		 m=x;
		// AnimationTimer xx=new MyTimer();
			//xx.start();
		 //root.getChildren().clear();
		 musicFile = "Monsters-in-Bell-Bottoms.mp3";     // For example
			sound = new Media(new File(musicFile).toURI().toString());
			 mediaPlayer = new MediaPlayer(sound);
			 mediaView = new MediaView(mediaPlayer);
		 
		this.scene=new Scene(root,600,600);
		
		this.p=new snake(5,this);
		this.blo=new ArrayList<block>();
		
		this.balls=new ArrayList<ball>();
		this.tokens=new ArrayList<Collidable>();
		this.dest=new ArrayList<destroyblock>();
		this.magt=new ArrayList<Magnet>();
		this.shield=new ArrayList<shield>();
		this.wall=new ArrayList<Wall>();
		this.coinss=new ArrayList<Coin>();
		this.playerScore=new Score();
		displayScore=new Text("Score: "+Integer.toString(playerScore.getPoints()));
		displayScore.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 30));
		displayScore.setX(355);
		displayScore.setY(30);
		root.getChildren().add(displayScore);
		displayLength=new Text("Length: "+Integer.toString(p.getl()));
		displayLength.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 16));
		displayLength.setX(200);
		displayLength.setY(30);
		root.getChildren().add(displayLength);
		AnimationTimer xx=new MyTimer();
		xx.start();
		
		
	}
	
	/** 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * <p>adds the choice box for start again,exit and go to main, has event handler for turning the snake left/right</p>
	 * <p>initiates the animation of objects by calling runanim method</p>
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			mediaPlayer.setOnEndOfMedia(new Runnable() {
			       public void run() {
			    	   mediaPlayer.seek(Duration.ZERO);
			       }
			   });
			
			
		    
		    this.m=primaryStage;
		    
		     locationchoiceBox.setLayoutX(40);
		     locationchoiceBox.setLayoutY(20);
		   
		   
			
		    
			
			root.setStyle("-fx-background-color: aqua");
			
			
			if(flag==0) {
				root.getChildren().add(locationchoiceBox);
				root.getChildren().add(mediaView);
				mediaPlayer.play();
				locationchoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {	
				@Override
					public void changed(ObservableValue<? extends Number> ov,Number number,Number number2) {
						if (choices.get(number2.intValue()).equals("EXIT AND GO TO MAIN"))
						{
							if (p.getl()>0) {
							m.close();
							root.getChildren().clear();
							Main.setres(true);
				        	Main f=new Main();
				        	p.setk(0);
				        	mediaPlayer.stop();
				        	Stage ff=new Stage();
				        	f.start(ff);
							}
				        	
						}
						
						else if (choices.get(number2.intValue()).equals("START AGAIN"))
						{
							if (p.getl()>0) {
							m.close();
							root.getChildren().clear();
							Stage ff=new Stage();
							mediaPlayer.stop();
				        	GameClass f=new GameClass(ff);
				        	p.setk(0);
				        	
				        	f.start(ff);
							}
				        	
						}
						
						
					}
				});
				
				primaryStage.setScene(scene);
				//AnimationTimer xx=new MyTimer();
				//xx.start();
				
				this.runanim();
					
				primaryStage.show();
							
				flag=1;
				}
			
			
			
			
			
			scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

	            @Override
	            public void handle(KeyEvent event) {
	            p.turnleftorright(event);
	            	
	            }
	        });
	    
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * runs an indefinite timeline to create a row of objects after every 1.5 seconds.
	 * 
	 */
	public void runanim() {
	    
		
		KeyFrame o=new KeyFrame(Duration.seconds(1.5),new TimeHandler(this));
		Timeline timeline=new Timeline(o);
		
		
		timeline.setCycleCount(Animation.INDEFINITE);
		//timeline2.setCycleCount(Animation.INDEFINITE);
		
	    timeline.play();
	    
	    
	    
	}
	

	
/**
 * <p>TimeHandler of indefinite timeline to create random row of objects to move.</p>
 * <p>it is ensured that value of atleast 1 block in a chain is less than snake's length</p>
 * <p>frequency of ball greater than other 3 tokens</p>
 * <p>walls occur in different lengths</p>
 * <p>also if length greater than 10 duration 3.5 seconds</p>
 * <p>else duration 4 seconds to ensure as length of snake increases speed increases</p>
 *
 */
private class TimeHandler implements EventHandler<ActionEvent>{
	 ArrayList<KeyValue> g;
	 GameClass f;
	 
public TimeHandler(GameClass r) {
	this.g=new ArrayList<KeyValue>();
	this.f=r;
	   
	    
	    
	
}
	    
 public void handle(ActionEvent event){	
	 
	 
	 
	 Random rp=new Random();
	    
	    this.g=new ArrayList<KeyValue>();
	   
	    int blocount=0;
	    int wallcount=0;
	    int ballcount=0;
	    int coincount=0;
	    int y;
	    int tokencount=0;//added now
	    int rand=rp.nextInt(2);//added now
	    ArrayList<block> pp=new ArrayList<block>(); 
	    
	    int x=1;
	    int j=0;
	    while (j<14){
	    	int ff=rp.nextInt(32);
	    	if ((ff>=0) && (ff<10)&&(blocount<5)) {
	    		int y1=rp.nextInt(4);
	    		int y2=x;
	    		if ((y1>=0) && (y1<3)) {
	    		int r=rp.nextInt(4)+1;
	    		for (int k=0;k<r;k++) {
	    		int i;
	    		int rrr=rp.nextInt(40);
	    		
	    		if (rrr<=25) {
	    			i=rp.nextInt(15);
	    		}
	    		else {
	    			i=rp.nextInt(15)+25;
	    		}
	    		block c=new block(i+1,y2+k*50,-50,50,50,this.f);
				
				
				
				
				blo.add(c);
				pp.add(c);
				KeyValue gg=new KeyValue(c.yProperty(),c.getY()+700);
				KeyValue ss=new KeyValue(c.gettex().yProperty(),c.gettex().getY()+700);
				g.add(gg);
				g.add(ss);
				root.getChildren().add(c);
				root.getChildren().add(c.gettex());
				
				tokens.add(c);
				//t.add(c);
				//bo.add(c);
				j+=1;
				blocount+=1;
				int yy=0;
				if (blocount==5) {
					for (block d:pp) {
						if (d.getvalue()<p.getl()) {
							yy=1;
							break;
							
						}
						else {
							yy=2;
							
						}
					}
					x+=80;
					break;
				}
                if (yy==2) {
                	int yt=Integer.max(1,rp.nextInt(p.getl()));
                	
                	c.setvalue(yt);
	    			
	    		}
				x+=60;
	    		}
	    		
	    		}
	    		else {
	    			
	    			
	    			blocount+=1;
	    			j+=1;
	    			
	    			
	    			
	    			
	    		}
	    		
	    		
	    	}
	    	else if((ff>=10)&&(ff<15)&&(ballcount<3)) {
	    		int y1=rp.nextInt(3);
	    		if ((y1>=0)&&(y1<=1)) {
	    			int v=rp.nextInt(12)+1;
	    			ball f=new ball(v,x,-2,this.f);
	    			KeyValue u=new KeyValue(f.centerYProperty(),f.getCenterY()+641);
	    			KeyValue m=new KeyValue(f.gettex().yProperty(),f.gettex().getY()+641);
	    			g.add(u);
	    			g.add(m);
	    			root.getChildren().add(f);
	    			tokens.add(f);
	    			balls.add(f);
	    			//ba.add(f);
	    			//t.add(f);
	    			
	    			j+=1;
	    			x+=30;
	    			ballcount+=1;
	    			
	    		}
	    		else {
	    			j+=1;
	    			
	    			ballcount+=1;
	    		}
	    		
	    	}
	    	else if ((ff<=19)&&(ff>=15)&&(tokencount==0)) {//addead now
	    		if (rand==0) {
	    			tokencount+=1;
	    			j+=1;
	    			
	    		}
	    		else {
	    			int dd=rp.nextInt(6);
	    			if ((dd==0)||(dd==1)) {
	    				tokencount+=1;
	    				j+=1;
	    				destroyblock f=new destroyblock(x,-61);
	    				//this.dst.add(f);
	    				dest.add(f);
	    				tokens.add(f);
	    				root.getChildren().add(f.getimv());
	    				KeyValue u=new KeyValue(f.getimv().yProperty(),f.getimv().getY()+671);
		    			
		    			g.add(u);
		    			
		    			x+=80;
	    				
	    				
	    				
	    			}
	    			else if ((dd==2)||(dd==3)) {
	    				tokencount+=1;
	    				j+=1;
	    				Magnet f=new Magnet(x,-61,this.f);
	    				//this.mag.add(f);
	    				magt.add(f);
	    				tokens.add(f);
	    				root.getChildren().add(f.getimv());
	    				KeyValue u=new KeyValue(f.getimv().yProperty(),f.getimv().getY()+671);
		    			
		    			g.add(u);
		    			
		    			x+=80;
	    				
	    			}
	    			else if ((dd==4)||(dd==5)) {
	    				tokencount+=1;
	    				j+=1;
	    				shield f=new shield(x,-61,this.f);
	    				//this.shieldd.add(f);
	    				shield.add(f);
	    				tokens.add(f);
	    				root.getChildren().add(f.getimv());
	    				KeyValue u=new KeyValue(f.getimv().yProperty(),f.getimv().getY()+671);
		    			
		    			g.add(u);
		    			
		    			x+=80;
	    				
	    			}
	    		}
	    		
	    	}
	    	else if((ff>=27)&&(ff<32)&&(coincount<2)) {
	    		int y1=rp.nextInt(3);
	    		if ((y1>=0)&&(y1<=1)) {
	    			
	    			coincount+=1;
    				j+=1;
    				Coin f=new Coin(x,-41,this.f);
    				//this.coins.add(f);
    				coinss.add(f);
    				tokens.add(f);
    				root.getChildren().add(f.getimv());
    				KeyValue u=new KeyValue(f.getimv().yProperty(),f.getimv().getY()+671);
	    			
	    			g.add(u);
	    			
	    			x+=60;
	    			
	    		}
	    		else {
	    			j+=1;
	    			
	    			coincount+=1;
	    		}
	    		
	    	}
	    	else if((ff>=20)&&(ff<27)&&(wallcount<3)) {
	    		int y1=rp.nextInt(3);
	    		if ((y1>=0)&&(y1<=1)) {
	    			Random xt=new Random();
	    			int s=xt.nextInt(51)+100;
	    			
	    			Wall f=new Wall(x,-100,s);
	    			KeyValue u=new KeyValue(f.yProperty(),f.getY()+700);
	    			
	    			
	    			g.add(u);
	    			
	    			root.getChildren().add(f);
	    			
	    			wall.add(f);
	    			//this.walls.add(f);
	    			//t.add(f);
	    			
	    			j+=1;
	    			x+=30;
	    			wallcount+=1;
	    			
	    		}
	    		else {
	    			j+=1;
	    			
	    			wallcount+=1;
	    		}
	    		
	    	}
	    	
	    }
	    KeyValue[] r=new KeyValue[g.size()];
	    for (int e=0;e<g.size();e++) {
	    	r[e]=g.get(e);
	    }
	    Random r1=new Random();
	    
	    double t;
	    if (p.getl()<=10) {
	    	t=4;
	    }
	    else  {
	    	t=3.5;
	    }
	    
	    KeyFrame o=new KeyFrame(Duration.seconds(t),r);
	    
	    
		Timeline timeline=new Timeline(o);
		//timeline.setCycleCount(1);
		
		timeline.play();
		
		
		
	 
	}
 

}


	
	
}

