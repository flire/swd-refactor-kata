package task1;

public class IndexOfAny {
	/**
	 * Write covering tests + refactor code. In this task signature should stay
	 * the same
	 */
	public static int indexOfAny(String str, char[] searchChars) {
		for (int i = 0; i < str.length(); ++i) {
			if (isArrayContains(str.charAt(i), searchChars)) {
				return i;
			}
		}

		return -1;
	}

	private static boolean isArrayContains(char symbol, char[] array) {
		for (char arraySymbol : array) {
			if (arraySymbol == symbol) {
				return true;
			}
		}
		return false;
	}
}
