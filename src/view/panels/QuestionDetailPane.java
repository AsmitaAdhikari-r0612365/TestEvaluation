package view.panels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import controller.listener.AddQuestionListner;
import controller.listener.CancelHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import model.Question;
import model.db.TestService;

public class QuestionDetailPane extends DetailPane {
	private Button btnOK, btnCancel;
	private TextField questionField, statementField, feedbackField;
	private Button btnAdd, btnRemove;
	private ComboBox categoryField;
	private TestService service;
	private TableView<String> statementsArea;

	public QuestionDetailPane(TestService service) {
		this.service = service;
		this.setPrefHeight(300);
		this.setPrefWidth(320);

		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		add(new Label("Question: "), 0, 0, 1, 1);
		questionField = new TextField();
		add(questionField, 1, 0, 2, 1);

		add(new Label("Statement: "), 0, 1, 1, 1);
		statementField = new TextField();
		add(statementField, 1, 1, 2, 1);

		add(new Label("Statements: "), 0, 2, 1, 1);
		statementsArea = new TableView<>();
		statementsArea.setPrefWidth(5);
		statementsArea.setEditable(false);
		TableColumn nameCol = new TableColumn<>("Statements");
		nameCol.setCellValueFactory(new PropertyValueFactory<Question, String>("statements"));
		statementsArea.getColumns().add(nameCol);

		add(statementsArea, 1, 2, 2, 5);

		Pane addRemove = new HBox();
		btnAdd = new Button("add");
		btnAdd.setOnAction(new AddStatementListener());
		addRemove.getChildren().add(btnAdd);

		btnRemove = new Button("remove");
		btnRemove.setOnAction(new RemoveStatementListener());
		addRemove.getChildren().add(btnRemove);
		add(addRemove, 1, 8, 2, 1);

		add(new Label("Category: "), 0, 9, 1, 1);
		categoryField = new ComboBox();
		categoryField.getItems().addAll(service.getCatTitles());
		add(categoryField, 1, 9, 2, 1);

		add(new Label("Feedback: "), 0, 10, 1, 1);
		feedbackField = new TextField();
		add(feedbackField, 1, 10, 2, 1);

		btnCancel = new Button("Cancel");
		btnCancel.setText("Cancel");
		setCancelAction();
		add(btnCancel, 0, 11, 1, 1);

		btnOK = new Button("Save");
		btnOK.isDefaultButton();
		btnOK.setText("Save");
		setSaveAction();
		add(btnOK, 1, 11, 2, 1);

	}

	public void setSaveAction() {
		AddQuestionListner saveAction = new AddQuestionListner(this, service);
		btnOK.setOnAction(saveAction);
	}

	public void setCancelAction() {
		CancelHandler cancelAction = new CancelHandler(this);
		btnCancel.setOnAction(cancelAction);
	}

	class AddStatementListener implements EventHandler<ActionEvent> {
		private ObservableList<String> addedStatements = FXCollections.observableArrayList();

		@Override
		public void handle(ActionEvent e) {
			addedStatements.add(statementField.getText());
			statementsArea.setItems(addedStatements);

			System.out.println(addedStatements);
			statementField.clear();
		}

	}

	class RemoveStatementListener implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			ObservableList<String> statementSelected, allStatements;
			allStatements = statementsArea.getItems();
			statementSelected = statementsArea.getSelectionModel().getSelectedItems();

			statementSelected.forEach(allStatements::remove);
		}
	}

	public String getQuestion() {
		return questionField.getText().toString();
	}

	public String getStatement() {
		return statementField.getText();
	}

	public String getFeedback() {
		return feedbackField.getText();
	}

	public String getCategoryField() {
		return (String) categoryField.getValue();
	}

	public Set<String> getStatements() {
		Set<String> statements = new HashSet();
		statements.addAll(statementsArea.getItems());
		return statements;
	}
}
