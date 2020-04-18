/**
 * 
 */
package pa06;

import java.util.ArrayList;

/**
 * A Sample represents a vector of doubles to be used in a clustering program...
 * you need methods to find the distance between two samples.

 * @author iandu
 *
 */
public class Sample {
	double X;
	double Y; 
	
	public Sample(double X,double Y) {
		this.X = X;
		this.Y = Y;
		
	}
	
	public double getX(){
		return this.X;
	}
	
	public double getY(){
		return this.Y;
	}
	public float Distance(Sample centerPoint){
		float distance = 0;
		distance += Math.pow(Math.abs(centerPoint.getX() - this.getX()), 2);
		distance += Math.pow(Math.abs(centerPoint.getY() - this.getY()), 2);
		return ((float) Math.sqrt(distance));
	}
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	ArrayList<Double> sample;

	public Sample(double[] values){
		this.sample = new ArrayList<Double>();
		for(int i = 0; i<values.length; i++){
			sample.add(values[i]);
		}
	}
	
	public static void main(String[] args) {
		System.out.println("testing for the Sample class.");
		double[] p1 = {1d, 2d, 3.14, 2.71};
		double[] p2 = {0.1, 1.1, 2.1, 3.1};
		Sample s1 = new Sample(p1);
		Sample s2 = new Sample(p2);
		System.out.println("s1=" + s1);
		System.out.println("s2=" + s2);
	}
	
	
	
	// Override to find size
	public int size(){
		return this.sample.size();
	}
	
	// Override to access ArrayList Index
	public double get(int index){
		return this.sample.get(index);
	}
	
		}
	// Override to find size
		public int size(){
			return this.sample.size();
		}
		
		// Override to access ArrayList Index
		public double get(int index){
			return this.sample.get(index);
		}
	// Part 1
	public float Distance(Sample p2){
		float distance = 0;
		for(int i = 0; i < p2.size(); i++){
			distance += Math.pow(Math.abs(p2.get(i) - this.sample.get(i)), 2);
		} return ((float) Math.sqrt(distance));
	}
}
*/

