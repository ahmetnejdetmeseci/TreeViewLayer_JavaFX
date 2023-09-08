package Controller;

import AbstractModel.CustomContextMenu;
import AbstractModel.MapLayerContextMenu;
import AbstractModel.UserLayerContextMenu;
import Main.ContextMenuSingleton;
import Model.TreeItemModel;
import View.ContextMenuView;
import View.TreeViewLayerView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.stage.Stage;

public class TreeViewController {
    private TreeItemModel model;
    private TreeViewLayerView view;

    private boolean isOpen = true;
    
	ContextMenuSingleton contextMenuSingleton = new ContextMenuSingleton();
    
    public TreeViewController(TreeItemModel model, TreeViewLayerView view) {
        this.model = model;
        this.view = view;
        
        view.updateTreeViewTreeCell(this.model.getTreeView());
        view.getChildren().add(model);
        
        this.model.getTreeView().setOnMousePressed( event -> {

        	if (event.isSecondaryButtonDown() && event.getTarget() instanceof TreeCell) {

        		TreeItem<String> selectedItem = this.model.getTreeView().getSelectionModel().getSelectedItem();
        		
        		if(selectedItem != null) {
        			
        		
        			if(TreeViewHandlers.isDescendant(selectedItem, TreeViewHandlers.findTreeItem(this.model.getTreeView().getRoot(), "KULLANICI KATMANLARI"))) {
        				
        				CustomContextMenu contextMenuModel = new UserLayerContextMenu();
                		
        				this.contextMenuSingleton.castContextMenuToChild(contextMenuModel);

                		handleContextMenuMain(event.getScreenX(), event.getScreenY());
        			
        			}else if(TreeViewHandlers.isDescendant(selectedItem, TreeViewHandlers.findTreeItem(this.model.getTreeView().getRoot(), "GOOGLE HARITALAR"))) {
        				
        				CustomContextMenu contextMenuModel = new MapLayerContextMenu();
                		
        				this.contextMenuSingleton.castContextMenuToChild(contextMenuModel);

                		handleContextMenuMain(event.getScreenX(), event.getScreenY());
        			}else {
        				
        				CustomContextMenu contextMenuModel = new UserLayerContextMenu();
                		
        				this.contextMenuSingleton.castContextMenuToChild(contextMenuModel);

                		handleContextMenuMain(event.getScreenX(), event.getScreenY());
        				
        			}
        			
        		}
        		
            }else {
            	
            	if(isOpen) {
            		handleContextMenuHide();
            		isOpen = false;
            	}else {
            		isOpen = true;
            	}
            	
            }
        });

    }


	private void handleContextMenuHide() {
		
		this.contextMenuSingleton.getContextMenuController().sleepContextMenu();
	}


	private void handleContextMenuMain(double screenX, double screenY) {

		this.contextMenuSingleton.getContextMenuController().awakeContextMenu(this.model.getTreeView(), screenX, screenY);
		
	}


	public TreeViewLayerView getView() {
        return view;
    }
    
    
}
