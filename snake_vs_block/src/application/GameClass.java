package application;
import java.io.*;


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






public class GameClass extends Application {
	  snake p;
	 static BorderPane root=new BorderPane();
	 private ArrayList<block> blo;
	
	 
	
	public GameClass() {
		
		this.p=new snake(5);
		this.blo=new ArrayList<block>();
		
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
		    
		    
		    root.getChildren().addAll(blo);
		   
		    
		    
		    
		    BorderPane x=new BorderPane();
		    //root.getChildren().add(x);
		    
		    x.setStyle("-fx-background-color: green");
		    
		    
			
		    Canvas bbb=new Canvas(600,600);
		    
		    root.getChildren().add(bbb);
		    Image image = new Image(new FileInputStream("magnet.png")); 
		    ImageView imageView = new ImageView(image); 
		    imageView.setX(60); 
		    imageView.setY(60); 
		    imageView.setFitHeight(40); 
		    imageView.setFitWidth(40);
		    Image image2 = new Image(new FileInputStream("coin2.jpg")); 
		    ImageView imageView2 = new ImageView(image2); 
		    imageView2.setX(60); 
		    imageView2.setY(300); 
		    imageView2.setFitHeight(40); 
		    imageView2.setFitWidth(40);
		    
		    
		    Image image3 = new Image(new FileInputStream("shield2.jpg")); 
		    ImageView imageView3 = new ImageView(image3); 
		    imageView3.setX(300); 
		    imageView3.setY(330); 
		    imageView3.setFitHeight(40); 
		    imageView3.setFitWidth(40);
		    
		    Image image4 = new Image(new FileInputStream("explode.gif_c200")); 
		    ImageView imageView4 = new ImageView(image4); 
		    imageView4.setX(400); 
		    imageView4.setY(440); 
		    imageView4.setFitHeight(60); 
		    imageView4.setFitWidth(60);
		    
		    
		    
			Text p1=new Text("Score: 0");
			p1.setX(355);
			p1.setY(10);
			ChoiceBox locationchoiceBox = new ChoiceBox(); 
		    locationchoiceBox.getItems().addAll("Exit and go to Main","Start Again"); 
		    locationchoiceBox.setLayoutX(40);
		    locationchoiceBox.setLayoutY(20);
		   
			
		    
			
			root.setStyle("-fx-background-color: aqua");
			//GraphicsContext gc = bbb.getGraphicsContext2D();
			
		
			
			
			
			root.getChildren().add(imageView);
			root.getChildren().add(imageView2);
			root.getChildren().add(imageView3);
			root.getChildren().add(imageView4);
			root.getChildren().add(p1);
			root.getChildren().add(locationchoiceBox);
			
			Circle b1=new Circle();
			b1.setRadius(4);
			b1.setFill(Color.CORAL);
			b1.setCenterX(200);
			b1.setCenterY(40);
			Circle b2=new Circle();
			b2.setRadius(4);
			b2.setFill(Color.CORAL);
			b2.setCenterX(300);
			b2.setCenterY(50);
			Text p3=new Text("6");
			p3.setX(200);
			p3.setY(55);
			p3.setFill(Color.GREEN);
			root.getChildren().add(p3);
			p3.setStyle("-fx-color: green");
			Text p4=new Text("7");
			p4.setX(300);
			p4.setY(65);
			p4.setFill(Color.GREEN);
			root.getChildren().add(p4);
			p4.setStyle("-fx-color: green");
			root.getChildren().add(b1);
			root.getChildren().add(b2);
			
			Rectangle w1=new Rectangle(370,70,2,200);
			w1.setFill(Color.GRAY);
			root.getChildren().add(w1);
			
			
			
			Rectangle m8=new Rectangle(374,70,50,50);
			m8.setFill(Color.YELLOW);
			root.getChildren().add(m8);
			
			Rectangle m9=new Rectangle(425,70,50,50);
			m9.setFill(Color.YELLOW);
			root.getChildren().add(m9);
			
			Rectangle m10=new Rectangle(476,70,50,50);
			m10.setFill(Color.YELLOW);
			root.getChildren().add(m10);
			
			Text p8=new Text("26");
			p8.setX(399);
			p8.setY(95);
			p8.setFill(Color.GREEN);
			root.getChildren().add(p8);
			p8.setStyle("-fx-color: green");
			
			Text p9=new Text("42");
			p9.setX(449);
			p9.setY(95);
			p9.setFill(Color.GREEN);
			root.getChildren().add(p9);
			p9.setStyle("-fx-color: green");
			
			Text p10=new Text("38");
			p10.setX(501);
			p10.setY(95);
			p10.setFill(Color.GREEN);
			root.getChildren().add(p10);
			p10.setStyle("-fx-color: green");
			
			
			/*Circle aa=new Circle();
			Circle bb=new Circle();
			Circle cc=new Circle();
			Circle dd=new Circle();
			Circle ee=new Circle();*/
			Rectangle mm=new Rectangle(300,150,50,50);
			mm.setFill(Color.YELLOW);
			//Rectangle m2=new Rectangle(0,0,600,600);
			//m2.setFill(Color.WHITE);
			root.getChildren().add(mm);
			KeyValue g=new KeyValue(mm.yProperty(),mm.getY()+600);
			KeyFrame r=new KeyFrame(Duration.seconds(1),g);
			Timeline timeline=new Timeline(r);
			timeline.setCycleCount(Animation.INDEFINITE);
		    timeline.play();
			//root.getChildren().add(m2);
			 Text p2=new Text("4");
				p2.setX(325);
				p2.setY(175);
				//p2.setFill(Color.GREEN);
				root.getChildren().add(p2);
				p2.setStyle("-fx-color: green");
			
			
			
			
			
			
			
		
			Scene scene = new Scene(root,600,600);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			this.blockanim();
			
			primaryStage.show();
			
			
			
			
			
			
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
	
	public void blockanim() {
		Random rr=new Random();
		KeyValue[] f=new KeyValue[10];
		
		int s=5;
		int x=(int)(rr.nextDouble()*400);
		for (int j=0;j<s;j++) {
			block c=new block(5*(j+1),Color.GREEN,x+j*50,-50,50,50);
			
			
			c.setFill(Color.YELLOW);
			blo.add(c);
			KeyValue g=new KeyValue(c.yProperty(),c.getY()+641);
			KeyValue ss=new KeyValue(c.gettex().yProperty(),c.gettex().getY()+641);
			f[2*j]=g;
			f[2*j+1]=ss;
			root.getChildren().add(c);
			root.getChildren().add(c.gettex());
			
		}
		KeyFrame r=new KeyFrame(Duration.seconds(2),new TimeHandler(),f);
		/*block c=new block(30,Color.GREEN,40,-41,50,50);
		c.setFill(Color.YELLOW);
		blo.add(c);*/
		
		
		
		//root.getChildren().add(blo.get(0).gettex());
		
	
		
        
		
		
		//c.setX(rr.nextDouble()*600);
		
		
		Timeline timeline=new Timeline(r);
		AnimationTimer xx=new MyTimer();
		xx.start();
		timeline.setCycleCount(Animation.INDEFINITE);
		
	    timeline.play();
	    //c.setX(rr.nextDouble()*600);
	    
	    
	}
	

	
private class TimeHandler implements EventHandler<ActionEvent>{
	    
 public void handle(ActionEvent event){	
	 Random rr=new Random();
	 
	 
	 double j=rr.nextDouble()*350;
	 int o=(int)(rr.nextDouble()*5);
	 
	 
	 for (int l=0;l<o;l++) {
		 blo.get(l).setOpacity(0);
		 blo.get(l).gettex().setOpacity(0);
	 }
	 for (int mm=o;mm<5;mm++) {
		 blo.get(mm).setOpacity(1);
		 blo.get(mm).gettex().setOpacity(1);
	 }
	 for (int m=0;m<5;m++) {
		 blo.get(m).setX(j+50*m);
		 blo.get(m).gettex().setX(j+25+50*m);
	 }
	 
	 
	 


	    }
	}
private class MyTimer extends AnimationTimer {

    @Override
    public void handle(long now) {
    
        doHandle();
    }

    private void doHandle() {

        for (int k=0;k<5;k++) {
        	double y=blo.get(k).getY();
        	
        	if ((blo.get(k).getOpacity()==1)&&((y+60)>200)&&(y+60<205)){
        		blo.get(k).collide();
        		
        		
        	}
        }
    }
}
	
	
}
