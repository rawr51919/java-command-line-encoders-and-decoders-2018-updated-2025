import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.geronimo.mail.util.UUEncode;
public class CRUUEncode {
	private static final Logger logger = Logger.getLogger(CRUUEncode.class.getName());
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		String string = "";
		logger.log(Level.INFO, "Please enter the string you wish to convert into UUEncode."); // time to input our string to
																							// encode
		string = k.nextLine();
		// now we try to encode the string that was entered in the UUEncode encoder
		byte[] estring = UUEncode.encode(string.getBytes(), 0, string.getBytes().length - 1);
		// and spit it out
		logger.log(Level.INFO, "The UUEncode string of that is: \n{0}", estring);
		k.close();
		logger.log(Level.INFO, "Now exiting the UUEncode Encoder/Decoder...");
	}
}
