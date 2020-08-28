package com.bcaf.ivan.FinalProject.Entity;

import com.bcaf.ivan.FinalProject.Util.BusDao;
import org.springframework.beans.factory.annotation.Autowired;

public class TripExt extends Trip {

    private Bus bus;
    private Stop sourceStop;
    private Stop destinationStop;

    public TripExt() {
    }

    public TripExt(Trip t) {
        this.setAgencyId(t.getAgencyId());
        this.setBusId(t.getBusId());
        this.setCreatedDate(t.getCreatedDate());
        this.setDestStopId(t.getDestStopId());
        this.setFare(t.getFare());
        this.setId(t.getId());
        this.setJourneyTime(t.getJourneyTime());
        this.setSourceStopId(t.getSourceStopId());
        this.setUpdatedDate(t.getUpdatedDate());
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Stop getSourceStop() {
        return sourceStop;
    }

    public void setSourceStop(Stop sourceStop) {
        this.sourceStop = sourceStop;
    }

    public Stop getDestinationStop() {
        return destinationStop;
    }

    public void setDestinationStop(Stop destinationStop) {
        this.destinationStop = destinationStop;
    }
}
