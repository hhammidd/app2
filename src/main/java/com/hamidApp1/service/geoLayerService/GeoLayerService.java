package com.hamidApp1.service.geoLayerService;

import com.hamidApp1.model.geoLayersModel.GeoLayer;
import com.hamidApp1.model.geoLayersModel.GeoPvFilter;
import com.hamidApp1.model.geoLayersModel.Istat_Filter;

import java.util.List;

public interface GeoLayerService {
    List<GeoPvFilter> getgeoLayerIstat(GeoLayer input);
}
