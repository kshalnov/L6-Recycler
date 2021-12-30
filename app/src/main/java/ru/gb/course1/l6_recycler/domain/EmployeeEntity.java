package ru.gb.course1.l6_recycler.domain;

import android.os.Parcel;
import android.os.Parcelable;

// POJO
public class EmployeeEntity implements Parcelable {
    public static final Creator<EmployeeEntity> CREATOR = new Creator<EmployeeEntity>() {
        @Override
        public EmployeeEntity createFromParcel(Parcel in) {
            return new EmployeeEntity(in);
        }

        @Override
        public EmployeeEntity[] newArray(int size) {
            return new EmployeeEntity[size];
        }
    };
    private String id;
    private String name;
    private String surname;
    private String phoneNumber;
    private int salary;
    private String position;

    public EmployeeEntity() {

    }

    public EmployeeEntity(String id, String name, String surname, String phoneNumber, int salary, String position) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.position = position;
    }

    protected EmployeeEntity(Parcel in) {
        id = in.readString();
        name = in.readString();
        surname = in.readString();
        phoneNumber = in.readString();
        salary = in.readInt();
        position = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(surname);
        parcel.writeString(phoneNumber);
        parcel.writeInt(salary);
        parcel.writeString(position);
    }
}