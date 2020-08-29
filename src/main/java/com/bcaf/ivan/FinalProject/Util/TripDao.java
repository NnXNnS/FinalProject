package com.bcaf.ivan.FinalProject.Util;

import com.bcaf.ivan.FinalProject.Entity.Stop;
import com.bcaf.ivan.FinalProject.Entity.Trip;
import com.bcaf.ivan.FinalProject.Entity.TripExt;
import com.bcaf.ivan.FinalProject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripDao extends JpaRepository<Trip, String> {
    @Query(nativeQuery = true,value="SELECT t.* FROM tb_trip t WHERE t.agency_id =:agencyId ")
    List<Trip> findAllByAgencyId(@Param("agencyId") String agencyId);
}