package application;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class MainController implements Initializable {
	
	//멤버필드===================================================================================
	//주문 탭
	@FXML private Button sizeBt1;
	@FXML private Button sizeBt2;
	@FXML private Button sizeBt3;
	@FXML private Button flavorBt1;
	@FXML private Button flavorBt2;
	@FXML private Button flavorBt3;
	@FXML private Button shapeBt1;
	@FXML private Button shapeBt2;
	@FXML private Button shapeBt3;
	@FXML private Button creamBt1;
	@FXML private Button creamBt2;
	@FXML private Button creamBt3;
	@FXML private TableView<Order1> order1;
	@FXML private TableColumn<Order1, String> orderList1;
	@FXML private TableColumn<Order1, String> price1;
	@FXML private TextField orderTotal;	
	@FXML private Button orderBt;	
	@FXML private Button resetBt;	
	
	//디자인 탭
	@FXML Canvas canvas; 
	GraphicsContext gc;
	
	//주문조회 탭
	@FXML private TableView<Order2> order2;
	@FXML private TableColumn<Order2, String> orderList2;
    @FXML private TableColumn<Order2, String> price2;
    
	//회원관리 탭
	@FXML private TableView<Users> table_users;
    @FXML private TableColumn<Users, Integer> col_no;
    @FXML private TableColumn<Users, String> col_id;
    @FXML private TableColumn<Users, String> col_pw;
    @FXML private TableColumn<Users, String> col_name;
    @FXML private TableColumn<Users, String> col_gender;
    @FXML private TableColumn<Users, String> col_phone;
    @FXML private TableColumn<Users, String> col_address;
    
    @FXML private Button saveBt;
	@FXML private Button deleteBt;
	
	private ObservableList<Order2> o2List;
	private ObservableList<Order1> o1List;
	private ObservableList<Users> list;
	//SqlConnect is the connection class
	private SqlConnect sqlConnect;
	Connection conn = null;
	
	//매출현황 탭
	
	
	//end 멤버변수==========================================================================================
	//주문 탭
	
	private void orderBt(ActionEvent event) {
		showData();
	}
	
	@FXML
    private void size1(ActionEvent event) {
		sqlConnect = new SqlConnect();
		
		orderList1.setCellValueFactory(new PropertyValueFactory<>("orderList1"));
		price1.setCellValueFactory(new PropertyValueFactory<>("price1"));
		
		o1List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order1 where orderList='크기(1호)'";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order1 cm = new Order1(SQL, SQL);
	            cm.orderList1.set(rs.getString("orderList"));
	            cm.price1.set(rs.getString("price"));
	            o1List.addAll(cm);                  
	        }
	        order1.setItems(o1List);
	    }
	    catch(Exception e){
	          e.printStackTrace();      
	    }
    }
	@FXML
	private void size2(ActionEvent event) {
		sqlConnect = new SqlConnect();
		
		orderList1.setCellValueFactory(new PropertyValueFactory<>("orderList"));
		price1.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		o1List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order1 where orderList='크기(2호)'";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order2 cm = new Order2(SQL, SQL);
	            cm.orderList2.set(rs.getString("orderList"));
	            cm.price2.set(rs.getString("price"));
	            o2List.addAll(cm);                  
	        }
	        order2.setItems(o2List);
	    }
	    catch(Exception e){
	          e.printStackTrace();      
	    }
	}
	@FXML
	private void size3(ActionEvent event) {
		sqlConnect = new SqlConnect();
		
		orderList1.setCellValueFactory(new PropertyValueFactory<>("orderList"));
		price1.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		o1List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order1 where orderList='크기(3호)'";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order2 cm = new Order2(SQL, SQL);
	            cm.orderList2.set(rs.getString("orderList"));
	            cm.price2.set(rs.getString("price"));
	            o2List.addAll(cm);                  
	        }
	        order2.setItems(o2List);
	    }
	    catch(Exception e){
	          e.printStackTrace();      
	    }
	}
	@FXML
	private void flavor1(ActionEvent event) {
		sqlConnect = new SqlConnect();
		
		orderList1.setCellValueFactory(new PropertyValueFactory<>("orderList"));
		price1.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		o1List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order1 where orderList='시트(바닐라)'";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order2 cm = new Order2(SQL, SQL);
	            cm.orderList2.set(rs.getString("orderList"));
	            cm.price2.set(rs.getString("price"));
	            o2List.addAll(cm);                  
	        }
	        order2.setItems(o2List);
	    }
	    catch(Exception e){
	          e.printStackTrace();      
	    }
	}
	@FXML
	private void flavor2(ActionEvent event) {
		sqlConnect = new SqlConnect();
		
		orderList1.setCellValueFactory(new PropertyValueFactory<>("orderList"));
		price1.setCellValueFactory(new PropertyValueFactory<>("price"));
		//변경
		o1List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order1 where orderList='시트(초코)'";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order2 cm = new Order2(SQL, SQL);
	            cm.orderList2.set(rs.getString("orderList"));
	            cm.price2.set(rs.getString("price"));
	            o2List.addAll(cm);                  
	        }
	        order2.setItems(o2List);
	    }
	    catch(Exception e){
	          e.printStackTrace();      
	    }
	}
	@FXML
	private void flavor3(ActionEvent event) {
		sqlConnect = new SqlConnect();
		
		orderList1.setCellValueFactory(new PropertyValueFactory<>("orderList"));
		price1.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		o1List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order1 where orderList='시트(얼그레이)'";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order2 cm = new Order2(SQL, SQL);
	            cm.orderList2.set(rs.getString("orderList"));
	            cm.price2.set(rs.getString("price"));
	            o2List.addAll(cm);                  
	        }
	        order2.setItems(o2List);
	    }
	    catch(Exception e){
	          e.printStackTrace();      
	    }
	}
	@FXML
	private void shape1(ActionEvent event) {
		sqlConnect = new SqlConnect();
		
		orderList1.setCellValueFactory(new PropertyValueFactory<>("orderList"));
		price1.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		o1List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order1 where orderList='모양(원형)'";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order2 cm = new Order2(SQL, SQL);
	            cm.orderList2.set(rs.getString("orderList"));
	            cm.price2.set(rs.getString("price"));
	            o2List.addAll(cm);                  
	        }
	        order2.setItems(o2List);
	    }
	    catch(Exception e){
	          e.printStackTrace();      
	    }
	}
	@FXML
	private void shape2(ActionEvent event) {
		sqlConnect = new SqlConnect();
		
		orderList2.setCellValueFactory(new PropertyValueFactory<>("orderList"));
		price2.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		o1List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order1 where orderList='모양(하트)'";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order1 cm = new Order1(SQL, SQL);
	            cm.orderList1.set(rs.getString("orderList"));
	            cm.price1.set(rs.getString("price"));
	            o1List.addAll(cm);                  
	        }
	        order2.setItems(o2List);
	    }
	    catch(Exception e){
	          e.printStackTrace();      
	    }
	}
	@FXML
	private void shape3(ActionEvent event) {
		sqlConnect = new SqlConnect();
		
		orderList1.setCellValueFactory(new PropertyValueFactory<>("orderList"));
		price1.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		o1List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order1 where orderList='모양(네모)'";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order2 cm = new Order2(SQL, SQL);
	            cm.orderList2.set(rs.getString("orderList"));
	            cm.price2.set(rs.getString("price"));
	            o2List.addAll(cm);                  
	        }
	        order2.setItems(o2List);
	    }
	    catch(Exception e){
	          e.printStackTrace();      
	    }
	}
	@FXML
	private void cream1(ActionEvent event) {
		sqlConnect = new SqlConnect();
		
		orderList1.setCellValueFactory(new PropertyValueFactory<>("orderList"));
		price1.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		o1List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order1 where orderList='크림(생크림)'";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order2 cm = new Order2(SQL, SQL);
	            cm.orderList2.set(rs.getString("orderList"));
	            cm.price2.set(rs.getString("price"));
	            o2List.addAll(cm);                  
	        }
	        order2.setItems(o2List);
	    }
	    catch(Exception e){
	          e.printStackTrace();      
	    }
	}
	@FXML
	private void cream2(ActionEvent event) {
		sqlConnect = new SqlConnect();
		
		orderList1.setCellValueFactory(new PropertyValueFactory<>("orderList"));
		price1.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		o1List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order1 where orderList='크림(오레오)'";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order2 cm = new Order2(SQL, SQL);
	            cm.orderList2.set(rs.getString("orderList"));
	            cm.price2.set(rs.getString("price"));
	            o2List.addAll(cm);                  
	        }
	        order2.setItems(o2List);
	    }
	    catch(Exception e){
	          e.printStackTrace();      
	    }
	}
	@FXML
	private void cream3(ActionEvent event) {
		sqlConnect = new SqlConnect();
		
		orderList1.setCellValueFactory(new PropertyValueFactory<>("orderList"));
		price1.setCellValueFactory(new PropertyValueFactory<>("price"));
		
		o1List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order1 where orderList='크림(크림치즈)'";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order2 cm = new Order2(SQL, SQL);
	            cm.orderList2.set(rs.getString("orderList"));
	            cm.price2.set(rs.getString("price"));
	            o2List.addAll(cm);                  
	        }
	        order2.setItems(o2List);
	    }
	    catch(Exception e){
	          e.printStackTrace();      
	    }
	}
	
	//디자인 탭
	private void draw(){ 
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1);
		
		canvas.setOnMousePressed(e->{
			gc.beginPath();
			gc.lineTo(e.getSceneX(), e.getSceneY());
			gc.stroke();
		});
		canvas.setOnMouseDragged(e->{
			gc.lineTo(e.getSceneX(), e.getSceneY());
			gc.stroke();
		});
	}
	
	@FXML
	private void color(ActionEvent event) {
		ColorPicker cp = new ColorPicker();
		cp.setValue(Color.BLACK);
		gc.setStroke(cp.getValue());
	}
	
	private void slider() {
		Slider sd = new Slider();
		double value = sd.getValue();
		sd.valueProperty().addListener(e->gc.setLineWidth(value));
	}
	
	//주문조회 탭
	private void showData() {
		o2List = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from order2";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Order2 cm = new Order2(SQL, SQL);
	            cm.orderList2.set(rs.getString("orderList"));
	            cm.price2.set(rs.getString("price"));
	            o2List.addAll(cm);                  
	        }
	        order2.setItems(o2List);
	    }
	    catch(Exception e){
	          e.printStackTrace();          
	    }
	}
	
	//회원관리 탭
    @FXML
    private void handleSaveBt(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
    	//connect to the database
    			Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1",
    			                         "mytest", "mytest");
    			
    			//statement query
    			Statement stmt = con.createStatement();
    			ResultSet rs = stmt.executeQuery("select * from member");
    			
    			//Excel
    			XSSFWorkbook workbook = new XSSFWorkbook();
    			XSSFSheet sheet = workbook.createSheet("member data");
    			
    			XSSFRow row = sheet.createRow(0);
    			row.createCell(0).setCellValue("no");
    			row.createCell(1).setCellValue("id");
    			row.createCell(2).setCellValue("pw");
    			row.createCell(3).setCellValue("name");
    			row.createCell(4).setCellValue("gender");
    			row.createCell(5).setCellValue("phone");
    			row.createCell(6).setCellValue("address");
    			
    			int r = 1;
    			while(rs.next()) {
    				int memNo = rs.getInt("no");
    				String memId = rs.getString("id");
    				String memPw = rs.getString("pw");
    				String memName = rs.getString("name");
    				String memGender = rs.getString("gender");
    				String memPhone = rs.getString("phone");
    				String memAddress = rs.getString("address");
    				
    				row = sheet.createRow(r++);
    				
    				row.createCell(0).setCellValue(memNo);
    				row.createCell(1).setCellValue(memId);
    				row.createCell(2).setCellValue(memPw);
    				row.createCell(3).setCellValue(memName);
    				row.createCell(4).setCellValue(memGender);
    				row.createCell(5).setCellValue(memPhone);
    				row.createCell(6).setCellValue(memAddress);
    			}
    			
    			FileOutputStream fos = new FileOutputStream(".\\datafiles\\member.xlsx");
    			workbook.write(fos);
    			
    			workbook.close();
    			fos.close();
    			con.close();
    		
    }
	@FXML
	private void handleDeleteBt(ActionEvent event) {
		
		table_users.getItems().removeAll(table_users.getSelectionModel().getSelectedItem());
		
//		list = FXCollections.observableArrayList();
//	    try{      
//	        String SQL = "delete";            
//	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
//	        while(rs.next()){
//	            Users cm = new Users(0, SQL, SQL, SQL, SQL, SQL, SQL);
//	            cm.no.set(rs.getInt("no"));            
//	            cm.id.set(rs.getString("id"));
//	            cm.pw.set(rs.getString("pw"));
//	            cm.name.set(rs.getString("name"));
//	            cm.gender.set(rs.getString("gender"));
//	            cm.phone.set(rs.getString("phone"));
//	            cm.address.set(rs.getString("address"));
//	            list.addAll((Users) cm);                  
//	        }
//	        table_users.setItems(list);
//	    }
//	    catch(Exception e){
//	          e.printStackTrace();
//	          System.out.println("Error on Building Data");            
//	    }
	}

	//매출현황 탭
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sqlConnect = new SqlConnect();
		col_no.setCellValueFactory(new PropertyValueFactory<>("no"));
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_pw.setCellValueFactory(new PropertyValueFactory<>("pw"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
		sqlConnect = new SqlConnect();
		table_users.setItems(list);
		
		conn = sqlConnect.getConnection();
		buildData();
		showData();
		
		gc = canvas.getGraphicsContext2D(); 
		draw();
		color(null);
		slider();
	}
	
	private void buildData() {
		list = FXCollections.observableArrayList();
	    try{      
	        String SQL = "Select * from member Order By no";            
	        ResultSet rs = conn.createStatement().executeQuery(SQL);  
	        while(rs.next()){
	            Users cm = new Users(0, SQL, SQL, SQL, SQL, SQL, SQL);
	            cm.no.set(rs.getInt("no"));            
	            cm.id.set(rs.getString("id"));
	            cm.pw.set(rs.getString("pw"));
	            cm.name.set(rs.getString("name"));
	            cm.gender.set(rs.getString("gender"));
	            cm.phone.set(rs.getString("phone"));
	            cm.address.set(rs.getString("address"));
	            list.addAll((Users) cm);                  
	        }
	        table_users.setItems(list);
	    }
	    catch(Exception e){
	          e.printStackTrace();          
	    }
		
	}
	
	
//====================================================================================================
public static class Users {
	
	private SimpleIntegerProperty no;
	private SimpleStringProperty id;
	private SimpleStringProperty pw;
	private SimpleStringProperty name;
	private SimpleStringProperty gender;
	private SimpleStringProperty phone;
	private SimpleStringProperty address;
	
	public int getNo() {
		return no.get();
	}
	public void setNo(Integer no) {
		this.no = new SimpleIntegerProperty(no);
	}
	public IntegerProperty noProperty() {
		return no;
	}
	
	public String getId() {
		return id.get();
	}
	public void setId(String id) {
		this.id = new SimpleStringProperty(id);;
	}
	public StringProperty idProperty() {
		return id;
	}
	
	public String getPw() {
		return pw.get();
	}
	public void setPw(String pw) {
		this.pw = new SimpleStringProperty(pw);;
	}
	public StringProperty pwProperty() {
		return pw;
	}
	
	public String getName() {
		return name.get();
	}
	public void setName(String name) {
		this.name = new SimpleStringProperty(name);
	}
	public StringProperty nameProperty() {
		return name;
	}
	
	public String getGender() {
		return gender.get();
	}
	public void setGender(String gender) {
		this.gender = new SimpleStringProperty(gender);
	}
	public StringProperty genderProperty() {
		return gender;
	}
	
	public String getPhone() {
		return phone.get();
	}
	public void setPhone(String phone) {
		this.phone = new SimpleStringProperty(phone);
	}
	public StringProperty phoneProperty() {
		return phone;
	}
	
	public String getAddress() {
		return address.get();
	}
	public void setAddress(String address) {
		this.address = new SimpleStringProperty(address);
	}
	public StringProperty addressProperty() {
		return address;
	}
	//=========================================================================================================
	public Users(int no, String id, String pw, String name, String gender, String phone, String address) {
		super();
		this.no = new SimpleIntegerProperty(no);
		this.id = new SimpleStringProperty(id);
		this.pw = new SimpleStringProperty(pw);
		this.name = new SimpleStringProperty(name);
		this.gender = new SimpleStringProperty(gender);
		this.phone = new SimpleStringProperty(phone);
		this.address = new SimpleStringProperty(address);
	}
}
	public class Order1 {
	
		private SimpleStringProperty orderList1;
		private SimpleStringProperty price1;
		
		public Order1(String orderList1, String price1) {
			super();
			this.orderList1 = new SimpleStringProperty(orderList1);
			this.price1 = new SimpleStringProperty(price1);
		}
	
		public String getOrderList1() {
			return orderList1.get();
		}
		public void setOrderList1(String orderList1) {
			this.orderList1 = new SimpleStringProperty(orderList1);
		}
		public StringProperty orderList1Property() {
			return orderList1;
		}
	
		public String getPrice1() {
			return price1.get();
		}
		public void setPrice1(String price1) {
			this.price1 = new SimpleStringProperty(price1);
		}
		public StringProperty price1Property() {
			return price1;
		}
		
	}
	public class Order2 {
		
		private SimpleStringProperty orderList2;
		private SimpleStringProperty price2;
		
		public Order2(String orderList2, String price2) {
			super();
			this.orderList2 = new SimpleStringProperty(orderList2);
			this.price2 = new SimpleStringProperty(price2);
		}
		
		public String getOrderList2() {
			return orderList2.get();
		}
		public void setOrderList2(String orderList2) {
			this.orderList2 = new SimpleStringProperty(orderList2);
		}
		public StringProperty orderList2Property() {
			return orderList2;
		}
		
		public String getPrice2() {
			return price2.get();
		}
		public void setPrice2(String price2) {
			this.price2 = new SimpleStringProperty(price2);
		}
		public StringProperty price2Property() {
			return price2;
		}
		
	}

}