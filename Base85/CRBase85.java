import java.util.Scanner;
import com.orwell.util.Ascii85;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CRBase85 {
	private static final Logger logger = Logger.getLogger(CRBase85.class.getName());
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		String string = "";
		String base85 = "";
		String decision = "";
		// ask whether you want to encode a string into base85 or decode a base85 back
		// into a string
		logger.log(Level.INFO, "Hello and welcome to the Base85 Encoder/Decoder. Which do you want to do, encode or decode?");
		decision = k.nextLine();
		if (decision.equalsIgnoreCase("encode")) {
			logger.log(Level.INFO, "Please enter the string you wish to convert into Base85/Ascii85."); // time to input our
																									// string to encode
			string = k.nextLine();
			// now we try to encode the string that was entered in the Base85 encoder
			byte[] estring = Ascii85.encode(string.getBytes());
			// and spit it out
			logger.log(Level.INFO, "The Base85 string of that is: \n{0}", estring);
		} else if (decision.equalsIgnoreCase("decode")) {
			logger.log(Level.INFO, "Please enter the Base85 string you wish to convert back into a string."); // inputting
																											// Base85
																											// for
																											// decoding
																											// now
			base85 = k.nextLine();
			// now we decode our Base85 back into a string (or try to, anyway)
			byte[] dstring = Ascii85.decode(base85.getBytes());
			// and spit the string it represents back out
			logger.log(Level.INFO, "The decoded string of the Base85 you input is: \n{0}", dstring);
		} else {
			logger.log(Level.SEVERE, "Invalid operation.");
		}
		k.close();
		logger.log(Level.INFO, "Now exiting the Base85 Encoder/Decoder...");
	}
}
