package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.model.Parcel;
import com.oocl.packagebooking.serveice.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParcelController {
    @Autowired
    private ParcelService parcelService;
    @PostMapping("/parcels")
    public ResponseEntity createParcel(@RequestBody Parcel parcel){
        return ResponseEntity.ok(parcelService.createParcel(parcel));
    }
    @GetMapping("/parcels")
    public ResponseEntity getParcels(){
        return ResponseEntity.ok(parcelService.getAllParcels());
    }
    @GetMapping(value = "/parcels",params = {"status"})
    public ResponseEntity getParcelsByStatus(@RequestParam String status){
        return ResponseEntity.ok(parcelService.getParcelsByStatus(status));
    }
    @PutMapping("/parcels/{id}")
    public ResponseEntity updateParcelByOrderid(@PathVariable int id,@RequestBody Parcel parcel){
        return ResponseEntity.ok(parcelService.UpdateParcelStatusById(id, parcel));
    }

}
