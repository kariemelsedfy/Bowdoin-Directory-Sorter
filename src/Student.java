/**
 * The Student class represents a student with various personal details,
 * including first name, last name, address, phone number, email address, and su box number.
 * It provides methods to access each of these attributes individually.
 *
 * @author Karim ElSedfy
 * @version 1.0 11/05/2005
 */
public class Student {
    /**
     * Represents the first name of the student.
     */
    private String firstName;

    /**
     * Represents the last name of the student.
     */
    private String lastName;

    /**
     * Represents the address of the student.
     */
    private String address;

    /**
     * Represents the phone number of the student.
     */
    private String phone;

    /**
     * Represents the email address of the student.
     */
    private String email;

    /**
     * Represents the su box number of the student.
     */
    private int suBox;

    /**
     * Gets the first name of the person.
     *
     * @return the first name as a String.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the person.
     *
     * @return the last name as a String.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the address of the person.
     *
     * @return the address as a String.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets the phone number of the person.
     *
     * @return the phone number as a String.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets the email address of the person.
     *
     * @return the email address as a String.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the suBox value of the person.
     *
     * @return the suBox value as an int.
     */
    public int getSuBox() {
        return suBox;
    }

    /**
     * Constructs a new Student with the specified details.
     *
     * @param firstName the first name of the student.
     * @param lastName the last name of the student.
     * @param address the address of the student.
     * @param phone the phone number of the student.
     * @param email the email address of the student.
     * @param suBox the su box number of the student.
     */
    public Student(String firstName, String lastName,
                   String address, String phone, String email, int suBox) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.suBox = suBox;
    }



    /**
     * Returns a string representation of the Student object.
     *
     * The format includes the student's first name, last name, address, phone number,
     * email, and su box number.
     *
     * @return a formatted string representing the student's details.
     */
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " | "
                + this.address + " | " + this.phone + " | " + this.email + " | " + this.suBox;
    }

}
