package me.skillsam;
import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


public class AudioCode extends Application{
	private MediaPlayer mediaPlayer;
	
	public void start(Stage primaryStage) {
		
 		StackPane root = new StackPane();
		
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
			}};
		mediaPlayer.setOnEndOfMedia(onEnd);
		mediaPlayer.play();
			

		primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
	}
	
    public static void main(String[] args)
    {
        launch(args);
    }
}