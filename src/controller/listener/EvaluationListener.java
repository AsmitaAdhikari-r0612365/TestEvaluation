/*@author Adhikari_Asmita-r0612365 
 * https://github.com/AsmitaAdhikari-r0612365/TestEvaluation.git */
package controller.listener;

import controller.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.db.TestService;
import view.panels.TestPane;

public class EvaluationListener implements EventHandler<ActionEvent> {
	private TestService service;
	private Controller controller;
	

	 public EvaluationListener(TestService service, Controller controller) {
		this.service = service;
		this.controller = controller;
	}

	@Override
	public void handle(ActionEvent event){
		TestPane test = new TestPane(service, controller);
		Stage stage = new Stage();
		Scene scene = new Scene(test, 600,400);
		stage.setScene(scene);
		stage.show();
		
	}

	
}
