package uk.ac.leeds.sog.moses.populationmodel.probability;

import java.util.ArrayList;
import java.util.List;


public class RandomProbabilityDeterminator implements Determinator {
	private final int i_upperBound;
	private double i_probability;
	private int i_index;
	private List i_numbers;

	public RandomProbabilityDeterminator(double probability, int upperBound) {
		i_probability = probability;
		i_numbers = new ArrayList();
		i_upperBound = upperBound;
		if(i_probability != 1.0 && i_probability != 0.0) {
			setRandomNumbers();
		}
	}
	
	public RandomProbabilityDeterminator(double probability, int upperBound, boolean flag) {
		if(flag) {
			i_probability = 1.0 - probability;
		} else {
			i_probability = probability;
		}
		i_numbers = new ArrayList();
		i_upperBound = upperBound;
		if(i_probability != 1.0 && i_probability != 0.0) {
			setRandomNumbers();
		}
	}
	
	private void setRandomNumbers() {
		i_index = 0;
		i_numbers.clear();
		int number = Math.round((float)i_probability * i_upperBound);
		List temp = new ArrayList(i_upperBound);
		for(int i=0; i<i_upperBound; i++) {
			temp.add(new Integer(i+1));
		}
		
		int count =  i_upperBound - number;
		for(int i=0; i<count; i++) {
			int a = (int)Math.round(Math.random() * temp.size() -1);
			if(a == -1 && temp.size() == 1) {
				a = 0;
			}
			i_numbers.add(temp.get(Math.abs(a)));
			/*try {
		    i_numbers.add(temp.get(Math.abs(a)));
			} catch(Exception e) {
				System.out.println("a: " + Math.abs(a));
				System.out.println("temp size: " + temp.size());
				System.out.println("i_probability: " + i_probability);
				System.exit(1);
			}*/
		    temp.remove(Math.abs(a));
		}
	}
	
	public boolean determine(Object object) {
		if(i_probability == 1.0) {
			return false;
		}
		if(i_probability == 0.0) {
			return true;
		}
		if(i_index >= i_upperBound) {
			setRandomNumbers();
		}
		i_index++;
		if(i_numbers.contains(new Integer(i_index))) {
			i_numbers.remove(new Integer(i_index));
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
		RandomProbabilityDeterminator test = new RandomProbabilityDeterminator(0.1423, 10000, true);
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

