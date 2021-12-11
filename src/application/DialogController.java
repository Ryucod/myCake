package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DialogController extends Application implements Initializable{
	
	// 회원가입 다이알로그
	@FXML private Button btnSignUpOK;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void dialogCheckBt(ActionEvent event) {
		try {
			Parent dialog = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(dialog);
			Stage primaryStage = (Stage)btnSignUpOK.getScene().getWindow();
			primaryStage.setScene(scene);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}
}
