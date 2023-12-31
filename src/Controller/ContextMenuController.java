package Controller;

import AbstractModel.CustomContextMenu;
import View.ContextMenuView;
import javafx.scene.Node;

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
	
}
