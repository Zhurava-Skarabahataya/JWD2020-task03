/* 3. «Суперзамок». Секретный замок для сейфа состоит из 10 расположенных в рад ячеек, 
 * в которые надо вставить игральные кубики. 
 * Но дверь открывается только в том случае, когда в любых трех соседних ячейках 
 * сумма точек на передних гранях кубиков равна 10. 
 * (Игральный кубик имеет на каждой грани от 1 до 6 точек). 
 * Напишите программу, которая разгадывает код замка при условии, что два кубика уже вставлены в ячейки.
 */

package by.epamtc.zhurava.array.task03;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[] lock;

		lock = new int[10];

		lock[3] = 1;
		lock[5] = 7;

		int index1 = 3;
		int index2 = 5;

		findSecretCode(lock, index1, index2);

		System.out.println(Arrays.toString(lock));

	}

	private static void findSecretCode(int[] lock, int index1, int index2) {

		if (isPossible(lock, index1, index2)) {

			if (lock[index1] != lock[index2]) {

				fillArrayWithNumberInIndex(lock, index1);
				fillArrayWithNumberInIndex(lock, index2);

				int lastNumber;
				lastNumber = 10 - (lock[index1] + lock[index2]);

				fillArrayNulsWithNumber(lock, lastNumber);

			} else {

				int othersSum;
				int firstNumber;
				int secondNumber;

				othersSum = 10 - lock[index1];
				firstNumber = 0;
				secondNumber = 0;

				for (int i = 1; i <= 6; i++) {
					for (int j = 1; j <= 6; j++) {
						if (i + j == othersSum) {
							firstNumber = i;
							secondNumber = j;
							break;
						}
					}
				}

				fillArrayWithNumberInIndex(lock, index1);
				
				fillArrayWithNumberInIndex(lock, index1 + 1, firstNumber);
				fillArrayWithNumberInIndex(lock, index1 + 2, secondNumber);

			}
		}

	}

	private static void fillArrayNulsWithNumber(int[] lock, int lastNumber) {
		for (int index = 0; index < lock.length; index++) {
			if (lock[index] == 0) {
				lock[index] = lastNumber;
			}
		}

	}

	private static void fillArrayWithNumberInIndex(int[] lock, int index, int firstOther) {
		for (int start = index % 3; start < lock.length; start += 3) {
			lock[start] = firstOther;
		}

	}

	private static void fillArrayWithNumberInIndex(int[] lock, int index1) {
		for (int start = index1 % 3; start < lock.length; start += 3) {
			lock[start] = lock[index1];
		}

	}

	 private static boolean isPossible(int[] lock, int index1, int index2) {

	        if ((index1 - index2) % 3 == 0) {
	            return lock[index1] == lock[index2];

	        } else if (lock[index1] + lock[index2] > 9 || (lock[index1] + lock[index2]) < 4) {
	            return false;
	        }

	        return true;
	    }

	}
