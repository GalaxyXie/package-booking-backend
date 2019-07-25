package com.oocl.packagebooking.serveice.impl;


import com.oocl.packagebooking.model.Parcel;
import com.oocl.packagebooking.repository.ParcelRepository;
import com.oocl.packagebooking.serveice.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService {
    @Autowired
    ParcelRepository parcelRepository;
    public Parcel createParcel(Parcel parcel){
        return parcelRepository.save(parcel);
    }

}
