package controller.listener;

import domain.Category;
import domain.TestService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.panels.CategoryDetailPane;

public class AddCategoryListener implements EventHandler<ActionEvent> {
	private CategoryDetailPane detail;
	private TestService service;
	
	
	
	public AddCategoryListener(CategoryDetailPane detail, TestService service) {
		this.detail = detail;
		this.service = service;
	}

	@Override
	public void handle(ActionEvent event) {
		Category cat = new Category();
		cat.setTitle(detail.getTitle());
		cat.setDescription(detail.getDescription());
		service.addCategory(cat);
		detail.clearFields();
		Stage stage = (Stage)detail.getScene().getWindow();
		stage.close();
		
	}

}
