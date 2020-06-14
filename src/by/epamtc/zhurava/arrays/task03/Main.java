/*
 * 3*. «Суперзамок». Секретный замок для сейфа состоит из 10 расположенных в рад ячеек, 
 * в которые надо вставить игральные кубики. 
 * Но дверь открывается только в том случае, когда в любых трех соседних ячейках 
 * сумма точек на передних гранях кубиков равна 10. 
 * (Игральный кубик имеет на каждой грани от 1 до 6 точек). 
 * Напишите программу, которая разгадывает код замка при условии, что два кубика уже вставлены в ячейки.
 */

package by.epamtc.zhurava.arrays.task03;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] lock = new int[10];
		
		lock[0] = 5;
		lock[1] = 4;
		
		int[] codeToUnlock = findCode(lock);
		System.out.println(Arrays.toString(codeToUnlock));
		
	}

	private static int[] findCode(int[] lock) {
		for (int i = 2; i < lock.length; i++) {
			lock[i] = 10 - lock[i-1] - lock[i-2];
		}
		
		return lock;
	}

}
