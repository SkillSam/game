package me.skillsam;

import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Jill extends BasicGame {
	
	private Image arm1_1 = null;
	private Image arm1_2 = null;
	private Image arm2_1 = null;
	private Image arm2_2 = null;
	private Image arm3_1 = null;
	private Image arm3_2 = null;
	private Image arm4_1 = null;
	private Image arm4_2 = null;
	private ArrayList<Image> imageList;
	private int count = 0;
	private int i = 0;
	
	public Jill(String title)
	{
		super(title);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		arm1_1 = new Image("src/main/resources/arm1_1.png");
		arm1_2 = new Image("src/main/resources/arm1_2.png");
		arm2_1 = new Image("src/main/resources/arm2_1.png");
		arm2_2 = new Image("src/main/resources/arm2_2.png");
		arm3_1 = new Image("src/main/resources/arm3_1.png");
		arm3_2 = new Image("src/main/resources/arm3_2.png");
		arm4_1 = new Image("src/main/resources/arm4_1.png");
		arm4_2 = new Image("src/main/resources/arm4_2.png");
		imageList.add(arm1_1);
		imageList.add(arm1_2);
		imageList.add(arm2_1);
		imageList.add(arm2_2);
		imageList.add(arm3_1);
		imageList.add(arm3_2);
		imageList.add(arm4_1);
		imageList.add(arm4_2);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_UP))
		{
			
		}
		
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.drawString("Hello World!", 20, 20);
		g.drawImage(imageList.get(i), 100, 100);
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Jill("Setup test"));
		
		app.setDisplayMode(800, 600, false);
		app.setAlwaysRender(true);
		
		app.start();
	}
}