import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessTest {

    public static void main(String[] args) {
        Process process = null;
        
        try
        {
            process = new ProcessBuilder("java", "-version").start();
        } catch (IOException ex) {
            Logger.getLogger(ProcessTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        OutputStream process_out_stream = process.getOutputStream ();
        InputStream process_error_stream = process.getErrorStream ();
        InputStream process_in_stream = process.getInputStream ();
        
        BufferedReader process_in_buffer = new BufferedReader (new InputStreamReader(process_in_stream));
        BufferedReader process_error_buffer = new BufferedReader (new InputStreamReader(process_error_stream));

        String input_line = "";
        
        try {
            while ((input_line = process_error_buffer.readLine()) != null)
            {
                System.out.println (input_line);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProcessTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            while ((input_line = process_in_buffer.readLine()) != null)
            {
                System.out.println (input_line);
            }
        } catch (IOException ex) {
            Logger.getLogger(ProcessTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
