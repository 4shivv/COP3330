/* Shivaganesh Nagamandla
 * COP 3330
 * Assignment 1
 */

package assignment2;

public class Dice {
	// instance variables (objects)
	private Die die1;
	private Die die2;

	public Dice() {
		this.die1 = new Die();
		this.die2 = new Die();
	} // end of no-arg constructor

	public int getFaceValueSum() {
		return die1.getFaceValue() + die2.getFaceValue();
	} // end of gettotalFaceValue method

	public void roll() {
		die1.roll();
		die2.roll();
	} // end of roll method
} // end of Dice Class
