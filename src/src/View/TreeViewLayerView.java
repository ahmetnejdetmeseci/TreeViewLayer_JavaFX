package View;

import Controller.TreeCellRenders;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TreeViewLayerView extends Pane{
    
	public TreeViewLayerView() {

    	
    	
    }
	
	public void updateTreeViewTreeCell(TreeView<String> treeView) {
		
		treeView.setCellFactory(param -> new TreeCellRenders());

	}
}
