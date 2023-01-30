import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.Scanner;

/**
 * The Class DVLA.
 */
public class DVLA {
    
    /** The car map. */
    // Map to store regNo as key and car as value
    static HashMap<RegNo, Car> carMap = new HashMap<>();
    
    /** The keeper map. */
    // Map to store regNo as key and keeper as value
    static HashMap<RegNo, Keeper> keeperMap = new HashMap<>();


    /** The current month. */
    public static int currentMonth = LocalDate.now().getMonthValue(); // this will return the current month as an integer

    /**
     * Adds the car.
     *
     * @param car the car
     */
    public void addCar(Car car) {
        // add it without a regNo and without a keeper, for registration just add a blank regNo
        // usually it`s used within dealerships on new cars
        carMap.put(new RegNo("N/A"), car);
    }

    /**
     * Adds the car.
     *
     * @param regNo the reg no
     * @param car the car
     */
    // add car with regNo and without a keeper
    public void addCar(RegNo regNo, Car car) {
        carMap.put(regNo, car);
    }

    /**
     * Adds the car.
     *
     * @param regNo the reg no
     * @param car the car
     * @param keeper the keeper
     */
    // add car with regNo and with a keeper
    public void addCar(RegNo regNo, Car car, Keeper keeper) {
        carMap.put(regNo, car);
        keeperMap.put(regNo, keeper);
    }

    /**
     * Adds the car safe mode, checks if the car already exists.
     *
     * @param regNo the reg no
     * @param car the car
     */
    // add car with regNo and with a keeper
    public void addCarSafe(RegNo regNo, Car car) {
        if (DVLA.carMap.containsKey(regNo)) {
            System.out.println("The car with the registration number " + regNo + " already exists.");
        } else {
            DVLA.carMap.put(regNo, car);
        }
    }

    /**
     * Adds the car safe mode, checks if the car already exists and adds a keeper as well.
     *
     * @param regNo the reg no
     * @param car the car
     * @param keeper the keeper
     */
    // add car with regNo and with a keeper
    public void addCarSafe(RegNo regNo, Car car, Keeper keeper) {
        if (DVLA.carMap.containsKey(regNo)) {
            System.out.println("The car with the registration number " + regNo + " already exists.");
        } else {
            DVLA.carMap.put(regNo, car);
            DVLA.keeperMap.put(regNo, keeper);
        }
    }

    /**
     * Adds the keeper.
     *
     * @param regNo the reg no
     * @param keeper the keeper
     */
    // add car with regNo and with a keeper
    public void addKeeper(RegNo regNo, Keeper keeper) {
        keeperMap.put(regNo, keeper);
    }

    /**
     * Adds the keeper.
     *
     * @param keeper the keeper
     */
    // add keeper without a regNo
    public void addKeeper(Keeper keeper) {
        keeperMap.put(new RegNo("N/A"), keeper);
    }

    /**
     * Adds the tax.
     *
     * @param regNo the reg no
     * @param tax the tax
     */
    // add tax to a car
    public void addTax(RegNo regNo, Month tax) {
        carMap.get(regNo).setTax(tax);
    }

    /**
     * Removes the car.
     *
     * @param regNo the reg no
     */
    // add tax to a car
    public void removeCar(RegNo regNo) {
        carMap.remove(regNo);
    }

    /**
     * Removes the car.
     */
    //remove car 
    public void removeCar() {
        // List all cars in the carMap
        carMap.entrySet().stream().collect(Collectors.toList()).forEach((car) -> {
            System.out.println(
                    carMap.entrySet().stream().collect(Collectors.toList()).indexOf(car) + " " + car.getValue());
        });
        // ask the user to input the index of the car they want to remove
        System.out.println("Please enter the index of the car you want to remove");
        try (Scanner scanner = new Scanner(System.in)) {
            int index = scanner.nextInt();
            // remove the car from the carMap by index
            // if statement to not go out of bounds
            if (index > carMap.size() - 1) {
                System.out.println("Index out of bounds");
            } else {
                carMap.remove(carMap.entrySet().stream().collect(Collectors.toList()).get(index).getKey());
                // print the car that was removed
                System.out.println("Car removed: "
                        + carMap.entrySet().stream().collect(Collectors.toList()).get(index).getValue());
            }
        }

    }

