package me.skillsam;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {
	private MediaPlayer mediaPlayer;
	private ArmImages armIm;
	private int i;

	public void start(Stage primaryStage) {
		// create a DrawPane object. See DrawPane.java for details.
		Buttons buttons = new Buttons();
		Progress progress = new Progress();
		
		i = 0;
		armIm = new ArmImages();
		ArrayList<Image> aiList = armIm.getList();
		Image currentAI = aiList.get(i);
		ImageView imv = new ImageView(currentAI);
		
		// put gui on top of the rootPane
		BorderPane rootPane = new BorderPane();
		rootPane.setLeft(buttons);
		rootPane.setCenter(imv);
		rootPane.setTop(progress);

		String sound = "src/main/resources/audio.mp3";
		final Media file = new Media(new File(sound).toURI().toString());
		mediaPlayer = new MediaPlayer(file);
		mediaPlayer.setAutoPlay(true);

		Runnable onEnd = new Runnable() {
			public void run() {
				mediaPlayer.dispose();
				mediaPlayer = new MediaPlayer(file);
				mediaPlayer.play();
				mediaPlayer.setOnEndOfMedia(this);
			}
		};
		mediaPlayer.setOnEndOfMedia(onEnd);
		mediaPlayer.play();


		// Create a scene and place rootPane in the stage
		Scene scene = new Scene(rootPane, 900, 700);

		primaryStage.setTitle("Shape Drawing");
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	public ArmImages getAI()
	{
		return armIm;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}