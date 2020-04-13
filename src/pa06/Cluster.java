package pa06;

import java.util.ArrayList;

import java.util.Random;
/**
 * A cluster is a cluster point (which is itself a sample)
 * and a list of the Sample points
 * @author iandu
 *
 */
public class Cluster{
	Sample clusterPoint;
	ArrayList<Sample> Points;
	
	Random random = new Random();
	
	// Parameters for samples should be able to have as many Samples as requried
	public Cluster(Sample s1, Sample s2) {
		Points = new ArrayList<>();
		
		// Adding s1 & s2 to Points
		Points.add(s1);
		Points.add(s2);
		
		// Random Index for Cluster Point
		int randomIndex = random.nextInt(Points.size());
		
		// Retrieve ClusterPoint
		clusterPoint = Points.get(randomIndex);
	}
	
	// Part 2
	public float ClusterDistance(){
		float distance = 0;
		for(int i = 0; i < Points.size(); i++){
			distance += clusterPoint.Distance(Points.get(i)); 
		}
		return distance;
	}
	
	// Override get()
	public Sample get(int index) {
		return Points.get(index);
	}
}
