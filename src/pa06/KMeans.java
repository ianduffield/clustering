/**
 * 
 */
package pa06;
import java.util.*;
import java.util.Scanner;
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
	Cluster[] clusters;
	Cluster originalData;
	
	public KMeans(int k){
		this.clusters = new Cluster[k];
		this.originalData = new Cluster();
		
	}
	
	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		// K is the number of clusters
		System.out.print("K: ");
		int clustersNum = input.nextInt();
		KMeans Km = new KMeans(clustersNum);
		
		// Retrieve file
		System.out.print("Filename: ");
		String fileName = input.next();
		
		
		// Read File
		Km.fileRead(fileName);
		
		Km.Classify (clustersNum);

		Km.Reclassify (clustersNum );
		Km.loop (clustersNum);
		System.out.println();
		System.out.println ("The following are the clusters formed. Cluster centers can be found seperated by a comma at the end of the cluster list.");
		System.out.println();
		for (int j = 0; j< clustersNum ; j++ ) {
		System.out.println ("Cluster " + (j+1));
		System.out.println();
		Km.clusters[j].print();
		System.out.println("_______________");
		}
	}
	public void fileRead(String FileName) throws FileNotFoundException  {
			File file = new File(FileName);
		  
			Scanner scan = new Scanner(file);

			// Part 4
			// Reading the file line by line
			int index = 0;
			while(scan.hasNextLine()){
				String line = scan.nextLine();
			    Scanner coordinates = new Scanner(line).useDelimiter("\\s+");
			    double X = 0;
			    double Y = 0;
				X = Double.parseDouble(coordinates.next());
				Y = Double.parseDouble(coordinates.next());
				Sample point = new Sample(X,Y);
				this.originalData.add(point);
			  }
		}
	//Initializes the clustering process but dividing the originalData into equal parts and choosing random ClusterPoints for each 
		public void Classify(int k){
			for (int j = 0; j< k ; j++ ) {
				this.clusters[j] = new Cluster();
				this.originalData.chooseClusterPoint();
				this.clusters[j].ClusterPoint = this.originalData.ClusterPoint ;
			}
			
			
		}
			

	
		public void Reclassify(int k){
			for(int j = 0; j < k; j++){
				this.clusters[j] = new Cluster(this.clusters[j].ClusterPoint);
			}
			
			Sample Closest = this.clusters[0].ClusterPoint;
			int closestIndex = 0;
			
			for(int i = 0; i < this.originalData.size(); i++){
				for(int z = 0; z < k; z++){		
					
				if(Closest.Distance(this.originalData.get(i)) >= this.clusters[z].ClusterPoint.Distance(this.originalData.get(i))){
					//|| this.clusters[z].ClusterPoint.Distance(this.originalData.get(i))!= 0
					
					Closest = this.clusters[z].ClusterPoint;
					closestIndex = z;
				}
			} this.clusters[closestIndex].add(this.originalData.get(i));
		}
	}
		public void loop (int k) {
			for (int i = 0; i <= 100; i++ ) {
				for (int j = 0; j<k ; j++ ) {
					clusters[j].Average();
					Reclassify(k);
								
				}
				
				
			}
			
		}

		
}

	






// initiating cluster arraylists
//Cluster clusters = new Cluster();


//for (int j = 0; j< clustersNum ; j++ ) {
//Km.clusters[j].print();
//System.out.println("********");
//}


//int size = 0;			
//// If/Else statement used to change size depending on even or odd
//if(this.originalData.size() % 2 == 0) {
//	size = this.originalData.size() / k;
//}
//else {
//	size = (this.originalData.size() / k) + 1;
//}
//
//
//for(int i = 0; i < k; i++){
//	this.clusters[i] = new Cluster();
//} for(int j = 0; j < k; j++){
//	for(int m = (size*j); m < (size*(j+1)); m++){
//		this.clusters[j].add(this.originalData.get(m));
//	}
//} for (int n = 0; n < k; n++){
//	this.clusters[n].chooseClusterPoint();
//}
//}

