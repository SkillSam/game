package me.skillsam;

import java.io.File;
import java.util.ArrayList;

import javafx.scene.image.Image;

public class ArmImages {

	private ArrayList<Image> imageList;
	private File file1, file2, file3, file4, file5, file6, file7, file8;
	private Image image1, image2, image3, image4, image5, image6,image7, image8;
	
	public ArmImages() {
	imageList = new ArrayList<Image>();
	file1 = new File("src/main/resources/arm1_1.png");
	image1 = new Image(file1.toURI().toString());
	imageList.add(image1);
	
	file2 = new File("src/main/resources/arm1_2.png");
	image2 = new Image(file2.toURI().toString());
	imageList.add(image2);
	
	file3 = new File("src/main/resources/arm2_1.png");
	image3 = new Image(file3.toURI().toString());
	imageList.add(image3);
	
	file4 = new File("src/main/resources/arm2_2.png");
	image4 = new Image(file4.toURI().toString());
	imageList.add(image4);
	
	file5 = new File("src/main/resources/arm3_1.png");
	image5 = new Image(file5.toURI().toString());
	imageList.add(image5);
	
	file6 = new File("src/main/resources/arm3_2.png");
	image6 = new Image(file6.toURI().toString());
	imageList.add(image6);
	
	file7 = new File("src/main/resources/arm4_1.png");
	image7 = new Image(file7.toURI().toString());
	imageList.add(image7);
	
	file8 = new File("src/main/resources/arm4_2.png");
	image8 = new Image(file8.toURI().toString());
	imageList.add(image8);
	}
	
	public ArrayList<Image> getList()
	{
		return imageList;
	}
	
}
