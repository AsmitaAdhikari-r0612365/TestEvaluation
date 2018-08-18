/*@author Adhikari_Asmita-r0612365 
 * https://github.com/AsmitaAdhikari-r0612365/TestEvaluation.git */
package controller.listener;

import controller.controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.db.TestService;
import view.panels.TestPane;

public class SubmitHandler implements EventHandler<ActionEvent> {
	private TestPane pane;
	private TestService service;
	private int counter;
	private Controller controller;
	
	public SubmitHandler(TestPane pane,TestService service, Controller controller) {
		this.controller = controller;
		this.pane = pane;
		this.service = service;
		counter = 0;
	}

	@Override
	public void handle(ActionEvent event) {
		String answer = pane.getSelectedStatements().toString().replace('[', ' ').replace(']',' ');
		System.out.println(answer);
		if(service.isCorrectAnswer(answer.trim())){
			System.out.println("Correct");
			service.saveAnswers(service.haalQuestion(), true);
			if(counter+1 == service.getQuestionData().size())
				this.closeScene();
			else
				this.getNextQuestion();
		}else{
			System.out.println("Wrong");
			service.saveAnswers(service.haalQuestion(), false);
			if(counter +1 == service.getQuestionData().size())
				this.closeScene();
			else
				this.getNextQuestion();
		}		
		
	}
	
	private void getNextQuestion() {
		counter++;
		pane.newQuestion();
		
	}

	public void closeScene(){
		Stage stage = (Stage)pane.getScene().getWindow();
		stage.close();
		this.controller.getMsgPane().showScores();
		stage.show();
		
	}
	
	

}
