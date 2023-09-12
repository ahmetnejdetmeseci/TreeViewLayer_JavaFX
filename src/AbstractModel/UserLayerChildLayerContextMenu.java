package AbstractModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

public class UserLayerChildLayerContextMenu extends CustomContextMenu{
		String[] userLayerNames = { "Add", "Delete", "Clear", "Rename" };
		
		ObservableList<MenuItem> userLayers = FXCollections.observableArrayList();
		
		public UserLayerChildLayerContextMenu() {
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
