package Controller;

import Model.TreeCellMap;
import View.CustomTreeCell;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.TreeCell;
import javafx.util.Duration;

public class TreeCellRenders extends TreeCell<String>{
	
	private Timeline animation;

	private TreeCellMap treeCellMap = new TreeCellMap();
	private CustomTreeCell object;
	@Override
	public void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
        	
            setText(null);
            
            setGraphic(null);
        
        } else {
            setText(item);
            
            if (isSelected()) {
            	
            	object = treeCellMap.getItemsGraphics().get(item);
            	
            	if(object != null) {
            		setText(null);
            		object.fillContainer();
            		setGraphic(object);
            	}

                setStyle("-fx-background-color: linear-gradient(#9933FF, #33FFFF); -fx-font-weight: bold; -fx-text-fill: brown;");
                animateSize(160);
                
            } else {
                setStyle("-fx-font-weight: bold; -fx-text-fill: #202020; -fx-background-color: linear-gradient(#808080, #FFFF33);"); // Reset style
                animateSize(40);
                setGraphic(null);
            }
        }
    }
	
    private void animateSize(double targetHeight) {
        if (animation != null) {
        }

        animation = new Timeline(
            new KeyFrame(Duration.millis(200), new KeyValue(prefHeightProperty(), targetHeight))
        );
        animation.play();
    }

}
