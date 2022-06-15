package com.almaz.rassrochka.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CreditDto {
    private Long id;
    private Integer zeroPayment;
    private Long deviceId;



}
