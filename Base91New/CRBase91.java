import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import de.bwaldvogel.base91.Base91;
public class CRBase91 {
	private static final Logger logger = Logger.getLogger(CRBase91.class.getName());
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		String string = "";
		String base91 = "";
		String decision = "";
		// ask whether you want to encode a string into base91 or decode a base91 back
		// into a string
		logger.log(Level.INFO, "Hello and welcome to the Base91 Encoder/Decoder. Which do you want to do, encode or decode?");
		decision = k.nextLine();
		if (decision.equalsIgnoreCase("encode")) {
			logger.log(Level.INFO, "Please enter the string you wish to convert into Base91."); // time to input our string
																							// to encode
			string = k.nextLine();
			// now we try to encode the string that was entered in the Base91 encoder
			byte[] estring = Base91.encode(string.getBytes());
			// and spit it out
			logger.log(Level.INFO, "The Base91 string of that is: \n{0}", estring);
		} else if (decision.equalsIgnoreCase("decode")) {
			logger.log(Level.INFO, "Please enter the Base91 string you wish to convert back into a string."); // inputting
																											// Base91
																											// for
																											// decoding
																											// now
			base91 = k.nextLine();
			// now we decode our Base91 back into a string (or try to, anyway)
			byte[] dstring = Base91.decode(base91.getBytes());
			// and spit the string it represents back out
			logger.log(Level.INFO, "The decoded string of the Base91 you input is: \n{0}", dstring);
		} else {
			logger.log(Level.SEVERE, "Invalid operation.");
		}
		k.close();
		logger.log(Level.INFO, "Now exiting the Base91 Encoder/Decoder...");
	}
}
