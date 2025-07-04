package Impl;

import Entity.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Interface.EmployeeManagament;

public class EmloyeeManagementImpl implements EmployeeManagament {
    private List<Department> departments;
    private List<Employee> employees;
    private Scanner scanner;

    public EmloyeeManagementImpl() {
        this.departments = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("=== MENU ===");
        System.out.println("1. Thêm phòng ban");
        System.out.println("2. Cập nhật thông tin phòng ban");
        System.out.println("3. Thêm nhân viên (Staff, Phó phòng, Trưởng phòng)");
        System.out.println("4. Cập nhật thông tin nhân viên");
        System.out.println("5. Hiển thị danh sách phòng ban");
        System.out.println("6. Hiển thị danh sách nhân viên theo phòng ban");
        System.out.println("7. Hiển thị danh sách nhân viên toàn công ty");
        System.out.println("8. Hiển thị danh sách phó phòng, trưởng phòng");
        System.out.println("9. Tính tổng lương của từng phòng");
        System.out.println("10. Xóa nhân viên");
        System.out.println("11. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    @Override
    public void runMenu() {
        int choice;
        do {
            showMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
                choice = 0;
            }
            
            switch (choice) {
                case 1:
                    addDepartment();
                    break;
                case 2:
                    updateDepartment();
                    break;
                case 3:
                    addEmployee();
                    break;
                case 4:
                    updateEmployee();
                    break;
                case 5:
                    showAllDepartments();
                    break;
                case 6:
                    showEmployeesByDepartment();
                    break;
                case 7:
                    showAllEmployees();
                    break;
                case 8:
                    showManagersAndViceManagers();
                    break;
                case 9:
                    calculateTotalSalaryByDepartment();
                    break;
                case 10:
                    deleteEmployee();
                    break;
                case 11:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
            if (choice != 11) {
                System.out.println("\nNhấn Enter để tiếp tục...");
                scanner.nextLine();
            }
        } while (choice != 11);
    }

    @Override
    public void addDepartment() {
        System.out.println("=== THÊM PHÒNG BAN ===");
        System.out.print("Nhập mã phòng ban: ");
        String departmentId = scanner.nextLine();
        
        // Kiểm tra mã phòng ban đã tồn tại chưa
        if (findDepartmentById(departmentId) != null) {
            System.out.println("Mã phòng ban đã tồn tại!");
            return;
        }
        
        System.out.print("Nhập tên phòng ban: ");
        String departmentName = scanner.nextLine();
        System.out.print("Nhập địa chỉ phòng ban: ");
        String departmentAddress = scanner.nextLine();
        
        Department department = new Department(Integer.parseInt(departmentId), departmentName, departmentAddress);
        departments.add(department);
        System.out.println("Thêm phòng ban thành công!");
    }

    @Override
    public void updateDepartment() {
        System.out.println("=== CẬP NHẬT THÔNG TIN PHÒNG BAN ===");
        System.out.print("Nhập mã phòng ban cần cập nhật: ");
        String departmentId = scanner.nextLine();
        
        Department department = findDepartmentById(departmentId);
        if (department == null) {
            System.out.println("Không tìm thấy phòng ban với mã: " + departmentId);
            return;
        }
        
        System.out.print("Nhập tên phòng ban mới: ");
        String newName = scanner.nextLine();
        System.out.print("Nhập địa chỉ phòng ban mới: ");
        String newAddress = scanner.nextLine();
        
        department.setDepartmentName(newName);
        department.setDepartmentAddress(newAddress);
        System.out.println("Cập nhật phòng ban thành công!");
    }

    @Override
    public void showAllDepartments() {
        System.out.println("=== DANH SÁCH PHÒNG BAN ===");
        if (departments.isEmpty()) {
            System.out.println("Chưa có phòng ban nào!");
            return;
        }
        
        for (Department dept : departments) {
            System.out.println("Mã: " + dept.getDepartmentId());
            System.out.println("Tên: " + dept.getDepartmentName());
            System.out.println("Địa chỉ: " + dept.getDepartmentAddress());
            System.out.println("------------------------");
        }
    }

    @Override
    public void addEmployee() {
        System.out.println("=== THÊM NHÂN VIÊN ===");
        System.out.println("Chọn loại nhân viên:");
        System.out.println("1. Staff");
        System.out.println("2. Phó phòng (Vice Manager)");
        System.out.println("3. Trưởng phòng (Manager)");
        System.out.print("Chọn: ");
        
        int employeeType;
        try {
            employeeType = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số!");
            return;
        }
        
        System.out.print("Nhập mã nhân viên: ");
        int employeeId;
        try {
            employeeId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Mã nhân viên phải là số!");
            return;
        }
        
        // Kiểm tra mã nhân viên đã tồn tại chưa
        if (findEmployeeById(employeeId) != null) {
            System.out.println("Mã nhân viên đã tồn tại!");
            return;
        }
        
        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Tuổi phải là số!");
            return;
        }
        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.print("Nhập lương cơ bản: ");
        double baseSalary;
        try {
            baseSalary = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lương phải là số!");
            return;
        }
        System.out.print("Nhập mã phòng ban: ");
        String departmentId = scanner.nextLine();
        
        // Kiểm tra phòng ban có tồn tại không
        if (findDepartmentById(departmentId) == null) {
            System.out.println("Phòng ban không tồn tại!");
            return;
        }
        
        Employee employee = null;
        switch (employeeType) {
            case 1:
                employee = new Staff(employeeId, name, age, address, baseSalary, "Staff", departmentId, 0);
                break;
            case 2:
                employee = new ViceManager(employeeId, name, age, address, baseSalary, "ViceManager", departmentId, 0);
                break;
            case 3:
                employee = new Manager(employeeId, name, age, address, baseSalary, "Manager", departmentId, 0);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ!");
                return;
        }
        
        employee.setSalary(employee.calculateSalary());
        employees.add(employee);
        System.out.println("Thêm nhân viên thành công!");
    }

    @Override
    public void updateEmployee() {
        System.out.println("=== CẬP NHẬT THÔNG TIN NHÂN VIÊN ===");
        System.out.print("Nhập mã nhân viên cần cập nhật: ");
        int employeeId;
        try {
            employeeId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Mã nhân viên phải là số!");
            return;
        }
        
        Employee employee = findEmployeeById(employeeId);
        if (employee == null) {
            System.out.println("Không tìm thấy nhân viên với mã: " + employeeId);
            return;
        }
        
        System.out.print("Nhập tên mới: ");
        String newName = scanner.nextLine();
        System.out.print("Nhập tuổi mới: ");
        int newAge;
        try {
            newAge = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Tuổi phải là số!");
            return;
        }
        System.out.print("Nhập địa chỉ mới: ");
        String newAddress = scanner.nextLine();
        System.out.print("Nhập lương cơ bản mới: ");
        double newBaseSalary;
        try {
            newBaseSalary = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Lương phải là số!");
            return;
        }
        System.out.print("Nhập mã phòng ban mới: ");
        String newDepartmentId = scanner.nextLine();
        
        // Kiểm tra phòng ban có tồn tại không
        if (findDepartmentById(newDepartmentId) == null) {
            System.out.println("Phòng ban không tồn tại!");
            return;
        }
        
        employee.setName(newName);
        employee.setAge(newAge);
        employee.setAddress(newAddress);
        employee.setBaseSalary(newBaseSalary);
        employee.setDepartmentId(newDepartmentId);
        employee.setSalary(employee.calculateSalary());
        
        System.out.println("Cập nhật nhân viên thành công!");
    }

    @Override
    public void showEmployee() {
        showAllEmployees();
    }

    @Override
    public void showAllEmployees() {
        System.out.println("=== DANH SÁCH NHÂN VIÊN TOÀN CÔNG TY ===");
        if (employees.isEmpty()) {
            System.out.println("Chưa có nhân viên nào!");
            return;
        }
        
        for (Employee emp : employees) {
            emp.showInfo();
            System.out.println("------------------------");
        }
    }

    @Override
    public void showEmployeesByDepartment() {
        System.out.println("=== DANH SÁCH NHÂN VIÊN THEO PHÒNG BAN ===");
        System.out.print("Nhập mã phòng ban: ");
        String departmentId = scanner.nextLine();
        
        Department department = findDepartmentById(departmentId);
        if (department == null) {
            System.out.println("Không tìm thấy phòng ban!");
            return;
        }
        
        System.out.println("Phòng ban: " + department.getDepartmentName());
        System.out.println("Danh sách nhân viên:");
        
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getDepartmentId().equals(departmentId)) {
                emp.showInfo();
                System.out.println("------------------------");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Không có nhân viên nào trong phòng ban này!");
        }
    }

