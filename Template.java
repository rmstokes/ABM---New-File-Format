import java.util.ArrayList;
import java.util.HashMap;

/*
 * 
 * 
 * Template objects can be compared with one another to calculate the distance 
 * between their features. The features for a Template represent the cdf data for a given
 * subject and a given instance of mouse movement.
 * 
 * 
 * 
 */

public class Template {

	private double[][] featureSet;
	private HashMap<Integer, ArrayList<Double>> featureSetImproved; //dynamically sized feature set
	private int subjectNumber;
	private int instanceNumber;
	private int cmc_rank;
	double max_x; // maximum for direction angle
	double max_y; // maximum for curvature angle
	double max_r; // maximum for curvature distance
	private int numMetrics;

	public Template(HashMap<Integer, ArrayList<Double>> featureSetImproved, int subjectNumber,
			int instanceNumber, double max_x, double max_y, double max_r) {
		//this.featureSet = featureSet;
		this.featureSetImproved = featureSetImproved;
		this.subjectNumber = subjectNumber;
		this.instanceNumber = instanceNumber;
		this.max_x = max_x;
		this.max_y = max_y;
		this.max_r = max_r;
		numMetrics = 3;
		// featureSetPrime = new HashMap<Integer, Double>();

	}

	public double computeManhattanDistance(Template t) {
		//returns sum of differences between templates divided by the total number of features.
		
		
		
		//System.out.println("inside computeManhattanDistance()");
		//System.out.println("inside computeManhattanDistance()...");
		
		double sumOfDifferences = 0.0;
		double sumOfMaxes = featureSetImproved.get(0).size()+featureSetImproved.get(1).size()+featureSetImproved.get(2).size();
		
		/*
		System.out.println("featureSetImproved first dimension: "+featureSetImproved.size());
		System.out.println("featureSetImproved xlength: "+featureSetImproved.get(0).size());
		System.out.println("featureSetImproved ylength: "+featureSetImproved.get(1).size());
		System.out.println("featureSetImproved rlength: "+featureSetImproved.get(2).size());
		*/
		
		//System.exit(0);
		//double sumOfMaxes = featureSet[0].length+featureSet[1].length+featureSet[2].length;
		
		//System.out.println("featureSet.length: "+featureSet.length);
		//System.out.println("featureSet[0].length: "+featureSet[0].length);
		//System.out.println("featureSet[1].length: "+featureSet[1].length);
		//System.out.println("featureSet[2].length: "+featureSet[2].length);
		//System.exit(0);
		
		for (int i = 0; i < numMetrics; i++){
			for (int j = 0; j < featureSetImproved.get(i).size(); j++){
				/*System.out.println("i: "+i+" j: "+j);
				System.out.println("featureSetImproved.get(i).size(): "+featureSetImproved.get(i).size());
				System.out.println("featureSetImproved.get(0).size(): "+featureSetImproved.get(0).size());
				System.out.println("featureSetImproved.get(i).get(j): "+featureSetImproved.get(i).get(j));
				*/
				sumOfDifferences += Math.abs(featureSetImproved.get(i).get(j)-t.getFeatureSet(i, j));
				//System.out.println("sumOfDifferences: "+sumOfDifferences);
				
			}
		}
		//System.out.println("computed manhattan distance...");
		//System.exit(0);
		
		return sumOfDifferences/sumOfMaxes;
		
	}

	/*
	 * public double[] computeManhattanDistance(Template t) { // this is the
	 * function that will compare this template with another // template that is
	 * passed as parameter // use the double values that are inside the
	 * featureSet of each // template. // the maximum values for each feature
	 * are inside the instance variables // max_x, max_y, and max_r.
	 * 
	 * double MD = 0.0; double[] NMDs = new double[3]; // x,y,r
	 * 
	 * for (int j = 0; j < featureSet[0].length; j++) { double distance = Math
	 * .abs(featureSet[0][j] - t.getFeatureSet(0, j)); MD += distance; }
	 * 
	 * NMDs[0] = MD / (featureSet[0].length * max_x);// normalized manhattan //
	 * distance (NMD) is the // MD per max possble // difference (total //
	 * amount of features // times max of each // feture)
	 * 
	 * for (int j = 0; j < featureSet[1].length; j++) { double distance = Math
	 * .abs(featureSet[1][j] - t.getFeatureSet(1, j)); MD += distance; }
	 * 
	 * NMDs[1] = MD / (featureSet[1].length * max_y);// normalized manhattan //
	 * distance (NMD) is the // MD per max possble // difference (total //
	 * amount of features // times max of each // feture)
	 * 
	 * for (int j = 0; j < featureSet[2].length; j++) { double distance = Math
	 * .abs(featureSet[2][j] - t.getFeatureSet(2, j)); MD += distance; }
	 * 
	 * NMDs[2] = MD / (featureSet[2].length * max_r);// normalized manhattan //
	 * distance (NMD) is the // MD per max possble // difference (total //
	 * amount of features // times max of each // feture)
	 * 
	 * return NMDs; }
	 */

	/**
	 * @return the featureSet
	 */
	public double getFeatureSet(int type, int index) {
		//System.out.println("inside getFeatureSet... "+featureSetImproved.get(type).get(index));
		//System.out.println("featureSetImproved return value: "+ featureSetImproved.get(type).get(index));
		
		return featureSetImproved.get(type).get(index);
	}

	/**
	 * @return the subjectNumber
	 */
	public int getSubjectNumber() {
		return subjectNumber;
	}

	/**
	 * @param subjectNumber
	 *            the subjectNumber to set
	 */
	public void setSubjectNumber(int subjectNumber) {
		this.subjectNumber = subjectNumber;
	}

	/**
	 * @return the instanceNumber
	 */
	public int getInstanceNumber() {
		return instanceNumber;
	}
	
	public int getRank(){
		return cmc_rank;
	}

	/**
	 * @param instanceNumber
	 *            the instanceNumber to set
	 */
	public void setInstanceNumber(int instanceNumber) {
		this.instanceNumber = instanceNumber;
	}
	
	public void setRank(int rank){
		cmc_rank = rank;
	}

}