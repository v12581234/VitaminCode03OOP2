package Entity;

public  class ViceManager extends  Employee{
    public ViceManager() {
    }

    public ViceManager(int id, String name, int age, String address, double baseSalary, String position, String departmentId,double salary) {
        super(id, name, age, address, baseSalary, position, departmentId,salary);
    }

    @Override
    public double calculateSalary(){
    return getBaseSalary()+3000000;
    }

    @Override
    public  Employee inputInformation(){
        super.inputInformation();
        return new ViceManager(getId(), getName(), getAge(), getAddress(), getBaseSalary(),"ViceManager", getDepartmentId(),calculateSalary());
    

}
}
