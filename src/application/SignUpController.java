package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SignUpController extends Application implements Initializable{
		
		// 회원가입
		@FXML private Button signupBt;
		@FXML private Button cancelBt;
		
		// 회원가입 창 입력 값
		@FXML private AnchorPane signUpPane;
		@FXML private TextField textName;
		@FXML private TextField textId;
		@FXML private TextField textPass;
		@FXML private ComboBox<String> comboTel;
		@FXML private TextField textTel1;
		@FXML private TextField textTel2;
		@FXML private ToggleGroup groupGender;
		@FXML private RadioButton manRadio;
		@FXML private RadioButton womanRadio;
		@FXML private TextField textAdd;
		
		String strSelectGender = "";
		
		@FXML
		void strSelectGender(ActionEvent event) {
			if(manRadio.isSelected()) {
				strSelectGender = manRadio.getText();
			}else if(womanRadio.isSelected()) {
				strSelectGender = womanRadio.getText();
			}
		}
		
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
		}
		
		// 회원가입 창 이벤트 메서드
		public void handlecancelBt(ActionEvent event) { // 회원가입 창 취소 버튼
			try {
				Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
				Scene scene = new Scene(login);
				Stage primaryStage = (Stage)cancelBt.getScene().getWindow();
				primaryStage.setScene(scene);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		public void handleSignupBt(ActionEvent event) throws IOException { // 회원가입 버튼
			String name = textName.getText().toString();
			String id = textId.getText().toString();
			String pw = textPass.getText().toString();
			String tel0 = comboTel.getPromptText();
			String tel1 = textTel1.getText();
			String tel2 = textTel2.getText();
			String phone = (tel0 + tel1 + "-" + tel2);
			String gender = strSelectGender.toString();
			String address = textAdd.getText().toString();
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest", "mytest");
				pstmt = con.prepareStatement(
						"insert into member(name, id, pw, gender, phone, address)"
						+ " values (?, ?, ?, ?, ?, ?)");
				pstmt.setString(1, name);
				pstmt.setString(2, id);
				pstmt.setString(3, pw);
				pstmt.setString(4, gender);
				pstmt.setString(5, phone);
				pstmt.setString(6, address);
				pstmt.executeUpdate();
				
				if(pstmt != null) {
					Node node = (Node) event.getSource();
					Stage stage = (Stage)node.getScene().getWindow();
					stage.close();
					
					Scene Scene = new Scene(FXMLLoader.load(getClass().getResource("SignUpDialog.fxml")));
					stage.setScene(Scene); 
					stage.show();
				}
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {if(pstmt != null) pstmt.close();} catch (SQLException e) {}
				try {if(con != null) con.close();} catch (SQLException e) {}
			}
		}
		
		@Override
		public void start(Stage primaryStage) throws Exception {
		}
}
