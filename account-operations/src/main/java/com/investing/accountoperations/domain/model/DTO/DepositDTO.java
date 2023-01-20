package com.investing.accountoperations.domain.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class DepositDTO {

    @JsonProperty("acc_to_deposit")
    private String accToDeposit;

    private BigDecimal value;
}
