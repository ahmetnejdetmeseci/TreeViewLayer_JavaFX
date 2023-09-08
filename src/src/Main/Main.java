package Main;

import Controller.TreeViewController;
import Model.TreeItemModel;
import View.TreeViewLayerView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
    	
    	TreeItemModel model = new TreeItemModel();
    	
    	TreeViewLayerView view = new TreeViewLayerView();
    	
        TreeViewController controller = new TreeViewController(model, view);
        
        Scene scene = new Scene(view);
        
//        scene.getStylesheets().add("styles.css");
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("TreeView Example");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
