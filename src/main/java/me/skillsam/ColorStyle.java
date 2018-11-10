package me.skillsam;

public enum ColorStyle {
	
	GREEN, YELLOW, ORANGE, RED;
	
	public String getStyle() {
		return this.name().toLowerCase() + "-bar";
	}
}