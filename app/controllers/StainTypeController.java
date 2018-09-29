package controllers;

import models.StainType;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class StainTypeController extends Controller
{
    private JPAApi jpaApi;
    private FormFactory formFactory;
    @Inject
    public StainTypeController(JPAApi jpaApi,FormFactory formFactory)
    {
        this.jpaApi = jpaApi;
        this.formFactory=formFactory;
    }
    @Transactional(readOnly = true)
    public Result getStainType()
    {

        String sql="SELECT s FROM StainType s ORDER BY TypeName";

        List<StainType> StainType=jpaApi.em().createQuery(sql,StainType.class).getResultList();

        return ok(views.html.StainType.render(StainType));

    }

}
