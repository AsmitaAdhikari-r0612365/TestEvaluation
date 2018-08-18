/*@author Adhikari_Asmita-r0612365 
 * https://github.com/AsmitaAdhikari-r0612365/TestEvaluation.git */
package application;

import controller.controller.Controller;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.db.TestService;
import view.panels.AssesMainPane;
import view.panels.CategoryOverviewPane;
import view.panels.MessagePane;
import view.panels.QuestionOverviewPane;

public class Main extends Application {
	private TestService service = new TestService();
	private Controller controller = new Controller();

	@Override
	public void start(Stage primaryStage) {
		try {
			QuestionOverviewPane questionOverviewPane = new QuestionOverviewPane(service);

			CategoryOverviewPane categoryOverviewPanel = new CategoryOverviewPane(service);

			MessagePane messagePane = new MessagePane(service, controller);

			Group root = new Group();
			Scene scene = new Scene(root, 750, 400);

			BorderPane borderPane = new AssesMainPane(messagePane, categoryOverviewPanel, questionOverviewPane);
			borderPane.prefHeightProperty().bind(scene.heightProperty());
			borderPane.prefWidthProperty().bind(scene.widthProperty());

			root.getChildren().add(borderPane);
			primaryStage.setScene(scene);
			primaryStage.sizeToScene();

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
