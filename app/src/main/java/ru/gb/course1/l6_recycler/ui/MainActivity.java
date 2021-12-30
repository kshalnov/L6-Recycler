package ru.gb.course1.l6_recycler.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ru.gb.course1.l6_recycler.domain.EmployeeEntity;
import ru.gb.course1.l6_recycler.R;

public class MainActivity extends AppCompatActivity implements OnEmployeeListener {
    private final ArrayList<EmployeeEntity> employeeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        employeeList.addAll(createDummyEmployeesData());

        initRecycler();
    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new EmployeeAdapter();
        adapter.setData(employeeList);
        adapter.setOnDeleteClickListener(this);

        recyclerView.setAdapter(adapter);
    }

    private int findPosition(EmployeeEntity employeeEntity) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeEntity.getId().equals(employeeList.get(i).getId())) {
                return i;
            }
        }
        throw new IllegalArgumentException("Нет такого элемента, где нашёл?");
    }

    @Override
    public void onDeleteEmployee(EmployeeEntity employeeEntity) {
        employeeList.remove(findPosition(employeeEntity));
        adapter.setData(employeeList);
    }

    @Override
    public void onClickEmployee(EmployeeEntity employeeEntity) {
        Toast.makeText(this, employeeEntity.getName(), Toast.LENGTH_SHORT).show();
    }
}