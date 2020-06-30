/*
 * 4. В массиве целых чисел с количеством элементов n найти наиболее часто встречающееся число.
 *  Если таких чисел несколько, то определить наименьшее из них.
 */

package by.epamtc.zhurava.array.task04;

public class Main {

	public static void main(String[] args) {

		int[] numbers = new int[] { 3, 6, 1, 2, 2, 2, 7, 7, 7, 4, 8 };

		System.out.println(findMostFrequentNumber(numbers));

	}

	private static int findMostFrequentNumber(int[] numbers) {

		int maxFrequency;
		int mostFrequentNumber;

		maxFrequency = 0;
		mostFrequentNumber = numbers[0];

		for (int index = 0; index < numbers.length; index++) {

			int frequency;
			frequency = findFrequency(numbers[index], numbers);

			if (frequency > maxFrequency) {
				maxFrequency = frequency;
				mostFrequentNumber = numbers[index];

			} else if (frequency == maxFrequency) {
				if (numbers[index] < mostFrequentNumber) {
					mostFrequentNumber = numbers[index];
				}
			}
		}

		return mostFrequentNumber;
	}

	private static int findFrequency(int number, int[] numbers) {

		int counter;
		counter = 0;

		for (int index = 0; index < numbers.length; index++) {
			if (number == numbers[index]) {
				counter++;
			}
		}
		return counter;
	}

}
