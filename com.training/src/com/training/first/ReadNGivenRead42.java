package com.training.first;

public class ReadNGivenRead42 {

	private char[] buffer = new char[4];
	int offset = 0, bufsize = 0;

	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */
	private int read4(char[] buf) {
		return 4;
	}

	public int read(char[] buf, int n) {
		int readBytes = 0;
		boolean eof = false;
		while (!eof && readBytes < n) {
			if (bufsize == 0) {
				bufsize = read4(buffer);
				eof = bufsize < 4;
			}
			int bytes = Math.min(n - readBytes, bufsize);
			System.arraycopy(buffer /* src */, offset /* srcPos */, buf /* dest */,
					readBytes /* destPos */, bytes /* length */);
			offset = (offset + bytes) % 4;
			bufsize -= bytes;
			readBytes += bytes;
		}
		return readBytes;
	}
}
