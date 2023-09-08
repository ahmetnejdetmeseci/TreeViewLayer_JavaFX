package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class UserLayerTreeCell extends CustomTreeCell{

	private VBox container = new VBox();
	private String name;
	
	public UserLayerTreeCell(String item) {
		
		this.name = item;
	
	}
	
	@Override
	public void fillContainer() {
		GridPane btnContainer = new GridPane();
        int countCol = 0;
        int countRow = 0;
        Label itemName = new Label(this.name);
        itemName.setAlignment(Pos.TOP_CENTER);
        String[] featuresNames = {"Click", "Me"};
		//countCol and CountRow is to give constraints to the GridPane position.
        for (String label : featuresNames ) {
            Button btn = new Button(label);
            GridPane.setConstraints(btn, countCol, countRow);
            countCol++;
            if(countCol == 2) {
            	countRow++;
            	countCol = 0;
            }
            btnContainer.getChildren().add(btn);
        } 	
        
        this.container.getChildren().addAll(itemName, btnContainer);
        
        super.setContentPane(container);
        
        this.container = new VBox();

	}

}
