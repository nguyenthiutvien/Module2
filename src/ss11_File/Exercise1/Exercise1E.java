package ss11_File.Exercise1;

import java.io.File;

public class Exercise1E {
    public static void main(String[] args) {
        String path = "src/ss11_File/Exercise1/input.txt";
        File fileToDelete = new File(path);
        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                System.out.println("Delete sucessfully: " + path);
            } else {
                System.out.println("Can not delete: "+ path);
            }
        } else {
            System.out.println("Not found");
        }
    }
}
