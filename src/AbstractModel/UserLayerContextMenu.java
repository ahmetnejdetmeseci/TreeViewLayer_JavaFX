package AbstractModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;

public class UserLayerContextMenu extends CustomContextMenu{

	String[] userLayerNames = { "Nejdet", "Duru", "Canik", "AK47", "Wincheaster", "Baretta", "AUG-312" };
	
	ObservableList<MenuItem> userLayers = FXCollections.observableArrayList();
	
	public UserLayerContextMenu() {
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
	
//	@Override
//	public void initializeContextMenu() {
//		MenuItem menuItem;
//		
//		for (String name : userLayerNames) {
//			menuItem = new MenuItem(name);
//			userLayers.add(menuItem);
//		}
//		
//		super.setObservableList(this.userLayers);
//	}
}
