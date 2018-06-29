package com.granulator.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="DATA_PRESCRIPTION")
public class DataPrescriptionEntity implements Serializable{
    //自动编号
    private Integer AUTOID;
    //处方编号
    private String ID;
    //挂号单号
    private String REGISTER_ID;
    //患者姓名
    private String NAME;
    //患者性别
    private String SEX;
    //患者年龄
    private Integer AGE;
    private Integer AGEMONTHS;
    private Integer AGEDAYS;
    //电话
    private String TELE;
    //电邮
    private String EMAIL;
    //科室
    private String DEPARTMENT_NAME;
    //医生
    private String DOCTOR_NAME;
    //协定处方名称
    private String PRESCRIPTION_NAME;
    //开具处方时间
    private Date PRESCRIBE_TIME;
    //录入员
    private String CREATOR_NAME;
    //录入时间
    private Date CREATION_TIME;
    //划价单号
    private String VALUE_SN;
    //划价员名称
    private String VALUER_NAME;
    //划价时间
    private Date VALUATION_TIME;
    //每剂单价
    private Double PRICE;
    //剂数（袋数）
    private Float QUANTITY;
    //剂数（付数）
    private Float QUANTITY_DAY;
    //处方总价
    private Double PRICE_TOTAL;
    //支付方式
    private String PAYMENT_TYPE;
    //支付状态
    private String PAYMENT_STATUS;
    //处方数据来源
    private String DATA_SOURCE;
    //调剂设备
    private String DEVICE_ID;
    //处理状态
    private String PROCESS_STATUS;
    //说明
    private String DESCRIPTION;
    //调剂锁定标记
    private Integer LOCKED;

    private String PRESCRIPTION_TYPE;
    private String PATIENT_LOCATION;
    private Integer GRANULE_COUNT;

    private Integer ONEPRES_PACKAGES;

    private List<DataPrescriptionDetailEntity> dataPrescriptionDetailEntityList;

    public Integer getAUTOID() {
        return AUTOID;
    }

