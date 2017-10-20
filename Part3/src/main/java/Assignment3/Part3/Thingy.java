package Assignment3.Part3;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Thingy {
	String file1;
	String file2;
	int counter = 1;
	
	public String product() throws IOException {
        createFile("Atlas");
		String idk = readFile(file1);
        createFile("Philips");
		String idk2 = readFile(file2);
		return idk + " by " + idk2;
	}
	
	public void createFile(String g) throws IOException {
		Random rn = new Random();
		int n = 1000;
		int i = rn.nextInt() % n + 1;
        FileWriter writer = new FileWriter("C:/Users/Ciaran/workspace/file" + i + ".txt", false);
        
        if (counter == 1) {
        	file1 = ("file" + i);
        } else if (counter == 2) {
        	file2 = ("file" + i);
        } else {
        	System.out.println("Something went wrong");
        }
        
        counter += 1;
        
        writer.write(g);
        writer.close();
	}
	
	public String readFile(String fileUsed) {
		String test = null;
		try {
			File file = new File("C:/Users/Ciaran/workspace/" + fileUsed + ".txt");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				test = line;
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return test;
	}
	
	@org.junit.Test
	public void testProduct() throws IOException {
		String ans = "Atlas by Philips";
		assertEquals(ans, product());
	}
}