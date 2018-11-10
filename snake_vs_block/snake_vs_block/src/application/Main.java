package application;
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

import javafx.scene.control.Label ;

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
public class Main extends Application {
	/*ImageView bgImage;
	AnimationTimer moveLoop;
	double bgSpeed= 0.5;
	Pane bgLayer;
	private double SCENE_WIDTH = 400;
	private double SCENE_HEIGHT = 800;*/
	@Override
	public void start(Stage primaryStage) {
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
		goToGame.setOnAction(e ->{
			/*bgImage= new ImageView( getClass().getResource( "/resources/appbg.jpg").toExternalForm());
			bgImage.relocate( 0, -bgImage.getImage().getHeight() + SCENE_HEIGHT);
			bgLayer.getChildren().add(bgImage);
			moveBackground();*/
			openGame(primaryStage);
		});
	    Reflection reflection = new Reflection(); 
	      
	      
	    reflection.setBottomOpacity(0.0); 
	      
	      
	    reflection.setTopOpacity(0.5); 
	      
	      
	    reflection.setTopOffset(0.0);
	      
	      
	    reflection.setFraction(0.7); 
	       
	      //Applying reflection effect to the text 
	    GameTitle.setEffect(reflection); 
		goToGame.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: #d8d8d8; -fx-border-width: 2px ; -fx-border-color: #e2e2e2;-fx-font-size:30px; -fx-border-radius:12px;");
		goToLbd.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: #d8d8d8; -fx-border-width: 2px ; -fx-border-color: #e2e2e2;-fx-font-size:30px; -fx-border-radius:12px;");
		vbox.getChildren().addAll(GameTitle,goToGame,resume,goToLbd);
		/*goToGame.setOnMouseEntered(e ->{
			goToGame.setStyle(" -fx-background-color: red; ");
		});
		goToGame.setOnMouseExited(e ->{
			goToGame.setStyle("-fx-background-color: #7FDBFF; ");
		});*/
		//vbox.getChildren().add(btnChk);
		Scene scene = new Scene(vbox);
		goToLbd.setOnAction(e ->{
			showLeaderBoard(primaryStage,scene);
		});
		//scene.getStylesheets().add(getClass().getResource("demo.css").toExternalForm());
		vbox.setAlignment(Pos.CENTER);
		vbox.setStyle("-fx-background-color: #1d1d1d;");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	public void showLeaderBoard(Stage lbdStage, Scene mainScene) {
		Text LbdTitle=new Text("LEADERBOARD");
		VBox.setMargin(LbdTitle, new Insets(20, 50, 80, 50));
		LbdTitle.setFill(Color.WHITE);
		LbdTitle.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 80));
		//Stage lbdStage=new Stage();
		Button backToMain1=new Button("GO TO MAIN PAGE");
		VBox.setMargin( backToMain1, new Insets(20, 50, 20, 50));
		backToMain1.setStyle("-fx-background-color: #3a3a3a; -fx-text-fill: #d8d8d8; -fx-border-width: 2px ; -fx-border-color: #e2e2e2;-fx-font-size:30px; -fx-border-radius:12px;");
		backToMain1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				lbdStage.setScene(mainScene);
			}
		});
		HBox rowTitle=new HBox();
		Text Rank=new Text("RANK");
		Text Score=new Text("SCORE");
		Text Date=new Text("DATE");
		Rank.setFill(Color.WHITE);
		Score.setFill(Color.WHITE);
		Date.setFill(Color.WHITE);
		Rank.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 30));
		Score.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 30));
		Date.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 30));
		rowTitle.setSpacing(80);
		rowTitle.getChildren().addAll(Rank,Score,Date);
		
		
		HBox row1=new HBox();		
		row1.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow1=new Text("#1 ---");
		textRow1.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow1.setFill(Color.WHITE);
		row1.getChildren().add(textRow1);
		
		HBox row2=new HBox();		
		row2.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow2=new Text("#2 ---");
		textRow2.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow2.setFill(Color.WHITE);
		row2.getChildren().add(textRow2);
		
		HBox row3=new HBox();		
		row3.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow3=new Text("#3 ---");
		textRow3.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow3.setFill(Color.WHITE);
		row3.getChildren().add(textRow3);
		
		HBox row4=new HBox();		
		row4.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow4=new Text("#4 ---");
		textRow4.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow4.setFill(Color.WHITE);
		row4.getChildren().add(textRow4);
		
		HBox row5=new HBox();		
		row5.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow5=new Text("#5 ---");
		textRow5.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow5.setFill(Color.WHITE);
		row5.getChildren().add(textRow5);
		
		HBox row6=new HBox();		
		row6.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow6=new Text("#6 ---");
		textRow6.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow6.setFill(Color.WHITE);
		row6.getChildren().add(textRow6);
		
		HBox row7=new HBox();		
		row7.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow7=new Text("#7 ---");
		textRow7.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow7.setFill(Color.WHITE);
		row7.getChildren().add(textRow7);
		
		HBox row8=new HBox();		
		row8.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow8=new Text("#8 ---");
		textRow8.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow8.setFill(Color.WHITE);
		row8.getChildren().add(textRow8);
		
		HBox row9=new HBox();		
		row9.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow9=new Text("#9 ---");
		textRow9.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow9.setFill(Color.WHITE);
		row9.getChildren().add(textRow9);
	
		HBox row10=new HBox();		
		row10.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow10=new Text("#10 ---");
		textRow10.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow10.setFill(Color.WHITE);
		row10.getChildren().add(textRow10);
		
		VBox vbox2=new VBox();
		vbox2.setStyle("-fx-background-color: #1d1d1d;");
		vbox2.setSpacing(10);
		vbox2.setAlignment(Pos.CENTER);
		vbox2.getChildren().addAll(LbdTitle,rowTitle,row1,row2,row3,row4,row5,row6,row7,row8,row9,row10,backToMain1);
		Scene scene2=new Scene(vbox2);
		lbdStage.setScene(scene2);
		lbdStage.show();
	}
	public void openGame(Stage gameBoard) {
		//Stage gameBoard=new Stage();
		GameClass game=new GameClass();
		game.start(gameBoard);
		//gameBoard.show();
		
	}
	/*public void moveBackground() {
		moveLoop=new AnimationTimer() {
			@Override
			public void handle(long l) {
	             double y = bgImage.getLayoutY() + bgSpeed;
	             
	             // check bounds. we scroll upwards, so the y position is negative. once it's > 0 we have reached the end of the map and stop scrolling
	             if( Double.compare( y, 0) >= 0) {
	              y = 0;
	             }

	             // move background
	             bgImage.setLayoutY( y);

	             
	            
			}
		};
		moveLoop.start();
		
	}*/
	
	public static void main(String[] args) {
		launch(args);
	}
}

