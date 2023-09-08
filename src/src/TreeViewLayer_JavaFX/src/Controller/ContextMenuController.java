package Controller;

import AbstractModel.CustomContextMenu;
import View.ContextMenuView;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.MenuItem;

public class ContextMenuController {

	CustomContextMenu contextMenuModel;
	
	ContextMenuView contextMenuView;
	
	public ContextMenuController(CustomContextMenu contextMenuModel, ContextMenuView contextMenuView) {
		
		this.contextMenuModel = contextMenuModel;
		
		this.contextMenuView = contextMenuView;
	
	}
	
	public void awakeContextMenu(Node window, double screenX, double screenY) {
		
		this.contextMenuView.show(window, screenX, screenY);	
	}
	
	public void sleepContextMenu() {
		this.contextMenuView.hide();
	}
	
//	public void setContextMenuModel(ObservableList<MenuItem> mainLayers) {
//		this.contextMenuView.populateContextMenu(mainLayers);
//	}
	
}
