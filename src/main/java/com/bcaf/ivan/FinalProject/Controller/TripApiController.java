package com.bcaf.ivan.FinalProject.Controller;

import com.bcaf.ivan.FinalProject.Entity.*;
import com.bcaf.ivan.FinalProject.Util.AgencyDao;
import com.bcaf.ivan.FinalProject.Util.BusDao;
import com.bcaf.ivan.FinalProject.Util.StopDao;
import com.bcaf.ivan.FinalProject.Util.TripDao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/trip")
public class TripApiController {

    @Autowired
    private TripDao tripDao;
    @Autowired
    private BusDao busDao;
    @Autowired
    private StopDao stopDao;


    @PostMapping("/getAllTripRec")
    public String getAgency(HttpServletRequest request) throws JsonProcessingException {
        HttpSession session = request.getSession(true);
        String agencyId = (String) session.getAttribute("agencyId");
        List<Trip> listTrip = tripDao.findAllByAgencyId(agencyId);
        List<TripExt> tripExtList = new LinkedList<>();
        for (Trip t :listTrip) {
            TripExt newT = new TripExt(t);
            Bus bus = busDao.findById(newT.getBusId()).get();
            Stop sourceStop = stopDao.findById(newT.getSourceStopId()).get();
            Stop destinationStop = stopDao.findById(newT.getDestStopId()).get();
            newT.setBus(bus);
            newT.setSourceStop(sourceStop);
            newT.setDestinationStop(destinationStop);
            tripExtList.add(newT);
        }
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(tripExtList);
        return rs;
    }

    @PostMapping("/getAllTrip")
    public String getAllTrip(String agencyId) throws JsonProcessingException {
        List<Trip> listTrip = tripDao.findAllByAgencyId(agencyId);
        List<TripExt> tripExtList = new LinkedList<>();
        for (Trip t :listTrip) {
            TripExt newT = new TripExt(t);
            Bus bus = busDao.findById(newT.getBusId()).get();
            Stop sourceStop = stopDao.findById(newT.getSourceStopId()).get();
            Stop destinationStop = stopDao.findById(newT.getDestStopId()).get();
            newT.setBus(bus);
            newT.setSourceStop(sourceStop);
            newT.setDestinationStop(destinationStop);
            tripExtList.add(newT);
        }
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(tripExtList);
        return rs;
    }


    @PostMapping("/addTrip")
    public String addTrip(@RequestBody List<TripExt> listTrip, HttpServletRequest request) throws JsonProcessingException {
        HttpSession session = request.getSession(true);
        String agencyId = (String) session.getAttribute("agencyId");
        for (TripExt t : listTrip) {
            Trip newTrip=new Trip();
            newTrip.setAgencyId(agencyId);
            newTrip.setBusId(t.getBus().getId());
            newTrip.setCreatedDate(new Timestamp(System.currentTimeMillis()));
            newTrip.setDestStopId(t.getDestinationStop().getId());
            newTrip.setSourceStopId(t.getSourceStop().getId());
            newTrip.setFare(t.getFare());
            newTrip.setJourneyTime(t.getJourneyTime());
            tripDao.save(newTrip);
        }
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(listTrip);
        return rs;
    }

    @PostMapping("/updateTripRec")
    public String updateTripRec(@RequestBody List<TripExt> listTrip, HttpServletRequest request) throws JsonProcessingException {
        HttpSession session = request.getSession(true);
        String agencyId = (String) session.getAttribute("agencyId");
        for (TripExt t : listTrip) {
            Trip newT=tripDao.findById(t.getId()).get();
            newT.setFare(t.getFare());
            newT.setJourneyTime(t.getJourneyTime());
            newT.setBusId(t.getBus().getId());
            newT.setSourceStopId(t.getSourceStop().getId());
            newT.setDestStopId(t.getDestinationStop().getId());
            newT.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
            tripDao.save(newT);
        }
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(listTrip);
        return rs;
    }


    @PostMapping("/deleteTripRec")
    public String deleteTripRec(@RequestBody List<TripExt> listTrip) throws JsonProcessingException {
        for (TripExt t : listTrip) {
            tripDao.deleteById(t.getId());
        }
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(listTrip);
        return rs;
    }

    @PostMapping("/deleteTrip")
    public String deleteTrip(String tripId) throws JsonProcessingException {
        tripDao.deleteById(tripId);
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(tripId);
        return rs;
    }

    @PostMapping("/getTripById")
    public String getTripById(String tripId) throws JsonProcessingException {
        Trip t= tripDao.findById(tripId).get();
        TripExt newT = new TripExt(t);
        Bus bus = busDao.findById(newT.getBusId()).get();
        Stop sourceStop = stopDao.findById(newT.getSourceStopId()).get();
        Stop destinationStop = stopDao.findById(newT.getDestStopId()).get();
        newT.setBus(bus);
        newT.setSourceStop(sourceStop);
        newT.setDestinationStop(destinationStop);
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(newT);
        return rs;
    }


    @PostMapping("/createTrip")
    public String createTrip(@RequestBody TripExt trip) throws JsonProcessingException {
        Trip newTrip=new Trip();
        newTrip.setAgencyId(trip.getAgencyId());
        newTrip.setBusId(trip.getBus().getId());
        newTrip.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        newTrip.setDestStopId(trip.getDestinationStop().getId());
        newTrip.setSourceStopId(trip.getSourceStop().getId());
        newTrip.setFare(trip.getFare());
        newTrip.setJourneyTime(trip.getJourneyTime());
        tripDao.save(newTrip);
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(newTrip);
        return rs;
    }

    @PostMapping("/updateTrip")
    public String updateTrip(@RequestBody TripExt t) throws JsonProcessingException {
        Trip newT=tripDao.findById(t.getId()).get();
        newT.setFare(t.getFare());
        newT.setJourneyTime(t.getJourneyTime());
        newT.setBusId(t.getBus().getId());
        newT.setSourceStopId(t.getSourceStop().getId());
        newT.setDestStopId(t.getDestinationStop().getId());
        newT.setUpdatedDate(new Timestamp(System.currentTimeMillis()));
        tripDao.save(newT);
        ObjectMapper Obj = new ObjectMapper();
        String rs = Obj.writeValueAsString(newT);
        return rs;
    }
}