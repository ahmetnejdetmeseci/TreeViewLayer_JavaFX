package AbstractModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

public abstract class CustomContextMenu{
	
	ObservableList<MenuItem> mainLayers = FXCollections.observableArrayList();
	
	public CustomContextMenu() {
		mainLayers.clear();
	}
	
	
	public ObservableList<MenuItem> getObservableList() {
		
		return this.mainLayers;
	}
	
	public void setObservableList(ObservableList<MenuItem> mainLayers) {
		this.mainLayers = mainLayers;
	}
	
	
}
