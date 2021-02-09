public class Admin {

    // Add field Variables
    Student[] student;
    Lab[] labs;
    private int maxPerYearCapacity;
    private int currentNumberOfStudents;
    private int[] currentPerYearStudent;
    private int numberOfLabs;
    private int numberOfStudentsApplied;
    private int[] numberOfPeopleAppliedForALab;

    Admin(int maxPerYearCapacity, Lab[] labs) {
        // Add code here
        this.student = new Student[100];
        this.labs = labs;
        this.maxPerYearCapacity = maxPerYearCapacity;
        this.currentPerYearStudent = new int[]{0, 0, 0, 0};
        this.currentNumberOfStudents = 0;
        this.numberOfLabs = 5;
        this.numberOfStudentsApplied = 0;
        this.numberOfPeopleAppliedForALab = new int[this.numberOfLabs];
    }


    // Add remaining Methods (*5)
    public int getCurrentNumberOfStudents() {
        return this.currentNumberOfStudents;
    }

    public void increaseLabCapacity(int labCode, int num) {
        for (int i = 0; i < labs.length; i++) {
            if (labs[i].getLabCode() == labCode) {
                labs[i].increaseSeats(num);
            }
        }
    }

    public boolean addStudent(Student student) {
        int studentYear = student.getYear();
        int index = studentYear - 2017;
        this.numberOfStudentsApplied++;



        int labCode = student.getPreferredLab();

        for (int i = 0; i < numberOfLabs; i++) {
            if (labs[i].getLabCode() == labCode) {
                this.numberOfPeopleAppliedForALab[i]++;
                if (currentPerYearStudent[index] >= maxPerYearCapacity){
                    return false;
                }
                if (labs[i].getCurrentNumberOfStudents() >= labs[i].getMaxCapacity()) {
                    return false;
                } else {
                    labs[i].updateCurrentNumberOfStudents();
                }
            }
        }


        this.student[currentNumberOfStudents++] = student;
        currentPerYearStudent[index]++;
        return true;
    }

    public double successRatio() {
        return (double)this.currentNumberOfStudents / this.numberOfStudentsApplied;
    }

    public double[] labSuccess() {
        double[] labSuccess = new double[this.numberOfLabs];
        for (int i = 0; i < this.numberOfLabs; i++) {
            labSuccess[i] = (double)labs[i].getCurrentNumberOfStudents()/this.numberOfPeopleAppliedForALab[i];
        }
        return labSuccess;
    }

}
