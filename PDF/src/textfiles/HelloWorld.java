package textfiles;
 
import java.io.FileOutputStream;
import java.io.IOException;
 





import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.BaseColor;
 
/**
 * First iText example: Hello World.
 */
public class HelloWorld {
    
    
 
    /** Path to the resulting PDF file. */
    public static final String RESULT
        = "results/part1/chapter01/hello.pdf";
 
    public static float SPACING;
    /**
     * Creates a PDF file: hello.pdf
     * @param    args    no arguments needed
     */
    public static void main(String[] args)
        throws DocumentException, IOException {
        new HelloWorld().createPdf("results/hello.pdf");
        
        
    }
    
    
    public static void createDiamond(PdfContentByte canvas, float x, float y)
    {
        canvas.moveTo(x, y); 
        canvas.lineTo(x - SPACING, y - SPACING);
        canvas.lineTo(x, y - (SPACING * 2));
        canvas.lineTo(x + SPACING, y - SPACING);
        canvas.lineTo(x - 0.35f, y + 0.35f);
        canvas.setColorFill(new BaseColor(255, 255, 255));
        canvas.fillStroke();
        //canvas.stroke();       
    }
    
    
    public static void createArc(PdfContentByte canvas, float bottom, float top, float leftend, float rightend)
    {
    	canvas.arc(leftend - SPACING, bottom, leftend + SPACING, top, 0, 180);
    }
 
    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException 
     */
    public void createPdf(String filename)
    throws DocumentException, IOException {
        
        
        
        String file_name = "results/Input.txt";
            ReadFile file = new ReadFile(file_name);
            String[] textfile = file.OpenFile();
            StringBuffer taketitle = new StringBuffer(textfile[0]);
            StringBuffer  takesubtitle = new StringBuffer(textfile[1]);
            
            String title = taketitle.substring(6, taketitle.length());
            String subtitle = takesubtitle.substring(9, takesubtitle.length());
            StringBuffer takespacing = new StringBuffer(textfile[2]);
            SPACING = Float.parseFloat(takespacing.substring(8, takespacing.length()));
           
        
        Document document = new Document();
         
         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("results/hello.pdf"));
         document.open();
         PdfContentByte canvas = writer.getDirectContent();
         canvas.beginText();
         canvas.moveText(210, 788);
         canvas.setFontAndSize(BaseFont.createFont(), 24);
         canvas.showText(title);
         canvas.endText();
         canvas.beginText();
         canvas.moveText(240, 762);
         canvas.setFontAndSize(BaseFont.createFont(), 14);
         canvas.showText(subtitle);
         canvas.endText();
         canvas.saveState();
         createArc(canvas, 390, 400, 450, 500);
         canvas.stroke();
         createDiamond(canvas, 250, 700);
         //canvas.moveTo(100, 200);
         //canvas.rectangle(100, 200, 10, 10);
         //canvas.stroke();
         /*canvas.moveTo(350, 400); //x=350, y=400, z=300
         canvas.lineTo(350, 400);
         canvas.lineTo(300, 350);
         canvas.lineTo(350, 300);
         canvas.lineTo(300, 350);
         canvas.lineTo(350, 300);
         canvas.lineTo(400, 350);
         canvas.lineTo(350, 400); 
         canvas.stroke();  */
         canvas.restoreState();
         document.close();
         
         /*public void drawDiamond(Graphics g, int x1, int y1, int x2, int y2)
         {
             x = (x1+x2)/2;
             y = (y1+y2)/2;
             g.drawLine(x1, y , x , y1);
             g.drawLine(x , y1, x2, y );
             g.drawLine(x2, y , x , y2);
             g.drawLine(x , y2, x1, y );
         } */
         
         
         
    }
}