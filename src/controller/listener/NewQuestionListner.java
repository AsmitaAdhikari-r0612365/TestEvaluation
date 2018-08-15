package controller.listener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.db.TestService;
import view.panels.QuestionDetailPane;

public class NewQuestionListner implements EventHandler<ActionEvent> {
	private TestService service;
	
	public NewQuestionListner(TestService service) {
		this.service = service;
	}

	@Override
	public void handle(ActionEvent event) {
		QuestionDetailPane question = new QuestionDetailPane(service);
		Stage stage = new Stage();
		Scene scene = new Scene(question,300,300);
		stage.setScene(scene);
		stage.show();
		
	}

}
