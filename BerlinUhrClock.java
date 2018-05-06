package myPack;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author alobansa
 *
 */
public class BerlinUhrClock {

	private String formattedTime;
	private static final String NEW_LINE = System.getProperty("line.separator");

	/**
	 * 
	 * @param time
	 */
	public BerlinUhrClock(String time) {

		if (time == null) {
			throw new IllegalArgumentException(BerlinUhrClockConstant.ERROR_NO_TIME);
		}

		String[] times = time.split(":", 3);

		if (times.length != 3) {
			throw new IllegalArgumentException(BerlinUhrClockConstant.ERROR_INVALID_TIME);
		}

		int hours = 0;
		int minutes = 0;
		int seconds = 0;

		try {
			hours = Integer.parseInt(times[0]);
			minutes = Integer.parseInt(times[1]);
			seconds = Integer.parseInt(times[2]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(BerlinUhrClockConstant.ERROR_NUMERIC_TIME);
		}

		if (hours < 0 || hours > 23)
			throw new IllegalArgumentException(BerlinUhrClockConstant.HOURS_OUT_OF_SCOPE);
		if (minutes < 0 || minutes > 59)
			throw new IllegalArgumentException(BerlinUhrClockConstant.MINUTES_OUT_OF_SCOPE);
		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException(BerlinUhrClockConstant.SECONDS_OUT_OF_SCOPE);

		this.formattedTime = formatTime(hours, minutes, seconds);
	}

	/**
	 * 
	 * @param hours
	 * @param minutes
	 * @param seconds
	 * @return
	 */
	private String formatTime(int hours, int minutes, int seconds) {

		String second = (seconds % 2 == 0) ? BerlinUhrClockConstant.Y : BerlinUhrClockConstant._0;
		String hour1 = convertIntoString(hours / 5, 4, BerlinUhrClockConstant.R);
		String hour2 = convertIntoString(hours % 5, 4, BerlinUhrClockConstant.R);
		String minute1 = convertIntoString(minutes / 5, 11, BerlinUhrClockConstant.Y).replaceAll(BerlinUhrClockConstant.YYY, BerlinUhrClockConstant.YYR);
		String minute2 = convertIntoString(minutes % 5, 4, BerlinUhrClockConstant.Y);

		return String.join(NEW_LINE, Arrays.asList(second, hour1, hour2, minute1, minute2));

	}

	/**
	 * 
	 * @param litLights
	 * @param lightsInRow
	 * @param lampType
	 * @return
	 */
	private String convertIntoString(int litLights, int lightsInRow, String lampType) {

		int unlitLights = lightsInRow - litLights;
		String lit = String.join("", Collections.nCopies(litLights, lampType));
		String unlit = String.join("", Collections.nCopies(unlitLights, BerlinUhrClockConstant._0));

		return lit + unlit;
	}

	/**
	 * Print a the berlin time.
	 */
	public void printClock() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return this.formattedTime;
	}

}
