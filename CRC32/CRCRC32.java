import java.util.Scanner;
import java.util.zip.CRC32;
import java.util.logging.Level;
import java.util.logging.Logger;
public final class CRCRC32 {
    private static final Logger logger = Logger.getLogger(CRCRC32.class.getName());
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        CRC32 e32 = new CRC32();
        String decision = "";
        do {
            logger.info("Enter the string you wish to calculate the CRC32 of: ");
            String string = k.nextLine();
            e32.update(string.getBytes());
            long crc32long = e32.getValue();
            String crc32string = Long.toHexString(crc32long).toUpperCase();
            if (crc32long < 0x10000000 /* the first number to not have a leading 0 */)
                crc32string = "0" + crc32string;
			logger.log(Level.INFO, "The CRC32 hash of the string you input is: {0}", crc32string);
            logger.info("Want to calculate another string's hash? (y/n)");
            decision = k.next();
            k.nextLine();
        } while (decision.equalsIgnoreCase("y"));
        logger.info("Exiting the CRC32 hasher...");
        k.close();
    }
}
