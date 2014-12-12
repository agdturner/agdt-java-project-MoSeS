package uk.ac.leeds.sog.moses.populationmodel.probability;

import java.util.Random;


public class TestRandomProbabilityDeterminator implements Determinator {
	
	private double i_probability;
	private Random random = new Random(System.currentTimeMillis());

	public TestRandomProbabilityDeterminator(double probability) {
		i_probability = probability;
	}
	
	public boolean determine(Object object) {
		if(i_probability == 1.0) {
			return false;
		}
		if(i_probability == 0.0) {
			return true;
		}
		if(random.nextDouble() < i_probability) {
			return true;
		} else {
			return false;
		}
	}
	
	public double getProbability() {
		return i_probability;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestRandomProbabilityDeterminator test = new TestRandomProbabilityDeterminator(0.1485);
		int count = 0;
		for(int i=1; i<=10000; i++) {
			if(test.determine(null)) {
				System.out.println(i + " true");
				count++;
			}
		}
		System.out.println("Total number of dead persons: " + count);
		
	}

}


