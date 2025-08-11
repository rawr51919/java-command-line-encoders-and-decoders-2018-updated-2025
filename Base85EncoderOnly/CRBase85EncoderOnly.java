import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CRBase85EncoderOnly {
	private static final Logger logger = Logger.getLogger(CRBase85EncoderOnly.class.getName());
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		String string = "";
		logger.log(Level.INFO, "Hello and welcome to the Base85/Ascii85 Encoder.");
		logger.log(Level.INFO, "Please enter the string you wish to convert into Base85/Ascii85."); // time to input our
																								// string to encode
		string = k.nextLine();
		// now we try to encode the string that was entered in the Base85/Ascii85
		// encoder
		String estring = Ascii85.encode(string);
		// and spit it out
		logger.log(Level.INFO, "The Base85/Ascii85 string of that is: \n{0}", estring);
		k.close();
		logger.log(Level.INFO, "Now exiting the Base85/Ascii85 Encoder...");
	}
}
