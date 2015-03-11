/*
 * this project can't distinguish simple bar and repeat bar
 * 
 */
package textfiles;

import java.io.IOException;

import com.itextpdf.text.DocumentException;

public class App {
	
	public static final String SRC = "sample1.txt";
	public static final String DEST = "P1.pdf";
	
	
	public static void main(String[] args) throws IOException, DocumentException {
        Composer.compose(SRC, DEST);
    }
	
	
}
