package me.skillsam;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ArmTransition {
	private Pane canvas;
	private ArrayList<Image> imageList;
	private ImageView imageView;

	public ArmTransition() {
		
		//adding all images to array list
		imageList.add(new Image("src/main/resource/arm1_1.png"));
		imageList.add(new Image("src/main/resource/arm1_2.png"));
		imageList.add(new Image("src/main/resource/arm2_1.png"));
		imageList.add(new Image("src/main/resource/arm2_2.png"));
		imageList.add(new Image("src/main/resource/arm3_1.png"));
		imageList.add(new Image("src/main/resource/arm3_2.png"));
		imageList.add(new Image("src/main/resource/arm4_1.png"));
		imageList.add(new Image("src/main/resource/arm4_2.png"));
		
	}
	
	
}