    @Override
    public void showManagersAndViceManagers() {
        System.out.println("=== DANH SÁCH PHÓ PHÒNG VÀ TRƯỞNG PHÒNG ===");
        boolean found = false;
        
        for (Employee emp : employees) {
            if (emp.getPosition().equals("Manager") || emp.getPosition().equals("ViceManager")) {
                emp.showInfo();
                System.out.println("------------------------");
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("Không có phó phòng hoặc trưởng phòng nào!");
        }
    }

    @Override
    public void calculateTotalSalaryByDepartment() {
        System.out.println("=== TỔNG LƯƠNG THEO TỪNG PHÒNG ===");
        
        if (departments.isEmpty()) {
            System.out.println("Chưa có phòng ban nào!");
            return;
        }
        
        for (Department dept : departments) {
            double totalSalary = 0;
            int employeeCount = 0;
            
            for (Employee emp : employees) {
                if (emp.getDepartmentId().equals(dept.getDepartmentId())) {
                    totalSalary += emp.getSalary();
                    employeeCount++;
                }
            }
            
            System.out.println("Phòng ban: " + dept.getDepartmentName() + " (" + dept.getDepartmentId() + ")");
            System.out.println("Số nhân viên: " + employeeCount);
            System.out.println("Tổng lương: " + String.format("%,.0f", totalSalary) + " VNĐ");
            System.out.println("------------------------");
        }
    }

    @Override
    public void deleteEmployee() {
        System.out.println("=== XÓA NHÂN VIÊN ===");
        System.out.print("Nhập mã nhân viên cần xóa: ");
        int employeeId;
        try {
            employeeId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Mã nhân viên phải là số!");
            return;
        }
        
        Employee employee = findEmployeeById(employeeId);
        if (employee == null) {
            System.out.println("Không tìm thấy nhân viên!");
            return;
        }
        
        employees.remove(employee);
        System.out.println("Xóa nhân viên thành công!");
    }

    // Các phương thức hỗ trợ
    private Department findDepartmentById(String departmentId) {
        for (Department dept : departments) {
            if (dept.getDepartmentId() == Integer.parseInt(departmentId)) {
                return dept;
            }
        }
        return null;
    }

    private Employee findEmployeeById(int employeeId) {
        for (Employee emp : employees) {
            if (emp.getId() == employeeId) {
                return emp;
            }
        }
        return null;
    }
}
