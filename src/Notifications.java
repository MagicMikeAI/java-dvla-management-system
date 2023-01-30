import java.util.Map.Entry;

/**
 * The Class Notifications.
 */
public class Notifications {
    
    /** The dvla. */
    DVLA dvla = new DVLA();

    /**
     * Reminder letter, takes in the car number, tax month and name of the keeper
     *
     * @param regNo the reg no
     * @param taxMonth the tax month
     * @param name the name
     */
    public void reminderLetter(RegNo regNo, int taxMonth, String name) {
        System.out.println("------------------------------------------------------------");
        System.out.println("Dear " + name + ",\n\nYour car with registration number " + regNo
                + "\nNeeds to be taxed as it will expire by the " + Main.textColor("end of this Month", "yellow")
                + ".\n\nYours sincerely,\nDVLA");
        System.out.println("============================================================\n");

    }

    /**
     * Warning letter.
     *
     * @param regNo the reg no
     * @param taxMonth the tax month
     * @param name the name
     */
    // warning letter for cars that have the tax expired
    public void warningLetter(RegNo regNo, int taxMonth, String name) {
        System.out.println("------------------------------------------------------------");
        System.out.println("Dear " + name + ",\n\nYour car with registration number " + regNo
                + "\nHas the TAX expired and needs to be " + Main.textColor("renewed Urgently", "red")
                + "!\n\nYours sincerely,\nDVLA");
        System.out.println("============================================================\n");

    }


    /**
     * Show all taxes.
     */
     // function that checks if the tax is expired, if there is no keeper then it will display "No Keeper"
    // if the tax is expired then it will display "Tax Expired"
    // if the tax is not expired then it will display "This Month"
    // Then will create a reminder letter for cars that have the tax expiring this month
    public void showAllTaxes() {
        System.out.println("\n/=====================================================\\");
        System.out.println("|    RegNo    |    Tax Status     |       Owner       |");
        System.out.println("|-------------|-------------------|-------------------|");

        for (Entry<RegNo, Car> entry : DVLA.carMap.entrySet()) {
            // if keeper is null then print out "No Keeper"
            if (DVLA.keeperMap.get(entry.getKey()) == null) {
                System.out.printf("| %-11s | %-17s | %-17s |%n", entry.getKey(), DVLA.isTaxExpired(entry.getKey()),
                        "No Keeper");
            } else {
                System.out.printf("| %-11s | %-17s | %-17s |%n", entry.getKey(), DVLA.isTaxExpired(entry.getKey()),
                        DVLA.keeperMap.get(entry.getKey()).getForeName());
            }
        }
        System.out.println("\\=====================================================/\n");

        // for each with tax that is expired this month, use reminderLetter method to create a reminder letter
        for (Entry<RegNo, Car> entry : DVLA.carMap.entrySet()) { // for each entry in the carMap 
            if (DVLA.isTaxExpired(entry.getKey()).equals(Main.textColor("This Month       ", "yellow"))) { // if the tax is expiring this month then
                reminderLetter(entry.getKey(), entry.getValue().getTaxExpiresEndMonth().getMonthNumber(), // create a reminder letter with the car number, tax month and name of the keeper
                        DVLA.keeperMap.get(entry.getKey()).getForeName()); // get the name of the keeper
            }
        }

        // same as above but for expired tax
        for (Entry<RegNo, Car> entry : DVLA.carMap.entrySet()) { // for each entry in the carMap 
            if (DVLA.isTaxExpired(entry.getKey()).equals(Main.textColor("Tax Expired      ", "red"))) { // if the tax is expired then 
                warningLetter(entry.getKey(), entry.getValue().getTaxExpiresEndMonth().getMonthNumber(), // create a warning letter with the car number, tax month and name of the keeper 
                        DVLA.keeperMap.get(entry.getKey()).getForeName()); // get the name of the keeper
            }
        }
    }

}
