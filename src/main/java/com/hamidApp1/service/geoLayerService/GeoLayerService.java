package com.hamidApp1.service.geoLayerService;

import com.hamidApp1.model.geoLayersModel.GeoLayer;
import com.hamidApp1.model.geoLayersModel.Istat_Filter;

import java.util.List;

public interface GeoLayerService {
    List<Istat_Filter> getgeoLayerIstat(GeoLayer input);
}
