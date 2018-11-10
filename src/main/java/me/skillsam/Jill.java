package me.skillsam;

//import javafx.scene.image.Image;

public class Jill extends BasicGame {
	
	private Image arm1_1 = null;
	private Image arm1_2 = null;
	private Image arm2_1 = null;
	private Image arm2_2 = null;
	private Image arm3_1 = null;
	private Image arm3_2 = null;
	private Image arm4_1 = null;
	private Image arm4_2 = null;
	
	public SetupClass(String title)
	{
		super(title);
	}
	
	public void init(GameContainer container) throws SlickException {
		arm1_1 = new Image("src/main/resources/arm1_1.png");
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