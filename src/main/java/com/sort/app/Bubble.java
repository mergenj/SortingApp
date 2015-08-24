package com.sort.app;

public class Bubble implements ISort {

	@Override
	public int[] sort(int[] array) {
		for (int i = array.length; i >= 0; i--) {
			for (int j = 0; j < array.length - 1; j++) {
				int nextIndex = j + 1;
				if (array[j] > array[nextIndex]) {
					swapNumbers(j, nextIndex, array);
				}
			}
		}
		return array;
	}

	private static void swapNumbers(int i, int j, int[] array) {

		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public String toString(){
		return "Bubble";
	}

}
