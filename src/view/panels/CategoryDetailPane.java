/*@author Adhikari_Asmita-r0612365 
 * https://github.com/AsmitaAdhikari-r0612365/TestEvaluation.git */
package view.panels;

import controller.listener.AddCategoryListener;
import controller.listener.CancelHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.db.TestService;

public class CategoryDetailPane extends DetailPane {
	private Button btnOK, btnCancel;
	private TextField titleField, descriptionField;
	private ComboBox categoryField;
	private CategoryOverviewPane overview;
	private TestService service;
	

	public CategoryDetailPane(CategoryOverviewPane overview, TestService service) {
		this.overview = overview;
		this.service = service;
		this.setPrefHeight(150);
		this.setPrefWidth(300);
		
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setVgap(5);
		this.setHgap(5);

		this.add(new Label("Title:"), 0, 0, 1, 1);
		titleField = new TextField();
		this.add(titleField, 1, 0, 1, 1);

		this.add(new Label("Description:"), 0, 1, 1, 1);
		descriptionField = new TextField();
		this.add(descriptionField, 1, 1, 1, 1);

		this.add(new Label("Main Category:"), 0, 2, 1, 1);
		categoryField = new ComboBox<>();
		this.add(categoryField, 1, 2, 1, 1);
		categoryField.getItems().addAll(service.getCatTitles());
				

		btnCancel = new Button("Cancel");
		setCancelAction();
		this.add(btnCancel, 0, 3, 1, 1);

		btnOK = new Button("Save");
		btnOK.isDefaultButton();
		setSaveAction();
		this.add(btnOK, 1, 3, 1, 1);
	}

	public void setSaveAction() {
		AddCategoryListener saveAction = new AddCategoryListener(this, service);
		btnOK.setOnAction(saveAction);
	}

	public void setCancelAction() {
		CancelHandler cancelAction= new CancelHandler(this);
		btnCancel.setOnAction(cancelAction);
	}
	
	public String getTitle(){
		return titleField.getText().toString();
	}
	
	public String getDescription(){
		return descriptionField.getText().toString();
	}
	
	public String getCategory(){
		return categoryField.getPromptText().toString();
	}

	public void clearFields() {
		titleField.clear();
		descriptionField.clear();		
	}

	

}
