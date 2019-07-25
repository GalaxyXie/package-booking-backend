package com.oocl.packagebooking.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table
public class Boss
{
    @Id
    @GeneratedValue
    private int Id;
    @OneToMany
    private List<Parcel> parcels;

    public Boss(int id, List<Parcel> parcels) {
        Id = id;
        this.parcels = parcels;
    }

    public Boss(List<Parcel> parcels) {
        this.parcels = parcels;
    }

    public List<Parcel> getParcels() {
        return parcels;
    }

    public void setParcels(List<Parcel> parcels) {
        this.parcels = parcels;
    }

}
