package com.almaz.rassrochka.service;

import com.almaz.rassrochka.domain.ProfileDb;
import com.almaz.rassrochka.domain.dto.CallActiveProfileDto;
import com.almaz.rassrochka.domain.dto.MainDashProfileDto;
import com.almaz.rassrochka.domain.dto.ProfileDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProfileService {

    List<ProfileDb> findAll();

    Optional<ProfileDb> findById(Long id);

    ProfileDb addProfiles(ProfileDto profileDto);

    List<ProfileDb> findByFullName(String fullName);

    List<ProfileDb> findByPassportInn(String passportInn);

    List<CallActiveProfileDto> findCallProfile();

    Optional<ProfileDb> editUserProfile(ProfileDb profileDb);

    List<ProfileDb> findProfileByPeriod(LocalDateTime start, LocalDateTime end);
    List<MainDashProfileDto> findProfileForDash(LocalDateTime start, LocalDateTime end);

    List<MainDashProfileDto> findProfileByFullName(String fullName);

    List<MainDashProfileDto> findProfileByDeviceImei(String deviceImei);

    List<MainDashProfileDto> findProfileByPassportInn(String passportInn);


}
