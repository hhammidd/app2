package com.hamidApp1.controller.istat;

import com.hamidApp1.model.istat.Istat_it;
import com.hamidApp1.model.istat.Istat_it_filter;
import com.hamidApp1.model.merchantFraud.BaseMerchantFraudToolBean;
import com.hamidApp1.service.istat.IstatItService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/istatit")
public class IstatItController  {
    @Autowired
    private IstatItService istatItService;

    @GetMapping(value = "/findall")
    public List<Istat_it> getAllMerchantFraud()  {
        return istatItService.findAll();
    }

    @PostMapping(value = "/load")
    public List<Istat_it> persist(@RequestBody final Istat_it pvs) {
        istatItService.savePv(pvs);
        return istatItService.findAll();
    }

    @RequestMapping(value = "/{id_region}", method = RequestMethod.GET)
    public List<Istat_it> getAll(@PathVariable("id_region") int id_region) {
        return istatItService.findByidRegion(id_region);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public List<Istat_it> getHistMailList(
            @RequestBody @Valid Istat_it_filter input) throws SQLException {
            return istatItService.getHistMailList(input);
    }

    //put
    @RequestMapping(method = RequestMethod.PUT , value = "/findall/{id}")
    public void updateIstat(@PathVariable String id){
        istatItService.deleteIstat(id);
    }
    //delete
    @RequestMapping(method = RequestMethod.DELETE , value = "/findall/{id}")
    public void deleteIstat(@PathVariable String id){
        istatItService.deleteIstat(id);
    }


}
