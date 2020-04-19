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
	Cluster[] clusters;
	Cluster originalData;
	
	public KMeans(int k){
		this.clusters = new Cluster[k];
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		// K is the number of clusters
		System.out.print("K: ");
		int clustersNum = input.nextInt();
		
		KMeans Km = new KMeans(clustersNum);

		// initiating cluster arraylists
		Cluster clusters = new Cluster();
		
				
		
		// Retrieve file
		System.out.print("Filename: ");
		String FileName0 = input.nextLine();
		Km.fileRead(FileName0);
		Km.Classify (clustersNum);
		Km.Reclassify (clustersNum );
	}
	public void fileRead(String FileName) {
		
			File file = new File(FileName);
		  
		    Scanner scan = new Scanner(FileName);
			

			// Part 4
			// Reading the file line by line
			while(scan.hasNextLine()){
				String line = scan.nextLine();
			    Scanner coordinates = new Scanner(line);
				double	X = coordinates.nextDouble();
				double	Y = coordinates.nextDouble();
				Sample point = new Sample(X,Y);
				this.originalData.add(point);
				
			  }
		}
	//Initializes the clustering process but dividing the originalData into equal parts and choosing random ClusterPoints for each 
		public void Classify(int k){
			int size = this.originalData.size()/k;
			for(int i = 0; i < k; i++){
				this.clusters[i] = new Cluster();
			} for(int j = 0; j < k; j++){
				for(int m = (size*j); m < (size*j+1); m++){
					this.clusters[j].add(this.originalData.get(m));
				}
			} for (int n = 0; n < k; n++){
				this.clusters[n].chooseClusterPoint();
			}
		}
	
		public void Reclassify(int k){
			for(int j = 0; j < k; j++){
				this.clusters[j] = new Cluster(this.clusters[j].ClusterPoint);
			}
			Sample Closest = this.clusters[0].ClusterPoint;
			int closestIndex = 0;
			for(int i =0; i < this.originalData.size(); i++){
				for(int z = 0; z < k; z++){				
				if(Closest.Distance(this.originalData.get(i)) > this.clusters[z].ClusterPoint.Distance(this.originalData.get(i)) || this.clusters[z].ClusterPoint.Distance(this.originalData.get(i))!= 0){
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

	











