package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.Parcel;
import com.oocl.packagebooking.serveice.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParcelController {
    @Autowired
    private ParcelService parcelService;
    @PostMapping("/parcels")
    public ResponseEntity createParkingLost(@RequestBody Parcel parcel){
        return ResponseEntity.ok(parcelService.createParcel(parcel));
    }

}
