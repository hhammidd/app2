package com.hamidApp1.dao.geoLayerDao;

import com.hamidApp1.model.geoLayersModel.GeoLayer;
import com.hamidApp1.model.geoLayersModel.GeoPvFilter;
import com.hamidApp1.model.geoLayersModel.Istat_Filter;

import java.util.List;

public interface GeoLayerQueryDao {
    List<GeoPvFilter> getGeoLayerIstat(GeoLayer input);
}
