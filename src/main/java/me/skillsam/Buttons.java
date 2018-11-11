package me.skillsam;

import java.io.File;
import java.util.ArrayList;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.media.AudioClip;

public class Buttons extends BorderPane {
	private ToggleGroup group;
	private Main main;
	
	private ImageView view;
	private ArrayList<Image> armImages;
	
	private AudioClip ac, cheer;
	
	private int armIndex = 1;

	private ToggleButton weight1, weight2, weight3, weight4, weight5;

	public Buttons(Main main) {
		this.main = main;
		this.armImages = this.main.getAI().getList();
		this.view = new ImageView(this.armImages.get(0));
		group = new ToggleGroup();
		
		//sounds
		ac = new AudioClip("file:src/main/resources/woosh.mp3");
		ac.setVolume(0.5);
		
		cheer = new AudioClip("file:src/main/resources/cheer.mp3");
		cheer.setVolume(0.3);

		weight1 = new ToggleButton();
		weight2 = new ToggleButton();
		weight3 = new ToggleButton();
		weight4 = new ToggleButton();
		weight5 = new ToggleButton();

		ImageView imv1 = new ImageView();
		imv1.setFitHeight(60);
		imv1.setFitWidth(60);
		weight1.setGraphic(imv1);
		File dumbbell10 = new File("src/main/resources/dumbbell_10.png");
		Image dumbbellimage10 = new Image(dumbbell10.toURI().toString());
		imv1.setImage(dumbbellimage10);

		ImageView imv2 = new ImageView();
		imv2.setFitHeight(65);
		imv2.setFitWidth(65);
		weight2.setGraphic(imv2);
		File dumbbell20 = new File("src/main/resources/dumbbell_20.png");
		Image dumbbellimage20 = new Image(dumbbell20.toURI().toString());
		imv2.setImage(dumbbellimage20);

		ImageView imv3 = new ImageView();
		imv3.setFitHeight(70);
		imv3.setFitWidth(70);
		weight3.setGraphic(imv3);
		File dumbbell30 = new File("src/main/resources/dumbbell_30.png");
		Image dumbbellimage30 = new Image(dumbbell30.toURI().toString());
		imv3.setImage(dumbbellimage30);

		ImageView imv4 = new ImageView();
		imv4.setFitHeight(75);
		imv4.setFitWidth(75);
		weight4.setGraphic(imv4);
		File dumbbell40 = new File("src/main/resources/dumbbell_40.png");
		Image dumbbellimage40 = new Image(dumbbell40.toURI().toString());
		imv4.setImage(dumbbellimage40);

		ImageView imv5 = new ImageView();
		imv5.setFitHeight(80);
		imv5.setFitWidth(80);
		weight5.setGraphic(imv5);
		File dumbbell50 = new File("src/main/resources/dumbbell_50.png");
		Image dumbbellimage50 = new Image(dumbbell50.toURI().toString());
		imv5.setImage(dumbbellimage50);

		weight1.setToggleGroup(group);
		weight2.setToggleGroup(group);
		weight3.setToggleGroup(group);
		weight4.setToggleGroup(group);
		weight5.setToggleGroup(group);

		TilePane tilePane = new TilePane(Orientation.VERTICAL);
		tilePane.setPadding(new Insets(90, 10, 10, 10));
		tilePane.setVgap(20);

		ButtonHandler handler = new ButtonHandler(main.getProgress(), main.getScore());
		
		weight1.setOnMousePressed(handler);
		weight2.setOnMousePressed(handler);
		weight3.setOnMousePressed(handler);
		weight4.setOnMousePressed(handler);
		weight5.setOnMousePressed(handler);
		
		ArmHandler armHandler = new ArmHandler();
		
		weight1.setOnMouseReleased(armHandler);
		weight2.setOnMouseReleased(armHandler);
		weight3.setOnMouseReleased(armHandler);
		weight4.setOnMouseReleased(armHandler);
		weight5.setOnMouseReleased(armHandler);

		tilePane.getChildren().addAll(weight1, weight2, weight3, weight4, weight5);
		this.setLeft(tilePane);
		this.setCenter(view);
	}
	
	private class ArmHandler implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent event) {
			view.setImage(armImages.get(armIndex - 1));
		}
		
	}

	private class ButtonHandler implements EventHandler<MouseEvent> {

		private Progress progress;
		private Score score;

		public ButtonHandler(Progress progress, Score score) {
			this.progress = progress;
			this.score = score;
		}

		@Override
		public void handle(MouseEvent event) {
			Object var = event.getSource();
			ac.play();
			
			if (var == weight1) {
				this.progress.changeEnergy(-0.5);
				this.score.addScore(5);
			} else if (var == weight2) {
				this.progress.changeEnergy(-1.0);
				this.score.addScore(10);
			} else if (var == weight3) {
				this.progress.changeEnergy(-1.5);
				this.score.addScore(15);
			} else if (var == weight4) {
				this.progress.changeEnergy(-2.0);
				this.score.addScore(20);
			} else if (var == weight5) {
				this.progress.changeEnergy(-2.5);
				this.score.addScore(25);
			}
			
			view.setImage(armImages.get(armIndex));
			if (this.score.ifLevelUp()) {
				armIndex += 2;
				cheer.play();
				
				if (armIndex > armImages.size() - 1) armIndex = armImages.size() - 1;
			}
		}


	}
}
