package uk.ac.leeds.sog.moses.populationmodel.probability;

import java.util.ArrayList;
import java.util.List;

public class MultiValueDeterminator {
	private List i_emptyKeyList;
	private List i_keyList;
	private List i_numberList;
	private int i_totoalNumber;
	private int i_index;
	private List i_numbers;
	public MultiValueDeterminator(List keyList, List numberList) {
		i_emptyKeyList = new ArrayList(0);
		i_keyList = new ArrayList();
		i_numberList = new ArrayList();
		i_totoalNumber = 0;
		for(int i=0; i<keyList.size(); i++) {
			Integer age = (Integer) keyList.get(i);
			Integer number = (Integer) numberList.get(i);
			if(number.intValue() == 0) {
				i_emptyKeyList.add(new Integer(age.intValue()));
			} else {
				i_keyList.add(new Integer(age.intValue()));
				i_numberList.add(new Integer(number.intValue()));
				i_totoalNumber += number.intValue();
			}
		}
		i_index = 0;
		i_numbers = new ArrayList(0);
		setRandomNumbers();
	}
	
	private void setRandomNumbers() {
		i_index = 0;
		i_numbers.clear();
		List temp1 = new ArrayList(i_totoalNumber);
		List temp2 = new ArrayList(i_totoalNumber);
		for(int i=0; i<i_totoalNumber; i++) {
			temp1.add(new Integer(i+1));
		}
		
		for(int i=0; i<i_totoalNumber; i++) {
			int a = (int)Math.round(Math.random() * temp1.size() -1);
			if(a == -1 && temp1.size() == 1) {
				a = 0;
			}
			temp2.add(temp1.get(Math.abs(a)));
			temp1.remove(Math.abs(a));
		}
		
		for(int i=0; i<i_totoalNumber; i++) {
			int value = getNumber((Integer) temp2.get(i));
			i_numbers.add(new Integer(value));
		}
	}
	
	private int getNumber(Integer index) {
		int result = 0;
		
		int count = 0;
		for(int i=0; i<i_keyList.size(); i++) {
			Integer age = (Integer) i_keyList.get(i);
			Integer number = (Integer) i_numberList.get(i);
			count += number.intValue();
			if(index.intValue() <= count) {
				result = age.intValue();
				break;
			}
		}
		
		return result;
	}
	
	public int getValue() {
		if(i_index == i_totoalNumber) {
			setRandomNumbers();
		}
		int value = ((Integer) i_numbers.get(i_index)).intValue();
		i_index++;
		return value;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List a = new ArrayList();
		a.add(new Integer(80));
		a.add(new Integer(81));
		a.add(new Integer(82));
		a.add(new Integer(83));
		a.add(new Integer(84));
		List b = new ArrayList();
		b.add(new Integer(4));
		b.add(new Integer(2));
		b.add(new Integer(0));
		b.add(new Integer(3));
		b.add(new Integer(2));
		MultiValueDeterminator determinator = new MultiValueDeterminator(a, b);
		int count80 = 0;
		int count81 = 0;
		int count82 = 0;
		int count83 = 0;
		int count84 = 0;
		for(int i=0; i<110; i++) {
			int value = determinator.getValue();
			if(value == 80) {
				count80++;
			}
			if(value == 81) {
				count81++;
			}
			if(value == 82) {
				count82++;
			}
			if(value == 83) {
				count83++;
			}
			if(value == 84) {
				count84++;
			}
		}
		System.out.println("Number of 80 persons: " + count80);
		System.out.println("Number of 81 persons: " + count81);
		System.out.println("Number of 82 persons: " + count82);
		System.out.println("Number of 83 persons: " + count83);
		System.out.println("Number of 84 persons: " + count84);
	}

}
