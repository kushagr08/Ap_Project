package snake_vs_block_5;
import java.io.IOException;
import javafx.scene.media.MediaView;
import java.io.File; 
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.text.Text; 
import javafx.scene.text.Font; 
import javafx.scene.text.FontPosture; 
import javafx.scene.text.FontWeight; 
import javafx.scene.text.Text;
import javafx.scene.control.Alert.AlertType; 
import javafx.scene.control.Alert;
import javafx.animation.Animation;
import javafx.animation.Animation.*;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.control.Label ;
import javafx.util.Duration;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.Color; 
import javafx.scene.effect.Reflection;


/**
 *<p>class for Main Page</p>
 *<p>game field for associated GameClass instance</p>
 *<p>static Leaderboard field ldbd</p>
 *<p>alertOver field to display score after gameover</p>
 *<p>boolean static res field for knowing whether resume to be enabled or not</p>
 *
 */
public class Main extends Application {
	
	
	/**
	 * game field for associated GameClass instance
	 */
	private GameClass game;
	/**
	 * static Leaderboard field ldbd
	 */
	private static LeaderBoard ldbd=new LeaderBoard();
	private boolean displast=false;
	/**
	 * alertOver field to display score after gameover
	 */
	private Alert alertOver = new Alert(AlertType.NONE);
	/**
	 * boolean static res field for knowing whether resume to be enabled or not
	 */
	private static boolean res=true;
	
	
	/**
	 * @return boolean field to tell whether resume to be enabled or not
	 */
	public static boolean getres() {
		return res;
	}
	
	
	/**
	 * @return reference to leaderboard
	 */
	public static LeaderBoard getlb() {
		return ldbd;
	}
	
	
	
	/**
	 * @param a set the boolean field to tell whether last played game completed/not.
	 */
	public static void setres(boolean a) {
		res=a;
	}
	
	
	/**
	 * default Main constructor
	 */
	public Main() {
		
	}
	
	
	/**
	 * <p>to display score after gameover and returning back to Main page</p>
	 * @param o boolean var for displaying score on game over
	 * @param score points of the player with date
	 * 
	 */
	public Main(boolean o, Score score) {
		if (o==true) {
			displast=true;
			// set alert type 
			Stage r=new Stage();
            this.start(r);
            alertOver.setAlertType(AlertType.WARNING); 
            
            // set content text 
            alertOver.setHeaderText("GAME OVER!!"); 
            alertOver.show(); 
            alertOver.setContentText("SCORE: "+score.getPoints());
            // show the dialog 
            Timeline idlestage = new Timeline( new KeyFrame( Duration.seconds(5 ), new EventHandler<ActionEvent>()
            {

                @Override
                public void handle( ActionEvent event )
                {
                    
                    alertOver.hide();
                }
            } ) );
            idlestage.setCycleCount( 1 );
            
            idlestage.play();
            o=false;
            
			
		}
		
	}
	
	
	
	
	
	/** 
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 * <p>to initialize the game UI</p>
	 * <p>to enable/disable resume button</p>
	 * <p>to write functionality of start and show leader board</p>
	 * 
	 */
	@Override
	public void start(Stage primaryStage) {
		String musicFile = "Strange-World.mp3";     // For example
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);
		//int s=INDEFINITE;
		//mediaPlayer.setCycleCount(0);
		 mediaPlayer.setOnEndOfMedia(new Runnable() {
		       public void run() {
		    	   mediaPlayer.seek(Duration.ZERO);
		       }
		   });
			MediaView mediaView = new MediaView(mediaPlayer);
			
			
		mediaPlayer.play();
		primaryStage.setTitle("SNAKE VS. BLOCK GAME");
		Text GameTitle=new Text("SNAKE VS. BLOCK GAME");
		Button goToGame=new Button("PLAY");
		Button resume=new Button("RESUME");
		Button goToLbd=new Button("LEADERBOARD");
		
		resume.setStyle("-fx-opacity:0.6;-fx-background-color: #3a3a3a; -fx-text-fill:#d8d8d8; -fx-border-width: 2px ;-fx-border-color: #e2e2e2;-fx-font-size:30px; -fx-border-radius:12px;");

		//bgLayer=new Pane();
		
