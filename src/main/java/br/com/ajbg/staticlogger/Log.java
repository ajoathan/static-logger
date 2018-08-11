package br.com.ajbg.staticlogger;

import java.util.Date;

public class Log {
	private static String mainPat =
			"[%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS][%2$s] ";

	public static void format(String mainPat) {
		Log.mainPat = mainPat;
	}

	private static void log(String pattern, String level, Object... msg) {
		String main = String.format(mainPat, new Date(), level);
		System.out.print(main + String.format(pattern, msg) + "\n");
	}

	public static void debug(String pattern, Object... msg) {
		log(pattern, "DEBUG", msg);
	}

	public static void info(String pattern, Object... msg) {
		log(pattern, " INFO", msg);
	}

	public static void warning(String pattern, Object... msg) {
		log(pattern, " WARN", msg);
	}

	public static void error(String pattern, Object... msg) {
		log(pattern, "ERROR", msg);
	}
}
