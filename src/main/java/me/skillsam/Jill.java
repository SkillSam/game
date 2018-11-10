package me.skillsam;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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
	
	public Jill(String title)
	{
		super(title);
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.drawString("Hello World!, 20, 20");
		arm1_1.draw();
	}
	
	public static void(String[] args) throws SlickException {
		AppContainer app = new AppGameContainer(new SetupClass("Setup test"));
		
		app.setDisplayMode(800, 600, false);
		app.setAlwaysRender(true);
		
		app.start();
	}
}