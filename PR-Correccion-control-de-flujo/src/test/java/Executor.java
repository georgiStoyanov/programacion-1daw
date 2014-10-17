import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Executor implements Callable<String> {

	private static void log(String s) {
		//System.err.println("Executor:" + s);
	}

	private String _cmd[];
	private String _input;
	private File _directory;

	public Executor(File directory, String cmd, String input) {
		this(directory, new String[] { cmd }, input);
	}

	public Executor(File directory, String[] cmd, String input) {
		_cmd = cmd;
		_input = input;
		_directory = directory;
	}

	private static class InputToOutput implements Runnable {
		private InputStream _in;
		private OutputStream _out;
		private boolean _terminateASSAP = false;
		private boolean _ended;

		public InputToOutput(InputStream in, OutputStream out) {
			_in = in;
			_out = out;
			new Thread(this).start();
		}

		public void run() {
			int b;
			try {
				do {
					b = _in.read();
					log("readed:" + b + " -- " + (char) b);
					if (b > 0) {
						_out.write(b);
						_out.flush();
					}
				} while (b != -1 && !_terminateASSAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
			_ended = true;
		}

		public void terminateASSAP() {
			_terminateASSAP = true;

		}

		public void waitFor() {
			while (!_ended) {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

		
	public String call() throws IOException, InterruptedException {
		try {
			ProcessBuilder procB = new ProcessBuilder(_cmd);
			procB.directory( _directory );
			procB.environment().put("LC_ALL", "C" );
			
			
			log("_cmd:" + Arrays.asList(_cmd));
			log("_input:" + _input);

			OutputStream fromProc = new ByteArrayOutputStream();

			procB.redirectErrorStream(true);
			Process proc = procB.start();
			if (!_input.equals("")) {
				proc.getOutputStream().write(_input.getBytes());
				proc.getOutputStream().flush();
			}

			InputToOutput oToI = new InputToOutput(proc.getInputStream(),
					fromProc);
			proc.waitFor();
			oToI.waitFor();

			return fromProc.toString();
		} catch (Throwable t) {
			t.printStackTrace();
			return "***THROWABLE***";
		}
	}

	private final ExecutorService pool = Executors.newFixedThreadPool(10);

	public Future<String> startCall() {
		return pool.submit(this);
	}

	public String call(long millis) {
		Future<String> f = startCall();
		try {
			return f.get(millis, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "***INTERRUPTED***";
		} catch (ExecutionException e) {
			e.printStackTrace();
			return "***ERROR***";
		} catch (TimeoutException e) {
			return "***TIMEOUT***";
		}
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {
		Executor e = new Executor( new File("."), "/usr/lib/jvm/java-7-openjdk-amd64/bin/javac", "");
		String s = e.call(50000);
		System.out.println(s);
		System.exit(0);
	}
}
