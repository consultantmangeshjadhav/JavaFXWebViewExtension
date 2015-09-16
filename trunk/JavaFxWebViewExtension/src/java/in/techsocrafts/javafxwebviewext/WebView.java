package in.techsocrafts.javafxwebviewext;

import in.techsocrafts.javafxwebviewext.engine.pdf.PDFEngine;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class WebView {

	private VBox container;
	private javafx.scene.web.WebView webView;
	private ScrollPane imageContainer;
	//private Node currentView;
	private String currentUrl;
	WebView() {
		container = new VBox();
		webView = new javafx.scene.web.WebView();
		imageContainer = new ScrollPane();
		imageContainer.setContent(new VBox());
	}
	
	public Node getNode() {
		return container;
	}
	protected javafx.scene.web.WebView getWebView() {
		return webView;
	}
	protected ScrollPane getImageView() {
		return imageContainer;
	}
	public void load(String url) {
		this.currentUrl = url;
		reload();
	}
	public void reload() {
		if(container.getChildren().size() != 0) {
			container.getChildren().remove(0);
		}
		if(this.currentUrl.endsWith(".pdf")) {
			PDFEngine pdfEngine = new PDFEngine();
			pdfEngine.load(this.currentUrl, (Pane)imageContainer.getContent());
			//currentView = imageContainer;
			container.getChildren().add(imageContainer);
			return;
		}
		//currentView = webView;
		container.getChildren().add(webView);
		if(webView.getEngine().getLocation() != null && webView.getEngine().getLocation().equals(this.currentUrl)) {
			webView.getEngine().reload();
			return;
		}
		webView.getEngine().load(this.currentUrl);
	}
}
