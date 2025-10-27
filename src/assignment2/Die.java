/* Shivaganesh Nagamandla
 * COP 3330
 * Assignment 1
 */

package assignment2;

import java.util.Random;

public class Die {
	// instance variables
	private int faceValue;

	// no-args constructor
	public Die() {
		this.faceValue = 1;
	} // end of no-args constructor

	public int getFaceValue() {
		return faceValue;
	} // end of faceValue getter

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	} // end of faceValue setter

	public void roll() {
		Random rand = new Random();
		this.faceValue = rand.nextInt(6) + 1;
	} // end of roll method
} // end of Die class
