package Assgn2;

// public class EmployeeWage {

//     private static final double WAGE_PER_HOUR = 20.0;
//     private static final int FULL_DAY_HOURS = 8;
//     private static final int PART_TIME_HOURS = 4;
//     private static final int MAX_DAYS = 20;
//     private static final int MAX_HOURS = 100;

//     private static double calculateDailyWage(int hoursWorked) {
//         double dailyWage;

//         switch (hoursWorked) {
//             case FULL_DAY_HOURS:
//                 dailyWage = FULL_DAY_HOURS * WAGE_PER_HOUR;
//                 break;
//             case PART_TIME_HOURS:
//                 dailyWage = PART_TIME_HOURS * WAGE_PER_HOUR;
//                 break;
//             default:
//                 System.out.println("Invalid hours worked.");
//                 dailyWage = 0.0;
//         }

//         return dailyWage;
//     }

//     public static void main(String[] args) {
//         System.out.println("Welcome to Employee Wage Computation Program");

//         int totalDays = 0;
//         int totalHours = 0;
//         double totalWage = 0.0;

//         while (totalDays < MAX_DAYS || totalHours < MAX_HOURS) {
//             int hoursWorked = FULL_DAY_HOURS; // Assuming full-time hours for simplicity
//             totalDays++;
//             totalHours += hoursWorked;
//             totalWage += calculateDailyWage(hoursWorked);
//         }

//         // If total hours exceed 100, adjust total wage
//         if (totalHours > MAX_HOURS) {
//             totalWage -= calculateDailyWage(totalHours - MAX_HOURS);
//         }

//         System.out.println("Total Wage for exactly " + totalDays + " days or " + totalHours + " hours: $" + totalWage);
//     }
// }
public class EmployeeWage {

    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOUR = 8;
    private static final int PART_TIME_HOUR = 4;
    private static final int WORKING_DAYS_PER_MONTH = 20;

    private static final int ABSENT = 0;
    private static final int PART_TIME = 1;
    private static final int FULL_TIME = 2;

    public static int getEmployeeType() {
        double randomNumber = Math.random();
        if (randomNumber < 0.2)
            return ABSENT;
        else if (randomNumber < 0.66)
            return PART_TIME;
        else
            return FULL_TIME;
    }

    public static int calculateDailyWage(int hours) {
        return WAGE_PER_HOUR * hours;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        int totalWage = 0;
        for (int day = 0; day < WORKING_DAYS_PER_MONTH; day++) {
            int employeeType = getEmployeeType();
            switch (employeeType) {
                case ABSENT:
                    System.out.println("Day " + (day + 1) + ": Employee is Absent");
                    break;
                case PART_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Part-time");
                    totalWage += calculateDailyWage(PART_TIME_HOUR);
                    break;
                case FULL_TIME:
                    System.out.println("Day " + (day + 1) + ": Employee is Full-time");
                    totalWage += calculateDailyWage(FULL_DAY_HOUR);
                    break;
            }
        }

        System.out.println("Total Wage for the Month: " + totalWage);
    }

    
}