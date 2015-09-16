package in.techsocrafts.javafxwebviewext.test;

import in.techsocrafts.javafxwebviewext.WebView;
import in.techsocrafts.javafxwebviewext.WebViewFactory;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TestWebViewApplication extends Application {

	public static final String APPLICATION_NAME = "Test WebView";
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(APPLICATION_NAME);
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		primaryStage.setX(primaryScreenBounds.getMinX());
		primaryStage.setY(primaryScreenBounds.getMinY());
		primaryStage.setWidth(primaryScreenBounds.getWidth());
		primaryStage.setHeight(primaryScreenBounds.getHeight());
		VBox vBox = new VBox();
		WebView webView = WebViewFactory.getWebView();
		//webView.load("http://www.google.co.in");
		webView.load("file:///Users/mangeshjadhav/clients/intolutions/products/ebook/poc/testpdfs/NEFTMandateForm.pdf");
		vBox.getChildren().add(webView.getNode());
		primaryStage.setScene(new Scene(vBox));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
