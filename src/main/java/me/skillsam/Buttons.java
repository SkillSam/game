package me.skillsam;

import java.io.File;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;

public class Buttons extends BorderPane
{
	private RadioButton weight1, weight2, weight3, weight4, weight5;
	private ToggleGroup group;
	private ArrayList<Image> imageList;
	private String lastPress;
	private ImageView imv;
	private File file, file2, file3, file4, file5, file6, file7, file8;
	private Image image, image2, image3, image4, image5, image6,image7, image8;
	
	public Buttons()
	{
		weight1 = new RadioButton("100");
		weight2 = new RadioButton("793");
		weight3 = new RadioButton("800");
		weight4 = new RadioButton ("1000");
		weight5 = new RadioButton ("3000");
		
		group = new ToggleGroup();
		
		weight1.setToggleGroup(group);
		weight2.setToggleGroup(group);
		weight3.setToggleGroup(group);
		weight4.setToggleGroup(group);
		weight5.setToggleGroup(group);
		
		TilePane tilePane = new TilePane(Orientation.VERTICAL);
		tilePane.setPadding(new Insets(90, 10, 10, 10));
		tilePane.setVgap(30);
		imv = new ImageView();
		file = new File("src/main/resources/arm1_1.png");
		image = new Image(file.toURI().toString());
		imv.setImage(image);
		tilePane.getChildren().addAll(weight1, weight2, weight3, weight4, weight5, imv);
		this.setLeft(tilePane);
		
//		Image arm1_1 = new Image("src/main/resource/arm1_1.png");
//		Image arm1_2 = new Image("src/main/resource/arm1_2.png");
//		Image arm2_1 = new Image("src/main/resource/arm2_1.png");
//		Image arm2_2 = new Image("src/main/resource/arm2_2.png");
//		Image arm3_1 = new Image("src/main/resource/arm3_1.png");
//		Image arm3_2 = new Image("src/main/resource/arm3_2.png");
//		Image arm4_1 = new Image("src/main/resource/arm4_1png");
//		Image arm4_2 = new Image("src/main/resource/arm4_2.png");
		
		/*imageList.add(new Image("src/main/resource/arm1_1.png"));
		imageList.add(new Image("src/main/resource/arm1_2.png"));
		imageList.add(new Image("src/main/resource/arm2_1.png"));
		imageList.add(new Image("src/main/resource/arm2_2.png"));
		imageList.add(new Image("src/main/resource/arm3_1.png"));
		imageList.add(new Image("src/main/resource/arm3_2.png"));
		imageList.add(new Image("src/main/resource/arm4_1.png"));
		imageList.add(new Image("src/main/resource/arm4_2.png"));*/
		


	}
}

