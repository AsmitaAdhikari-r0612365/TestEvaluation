/*@author Adhikari_Asmita-r0612365 
 * https://github.com/AsmitaAdhikari-r0612365/TestEvaluation.git */
package view.panels;

import controller.controller.Controller;
import controller.listener.NewCategoryListener;
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
import model.db.TestService;


public class CategoryOverviewPane extends GridPane {
	private TableView<Category> table = new TableView<>();
	private Button btnNew;
	private Controller controller;
	private CategoryDetailPane catDetail;
	private TestService service;
	 
	
	public CategoryOverviewPane(TestService service) {
		//this.controller = controller;
		this.service = service;
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		this.add(new Label("Categories:"), 0, 0, 1, 1);
		
		table = new TableView<>();
		table.setPrefWidth(REMAINING);
        
		TableColumn nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Category,String>("title"));
        table.getColumns().add(nameCol);
        
        TableColumn descriptionCol = new TableColumn<>("Description");
        descriptionCol.setCellValueFactory(new PropertyValueFactory<Category,String>("description"));
        
        table.getColumns().add(descriptionCol);
		this.add(table, 0, 1, 2, 6);
		
		setDataItems();

		btnNew = new Button("New");
		setNewAction();
		this.add(btnNew, 0, 11, 1, 1);
		
	}
	
	public void setDataItems(){
		table.setItems(service.getCategoryData());
		
	}
	

	public void setNewAction() {
		NewCategoryListener newCat = new NewCategoryListener(this,service);
		btnNew.setOnAction(newCat);
	}

	public void setEditAction(EventHandler<MouseEvent> editAction) {
		table.setOnMouseClicked(editAction);
	}
	
	


}
