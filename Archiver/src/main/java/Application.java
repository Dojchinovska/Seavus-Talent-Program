import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws IOException, InvalidInputException {

        System.out.println("Specify a compression algorithm, zip or 7zip:");
        String specification = new Scanner(System.in).nextLine().toLowerCase();
        File directory = new File("files");

        Archiver archiver = null;

        if (specification.equals("zip")) {
            archiver = new ZipArchiver();
        } else if (specification.equals("7zip")) {
            archiver = new SevenZip();
            specification = "7z";
        } else {
            throw new InvalidInputException("Invalid input");
        }
        archiver.archive(directory, new File("archive." + specification));
    }
}
