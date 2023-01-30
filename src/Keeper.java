
/**
 * The Class Keeper.
 */
public class Keeper {
    
    /** The fore name. */
    private String foreName;
    
    /** The sur name. */
    private String surName;
    
    /** The address. */
    private Address address;

    /**
     * Instantiates a new keeper.
     *
     * @param foreName the fore name
     * @param surName the sur name
     * @param address the address
     */
    public Keeper(String foreName, String surName, Address address) {
        this.foreName = foreName;
        this.surName = surName;
        this.address = address;
    }

    /**
     * Gets the fore name.
     *
     * @return the fore name
     */
    public String getForeName() {
        if (foreName == null || foreName.isEmpty()) {
            return "N/A";
        } else {
            return foreName;
        }
    }

    /**
     * Sets the fore name.
     *
     * @param foreName the new fore name
     */
    public void setForeName(String foreName) {
        this.foreName = foreName;
    }

    /**
     * Gets the sur name.
     *
     * @return the sur name
     */
    public String getSurName() {
        return surName;
    }

    /**
     * Sets the sur name.
     *
     * @param surName the new sur name
     */
    public void setSurName(String surName) {
        this.surName = surName;
    }

    /**
     * Gets the address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets the address.
     *
     * @param address2 the new address
     */
    public void setAddress(Address address2) {
        this.address = address2;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override

    public String toString() {
        return "Keeper{" +
                "foreName='" + foreName + '\'' +
                ", surName='" + surName + '\'' +
                ", address=" + address +
                '}';
    }

    /**
     * Sets the first name.
     *
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
    }

}
