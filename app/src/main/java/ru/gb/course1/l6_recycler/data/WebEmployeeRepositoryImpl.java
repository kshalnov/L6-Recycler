package ru.gb.course1.l6_recycler.data;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.l6_recycler.domain.EmployeeEntity;
import ru.gb.course1.l6_recycler.domain.EmployeeRepository;

public class WebEmployeeRepositoryImpl implements EmployeeRepository {

    // todo Здесь надо получать данные из интернета

    @Override
    public List<EmployeeEntity> getEmployees() {
        return new ArrayList<>();
    }

    @Override
    public void deleteEmployee(EmployeeEntity employeeEntity) {
        // todo ignore
    }
}
