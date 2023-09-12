package AbstractModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

public class MapLayerContextMenu extends CustomContextMenu{

	String[] userLayerNames = { "Google", "Bing", "Yandex", "Apple" };
	
	ObservableList<MenuItem> userLayers = FXCollections.observableArrayList();
	
	public MapLayerContextMenu() {
		userLayers.clear();
		super.getObservableList().clear();
		if(userLayers.isEmpty()) {
			MenuItem menuItem;
			
			for (String name : userLayerNames) {
				menuItem = new MenuItem(name);
				userLayers.add(menuItem);
			}
			
		}
		super.setObservableList(this.userLayers);
	}
	
}
