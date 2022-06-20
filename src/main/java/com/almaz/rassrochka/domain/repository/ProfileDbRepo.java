package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.domain.ProfileDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface ProfileDbRepo extends JpaRepository<ProfileDb, Long> {
    List<ProfileDb> findByFullNameIgnoreCaseContaining (String fullName);

    List<ProfileDb> findByPassportInnIgnoreCaseContaining (String passportInn);


    @Query(value = "SELECT p.id, p.full_name as fullName, p.phone as phone, d.device_model as deviceModel, d.device_price as devicePrice, " +
            "c.zero_payment as zeroPayment, mc.credit_id as creditId, mc.id as mcId, mc.count_month as countMonth, mc.debt as debt, mc.pay_date as payDate, " +
            "mc.status_type as StatusType, mc.\"comment\", c.salesman_login as salesmanLogin " +
            "FROM azamat.profile p, azamat.device d, azamat.credit c, azamat.month_credit mc " +
            "where p.id=d.profile_id " +
            "and c.device_id=d.id " +
            "and mc.credit_id=c.id " +
            "and mc.status_type ='EXPIRED' " +
            "order by mc.credit_id asc", nativeQuery = true)
    List<CallProfileDto> findCallProfile();

    @Query(value = "SELECT * from azamat.profile where registration_date between :start and :end " +
            "order by id desc", nativeQuery = true)
    List<ProfileDb> findAllByRegistrationDateBetween(@Param("start") LocalDateTime start,
                                                     @Param("end") LocalDateTime end);

}
