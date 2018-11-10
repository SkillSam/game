package me.skillsam;

import org.newdawn.slick.AppGameContainer;
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

	@Override
	public void init(GameContainer arg0) throws SlickException {
		arm4_1 = new Image("src/main/resources/arm4_1.png");
		
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.drawString("Hello World!", 20, 20);
		g.drawImage(arm4_1, 100, 100);
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new Jill("Setup test"));
		
		app.setDisplayMode(800, 600, false);
		app.setAlwaysRender(true);
		
		app.start();
	}
}