package snake_vs_block_5;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
/**
 * <p>LeaderBoard class for game leaderboard</p>
 *<p> scores field of ArrayList type is the list of scores of all games played</p>
 * @author abhiv
 *
 */
public class LeaderBoard extends Application {
	/**
	 * The list of scores of all games played
	 */
	List<Score> scores;
	Scene mainScene;
	/**
	 * Class Constructor creates a list of scores and initalizes to the deserialized list
	 */
	public LeaderBoard() {
		scores=new ArrayList<Score>();
		//List<Score> CustomerSet=new ArrayList<Customer>();

		try {
			List<Score> retScore=scoreDeserialize();
			if(!retScore.isEmpty()){
				scores=retScore;
			}
	        
		}
		catch(IOException ex) {
			
		}
		catch( ClassNotFoundException EX2) {
			
		}
		

	}
	/**
	 * 
	 * @return list of scores
	 */
	public List<Score> getScore() {
		return scores;
	}
	/**
	 * 
	 * @param s Score to be serialized
	 * @throws IOException serialize method being called
	 * 
	 * 
	 */

	public void serializeGameOver(Score s) throws IOException{
		
		this.scores.add(s);
		Collections.sort(scores, new Comparator<Score>() {
		    @Override
		    public int compare(Score o1, Score o2) {
		        if(o1.getPoints()>o2.getPoints()) {
		        	return -1;
		        }
		        else if(o1.getPoints()<o2.getPoints()){
		        	return 1;
		        }
		        /*else {
		        	return o1.getDate().compareTo(o2.getDate());
		        }*/
		        return 0;
		    }
		});
		/*for(Score d: scores) {
			System.out.println(d.getPoints()+" "+d.getDate().toString());
		}*/
		scoreSerialize(scores);
	}
	/**
	 * 
	 * @param scoreList1 list to be serialized 
	 * @throws IOException signals that I/O exception of some sort has occurred
	 */
	public static void scoreSerialize(List<Score> scoreList1) throws IOException{
		ObjectOutputStream out1=null;
		try{
			out1=new ObjectOutputStream(new FileOutputStream("scoreRecord.txt"));
			//for(Customer cIterate4: customerList1){
			out1.writeObject(scoreList1);
			//}
		}
		/*catch(IOException e1){
			System.err.println("error opening file");
		}
		catch(){

		}*/
		finally{
			if(out1!=null){
				out1.close();
			}
		}

	}
	/**
	 * 
	 * @return list deserialized from file
	 * @throws IOException signals that I/O exception of some sort has occurred
	 * @throws ClassNotFoundException Thrown when an application tries to load in a class but no definition for the class with the specified name could be found
	 */
	public static List<Score> scoreDeserialize() throws IOException, ClassNotFoundException{
		ObjectInputStream in1=null;
		List<Score> list=new ArrayList<Score>();
		try{
			in1=new ObjectInputStream(new FileInputStream("scoreRecord.txt"));
			//while(true){
			//	Customer cObj=(Customer) in1.readObject();
			list=(ArrayList<Score>) in1.readObject();
			//}
		}
		catch(EOFException e2){
			System.out.println("catching eof");

			return list;
		}
		finally{
			if(in1!=null){
				in1.close();
			}
		}
		return list;
	}
	/**
	 * <p>Creates the UI of leaderboard screen and displays the top 10 scores</p>
	 */
	@Override
	public void start(Stage primaryStage) {
		String musicFile = "Street-Mayhem.mp3";     // For example
		Media sound = new Media(new File(musicFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(sound);

		 mediaPlayer.setOnEndOfMedia(new Runnable() {
		       public void run() {
		    	   mediaPlayer.seek(Duration.ZERO);
		       }
		   });
		MediaView mediaView = new MediaView(mediaPlayer);

		mediaPlayer.play();
		
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
				//primaryStage.setScene(mainScene);
				
				Main f=new Main();
				Stage ff=new Stage();
				
				
				mediaPlayer.stop();
				primaryStage.close();
				f.start(ff);
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
		Text textRow1=new Text("#1");
		textRow1.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow1.setFill(Color.WHITE);

		if(scores.size()>0) {
		Text first=new Text(Integer.toString(scores.get(0).getPoints()));
		Text firstDate=new Text(		scores.get(0).getDate().toString());
		first.setFill(Color.WHITE);
		firstDate.setFill(Color.WHITE);
		first.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		firstDate.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		/*try {
			Image image = new Image(new FileInputStream("trophy.jpeg"),50,50,true,true); 
			ImageView imageview = new ImageView(image); 
			row1.setSpacing(150);
			row1.getChildren().addAll(textRow1,imageview,first,firstDate);
		}
		catch(Exception e) {
			
		}*/
		row1.setSpacing(150);
		row1.getChildren().addAll(textRow1,first,firstDate);

		}
		else {
			row1.getChildren().addAll(textRow1);
		}

		
		HBox row2=new HBox();		
		row2.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow2=new Text("#2");
		textRow2.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow2.setFill(Color.WHITE);
		if(scores.size()>1) {
		Text sec=new Text(Integer.toString(scores.get(1).getPoints()));
		Text secDate=new Text(		scores.get(1).getDate().toString());
		sec.setFill(Color.WHITE);
		secDate.setFill(Color.WHITE);
		sec.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		secDate.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		row2.setSpacing(150);
		row2.getChildren().addAll(textRow2,sec,secDate);
		}
		else {
			row2.getChildren().addAll(textRow2);
		}

		
		HBox row3=new HBox();		
		row3.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow3=new Text("#3");
		textRow3.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow3.setFill(Color.WHITE);
		if(scores.size()>2) {
		Text third=new Text(Integer.toString(scores.get(2).getPoints()));
		Text thirdDate=new Text(		scores.get(2).getDate().toString());
		third.setFill(Color.WHITE);
		thirdDate.setFill(Color.WHITE);
		third.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		thirdDate.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		row3.setSpacing(150);
		row3.getChildren().addAll(textRow3,third,thirdDate);
		}
		else {
			row3.getChildren().addAll(textRow3);
		}

		
		HBox row4=new HBox();		
		row4.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow4=new Text("#4");
		textRow4.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow4.setFill(Color.WHITE);
		if(scores.size()>3) {
		Text fourth=new Text(Integer.toString(scores.get(3).getPoints()));
		Text fourthDate=new Text(		scores.get(3).getDate().toString());
		fourth.setFill(Color.WHITE);
		fourthDate.setFill(Color.WHITE);
		fourth.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		fourthDate.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		row4.setSpacing(150);
		row4.getChildren().addAll(textRow4,fourth,fourthDate);
		}
		else {
			row4.getChildren().addAll(textRow4);
		}

		
		HBox row5=new HBox();		
		row5.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow5=new Text("#5");
		textRow5.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow5.setFill(Color.WHITE);
		if(scores.size()>4) {
		Text fifth=new Text(Integer.toString(scores.get(4).getPoints()));
		Text fifthDate=new Text(		scores.get(4).getDate().toString());
		fifth.setFill(Color.WHITE);
		fifthDate.setFill(Color.WHITE);
		fifth.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		fifthDate.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		row5.setSpacing(150);
		row5.getChildren().addAll(textRow5,fifth,fifthDate);
		}
		else {
			row5.getChildren().addAll(textRow5);
		}

		
		HBox row6=new HBox();		
		row6.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow6=new Text("#6");
		textRow6.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow6.setFill(Color.WHITE);
		if(scores.size()>5) {
		Text sixth=new Text(Integer.toString(scores.get(5).getPoints()));
		Text sixthDate=new Text(		scores.get(5).getDate().toString());
		sixth.setFill(Color.WHITE);
		sixthDate.setFill(Color.WHITE);
		sixth.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		sixthDate.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		row6.setSpacing(150);
		row6.getChildren().addAll(textRow6,sixth,sixthDate);
		}
		else {
			row6.getChildren().addAll(textRow6);
		}

		
		HBox row7=new HBox();		
		row7.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow7=new Text("#7");
		textRow7.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow7.setFill(Color.WHITE);
		if(scores.size()>6) {
		Text seventh=new Text(Integer.toString(scores.get(6).getPoints()));
		Text seventhDate=new Text(		scores.get(6).getDate().toString());
		seventh.setFill(Color.WHITE);
		seventhDate.setFill(Color.WHITE);
		seventh.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		seventhDate.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		row7.setSpacing(150);
		row7.getChildren().addAll(textRow7,seventh,seventhDate);
		}
		else {
			row7.getChildren().addAll(textRow7);
		}

		
		HBox row8=new HBox();		
		row8.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow8=new Text("#8");
		textRow8.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow8.setFill(Color.WHITE);
		if(scores.size()>7) {
		Text eigth=new Text(Integer.toString(scores.get(7).getPoints()));
		Text eigthDate=new Text(		scores.get(7).getDate().toString());
		eigth.setFill(Color.WHITE);
		eigthDate.setFill(Color.WHITE);
		eigth.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		eigthDate.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		row8.setSpacing(150);
		row8.getChildren().addAll(textRow8,eigth,eigthDate);
		}
		else {
			row8.getChildren().addAll(textRow8);
		}

		
		HBox row9=new HBox();		
		row9.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow9=new Text("#9");
		textRow9.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow9.setFill(Color.WHITE);
		if(scores.size()>8) {
		Text ninth=new Text(Integer.toString(scores.get(8).getPoints()));
		Text ninthDate=new Text(		scores.get(8).getDate().toString());
		ninth.setFill(Color.WHITE);
		ninthDate.setFill(Color.WHITE);
		ninth.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		ninthDate.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		row9.setSpacing(150);
		row9.getChildren().addAll(textRow9,ninth,ninthDate);
		}
		else {
			row9.getChildren().addAll(textRow9);
		}

	
		HBox row10=new HBox();		
		row10.setStyle("-fx-background-color: linear-gradient(to right,rgba(58,58,58,1),rgba(58,58,58,0));");
		Text textRow10=new Text("#10");
		textRow10.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		textRow10.setFill(Color.WHITE);
		if(scores.size()>9) {
		Text tenth=new Text(Integer.toString(scores.get(9).getPoints()));
		Text tenthDate=new Text(		scores.get(9).getDate().toString());
		tenth.setFill(Color.WHITE);
		tenthDate.setFill(Color.WHITE);
		tenth.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		tenthDate.setFont(Font.font("garamond", FontWeight.BOLD, FontPosture.REGULAR, 20));
		row10.setSpacing(145);
		row10.getChildren().addAll(textRow10,tenth,tenthDate);
		}
		else {
			row10.getChildren().addAll(textRow10);
		}

		
		//row1.getChildren().addAll(textRow1,first,firstDate);
		
		VBox vbox2=new VBox();
		vbox2.setStyle("-fx-background-color: #1d1d1d;");
		vbox2.setSpacing(10);
		vbox2.setAlignment(Pos.CENTER);
		vbox2.getChildren().add(mediaView);
		vbox2.getChildren().addAll(LbdTitle,rowTitle,row1,row2,row3,row4,row5,row6,row7,row8,row9,row10,backToMain1);
		Scene scene2=new Scene(vbox2);
		primaryStage.setScene(scene2);
		primaryStage.show();
	}
}
