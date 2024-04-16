import java.io.*;

public class EmployeeFileHandler {
    private static final String FILE_NAME = "employees.txt";

    public static void writeToFile(Employee employee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(employeeToString(employee));
            writer.newLine();
            System.out.println("Employee information has been written to file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String employeeToString(Employee employee) {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(employee.ID).append(", ");
        sb.append("Full Name: ").append(employee.fullName).append(", ");
        sb.append("Birth Day: ").append(employee.birthDay).append(", ");
        sb.append("Phone: ").append(employee.phone).append(", ");
        sb.append("Email: ").append(employee.email).append(", ");
        sb.append("Employee Type: ").append(employee.employeeType);
        if (employee instanceof Experience) {
            Experience expEmployee = (Experience) employee;
            sb.append(", Experience in Year: ").append(expEmployee.expInYear).append(", ");
            sb.append("Professional Skill: ").append(expEmployee.proSkill);
        } else if (employee instanceof Fresher) {
            Fresher freshEmployee = (Fresher) employee;
            sb.append(", Graduation Date: ").append(freshEmployee.graduationDate).append(", ");
            sb.append("Graduation Rank: ").append(freshEmployee.graduationRank).append(", ");
            sb.append("Education: ").append(freshEmployee.education);
        } else if (employee instanceof Intern) {
            Intern internEmployee = (Intern) employee;
            sb.append(", Majors: ").append(internEmployee.majors).append(", ");
            sb.append("Semester: ").append(internEmployee.semester).append(", ");
            sb.append("University Name: ").append(internEmployee.universityName);
        }
        return sb.toString();
    }
}
