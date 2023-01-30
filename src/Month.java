
/**
 * The Enum Month.
 */
public enum Month {

    /**  january. */
    JANUARY(1, "January"),
    
    /**  february. */
    FEBRUARY(2, "February"),
    
    /**  march. */
    MARCH(3, "March"),
    
    /**  april. */
    APRIL(4, "April"),
    
    /**  may. */
    MAY(5, "May"),
    
    /**  june. */
    JUNE(6, "June"),
    
    /**  july. */
    JULY(7, "July"),
    
    /**  august. */
    AUGUST(8, "August"),
    
    /**  september. */
    SEPTEMBER(9, "September"),

    /**  october. */
    OCTOBER(10, "October"),
    
    /**  november. */
    NOVEMBER(11, "November"),
    
    /**  december. */
    DECEMBER(12, "December"),
    
    /**  invalid. */
    INVALID(0, "No Tax");

    /** The month number. */
    private final int monthNumber;
    
    /** The month name. */
    private final String monthName;

    /**
     * Instantiates a new month.
     *
     * @param monthNumber the month number
     * @param monthName the month name
     */
    private Month(int monthNumber, String monthName) {
        this.monthNumber = monthNumber;
        this.monthName = monthName;
    }

    /**
     * Gets the month number.
     *
     * @return the month number
     */
    public int getMonthNumber() {
        return monthNumber;
    }

    /**
     * Gets the month name.
     *
     * @return the month name
     */
    public String getMonthName() {
        return monthName;
    }

    /**
     * Gets the month.
     *
     * @param monthNumber the month number
     * @return the month
     */
    // takes in a number from 1-12 and returns the month name
    public static Month getMonth(int monthNumber) {
        for (Month month : Month.values()) {
            if (month.getMonthNumber() == monthNumber) {
                return month;
            }
        }
        return INVALID;
    }

    /**
     * Gets the month.
     *
     * @param taxExpiresEndMonth the tax expires end month
     * @return the month
     */
    // takes in a month name and returns the month number
    public static Month getMonth(Month taxExpiresEndMonth) {
        for (Month month : Month.values()) {
            if (month.getMonthNumber() == taxExpiresEndMonth.getMonthNumber()) {
                return month;

            }
        }
        return INVALID;
    }

    /**
     * Gets the month.
     *
     * @param monthName the month name
     * @return the month
     */
    public static Month getMonth(String monthName) {
        for (Month month : Month.values()) {
            if (month.getMonthName().equalsIgnoreCase(monthName)) {
                return month;
            }
        }
        return INVALID;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Month{" +
                "monthNumber=" + monthNumber +
                ", monthName='" + monthName + '\'' +
                '}';
    }

}
