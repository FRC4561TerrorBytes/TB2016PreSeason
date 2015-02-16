/**
 * 
 */
package org.usfirst.frc.team4561.robot;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;

/**
 * pings and reads gyro through out match
 *
 */
public class GyroReadThread extends Thread {
	private static final char LINE_TERMINATOR = '\n';
	private static final String BAD_DATA = "BAD_DATA";
	private static final int PING_TO_READ_SLEEP_MS = 1;
	private static final int NUMBER_NO_DATA_READS_UNTIL_REPING = 10;
	private SerialPort gyro = new SerialPort(38400, Port.kMXP);
	double lastGoodRotation = 0.0;
	boolean needToSaveBias = true;
	double bias = 0.0;
	
	// for test
	String lastRawData = "";
	public String getLastRawData() {
		return lastRawData;
	}
	
	/**
	 * Called from other threads to get latest good rotation.
	 */
	public synchronized double getLastGoodRotation() {
		return lastGoodRotation;
	}
	
	/**
	 * Called from other threads to reset gyro.
	 */
	public synchronized void reset() {
		lastGoodRotation = 0.0;
		needToSaveBias = true;
		bias = 0.0;
	}
	
	public synchronized double getBias() {
		return bias;
	}

	/**
	 * 
	 */
	public GyroReadThread() {
		super();
	}
	
	/**
	 * Runs forever pinging and then reading the gyro.
	 */
	@Override
	public void run() {
		while (true) {
			pingGyro();
			String rawData = null;
			int timeOut = NUMBER_NO_DATA_READS_UNTIL_REPING;
			// Read until data (good or bad) or timeout
			while (rawData == null && timeOut > 0) {
				timeOut--;
				try {
					sleep(PING_TO_READ_SLEEP_MS);
				} catch (InterruptedException e) {
				}
				rawData = readGyro();
				if ((rawData != null) && (rawData != BAD_DATA)) {
					double yaw = 0.0;
					try {
						yaw = Double.parseDouble(rawData);
					} catch (Throwable t) {
						rawData = BAD_DATA;
					}
					if (rawData != BAD_DATA) {
						// only place state is referenced in this thread
						synchronized (this) {
							lastGoodRotation = yaw;
							if (needToSaveBias) {
								bias = yaw;
								needToSaveBias = false;
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Ask the gyro for data.
	 */
	private void pingGyro() {
		gyro.writeString("#f");
	}

	/**
	 * Read data from serial port. Return null if no data. Return BAD_DATA if
	 * data not parseable. Return the yaw as a string if good data.
	 * 
	 * @return
	 */
	private String readGyro() {
		//String rawData = gyro.readString();
		String rawData = readGyroLine();
		if (rawData == null || rawData.isEmpty()) {
			return null;
		} else {
			lastRawData = rawData;
			try {
				int lastLine = rawData.lastIndexOf(LINE_TERMINATOR);
				String yawPitchRoll = rawData.substring(rawData.lastIndexOf('=', lastLine) + 1);
				String stringYaw = yawPitchRoll.substring(0, yawPitchRoll.indexOf(','));
				if ((stringYaw == null) || (stringYaw.isEmpty()))
					return BAD_DATA;
				else
					return stringYaw;
			} catch (Throwable t) {
				return BAD_DATA;
			}
		}
	}
	
	private String readGyroLine() {
		StringBuilder strBldr = new StringBuilder(50);
		String currentChar = null;
		char c = ' ';
		while (c != LINE_TERMINATOR) {
			if (!(gyro.getBytesReceived() == 0)) {
				currentChar = gyro.readString(1);
				if (currentChar != null && !currentChar.isEmpty()) {
					c = currentChar.charAt(0);
					strBldr.append(c);
				}
			} else {
				try {
					sleep(0);
				} catch (InterruptedException e) {
				}
			}
		}
		return strBldr.toString();
	}
}
