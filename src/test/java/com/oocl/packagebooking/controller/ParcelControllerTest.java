package com.oocl.packagebooking.controller;

import com.google.gson.Gson;

import com.oocl.packagebooking.model.Parcel;
import com.oocl.packagebooking.serveice.ParcelService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.AutoConfigureDataNeo4j;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ParcelControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ParcelService parcelService;

    @Test
    void should_return_the_Parcel_when_create_a_Parcel() throws Exception {
        Gson gson = new Gson();
        Parcel parcel = new Parcel("Laura","15342217675","已预约","2019/7/25");
        parcel.setOrderId(23213);
        String result=gson.toJson(parcel);
        when(parcelService.createParcel(parcel)).thenReturn(parcel);
        mockMvc.perform(post("/parcels").contentType(MediaType.APPLICATION_JSON).content(result))
                .andExpect(status().isOk());
    }
    @Test
    void should_return_the_Parcel_List_when_find_all_Parcels() throws Exception {
        List<Parcel> parcels= new ArrayList<>();
        parcels.add( new Parcel("Laura","15342217675","未预约","2019/7/25"));
        parcels.add( new Parcel("Laura","15342217675","未预约","2019/7/26"));
        given(parcelService.getAllParcels()).willReturn(parcels);

        mockMvc.perform(get("/parcels"))
                .andExpect(status().isOk())
                .andExpect(content().json(new Gson().toJson(parcels,List.class)));
    }
    @Test
    void should_return_the_Parcel_List_when_find_Parcels_by_Status() throws Exception {
        List<Parcel> parcels = new ArrayList<>();
        parcels.add( new Parcel("Laura","15342217675","未预约","2019/7/25"));
        parcels.add( new Parcel("Laura","15342217675","已预约","2019/7/25"));
        parcels.add( new Parcel("Laura","15342217675","已取件","2019/7/26"));
        List<Parcel> returnParcels=parcels.stream().filter(parcel -> parcel.getStatus().equals("已预约")).collect(Collectors.toList());
        given(parcelService.getParcelsByStatus("已预约")).willReturn(returnParcels);

        mockMvc.perform(get("/parcels")
                .param("status", "已预约")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(new Gson().toJson(returnParcels,List.class)));
    }
    @Test
    void should_return_the_newParcelwhen_update_Parcel_status_by_Id() throws Exception {
        Gson gson = new Gson();
        Parcel oldParcel=new Parcel("Laura","15342217675","未预约","2019/7/25");
        Parcel newParcel=new Parcel("Laura","15342217675","已取件","2019/7/25");
        oldParcel.setOrderId(1);

        String result=gson.toJson(newParcel);
        parcelService.createParcel(oldParcel);
        given(parcelService.UpdateParcelStatusById(anyInt(),any(Parcel.class))).willReturn(newParcel);

        mockMvc.perform(put("/parcels/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(newParcel)))
                .andExpect(status().isOk()).andExpect(content().json(gson.toJson(newParcel)));
    }


}