/*@author Adhikari_Asmita-r0612365 
 * https://github.com/AsmitaAdhikari-r0612365/TestEvaluation.git */
package view.panels;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import controller.controller.Controller;
import controller.listener.SubmitHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import model.Question;
import model.db.TestService;

public class TestPane extends GridPane {
	private TestService service;
	private Controller controller;
	private Label questionField;
	private Button submitButton;
	private ToggleGroup statementGroup;
	private RadioButton radio;
	private Set<Question> vragen;

	public TestPane(TestService service, Controller controller) {
		this.service = service;
		this.controller = controller;

		this.setPrefHeight(300);
		this.setPrefWidth(750);

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		questionField = new Label();
		vragen = service.getAllQuestions();
		Question question = vragen.iterator().next();
		questionField.setText(question.getQuestion());
		vragen.remove(question);

		add(questionField, 0, 0, 1, 1);

		statementGroup = new ToggleGroup();
		Set<String> statements = question.getStatements();
		System.out.println(statements);
		int i = 1;
		for (String st : statements) {
			radio = new RadioButton(st);
			radio.setText(st);
			radio.setUserData(st);
			radio.setToggleGroup(statementGroup);
			add(radio, 0, i++);
		}

		submitButton = new Button("Submit");
		add(submitButton, 0, i);
		submitButton.setOnAction(new SubmitHandler(this,service,controller));
	}

	public void newQuestion() {
		this.getChildren().clear();
		while(vragen.iterator().hasNext()){
		Question vraag = vragen.iterator().next();
		
		this.setPrefHeight(300);
		this.setPrefWidth(750);

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);
		
		questionField = new Label();
		questionField.setText(vraag.getQuestion());
		vragen.remove(vraag);
		add(questionField, 0, 0, 1, 1);
		
		statementGroup = new ToggleGroup();
		Set<String> statements = vraag.getStatements();
		int j = 1;
		for (String st : statements) {
			radio = new RadioButton(st);
			radio.setUserData(st);
			radio.setToggleGroup(statementGroup);
			add(radio, 0, j++);
		}
		submitButton = new Button("Submit");
		add(submitButton, 0, j);
		submitButton.setOnAction(new SubmitHandler(this,service, controller));
		}

	}

	public List<String> getSelectedStatements() {
		List<String> selected = new ArrayList<String>();
		if (statementGroup.getSelectedToggle() != null) {
			selected.add(statementGroup.getSelectedToggle().getUserData().toString());
		}
		return selected;
	}

}
