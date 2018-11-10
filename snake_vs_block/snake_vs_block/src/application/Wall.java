package application;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;
public class Wall extends Rectangle {
	public Wall(int xWall,int yWall) {
		super(xWall,yWall,5,200);
		this.setFill(Color.GRAY);
	}
}
