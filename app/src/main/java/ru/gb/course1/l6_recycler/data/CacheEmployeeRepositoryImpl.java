package ru.gb.course1.l6_recycler.data;

import java.util.ArrayList;
import java.util.List;

import ru.gb.course1.l6_recycler.domain.EmployeeEntity;
import ru.gb.course1.l6_recycler.domain.EmployeeRepository;

public class CacheEmployeeRepositoryImpl implements EmployeeRepository {
    private final ArrayList<EmployeeEntity> cache = new ArrayList<>();

    public CacheEmployeeRepositoryImpl() {
        cache.addAll(createDummyEmployeesData());
    }

    private static ArrayList<EmployeeEntity> createDummyEmployeesData() {
        final ArrayList<EmployeeEntity> employeeEntities = new ArrayList<>();
        employeeEntities.add(new EmployeeEntity(
                "0",
                "Иван",
                "Иванов",
                "88005553535",
                500_000,
                "android developer"
        ));
        employeeEntities.add(new EmployeeEntity(
                "1",
                "Пётр",
                "Петров",
                "88005553535",
                400_000,
                "ios developer"
        ));
        employeeEntities.add(new EmployeeEntity(
                "2",
                "Сидр",
                "Сидоров",
                "88005553535",
                1_000_000,
                "Самый главный директор"
        ));
        employeeEntities.add(new EmployeeEntity(
                "3",
                "Мария",
                "Иванова",
                "88005553535",
                500_000,
                "PHP developer"
        ));
        employeeEntities.add(new EmployeeEntity(
                "4",
                "Юрий",
                "Юрьев",
                "88005553535",
                100_000,
                "Junior developer"
        ));
        employeeEntities.add(new EmployeeEntity(
                "5",
                "Игнат",
                "Игнатьев",
                "88005553535",
                300_000,
                "Designer"
        ));
        return employeeEntities;
    }

    @Override
    public List<EmployeeEntity> getEmployees() {
        return new ArrayList<>(cache);
    }

    @Override
    public void deleteEmployee(EmployeeEntity employeeEntity) {
        try {
            cache.remove(findPosition(employeeEntity));
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        }
    }

    private int findPosition(EmployeeEntity employeeEntity) {
        for (int i = 0; i < cache.size(); i++) {
            if (employeeEntity.getId().equals(cache.get(i).getId())) {
                return i;
            }
        }
        throw new IllegalArgumentException("Нет такого элемента, где нашёл?");
    }

}
