package Entity;

public class Staff extends Employee {

    public Staff() {
    }

    public Staff(int id, String name, int age, String address, double baseSalary, String position, String departmentId,
            double salary) {
        super(id, name, age, address, baseSalary, position, departmentId, salary);

    }

    @Override
    public double calculateSalary() {
        return getBaseSalary();
    }

    @Override
    public Employee inputInformation() {
        super.inputInformation();
        return new Staff(getId(), getName(), getAge(), getAddress(), getBaseSalary(), "Staff", getDepartmentId(),
                calculateSalary());
    }
}
