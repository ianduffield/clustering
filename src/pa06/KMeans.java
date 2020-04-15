/**
 * 
 */
package pa06;
import java.util.*;
/**
 * @author Ghazal
 *Create the KMeans class with a main method that asks for the file name and the number of clusters (but doesn't do anything else)
     The instance variables should be clusters an array of size k of Clusters with randomly generated cluster points
     and also an element originalData which is a cluster of all original data with the single sample point (0,0,....)
 */
public class KMeans {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner data = new Scanner(System.in);
		  System.out.print("K: ");
		  int clustersNum = data.nextInt();
		  System.out.print("Filename: ");
		  String FileName = data.nextLine();
		  Scanner file = new Scanner(FileName);
		  Cluster clusters = new Cluster(clustersNum);
		  while(file.hasNextInt()){
			  double[] point
			  Sample point = new Sample(file.nextDouble());
		  }
	}

}
