/*@author Adhikari_Asmita-r0612365 
 * https://github.com/AsmitaAdhikari-r0612365/TestEvaluation.git */
package controller.listener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.Question;
import model.db.TestService;
import view.panels.QuestionDetailPane;

public class AddQuestionListner implements EventHandler<ActionEvent> {
	private QuestionDetailPane detail;
	private TestService service;

	public AddQuestionListner(QuestionDetailPane detail, TestService service) {
		this.detail = detail;
		this.service = service;
	}

	@Override
	public void handle(ActionEvent event) {
		Question quest = new Question();	
		quest.setQuestion(detail.getQuestion());
		quest.setCategory(service.getCategoryTitle(detail.getCategoryField()));
		quest.setStatements(detail.getStatements());
		quest.setFeedback(detail.getFeedback());
		service.addQuestion(quest);
		
		Stage stage = (Stage)detail.getScene().getWindow();
		stage.close();

	}

}
