package controller.listener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.db.TestService;
import view.panels.CategoryDetailPane;
import view.panels.CategoryOverviewPane;

public class NewCategoryListener implements EventHandler<ActionEvent> {
	private CategoryOverviewPane overview;
	private TestService service;
	

	public NewCategoryListener(CategoryOverviewPane overview, TestService service) {
		this.overview = overview;
		this.service = service;
	}


	@Override
	public void handle(ActionEvent event) {
		CategoryDetailPane catDetail = new CategoryDetailPane(overview,service);
		Stage stage = new Stage();
		Scene scene = new Scene(catDetail, 250,150);
		stage.setScene(scene);
		stage.show();
	}

}
