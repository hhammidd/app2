package com.hamidApp1.controller.mapFilter;

import com.hamidApp1.model.geoLayersModel.GeoLayer;
import com.hamidApp1.model.geoLayersModel.Istat_Filter;
import com.hamidApp1.service.geoLayerService.GeoLayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/geographifilter")
public class MapFilterController {

    @Autowired
    private GeoLayerService geoLayerService;

    @RequestMapping( value = "/filter", method = RequestMethod.POST)
    public  Map<String,List<Istat_Filter>> getGeoLayerIstat(
            @RequestBody @Valid GeoLayer input) throws SQLException {
        Map<String,List<Istat_Filter>> results = new HashMap<String, List<Istat_Filter>>();

        List<Istat_Filter> istat_id = geoLayerService.getgeoLayerIstat(input);

        results.put("istat_id", istat_id);
        return results;
    }



}
