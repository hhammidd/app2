package com.hamidApp1.service.geoLayerService.impl;

import com.hamidApp1.dao.geoLayerDao.GeoLayerQueryDao;
import com.hamidApp1.model.geoLayersModel.GeoLayer;
import com.hamidApp1.model.geoLayersModel.Istat_Filter;
import com.hamidApp1.service.geoLayerService.GeoLayerService;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeoLayerServiceImpl implements GeoLayerService {

    @Autowired
    private GeoLayerQueryDao geoLayerQueryDao;
    @Override
    public List<Istat_Filter> getgeoLayerIstat(GeoLayer input) {
        List<Istat_Filter> geoIstat = geoLayerQueryDao.getGeoLayerIstat(input);


        return null;
    }
}
