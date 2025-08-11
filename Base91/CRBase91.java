import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CRBase91 {
	private static final Logger logger = Logger.getLogger(CRBase91.class.getName());
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		Base91 b91 = new Base91();
		String string = "";
		String base91 = "";
		String decision = "";
		logger.log(Level.INFO, "Hello and welcome to the Base91 Encoder/Decoder. Which do you want to do, encode or decode?");
		decision = k.nextLine();
		if (decision.equalsIgnoreCase("encode")) {
			logger.log(Level.INFO, "Please enter the string you wish to encode in Base91.");
			string = k.nextLine();
			byte[] bstring = string.getBytes();
			int length = string.length();
			byte[] estring = new byte[1048576];
			b91.encode(bstring, length, estring);
			logger.log(Level.INFO, "The Base91 string of that is: \n{0}", estring);
		} else if (decision.equalsIgnoreCase("decode")) {
			logger.log(Level.INFO, "Please enter the Base91 string you wish to decode.");
			base91 = k.nextLine();
			byte[] bstring = base91.getBytes();
			int length = base91.length();
			byte[] basE91 = new byte[1048576];
			b91.decode(bstring, length, basE91);
			logger.log(Level.INFO, "The decoded string of that is: \n{0}", basE91);
		} else {
			logger.log(Level.SEVERE, "Invalid operation.");
		}
		k.close();
		logger.log(Level.INFO, "Now exiting the Base91 Encoder/Decoder...");
	}
}
