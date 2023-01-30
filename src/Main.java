import java.util.Scanner;
import java.util.TreeMap;

/**
 * The Class Main.
 */
public class Main {
    
    /** The tree map storage. */
    static TreeMap<RegNo, Car> treeMapStorage = new TreeMap<RegNo, Car>();
    
    /**  dvla. */
    static DVLA dvla = new DVLA();
    
    /** The file manager. */
    static FileManager fm = new FileManager();
    
    /** The notification system. */
    static Notifications n = new Notifications();
    
    /** The scanner. */
    static Scanner scanner = new Scanner(System.in);

    /**
     * The main menu method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        DVLA dvla = new DVLA();
        String[] mainMenuOptions = { "Dummy Data", "Data Management", "Test001", "Test002", "Test003", "Test004", "Test005", "Exit" };
        String[] mainMenuDescription = { "Fill with Dummy data", "CRUD & Settings", "Creating HashMap", "HashMap to TreeMap ", "RegNo & Keepers", "Reminder/Warning letters", "Serialisation", "Exit the aplication" };
        String mainMenuSubtitle = "           Welcome to the DVLA Vehicle Management System          Please select an option from the menu below, If you want to   run the Tests please make sure you have added the dummy data";

        int choice = 0;
        do {
            printTable("Main Menu", mainMenuOptions, mainMenuDescription, mainMenuSubtitle);

            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.print("Enter your choice: ");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    dvla.addCar(new RegNo("XK14 OWW"), new Car("Skoda", "Superb MK2", "Silver"));
                    dvla.addCar(new RegNo("BJ22 FKH"), new Car("MG", "ZS EV", "Red"));
                    dvla.addCar(new RegNo("AL10 SXV"), new Car("MB", "A160", "Black"));
                    dvla.addCar(new RegNo("4LL10 ABV"), new Car("MB", "GLS200", "Black"));
                    dvla.addCar(new RegNo("2DK14 OWW"), new Car("Skoda", "Superb", "Silver"));
                    dvla.addCar(new RegNo("1PJ22 FKH"), new Car("MG", "ZS EV", "Red"));
                    dvla.addCar(new RegNo("3LL10 SXV"), new Car("MB", "A160", "Black"));

                    dvla.addKeeper(new RegNo("XK14 OWW"),
                                    new Keeper("John", "Smith", new Address("1 High Street", "London", "E1 1AA")));
                    dvla.addKeeper(new RegNo("2DK14 OWW"),
                                    new Keeper("Jane", "Doe", new Address("2 High Street", "London", "E1 1AA")));
                    dvla.addKeeper(new RegNo("3LL10 SXV"),
                                    new Keeper("John", "Doe", new Address("3 High Street", "London", "E1 1AA")));
                    dvla.addKeeper(new RegNo("BJ22 FKH"),
                                    new Keeper("John", "Smith", new Address("1 High Street", "London", "E1 1AA")));
                    dvla.addKeeper(new RegNo("1PJ22 FKH"),
                                    new Keeper("Jane", "Doe", new Address("2 High Street", "London", "E1 1AA")));

                    dvla.addTax(new RegNo("XK14 OWW"), Month.MAY);
                    dvla.addTax(new RegNo("2DK14 OWW"), Month.JANUARY);
                    dvla.addTax(new RegNo("3LL10 SXV"), Month.FEBRUARY);
                    dvla.addTax(new RegNo("BJ22 FKH"), Month.MAY);
                    dvla.addTax(new RegNo("1PJ22 FKH"), Month.DECEMBER);

                    System.out.println(textColor("\n\nDummy Data added", "green"));
                    printTestTable("Dummy DATA", " Added dummy data into the system to be able to run the tests ");
                    dvla.showAllCars();

                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 2:
                    System.out.println(textColor( "NOTE: If you want to run the Tests please make sure you have added the dummy data and go trough them, then use the prototype MENU for Data Management",  "yellow"));
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    DataManagementMenu();
                    break;

                case 3:
                    printTestTable("Test001",  " Create a class called Test001 to put information for 3 cars   and corresponding registration numbers into the DVLA HashMap,  and then call the `showAllCars` method.                       ");
                    dvla.showAllCars();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 4:
                    printTestTable("Test002"," Create a class called Test002 to convert the HashMap to a TreeMap and verify that the tree traversal is now in sorted order  according to the registration number.                         ");
                    treeMapStorage = (TreeMap<RegNo, Car>) DVLA.convertToTreeMap(DVLA.carMap);
                    DVLA.printTreeMap(treeMapStorage);

                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();

                    break;
                case 5:
                    printTestTable("Test003","  DVLA needs to map the registration numbers to the keepers.    Devise a means of doing this. Create a class called Test003   to list all the registration numbers and keepers.             ");
                    dvla.showAllCarsWithKeepers();

                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();

                    break;
                case 6:
                    printTestTable("Test004","  Create a class called Test004 to test that reminder letters  and warning letters can be sent to the appropriate keepers     on any given month.                                           ");
                    System.out.println("Current Month : " + DVLA.currentMonth);
                    n.showAllTaxes();

                    System.out.println(textColor("You can change the month in DataManagement -> System -> Change Current Month\n", "yellow"));

                    // change currentMonth to month 5 to test, uncomment the following lines
                    // DVLA.currentMonth = 5;
                    // n.showAllTaxes();

                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();

                    break;
                case 7:
                    printTestTable("Test005", "  Write the code to save all the data for the warning and      reminder letters to a flash drive. Write code to read the same data from the flash drive. Create a class called Test005 to    demonstrate the write/read operation.                         ");
                    fm.createFilesReminder();
                    fm.readFiles();

                    System.out.println(textColor( "If you want to read these files, go to the Foler or CLI at: Main Menu -> Data Management -> File Management\n", "yellow"));
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 8:
                    System.out.println("Thank you for using this Program!");
                    break;

                default:
                    System.out.println(textColor("Invalid choice", "red"));
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();

                    break;
            }
        } while (choice != mainMenuOptions.length);

    }

    /**
     * Data management menu.
     */
    public static void DataManagementMenu() {
        String[] dataManagementOptions = { "Car ", "Keeper ", "Reg ", "Tax ", "File ", "System ", "<---Back" };
        String[] dataManagementDescription = { "Add/Remove/Update Cars", "Add/Remove/Update Keepers", "Add/Remove/Update Regs", "Add/Remove/Update Taxes", "Create/Read Files", "Change Current Month", "Back to Main Menu" };
        String subTitle = "           Welcome to the DVLA Vehicle Management System          Please select an option from the menu below, they will allow you to do CRUD operations of the data.                       ";
        int choice = 0;
        do {
            printTable("Data Management", dataManagementOptions, dataManagementDescription, subTitle);

            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.print("Enter your choice: ");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    CarMenu();
                    break;
                case 2:
                    KeeperMenu();
                    break;
                case 3:
                    RegMenu();
                    break;
                case 4:
                    TaxMenu();
                    break;
                case 5:
                    FileMenu();
                    break;
                case 6:
                    SystemMenu();
                    break;
                case 7:
                    break;
                default:
                    System.out.println(textColor("Invalid choice", "red"));
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;
            }
        } while (choice != dataManagementOptions.length);
    }
   
    /**
     * Car menu.
     */
    public static void CarMenu() {
        String[] carOptions = { "Add ", "Remove ", "Update Make", "Update Model", "Update Color", "Show All ", "Show All + Keepers ", "<---Back" };
        String[] carDescription = { "Add a Car", "Remove a Car", "Update Make", "Update Model", "Update Color","All Cars", "All + Keepers", "Back to Data Management" };
        String subTitle = "           Welcome to the DVLA Vehicle Management System          Please select an option from the menu below, they will allow you to do CRUD operations of the data.                       ";
        int choice = 0;

        do {
            printTable("Car", carOptions, carDescription, subTitle);
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                // System.out.println(textColor("Invalid choice", "red"));
                System.out.print("Enter your choice: ");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    // will take user input and add a car to the list of cars
                    System.out.println("Add a Car");
                    System.out.println("Enter the Car's Make: ");
                    String make = scanner.nextLine();
                    System.out.println("Enter the Car's Model: ");
                    String model = scanner.nextLine();
                    System.out.println("Enter the Car's Colour: ");
                    String colour = scanner.nextLine();

                    dvla.addCar(new Car(make, model, colour));
                    System.out.println(textColor("\nCar Added Successfully\n", "green"));

                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 2:
                    System.out.println("Remove a Car");
                    dvla.deleteCar();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("Update Make");
                    dvla.updateCarMarke();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 4:
                    System.out.println("Update Model");
                    dvla.updateCarModel();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 5:
                    System.out.println("Update Color");
                    dvla.updateCarColor();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 6:
                    System.out.println("Show All");
                    dvla.showAllCars();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 7:
                    System.out.println("Show All + Keepers");
                    dvla.showAllCarsWithKeepers();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 8:
                    break;
                default:
                    System.out.println(textColor("Invalid choice", "red"));
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

            }
        } while (choice != carOptions.length);
    }

    /**
     * Keeper menu.
     */
    public static void KeeperMenu() {
        String[] keeperOptions = { "Add ", "Remove ", "Update Name", "Show All ", "<---Back" };
        String[] keeperDescription = { "Add a Keeper", "Remove a Keeper", "Update Name", "All Keepers", "Back to Data Management" };
        String subTitle = "           Welcome to the DVLA Vehicle Management System          Please select an option from the menu below, they will allow you to do CRUD operations of the data.                       ";
        int choice = 0;

        do {
            printTable("Keeper", keeperOptions, keeperDescription, subTitle);
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                // System.out.println(textColor("Invalid choice", "red"));
                System.out.print("Enter your choice: ");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    System.out.println("Add a Keeper");
                    System.out.println("Enter the Keeper's Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Enter the Keeper's ForeName: ");
                    String foreName = scanner.nextLine();
                    System.out.println("Enter the Keeper's Street Address: ");
                    String streetAddress = scanner.nextLine();
                    System.out.println("Enter the Keeper's City: ");
                    String city = scanner.nextLine();
                    System.out.println("Enter the Keeper's Postcode: ");
                    String postcode = scanner.nextLine();
                    dvla.addKeeper(new Keeper(name, foreName, new Address(streetAddress, city, postcode)));

                    System.out.println(textColor("\nKeeper Added Successfully\n", "green"));
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 2:
                    System.out.println("Remove a Keeper");
                    dvla.showAllKeepers();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("Update Name");
                    dvla.updateKeeperFirstName();
                    dvla.updateKeeperLastName();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 4:
                    System.out.println("Show All");
                    dvla.showAllKeepers();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 5:

                    break;
                default:
                    System.out.println(textColor("Invalid choice", "red"));
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

            }
        } while (choice != keeperOptions.length);

    }

    /**
     * Reg menu.
     */
    public static void RegMenu() {
        String[] regOptions = { "Create ", "Attach Reg", "Remove ", "Update RegNo", "Show All ", "<---Back" };
        String[] regDescription = { "Create a RegNo", "Attach RegNo to a Car", "Remove a RegNo", "Update RegNo", "All RegNo", "Back to Data Management" };
        String subTitle = "           Welcome to the DVLA Vehicle Management System          Please select an option from the menu below, they will allow you to do CRUD operations of the data.                       ";
        int choice = 0;

        do {
            printTable("RegNo", regOptions, regDescription, subTitle);
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                // System.out.println(textColor("Invalid choice", "red"));
                System.out.print("Enter your choice: ");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    dvla.addRegNo();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 2:
                    dvla.attachRegNoToCar();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 3:
                    dvla.deleteRegNo();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 4:
                    dvla.updateRegNo();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;


                case 5:
                    // dvla.showAllRegs();
                    dvla.showAllCars();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 6:

                    break;
                default:

                    System.out.println(textColor("Invalid choice", "red"));
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;
            }
        } while (choice != regOptions.length);

    }

    /**
     * Tax menu.
     */
    public static void TaxMenu() {
        String[] taxOptions = { "Remove ", "Update ", "Show All ", "<---Back" };
        String[] taxDescription = { "Remove a Tax", "Update Tax", "All Tax", "Back to Data Management" };
        String subTitle = "           Welcome to the DVLA Vehicle Management System          Please select an option from the menu below, they will allow you to do CRUD operations of the data.                       ";
        int choice = 0;

        do {
            printTable("Tax", taxOptions, taxDescription, subTitle);
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();

            } else {
                // System.out.println(textColor("Invalid choice", "red"));
                System.out.print("Enter your choice: ");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    dvla.deleteTaxExpiresEndMonth();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 2:
                    dvla.updateTaxExpiresEndMonth();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 3:
                    dvla.showAllCarsWithTaxExpiresEndMonth();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 4:

                    break;
                default:

                    System.out.println(textColor("Invalid choice", "red"));
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;
            }
        } while (choice != taxOptions.length);

    }

    /**
     * File menu.
     */
    public static void FileMenu() {
        String[] fileOptions = { "Create Letters ", "Read Letters ", "Read a Letter", "Save ToDisk ", "Delete letter", "Delete All", "<---Back" };
        String[] fileDescription = { "Create Letters", "Read Letters", "Read From Disk", "Save ToDisk", "Delete a letter", "Clear", "Back to Data Management" };
        String subTitle = "           Welcome to the DVLA Vehicle Management System          Please select an option from the menu below, they will allow you to do CRUD operations of the data.                       ";
        int choice = 0;

        do {
            printTable("File", fileOptions, fileDescription, subTitle);
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                // System.out.println(textColor("Invalid choice", "red"));
                System.out.print("Enter your choice: ");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    dvla.showAllCarsWithTaxExpiresEndMonth();
                    fm.createFilesReminder();
                    fm.readFiles();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 2:
                    n.showAllTaxes();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 3:
                    dvla.showAllCarsWithTaxExpiresEndMonth();
                    fm.readFiles();
                    System.out.println(textColor("Enter the INDEX of the file you want to read\n", "yellow"));
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    fm.readFile(number);
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 4:
                    dvla.showAllCarsWithTaxExpiresEndMonth();
                    fm.createFilesReminder();
                    fm.readFiles();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 5:
                    fm.readFiles();
                    System.out.println(textColor("Enter the INDEX of the file you want to delete\n", "yellow"));
                    int numberDelete = scanner.nextInt();
                    scanner.nextLine();
                    fm.deleteFile(numberDelete);
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 6:
                    fm.clearFiles();
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 7:

                    break;
                default:

                    System.out.println(textColor("Invalid choice", "red"));
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;
            }
        } while (choice != fileOptions.length);

    }

    /**
     * System menu.
     */
    public static void SystemMenu() {
        String[] systemOptions = { "Change Month ", "<---Back" };
        String[] systemDescription = { "Change System Month", "Back to Data Management" };
        String subTitle = "           Welcome to the DVLA Vehicle Management System          Please select an option from the menu below, they will allow you to do CRUD operations of the data.                       ";
        int choice = 0;

        do {
            printTable("System", systemOptions, systemDescription, subTitle);
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.print("Enter your choice: ");
                scanner.nextLine();
            }
            switch (choice) {
                case 1:
                    dvla.showAllCarsWithTaxExpiresEndMonth();
                    System.out.println(textColor("Enter the new month\n", "yellow"));
                    int newMonth = scanner.nextInt();
                    scanner.nextLine();
                    DVLA.currentMonth = newMonth;
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;

                case 2:

                    break;
                default:

                    System.out.println(textColor("Invalid choice", "red"));
                    System.out.println(textColor("Press Any key to continue...\n", "blue"));
                    scanner.nextLine();
                    break;
            }
        } while (choice != systemOptions.length);

    }

    /**
     * Prints the table.
     *
     * @param title the title
     * @param options the options
     * @param descriptions the descriptions
     * @param optional the optional
     */
    //Creates a table with the options and descriptions of the menu 
    public static void printTable(String title, String[] options, String[] descriptions, String optional) {
        
        System.out.println("\n ==================================================================");
        System.out.println(titleLimit(title));
        System.out.println("|                                                                  |");
        System.out.println(optionsLimit(optional));
        System.out.println("|                                                                  |");
        System.out.println("|------------------------------------------------------------------|");
        System.out.println("|    No    |          Option        |            Description       |");
        System.out.println("|----------|------------------------|------------------------------|");
        // print the options and descriptions
        for (int i = 0; i < options.length; i++) {
            System.out.printf("|    %1s     |   %-20s |    %-25s |%n", i + 1, options[i], descriptions[i]);
        }
        System.out.println(" ==================================================================");

    }

    /**
     * Prints the test table.
     *
     * @param title the title
     * @param description the description
     */
    // function that is similar with the one above but prints test information eg Headers for Tests 001 - 005
    public static void printTestTable(String title, String description) {
        // print the title
        System.out.println("\n ==================================================================");
        System.out.println("|                                                                  |");
        System.out.println(titleLimit(title));
        System.out.println("|                                                                  |");
        System.out.println(optionsLimit(description));
        System.out.println("|                                                                  |");
        System.out.println(" ==================================================================");

    }

    /**
     * Options limit.
     *
     * @param option the option
     * @return the string
     */
    // function that is used for the Header subtitle of the menu to make sure that it is not more than 63 characters ( it works intermitently, needs some work but does the job for now)
    public static String optionsLimit(String option) {
        String newOption = ""; // new string that will be returned
        int count = 0; //
        for (int i = 0; i < option.length(); i++) { // loop through the string and add the characters to the new string
            if (count < 63) { // if the count is less than 63 then add the character to the string
                newOption += option.charAt(i); // add the character to the string
                count++;
            } else { // if the count is more than 63 then add a new line and add the character to the
                     // string
                newOption += "  |" + "\n| " + option.charAt(i); //
                count = 1;
            }
        }
        // add | at the start and end of the string
        newOption = "| " + newOption + "   |";
        // add spaces at the end of the string
        for (int i = 0; i < 100 - count; i++) {
            newOption += "  ";
        }
        return newOption; // return the string

    }


    /**
     * Title limit.
     *
     * @param title the title
     * @return the string
     */
    // fucntion that takes in a String and returns a string with a limit of 64 for example
    // characters but the string is always in center.
    // if the string is only 30 characters long then it will add 16 spaces at the start and 16 spaces at the end
    // fist check how long the string is and then add the spaces that it needs to be equal
    public static String titleLimit(String title) {
        int titleLenght = title.length();
        String newTitle = "";
        int count = 0;
        // adding the spaces at the start of the string and at the eend
        for (int i = 0; i < 64; i++) { // loop through the string and add the characters to the new string
            if (i < (64 - titleLenght) / 2) { // if the count is less than 63 then add the character to the string
                newTitle += " "; // add the character to the string
            } else if (i >= (64 - titleLenght) / 2 && i < (64 - titleLenght) / 2 + titleLenght) { // if the count is more than 63 then add a new line and
                                                                                                  // add the character to the string
                newTitle += title.charAt(count); // add the character to the string
                count++;
            } else { // if the count is more than 63 then add a new line and add the character to the
                     // string
                newTitle += " ";
            }
        }
        // add | at the start and end of the string
        newTitle = "| " + newTitle + " |";
        return newTitle;
    }

    /**
     * Check input.
     *
     * @param choice the choice
     * @param type the type
     * @return true, if successful
     */
    //function that takes in any input as parameter + desiered input type, if it
    // maches then return the input otherwise return false
    public static boolean checkInput(String choice, String type) {
        switch (type) {
            case "int":
                try {
                    Integer.parseInt(choice);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            case "string":
                try {
                    String.valueOf(choice);
                    return true;
                } catch (NumberFormatException e) {
                    return false;
                }
            case "any":
                return true;
            default:
                return false;
        }
    }

    /**
     * Text color.
     *
     * @param text the text
     * @param color the color
     * @return the string
     */
    // create a function that takes in a string and another string for color and
    // returns the string with the color
    public static String textColor(String text, String color) {
        String newString = "";
        switch (color) {
            case "red":
                newString = "\u001B[31m" + text + "\u001B[0m";
                break;
            case "green":
                newString = "\u001B[32m" + text + "\u001B[0m";
                break;
            case "yellow":
                newString = "\u001B[33m" + text + "\u001B[0m";
                break;
            case "blue":
                newString = "\u001B[34m" + text + "\u001B[0m";
                break;
            case "white":
                newString = "\u001B[37m" + text + "\u001B[0m";
                break;
            default:
                newString = text;
                break;
        }
        return newString;

    }

}
