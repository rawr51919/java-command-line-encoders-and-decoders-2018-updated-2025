import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import godlikeblock.util.CRC16;
public class CRCRC16 {
	public static final CRC16 e16 = new CRC16();
    private static final Logger logger = Logger.getLogger(CRCRC16.class.getName());
    public static void main(String[] args) {
        Scanner k = new Scanner(System.in);
        String string = "";
            logger.log(Level.INFO, "Please enter the string you wish to convert into CRC16.");
            string = k.nextLine();
            // encode
            byte[] ebytes = string.getBytes();
			int eint = e16.update(ebytes);
			String estring = String.format("%04X", eint);
            // output
            logger.log(Level.INFO, "The CRC16 string of that is:\n{0}", estring);
        k.close();
        logger.log(Level.INFO, "Now exiting the CRC16 Encoder/Decoder...");
    }
}
