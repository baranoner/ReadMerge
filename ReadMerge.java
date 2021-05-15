import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadMerge {

	public static void main(String[] args) {
		File file = new File("data1.txt");
		File file2= new File("data2.txt");
		File newfile= new File("newfile.txt");
		
		try {
			FileInputStream input1 = new FileInputStream(file);
			Scanner scan1 = new Scanner(input1);
			FileInputStream input2 = new FileInputStream(file2);
			Scanner scan2 = new Scanner(input2);
			FileOutputStream output= new FileOutputStream(newfile);
			
			scan1.nextLine();
			scan2.nextLine();
			// these nextlines means that we skip the headers in the reading part.
			PrintWriter writedata = new PrintWriter(newfile);
			writedata.println("ID, Name, LastName, Department, Q, Midterm, Final");
			while(scan1.hasNext() && scan2.hasNext()) {
				String mydata1 = scan1.nextLine();
				String Line1[] = mydata1.split(",");
				int id = Integer.parseInt(Line1[0]);
				String name = Line1[1];
				String lastname = Line1[2];
				String department = Line1[3];
				
				// first we read the data1's values
					String mydata2 = scan2.nextLine();
					String Line2[] = mydata2.split(",");
				     int q1 = Integer.parseInt(Line2[1]);
				     int q2 = Integer.parseInt(Line2[2]);
				     int q3 = Integer.parseInt(Line2[3]);
				    int q = (q1 + q2 + q3)/3;
				    int m= Integer.parseInt(Line2[4]);
				    int f = Integer.parseInt(Line2[5]);
				    // then we read the data2's values
				    
			writedata.println(	id + "," +name + "," + lastname + ","+ department +","+  q + "," + m + "," + f) ;
				writedata.flush();
			//  we merge them together and print them in a new file
			
			}
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			
		}

	}

}
