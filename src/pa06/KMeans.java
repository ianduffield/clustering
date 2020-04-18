/**
 * 
 */
package pa06;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * @author Ghazal
 *Create the KMeans class with a main method that asks for the file name and the number of clusters (but doesn't do anything else)
     The instance variables should be clusters an array of size k of Clusters with randomly generated cluster points
     and also an element originalData which is a cluster of all original data with the single sample point (0,0,....)
 */

// Part 3
public class KMeans {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		// K is the number of clusters
		System.out.print("K: ");
		int clustersNum = input.nextInt();
		
		// initiating cluster arraylists
		Cluster clusters = new Cluster();
		
				
		
		// Retrieve file
		System.out.print("Filename: ");
		String FileName0 = input.nextLine();
		fileRead(FileName0,clustersNum);
		
	}
	public static void fileRead(String FileName, int k) {
		
			File file = new File(FileName);
		  
		    Scanner scan = new Scanner(FileName);
			
			// Send all information (Original Data) to make clusters
			Cluster originalData = new Cluster();
			
			/*
			
			
			// Initializing each cluster in Clusters
			for(int i = 0; i < K; i++) {
				// Constructor of Cluster creates a clusterPoint
				clusters[i] = new Cluster(); // Still need to pass in information to cluster
			}
				*/
			// Part 4
			// Reading the file line by line
			while(scan.hasNextLine()){
				String line = scan.nextLine();
			    Scanner coordinates = new Scanner(line);
				double	X = coordinates.nextDouble();
				double	Y = coordinates.nextDouble();
				Sample point = new Sample(X,Y);
				originalData.add(point);
				
			  }
		}
		
		
		
		
		
	}

	











