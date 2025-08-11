/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Chris Pacia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.Arrays;

public class Ascii85 {

	private Ascii85() {
		// Prevent instantiation
	}

	/**
	 * Encode a string using Ascii85.
	 */
	public static String encode(String data) {
		byte[] bytes = data.getBytes();
		int padLen = calculatePadding(bytes.length);
		byte[] padded = padBytes(bytes, padLen);

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < padded.length; i += 4) {
			encodeBlock(padded, i, bytes.length, builder);
		}

		return "<~" + builder + "~>";
	}

	private static int calculatePadding(int length) {
		return (length % 4 == 0) ? 0 : 4 - (length % 4);
	}

	private static byte[] padBytes(byte[] bytes, int padLen) {
		return Arrays.copyOf(bytes, bytes.length + padLen);
	}

	private static void encodeBlock(byte[] padded, int offset, int originalLength, StringBuilder builder) {
		byte[] block = Arrays.copyOfRange(padded, offset, offset + 4);
		long x = Long.parseLong(bytesToHex(block), 16);

		int[] chars = {
				(int) (x / 52200625) % 85 + 33,
				(int) (x / 614125) % 85 + 33,
				(int) (x / 7225) % 85 + 33,
				(int) (x / 85) % 85 + 33,
				(int) x % 85 + 33
		};

		if (isZeroBlock(chars) && offset + 4 != padded.length) {
			builder.append('z');
			return;
		}

		int remaining = originalLength - offset;
		for (int j = 0; j < 5 && j < remaining + 1; j++) {
			builder.append((char) chars[j]);
		}
	}

	private static boolean isZeroBlock(int[] chars) {
		for (int c : chars) {
			if (c != 33)
				return false; // ' ' in Ascii85 is 33 after adding
		}
		return true;
	}

	private static final char[] hexArray = "0123456789ABCDEF".toCharArray();

	private static String bytesToHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int j = 0; j < bytes.length; j++) {
			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}
