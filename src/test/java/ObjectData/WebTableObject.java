package ObjectData;

import java.util.HashMap;

public class WebTableObject {

    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private Integer salary;
    private String department;

    public WebTableObject(HashMap<String, String> testData) {
        populateData(testData);
    }

    private void populateData(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "firstName":
                    setFirstName(testData.get(key));
                    break;
                case "lastName":
                    setLastName(testData.get(key));
                    break;
                case "age":
                    setAge(Integer.valueOf(testData.get(key)));
                    break;
                case "email":
                    setEmail(testData.get(key));
                    break;
                case "salary":
                    setSalary(Integer.valueOf(testData.get(key)));
                    break;
                case "department":
                    setDepartment(testData.get(key));
                    break;
            }
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
