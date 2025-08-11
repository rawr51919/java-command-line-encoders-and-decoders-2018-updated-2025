import rawr.util.Base93;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CRBase93 {
	private static final Logger logger = Logger.getLogger(CRBase93.class.getName());
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		String string = "";
		String base93 = "";
		String decision = "";
		// ask whether you want to encode a string into base93 or decode a base93 back
		// into a string
		logger.log(Level.INFO, "Hello and welcome to the Base93 Encoder/Decoder. Which do you want to do, encode or decode?");
		decision = k.nextLine();
		if (decision.equalsIgnoreCase("encode")) {
			logger.log(Level.INFO, "Please enter the string you wish to convert into Base93."); // time to input our string
																							// to encode
			string = k.nextLine();
			// now we try to encode the string that was entered in the Base93 encoder
			byte[] estring = Base93.encode(string.getBytes());
			// and spit it out
			logger.log(Level.INFO, "The Base93 string of that is: \n{0}", estring);
		} else if (decision.equalsIgnoreCase("decode")) {
			logger.log(Level.INFO, "Please enter the Base93 string you wish to convert back into a string."); // inputting
																											// Base93
																											// for
																											// decoding
																											// now
			base93 = k.nextLine();
			// now we decode our Base93 back into a string (or try to, anyway)
			byte[] dstring = Base93.decode(base93.getBytes());
			// and spit the string it represents back out
			logger.log(Level.INFO, "The decoded string of the Base93 you input is: \n{0}", dstring);
		} else {
			logger.log(Level.SEVERE, "Invalid operation.");
		}
		k.close();
		logger.log(Level.INFO, "Now exiting the Base93 Encoder/Decoder...");
	}
}
