


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {
	
	Button _1;
	Button _2;
	Button _3;
	Button _4;
	Button _5;
	
	Label label;
	
	TextField txt;
	
	HBox h1;
	HBox h2;

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	
	DataManager dm;
	
	//student Task #4:
	//  declare an instance of DataManager
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		
		_1 = new Button("Hello");
		_2 = new Button("Howdy");
		_3 = new Button("Chinese");
		_4 = new Button("Clear");
		_5 = new Button("Exit");
		
		label = new Label("Feedback:");
		
		txt = new TextField();
		
		h1 = new HBox();
		h2 = new HBox();

		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		
		dm = new DataManager();
		
		_1.setOnAction(new ButtonHandler());
		_2.setOnAction(new ButtonHandler());
		_3.setOnAction(new ButtonHandler());
		_4.setOnAction(new ButtonHandler());
		_5.setOnAction(new ButtonHandler());
		
		HBox.setMargin(_1, new Insets(10));
		HBox.setMargin(_2, new Insets(10));
		HBox.setMargin(_3, new Insets(10));
		HBox.setMargin(_4, new Insets(10));
		HBox.setMargin(_5, new Insets(10));
		HBox.setMargin(label, new Insets(10));
		HBox.setMargin(txt, new Insets(10));
		
		h1.setAlignment(Pos.CENTER);
		h2.setAlignment(Pos.CENTER);
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		
		h1.getChildren().addAll(_1, _2, _3, _4, _5);
		h2.getChildren().addAll(label, txt);
		
		getChildren().addAll(h1, h2);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent event) {
			
			if(event.getTarget() == _1) {
				txt.setText(dm.getHello());
			}
			else if(event.getTarget() == _2) {
				txt.setText(dm.getHowdy());
			}
			else if(event.getTarget() == _3) {
				txt.setText(dm.getChinese());
			}
			else if(event.getTarget() == _4) {
				txt.setText("");
			}
			else if(event.getTarget() == _5) {
				Platform.exit();
				System.exit(0);
			}
			
			
		}
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
}
	
