/*
 * Дана последовательность целых чисел  . 
 * Образовать новую последовательность, выбросив из исходной те члены, которые равны минимуму.
 */

package by.epamtc.zhurava.array.task02;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] numbers = new int[] { 1, 4, 7, 1, 1, 4, 6, 8, 7 };

		int[] numbersWithoutMin;
		numbersWithoutMin = deleteMinimalNumbers(numbers);

		System.out.println(Arrays.toString(numbersWithoutMin));

	}

	private static int[] deleteMinimalNumbers(int[] numbers) {

		int minimum;
		int[] arrayWithoutMinimal;
		int arrayLengthWithoutMinimals;

		minimum = findMinimum(numbers);

		arrayLengthWithoutMinimals = findArrayLengthWithoutMinimals(minimum, numbers);

		arrayWithoutMinimal = new int[arrayLengthWithoutMinimals];

		int count;
		count = 0;

		for (int index = 0; index < numbers.length; index++) {
			if (numbers[index] != minimum) {
				arrayWithoutMinimal[count++] = numbers[index];
			}
		}

		return arrayWithoutMinimal;
	}

	private static int findArrayLengthWithoutMinimals(int minimum, int[] numbers) {

		int frequencyOfMinimal;
		int arrayLength;

		frequencyOfMinimal = findFrequencyOfNumber(minimum, numbers);

		arrayLength = numbers.length - frequencyOfMinimal;

		return arrayLength;
	}

	private static int findMinimum(int[] numbers) {

		int minimum;
		minimum = numbers[0];

		for (int index = 1; index < numbers.length; index++) {
			if (numbers[index] < minimum) {
				minimum = numbers[index];
			}
		}
		return minimum;
	}

	private static int findFrequencyOfNumber(int num, int[] numbers) {

		int count;
		count = 0;

		for (int index = 0; index < numbers.length; index++) {
			if (numbers[index] == num) {
				count++;
			}
		}

		return count;
	}

}
