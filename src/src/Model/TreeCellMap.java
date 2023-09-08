package Model;
import java.util.HashMap;
import java.util.Map;

import View.BingMapsTreeCell;
import View.CustomTreeCell;
import View.UserLayerTreeCell;

public class TreeCellMap{
	
	//TRICK TO FOLLOW UP!!!
	
	//In order to see the TreeView's items we may need to get 
	//the TreeView to trace over the items so that we can catch Children of 'KULLANICI KATMANLARI'
	
	private final Map<String, CustomTreeCell> itemGraphics = new HashMap<>();
	
	public TreeCellMap() {
		itemGraphics.put("YUKSEKLIK HARITALARI", new UserLayerTreeCell("YUKSEKLIK HARITALARI"));
		itemGraphics.put("RASTER HARITALAR", new UserLayerTreeCell("RASTER HARITALAR"));
		itemGraphics.put("BING HARITALAR", new BingMapsTreeCell("BING HARITALAR"));
		
		/************************************************************************************/
		//There is a special case for 'KULLANICI KATMANLARI'!!! DO NOT FORGET THAT SPECIALITY
		/************************************************************************************/
		
		itemGraphics.put("KULLANICI KATMANLARI", new UserLayerTreeCell("KULLANICI KATMANLARI"));
	}
	
	public Map<String, CustomTreeCell> getItemsGraphics(){
		return this.itemGraphics;
	}
	
}
