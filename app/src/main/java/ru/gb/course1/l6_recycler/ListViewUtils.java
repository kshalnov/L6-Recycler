package ru.gb.course1.l6_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ListViewUtils {

    static Button createButtonView(Context context, View.OnClickListener onClickListener) {
        Button button = new Button(context);
        button.setText("Refresh");
        button.setOnClickListener(onClickListener);
        return button;
    }

    static View createItemView(LayoutInflater layoutInflater, ViewGroup parent, EmployeeEntity employeeEntity, View.OnClickListener onDeleteClickListener) {
        final View employeeItemView = layoutInflater.inflate(R.layout.item_employee, parent, false);

        final TextView nameTextView = employeeItemView.findViewById(R.id.name_text_view);
        final TextView surnameTextView = employeeItemView.findViewById(R.id.surname_text_view);
        final TextView positionTextView = employeeItemView.findViewById(R.id.position_text_view);
        final Button deleteButton = employeeItemView.findViewById(R.id.delete_button);

        nameTextView.setText(employeeEntity.getName());
        surnameTextView.setText(employeeEntity.getSurname());
        positionTextView.setText(employeeEntity.getPosition());

        deleteButton.setOnClickListener(onDeleteClickListener);

        return employeeItemView;
    }

}
