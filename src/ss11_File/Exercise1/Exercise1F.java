package ss11_File.Exercise1;

import java.io.File;
import java.io.IOException;

public class Exercise1F {
    public static void main(String[] args) throws IOException {
        String oldPath = "src/ss11_File/Exercise1/input.txt";
        String newPath = "src/ss11_File/Exercise1/output.txt";

        File oldFile = new File(oldPath);
        File newFile = new File(newPath);

        if (oldFile.exists()) {
            if (oldFile.renameTo(newFile)) {
                System.out.println("Rename sucessfully " );
            } else {
                System.out.println("Can not rename ");
            }
        } else {
            System.out.println("Not found");
        }    }
}
