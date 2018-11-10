package me.skillsam;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Progress extends Pane {
	
	private ProgressBar bar;
	
	public Progress() {
		this.bar = new ProgressBar(1);
		this.start();
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
		VBox vbox = new VBox();
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(10));
		
		ObservableList<String> css = vbox.getStylesheets();
		css.add(this.getClass().getResource("style.css").toExternalForm());
		
		this.setBarStyle(bar, ColorStyle.GREEN);
		bar.setMinSize(600, 50);
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
		
		vbox.getChildren().add(bar);
	}
	
}