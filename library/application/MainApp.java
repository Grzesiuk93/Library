package library.application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import library.controller.EditMemberController;
import library.controller.NewMemberDialogController;
import library.data.Member;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;



public class MainApp extends Application {
	private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Member> memberData = FXCollections.observableArrayList();
	
	@Override
	public void start(Stage primaryStage){ //called automatically when the app is launched from main method
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout();
        showMemberOverview();
	}
	
	// Initializes Root Layout
	public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/library/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	// Shows the member overview inside the root layout
	public void showMemberOverview() {
        try {
            //Load member overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/library/view/EditMemberPane.fxml"));
            AnchorPane memberOverview = (AnchorPane) loader.load();

            //Set member overview into the center of root layout.
            rootLayout.setCenter(memberOverview);
            
            //Gives the controller an access to the main app.
            EditMemberController controller = loader.getController();
            controller.setMainApp(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public boolean showNewMemberDialog(Member member) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
	        FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("/library/view/NewMemberDialog.fxml"));
	        AnchorPane page = (AnchorPane) loader.load();

	        // Create the dialog Stage.
	        Stage dialogStage = new Stage();
	        dialogStage.setTitle("Edit Person");
	        dialogStage.initModality(Modality.WINDOW_MODAL);//set modality of the stage that block input events
	        //from being delivered to all windows from its owner to its root.
	        dialogStage.initOwner(primaryStage);
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);

	        // Set the member into the controller.
	        NewMemberDialogController controller = loader.getController();
	        controller.setDialogStage(dialogStage);
	        controller.setMember(member);
	        
	        // Show the dialog and wait until the user closes it
	        dialogStage.showAndWait();
	        
	        return controller.isOkClicked();
	    } catch (IOException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public ObservableList<Member> getMemberData() {
        return memberData;
    }
	
	public Stage getPrimaryStage() {
        return primaryStage;
    }
	
    public static void main(String[] args) {
        launch(args);
    }
}
