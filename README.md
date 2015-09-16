# JavaFXWebViewExtension
Extension for JavaFX Webview, handles view for both html files and pdf
JavaFX WebView is not able to handle PDF files. This component creates a wrapper to the webview and a pdf viewer.
Using this component, one can seamlessly view web and pdf files.

How to Use


		WebView webView = WebViewFactory.getWebView();
		//webView.load("http://www.google.co.in");
		webView.load("file:///path/to/pdf/file/pdffile.pdf");
		container.getChildren().add(webView.getNode());

This component uses <a href="https://pdfbox.apache.org/">apache pdfbox</a> for pdf rendering. 

You can set dependency to apache pdfbox from maven using the link <a href="http://search.maven.org/#artifactdetails%7Corg.apache.pdfbox%7Cpdfbox%7C1.8.10%7Cbundle">http://search.maven.org/#artifactdetails%7Corg.apache.pdfbox%7Cpdfbox%7C1.8.10%7Cbundle</a>
