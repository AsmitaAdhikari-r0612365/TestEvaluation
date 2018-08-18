/*@author Adhikari_Asmita-r0612365 
 * https://github.com/AsmitaAdhikari-r0612365/TestEvaluation.git */
package controller.listener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import view.panels.DetailPane;

public class CancelHandler implements EventHandler<ActionEvent>{
	private DetailPane detail;	

	public CancelHandler(DetailPane detail) {
		this.detail = detail;
	}


	@Override
	public void handle(ActionEvent event) {
		Stage stage = (Stage) detail.getScene().getWindow();
		stage.close();
	}

}
