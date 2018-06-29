package com.granulator.controller;

import com.granulator.entity.DataPrescriptionDetailEntity;
import com.granulator.entity.DataPrescriptionEntity;
import com.granulator.service.DataPrescriptionService;
import com.granulator.util.MsgStatus;
import com.granulator.util.StringData;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Future
 */
@Controller
@RequestMapping("/test")
public class PrescriptionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PrescriptionController.class);

    @Autowired
    protected DataPrescriptionService dataPrescriptionService;

    /**
     * 查询处方列表
     *
     * @return
     */
    @RequestMapping(value = "/getDataPrescriptionList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getDataPrescriptionList(String s) {
        StringData<DataPrescriptionEntity> stringData = new StringData<DataPrescriptionEntity>();
        LOGGER.info("访问开始了！！");
        List<DataPrescriptionEntity> dataPrescriptionEntityList = dataPrescriptionService.getDataPrescriptionList();
        stringData.setCode(MsgStatus.SUCCESS);
        stringData.setData(dataPrescriptionEntityList);
        try {
            String result = JSONObject.fromObject(stringData).toString();
            URLEncoder.encode(result, "utf-8");
            LOGGER.info("访问成功了！！");
            return URLDecoder.decode(result, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            stringData.setCode(MsgStatus.FAILURE);
            stringData.setData(null);
        }
        return JSONObject.fromObject(stringData).toString();
    }

    /**
     * 增加处方数据
     */
    @RequestMapping(value = "/saveDataPrescription", method = RequestMethod.POST)
    public String saveDataPrescription(@RequestBody String dataPrescriptionEntity, String ID) {
        JSONObject jsonObject = JSONObject.fromObject(dataPrescriptionEntity);
        System.out.println(jsonObject);
        int save = dataPrescriptionService.saveDataPrescription(null);
        return "test";
    }

    /**
     * 查询处方明细列表
     *
     * @return
     */
    @RequestMapping(value = "/getDataPrescriptionDetailList", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getDataPrescriptionDetailList(String s) {
        StringData<DataPrescriptionDetailEntity> stringData = new StringData<DataPrescriptionDetailEntity>();
        LOGGER.info("访问开始了！！");
        List<DataPrescriptionDetailEntity> dataPrescriptionDetailList = dataPrescriptionService.getDataPrescriptionDetailList();
        stringData.setCode(MsgStatus.SUCCESS);
        stringData.setData(dataPrescriptionDetailList);
        String result = JSONObject.fromObject(stringData).toString();

        try {
            URLEncoder.encode(result, "utf-8");
            LOGGER.info("访问成功了！！");
            return URLDecoder.decode(result, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            stringData.setCode(MsgStatus.FAILURE);
            stringData.setData(null);
        }
        return JSONObject.fromObject(stringData).toString();
    }

    /**
     * 增加处方明细数据
     */
    @RequestMapping(value = "/saveDataPrescriptionDetail")
    public String saveDataPrescriptionDetail() {
        List<DataPrescriptionDetailEntity> dataPrescriptionDetailEntityList = new ArrayList<DataPrescriptionDetailEntity>();
        int save = dataPrescriptionService.saveDataPrescriptionDetail(dataPrescriptionDetailEntityList);
        System.out.println(save);
        return "test";
    }
}
