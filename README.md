# JavaFXWebViewExtension
Extension for JavaFX Webview, handles view for both html files and pdf
JavaFX WebView is not able to handle PDF files. This component creates a wrapper to the webview and a pdf viewer.
Using this component, one can seamlessly view web and pdf files.

How to Use


		WebView webView = WebViewFactory.getWebView();
		//webView.load("http://www.google.co.in");
		webView.load("file:///path/to/pdf/file/pdffile.pdf");
		container.getChildren().add(webView.getNode());
