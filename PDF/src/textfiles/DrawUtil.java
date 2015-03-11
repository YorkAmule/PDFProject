package textfiles;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class DrawUtil {

	public static final float SIZEX = 612;
	public static final float SIZEY = 792;
	private PdfWriter writer;
	private Document document;
	private FileOutputStream output;
	private int pageNum;

	public DrawUtil(String dest) throws FileNotFoundException,
			DocumentException {
		pageNum = 1;
		Rectangle pageSize = new Rectangle(SIZEX, SIZEY);
		document = new Document(pageSize);
		output = new FileOutputStream(dest);
		writer = PdfWriter.getInstance(document, output);
		document.open();
	}
	
	public void closeDocument() {
		document.close();
	}
	
	public void createNewPage() {
		document.newPage();
	}

	// draw text
	public void createTextCenteredAtPosition(String text, float x, float y,
			float size) throws DocumentException, IOException {
		PdfContentByte cb = writer.getDirectContent();
		cb.setFontAndSize(BaseFont.createFont(BaseFont.HELVETICA,
				BaseFont.WINANSI, false), size);
		cb.beginText();
		cb.showTextAligned(Element.ALIGN_CENTER, text, x, SIZEY - y, 0);
		cb.endText();
		cb.stroke();
	}

	// draw horizontal line
	public void createHLineAtPosition(float x, float y, float length) {
		PdfContentByte cb = writer.getDirectContent();
		cb.setLineWidth(0.5f);
		cb.moveTo(x, SIZEY - y);
		cb.lineTo(x + length, SIZEY - y);
		cb.stroke();
	}

	// draw vertical
	public void createVLineAtPosition(float x, float y, float length) {
		PdfContentByte cb = writer.getDirectContent();
		cb.setLineWidth(0.5f);
		cb.moveTo(x, SIZEY - y);
		cb.lineTo(x, SIZEY - (y + length));
		cb.stroke();
	}

	// draw circle for repeat bar
	public void createCircle(float x, float y, float length) {
		PdfContentByte cb = writer.getDirectContent();
		cb.circle(x + 2f, SIZEY - y, 1);
		cb.stroke();
	}

	public void createRDoubleBar(float x, float y, float length) {
		PdfContentByte cbThin = writer.getDirectContent();
		cbThin.setLineWidth(0.5f);
		cbThin.moveTo(x - 1, SIZEY - y);
		cbThin.lineTo(x - 1, SIZEY - (y + length));
		PdfContentByte cbBold = writer.getDirectContent();
		cbThin.stroke();

		cbBold.setLineWidth(1.2f);
		cbBold.moveTo(x + 1, SIZEY - y);
		cbBold.lineTo(x + 1, SIZEY - (y + length));
		cbBold.stroke();

	}

	public void createLDoubleBar(float x, float y, float length) {
		PdfContentByte cbBold = writer.getDirectContent();
		cbBold.setLineWidth(1.2f);
		cbBold.moveTo(x + 1, SIZEY - y);
		cbBold.lineTo(x + 1, SIZEY - (y + length));
		cbBold.stroke();

		PdfContentByte cbThin = writer.getDirectContent();
		cbThin.setLineWidth(0.5f);
		cbThin.moveTo(x - 1, SIZEY - y);
		cbThin.lineTo(x - 1, SIZEY - (y + length));
		cbThin.stroke();
	}
}
