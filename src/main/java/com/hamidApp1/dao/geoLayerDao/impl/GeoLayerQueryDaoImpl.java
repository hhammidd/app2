package com.hamidApp1.dao.geoLayerDao.impl;

import com.hamidApp1.dao.geoLayerDao.GeoLayerQueryDao;
import com.hamidApp1.model.geoLayersModel.GeoLayer;
import com.hamidApp1.model.geoLayersModel.GeoPvFilter;
import com.hamidApp1.model.geoLayersModel.Istat_Filter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class GeoLayerQueryDaoImpl implements GeoLayerQueryDao {

    @PersistenceUnit
    protected EntityManagerFactory emf;
    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<GeoPvFilter> getGeoLayerIstat(GeoLayer input) {

        List<Istat_Filter> istat_id = new ArrayList<>();

        String geoLayerQueryStr = "SELECT i.id FROM"
                + " istat_it i JOIN regioni_it r ON i.id_region = r.id "
                + "JOIN province_it p ON i.id_province  = p.id "
                + "JOIN comuni_it o ON i.id_comune = o.id WHERE 1 = 1";

        ArrayList<String> regs = new ArrayList<>();
        regs = input.getReg();
        String tempRegs = "";
        for (String r : regs) {
            tempRegs += "'" + r + "',";
        }
        geoLayerQueryStr = geoLayerQueryStr + " AND r.codice IN (" + tempRegs.substring(0, tempRegs.length() - 1) + ") ";
        ArrayList<String> pros = new ArrayList<>();
        pros = input.getPro();
        String tempPro = "";
        for (String p : pros) {
            tempPro += "'" + p + "',";
        }
        geoLayerQueryStr = geoLayerQueryStr + " OR p.codice IN (" + tempPro.substring(0, tempPro.length() - 1) + ") ";

        ArrayList<String> coms = new ArrayList<>();
        coms = input.getCom();
        String tempCom = "";
        for (String o : coms) {
            tempCom += "'" + o + "',";
        }
        geoLayerQueryStr = geoLayerQueryStr + " OR o.codice IN (" + tempCom.substring(0, tempCom.length() - 1) + ") ";

        System.out.println("geoLayerQueryStr: " + geoLayerQueryStr);

        // this is for test you can cancel it
        TypedQuery<Istat_Filter> geoLayerIstatQuery = (TypedQuery<Istat_Filter>) em.createNativeQuery(geoLayerQueryStr);
        System.out.println("geoLayerIstatQuery: " + geoLayerIstatQuery);
        istat_id = geoLayerIstatQuery.getResultList();


        String biMgis = "SELECT  SQL_CALC_FOUND_ROWS pv.client_code, pv.id_pv, pv.code AS code_mgis,"
                + " pv.name1 AS region_social, pv.address, pv.cap, pv.comune, pv.provincia, "
                + " pv.tel1 AS telephone, pv.tel2 AS telephone2, pv.tel3 AS telephone3, "
                + " pv.cf_pi AS codice_fiscale, pv.name2 AS title, pv.fax, pv.email, pv.site, "
                + " IF(pv.client_is=0, 'No', 'Si') AS cliente, pv.mod_date, pv.note,pv.coords  FROM pv  ";

        biMgis = biMgis +  " WHERE (pv.istat_id IN ( ";
        biMgis = biMgis + geoLayerQueryStr + ") AND pv.tc_state_other = 1)";

        TypedQuery<GeoPvFilter> geoPvFilterQuery = (TypedQuery<GeoPvFilter>) em.createNativeQuery(biMgis);

        List<GeoPvFilter> geoPvFilterList = new ArrayList<>();

        geoPvFilterList = geoPvFilterQuery.getResultList();

        return geoPvFilterList;
    }
}
