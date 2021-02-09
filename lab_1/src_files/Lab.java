public class Lab {


    // Add Class Variables
    private int labCode;
    private int maxCapacity;
    private int currentNumberOfStudents;

    Lab(int labCode, int maxCapacity) {
        // Add code here
        this.labCode = labCode;
        this.maxCapacity = maxCapacity;
        this.currentNumberOfStudents = 0;
    }

    //Add remaining methods (*5)
    public int getLabCode() {
        return this.labCode;
    }

    public int getCurrentNumberOfStudents() {
        return this.currentNumberOfStudents;
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public void increaseSeats(int numSeats) {
        this.maxCapacity += numSeats;
    }

    public void updateCurrentNumberOfStudents() {
        this.currentNumberOfStudents++;
    }
}
