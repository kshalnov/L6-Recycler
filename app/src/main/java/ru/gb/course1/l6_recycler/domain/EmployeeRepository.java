package ru.gb.course1.l6_recycler.domain;

import java.util.List;

public interface EmployeeRepository {
    List<EmployeeEntity> getEmployees();

    void deleteEmployee(EmployeeEntity employeeEntity);
}
