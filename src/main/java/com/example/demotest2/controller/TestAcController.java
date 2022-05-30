package com.example.demotest2.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: demo-test2
 * @description:
 * @author: mike
 * @create: 2022-05-30 10:32
 **/
public class TestAcController {

    public static void main(String[] args) {
        String xwj = "{\"MOT_ManufacturerName\":\"FDK\",\"MOT_GearRatio\":\"100:1\",\"BAT_DesignCapacity\":\"6000 mAh\",\"BAT_ManufacturerName\":\"glotronics\",\"FW_PebBoot\":\"UDFRM-B-S01-02V000-51X\",\"MOT_Type\":\"brushless\",\"BAT_SerialNumber\":\"1\",\"MOT_FwVerLeft\":\"20210727\",\"FW_McbBoot\":\"UDFRM-B-S01-02V000-51X\",\"FW_TrkBoot\":\"UDFRM-B-S01-02V000-51X\",\"BAT_CycleCount\":\"34\",\"MOT_Power\":\"39000 W\",\"FW_PebApp\":\"UDFRM-A-PEB-12V003.0907A\",\"FW_McbApp\":\"UDFRM-A-MCB-12V006.0408A\",\"BAT_DeviceName\":\"MKD35.2V12AH\",\"FW_PmbBoot\":\"UDFRM-B-S01-02V000-51X\",\"General_ModelCode\":\"F\",\"FW_PmbApp\":\"UDFRM-A-PMB-12V002.0408A\",\"FW_TrkApp\":\"UDFRM-A-TRK-12V003.0225A\",\"FW_IrmApp\":\"UDFRM-A-IRM-11V000\",\"MOT_FwVerRight\":\"20210727\"}";
        if (StringUtils.isNotBlank(xwj)) {
            JSONObject jsonObject = JSONObject.parseObject(xwj);
            if (StringUtils.isNotBlank(jsonObject.getString("FW_PmbBoot"))) {
                System.out.println("PmbBoot：" + jsonObject.getString("FW_PmbBoot"));
            }
            if (StringUtils.isNotBlank(jsonObject.getString("FW_TrkBoot"))) {
                System.out.println("TrkBoot："+jsonObject.getString("FW_TrkBoot"));
            }
            if (StringUtils.isNotBlank(jsonObject.getString("FW_McbBoot"))) {
                System.out.println("McbBoot："+jsonObject.getString("FW_McbBoot"));
            }
            if (StringUtils.isNotBlank(jsonObject.getString("FW_PebBoot"))) {
                System.out.println("PebBoot："+jsonObject.getString("FW_PebBoot"));
            }
            // 原有的字段覆盖
            if (StringUtils.isNotBlank(jsonObject.getString("FW_IrmApp"))) {
                System.out.println("Irm："+jsonObject.getString("FW_IrmApp"));
            }
            if (StringUtils.isNotBlank(jsonObject.getString("FW_PebApp"))) {
                System.out.println("Peb："+jsonObject.getString("FW_PebApp"));
            }
            if (StringUtils.isNotBlank(jsonObject.getString("FW_TrkApp"))) {
                System.out.println("Trk："+jsonObject.getString("FW_TrkApp"));
            }
            if (StringUtils.isNotBlank(jsonObject.getString("FW_McbApp"))) {
                System.out.println("Mcb："+jsonObject.getString("FW_McbApp"));
            }
            if (StringUtils.isNotBlank(jsonObject.getString("FW_PmbApp"))) {
                System.out.println("Pmb："+jsonObject.getString("FW_PmbApp"));
            }
        }
    }
}
