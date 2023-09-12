package Model;

import AbstractModel.CustomContextMenu;
import AbstractModel.MapLayerContextMenu;
import AbstractModel.UserLayerChildLayerContextMenu;
import AbstractModel.UserLayerContextMenu;
import Controller.TreeViewHandlers;
import Main.ContextMenuSingleton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class TreeItemModel extends TreeView<String>{
	
	String[] treeViewItemNames = { "YUKSEKLIK HARITALARI", "SIB HARITALARI", "GOOGLE HARITALAR", "YANDEX HARITALAR", "BING HARITALAR", "OVIHERE HARITALAR", "RASTER HARITALAR",
			"DENIZ HARITALARI", "VEKTOR HATIRALAR", "YUKSEKLIK ANALIZLERI"};

	ObservableList<TreeItem<String>> mainLayers = FXCollections.observableArrayList();
	
    private TreeItem<String> root;

    private boolean isOpen = false;
    
	ContextMenuSingleton contextMenuSingleton = new ContextMenuSingleton();
    
	CustomContextMenu contextMenuModel;
    
    public TreeItemModel() {
    	
        root = new TreeItem<>("Root");
        init_TreeViewRootItem();
        this.setRoot(root);
        this.setShowRoot(false);
        
        this.setPrefWidth(500);
        this.setPrefHeight(600);
        initializeContextMenus();

    }
    
    private void init_TreeViewRootItem() {
    	TreeItem<String> childLayer;
    	
    	for(String childLayer_Name: treeViewItemNames) {
    		
			childLayer = new TreeItem<String>(childLayer_Name);
			childLayer.setExpanded(true);
			mainLayers.add(childLayer);
		
    	}

    	mainLayers.add(new UserLayerTreeItemModel());
    	mainLayers.add(new ProjectLayerTreeItemModel());
    	
		root.getChildren().addAll(mainLayers);
		root.setExpanded(true);
	}
    

    //We will create well-structured ContextMenus
    private void initializeContextMenus() {
        this.setOnMousePressed(event -> {
            if (event.isSecondaryButtonDown()) {
                TreeItem<String> selectedItem = this.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    isOpen = true;
                    CustomContextMenu contextMenuModel = getContextForSelectedItem(selectedItem);
                    contextMenuSingleton.castContextMenuToChild(contextMenuModel);
                    handleContextMenuMain(event.getScreenX(), event.getScreenY());
                }
            } else {
                isOpen = !isOpen;
                if (!isOpen) {
                    handleContextMenuHide();
                }
            }
        });
    }

    //
    //we will try to make it nice structure
    //
    private CustomContextMenu getContextForSelectedItem(TreeItem<String> selectedItem) {
        
    	 if (TreeViewHandlers.isDescendant(selectedItem, TreeViewHandlers.findTreeItem(this.getRoot(), "GOOGLE HARITALAR"))) {
            return new MapLayerContextMenu();
        }else if(TreeViewHandlers.isDescendantChildren(selectedItem, TreeViewHandlers.findTreeItem(this.getRoot(), "KULLANICI KATMANLARI"))) {
        	return new UserLayerChildLayerContextMenu();
        } else if (TreeViewHandlers.isDescendant(selectedItem, TreeViewHandlers.findTreeItem(this.getRoot(), "KULLANICI KATMANLARI"))) {
        	System.out.println("Selected Item is : " + selectedItem);
            return new UserLayerContextMenu();
        } else if(TreeViewHandlers.isDescendant(selectedItem, TreeViewHandlers.findTreeItem(this.getRoot(), "YANDEX HARITALAR"))){
            return new MapLayerContextMenu();
        } else if(TreeViewHandlers.isDescendant(selectedItem, TreeViewHandlers.findTreeItem(this.getRoot(), "RASTER HARITALAR"))){
            return new MapLayerContextMenu();
        } else if(TreeViewHandlers.isDescendant(selectedItem, TreeViewHandlers.findTreeItem(this.getRoot(), "DENIZ HARITALARI"))){
            return new MapLayerContextMenu();
        } else if(TreeViewHandlers.isDescendant(selectedItem, TreeViewHandlers.findTreeItem(this.getRoot(), "OVIHERE HARITALAR"))){
            return new MapLayerContextMenu();
        } else if(TreeViewHandlers.isDescendant(selectedItem, TreeViewHandlers.findTreeItem(this.getRoot(), "SIB HARITALARI"))){
            return new MapLayerContextMenu();
        } else if(TreeViewHandlers.isDescendant(selectedItem, TreeViewHandlers.findTreeItem(this.getRoot(), "BING HARITALAR"))){
            return new MapLayerContextMenu();
        } else if(TreeViewHandlers.isDescendant(selectedItem, TreeViewHandlers.findTreeItem(this.getRoot(), "YUKSEKLIK HARITALARI"))){
            return new MapLayerContextMenu();
        } else if(TreeViewHandlers.isDescendant(selectedItem, TreeViewHandlers.findTreeItem(this.getRoot(), "VEKTOR HATIRALAR"))){
            return new MapLayerContextMenu();
        } else {
        	return new UserLayerContextMenu();
        }
    
    }

    private void handleContextMenuHide() {
        contextMenuSingleton.getContextMenuController().sleepContextMenu();
    }

    private void handleContextMenuMain(double screenX, double screenY) {
        contextMenuSingleton.getContextMenuController().awakeContextMenu(this, screenX, screenY);
    }
    
    public TreeView<String> getTreeView(){
    	return this;
    }
}
