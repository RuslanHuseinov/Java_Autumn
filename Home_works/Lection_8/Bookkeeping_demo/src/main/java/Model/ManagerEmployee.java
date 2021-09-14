package Model;


import Interfaces.Department;
import Interfaces.Employee;
import Interfaces.Manager;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class ManagerEmployee implements Employee, Manager {
    private int ID;
    private String name;
    private LocalDate birthDate;
    private LocalDate hiringDate;
    private Department department;
    private List<Employee> managersEmployees = new LinkedList<>();

    @Override
    public int getId() {
        return ID;
    }
    @Override
    public void setName(String name) {
    this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setBirthDate(LocalDate date) {
        this.birthDate = date;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public void setHiringDate(LocalDate date) {
        this.hiringDate = date;
    }

    @Override
    public LocalDate getHiringDate() {
        return hiringDate;
    }

    @Override
    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public Department getDepartment() {
        return department;
    }

    @Override
    public long getManagerBonus() {
        long result = 0;
        result += getSalaryBonus();
        result += getManagersEmployees().size() * ((department.getFund() * 0.8) * 0.01);
        return result;
    }

    @Override
    public long getSalaryBonus() {
        long result = 0;
        LocalDate currentDate = LocalDate.now();
        if (this.getBirthDate().getMonth() == currentDate.getMonth()){
            result +=( department.getFund()/ department.getAllEmployeesList().size() * 0.8) * 0.01;
        }
        return result + getManagerBonus();
    }

    @Override
    public List<Employee> getManagersEmployees() {
        return managersEmployees;
    }

    @Override
    public boolean removeEmployeeFromManager(Employee employeeForFiring) {
       return managersEmployees.remove(employeeForFiring);
    }

    @Override
    public boolean addEmployeeToManager(Employee employeeForHiring) {
        return managersEmployees.add(employeeForHiring);
    }

    @Override
    public String toString() {
        StringBuilder result =  new StringBuilder(super.toString());
        result.append("Manager employees : " + managersEmployees);
        return result.toString();
    }
}
