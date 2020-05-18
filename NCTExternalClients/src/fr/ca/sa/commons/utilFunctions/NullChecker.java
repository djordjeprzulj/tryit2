package fr.ca.sa.commons.utilFunctions;

public class NullChecker {

	public static boolean isNotNullZeroAndMinusOne(Integer arg) {
		return (arg != null && arg != -1 && arg != 0);
	}

	public static boolean isNotNullAndMinusOne(Integer arg) {
		return (arg != null && arg != -1);
	}

	public static boolean isNotNullAndEmpty(String arg) {
		return (arg != null && !arg.isEmpty());
	}

	public static boolean isNotNullAndFalse(Boolean arg) {
		return (arg != null && arg != false);
	}
}
