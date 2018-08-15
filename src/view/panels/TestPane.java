package view.panels;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import domain.Question;
import domain.TestService;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class TestPane extends GridPane {
	private Label questionField;
	private Button submitButton;
	private ToggleGroup statementGroup;
	private TestService service;
	private RadioButton radio;
	
	
	public TestPane (TestService service){
		this.service = service;
		
		this.setPrefHeight(300);
		this.setPrefWidth(750);
		
		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);

		questionField = new Label();
		add(questionField, 0, 0, 1, 1);
		Question question = service.haalQuestion();
		questionField.setText(question.getQuestion());
		
		statementGroup = new ToggleGroup();
		Set<String> statements = question.getStatements();
		int i = 1;
		for(String st: statements){
			radio = new RadioButton(st);
			radio.setToggleGroup((ToggleGroup) statementGroup.getUserData());
			radio.setSelected(false);
			add(radio,0, i++);
		}
		
		submitButton = new Button("Submit");
		add(submitButton, 0,i);
		submitButton.setOnAction(new SubmitAnswerHandler());
	}
	
	class SubmitAnswerHandler implements EventHandler<ActionEvent> {
		
		@Override
		public void handle(ActionEvent event) {
		for(Question vraag: service.getQuestionData()){
			if(vraag.getJuistStmt().containsAll(getSelectedStatements())){
				JOptionPane.showMessageDialog(null, "Proficiat! Alles juist!");
	
			}
			
			
		}

		}

	}
	public List<String> getSelectedStatements() {
		List<String> selected = new ArrayList<String>();
		if(statementGroup.getSelectedToggle()!=null){
			selected.add(statementGroup.getSelectedToggle().getUserData().toString());
		}
		return selected;
	}
}
