package Assgn2;
public class EmployeeWage {

    private static void checkAttendance() {
        
        double attendanceValue = Math.random();

        if (attendanceValue > 0.5) {
            System.out.println("Employee is present.");
        } else {
            System.out.println("Employee is absent.");
        }
    }
    public static void main(String[] args){
        System.out.println("Welcome to Employee Wage Computation Program\n");
        System.out.println("ATTANDANCE");
        checkAttendance();
    }
}
