package view.panels;

import controller.listener.EvaluationListener;
import domain.TestService;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class MessagePane extends GridPane {
	private Button testButton;
	private TestService service;
	
	public MessagePane (TestService service){
		this.service = service;
	    setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

		this.setPadding(new Insets(5, 5, 5, 5));
        this.setVgap(5);
        this.setHgap(5);
        
		testButton = new Button("Evaluate");
		testButton.setOnAction(new EvaluationListener(service));
		//System.out.println(service.getStatements());
		
		add(testButton, 0,1,1,1);
		setHalignment(testButton, HPos.CENTER);
	}

}