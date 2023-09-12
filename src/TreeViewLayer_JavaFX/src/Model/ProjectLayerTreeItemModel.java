package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class ProjectLayerTreeItemModel extends TreeItem<String>{

	String[] dummyLayerNames = { "Alarm Bolgeleri", "Filtre Bolgeleri" };
	
	ObservableList<TreeItem<String>> layerItems = FXCollections.observableArrayList();

	public ProjectLayerTreeItemModel(){
		TreeItem<String> childItem_Layer;
		
		for(String childLayer_Name: dummyLayerNames) {
			childItem_Layer = new TreeItem<String>(childLayer_Name);
			layerItems.add(childItem_Layer);
		}
		
		this.setValue("PROJE KATMANLARI");
		this.getChildren().addAll(layerItems);
		this.setExpanded(true);
	}
}
