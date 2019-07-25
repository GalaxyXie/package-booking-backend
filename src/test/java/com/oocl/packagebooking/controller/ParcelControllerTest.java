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
    void should_return_the_parkingLot_when_create_a_ParkingLost() throws Exception {
        Gson gson = new Gson();
        Parcel parcel = new Parcel("Laura","15342217675","未取件","2019/7/25");
        parcel.setOrderId(23213);
        String result=gson.toJson(parcel);
        when(parcelService.createParcel(parcel)).thenReturn(parcel);
        mockMvc.perform(post("/parcels").contentType(MediaType.APPLICATION_JSON).content(result))
                .andExpect(status().isOk());
    }
}