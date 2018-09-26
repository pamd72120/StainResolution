package controllers;

import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import models.StainType;
import javax.inject.Inject;
import java.util.List;

public class StainTypeController extends Controller
{
    private JPAApi jpaApi;
    @Inject
    public StainTypeController(JPAApi jpaApi)
    {
        this.jpaApi = jpaApi;
    }
    @Transactional(readOnly = true)
    public Result getStainType()
    {
        String sql="SELECT s FROM StainType s ORDER BY TypeName";

        List<StainType> StainType=jpaApi.em().createQuery(sql,StainType.class).getResultList();
        return ok(""+ StainType.size());
    }
}
