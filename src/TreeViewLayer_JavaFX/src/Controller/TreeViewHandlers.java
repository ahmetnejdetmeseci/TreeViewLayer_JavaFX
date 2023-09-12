package Controller;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class TreeViewHandlers {

	
	public TreeViewHandlers() {}
	
	
	//traces over only one item of the TreeView
	public static TreeItem<String> searchTreeItem(TreeItem<String> root, String value) {

		for (TreeItem<String> child : root.getChildren()) {
			if(child.getValue().equals(value)) {
				return child;
			}else {
            	return null;
            }
        }
        return null;
    }

	//creating Child
	public static void createChild(TreeItem<String> selectedItem, TreeItem<String> newItem) {
		selectedItem.setExpanded(true);
		
		selectedItem.getChildren().add(newItem);
	}
	
	//deleting child
	public static void deleteChild(TreeItem<String> selectedItem) {
		if (selectedItem != null) {
			
			//If the parent is null, parent's parent is null and it is not logical to delete that item
			
			TreeItem<String> parent = selectedItem.getParent();
            if (parent != null) {
                parent.getChildren().remove(selectedItem);
                
            //Program will not enter else part as we say do not delete the first item of the tree view but in case of any update, it is written    
            }
        }
	}
	
	
	//renaming item
	public static void renameChild(TreeItem<String> newTreeItem, TreeItem<String> selectedItem) {
		if(selectedItem != null) {
			selectedItem.setValue(newTreeItem.getValue());
		}
	}
	
	//clearing item
	public static void clearChildren(TreeItem<String> selectedItem) {
		selectedItem.getChildren().clear();
	}
	
	
	
	//traces over the whole tree view
	public static TreeItem<String> findTreeItem(TreeItem<String> root, String value) {
        if (root.getValue().equals(value)) {
            return root;
        } else {
            for (TreeItem<String> child : root.getChildren()) {
                TreeItem<String> result = findTreeItem(child, value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
	
	//Check if it is child of
	public static boolean isDescendant(TreeItem<String> item, TreeItem<String> potentialParent) {
		if (item == potentialParent) {
		    return true;
		}

		for (TreeItem<String> child : potentialParent.getChildren()) {
		    if (isDescendant(item, child)) {
		        return true;
		    }
		}

		return false;
	}
}
