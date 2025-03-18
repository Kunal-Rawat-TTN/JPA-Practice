package com.example.demo.Models.Development;

import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
public class ProgrammerId implements Serializable {
    private Long nsrId;
    private Long pId;

    public ProgrammerId(Long nsrId,Long pId)
    {
            this.nsrId=nsrId;
            this.pId=pId;
    }
}
