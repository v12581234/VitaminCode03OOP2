package Entity;

public  class Manager extends Employee{
    public Manager() {
    }

    public Manager(int id, String name, int age, String address, double baseSalary, String position, String departmentId,double salary) {
        super(id, name, age, address, baseSalary, position, departmentId,salary);
    }

    @Override
    public double calculateSalary(){
        return (getBaseSalary() + 5000000);
        
    }
    @Override
public  Employee inputInformation(){
    super.inputInformation();
    return new Manager(getId(), getName(), getAge(), getAddress(), getBaseSalary(),"Manager", getDepartmentId(),calculateSalary());
}
}
