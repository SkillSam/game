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
	

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		// TODO Auto-generated method stub
		arm1_1 = new Image("src/main/resources");
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
}