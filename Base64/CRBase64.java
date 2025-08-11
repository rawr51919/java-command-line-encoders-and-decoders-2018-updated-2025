import java.util.Base64;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class CRBase64 {
    private static final Logger logger = Logger.getLogger(CRBase64.class.getName());
    public static void main(String[] args) {
        try (Scanner k = new Scanner(System.in)) {
            logger.log(Level.INFO,
                    "Hello and welcome to the Base64 Encoder/Decoder. Which do you want to do, encode or decode?");
            String decision = k.nextLine();

            if (decision.equalsIgnoreCase("encode")) {
                handleEncode(k);
            } else if (decision.equalsIgnoreCase("decode")) {
                handleDecode(k);
            } else {
                logger.log(Level.SEVERE, "Invalid operation.");
            }

            logger.log(Level.INFO, "Now exiting the Base64 Encoder/Decoder...");
        }
    }
    private static void handleEncode(Scanner k) {
        logger.log(Level.INFO, "Which encoder do you want to use?");
        String choice = k.nextLine();

        switch (choice.toLowerCase()) {
            case "basic":
                logger.log(Level.INFO, "Please enter the string you wish to convert into Basic Base64.");
                logEncoded(Base64.getEncoder().encode(k.nextLine().getBytes()), "Basic Base64");
                break;

            case "url and filename safe":
                logger.log(Level.INFO, "Please enter the string you wish to convert into URL/Filename safe Base64.");
                logEncoded(Base64.getUrlEncoder().encode(k.nextLine().getBytes()), "URL/Filename safe Base64");
                break;

            case "mime":
                logger.log(Level.INFO, "Please enter the string you wish to convert into MIME Base64.");
                logEncoded(Base64.getMimeEncoder().encode(k.nextLine().getBytes()), "MIME Base64");
                break;

            default:
                logger.log(Level.SEVERE, "Invalid encoder type.");
        }
    }
    private static void handleDecode(Scanner k) {
        logger.log(Level.INFO, "Which decoder do you want to use?");
        String choice = k.nextLine();

        switch (choice.toLowerCase()) {
            case "basic":
                logger.log(Level.INFO,
                        "Please enter the Basic Base64 string you wish to convert back into a string.");
                logDecoded(Base64.getDecoder().decode(k.nextLine()), "Basic Base64");
                break;

            case "url and filename safe":
                logger.log(Level.INFO,
                        "Please enter the URL/Filename safe Base64 string you wish to convert back into a string.");
                logDecoded(Base64.getUrlDecoder().decode(k.nextLine()), "URL/Filename safe Base64");
                break;

            case "mime":
                logger.log(Level.INFO,
                        "Please enter the MIME Base64 string you wish to convert back into a string.");
                logDecoded(Base64.getMimeDecoder().decode(k.nextLine()), "MIME Base64");
                break;

            default:
                logger.log(Level.SEVERE, "Invalid decoder type.");
        }
    }
    private static void logEncoded(byte[] encoded, String type) {
        logger.log(Level.INFO, "The {0} string of that is: \n{1}",
                new Object[]{type, new String(encoded)});
    }
    private static void logDecoded(byte[] decoded, String type) {
        logger.log(Level.INFO, "The decoded string of the {0} you input is: \n{1}",
                new Object[]{type, new String(decoded)});
    }
}
