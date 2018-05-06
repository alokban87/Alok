/**
 * 
 */
package myPack;

/**
 * @author alobansa
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BerlinUhrClock clock = new BerlinUhrClock("15:23:01");

		System.out.println("====== *************** Start Output****************** ======");
		clock.printClock();
		System.out.println("====== ***************End Output****************** ======");

	}

}
