package me.skillsam;

import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {
	private MediaPlayer mediaPlayer;
	private Progress progress;
	private Score score;
	private ArmImages armIm;
	private BorderPane rootPane;
	private int i;

	public void start(Stage primaryStage) {
		// create a DrawPane object. See DrawPane.java for details.
		this.score = new Score();
		this.progress = new Progress(this.score);

		i = 0;
		armIm = new ArmImages();
		ArrayList<Image> aiList = armIm.getList();

		Buttons buttons = new Buttons(this);
		Image currentAI = aiList.get(i);

		// put gui on top of the rootPane
		rootPane = new BorderPane();
		rootPane.setCenter(buttons);
		rootPane.setTop(progress);

		String sound = "src/main/resources/audio.mp3";
		final Media file = new Media(new File(sound).toURI().toString());
		mediaPlayer = new MediaPlayer(file);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setVolume(0.3);

		Runnable onEnd = new Runnable() {
			public void run() {
				mediaPlayer.dispose();
				mediaPlayer = new MediaPlayer(file);
				mediaPlayer.setVolume(0.05);
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

	public ArmImages getAI() {
		return armIm;
	}

	public Progress getProgress() {
		return this.progress;
	}

	public Score getScore() {
		return this.score;
	}

	public static void main(String[] args) {
		launch(args);
	}
}