package library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.data.Member;

public class NewMemberDialogController {
	
	private Stage dialogStage;
    private Member member;
    private boolean okClicked = false;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField peselField;

    @FXML
    private TextField booksField;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;
    
    @FXML
    private void initialize() {
    }
    
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setMember(Member member) {
    	this.member = member;
    	firstNameField.setText(member.getFirstName());
    	lastNameField.setText(member.getLastName());
    	peselField.setText(member.getPesel());
    	booksField.setText(member.getBooks());
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk() {
    	if(isInputValid()) {
    		member.setFirstName(firstNameField.getText());
    		member.setLastName(lastNameField.getText());
    		member.setPesel(peselField.getText());
    		member.setBooks(booksField.getText());
    		okClicked = true;
    		dialogStage.close();
    	}
    }
    
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
    
    private boolean isInputValid() {
    	String errorMsg = "";
    	
    	if(firstNameField.getText() == null || firstNameField.getText().length() == 0) {
    		errorMsg += "You have to enter your name!\n";
    	}
    	if(lastNameField.getText() == null || lastNameField.getText().length() == 0) {
    		errorMsg += "You have to enter your family name!\n";
    	}
    	if(peselField.getText() == null || peselField.getText().length() == 0) {
    		errorMsg += "You have to enter your PESEL!\n";
    	} 
    	if(errorMsg.length() == 0) {
    		return true;
    	}else {
    		Alert alert = new Alert(AlertType.ERROR);
    		alert.initOwner(dialogStage);
    		alert.setTitle("Invalid Fields");
    		alert.setHeaderText("Please correct invalid field");
    		alert.setContentText(errorMsg);
    		alert.showAndWait();
    		return false;
    	}
    }

}
