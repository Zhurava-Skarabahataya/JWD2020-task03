/* . Дан одномерный массив A[N]. Найти:
 */

package by.epamtc.zhurava.array.task05;

public class Main {

	public static void main(String[] args) {

		double[] numbers = new double[] { 2, 5, 3, 7, 1, 14 };

		System.out.println(findSumOfMinAndMax(numbers));

	}

	private static double findSumOfMinAndMax(double[] numbers) {

		double maxOfEvenIndex;
		double minOfOddIndex;

		maxOfEvenIndex = findMaxOfEven(numbers);
		minOfOddIndex = findMinOfOdd(numbers);

		return maxOfEvenIndex + minOfOddIndex;
	}

	private static double findMinOfOdd(double[] numbers) {

		double min;
		min = numbers[0];

		for (int i = 0; i < numbers.length; i += 2) {
			if (numbers[i] < min) {
				min = numbers[i];
			}
		}

		return min;
	}

	private static double findMaxOfEven(double[] numbers) {

		double max;
		max = numbers[1];

		for (int i = 1; i < numbers.length; i += 2) {
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}

		return max;
	}

}
