package controller.listener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.db.TestService;
import view.panels.CategoryOverviewPane;
import view.panels.TestPane;

public class EvaluationListener implements EventHandler<ActionEvent> {
	private TestService service;
	

	 public EvaluationListener(TestService service) {
		this.service = service;
	}

	@Override
	public void handle(ActionEvent event){
		TestPane test = new TestPane(service);
		Stage stage = new Stage();
		Scene scene = new Scene(test, 600,400);
		stage.setScene(scene);
		stage.show();
		
		
	}

	
}
