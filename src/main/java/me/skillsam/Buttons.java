package me.skillsam;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.TilePane;

public class Buttons extends TilePane
{
	private RadioButton weight1, weight2, weight3, weight4, weight5;
	private ToggleGroup group;
	
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
		
		this.getChildren().addAll(weight1, weight2, weight3, weight4, weight5);
		
	}
}
