package ru.gb.course1.l6_recycler;

import android.app.Application;
import android.content.Context;

import ru.gb.course1.l6_recycler.data.CacheEmployeeRepositoryImpl;
import ru.gb.course1.l6_recycler.domain.EmployeeRepository;

public class App extends Application {
    private EmployeeRepository employeeRepository = new CacheEmployeeRepositoryImpl();

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public EmployeeRepository getEmployeeRepo() {
        return employeeRepository;
    }
}
