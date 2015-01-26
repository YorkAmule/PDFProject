package textfiles;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;


public class ReadFile {

	public String path;
	public int numberOfLines;
	String[] textData;

	
	public ReadFile(String file_path) {
		path = file_path;
		numberOfLines = 0;
	}
	
	public int readLines() throws IOException {
		
		FileReader file_to_read = new FileReader(path); //Reads the name of the file.
		BufferedReader bf = new BufferedReader(file_to_read); //Reads the actual file itself.
	     
		String aLine;

		
		while ((aLine = bf.readLine()) != null) {
			this.numberOfLines++;
		}
		bf.close();
		return this.numberOfLines;
		
	}
	
	public String[] OpenFile() throws IOException {
		
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);
		
		int numberOfLines = readLines();
		this.textData = new String[numberOfLines];
		
		for(int i = 0; i < numberOfLines; i++) {
			textData[i] = textReader.readLine();
		}
		textReader.close();
		
		return textData;
		
	}
	
	public int getLines()
	{	
		return this.numberOfLines;
	}
	
}
