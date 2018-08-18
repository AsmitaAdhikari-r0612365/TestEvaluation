package controller.listener;

import java.io.Closeable;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import model.db.TestService;
import view.panels.TestPane;

public class SubmitHandler implements EventHandler<ActionEvent> {
	private TestPane pane;
	private TestService service;
	private int counter;
	
	public SubmitHandler(TestPane pane,TestService service) {
		this.pane = pane;
		this.service = service;
		counter = 0;
	}

	@Override
	public void handle(ActionEvent event) {
		String answer = pane.getSelectedStatements().toString();
		System.out.println(answer);
		if(service.isCorrectAnswer(answer)){
			System.out.println("Correct");
			service.saveAnswers(service.haalQuestion(), true);
			if(counter +1 == service.getQuestionData().size())
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
		//service.showResult();
		
	}
	
	private void getNextQuestion() {
		counter++;
		pane.newQuestion();
		
	}

	public void closeScene(){
		Stage stage = (Stage)pane.getScene().getWindow();
		stage.close();
	}
	
	

}
