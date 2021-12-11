package application;

import java.lang.reflect.Member;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
//		CheckConnection();
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
			AnchorPane Login = (AnchorPane)loader.load();
//			Parent miniProjectLogin = (Parent)FXMLLoader.load(getClass().getResource("Login.fxml"));
			
			Scene scene = new Scene(Login);
			
			primaryStage.setTitle("MyCake");
			primaryStage.setScene(scene);
			primaryStage.show();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
			launch(args); //Main 객체 생성 및 메인 윈도우생성
		}
	
}
