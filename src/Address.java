import java.util.Objects;


/**
 * The Class Address.
 */
// Address class
public class Address {
    
    /** The street. */
    private String street;
    
    /** The town. */
    private String town;
    
    /** The postcode. */
    private String postcode;

    /**
     * Instantiates a new address.
     *
     * @param street the street
     * @param town the town
     * @param postcode the postcode
     */
    // constructor
    public Address(String street, String town, String postcode) {
        this.street = street;
        this.town = town;
        this.postcode = postcode;
    }

    /**
     * Gets the street.
     *
     * @return the street
     */
    // getters and setters
    public String getStreet() {
        return street;
    }

    /**
     * Gets the town.
     *
     * @return the town
     */
    public String getTown() {
        return town;
    }

    /**
     * Gets the postcode.
     *
     * @return the postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * Sets the street.
     *
     * @param street the new street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Sets the town.
     *
     * @param town the new town
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * Sets the postcode.
     *
     * @param postcode the new postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    /**
     * To string.
     *
     * @return the string
     */
    // toString, hashCode and equals
    @Override
    public String toString() {
        return "Address [postcode=" + postcode + ", street=" + street + ", town=" + town + "]";
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(postcode, street, town);
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        return Objects.equals(postcode, other.postcode) && Objects.equals(street, other.street)
                && Objects.equals(town, other.town);
    }

}