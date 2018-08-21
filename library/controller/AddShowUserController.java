package library.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import library.application.MainApp;
import library.data.Member;


public class EditMemberController implements Initializable {
	
		@FXML
	    private TableView<Member> memberTable;

	    @FXML
	    private TableColumn<Member, String> firstNameColumn;

	    @FXML
	    private TableColumn<Member, String> lastNameColumn;

	    @FXML
	    private Label firstNameLabel;

	    @FXML
	    private Label lastNameLabel;

	    @FXML
	    private Label peselLabel;

	    @FXML
	    private Label booksLabel;

	    @FXML
	    private Button newUserButton;

	    @FXML
	    private Button editButton;

	    @FXML
	    private Button deleteButton;
	    
	    private MainApp mainApp;
	    
	    public EditMemberController() {}
	    
	    private void showMemberDetails(Member member) {
	    	if(member != null) {
	    		//Fill the blank labels with infos from member object
	    		firstNameLabel.setText(member.getFirstName());
	    		lastNameLabel.setText(member.getLastName());
	    		peselLabel.setText(member.getPesel());
	    		booksLabel.setText(member.getBooks());
	    	}
	    	else {
	    		//if no member, remove all the text
	    		firstNameLabel.setText("");
	    		lastNameLabel.setText("");
	    		peselLabel.setText("");
	    		booksLabel.setText("");
	    	}
	    }
	    
	    @FXML
	    private void addNewMember() {
	    	Member tempMember = new Member();
	    	boolean okClicked = mainApp.showNewMemberDialog(tempMember);
	    	if(okClicked) {
	    		mainApp.getMemberData().add(tempMember);
	    	}
	    }
	    
	    @FXML
	    private void editMember() {
	    	Member selectedMember = memberTable.getSelectionModel().getSelectedItem();
	    	if(selectedMember != null) {
	    		boolean okClicked = mainApp.showNewMemberDialog(selectedMember);
	    		if(okClicked) {
	    			showMemberDetails(selectedMember);
	    		}
	    	}
	    	else {
	    		Alert alert = new Alert(AlertType.WARNING);
	            alert.initOwner(mainApp.getPrimaryStage());
	            alert.setTitle("No Selection");
	            alert.setHeaderText("No Person Selected");
	            alert.setContentText("Please select a person in the table.");

	            alert.showAndWait();
	    	}
	    }
	    
	    @FXML
	    private void handleDeleteMember() {
	    	int rowSelected = memberTable.getSelectionModel().getSelectedIndex();
	    	if(rowSelected >= 0) {
	    		memberTable.getItems().remove(rowSelected);
	    		//memberTable.getItems().remove(memberTable.getSelectionModel().getSelectedIndex())
	    	}
	    	else {
	    		// Nothing selected.
	            Alert alert = new Alert(AlertType.WARNING);
	            alert.initOwner(mainApp.getPrimaryStage());
	            alert.setTitle("No Selection");
	            alert.setHeaderText("No member selected");
	            alert.setContentText("You have to select a member");
	            alert.showAndWait();
	    	}
	    	;
	    }
	    
	    /*We need to get informed whenever user selects a person in the person table, that means there must
	      be a listen for changes, which is ChangeListener interface with method called changed(...) with 
	      3 parameteres, observable, oldValue, newValue. Here a ChangeListener is created with Java 8 lambda 
	      expression. */
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			//Initialize the member table with two colmns
			firstNameColumn.setCellValueFactory(
	                cellData -> cellData.getValue().firstNameProperty());
	        lastNameColumn.setCellValueFactory(
	                cellData -> cellData.getValue().lastNameProperty());

	        // Clear person details.
	        showMemberDetails(null);

	        // Listen for selection changes and show the person details when changed.
	        memberTable.getSelectionModel().selectedItemProperty().addListener(
	                (observable, oldValue, newValue) -> showMemberDetails(newValue));
			
		}
		
		public void setMainApp(MainApp mainApp) {
	        this.mainApp = mainApp;

	        // Add observable list data to the table
	        memberTable.setItems(mainApp.getMemberData());
	    }
}
