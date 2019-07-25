package com.oocl.packagebooking.serveice;

import com.oocl.packagebooking.model.Parcel;
import org.springframework.stereotype.Service;

@Service
public interface ParcelService {
    public Parcel createParcel(Parcel parcel);

}
