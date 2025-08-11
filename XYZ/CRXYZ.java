import java.util.Scanner;
import com.xyz.XYZMessageDigest;
import jcifs.util.Hexdump;
public class CRXYZ {
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		XYZMessageDigest exyz = new XYZMessageDigest();
		String data = "";
		String xyzstring = "";
		String decision = "";
		do {
			System.out.print("Hello and welcome to the XYZ Hasher. What string do you want to hash today?");
			data = k.nextLine();
			byte[] inputbytes = data.getBytes();
			exyz.engineUpdate(inputbytes, 0, inputbytes.length);
			byte[] xyzbytes = exyz.engineDigest();
			xyzstring = new String(Hexdump.toHexString(xyzbytes, 0, xyzbytes.length * 2));
			System.out.println("The XYZ hash of the string you entered was: " + new String(xyzstring));
			System.out.println("Do you want to hash another string? (y/n)");
		} while (decision.equalsIgnoreCase("y"));
		System.out.println("Exiting the XYZ Hasher...");
		k.close();
	}
}
