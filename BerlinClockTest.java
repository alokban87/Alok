package myPack;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

/**
 * @author alobansa
 *
 */
class BerlinClockTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void testMinValidBerlinClock() {
		new BerlinUhrClock("00:00:00");
	}

	@Test
	public void testMaxValidBerlinClock() {
		new BerlinUhrClock("23:59:59");
	}

	@Test
	public void testPrintClock() {
		BerlinUhrClock clock = new BerlinUhrClock("12:30:30");
		clock.printClock();

		String expected = "Y\n" + "RR00\n" + "RR00\n" + "YYRYYR00000\n" + "0000\n";

		assertEquals(expected, outContent.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUpperInvalidHours() {
		new BerlinUhrClock("24:00:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUpperInvalidMinutes() {
		new BerlinUhrClock("00:60:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testUpperInvalidSeconds() {
		new BerlinUhrClock("00:00:60");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLowerInvalidHours() {
		new BerlinUhrClock("-01:00:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLowerInvalidMinutes() {
		new BerlinUhrClock("00:-01:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLowerInvalidSeconds() {
		new BerlinUhrClock("00:00:-01");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidString() {
		new BerlinUhrClock("00:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullString() {
		new BerlinUhrClock(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyString() {
		new BerlinUhrClock("");
	}

	

}
