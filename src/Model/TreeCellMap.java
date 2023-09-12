package Model;
import java.util.HashMap;
import java.util.Map;

import Controller.TreeViewHandlers;
import View.BingMapsTreeCell;
import View.CustomTreeCell;
import View.UserLayerChildLayerTreeCell;
import View.UserLayerTreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class TreeCellMap{

	private final Map<String, CustomTreeCell> itemGraphics = new HashMap<>();
	
	private final TreeItem<String> rootItem;
	
	public TreeCellMap(TreeView<String> treeView) {
		
		this.rootItem = treeView.getRoot();		
		
		
		itemGraphics.put("YUKSEKLIK HARITALARI", new UserLayerTreeCell("YUKSEKLIK HARITALARI"));
		itemGraphics.put("RASTER HARITALAR", new UserLayerTreeCell("RASTER HARITALAR"));
		itemGraphics.put("BING HARITALAR", new BingMapsTreeCell("BING HARITALAR"));
		
		/************************************************************************************/
		//There is a special case for 'KULLANICI KATMANLARI'!!! DO NOT FORGET THAT SPECIALITY
		/************************************************************************************/
		
		for(TreeItem<String> child: TreeViewHandlers.findTreeItem(this.rootItem, "KULLANICI KATMANLARI").getChildren()) {
			itemGraphics.put(child.getValue(), new UserLayerChildLayerTreeCell(child.getValue()));
		}

		itemGraphics.put("KULLANICI KATMANLARI", new UserLayerTreeCell("KULLANICI KATMANLARI"));
	}
	
	public Map<String, CustomTreeCell> getItemsGraphics(){
		return this.itemGraphics;
	}

	
}
