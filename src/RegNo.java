
/**
 * The Class RegNo.
 */
class RegNo implements Comparable<RegNo> {

    /** The reg no. */
    private String regNo;

    /**
     * Instantiates a new reg no.
     *
     * @param string the string
     */
    public RegNo(String string) {
        this.regNo = string;
    }

    /**
     * Gets the reg no.
     *
     * @return the reg no
     */
    public String getRegNo() {
        return regNo;
    }

    /**
     * Sets the reg no.
     *
     * @param regNo the new reg no
     */
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return regNo;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((regNo == null) ? 0 : regNo.hashCode());
        return result;
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
        RegNo other = (RegNo) obj;
        if (regNo == null) {
            if (other.regNo != null)
                return false;
        } else if (!regNo.equals(other.regNo))
            return false;
        return true;
    }

    /**
     * Compare to.
     *
     * @param o the o
     * @return the int
     */
    @Override
    public int compareTo(RegNo o) {
        return this.regNo.compareTo(o.regNo);
    }

}
