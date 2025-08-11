import jcifs.util.MD4;
import jcifs.util.Hexdump;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public final class CRMD4 {
    private static final Logger logger = Logger.getLogger(CRMD4.class.getName());
	public static final void main(String[] args) {
		MD4 e4 = new MD4();
		Scanner k = new Scanner(System.in);
		String input = "";
		String md4hash = "";
		String decision = "";
		do {
			logger.log(Level.INFO, "Hello and welcome to the MD4 Hasher. What string do you want to hash today?");
			input = k.nextLine();
			byte[] inputbytes = input.getBytes();
			e4.engineUpdate(inputbytes, 0, inputbytes.length);
			byte[] md4bytes = e4.engineDigest();
			md4hash = Hexdump.toHexString(md4bytes, 0, md4bytes.length * 2);
			logger.log(Level.INFO, "The MD4 hash of the string you input is {0}", md4hash);
			logger.log(Level.INFO, "Do you want to hash another string? (y/n)");
			decision = k.next();
			k.nextLine();
		} while (decision.equalsIgnoreCase("y"));
		logger.log(Level.INFO, "Exiting the MD4 Hasher...");
		k.close();
	}
}
