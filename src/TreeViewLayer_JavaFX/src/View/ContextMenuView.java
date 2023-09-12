package View;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class ContextMenuView extends ContextMenu{

	ObservableList<MenuItem> mainLayers = FXCollections.observableArrayList();
	
	public ContextMenuView(ObservableList<MenuItem> mainLayers) {
		this.mainLayers = mainLayers;
		
		this.getItems().addAll(this.mainLayers);
	}

	
}
