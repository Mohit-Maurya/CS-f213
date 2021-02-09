public class Student {

    // Add fields here
    private String ID;
    private int preferredLab;


    Student(String ID, int preferredLab) {
        // Add code here
        this.ID = ID;
        this.preferredLab = preferredLab;
    }


    // Template code; do not edit
    int getYear() {
        //Extracting characters one by one and converting them to int
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int temp = (int) (ID.charAt(i) - '0'); //Typecasting
            sum *= 10;
            sum = sum + temp;
        }
        return sum;
    }

    String getBranch() {
        return ID.substring(4, 6);
    }
    // Template Code Ends

    //Add remaining methods(*2)
    public String getID() {
        return this.ID;
    }

    public int getPreferredLab() {
        return this.preferredLab;
    }
}
