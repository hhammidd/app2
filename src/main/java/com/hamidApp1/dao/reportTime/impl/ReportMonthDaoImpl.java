package com.hamidApp1.dao.reportTime.impl;

import com.hamidApp1.dao.reportTime.ReportMonthDao;
import com.hamidApp1.model.reportTiming.ReportMontlyListBean;
import com.hamidApp1.model.usersGis.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
public class ReportMonthDaoImpl implements ReportMonthDao {


    @PersistenceUnit
    protected EntityManagerFactory emf;
    @PersistenceContext
    protected EntityManager em;
    @Override
    public List<ReportMontlyListBean> reportMonthly() {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("User");
        //EntityManager em = emf.createEntityManager();
        //em.getTransaction().begin();
        String userQueryStr ="SELECT date_format( date, '%Y') as fiyear, date_format(date, '%M') AS month, count(*) as counter "
                + " from istat_it where id_region = 1611 GROUP BY fiyear, month ";


        System.out.println("reportTime: " + userQueryStr);

        TypedQuery<ReportMontlyListBean> pvsQuery = (TypedQuery<ReportMontlyListBean>) em.createNativeQuery(userQueryStr , ReportMontlyListBean.class);
        System.out.println("user: " + pvsQuery);
        List<ReportMontlyListBean> pvResult = pvsQuery.getResultList();

        //em.getTransaction().commit();

        return pvResult;
    }
}
