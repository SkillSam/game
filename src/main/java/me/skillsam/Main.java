package me.skillsam;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

public class Main extends Application
{
   public void start(Stage primaryStage)
   {   
      //create a DrawPane object. See DrawPane.java for details.
      Buttons gui = new Buttons();
   
      //put gui on top of the rootPane
      StackPane rootPane = new StackPane();
      rootPane.getChildren().add(gui);
   
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