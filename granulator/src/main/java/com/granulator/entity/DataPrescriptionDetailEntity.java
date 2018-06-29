package com.granulator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="DATA_PRESCRIPTION_DETAIL")
public class DataPrescriptionDetailEntity implements Serializable{
    //处方编号
    @Column(name ="ID")
    private String ID;
    //颗粒序号
    @Column(name ="NO")
    private Integer NO;
    //颗粒ID
    @Column(name ="REGISTER_ID")
    private String REGISTER_ID;
    //颗粒名称
    @Column(name ="GRANULE_NAME")
    private String GRANULE_NAME;
    //饮片剂量
    @Column(name ="DOSE_HERB")
    private BigDecimal DOSE_HERB;
    //当量
    @Column(name ="EQUIVALENT")
    private BigDecimal EQUIVALENT;
    //剂量
    @Column(name ="DOSE")
    private BigDecimal DOSE;
    //价格
    @Column(name ="PRICE")
    private BigDecimal PRICE;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Integer getNO() {
        return NO;
    }

    public void setNO(Integer NO) {
        this.NO = NO;
    }

    public String getREGISTER_ID() {
        return REGISTER_ID;
    }

    public void setREGISTER_ID(String REGISTER_ID) {
        this.REGISTER_ID = REGISTER_ID;
    }

    public String getGRANULE_NAME() {
        return GRANULE_NAME;
    }

    public void setGRANULE_NAME(String GRANULE_NAME) {
        this.GRANULE_NAME = GRANULE_NAME;
    }

    public BigDecimal getDOSE_HERB() {
        return DOSE_HERB;
    }

    public void setDOSE_HERB(BigDecimal DOSE_HERB) {
        this.DOSE_HERB = DOSE_HERB;
    }

    public BigDecimal getEQUIVALENT() {
        return EQUIVALENT;
    }

    public void setEQUIVALENT(BigDecimal EQUIVALENT) {
        this.EQUIVALENT = EQUIVALENT;
    }

    public BigDecimal getDOSE() {
        return DOSE;
    }

    public void setDOSE(BigDecimal DOSE) {
        this.DOSE = DOSE;
    }

    public BigDecimal getPRICE() {
        return PRICE;
    }

    public void setPRICE(BigDecimal PRICE) {
        this.PRICE = PRICE;
    }
}
