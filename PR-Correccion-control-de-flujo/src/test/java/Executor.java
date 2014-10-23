import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Executor implements Callable<String> {

	private static void log( String s ){
		System.out.println( "log:" + s );
	}
	
	private String _cmd;
	private String _input;

	public Executor(String cmd, String input) {
		_cmd = cmd;
		_input = input;
	}

	private static class InputToOutput implements Runnable{
		private InputStream _in;
		private OutputStream _out;
		private boolean _terminateASSAP = false;
		private boolean _dolog;
		private boolean _ended;

		public InputToOutput(InputStream in, OutputStream out, boolean dolog ) {
			_in = in;
			_out = out;
			_dolog = dolog;
			new Thread(this).start();
		}

		public void run() {
			int b;
			try {
				do{
					b = _in.read();
					if( b > 0 ){
						_out.write(b);
						_out.flush();
					}
				}
				while( b != -1 && !_terminateASSAP);
			} catch (IOException e) {
				e.printStackTrace();
			}
			_ended = true;
		}

		public void terminateASSAP() {
			_terminateASSAP = true;
			
		}
		
		public void waitFor(){
			while( !_ended ){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public String call() throws IOException, InterruptedException{
		ProcessBuilder procB = new ProcessBuilder(_cmd);
		
		OutputStream fromProc = new ByteArrayOutputStream();
		
		Process proc = procB.start();
		proc.getOutputStream().write( _input.getBytes() );
		proc.getOutputStream().flush();
		
		InputToOutput oToI = new InputToOutput(proc.getInputStream(), fromProc,true );
		proc.waitFor();
		oToI.waitFor();
		
		return fromProc.toString();
	}

	private final ExecutorService pool = Executors.newFixedThreadPool(10);
	 
	public Future<String> startCall(){
	    return pool.submit(this);
	}
	
	public String call( long millis ){
		Future<String> f = startCall();
		try {
			return f.get(millis, TimeUnit.MILLISECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			return "***TIMEOUT***";
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		Executor e = new Executor( "/bin/bash", "ls\nman ls\nexi\n" );
		String s = e.call(5000);
		System.out.println( s );
		System.exit(0);
	}
}
