package View;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class TreeCellView {
	private static VBox container = new VBox();
	
	public static void specifyTreeCell(String item, boolean hasSlider, ArrayList<String> featuresNames) {
		container.getChildren().clear();
		Label itemName = new Label(item);
        itemName.setAlignment(Pos.TOP_CENTER);
        GridPane btnContainer = new GridPane();
        int countCol = 0;
        int countRow = 0;
        
        if(featuresNames != null) {
        	//countCol and CountRow is to give constraints to the GridPane position.
            for (String label : featuresNames) {
                Button btn = new Button(label);
                GridPane.setConstraints(btn, countCol, countRow);
                countCol++;
                if(countCol == 2) {
                	countRow++;
                	countCol = 0;
                }
                btnContainer.getChildren().add(btn);
            }
        }
        
        container.getChildren().addAll(itemName, btnContainer);
        
        if(hasSlider) {
        	Slider slider = new Slider();
        	container.getChildren().add(slider);
        }

        container.setAlignment(Pos.BOTTOM_LEFT);
	}
	
	public static VBox getCellContent() {
		return container;
	}
	
	
}
