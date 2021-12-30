package ru.gb.course1.l6_recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private final TextView nameTextView = itemView.findViewById(R.id.name_text_view);
    private final TextView surnameTextView = itemView.findViewById(R.id.surname_text_view);
    private final TextView positionTextView = itemView.findViewById(R.id.position_text_view);
    private final Button deleteButton = itemView.findViewById(R.id.delete_button);

    private OnEmployeeListener onEmployeeListener;

    public EmployeeViewHolder(
            @NonNull LayoutInflater inflater,
            @NonNull ViewGroup parent,
            OnEmployeeListener onEmployeeListener
    ) {
        super(inflater.inflate(R.layout.item_employee, parent, false));
        this.onEmployeeListener = onEmployeeListener;
    }

    public void bind(EmployeeEntity employee) {
        deleteButton.setOnClickListener(v -> onEmployeeListener.onDeleteEmployee(employee));
        itemView.setOnClickListener(v -> onEmployeeListener.onClickEmployee(employee));

        nameTextView.setText(employee.getName());
        surnameTextView.setText(employee.getSurname());
        positionTextView.setText(employee.getPosition());
    }
}