    /**
     * Removes the tax.
     *
     * @param regNo the reg no
     */
    //removeTax
    public void removeTax(RegNo regNo) {
        carMap.get(regNo).setTaxExpiresEndMonth(null);
    }

    /**
     * Update car.
     *
     * @param regNo the reg no
     * @param car the car
     */
    //updateCar 
    public void updateCar(RegNo regNo, Car car) {
        carMap.replace(regNo, car);
    }

    /**
     * Update keeper.
     *
     * @param regNo the reg no
     * @param keeper the keeper
     */
    //updateKeeper
    public void updateKeeper(RegNo regNo, Keeper keeper) {
        keeperMap.replace(regNo, keeper);
    }

    /**
     * Update tax.
     *
     * @param regNo the reg no
     * @param tax the tax
     */
    //updateTax
    public void updateTax(RegNo regNo, Month tax) {
        carMap.get(regNo).setTax(tax);
    }

    /**
     * Gets the tax.
     *
     * @param regNo the reg no
     * @return the tax
     */
    //get tax by regNo
    public void getTax(RegNo regNo) {
        System.out.println(carMap.get(regNo).getTaxExpiresEndMonth());
    }

    /**
     * Show all cars.
     */
    //show all cars
    public void showAllCars() {
        System.out.println("\n====================================================|");
        System.out.println("   RegNo  |    Make    |    Model    |    Colour    |");
        System.out.println("----------|------------|-------------|--------------|");
        // if make is null, print N/A instead, else print all the cars in the carMap
        carMap.forEach((regNo, car) -> {
            if (car == null) {
                System.out.printf("%-9s | %-10s | %-11s | %-12s |%n", regNo, "N/A", "N/A", "N/A");
            } else {
                System.out.printf("%-9s | %-10s | %-11s | %-12s |%n", regNo, car.getMake(), car.getModel(), car.getColour());
            }
        });
        System.out.println("====================================================|\n");

    }

    /**
     * Show all keepers.
     */
    //show all keepers
    public void showAllKeepers() {
        for (Entry<RegNo, Keeper> entry : keeperMap.entrySet()) {
            System.out.printf("| %-10s | %-13s |  %-10s | %-10s |%n", entry.getValue().getForeName(),
                    entry.getValue().getAddress().getStreet(), entry.getValue().getAddress().getTown(),
                    entry.getValue().getAddress().getPostcode());
        }
    }

    /**
     * Prints the tree map.
     *
     * @param treeMapStorage the tree map storage
     */
    public static void printTreeMap(TreeMap<RegNo, Car> treeMapStorage) {
        System.out.println("\n=====================================================|");
        System.out.println("   RegNo   |    Make    |    Model    |    Colour    |");
        System.out.println("-----------|------------|-------------|--------------|");
        for (Entry<RegNo, Car> entry : treeMapStorage.entrySet()) {
            System.out.printf(" %-9s | %-10s | %-11s | %-12s |%n", entry.getKey(), entry.getValue().getMake(),
                    entry.getValue().getModel(), entry.getValue().getColour());
        }
        System.out.println("=====================================================|\n");

    }

    /**
     * Show all cars with keepers.
     */
    // prints out all cars with their registration numbers and keeper details
    public void showAllCarsWithKeepers() {
        System.out.println("\n========================================================================|");
        System.out.println("   RegNo   |    Make    |    Model    |    Colour    |    Keeper Name   |");
        System.out.println("-----------|------------|-------------|--------------|------------------|");

        carMap.forEach((regNo, car) -> {
            if (car == null) {
                System.out.printf(" %-9s | %-10s | %-11s | %-12s | %-16s |%n", regNo, "N/A", "N/A", "N/A", "N/A");
            } else if (regNo == null) {
                System.out.printf(" %-9s | %-10s | %-11s | %-12s | %-16s |%n", "N/A", car.getMake(), car.getModel(),
                        car.getColour(), "N/A");
            } else if (keeperMap.get(regNo) == null) {
                System.out.printf(" %-9s | %-10s | %-11s | %-12s | %-16s |%n", regNo, car.getMake(), car.getModel(),
                        car.getColour(), "N/A");
            } else {
                System.out.printf(" %-9s | %-10s | %-11s | %-12s | %-16s |%n", regNo, car.getMake(), car.getModel(),
                        car.getColour(), keeperMap.get(regNo).getForeName());
            }
        });
        System.out.println("========================================================================|\n");
    }

