package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Department;
import model.services.DepartmentService;

public class DepartmentListController implements Initializable{

	//Dependência ao DepartmentService
	private DepartmentService service;
	
	//Definir todos os objetos
	@FXML
	private TableView<Department> tableViewDepartment;
	
	@FXML
	private TableColumn<Department,Integer> tableColumnId;
	
	@FXML
	private TableColumn<Department,String> tableColumnName;
	
	private ObservableList<Department> obsList;
	
	@FXML
	private Button btnNew;
	
	//Defini o método de ação
	public void onBtnNewAction() {
		System.out.println("onBtnNewAction");
	}
	
	//Injetar dependencia
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
	}


	private void initializeNodes() {
		//Para iniciar o comportamento das colunas
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
		
		//Para ficar do tamanho total da Janela
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
			
			//recebe os serviços retornados do métodos findAll()
			List<Department> list = service.findAll();
			obsList = FXCollections.observableArrayList(list);
			
			//Para carregar as obslist na TableView
			tableViewDepartment.setItems(obsList);
	}

}
