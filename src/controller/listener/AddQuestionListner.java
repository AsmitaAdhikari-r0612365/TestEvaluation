package controller.listener;

import domain.Question;
import domain.TestService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
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
