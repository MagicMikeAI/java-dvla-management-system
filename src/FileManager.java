import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map.Entry;

/**
 * The Class FileManager.
 */
public class FileManager {

    /** The dvla. */
    // carMap refers to dvla object from DVLA class reffer to it here so we can use it locally
    DVLA dvla = new DVLA();

    /**
     * Creates the folder.
     */
    // a function that creates a new folder within user`s Documents folder named "A4_MihaiCaramizoiu_DVLA"
    public void createFolder() {
        // create a new folder named "A4_MihaiCaramizoiu_DVLA" within user`s Documents folder but take the user`s name from the system
        File folder = new File(System.getProperty("user.home") + "/Documents/A4_MihaiCaramizoiu_DVLA");
        folder.mkdir();
    }

    /**
     * Creates the folder.
     *
     * @param location the location
     */
    // Takes the location as parameter, usefull within Menu settings (Not yet implemented)
    public void createFolder(String location) {

        File folder = new File(location + "/A4_MihaiCaramizoiu_DVLA");
        folder.mkdir();
    }

    /**
     * Check if folder exists.
     */
    // a function that checks if the folder exists, if not, create it and if it does, print a message to the user
    public void checkIfFolderExists() {
        System.out.println("\nChecking if the folder exists...\n");
        if (!Files.exists(Paths.get(System.getProperty("user.home") + "/Documents/A4_MihaiCaramizoiu_DVLA"))) {
            createFolder();
            // Output a message to the user
            System.out.println("Folder created successfully!\n");
        }
        // if the folder exists, then create the files
        else if (Files.exists(Paths.get(System.getProperty("user.home") + "/Documents/A4_MihaiCaramizoiu_DVLA"))) {
            // Output a message to the user
            System.out.println("Folder already exists!\n");
        }
    }

    /**
     * Creates the files reminder.
     */
    // for each car that has the tax expired, create a file with the car number and  the name of the keeper
    public void createFilesReminder() {
        checkIfFolderExists();

        // for each car that has the tax expired, create a file with the car number and
        // the name of the keeper, use the reminderLetter function to save the text
        // within the file
        for (Entry<RegNo, Car> entry : DVLA.carMap.entrySet()) {
            if (DVLA.isTaxExpired(entry.getKey()).equals(Main.textColor("This Month       ", "yellow"))) {
                File file = new File(System.getProperty("user.home") + "/Documents/A4_MihaiCaramizoiu_DVLA/REMINDER_"
                        + entry.getKey() + "_" + DVLA.keeperMap.get(entry.getKey()).getForeName() + ".txt");
                try {
                    try (// write a simple text for testing
                            FileWriter fw = new FileWriter(file)) {
                        fw.write("Dear " + DVLA.keeperMap.get(entry.getKey()).getForeName()
                                + ",\n\nYour car with registration number " + entry.getKey()
                                + "\nHas the TAX expiring this month and needs to be renewed Urgently!\n\nYours sincerely,\nDVLA");
                    }
                    System.out.println("Reminder Letter created successfully!\n");
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("File already exists!\n");
                }
            }
            if (DVLA.isTaxExpired(entry.getKey()).equals(Main.textColor("Tax Expired      ", "red"))) {
                // create a new file with the car number and the name of the keeper
                File file = new File(System.getProperty("user.home") + "/Documents/A4_MihaiCaramizoiu_DVLA/WARNING_"
                        + entry.getKey() + "_" + DVLA.keeperMap.get(entry.getKey()).getForeName() + ".txt");
                try {
                    // create the file
                    file.createNewFile(); // if file already exists will do nothing
                    // write the text within the file, use something different than filewritter
                    FileWriter fw = new FileWriter(file);
                    fw.write("Dear " + DVLA.keeperMap.get(entry.getKey()).getForeName()
                            + ",\n\nYour car with registration number " + entry.getKey()
                            + "\nHas the TAX expired and needs to be renewed Urgently!\n\nYours sincerely,\nDVLA");
                    fw.close();
                    System.out.println("Warning Letter created successfully!\n");

                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("File already exists!\n");
                }
            }
            // if all are valid or no tax)
            else if (DVLA.isTaxExpired(entry.getKey()).equals("Valid")
                    || DVLA.isTaxExpired(entry.getKey()).equals("No Tax")) {
                System.out.println("No letters created!\n");
            }

        }
        System.out.println(
                "Location of the Files: " + System.getProperty("user.home") + "/Documents/A4_MihaiCaramizoiu_DVLA");

    }

    /**
     * Read files.
     */
    // function that reads the files within that folder
    public void readFiles() {
        System.out.println("\nFiles within the folder:\n");
        File folder = new File(System.getProperty("user.home") + "/Documents/A4_MihaiCaramizoiu_DVLA");
        // create a new array of files and store the files within the folder
        File[] listOfFiles = folder.listFiles();
        // for each file within the folder, print the name of the file
        // print the name of the file, starting with numerotation 1 to n
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println((i + 1) + ". " + listOfFiles[i].getName());

            }
        }
        System.out.println("");

    }

    /**
     * Read file.
     *
     * @param number the number
     */
    // function that takes a number as parameter and outputs in console the file
    // from that folder based on the number given -1 because the numerotation starts from 0
    public void readFile(int number) {
        File folder = new File(System.getProperty("user.home") + "/Documents/A4_MihaiCaramizoiu_DVLA");
        // create a new array of files and store the files within the folder
        File[] listOfFiles = folder.listFiles();
        // for each file within the folder, print the name of the file
        // print the name of the file, starting with numerotation 1 to n
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (i == number - 1) {
                    System.out.println("\nFile " + listOfFiles[i].getName() + " contains:\n");
                    try {
                        // read the file and print it in console
                        BufferedReader br = new BufferedReader(new FileReader(listOfFiles[i]));
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Delete file.
     *
     * @param number the number
     */
    // function that takes a number as parameter and deletes the file from that folder
    //  based on the number given -1 because the numerotation starts from 0
    public void deleteFile(int number) {
        File folder = new File(System.getProperty("user.home") + "/Documents/A4_MihaiCaramizoiu_DVLA");
        // create a new array of files and store the files within the folder
        File[] listOfFiles = folder.listFiles();
        // for each file within the folder, print the name of the file
        // print the name of the file, starting with numerotation 1 to n
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                if (i == number - 1) {
                    // delete the file
                    listOfFiles[i].delete();
                    System.out.println("File " + listOfFiles[i].getName() + " deleted successfully!\n");
                }
            }
        }
        System.out.println("Files remaining in the folder:\n");
        readFiles();
        System.out.println("");
    }

    /**
     * Clear files.
     */
    // function that clears all files within the respective folder
    public void clearFiles() {
        File folder = new File(System.getProperty("user.home") + "/Documents/A4_MihaiCaramizoiu_DVLA");
        // create a new array of files and store the files within the folder
        File[] listOfFiles = folder.listFiles();
        // for each file within the folder, print the name of the file

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                // delete the file
                listOfFiles[i].delete();
                System.out.println("File " + listOfFiles[i].getName() + " deleted successfully!\n");
            }

        }
        System.out.println("All files have been Cleared\n");

    }

}
