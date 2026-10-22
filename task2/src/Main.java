public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Моц", "Микита", 18, "ai-251", "2542351234");
        Student student2 = new Student("Замфір", "Данило", 18, "ai-257", "25425456237");
        Student student3 = new Student("Редько", "Ілья", 19, "ai-247", "65425438668");
        Lecturer lecturer1 = new Lecturer("Мельник", "Анатолій", 45, "ІКС", 35500.0);
        Lecturer lecturer2 = new Lecturer("Бойко", "Тарас", 52, "ІКС", 48000.0);
        Lecturer lecturer3 = new Lecturer("Кравченко", "Дмитро", 39, "ІКС", 41200.0);

        Person[] people = {student1, student2, student3, lecturer1, lecturer2, lecturer3};

        for(int i = 0; i < people.length; i++){
            System.out.println(people[i].toString());
        }
    }
}

class Person{
    private String lastName;
    private String firstName;
    private int age;

    Person(String lastName, String firstName, int age){
        if(age < 0){
            throw new IllegalArgumentException("Вік повинен бути більше 0");
        }
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;

    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setAge(int age){
        if(age < 0){
            throw new IllegalArgumentException("Вік повинен бути більше 0");
        }
        this.age = age;
    }
    public String getLastName(){
        return this.lastName;
    }
    public  String getFirstName(){
        return this.firstName;
    }
    public int getAge(){
        return this.age;
    }

    @Override
    public String toString(){
        return "Людина " + getLastName() + " " + getFirstName() + ", вік: " + getAge();
    }
}

class Student extends Person {
    private String group;
    private String studentID;

    Student(String lastName, String firstName, int age, String group, String studentID) {
        super(lastName, firstName, age);
        this.group = group;
        this.studentID = studentID;
    }

    public String getGroup(){
        return group;
    }
    public String getStudentID(){
        return studentID;
    }

    public void setGroup(String group){
        this.group = group;
    }
    public void setStudentID(String studentID){
        this.studentID = studentID;
    }

    @Override
    public String toString(){
        return "Студент групи " + getGroup() + ", " + getLastName() + " " + getFirstName() + ", вік: " + getAge()
        + ". Номер студентського квитка: " + getStudentID();
    }
}

class Lecturer extends Person{
    private String department;
    private double salary;

    public Lecturer(String lastName, String firstName, int age, String department, double salary) {
        super(lastName, firstName, age);
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment(){
        return department;
    }

    public double getSalary(){
        return salary;
    }

    public void setDepartment(String department){
        this.department = department;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Викладач кафедри " + getDepartment() + ", " + getLastName() + " " + getFirstName() + ", вік: " + getAge()
                + ". Зарплата: " + getSalary();
    }
}