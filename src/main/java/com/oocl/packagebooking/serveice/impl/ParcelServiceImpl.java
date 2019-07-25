package com.oocl.packagebooking.serveice.impl;


import com.oocl.packagebooking.model.Parcel;
import com.oocl.packagebooking.repository.ParcelRepository;
import com.oocl.packagebooking.serveice.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParcelServiceImpl implements ParcelService {
    @Autowired
    ParcelRepository parcelRepository;
    public Parcel createParcel(Parcel parcel){
        return parcelRepository.save(parcel);
    }
    public List<Parcel> getAllParcels(){
        return parcelRepository.findAll();
    }
    public List<Parcel>getParcelsByStatus(String status){
        return parcelRepository.findParcelsByStatus(status);
    }
    public Parcel UpdateParcelStatusById(int Id,Parcel parcel){
        Parcel oldParcel=parcelRepository.findById(Id).orElse(null);
        oldParcel.setStatus(parcel.getStatus());
        parcelRepository.save(oldParcel);
        return oldParcel;

    }

}
