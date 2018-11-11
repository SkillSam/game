package me.skillsam;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Score extends Application {

	private int count = 0;
	private int multiplier = 0;

	@Override
	public void start(Stage stage) throws Exception {
		VBox box = new VBox();
		box.setAlignment(Pos.CENTER);

		final Label label = new Label("Score: " + count);

		Button button = new Button("CLICK");
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				if (multiplier == 0) {
					label.setText("Set an adder!");
				} else {
					count += multiplier;
					label.setText("Score: " + count);
				}
			}
		});

		ToggleGroup group = new ToggleGroup();

		for (int i = 1; i <= 5; i++) {
			RadioButton r = new RadioButton(i + "");
			r.setToggleGroup(group);
			r.setUserData(i);
			r.setFocusTraversable(false);
			box.getChildren().add(r);
		}

		group.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			@Override
			public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
				multiplier = Integer.parseInt(newValue.getUserData().toString());
			}

		});

		box.getChildren().addAll(label, button);

		Scene scene = new Scene(box);
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.SPACE) {
					if (multiplier == 0) {
						label.setText("Set an adder!");
					} else {
						count += multiplier;
						label.setText("Score: " + count);
					}
				}

			}

		});
		
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
		
	}
	
}