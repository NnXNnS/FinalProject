package com.bcaf.ivan.FinalProject.Controller;


import com.bcaf.ivan.FinalProject.Entity.Agency;
import com.bcaf.ivan.FinalProject.Entity.Bus;
import com.bcaf.ivan.FinalProject.Entity.Trip;
import com.bcaf.ivan.FinalProject.Entity.User;
import com.bcaf.ivan.FinalProject.Request.RegisterRequest;
import com.bcaf.ivan.FinalProject.Util.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusApiController {

    @Autowired
    private BusDao busDao;


    @Autowired
    private TripDao tripDao;
    @PostMapping("/getAllBus")
    public String getAllBus(HttpServletRequest request) throws JsonProcessingException {
        HttpSession session = request.getSession(true);
        String agencyId = (String) session.getAttribute("agencyId");
        List<Bus> listBus = busDao.findAllBusByAgencyId(agencyId);
        if (listBus == null)
            listBus = new LinkedList<>();
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(listBus);
        return rs;
    }


    @PostMapping("/getAllBusByAgencyId")
    public String getAllBusByAgencyId(String agencyId) throws JsonProcessingException {
        List<Bus> listBus = busDao.findAllBusByAgencyId(agencyId);
        if (listBus == null)
            listBus = new LinkedList<>();
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(listBus);
        return rs;
    }

    @PostMapping("/updateBusRec")
    public String updateBusRec(@RequestBody List<Bus> listBus) throws JsonProcessingException {
        for (Bus b : listBus) {
            b.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
            busDao.save(b);
        }
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(listBus);
        return rs;
    }

    @PostMapping("/updateBus")
    public String updateBus(@RequestBody Bus bus) throws JsonProcessingException {
        bus.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        busDao.save(bus);
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(bus);
        return rs;
    }
    @PostMapping("/addBus")
    public String addBus(@RequestBody List<Bus> listBus,HttpServletRequest request) throws JsonProcessingException {
        HttpSession session = request.getSession(true);
        String agencyId = (String) session.getAttribute("agencyId");
        for (Bus b : listBus) {
            b.setAgencyId(agencyId);
            b.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            busDao.save(b);
        }
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(listBus);
        return rs;
    }

    @PostMapping("/createBus")
    public String createBus(@RequestBody Bus bus) throws JsonProcessingException {
        bus.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        busDao.save(bus);
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(bus);
        return rs;
    }

    @PostMapping("/deleteBusRec")
    public String deleteBusRec(@RequestBody List<Bus> listBus) throws JsonProcessingException {
        for (Bus b : listBus) {
            busDao.delete(b);
        }
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(listBus);
        return rs;
    }

    @PostMapping("/deleteBus")
    public String deleteBus(@RequestBody Bus bus) throws JsonProcessingException {
        List<Trip> deletedTrip=tripDao.findAllByBusId(bus.getId());
        for (Trip t:deletedTrip) {
            tripDao.delete(t);
        }
        busDao.delete(bus);
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(bus);
        return rs;
    }


    @PostMapping("/getBusById")
    public String getBusById(String busId) throws JsonProcessingException {
        Bus bus = busDao.findById(busId).get();
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(bus);
        return rs;
    }
}