    /**
     * Checks if is tax expired.
     *
     * @param regNo the reg no
     * @return the string
     */
    public static String isTaxExpired(RegNo regNo) {
        if (carMap.get(regNo).getTaxExpiresEndMonth().getMonthNumber() < currentMonth && carMap.get(regNo).getTaxExpiresEndMonth().getMonthNumber() != 0) {
            return Main.textColor("Tax Expired      ", "red");

        } else if (carMap.get(regNo).getTaxExpiresEndMonth().getMonthNumber() == currentMonth) {
            return Main.textColor("This Month       ", "yellow");

        } else if (carMap.get(regNo).getTaxExpiresEndMonth().getMonthNumber() > currentMonth) {
            return Main.textColor("Valid            ", "green");
            
        } else if (carMap.get(regNo).getTaxExpiresEndMonth() == null || carMap.get(regNo).getTaxExpiresEndMonth().getMonthNumber() == 0) {
            return Main.textColor("No Tax           ", "blue");
        } else {
            return "Error";
        }

    }

    /**
     * Convert to tree map.
     *
     * @param <K> the key type
     * @param <V> the value type
     * @param hashMap the hash map
     * @return the map
     */
    public static <K, V> Map<K, V> convertToTreeMap(Map<K, V> hashMap) { // converts the hashmap to a treemap using a stream and a collector toMap method which takes a key mapper, a value mapper, a merge
                                                                         // function and a supplier the merge function is used to resolve collisions, in this case it will just take
                                                                         // the new value and discard the old value if there is a collision the supplier is used to create the new map,
                                                                         // in this case it will create a new TreeMap the key mapper and value mapper are used to
                                                                         // map the key and value from the entry set of the hashmap to the key and value of the treemap

        Map<K, V> treeMap = hashMap.entrySet().stream().collect(
                Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> newValue, TreeMap::new));
        return treeMap;
    }

    //////////////////////////// CAR MANAGEMENT ////////////////////////////

    /**
     * Gets the car by reg.
     *
     * @param regNo the reg no
     * @return the car by reg
     */
    public char[] getCarByReg(RegNo regNo) {
        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // return the car
            return carMap.get(regNo).getMake().toCharArray();
        } else {
            // return null
            return null;
        }

    }

    /**
     * Gets the cars.
     *
     * @return the cars
     */
    public HashMap<RegNo, Car> getCars() {
        // returns a list of all the cars using for each
        HashMap<RegNo, Car> cars = new HashMap<RegNo, Car>();
        for (Entry<RegNo, Car> entry : carMap.entrySet()) {
            cars.put(entry.getKey(), entry.getValue());
        }
        for (Entry<RegNo, Car> entry : cars.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return cars;

    }

    /**
     * Update car color.
     *
     * @return the hash map
     */
    public HashMap<RegNo, Car> updateCarColor() {
        // updates the color of a car
        System.out.println("Enter the registration number of the car you want to update");
        // list cars
        for (Entry<RegNo, Car> entry : carMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        // get regNo
        RegNo regNo = new RegNo(Main.scanner.nextLine());
        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // get the car
            Car car = carMap.get(regNo);
            // get the color
            System.out.println("Enter the new color");
            String color = Main.scanner.nextLine();
            // set the color
            car.setColour(color);
            // put the car back in the carMap
            carMap.put(regNo, car);
            // return the carMap
            return carMap;
        } else {
            // return null
            return null;
        }
    }

    /**
     * Update car marke.
     *
     * @return the hash map
     */
    // update mark of the car
    public HashMap<RegNo, Car> updateCarMarke() {
        showAllCars();
        System.out.println(Main.textColor("Enter the registration number of the car you want to update", "yellow"));

        // get regNo
        System.out.print("RegNo: ");
        // to upper case
        RegNo regNo = new RegNo(Main.scanner.nextLine().toUpperCase());

        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // get the car
            Car car = carMap.get(regNo);
            // get the mark
            System.out.println("Enter the new mark");
            String mark = Main.scanner.nextLine();
            // set the mark
            car.setMake(mark);
            // put the car back in the carMap
            carMap.put(regNo, car);
            // return the carMap
            return carMap;
        } else {
            System.out.println(Main.textColor(
                    "Car not found, please make sure you include the space, also NOT case sensitive", "red"));
            return null;
        }
    }

    /**
     * Delete car.
     *
     * @return the hash map
     */
    // delete a car
    public HashMap<RegNo, Car> deleteCar() {
        showAllCars();
        System.out.println(Main.textColor("Enter the registration number of the car you want to delete", "yellow"));
        // get regNo
        System.out.print("RegNo: ");
        // to upper case
        RegNo regNo = new RegNo(Main.scanner.nextLine().toUpperCase());
        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // remove the car
            carMap.remove(regNo);
            // return the carMap
            System.out.println(Main.textColor("Car deleted", "green"));
            return carMap;
        } else {
            System.out.println(Main.textColor(
                    "Car not found, please make sure you include the space, also NOT case sensitive", "red"));
            return null;
        }
    }

    /**
     * Update car model.
     *
     * @return the hash map
     */
    // update model of the car
    public HashMap<RegNo, Car> updateCarModel() {
        // updates the model of a car
        System.out.println("Enter the registration number of the car you want to update");
        // list cars
        for (Entry<RegNo, Car> entry : carMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        // get regNo
        RegNo regNo = new RegNo(Main.scanner.nextLine());
        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // get the car
            Car car = carMap.get(regNo);
            // get the model
            System.out.println("Enter the new model");
            String model = Main.scanner.nextLine();
            // set the model
            car.setModel(model);
            // put the car back in the carMap
            carMap.put(regNo, car);
            // return the carMap
            return carMap;
        } else {
            // return null
            return null;
        }
    }
    //////////////////////////// CAR MANAGEMENT ////////////////////////////

    //////////////////////////// Keeper MANAGEMENT ////////////////////////////
    /**
     * Gets the keepers.
     *
     * @return the keepers
     */
    // Get all the keepers
    public HashMap<RegNo, Keeper> getKeepers() {
        // returns a list of all the keepers using for each
        HashMap<RegNo, Keeper> keepers = new HashMap<RegNo, Keeper>();
        for (Entry<RegNo, Keeper> entry : keeperMap.entrySet()) {
            keepers.put(entry.getKey(), entry.getValue());
        }
        for (Entry<RegNo, Keeper> entry : keepers.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        return keepers;
    }

    /**
     * Update keeper first name.
     *
     * @return the hash map
     */
    // updates the first name of a keeper
    public HashMap<RegNo, Keeper> updateKeeperFirstName() {
        System.out.println("Enter the First name of the keeper you want to update");
        getKeepers();
        // get regNo
        RegNo regNo = new RegNo(Main.scanner.nextLine());
        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // get the keeper
            Keeper keeper = keeperMap.get(regNo);
            // get the first name
            System.out.println("Enter the new first name");
            String firstName = Main.scanner.nextLine();
            // set the first name
            keeper.setFirstName(firstName);
            // put the keeper back in the keeperMap
            keeperMap.put(regNo, keeper);
            // return the keeperMap
            return keeperMap;

        } else {
            // return null
            return null;
        }
    }

    /**
     * Update keeper last name.
     *
     * @return the hash map
     */
    // updates the last name of a keeper
    public HashMap<RegNo, Keeper> updateKeeperLastName() {
        System.out.println("Enter the registration number of the car you want to update");
        // list cars
        for (Entry<RegNo, Car> entry : carMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        // get regNo
        RegNo regNo = new RegNo(Main.scanner.nextLine());
        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // get the keeper
            Keeper keeper = keeperMap.get(regNo);
            // get the last name
            System.out.println("Enter the new last name");
            String lastName = Main.scanner.nextLine();
            // set the last name
            keeper.setSurName(lastName);
            // put the keeper back in the keeperMap
            keeperMap.put(regNo, keeper);
            // return the keeperMap
            return keeperMap;
        } else {
            // return null
            return null;
        }
    }

    /**
     * Delete keeper.
     *
     * @return the hash map
     */
    // remove a keeper
    public HashMap<RegNo, Keeper> deleteKeeper() {
        showAllCars();
        System.out.println(Main.textColor("Enter the registration number of the car you want to delete", "yellow"));
        // get regNo
        System.out.print("RegNo: ");
        // to upper case
        RegNo regNo = new RegNo(Main.scanner.nextLine().toUpperCase());
        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // remove the keeper
            keeperMap.remove(regNo);
            // return the keeperMap
            System.out.println(Main.textColor("Keeper deleted", "green"));
            return keeperMap;
        } else {
            System.out.println(Main.textColor(
                    "Car not found, please make sure you include the space, also NOT case sensitive", "red"));
            return null;
        }
    }

    //////////////////////////// Keeper MANAGEMENT ////////////////////////////

    //////////////////////////// RegNo Management ////////////////////////////

    /**
     * Adds the reg no.
     *
     * @return the hash map
     */
    // add a regNo
    public HashMap<RegNo, Car> addRegNo() {
        System.out.println("Enter the registration number");
        RegNo regNo = new RegNo(Main.scanner.nextLine().toUpperCase());
        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // return null
            System.out.println(Main.textColor("Car already exists", "red"));
            return null;
        } else {
            // add the regNo to the carMap
            carMap.put(regNo, null);
            // return the carMap
            System.out.println(Main.textColor("\nRegNo Added Successfully\n", "green"));
            return carMap;
        }
    }

    /**
     * Delete reg no.
     *
     * @return the hash map
     */
    // delete a regNo
    public HashMap<RegNo, Car> deleteRegNo() {
        showAllCars();
        System.out.println(Main.textColor("Enter the registration number of the car you want to delete", "yellow"));
        // get regNo
        System.out.print("RegNo: ");
        // to upper case
        RegNo regNo = new RegNo(Main.scanner.nextLine().toUpperCase());
        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // remove the regNo
            carMap.remove(regNo);
            // return the carMap
            System.out.println(Main.textColor("Car deleted", "green"));
            return carMap;
        } else {
            System.out.println(Main.textColor(
                    "Car not found, please make sure you include the space, also NOT case sensitive", "red"));
            return null;
        }
    }

    /**
     * Show all regs.
     */
    // list all regNos
    public void showAllRegs() {
        // lists all cars
        // for each entry in the carMap
        for (Entry<RegNo, Car> entry : carMap.entrySet()) {
            // print the regNo and the car
            System.out.println(entry.getKey() + " " + entry.getValue());
            // if the car is null or the keeper is null print N/A
            if (entry.getValue() == null || keeperMap.get(entry.getKey()) == null) {
                System.out.println("N/A");
            } else {
                // print the keeper
                System.out.println(keeperMap.get(entry.getKey()));
            }
        }
    }

    /**
     * Attach reg no to car.
     *
     * @return the hash map
     */
    // attach a regNo to a car
    // Needs to be worked on ( not working properly ! )
    public HashMap<RegNo, Car> attachRegNoToCar() {
        System.out.println("\n====================================================|");
        System.out.println("   RegNo  |    Make    |    Model    |    Colour    |");
        System.out.println("----------|------------|-------------|--------------|");
        // if make is null, print N/A instead, else print all the cars in the carMap
        carMap.forEach((regNo, car) -> {
            if (car == null) {
                System.out.printf("%-9s | %-10s | %-11s | %-12s |%n", regNo, "N/A", "N/A", "N/A");
            }
        });
        System.out.println("====================================================|\n");

        // if there is no car == null in the carMap print "No cars available" and break
        if (carMap.containsValue(null)) {
            // get regNo
            System.out.println(Main.textColor("Enter the registration number of the car you want to attach", "yellow"));
            System.out.print("RegNo: ");
            // to upper case
            RegNo regNo = new RegNo(Main.scanner.nextLine().toUpperCase());
            // if the carMap contains the registration number
            if (carMap.containsKey(regNo)) {
                // if the car is null
                if (carMap.get(regNo) == null) {
                    // get the car
                    Car car = carMap.get(regNo);
                    // put the car in the carMap
                    carMap.put(regNo, car);
                    // return the carMap
                    System.out.println(Main.textColor("Car attached", "green"));
                    return carMap;
                } else {
                    System.out.println(Main.textColor("Car already attached", "red"));
                    return null;
                }
            } else {
                System.out.println(Main.textColor(
                        "Car not found, please make sure you include the space, also NOT case sensitive", "red"));
                return null;
            }
        } else {
            System.out.println(Main.textColor("No cars available", "red"));
            return null;
        }
    }

    /**
     * Update reg no.
     *
     * @return the hash map
     */
    // update a regNo
    public HashMap<RegNo, Car> updateRegNo() {
        showAllCars();
        System.out.println(Main.textColor("Enter the registration number of the car you want to update", "yellow"));
        // get regNo
        System.out.print("RegNo: ");
        // to upper case
        RegNo regNo = new RegNo(Main.scanner.nextLine().toUpperCase());
        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // get the car
            Car car = carMap.get(regNo);
            // get the regNo
            System.out.println("Enter the new registration number");
            RegNo newRegNo = new RegNo(Main.scanner.nextLine());
            // put the car in the carMap
            carMap.put(newRegNo, car);
            // remove the old regNo
            carMap.remove(regNo);
            System.out.println(Main.textColor("RegNo updated", "green"));
            // return the carMap
            return carMap;
        } else {
            // return null
            System.out.println(Main.textColor(
                    "Car not found, please make sure you include the space, also NOT case sensitive", "red"));
            return null;
        }
    }

    //////////////////////////// RegNo Management ////////////////////////////

    //////////////////////////// Tax Management ////////////////////////////

    /**
     * Delete tax expires end month.
     *
     * @return the hash map
     */
    // delete a taxExpiresEndMonth from a regNo
    public HashMap<RegNo, Car> deleteTaxExpiresEndMonth() {
        showAllCarsWithTaxExpiresEndMonth();
        System.out.println(Main.textColor(
                "Enter the registration number of the car you want to delete a taxExpiresEndMonth from", "yellow"));
        // get regNo
        System.out.print("RegNo: ");
        // to upper case
        RegNo regNo = new RegNo(Main.scanner.nextLine().toUpperCase());
        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // get the car
            Car car = carMap.get(regNo);
            // set the taxExpiresEndMonth to null
            car.setTaxExpiresEndMonth(null);
            // put the car in the carMap
            carMap.put(regNo, car);
            // return the carMap
            System.out.println(Main.textColor("taxExpiresEndMonth deleted", "green"));
            return carMap;
        } else {
            // return null
            System.out.println(Main.textColor(
                    "Car not found, please make sure you include the space, also NOT case sensitive", "red"));
            return null;
        }
    }

    /**
     * Update tax expires end month.
     *
     * @return the hash map
     */
    // update a taxExpiresEndMonth from a regNo
    public HashMap<RegNo, Car> updateTaxExpiresEndMonth() {
        // list cars
        showAllCarsWithTaxExpiresEndMonth();
        System.out.println(Main.textColor(
                "Enter the registration number of the car you want to add a taxExpiresEndMonth to", "yellow"));
        // get regNo
        System.out.print("RegNo: ");
        // to upper case
        RegNo regNo = new RegNo(Main.scanner.nextLine().toUpperCase());
        // if the carMap contains the registration number
        if (carMap.containsKey(regNo)) {
            // get the car
            Car car = carMap.get(regNo);
            // get the taxExpiresEndMonth
            System.out.println("Enter the month to expire, from 1 to 12");
            System.out.print("taxExpiresEndMonth: ");
            // user will enter a number from 1 to 12
            // convert that to a Month using the getMonth method in the Month class
            Month taxExpiresEndMonth = Month.getMonth(Main.scanner.nextInt());
            // set the taxExpiresEndMonth
            car.setTaxExpiresEndMonth(taxExpiresEndMonth);
            // put the car in the carMap
            carMap.put(regNo, car);
            // return the carMap
            System.out.println(Main.textColor("taxExpiresEndMonth added", "green"));

            return carMap;
        } else {
            // return null
            System.out.println(Main.textColor(
                    "Car not found, please make sure you include the space, also NOT case sensitive", "red"));
            return null;
        }
    }

    /**
     * Show all cars with tax expires end month.
     */
    // show all cars with a taxExpiresEndMonth
    public void showAllCarsWithTaxExpiresEndMonth() {
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
    }

    //////////////////////////// Tax Management ////////////////////////////

}