/*
 * Даны действительные числа  . Найти
 .
 */

package by.epamtc.zhurava.array.task01;

public class Main {

	public static void main(String[] args) {
		
		double[] numbers = { 1, 4, 8, 16, 2, 3, 5, 1 };

		System.out.println(findMaxSum(numbers));

	}
	
	private static double findMaxSum(double[] numbers) {

		int lastNumberIndex;
		lastNumberIndex = numbers.length - 1;

		double maxSum;
		maxSum = numbers[0] + numbers[lastNumberIndex];

		for (int fistNumberIndex = 1; fistNumberIndex < numbers.length / 2; fistNumberIndex++) {

			double thisSum;
			thisSum = numbers[fistNumberIndex] + numbers[lastNumberIndex - fistNumberIndex];

			if (thisSum > maxSum) {
				maxSum = thisSum;
			}
		}

		return maxSum;
	}

}
