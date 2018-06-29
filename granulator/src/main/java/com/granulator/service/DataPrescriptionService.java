package com.granulator.service;

import com.granulator.entity.DataPrescriptionDetailEntity;
import com.granulator.entity.DataPrescriptionEntity;

import java.util.List;

/**
 * @author Future
 */
public interface DataPrescriptionService {
    /**
     * 查询处方列表
     * @return
     */
    List<DataPrescriptionEntity> getDataPrescriptionList();

    /**
     * 增加处方数据
     */
    int saveDataPrescription(DataPrescriptionEntity dataPrescriptionEntity);

    /**
     * 查询处方明细列表
     * @return
     */
    List<DataPrescriptionDetailEntity> getDataPrescriptionDetailList();

    /**
     * 增加处方明细数据
     */
    int saveDataPrescriptionDetail(List<DataPrescriptionDetailEntity> dataPrescriptionDetailEntity);

}
