package com.sort.app;

public class Merge implements ISort {
	private int[] array;
	private int[] tempArray;

	@Override
	public int[] sort(int[] array) {
		this.array = array;
		this.tempArray = new int[array.length];

		return sort(0, array.length - 1);
	}

	private int[] sort(int lowerIndex, int higherIndex) {
		if (lowerIndex < higherIndex) {
			int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
			// Below step sorts the left side of the array
			sort(lowerIndex, middle);
			// Below step sorts the right side of the array
			sort(middle + 1, higherIndex);
			// Now merge both sides
			 mergeParts(lowerIndex, middle, higherIndex);
			return array;
		} else
			return null;
	}

	private void mergeParts(int lowerIndex, int middle, int higherIndex) {

		for (int i = lowerIndex; i <= higherIndex; i++) {
			tempArray[i] = array[i];
		}
		int i = lowerIndex;
		int j = middle + 1;
		int k = lowerIndex;
		while (i <= middle && j <= higherIndex) {
			if (tempArray[i] <= tempArray[j]) {
				array[k] = tempArray[i];
				i++;
			} else {
				array[k] = tempArray[j];
				j++;
			}
			k++;
		}
		while (i <= middle) {
			array[k] = tempArray[i];
			k++;
			i++;
		}

	}
	
	public String toString(){
		return "Merge";
	}

}
