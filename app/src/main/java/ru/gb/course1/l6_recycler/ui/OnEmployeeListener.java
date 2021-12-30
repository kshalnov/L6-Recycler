package ru.gb.course1.l6_recycler.ui;

import ru.gb.course1.l6_recycler.domain.EmployeeEntity;

interface OnEmployeeListener {
    void onDeleteEmployee(EmployeeEntity employeeEntity);
    void onClickEmployee(EmployeeEntity employeeEntity);
}