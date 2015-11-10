package task2;

import com.sun.istack.internal.NotNull;

public class Abbreviate {
	/**
	 * Write covering tests + refactor code. In this task you can simplify the
	 * signature. All usages in project are listed in Usages.java
	 */
	private static String DOTS = "...";

	public static String abbreviate(@NotNull String str, int maxWidth) {
		int effectiveLength = maxWidth - DOTS.length();
		if (numberOfSymbolsToCut(str, effectiveLength) <= DOTS.length()) {
			return str;
		}
		return cut(str, effectiveLength) + DOTS;
	}

	public static String abbreviate(@NotNull String str, int maxWidth, int offset) {
		String result = abbreviate(str, calculateCutEndPoint(maxWidth, offset));
		if (isOffsetAfterDots(result, offset)) {
			return DOTS;
		}
		return cutAtTheBeginningIfNeeded(result, offset);
	}

	public static String abbreviateAtFront(@NotNull String str, int offset) {
		return abbreviate(str, str.length(), offset);
	}
	
	private static int calculateCutEndPoint(int maxWidth, int offset) {
		return offset + maxWidth - DOTS.length();
	}

	private static String cutAtTheBeginningIfNeeded(String result, int offset) {
		if (offset <= DOTS.length()) {
			return result;
		}
		return DOTS + cutAtTheBeginning(result, offset);
	}

	private static String cutAtTheBeginning(String result, int offset) {
		return result.substring(offset);
	}

	private static boolean isOffsetAfterDots(String result, int offset) {
		return offset >= result.length() - DOTS.length();
	}

	private static String cut(String str, int resultLength) {
		return str.substring(0, resultLength >= 0 ? resultLength : 0);
	}
	
	private static int numberOfSymbolsToCut(String str, int width) {
		int strLength = str.length();
		return strLength >= width ? strLength - width : 0;
	}
}
