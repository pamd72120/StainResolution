package controllers;

import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import models.Textile;
import javax.inject.Inject;
import java.util.List;

public class TextileController extends Controller
{
    private JPAApi jpaApi;
    @Inject
    public TextileController(JPAApi jpaApi)
    {
        this.jpaApi = jpaApi;
    }
    @Transactional(readOnly = true)
    public Result getTextile()
    {
        String sql="SELECT t FROM Textile t ORDER BY textileName";

        List<Textile> textiles=jpaApi.em().createQuery(sql,Textile.class).getResultList();
        return ok(""+textiles.size());
    }
}


