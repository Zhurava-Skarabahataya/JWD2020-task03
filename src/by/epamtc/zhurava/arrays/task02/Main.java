/*
 * Дана последовательность целых чисел  . 
 * Образовать новую последовательность, выбросив из исходной те члены, которые равны  .
 */

package by.epamtc.zhurava.arrays.task02;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] numbers = { 1, 4, 7, 4, 6, 8, 7 };

		int[] uniqueNumbers;
		uniqueNumbers = deleteEqualNumbers(numbers);

		System.out.println(Arrays.toString(uniqueNumbers));

	}

	private static int[] deleteEqualNumbers(int[] numbers) {
		
		int amountOfUniqueNumbers;
		amountOfUniqueNumbers = countUniqueNumbers(numbers);

		int[] uniqueNumbers;
		uniqueNumbers = new int[amountOfUniqueNumbers];

		int uniqueCounter;
		uniqueCounter = 0;

		for (int i = 0; i < numbers.length; i++) {
			if (isNumberUnique(numbers[i], numbers)) {
				uniqueNumbers[uniqueCounter++] = numbers[i];
			}
		}
		
		return uniqueNumbers;
	}

	private static int countUniqueNumbers(int[] numbers) {
		int counter;
		counter = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			if (isNumberUnique(numbers[i], numbers)) {
				counter++;
			}
		}
		
		return counter;
	}

	private static boolean isNumberUnique(int number, int[] array) {
		int counter;
		counter = 0;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				counter++;
			}
		}
		
		return counter > 1 ? false : true;
	}

}
