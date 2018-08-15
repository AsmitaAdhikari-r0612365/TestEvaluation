package view.panels;

import controller.listener.NewQuestionListner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import model.Category;
import model.Question;
import model.TestService;

public class QuestionOverviewPane extends GridPane {
	private TableView table;
	private Button btnNew;
	private TestService service;
	
	public QuestionOverviewPane(TestService service ) {
		this.service = service;
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		this.add(new Label("Questions:"), 0, 0, 1, 1);
		
		table = new TableView<>();
		table.setPrefWidth(REMAINING);
       
		TableColumn nameCol = new TableColumn<>("Question");
        nameCol.setCellValueFactory(new PropertyValueFactory<Question, String>("question"));
        table.getColumns().add(nameCol);
        
        TableColumn descriptionCol = new TableColumn<>("Category");
        descriptionCol.setCellValueFactory(new PropertyValueFactory<Question,String>("category"));
        table.getColumns().add(descriptionCol);
		this.add(table, 0, 1, 2, 6);
		
		table.setItems(service.getQuestionData());
		
		btnNew = new Button("New");
		setNewAction();
		this.add(btnNew, 0, 11, 1, 1);
	}
	
	public void setNewAction() {
		NewQuestionListner newQue = new NewQuestionListner(service);
		btnNew.setOnAction(newQue);
	}
	
	public void setEditAction(EventHandler<MouseEvent> editAction) {
		table.setOnMouseClicked(editAction);
	}

}
