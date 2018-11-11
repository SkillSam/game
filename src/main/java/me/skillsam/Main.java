package me.skillsam;

import java.io.File;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {
	private MediaPlayer mediaPlayer;
	private ArmImages armIm;

	public void start(Stage primaryStage) {
		// create a DrawPane object. See DrawPane.java for details.
		armIm = new ArmImages();
		Buttons gui = new Buttons();
		Progress progress = new Progress();
		
		// put gui on top of the rootPane
		BorderPane rootPane = new BorderPane();
		rootPane.setCenter(gui);
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
		Scene scene = new Scene(rootPane, 800, 600);

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