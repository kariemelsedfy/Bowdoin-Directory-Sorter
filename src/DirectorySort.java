import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Comparator;


/**
 * class provides various methods to sort a directory of students
 * based on different criteria, such as smallest or largest su box number, lexicographical
 * order by last name, number of vowels in the name, and fanciest phone number.
 * It uses a SortableArrayList directory to store and manage the Student objects.
 *
 * The class includes comparators for each sorting criterion and uses helper methods
 * to assist with specific sorting logic.
 *
 * @author Karim ElSedfy
 * @version 1.0 11/05/2005
 */
public class DirectorySort {
    /**
     * This is an instance of SortableArrayList containing instances of
     * the Student class.
     *
     * It represents the directory and most methods in this class operate on it.
     */
    private static SortableArrayList<Student> directory = new SortableArrayList<>();

    /**
     * This function calls getTopStudents and returns
     * the student(s) with the smallest su box number.
     *
     * @return the student(s) with the smallest su box number
     */
    public static String getSmallestSU() {
        return getTopStudents(new SmallestSuBoxComparator());
    }

    /**
     * This is a Comparator class implementing the compare method on two
     * Student instances to get which has the larger su box number.
     *
     * When used as a parameter for the sort function this will end up sorting
     * the SortableArrayList ascendingly.
     */
    private static class SmallestSuBoxComparator implements Comparator<Student> {
        /**
         * Compares the su box values for two Student instances.
         *
         * @param a the first object to be compared
         * @param b the second object to be compared
         * @return the difference between su box values
         */
        @Override
        public int compare(Student a, Student b) {
            return a.getSuBox() - b.getSuBox();
        }
    }

    /**
     * This function calls getTopStudents and returns
     * the student(s) with the largest su box number.
     *
     * @return the student(s) with the largest su box number
     */
    public static String getLargestSU() {
        return getTopStudents(new LargestSuBoxComparator());
    }

