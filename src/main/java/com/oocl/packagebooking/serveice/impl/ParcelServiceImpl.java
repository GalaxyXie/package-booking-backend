package com.oocl.packagebooking.serveice.impl;


import com.oocl.packagebooking.model.Parcel;
import com.oocl.packagebooking.repository.ParcelRepository;
import com.oocl.packagebooking.serveice.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    public Parcel UpdateParcelById(int Id,Parcel parcel) throws Exception {
        if(parcelRepository.findById(Id).get().getStatus().equals("未预约")&&
                parcel.getStatus().equals("已预约")){
        if (validateTime(parcel.getAppointmentTime())){
                Parcel oldParcel=parcelRepository.findById(Id).orElse(null);
                oldParcel.setAppointmentTime(parcel.getAppointmentTime());
                parcelRepository.save(oldParcel);
                return oldParcel;
        } else{
                throw new Exception("您设定的时间不在营业范围内");
            }
        }else{
            Parcel oldParcel=parcelRepository.findById(Id).orElse(null);
            oldParcel.setStatus(parcel.getStatus());
            parcelRepository.save(oldParcel);
            return oldParcel;
        }

    }
    public boolean validateTime(String time) throws ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        cal.setTime(formatter.parse(time));

        if(cal.get(Calendar.HOUR)>=9&&cal.get(Calendar.HOUR)<=20)
        {
            return true;
        }else
            return false;

    }

}
