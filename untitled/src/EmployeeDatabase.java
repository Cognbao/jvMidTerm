import java.sql.*;

class EmployeeDatabase {
    private Connection connection;

    public EmployeeDatabase(String url, String user, String password) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employment", "root", "Bin141005");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee(Employee employee) {
        try {
            String sql = "INSERT INTO employees (ID, full_name, birth_day, phone, email, employee_type, exp_in_year, pro_skill, graduation_date, graduation_rank, education, majors, semester, university_name) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.ID);
            preparedStatement.setString(2, employee.fullName);
            preparedStatement.setDate(3, java.sql.Date.valueOf(employee.birthDay));
            preparedStatement.setString(4, employee.phone);
            preparedStatement.setString(5, employee.email);
            preparedStatement.setString(6, employee.employeeType);

            if (employee instanceof Experience) {
                Experience experience = (Experience) employee;
                preparedStatement.setInt(7, experience.expInYear);
                preparedStatement.setString(8, experience.proSkill);
            } else {
                preparedStatement.setNull(7, Types.INTEGER);
                preparedStatement.setNull(8, Types.VARCHAR);
            }

            if (employee instanceof Fresher) {
                Fresher fresher = (Fresher) employee;
                preparedStatement.setDate(9, java.sql.Date.valueOf(fresher.graduationDate));
                preparedStatement.setString(10, fresher.graduationRank);
                preparedStatement.setString(11, fresher.education);
            } else {
                preparedStatement.setNull(9, Types.DATE);
                preparedStatement.setNull(10, Types.VARCHAR);
                preparedStatement.setNull(11, Types.VARCHAR);
            }

            if (employee instanceof Intern) {
                Intern intern = (Intern) employee;
                preparedStatement.setString(12, intern.majors);
                preparedStatement.setString(13, intern.semester);
                preparedStatement.setString(14, intern.universityName);
            } else {
                preparedStatement.setNull(12, Types.VARCHAR);
                preparedStatement.setNull(13, Types.VARCHAR);
                preparedStatement.setNull(14, Types.VARCHAR);
            }

            preparedStatement.executeUpdate();
            System.out.println("Employee added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Implement other CRUD operations similarly

    public void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void displayAllEmployees() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String fullName = resultSet.getString("full_name");
                Date birthDay = resultSet.getDate("birth_day");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String employeeType = resultSet.getString("employee_type");
                int expInYear = resultSet.getInt("exp_in_year");
                String proSkill = resultSet.getString("pro_skill");
                Date graduationDate = resultSet.getDate("graduation_date");
                String graduationRank = resultSet.getString("graduation_rank");
                String education = resultSet.getString("education");
                String majors = resultSet.getString("majors");
                String semester = resultSet.getString("semester");
                String universityName = resultSet.getString("university_name");

                // Create employee object based on employee type
                Employee employee;
                switch (employeeType.toLowerCase()) {
                    case "experience":
                        employee = new Experience(id, fullName, birthDay.toString(), phone, email, expInYear, proSkill);
                        break;
                    case "fresher":
                        employee = new Fresher(id, fullName, birthDay.toString(), phone, email, graduationDate.toString(), graduationRank, education);
                        break;
                    case "intern":
                        employee = new Intern(id, fullName, birthDay.toString(), phone, email, majors, semester, universityName);
                        break;
                    default:
                        // Handle invalid employee type
                        continue;
                }

                // Display employee information
                employee.showInfo();
                System.out.println();
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}