    /**
     * This is a Comparator class implementing the compare method on two
     * Student instances to get which has the smaller su box number.
     *
     * When used as a parameter for the sort function this will end up sorting
     * the SortableArrayList descendingly.
     */
    private static class LargestSuBoxComparator implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return b.getSuBox() - a.getSuBox();
        }
    }

    /**
     * This function calls getTopStudents and returns the top students
     * in the lexicographically sorted directory by last name.
     *
     * @return First student(s) in the lexicographically sorted directory by last name
     */
    public static String getFirstByLastName() {
        return getTopStudents(new FirstStudentLastNameComparator());
    }

    /**
     * This is a Comparator class implementing the compare method on two
     * Student instances to get which has a lexicographically preceding name.
     *
     * When used as a parameter for the sort function this will end up sorting
     * the SortableArrayList ascendingly.
     */
    private static class FirstStudentLastNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return a.getLastName().compareToIgnoreCase(b.getLastName());
        }
    }


    /**
     * This function calls getTopStudents and returns the top students
     * in the inversely lexicographically sorted directory by last name.
     *
     * @return Last student(s) in the lexicographically sorted directory by last name
     */
    public static String getLastByLastName() {
        return getTopStudents(new LastStudentLastNameComparator());
    }

    /**
     * This is a Comparator class implementing the compare method on two
     * Student instances to get which has a lexicographically following name.
     *
     * When used as a parameter for the sort function this will end up sorting
     * the SortableArrayList descendingly.
     */
    private static class LastStudentLastNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return b.getLastName().compareToIgnoreCase(a.getLastName());
        }
    }

    /**
     * This function calls getTopStudents and returns the top students
     * in the directory sorted by most vowels in full name.
     *
     * @return Top student(s) in the directory sorted by most vowels in full name
     */
    public static String getMostVowels() {
        return getTopStudents(new MostVowelsComparator());
    }

    /**
     * This is a Comparator class implementing the compare method on two
     * Student instances to get which has more vowels in their full name.
     *
     * When used as a parameter for the sort function this will end up sorting
     * the SortableArrayList descendingly.
     */
    private static class MostVowelsComparator implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return getNumberOfVowels(b.getFirstName() + b.getLastName())
                    - getNumberOfVowels(a.getFirstName() + a.getLastName());
        }
    }

    /**
     * This function calls getTopStudents and returns the top students
     * in the directory sorted by least vowels in full name.
     *
     * @return Top student(s) in the directory sorted by least vowels in full name
     */
    public static String getLeastVowels() {
        return getTopStudents(new LeastVowelsComparator());
    }

    /**
     * This is a Comparator class implementing the compare method on two
     * Student instances to get which has fewer vowels in their full name.
     *
     * When used as a parameter for the sort function this will end up sorting
     * the SortableArrayList ascendingly.
     */
    private static class LeastVowelsComparator implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return getNumberOfVowels(a.getFirstName() + a.getLastName())
                    - getNumberOfVowels(b.getFirstName() + b.getLastName());
        }
    }

    /**
     * This function calls getTopStudents and returns the top students
     * in the directory sorted by the fanciest phone (most occurrences
     * of any single digit in their phone number).
     *
     * @return Top student(s) in the directory sorted by fanciest phone
     */
    public static String getFancyPhone() {
        return getTopStudents(new FancyNumberComparator());
    }

    /**
     * This is a Comparator class implementing the compare method on two
     * Student instances to get which has more occurrences
     * of any single digit in their phone number (fancier phone).
     *
     * When used as a parameter for the sort function this will end up sorting
     * the SortableArrayList descendingly.
     */
    private static class FancyNumberComparator implements Comparator<Student> {
        @Override
        public int compare(Student a, Student b) {
            return sameNumberFrequency(b.getPhone()) - sameNumberFrequency(a.getPhone());
        }
    }


    /**
     * This is a helper function for the FancyNumberComparator class. It takes a
     * String representing a phone number, creates a hashmap, loops over it populating
     * it, with each character or number having a frequency. Then it returns the character
     * or number that appeared the most frequent.
     *
     * @param phone a string representing the phone number of a Student instance
     * @return most occurrences of any single character in the param phone
     */
    private static int sameNumberFrequency(String phone) {
        Map<Character, Integer> numberFrequency = new HashMap<>();
        for(char number: phone.toCharArray()) {
            if(numberFrequency.containsKey(number)) {
                numberFrequency.put(number, (numberFrequency.get(number) + 1));
                continue;
            }
            numberFrequency.put(number, 1);
        }
        int largestFrequency = 0;
        for(int frequency: numberFrequency.values()) {
            if(frequency > largestFrequency) {
                largestFrequency = frequency;
            }
        }
        return largestFrequency;
    }

    /**
     * This is a helper function for both the MostVowelsComparator and
     * LeastVowelsComparator. It returns the number of vowels in a given
     * String.
     *
     * It loops over all the characters in the param name and checks
     * if that character is a vowel or not. If it is it increments
     * numberOfVowelsInName.
     *
     * @param name string representing full name of a Student instance
     * @return numberOfVowelsInName: number of vowels in the param name
     */
    private static int getNumberOfVowels(String name) {
        char[] vowels = {'a', 'e', 'i', 'u', 'o'};
        int numberOfVowelsInName = 0;
        for(char character: name.toLowerCase().toCharArray()) {
            for(char vowel: vowels) {
                if(character == vowel) {
                    numberOfVowelsInName++;
                }
            }
        }
        return numberOfVowelsInName;
    }

    /**
     * This is a helper function for all the non-helper methods in this class. It
     * returns the top student(s) in a sorted directory according to a certain comparator
     * c.
     *
     * It equals the top Student with index 0 in the SortableArrayList directory to
     * topStudents. Then, it checks if there are ties by using the comparator c
     * and its method compare to loop over the sorted Students of directory, and once,
     * according to the Comparator c, the values are unequal, it returns the string topStudents.
     *
     *
     * @param c Comparator class used as criteria to sort directory
     * @return the first Student instance(s) that are tied
     */
    private static String getTopStudents(Comparator<Student> c) {
        directory.sort(c);
        String topStudents = directory.get(0).toString();
        for(int i = 1; i < directory.size(); i++) {
            if(!(c.compare(directory.get(i - 1), directory.get(i)) == 0)) {
                return topStudents;
            }
            topStudents += "\n" + directory.get(i).toString();
        }
        return "Failed to get top students!";
    }

    /**
     * Tries to read the file directory.txt, and then loops over each line,
     * feeding the lines to addStudent. Populates the SortableArrayList directory.
     */
    private static void populateSortableArrayList() {
        Scanner scan;
        try {
            scan = new Scanner(new File("directory-files/directory.txt"));
        } catch (Exception e) {
            System.out.println("Failed to read file.");
            return;
        }
        while (scan.hasNext()) {
            String line = scan.nextLine();
            addStudent(line);
        }
        scan.close();
    }

    /**
     * Takes in a string student, which is expected to be every line in
     * directory.txt. Splices that string and passes it off to the Student
     * constructor, and adding that Student instance to the SortableArrayList
     * directory.
     *
     * @param student line in directory.txt representing every student
     */
    private static void addStudent(String student) {
        String[] studentParts = student.split(" \\| ");
        String[] name = studentParts[0].split(" ");
        directory.add(new Student(name[0], name[1], studentParts[1],
                studentParts[2], studentParts[3], Integer.parseInt(studentParts[4])));
    }


    /**
     * Calls populateSortableArrayList to populate SortableArraylist directory.
     * Prints all the values for all the non-helper functions.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        populateSortableArrayList();
        System.out.println("Smallest su box number: \n" + getSmallestSU());
        System.out.println("Largest su box number: \n" + getLargestSU());
        System.out.println("First student in the lexicographically sorted directory by last name: \n"
                + getFirstByLastName());
        System.out.println("Last student in the lexicographically sorted directory by last name: \n"
                + getLastByLastName());
        System.out.println("Student with the most vowels in their name: \n" + getMostVowels());
        System.out.println("Student with the least vowels in their name: \n" + getLeastVowels());
        System.out.println("Student with the fanciest phone: \n" + getFancyPhone());
        System.out.println(getFirstByLastName());

    }


}