    public void setAUTOID(Integer AUTOID) {
        this.AUTOID = AUTOID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getREGISTER_ID() {
        return REGISTER_ID;
    }

    public void setREGISTER_ID(String REGISTER_ID) {
        this.REGISTER_ID = REGISTER_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSEX() {
        return SEX;
    }

    public void setSEX(String SEX) {
        this.SEX = SEX;
    }

    public Integer getAGE() {
        return AGE;
    }

    public void setAGE(Integer AGE) {
        this.AGE = AGE;
    }

    public Integer getAGEMONTHS() {
        return AGEMONTHS;
    }

    public void setAGEMONTHS(Integer AGEMONTHS) {
        this.AGEMONTHS = AGEMONTHS;
    }

    public Integer getAGEDAYS() {
        return AGEDAYS;
    }

    public void setAGEDAYS(Integer AGEDAYS) {
        this.AGEDAYS = AGEDAYS;
    }

    public String getTELE() {
        return TELE;
    }

    public void setTELE(String TELE) {
        this.TELE = TELE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getDEPARTMENT_NAME() {
        return DEPARTMENT_NAME;
    }

    public void setDEPARTMENT_NAME(String DEPARTMENT_NAME) {
        this.DEPARTMENT_NAME = DEPARTMENT_NAME;
    }

    public String getDOCTOR_NAME() {
        return DOCTOR_NAME;
    }

    public void setDOCTOR_NAME(String DOCTOR_NAME) {
        this.DOCTOR_NAME = DOCTOR_NAME;
    }

    public String getPRESCRIPTION_NAME() {
        return PRESCRIPTION_NAME;
    }

    public void setPRESCRIPTION_NAME(String PRESCRIPTION_NAME) {
        this.PRESCRIPTION_NAME = PRESCRIPTION_NAME;
    }

    public Date getPRESCRIBE_TIME() {
        return PRESCRIBE_TIME;
    }

    public void setPRESCRIBE_TIME(Date PRESCRIBE_TIME) {
        this.PRESCRIBE_TIME = PRESCRIBE_TIME;
    }

    public String getCREATOR_NAME() {
        return CREATOR_NAME;
    }

    public void setCREATOR_NAME(String CREATOR_NAME) {
        this.CREATOR_NAME = CREATOR_NAME;
    }

    public Date getCREATION_TIME() {
        return CREATION_TIME;
    }

    public void setCREATION_TIME(Date CREATION_TIME) {
        this.CREATION_TIME = CREATION_TIME;
    }

    public String getVALUE_SN() {
        return VALUE_SN;
    }

    public void setVALUE_SN(String VALUE_SN) {
        this.VALUE_SN = VALUE_SN;
    }

    public String getVALUER_NAME() {
        return VALUER_NAME;
    }

    public void setVALUER_NAME(String VALUER_NAME) {
        this.VALUER_NAME = VALUER_NAME;
    }

    public Date getVALUATION_TIME() {
        return VALUATION_TIME;
    }

    public void setVALUATION_TIME(Date VALUATION_TIME) {
        this.VALUATION_TIME = VALUATION_TIME;
    }

    public Double getPRICE() {
        return PRICE;
    }

    public void setPRICE(Double PRICE) {
        this.PRICE = PRICE;
    }

    public Float getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(Float QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public Float getQUANTITY_DAY() {
        return QUANTITY_DAY;
    }

    public void setQUANTITY_DAY(Float QUANTITY_DAY) {
        this.QUANTITY_DAY = QUANTITY_DAY;
    }

    public Double getPRICE_TOTAL() {
        return PRICE_TOTAL;
    }

    public void setPRICE_TOTAL(Double PRICE_TOTAL) {
        this.PRICE_TOTAL = PRICE_TOTAL;
    }

    public String getPAYMENT_TYPE() {
        return PAYMENT_TYPE;
    }

    public void setPAYMENT_TYPE(String PAYMENT_TYPE) {
        this.PAYMENT_TYPE = PAYMENT_TYPE;
    }

    public String getPAYMENT_STATUS() {
        return PAYMENT_STATUS;
    }

    public void setPAYMENT_STATUS(String PAYMENT_STATUS) {
        this.PAYMENT_STATUS = PAYMENT_STATUS;
    }

    public String getDATA_SOURCE() {
        return DATA_SOURCE;
    }

    public void setDATA_SOURCE(String DATA_SOURCE) {
        this.DATA_SOURCE = DATA_SOURCE;
    }

    public String getDEVICE_ID() {
        return DEVICE_ID;
    }

    public void setDEVICE_ID(String DEVICE_ID) {
        this.DEVICE_ID = DEVICE_ID;
    }

    public String getPROCESS_STATUS() {
        return PROCESS_STATUS;
    }

    public void setPROCESS_STATUS(String PROCESS_STATUS) {
        this.PROCESS_STATUS = PROCESS_STATUS;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public Integer getLOCKED() {
        return LOCKED;
    }

    public void setLOCKED(Integer LOCKED) {
        this.LOCKED = LOCKED;
    }

    public String getPRESCRIPTION_TYPE() {
        return PRESCRIPTION_TYPE;
    }

    public void setPRESCRIPTION_TYPE(String PRESCRIPTION_TYPE) {
        this.PRESCRIPTION_TYPE = PRESCRIPTION_TYPE;
    }

    public String getPATIENT_LOCATION() {
        return PATIENT_LOCATION;
    }

    public void setPATIENT_LOCATION(String PATIENT_LOCATION) {
        this.PATIENT_LOCATION = PATIENT_LOCATION;
    }

    public Integer getGRANULE_COUNT() {
        return GRANULE_COUNT;
    }

    public void setGRANULE_COUNT(Integer GRANULE_COUNT) {
        this.GRANULE_COUNT = GRANULE_COUNT;
    }

    public Integer getONEPRES_PACKAGES() {
        return ONEPRES_PACKAGES;
    }

    public void setONEPRES_PACKAGES(Integer ONEPRES_PACKAGES) {
        this.ONEPRES_PACKAGES = ONEPRES_PACKAGES;
    }

    public List<DataPrescriptionDetailEntity> getDataPrescriptionDetailEntityList() {
        return dataPrescriptionDetailEntityList;
    }

    public void setDataPrescriptionDetailEntityList(List<DataPrescriptionDetailEntity> dataPrescriptionDetailEntityList) {
        this.dataPrescriptionDetailEntityList = dataPrescriptionDetailEntityList;
    }
}
