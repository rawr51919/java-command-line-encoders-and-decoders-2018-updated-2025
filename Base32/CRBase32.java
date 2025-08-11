import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base32;
public class CRBase32 {
	private static final Logger logger = Logger.getLogger(CRBase32.class.getName());
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Base32 b32 = new Base32();
		logger.info("Hello and welcome to the Base32 Encoder/Decoder. Which do you want to do, encode or decode?");
		String decision = k.nextLine();
		if (decision.equalsIgnoreCase("encode")) {
			logger.info("Please enter the string you wish to convert into Base32.");
			String string = k.nextLine();
			byte[] estring = b32.encode(string.getBytes());
			logger.log(Level.INFO, "The Base32 string of that is:\n{0}", new String(estring));
		} else if (decision.equalsIgnoreCase("decode")) {
			logger.info("Please enter the Base32 string you wish to convert back into a string.");
			String base32 = k.nextLine();
			byte[] dstring = b32.decode(base32.getBytes());
			logger.log(Level.INFO, "The decoded string of the Base32 you input is:\n{0}", new String(dstring));
		} else {
			logger.severe("Invalid operation.");
		}
		k.close();
		logger.info("Now exiting the Base32 Encoder/Decoder...");
	}
}
