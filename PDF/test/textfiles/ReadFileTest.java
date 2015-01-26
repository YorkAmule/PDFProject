package textfiles;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReadFileTest {

	private ReadFile file, wrongfile;
	private String filename = "results/Input.txt";
	private String wrongfilename = "results/Notinput.txt";
	private int numberOfLines;
	
	@Before
    public void setup() throws Exception
    {
		file = new ReadFile(filename);
		wrongfile = new ReadFile(wrongfilename);
    }
	
	@Test
	public void testReadFile() {
		
		assertSame("results/Input.txt", file.path);
	}

	@Test
	public void testReadLines() throws IOException {
		
		assertSame(file.readLines(), file.numberOfLines);
		
	}

	@Test
	public void testOpenFile() throws IOException {
		
		for(int i = 0; i < file.numberOfLines; i++)
		{
   		assertSame(file.textData[i], file.OpenFile());
		}
		
		
	}
	
	@Test(expected = Exception.class)
	public void testReadFileException() throws IOException
	{
		wrongfile.readLines();
	}
	
	public void testgetText()
	{
		assertSame(2, file.getLines());
	}

}
