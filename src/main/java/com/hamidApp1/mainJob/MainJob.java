package com.hamidApp1.mainJob;

import com.hamidApp1.model.reporting.reportA.GenericReportA;
import com.hamidApp1.service.reporting.reportA.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

public class MainJob {


    public static void main(String[] args) throws Exception {
        MainJob mainJob = new MainJob();
        switch (args[0]) {
            case "doReportA":
            mainJob.reportA(args);
        }
    }

    private void reportA(String[] args) throws Exception{
        String monthReport = args[1];
        getReportA(monthReport,"EUR");

    }

    private void getReportA(String monthReport, String eur) {
        List<Object> par = new ArrayList<>();
        par.add(monthReport);
        par.add(eur);

        //List<GenericReportA> repBeanList = jobService.getDataReportAService(par,"reportA");
    }


}
