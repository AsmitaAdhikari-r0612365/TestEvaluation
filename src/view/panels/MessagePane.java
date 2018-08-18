/*@author Adhikari_Asmita-r0612365 
 * https://github.com/AsmitaAdhikari-r0612365/TestEvaluation.git */
package view.panels;

import controller.controller.Controller;
import controller.listener.EvaluationListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import model.db.TestService;

public class MessagePane extends GridPane {
	private Button testButton;
	private TestService service;
	private Controller controller;
	
	public MessagePane (TestService service, Controller controller){
		this.service = service;
		this.controller = controller;
	    setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		testButton = new Button("Evaluate");
		testButton.setOnAction(new EvaluationListener(service, controller));
		
		add(testButton, 0,1,1,1);
		setHalignment(testButton, HPos.CENTER);
	}
	
	public void showScores(){
		this.getChildren().clear();
	    setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
        Label label = new Label();
        if(service.getWrongAnswers().size()==0)
        	label.setText("Perfect Score!");
        else
        	label.setText(service.showResult());
        
        add(label, 0, 0, 1, 1);
		setHalignment(label, HPos.CENTER);	
		
		testButton = new Button("Evaluate");
		testButton.setOnAction(new EvaluationListener(service, controller));
		
		add(testButton, 0,1,1,1);
		setHalignment(testButton, HPos.CENTER);
        
	}

}
