
/**
 * The Class Car.
 */
public class Car {
    
    /** The vin. */
    private String vin;
    
    /** The make. */
    private String make;
    
    /** The model. */
    private String model;
    
    /** The colour. */
    private String colour;
    
    /** The tax expires end month. */
    private Month taxExpiresEndMonth;

    /**
     * Instantiates a new car.
     *
     * @param make the make
     * @param model the model
     * @param colour the colour
     */
    // default constructor
    public Car(String make, String model, String colour) {
        this.make = make;
        this.model = model;
        this.colour = colour;
        // takes in values from make model color and a random number for the vin
        this.vin = make.substring(0, 2) + model.substring(0, 2) + colour.substring(0, 2)
                + (int) (Math.random() * 100000);

    }

    /**
     * Instantiates a new car.
     *
     * @param make the make
     * @param model the model
     * @param colour the colour
     * @param taxExpiresEndMonth the tax expires end month
     */
    // constructor with tax expiry month
    public Car(String make, String model, String colour, Month taxExpiresEndMonth) {
        this.make = make;
        this.model = model;
        this.colour = colour;
        this.taxExpiresEndMonth = taxExpiresEndMonth;
        this.vin = make.substring(0, 2) + model.substring(0, 2) + colour.substring(0, 2)
                + (int) (Math.random() * 100000);

    }

    /**
     * Gets the vin.
     *
     * @return the vin
     */
    // getters and setters
    public String getVin() {
        return vin;
    }

    /**
     * Sets the vin.
     *
     * @param vin the new vin
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     * Gets the make.
     *
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the make.
     *
     * @param make the new make
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param model the new model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the colour.
     *
     * @return the colour
     */
    public String getColour() {
        return colour;
    }

    /**
     * Sets the colour.
     *
     * @param colour the new colour
     */
    public void setColour(String colour) {
        this.colour = colour;
    }

    /**
     * Sets the tax.
     *
     * @param month the new tax
     */
    public void setTax(Month month) {
        this.taxExpiresEndMonth = month;
    }

    /**
     * Sets the tax.
     *
     * @param month the new tax
     */
    public void setTax(String month) {
        this.taxExpiresEndMonth = Month.getMonth(month);
    }

    /**
     * Checks if is tax expired.
     *
     * @param month the month
     * @return true, if is tax expired
     */
    public boolean isTaxExpired(Month month) {
        return taxExpiresEndMonth.getMonthNumber() < month.getMonthNumber();
    }

    /**
     * Checks if is tax expired.
     *
     * @param month the month
     * @return true, if is tax expired
     */
    public boolean isTaxExpired(String month) {
        return taxExpiresEndMonth.getMonthNumber() < Month.getMonth(month).getMonthNumber();
    }

    /**
     * Gets the tax expires end month.
     *
     * @return the tax expires end month
     */
    public Month getTaxExpiresEndMonth() {
        if (taxExpiresEndMonth == null || taxExpiresEndMonth.getMonthNumber() == 0) {
            return Month.INVALID;
        } else {
            return Month.getMonth(taxExpiresEndMonth);
        }
    }

    /**
     * Sets the tax expires end month.
     *
     * @param taxExpiresEndMonth the new tax expires end month
     */
    public void setTaxExpiresEndMonth(Month taxExpiresEndMonth) {
        this.taxExpiresEndMonth = taxExpiresEndMonth;
    }

    /**
     * To string.
     *
     * @return the string
     */
    //toString method
    @Override
    public String toString() {
        return " VIN : " + vin + " Make : " + make + " Model : " + model + " Colour : " + colour + " Tax Expires : "
                + taxExpiresEndMonth;
    }



}
