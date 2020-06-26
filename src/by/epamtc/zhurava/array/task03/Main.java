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
		int[] lock = new int[10];

		lock[0] = 6;
		lock[5] = 1;
		int index1 = 0;
		int index2 = 5;

		//int[] codeToUnlock = 
				findCode(lock, index1, index2);
		System.out.println(Arrays.toString(lock));


	}
	
	private static void findCode(int[] lock, int index1, int index2) {
		if (lock[index1] + lock[index2] > 9 || (lock[index1] + lock[index2]) < 4) {
			System.out.println("Невозможно");
		}
		
		
		if (Math.abs(index1 - index2) == 1) {
			findCodeForNeighbors(lock, index1, index2);
		} else {
			 findCodeBetween(lock, index1, index2);
		}

	}

	private static void findCodeBetween(int[] lock, int index1, int index2) {
		int beginIndex1 = index1%3;
		for (int i = beginIndex1; i < lock.length; i+=3) {
			lock[i] = lock[index1];
		}

		//return lock;
	}

	private static void findCodeForNeighbors(int[] lock, int index1, int index2) {
		
		for (int i = Math.min(index1, index2) + 2; i < lock.length; i++) {
			lock[i] = 10 - (lock[i - 1] + lock[i - 2]);
		}
		for (int i = Math.min(index1, index2) - 1; i >= 0; i--) {
			lock[i] = 10 - (lock[i + 1] + lock[i + 2]);
		}

		//return lock;
	}


}
