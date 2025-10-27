/* Shivaganesh Nagamandla
 * COP 3330
 * Assignment 1
 * Additional Methods: roll, printOccurences, printOccurencesGraph
 */

package assignment2;

public class Nagamandla_Shivaganesh {

	public static void main(String[] args) {
		// create instance of dice
		Dice dice = new Dice();

		// create integer array to hold indexes from 2-12
		int[] arr = new int[13];

		roll(dice, arr);
		printOccurrences(arr);
		printOccurrencesGraph(arr);
	} // end of main method

	public static void roll(Dice dice, int[] arr) {
		// roll dice 1000 times
		for (int i = 0; i < 1000; i++) {
			dice.roll();
			int rolled = dice.getFaceValueSum();
			arr[rolled]++;
		} // end of for loop
	} // end of roll method

	public static void printOccurrences(int[] arr) {
		for (int i = 2; i <= 12; i++) {
			System.out.println("Number of " + i + "s are " + arr[i]);
		}
	} // end of printOccurrences

	public static void printOccurrencesGraph(int[] arr) {
		int maxCount = 0;
		for (int i = 2; i <= 12; i++) {
			if (arr[i] > maxCount) {
				maxCount = arr[i];
			}
		}

		System.out.println("Graph");
		for (int i = 150; i >= 0; i -= 25) {
			System.out.printf("%3d| ", i);
			for (int j = 2; j <= 12; j++) {
				if (arr[j] >= i) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println("   --------------------------------");
		System.out.println("    2 3 4 5 6 7 8 9 10 11 12");
	} // end of printOccurrencesGraph
} // end of class
