import java.util.Scanner;
import jcifs.util.Hexdump;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.xyz.XYZMessageDigest;
public class CRXYZ {
	private static final Logger logger = Logger.getLogger(CRXYZ.class.getName());
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		XYZMessageDigest exyz = new XYZMessageDigest();
		String data = "";
		String xyzstring = "";
		String decision = "";
		do {
			logger.log(Level.INFO, "Hello and welcome to the XYZ Hasher. What string do you want to hash today?");
			data = k.nextLine();
			byte[] inputbytes = data.getBytes();
			exyz.engineUpdate(inputbytes, 0, inputbytes.length);
			byte[] xyzbytes = exyz.engineDigest();
			xyzstring = Hexdump.toHexString(xyzbytes, 0, xyzbytes.length * 2);
			logger.log(Level.INFO, "The XYZ hash of the string you entered was: {0}", xyzstring);
			logger.log(Level.INFO, "Do you want to hash another string? (y/n)");
		} while (decision.equalsIgnoreCase("y"));
		logger.log(Level.INFO, "Exiting the XYZ Hasher...");
		k.close();
	}
}
