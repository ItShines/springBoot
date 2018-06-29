package com.granulator.service.impl;

import com.granulator.entity.DataPrescriptionDetailEntity;
import com.granulator.entity.DataPrescriptionEntity;
import com.granulator.service.DataPrescriptionService;
import com.granulator.util.SessionFactoryUtil;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Future
 */
@Service
public class DataPrescriptionServiceImpl implements DataPrescriptionService {

    /**
     * 查询处方列表 -- 不做生产使用
     * @return
     */
    @Override
    @Transactional
    public List<DataPrescriptionEntity> getDataPrescriptionList() {
        Session session = SessionFactoryUtil.getSession();
        session.beginTransaction();//开始事务
        String sql = "SELECT * FROM DATA_PRESCRIPTION";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        List list = sqlQuery.list();
        List<DataPrescriptionEntity> dataPrescriptionEntityList = new ArrayList<DataPrescriptionEntity>();
        for (int i = 0; i < list.size(); i++) {
            DataPrescriptionEntity dataPrescriptionEntity =new DataPrescriptionEntity();
            Object[] object = (Object[]) list.get(i);
            dataPrescriptionEntity.setAUTOID(Integer.valueOf( object[0].toString()));
            dataPrescriptionEntity.setID(object[1].toString());
            dataPrescriptionEntityList.add(dataPrescriptionEntity);
        }
        session.getTransaction().commit(); //事务提交
        return dataPrescriptionEntityList;
    }
    /**
     * 增加处方数据
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveDataPrescription(DataPrescriptionEntity dataPrescriptionEntity) {
        if(dataPrescriptionEntity == null){
            return 0;
        }
        Session session = SessionFactoryUtil.getSession();
        session.beginTransaction();//开始事务
        String sql = "INSERT INTO DATA_PRESCRIPTION(" +
                "AUTOID, ID, REGISTER_ID, NAME, SEX, AGE, AGEMONTHS, AGEDAYS, TELE, EMAIL, DEPARTMENT_NAME, DOCTOR_NAME, " +
                "PRESCRIPTION_NAME, PRESCRIBE_TIME, CREATOR_NAME, CREATION_TIME, VALUE_SN, VALUER_NAME, VALUATION_TIME, " +
                "PRICE, QUANTITY, QUANTITY_DAY, PRICE_TOTAL, PAYMENT_TYPE, PAYMENT_STATUS, DATA_SOURCE, DEVICE_ID, " +
                "PROCESS_STATUS, DESCRIPTION, LOCKED, PRESCRIPTION_TYPE, PATIENT_LOCATION, GRANULE_COUNT, ONEPRES_PACKAGES) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, )";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        sqlQuery.setInteger(0, dataPrescriptionEntity.getAUTOID());
        sqlQuery.setString(1, dataPrescriptionEntity.getID());
        sqlQuery.setString(2, dataPrescriptionEntity.getREGISTER_ID());
        sqlQuery.setString(3, dataPrescriptionEntity.getNAME());
        sqlQuery.setString(4, dataPrescriptionEntity.getSEX());
        sqlQuery.setInteger(5, dataPrescriptionEntity.getAGE());
        sqlQuery.setInteger(6,dataPrescriptionEntity.getAGEMONTHS());
        sqlQuery.setInteger(7,dataPrescriptionEntity.getAGEDAYS());
        sqlQuery.setString(8,dataPrescriptionEntity.getTELE());
        sqlQuery.setString(9,dataPrescriptionEntity.getEMAIL());
        sqlQuery.setString(10,dataPrescriptionEntity.getDEPARTMENT_NAME());
        sqlQuery.setString(11,dataPrescriptionEntity.getDOCTOR_NAME());
        sqlQuery.setString(12,dataPrescriptionEntity.getPRESCRIPTION_NAME());
        sqlQuery.setDate(13,dataPrescriptionEntity.getPRESCRIBE_TIME());
        sqlQuery.setString(14,dataPrescriptionEntity.getCREATOR_NAME());
        sqlQuery.setDate(15,dataPrescriptionEntity.getCREATION_TIME());
        sqlQuery.setString(16,dataPrescriptionEntity.getVALUE_SN());
        sqlQuery.setString(17,dataPrescriptionEntity.getVALUER_NAME());
        sqlQuery.setDate(18,dataPrescriptionEntity.getVALUATION_TIME());
        sqlQuery.setDouble(19,dataPrescriptionEntity.getPRICE());
        sqlQuery.setFloat(20,dataPrescriptionEntity.getQUANTITY());
        sqlQuery.setFloat(21,dataPrescriptionEntity.getQUANTITY_DAY());
        sqlQuery.setDouble(22,dataPrescriptionEntity.getPRICE_TOTAL());
        sqlQuery.setString(23,dataPrescriptionEntity.getPAYMENT_TYPE());
        sqlQuery.setString(24,dataPrescriptionEntity.getPAYMENT_STATUS());
        sqlQuery.setString(25,dataPrescriptionEntity.getDATA_SOURCE());
        sqlQuery.setString(26,dataPrescriptionEntity.getDEVICE_ID());
        sqlQuery.setString(27,dataPrescriptionEntity.getPROCESS_STATUS());
        sqlQuery.setString(28,dataPrescriptionEntity.getDESCRIPTION());
        sqlQuery.setInteger(29,dataPrescriptionEntity.getLOCKED());
        sqlQuery.setString(30,dataPrescriptionEntity.getPRESCRIPTION_TYPE());
        sqlQuery.setString(31,dataPrescriptionEntity.getPATIENT_LOCATION());
        sqlQuery.setInteger(32,dataPrescriptionEntity.getGRANULE_COUNT());
        sqlQuery.setInteger(33,dataPrescriptionEntity.getONEPRES_PACKAGES());
        int i = sqlQuery.executeUpdate();
        session.getTransaction().commit(); //事务提交
        if(i >0){
            int I = saveDataPrescriptionDetail(dataPrescriptionEntity.getDataPrescriptionDetailEntityList());
            if(I > 0){
                return I;
            }
        }
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    /**
     * 查询处方明细列表  -- 不做生产使用
     * @return
     */
    @Override
    public List<DataPrescriptionDetailEntity> getDataPrescriptionDetailList() {
        Session session = SessionFactoryUtil.getSession();
        session.beginTransaction();//开始事务
        String sql = "SELECT * from DATA_PRESCRIPTION_DETAIL";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        List list = sqlQuery.list();
        List<DataPrescriptionDetailEntity> prescriptionDetailList = new ArrayList<DataPrescriptionDetailEntity>();
        Object[] objects;
        BigDecimal bigDecimal;
        for (int i = 0; i < list.size(); i++) {
            DataPrescriptionDetailEntity prescriptionDetail = new DataPrescriptionDetailEntity();
            objects = (Object[]) list.get(i);
            if(objects == null ){
                continue;
            }
            prescriptionDetail.setID(objects[0] == null ? "" : objects[0].toString());
            prescriptionDetail.setNO(objects[1] == null ? i : Integer.valueOf(objects[1].toString()));
            prescriptionDetail.setREGISTER_ID(objects[2] == null ? "" : objects[2].toString());
            prescriptionDetail.setGRANULE_NAME(objects[3] == null ? "" : objects[3].toString());
            bigDecimal = new BigDecimal(objects[4] == null ? "0.00" : objects[4].toString());
            prescriptionDetail.setDOSE_HERB(bigDecimal);
            bigDecimal = new BigDecimal(objects[5] == null ? "0.00" : objects[5].toString());
            prescriptionDetail.setEQUIVALENT(bigDecimal);
            bigDecimal = new BigDecimal(objects[6] == null ? "0.00" : objects[6].toString());
            prescriptionDetail.setDOSE(bigDecimal);
            bigDecimal = new BigDecimal(objects[7] == null ? "0.00" : objects[7].toString());
            prescriptionDetail.setPRICE(bigDecimal);
            prescriptionDetailList.add(prescriptionDetail);
        }
        session.getTransaction().commit(); //事务提交
        return prescriptionDetailList;
    }

    /**
     * 增加处方明细
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveDataPrescriptionDetail(List<DataPrescriptionDetailEntity> dataPrescriptionDetailEntity) {
        Session session = SessionFactoryUtil.getSession();
        session.beginTransaction();//开始事务
        String sql = "INSERT INTO DATA_PRESCRIPTION_DETAIL(ID, \"NO\", GRANULE_ID, GRANULE_NAME, DOSE_HERB, EQUIVALENT, DOSE) VALUES ('I09', 3, 'ZY02000000', '蝉蜕', 1, 0, 0)";
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        int i = sqlQuery.executeUpdate();
        session.getTransaction().commit(); //事务提交
        return i;
    }
}
