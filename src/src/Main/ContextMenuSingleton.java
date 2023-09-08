package Main;

import AbstractModel.CustomContextMenu;
import Controller.ContextMenuController;
import View.ContextMenuView;

public class ContextMenuSingleton {

	CustomContextMenu contextMenuModel;

	ContextMenuView currentContextMenuView;
	
    ContextMenuController contextMenuController;
	
	public ContextMenuSingleton() {
		
	}
	
	public void castContextMenuToChild(CustomContextMenu model) {
		
		if (currentContextMenuView != null) {
			currentContextMenuView.hide();
        }
		
		this.contextMenuModel = model;
		
		//we switch the opened ones 
		ContextMenuView contextMenuView = new ContextMenuView(model.getObservableList());
		
		this.currentContextMenuView = contextMenuView;
		
		this.currentContextMenuView = new ContextMenuView(model.getObservableList());
		
		this.contextMenuController = new ContextMenuController(this.contextMenuModel, this.currentContextMenuView);
		
	}
	
	
	public ContextMenuController getContextMenuController() {
		return this.contextMenuController;
	}
	
}
