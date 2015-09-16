package in.techsocrafts.javafxwebviewext.engine.pdf;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFImageWriter;

public class PDFEngine {

	private static final String FILE_PROTOCOL_PREFIX = "file://";
	private String url;
	private boolean displayByPage;
	
	public PDFEngine() {
	}
	
	public void setDisplayByPage(boolean displayByPage) {
		this.displayByPage = displayByPage;
	}

	public void load(String url, Pane container) {
		this.url = url;
		PDFImageWriter imageWriter = new PDFImageWriter();
		PDDocument pdDocument = null;
		File outputFolder = null;
		try {
			String outputPrefix = "/temp";
			if(url.startsWith(FILE_PROTOCOL_PREFIX)) {
				outputPrefix = url.substring(FILE_PROTOCOL_PREFIX.length(),this.url.lastIndexOf("."));
				outputFolder = new File(outputPrefix);
				if(!outputFolder.exists()) {
					outputFolder.mkdirs();
				}
			}
			if(url.startsWith(FILE_PROTOCOL_PREFIX)) {
				pdDocument = PDDocument.load(this.url.substring(FILE_PROTOCOL_PREFIX.length()));
			} else {
				pdDocument = PDDocument.load(this.url);
			}
			
			int resolution = Toolkit.getDefaultToolkit().getScreenResolution();
			
			if(outputFolder.list().length < pdDocument.getNumberOfPages()) {
				imageWriter.writeImage(pdDocument, "png",null,1,pdDocument.getNumberOfPages(),outputPrefix+File.separator+"page",BufferedImage.TYPE_INT_RGB, resolution);
			}
			if(outputFolder != null) {
				for(File pageImage : outputFolder.listFiles()) {
					container.getChildren().add(new ImageView(FILE_PROTOCOL_PREFIX + pageImage.getAbsolutePath()));
					if(displayByPage) {
						break;
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pdDocument.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
