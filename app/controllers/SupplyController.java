package controllers;

import models.Supply;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class SupplyController extends Controller
{
    private JPAApi jpaApi;
    private FormFactory formFactory;
    @Inject
    public SupplyController(JPAApi jpaApi, FormFactory formFactory)
    {
        this.jpaApi=jpaApi;
        this.formFactory=formFactory;
    }
    public SupplyController(JPAApi jpaApi)
    {
        this.jpaApi = jpaApi;
    }
    @Transactional(readOnly = true)
    public Result getSupply()
    {
        String sql="SELECT s FROM Supply s ORDER BY supplyName";

        List<Supply> supplies=jpaApi.em().createQuery(sql,Supply.class).getResultList();
        return ok(""+supplies.size());
    }
}
