package com.almaz.rassrochka.domain.repository;

import com.almaz.rassrochka.domain.ReportingDb;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReportingDbRepo extends JpaRepository<ReportingDb, Long> {

    @Query(value = "SELECT r.id, p.full_name as fullName, r.debt_report as debtReport, r.registration_date as registrationDate, " +
            "r.salesman_login as salesmanLogin \n" +
            "FROM azamat.report r, azamat.credit c, azamat.device d, azamat.profile p  \n" +
            "where c.device_id = d.id\n" +
            "and d.profile_id = p.id \n" +
            "and r.credit_id = c.device_id " +
            "and r.debt_report is not null and p.deleted is false " +
            "and r.registration_date between :start and :end " +
            "order by r.registration_date desc\n", nativeQuery = true)
    List<ReportRepoDto> findAllReportByDate(@Param("start") LocalDateTime start,
                                            @Param("end") LocalDateTime end);

    @Query(value = "SELECT r.id, p.full_name as fullName, r.debt_report as debtReport, r.registration_date as registrationDate, " +
            "r.salesman_login as salesmanLogin \n" +
            "FROM azamat.report r, azamat.credit c, azamat.device d, azamat.profile p  \n" +
            "where c.device_id = d.id\n" +
            "and d.profile_id = p.id and r.credit_id = c.device_id " +
            "and r.debt_report is not null and p.deleted is false " +
            "and r.registration_date between :start and :end " +
            "and r.salesman_login=:username " +
            "order by r.registration_date desc\n", nativeQuery = true)
    List<ReportRepoDto> findAllReportByDateAndUserName(@Param("start") LocalDateTime start,
                                                       @Param("end") LocalDateTime end,
                                                       @Param("username") String username);
}
