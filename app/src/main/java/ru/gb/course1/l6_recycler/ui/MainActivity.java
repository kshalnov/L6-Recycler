package ru.gb.course1.l6_recycler.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ru.gb.course1.l6_recycler.App;
import ru.gb.course1.l6_recycler.R;
import ru.gb.course1.l6_recycler.domain.EmployeeEntity;
import ru.gb.course1.l6_recycler.domain.EmployeeRepository;

public class MainActivity extends AppCompatActivity implements OnEmployeeListener {
    private static final int EMPLOYEE_REQUEST_CODE = 42;

    private EmployeeRepository employeeRepository;

    private RecyclerView recyclerView;
    private EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeRepository = App.get(this).getEmployeeRepo();

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
        Intent intent = new Intent(this, EmployeeActivity.class);
        intent.putExtra(EmployeeActivity.EMPLOYEE_EXTRA_KEY, employeeEntity);
        startActivityForResult(intent, EMPLOYEE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EMPLOYEE_REQUEST_CODE && resultCode == RESULT_OK) {
            adapter.setData(employeeRepository.getEmployees());
        }
    }
}