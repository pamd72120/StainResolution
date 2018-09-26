package controllers;

import models.TreatmentSupply;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class TreatmentSupplyController extends Controller
{
    private JPAApi jpaApi;
    @Inject
    public TreatmentSupplyController(JPAApi jpaApi)
    {
        this.jpaApi = jpaApi;
    }
    @Transactional(readOnly = true)
    public Result getTreatmentSupply()
    {
        String sql="SELECT t FROM TreatmentSupply t ORDER BY treatmentSupplyId";

        List<TreatmentSupply> treatmentsSupplies=jpaApi.em().createQuery(sql,TreatmentSupply.class).getResultList();
        return ok(""+treatmentsSupplies.size());
    }
}
