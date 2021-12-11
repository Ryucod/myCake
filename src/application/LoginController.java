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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController extends Application implements Initializable{
	
	// 로그인
	@FXML private TextField loginId;
	@FXML private Label errors;
	@FXML private PasswordField loginPw;
	@FXML private Button loginBt;
	@FXML private Button memberBt;
	@FXML private Button exitBt;
		
	//로그인 창 메서드
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void handlememberBt(ActionEvent event) { // 로그인 창 회원가입 버튼
		try {
			Parent signUp = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
			Scene scene = new Scene(signUp);
			Stage primaryStage = (Stage)memberBt.getScene().getWindow();
			primaryStage.setScene(scene); 
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void handleloginBt(ActionEvent event) throws IOException { // 로그인 창 로그인 버튼			
		String id = loginId.getText().toString();
		String pw = loginPw.getText().toString();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest", "mytest");
			pstmt = con.prepareStatement("select id, pw from member where id = ? and pw = ?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			if(!rs.next()) {
				errors.setTextFill(Color.TOMATO);
				errors.setText("Enter Correct ID/Password");
				System.err.println("Wrong Login");
			}else {
				errors.setTextFill(Color.GREEN);
				errors.setText("Login Successful");
				System.out.println("Successful Login");
				if(rs.getString("id").equals("admin") && rs.getString("pw").equals("123")) {
					Node node = (Node) event.getSource();
					Stage stage = (Stage)node.getScene().getWindow();
					stage.close();
					
					Scene Scene = new Scene(FXMLLoader.load(getClass().getResource("Main.fxml")));
					stage.setScene(Scene); 
					stage.show();
				}else if(rs.getString("id").equals(id) && rs.getString("pw").equals(pw)) {
					Node node = (Node) event.getSource();
					Stage stage = (Stage)node.getScene().getWindow();
					stage.close();
					
					Scene Scene = new Scene(FXMLLoader.load(getClass().getResource("MainClient.fxml")));
					stage.setScene(Scene); 
					stage.show();
				}
			}	
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {if(rs != null) rs.close();} catch (SQLException e) {}
			try {if(pstmt != null) pstmt.close();} catch (SQLException e) {}
			try {if(con != null) con.close();} catch (SQLException e) {}
		}
	}
	
	public void handleexitBt(ActionEvent event) { // 로그인 창 취소 버튼
		Platform.exit();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		memberBt.setOnAction(e-> handlememberBt(e));
		loginBt.setOnAction(e -> {
			try {
				handleloginBt(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
	}

}
