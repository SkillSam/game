package me.skillsam;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.GridPane;

public class Progress extends GridPane {
	
	private ProgressBar bar;
	private Score score;
	private double energy, maxEnergy;
	
	public Progress(Score score) {
		this.score = score;
		this.bar = new ProgressBar(1);
		this.energy = 100;
		this.maxEnergy = 100;
		this.start();
	}
	
	private void setEnergy(double energy) {
		this.energy = energy;
		if (this.energy > this.maxEnergy) this.energy = this.maxEnergy;
		if (this.energy < 0) this.energy = 0;
	}
	
	public void changeEnergy(double change) {
		this.setEnergy(this.energy + change);
		this.update();
	}
	
	private void update() {
		this.bar.setProgress(energy / maxEnergy);
	}
	
	public ProgressBar getBar() {
		return this.bar;
	}
	
	public void setBarStyle(ProgressBar bar, ColorStyle style) {
		ObservableList<String> list = bar.getStyleClass();
		
		for (ColorStyle colors : ColorStyle.values()) {
			list.remove(colors.getStyle());
		}
		
		bar.getStyleClass().add(style.getStyle());
	}
	
	public void start() {
		ObservableList<String> css = super.getStylesheets();
		css.add(this.getClass().getResource("style.css").toExternalForm());
		
		this.setBarStyle(bar, ColorStyle.GREEN);
		bar.setMinSize(500, 50);
		bar.progressProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				double progress = newValue.doubleValue();
				if (progress > 0.75) {
					setBarStyle(bar, ColorStyle.GREEN);
				} else if (progress > 0.5) {
					setBarStyle(bar, ColorStyle.ORANGE);
				} else if (progress > 0.25) {
					setBarStyle(bar, ColorStyle.YELLOW);
				} else {
					setBarStyle(bar, ColorStyle.RED);
				}
			}
			
		});
		
		super.add(this.score.getLevelLabel(), 0, 0);
		super.add(this.bar, 1, 0);
		super.add(this.score.getScoreLabel(), 2, 0);
		super.setAlignment(Pos.CENTER);
		super.setHgap(10);
	}
	
}