package br.com.ajbg.staticlogger;

public class Log {
	private static String pattern = "[$HH:$mm:$ss $yyyy-$MM-$dd] " +
			"$package.$class#$method: $message";

	public static void format(String pattern) {
	}

	public static void info(String message) {
		info(message, null, pattern);
	}

	public static void info(String message, Object obj) {
		info(message, obj, pattern);
	}

	public static void info(String message, String pattern) {
		info(message, null, pattern);
	}

	public static synchronized void info(String message,
			Object obj, String pattern) {
		System.out.println("INFO: " + message);
		System.out.println(obj);
	}

	public static void warning(String message) {
		warning(message, null, pattern);
	}

	public static void warning(String message, Object obj) {
		warning(message, obj, pattern);
	}

	public static void warning(String message, String pattern) {
		warning(message, null, pattern);
	}

	public static synchronized void warning(String message,
			Object obj, String pattern) {
		System.out.println("WARN: " + message);
		System.out.println(obj);
	}

	public static void error(String message) {
		error(message, null, pattern);
	}

	public static void error(String message, Object obj) {
		error(message, obj, pattern);
	}

	public static void error(String message, String pattern) {
		error(message, null, pattern);
	}

	public static synchronized void error(String message,
			Object obj, String pattern) {
		System.out.println("ERRO: " + message);
		System.out.println(obj);
	}

	public static void error(Exception exp) {
		error(exp, null, pattern);
	}

	public static void error(Exception exp, Object obj) {
		error(exp, obj, pattern);
	}

	public static void error(Exception exp, String pattern) {
		error(exp, null, pattern);
	}

	public static synchronized void error(Exception exp,
			Object obj, String pattern) {
		System.out.println("ERRO: " + exp.getMessage());
		System.out.println(obj);
	}
}
