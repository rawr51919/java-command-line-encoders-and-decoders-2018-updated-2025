import java.util.Scanner;
import java.util.zip.Adler32;
import java.util.logging.Level;
import java.util.logging.Logger;
public final class CRAdler32 {
    private static final Logger logger = Logger.getLogger(CRAdler32.class.getName());
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        Adler32 ae32 = new Adler32();
        String decision = "";
        do {
            logger.info("Enter the string you wish to calculate the Adler-32 of: ");
            String string = k.nextLine();
            ae32.update(string.getBytes());
            long adler32long = ae32.getValue();
            String adler32string = Long.toHexString(adler32long).toUpperCase();
            if (adler32long < 0x10000000 /* the first number to not have a leading 0 */)
                adler32string = "0" + adler32string;
            logger.log(Level.INFO, "The Adler-32 hash of the string you input is: {0}", adler32string);
            logger.info("Want to calculate another string's hash? (y/n)");
            decision = k.next();
            k.nextLine();
        } while (decision.equalsIgnoreCase("y"));
        logger.info("Exiting the Adler-32 hasher...");
        k.close();
    }
}
