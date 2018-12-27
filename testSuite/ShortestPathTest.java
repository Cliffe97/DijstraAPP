package pa3.testSuite;
/**
 * @author cliffegao
 * cliffe14@brandeis.edu
 */
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import pa3.*;
public class ShortestPathTest {
	@Test
	void runTest() {
		GraphWrapper gw = new GraphWrapper();
		String output = FindMinPath.run(gw, gw.getHome());
		System.out.println("\n"+ output.substring(output.length()-4));
		assertTrue(output.substring(output.length()-4).equals("East"));
	}
	@Test
	void printTest() {
		String output = "West\nEast";
		FindMinPath.writeToFiles(output);
		File file = new File("answers.txt");
		Scanner scanner;
		String line = "";
		try {
			scanner = new Scanner(file);
		    line = scanner.nextLine();
			line += "\n"+scanner.nextLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(output.equals(line));
	}
}
