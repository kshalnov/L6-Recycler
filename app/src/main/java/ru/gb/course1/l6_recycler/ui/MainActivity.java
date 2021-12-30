package ru.gb.course1.l6_recycler.ui;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.gb.course1.l6_recycler.R;
import ru.gb.course1.l6_recycler.data.CacheEmployeeRepositoryImpl;
import ru.gb.course1.l6_recycler.domain.EmployeeEntity;
import ru.gb.course1.l6_recycler.domain.EmployeeRepository;

public class MainActivity extends AppCompatActivity implements OnEmployeeListener {
    private final EmployeeRepository employeeRepository = new CacheEmployeeRepositoryImpl();

    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecycler();
    }

    private void initRecycler() {
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new EmployeeAdapter();
        adapter.setData(employeeRepository.getEmployees());
        adapter.setOnDeleteClickListener(this);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDeleteEmployee(EmployeeEntity employeeEntity) {
        employeeRepository.deleteEmployee(employeeEntity);
        adapter.setData(employeeRepository.getEmployees());
    }

    @Override
    public void onClickEmployee(EmployeeEntity employeeEntity) {
        Toast.makeText(this, employeeEntity.getName(), Toast.LENGTH_SHORT).show();
    }
}