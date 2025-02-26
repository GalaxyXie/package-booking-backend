package com.oocl.packagebooking.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Parcel {
    @Id
    private int orderId;
    private String customName;
    private String telephone;
    private String status;
    private String appointmentTime;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Parcel(String customName, String telephone, String status, String appointmentTime) {
        this.customName = customName;
        this.telephone = telephone;
        this.status = status;
        this.appointmentTime = appointmentTime;
    }

    public Parcel(String customName, String telephone, String status) {
        this.customName = customName;
        this.telephone = telephone;
        this.status = status;
    }

    public Parcel(int orderId, String customName, String telephone, String status, String appointmentTime) {
        this.orderId = orderId;
        this.customName = customName;
        this.telephone = telephone;
        this.status = status;
        this.appointmentTime = appointmentTime;
    }

    public Parcel() {
    }
}
