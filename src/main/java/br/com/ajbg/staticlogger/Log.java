package br.com.ajbg.staticlogger;

import java.io.PrintStream;
import java.io.FileOutputStream;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.Date;

public class Log {
	private static BlockingQueue<String> queue =
			new LinkedBlockingDeque<String>();
	private static LogWriter writer = new LogWriter(queue);

	private static String logFile = "logfile.log";
	private static String mainPat =
			"[%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS][%2$s] ";

	public static void file(String logFile) {
		Log.logFile = logFile;
	}

	public static void format(String mainPat) {
		Log.mainPat = mainPat;
	}

	private static void log(String pattern, String level, Object... msg) {
		String main = String.format(mainPat, new Date(), level);
		queue.add(main + String.format(pattern, msg) + "\n");
		if (!writer.isAlive()) {
			writer.start();
		}
	}

	public static void debug(String pattern, Object... msg) {
		log(pattern, "DEBUG", msg);
	}

	public static void info(String pattern, Object... msg) {
		log(pattern, "INFO", msg);
	}

	public static void warning(String pattern, Object... msg) {
		log(pattern, "WARN", msg);
	}

	public static void error(String pattern, Object... msg) {
		log(pattern, "ERROR", msg);
	}

	static class LogWriter extends Thread {
		private BlockingQueue<String> queue;

		public LogWriter(BlockingQueue<String> queue) {
			this.queue = queue;
		}

		public void run() {
			try {
				PrintStream ps = new PrintStream(
					new FileOutputStream(logFile, true));
				while (queue.peek() != null) {
					ps.print(queue.take());
				}
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
