import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Write data to file");
            System.out.println("2. Show data from file");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    writeDataToFile();
                    break;
                case 2:
                    showDataFromFile();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    private static void writeDataToFile() {
        System.out.println("Enter employee information:");
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Birth Day (YYYY-MM-DD): ");
        String birthDay = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Employee Type (Experience, Fresher, or Intern): ");
        String employeeType = scanner.nextLine();

        Employee employee;
        switch (employeeType.toLowerCase()) {
            case "experience":
                System.out.print("Years of Experience: ");
                int expInYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                System.out.print("Professional Skill: ");
                String proSkill = scanner.nextLine();

                employee = new Experience(id, fullName, birthDay, phone, email, expInYear, proSkill);
                break;
            case "fresher":
                System.out.print("Graduation Date (YYYY-MM-DD): ");
                String graduationDate = scanner.nextLine();

                System.out.print("Graduation Rank: ");
                String graduationRank = scanner.nextLine();

                System.out.print("Education: ");
                String education = scanner.nextLine();

                employee = new Fresher(id, fullName, birthDay, phone, email, graduationDate, graduationRank, education);
                break;
            case "intern":
                System.out.print("Majors: ");
                String majors = scanner.nextLine();

                System.out.print("Semester: ");
                String semester = scanner.nextLine();

                System.out.print("University Name: ");
                String universityName = scanner.nextLine();

                employee = new Intern(id, fullName, birthDay, phone, email, majors, semester, universityName);
                break;
            default:
                System.out.println("Invalid employee type.");
                return;
        }

        // Write employee to file
        EmployeeFileHandler.writeToFile(employee);

        System.out.println("Employee data has been written to file.");
    }


    private static void showDataFromFile() {
        System.out.println("Employees read from file:");
        EmployeeFileHandler.readFromFile();
    }
}


//database


//import java.util.Scanner;
//
//public class Main {
//    private static final Scanner scanner = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/employment";
//        String user = "root";
//        String password = "Bin141005";
//
//        EmployeeDatabase database = new EmployeeDatabase(url, user, password);
//
//        while (true) {
//            System.out.println("Choose an option:");
//            System.out.println("1. Write data to database");
//            System.out.println("2. Show data from database");
//            System.out.println("3. Exit");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine(); // Consume newline character
//
//            switch (choice) {
//                case 1:
//                    writeDataToDatabase(database);
//                    break;
//                case 2:
//                    showDataFromDatabase(database);
//                    break;
//                case 3:
//                    System.out.println("Exiting...");
//                    database.close();
//                    return;
//                default:
//                    System.out.println("Invalid choice. Please choose again.");
//            }
//        }
//    }
//
//    private static void writeDataToDatabase(EmployeeDatabase database) {
//        System.out.println("Enter employee information:");
//        System.out.print("ID: ");
//        int id = scanner.nextInt();
//        scanner.nextLine(); // Consume newline character
//
//        System.out.print("Full Name: ");
//        String fullName = scanner.nextLine();
//
//        System.out.print("Birth Day (YYYY-MM-DD): ");
//        String birthDay = scanner.nextLine();
//
//        System.out.print("Phone: ");
//        String phone = scanner.nextLine();
//
//        System.out.print("Email: ");
//        String email = scanner.nextLine();
//
//        System.out.print("Employee Type (Experience, Fresher, or Intern): ");
//        String employeeType = scanner.nextLine();
//
//        Employee employee;
//        switch (employeeType.toLowerCase()) {
//            case "experience":
//                System.out.print("Years of Experience: ");
//                int expInYear = scanner.nextInt();
//                scanner.nextLine(); // Consume newline character
//
//                System.out.print("Professional Skill: ");
//                String proSkill = scanner.nextLine();
//
//                employee = new Experience(id, fullName, birthDay, phone, email, expInYear, proSkill);
//                break;
//            case "fresher":
//                System.out.print("Graduation Date (YYYY-MM-DD): ");
//                String graduationDate = scanner.nextLine();
//
//                System.out.print("Graduation Rank: ");
//                String graduationRank = scanner.nextLine();
//
//                System.out.print("Education: ");
//                String education = scanner.nextLine();
//
//                employee = new Fresher(id, fullName, birthDay, phone, email, graduationDate, graduationRank, education);
//                break;
//            case "intern":
//                System.out.print("Majors: ");
//                String majors = scanner.nextLine();
//
//                System.out.print("Semester: ");
//                String semester = scanner.nextLine();
//
//                System.out.print("University Name: ");
//                String universityName = scanner.nextLine();
//
//                employee = new Intern(id, fullName, birthDay, phone, email, majors, semester, universityName);
//                break;
//            default:
//                System.out.println("Invalid employee type.");
//                return;
//        }
//
//        // Add employee to database
//        database.addEmployee(employee);
//
//        System.out.println("Employee data has been written to database.");
//    }
//
//    private static void showDataFromDatabase(EmployeeDatabase database) {
//        System.out.println("Employees read from database:");
//        database.displayAllEmployees();
//    }
//}