		//StackPane stackPane = new StackPane();
		VBox vbox=new VBox();
		vbox.setSpacing(10);
		VBox.setMargin(GameTitle, new Insets(20, 50, 100, 50));
		VBox.setMargin(goToGame, new Insets(20, 50, 20, 50));
		VBox.setMargin(goToLbd, new Insets(20, 50, 20, 50));
		VBox.setMargin(resume, new Insets(20, 50, 20, 50));
		GameTitle.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 80));
		GameTitle.setFill(Color.WHITE);
		//Label btnChk=new Label("not selected");

	    Reflection reflection = new Reflection(); 
	      
	      
	    reflection.setBottomOpacity(0.0); 
	      
	      
	    reflection.setTopOpacity(0.5); 
	      
	      
	    reflection.setTopOffset(0.0);
	      
	      
	    reflection.setFraction(0.7); 
	       
	      //Applying reflection effect to the text 
	    GameTitle.setEffect(reflection); 
	    ArrayList<itemObj> itmobjArr; 
		itmobjArr = new ArrayList<itemObj>();
		xmlparse xm=new xmlparse();
		itmobjArr=xm.ReadXml();
		for(itemObj i : itmobjArr) {
			//this loop is collecting all the data and it can be used to resume game
		if (Integer.parseInt(i.getItem())>=17) {
			if (Integer.parseInt(i.getValue())>0) {
				res=true;
			}
			else {
				res=false;
			}
		}
		}
	    if (res==true) {
	    	resume.setStyle("-fx-opacity:1;-fx-background-color: #3a3a3a; -fx-text-fill:#d8d8d8; -fx-border-width: 2px ;-fx-border-color: #e2e2e2;-fx-font-size:30px; -fx-border-radius:12px;");
	    }
	    else {
	    	resume.setStyle("-fx-opacity:0.6;-fx-background-color: #3a3a3a; -fx-text-fill:#d8d8d8; -fx-border-width: 2px ;-fx-border-color: #e2e2e2;-fx-font-size:30px; -fx-border-radius:12px;");
	    }
	    
	    resume.setOnAction(e ->{
			if (res==true) {
				mediaPlayer.stop();
				GameClass d=new GameClass(new Stage());
				primaryStage.close();
				d.resume();
			}
		});
	    
	    
		goToGame.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: #d8d8d8; -fx-border-width: 2px ; -fx-border-color: #e2e2e2;-fx-font-size:30px; -fx-border-radius:12px;");
		goToLbd.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: #d8d8d8; -fx-border-width: 2px ; -fx-border-color: #e2e2e2;-fx-font-size:30px; -fx-border-radius:12px;");
		vbox.getChildren().addAll(GameTitle,goToGame,resume,goToLbd);
		
		Scene scene = new Scene(vbox);
		goToLbd.setOnAction(e ->{
			mediaPlayer.stop();
			showLeaderBoard(primaryStage,scene);
			
		});
		goToGame.setOnAction(e ->{
			
			try {
				openGame(primaryStage,scene);
			}
			catch(IOException ex) {
				System.out.println("exception caughttttttt");
				ex.printStackTrace();
			}
			catch( ClassNotFoundException EX2) {
				System.out.println("exception caught--");
			}
		});
		
		vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(mediaView);
		vbox.setStyle("-fx-background-color: #1d1d1d;");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	/**
	 * <p>method to show leaderboard on click leaderboard button on Main page</p>
	 * @param lbdStage static leader board
	 * @param mainScene mainscene associated with leaderboard
	 */
	public void showLeaderBoard(Stage lbdStage, Scene mainScene) {
		try {
		LeaderBoard ldbd=new LeaderBoard();
		ldbd.mainScene=mainScene;
		ldbd.start(lbdStage);
		}
		catch (Exception e) {
			
		}
	
		
	}
	/**
	 * @param gameBoard stage associated
	 * @param mainScene mainScene associated
	 * @throws IOException can throw this checked exception
	 * @throws ClassNotFoundException can throw this checked exception
	 */
	public void openGame(Stage gameBoard,Scene mainScene) throws IOException,ClassNotFoundException {
		
		Stage f=new Stage();
		game=new GameClass(f);
		
		
		
		gameBoard.close();
		
		
		game.start(f);
		
		
	}
	
	
	/**
	 * <p>to create an instance of this javafx application</p>
	 * @param args arguments
	 */
	public static void main(String[] args) {
		ArrayList<itemObj> itmobjArr; 
		itmobjArr = new ArrayList<itemObj>();
		xmlparse xm=new xmlparse();
		itmobjArr=xm.ReadXml();
		/*for(itemObj i : itmobjArr) { //this loop is collecting all the data and it can be used to resume game
		System.out.println("Item : "+i.getItem());
		System.out.println("Xpos : "+i.getXpos());
		System.out.println("Ypos : "+i.getYpos());
		System.out.println("Value : "+i.getValue());
		
		}*/
		
		launch(args);
	}
}

