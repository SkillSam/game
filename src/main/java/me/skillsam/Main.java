package me.skillsam;

import java.io.File;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Main extends Application
{
	MediaPlayer mediaPlayer;
   public void start(Stage primaryStage)
   {   
      //create a DrawPane object. See DrawPane.java for details.
      Buttons gui = new Buttons();
   
      //put gui on top of the rootPane
      StackPane rootPane = new StackPane();
      rootPane.getChildren().add(gui);
      
      String sound = "src/main/resources/audio.mp3";
		Media file = new Media(new File(sound).toURI().toString());
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
   
      // Create a scene and place rootPane in the stage
      Scene scene = new Scene(rootPane, 600, 400);
      primaryStage.setTitle("Shape Drawing"); 
      primaryStage.setScene(scene); // Place the scene in the stage
      primaryStage.show(); // Display the stage
   }
   public static void main(String[] args)
   {
      Application.launch(args);
   }
}