package com.oocl.packagebooking.serveice;

import com.oocl.packagebooking.model.Parcel;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public interface ParcelService {
    public Parcel createParcel(Parcel parcel);
    public List<Parcel>getAllParcels();
    public List<Parcel>getParcelsByStatus(String status);
    public Parcel UpdateParcelById(int Id,Parcel parcel) throws Exception;
}
