package ru.gb.course1.l6_recycler;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final ArrayList<EmployeeEntity> employeeList = new ArrayList<>();
    private LinearLayout listLinearLayout;

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

    private static int getPosByItem(ArrayList<EmployeeEntity> employeeList, EmployeeEntity employeeEntity) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeEntity.getId().equals(employeeList.get(i).getId())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = getLayoutInflater().inflate(R.layout.activity_main, null);
        setContentView(rootView);

        employeeList.addAll(createDummyEmployeesData());

        listLinearLayout = findViewById(R.id.list_linear_layout);

        refreshList();
    }

    private void refreshList() {
        listLinearLayout.removeAllViews();

        Button button = ListViewUtils.createButtonView(this, v -> {
            refreshList();
        });
        listLinearLayout.addView(button);
        for (EmployeeEntity employeeEntity : employeeList) {
            View employeeItemView = ListViewUtils.createItemView(getLayoutInflater(), listLinearLayout, employeeEntity, v -> {
                int deletedPosition = getPosByItem(employeeList, employeeEntity);
                listLinearLayout.removeViewAt(deletedPosition + 1);
                employeeList.remove(deletedPosition);
            });
            listLinearLayout.addView(employeeItemView);
        }
    }
}