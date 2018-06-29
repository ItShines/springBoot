package com.granulator.controller;

import com.granulator.entity.DataPrescriptionEntity;
import com.granulator.util.HttpclientUtil;
import net.sf.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

public class TestControllerTest {

    @Test
    public void getDataPrescriptionList() {
    }

    @Test
    public void saveDataPrescription() {
        DataPrescriptionEntity dataPrescriptionEntity = new DataPrescriptionEntity();
        dataPrescriptionEntity.setAUTOID(null);
        dataPrescriptionEntity.setID("1");
        dataPrescriptionEntity.setREGISTER_ID("1");
        dataPrescriptionEntity.setNAME("张三");
        dataPrescriptionEntity.setSEX("男");
        dataPrescriptionEntity.setAGE(20);
        dataPrescriptionEntity.setAGEMONTHS(1);
        dataPrescriptionEntity.setAGEDAYS(1);
        dataPrescriptionEntity.setTELE("1999999999999");
        dataPrescriptionEntity.setEMAIL("12@163.com");
        dataPrescriptionEntity.setDEPARTMENT_NAME("内一科");
        dataPrescriptionEntity.setDOCTOR_NAME("张三丰");
        JSONObject jsonObject = JSONObject.fromObject(dataPrescriptionEntity);
        try {
            String send = HttpclientUtil.httpPost("http://localhost:8080/test/saveDataPrescription", jsonObject, "utf-8");
            System.out.println(send);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDataPrescriptionDetailList() {
    }

    @Test
    public void saveDataPrescriptionDetail() {
    }
}