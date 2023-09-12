package View;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public abstract class CustomTreeCell extends Pane{
	
	public CustomTreeCell() {}
	
	public void fillContainer() {}
	
	public void setContentPane(VBox container) {
		this.getChildren().add(container);
	}
	
	
}
