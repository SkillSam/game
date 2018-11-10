package me.skillsam;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;

public class Main {
	
	public void start() {
		try {
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
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