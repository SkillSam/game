package me.skillsam;

import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;

public class Score extends TilePane {

	private int score = 0;
	private int level = 1;

	private Label scoreLabel, levelLabel;

	public Score() {
		scoreLabel = new Label("Score: " + score);
		levelLabel = new Label("Level: " + level);
	}

	public boolean ifLevelUp() {
		if (score >= (100 * Math.exp(level))) {
			level++;
			this.levelLabel.setText("Level: " + level);

			return true;
		}

		return false;
	}

	public void addScore(int add) {
		this.score += add;
		this.scoreLabel.setText("Score: " + score);
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		return this.score;
	}

	public Label getScoreLabel() {
		return this.scoreLabel;
	}

	public Label getLevelLabel() {
		return this.levelLabel;
	}

}