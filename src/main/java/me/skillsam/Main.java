package me.skillsam;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Main {
	
	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		while (!Display.isCloseRequested()) {
			Display.update();
		}
		
		Display.destroy();
	}
	
	public static void main(String[] args) {
		
		new Main().start();
		
		int counter = 0, sum = 0;
		
		for (int i = 0; i < 10; i++) {
			counter++;
			sum += i;
		}
		
		System.out.println(counter + " - " + sum);
		
		System.out.println("Hello world!");
		System.out.print("HI");
		System.out.print("Crystal");
		System.out.print("Jill");
	}
	
}