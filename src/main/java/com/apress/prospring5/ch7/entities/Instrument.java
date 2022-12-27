package com.apress.prospring5.ch7.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "instrument")
public class Instrument implements Serializable {
    private Long instrumentId;

    @Id
    @Column(name = "INSTRUMENT_ID")
    public Long getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(Long instrumentId) {
        this.instrumentId = instrumentId;
    }

    @Override
    public String toString() {
        return "Instrument: " + getInstrumentId();
    }
}
