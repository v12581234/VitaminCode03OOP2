package Entity;

import java.util.Scanner;

public abstract class Employee {
    private int id;
    private String name;
    private int age;
    private String address;
    private double baseSalary;
    private String position;
    private String departmentId;
    private double salary;

    public static Scanner sc = new Scanner(System.in);

    public Employee() {
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(int id, String name, int age, String address, double baseSalary, String position, String departmentId,
            double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.baseSalary = baseSalary;
        this.position = position;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double calculateSalary();

    public void showInfo() {
        System.out.println("Nhân viên có id là: " + this.id);
        System.out.println("Nhân viên có name là: " + this.name);
        System.out.println("Nhân viên có age là: " + this.age);
        System.out.println("Nhân viên có address là: " + this.address);
        System.out.println("Nhân viên có baseSalary là: " + this.baseSalary);
        System.out.println("Nhân viên có position là: " + this.position);
        System.out.println("Nhân viên có departmentId là: " + this.departmentId);
        System.out.println("Lương: " + calculateSalary());
    }

    public Employee inputInformation() {

        System.out.println("Xin mời nhập id nhân viên: ");
        setId(Integer.parseInt(sc.nextLine()));

        System.out.println("Xin mời nhập tên nhân viên: ");
        setName(sc.nextLine());

        System.out.println("Xin mời nhập tuổi nhân viên: ");
        setAge(Integer.parseInt(sc.nextLine()));

        System.out.println("Xin mời nhập địa chỉ của nhân viên: ");
        setAddress(sc.nextLine());

        System.out.println("Xin mời nhập lương cơ bản của nhân viên: ");
        setBaseSalary(Double.parseDouble(sc.nextLine()));

        System.out.println("Xin mời nhập mã phòng ban của nhân viên: ");
        setDepartmentId(sc.nextLine());

        return null;
    }
}
