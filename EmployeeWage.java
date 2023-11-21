package Assgn2;
public class EmployeeWage {

    private static double calculateDailyWage(int hoursWorked, double wagePerHour) {
        
        final int fullDayHours = 8;
        final int partTimeHours = 4;
        double dailyWage;

        switch (hoursWorked) {
            case fullDayHours:
                dailyWage = hoursWorked * wagePerHour;
                break;
            case partTimeHours:
                dailyWage = hoursWorked * wagePerHour;
                break;
            default:
                System.out.println("Invalid hours worked.");
                dailyWage = 0.0;
        }

        return dailyWage;
    }
    public static void main(String[] args){
        System.out.println("Welcome to Employee Wage Computation Program");
        double wagePerHour = 20.0;

        int fullTimeHours = 8;
        double fullTimeWage = calculateDailyWage(fullTimeHours, wagePerHour);
        System.out.println("Full Time Employee Daily Wage: $" + fullTimeWage);

        int partTimeHours = 4;
        double partTimeWage = calculateDailyWage(partTimeHours, wagePerHour);
        System.out.println("Part Time Employee Daily Wage: $" + partTimeWage);
    }
}
