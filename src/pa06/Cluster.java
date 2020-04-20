package pa06;

import java.util.ArrayList;

import java.util.Random;
/**
 * A cluster is a cluster point (which is itself a sample)
 * and a list of the Sample points
 * 
 * Implement and test the Cluster class (which is an ArrayList (rows) of  Samples together with a single Sample (the cluster point)
   You need a method to pick a random element of a cluster (for initializing k-means you pick k random elements to start the process.
 * @author iandu
 *
 */
public class Cluster{
	ArrayList<Sample> SamplePoints;
	Sample ClusterPoint;

	Random random = new Random();
	
	public Cluster(Sample ClusterPoint){
		this.ClusterPoint = ClusterPoint;
		this.SamplePoints = new ArrayList<Sample>();
	}
	
	public Cluster(){
		this.SamplePoints = new ArrayList<Sample>();
	}
	
	
//	public void addOriginal(Sample point) {
//		this.SamplePoints.add(point);
//		
//	}
	public void chooseClusterPoint(){
		// Random Index for Cluster Point
		this.ClusterPoint = this.SamplePoints.get(random.nextInt(this.SamplePoints.size()));
	
		}
	
	public void add(Sample sample){
		this.SamplePoints.add(sample);
	}
	
	public int size(){
		return this.SamplePoints.size();
	}
	
	public Sample get(int index){
		return this.SamplePoints.get(index);
	}
	
	public void print () {
		System.out.print ("[");
		for (int i=0; i< this.SamplePoints.size();i++) {
			System.out.print("{"+SamplePoints.get(i).getX() +" " + SamplePoints.get(i).getY()+"} ");
			//System.out.println("{"+SamplePoints.get(i).getX() +" " + SamplePoints.get(i).getY()+"} ");

		}
		System.out.print (", { "+this.ClusterPoint.getX()+ " "+ this.ClusterPoint.getY()+"} ");
		System.out.print("]");
		System.out.println();
		
	}
	
//	public float ClusterPointDistance(){
//		float distance = 0;
//		for(int i = 0; i < SamplePoints.size(); i++){
//			distance += ClusterPoint.Distance(SamplePoints.get(i)); 
//		}
//		return distance;
//	}
	
	public Sample ClosestClusterPoint() {

		Sample Closest = this.SamplePoints.get(0);
		for(int i =0; i < this.SamplePoints.size(); i++){
			if(Closest.Distance(this.ClusterPoint) > this.SamplePoints.get(i).Distance(this.ClusterPoint)){
				Closest = this.SamplePoints.get(i);
			}
		}
		return Closest;
	}
	public void Average() {
		double newX = 0;
		double newY = 0;
		for (Sample S: SamplePoints) {
			newX += S.getX();
			
		}
		for (Sample S: SamplePoints) {
			newY += S.getY();
			
		}
		
		double AvgX = newX/SamplePoints.size();
		double AvgY = newY/SamplePoints.size();
		this.ClusterPoint = new Sample (AvgX, AvgY);
		
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	
	
	
	// Parameters for samples should be able to have as many Samples as requried
	// Constructor is used after each individual cluster has been made
	public Cluster() {
		Points = new ArrayList<>();
		
		// Adding s1 & s2 to Points
		// Points.add(s1);
		// Points.add(s2);
		

		// Retrieve ClusterPoint
		clusterPoint = Points.get(randomIndex);
	}
	
	// Constructor only used for original data
	public Cluster() { // Pass in original data
		
	}
	
	// Part 2
	public float ClusterPointDistance(){
		float distance = 0;
		for(int i = 0; i < Points.size(); i++){
			distance += clusterPoint.PointDistance(Points.get(i)); 
		}
		return distance;
	}
	
	// Override get()
	public Sample get(int index) {
		return Points.get(index);
	}
}

	
	*/
