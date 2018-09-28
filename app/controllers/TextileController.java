package controllers;

import models.Textile;
import models.Treatment;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class TextileController extends Controller
{
    private JPAApi jpaApi;
    private FormFactory formFactory;
    @Inject
    public TextileController(JPAApi jpaApi, FormFactory formFactory)
    {
        this.jpaApi = jpaApi;
        this.formFactory = formFactory;
    }
    @Transactional(readOnly = true)
    public Result getTextile()
    {
        String sql="SELECT t FROM Textile t ORDER BY textileName";

        List<Textile> textiles = jpaApi.em().createQuery(sql,Textile.class).getResultList();
        return ok(views.html.Textile.render(textiles));
    }
    public Result postTextile()
    {
        DynamicForm form = formFactory.form().bindFromRequest();

        String textileName = form.get("textileName");

        String sql="SELECT t FROM Treatment t ORDER BY treatmentID";
        List<Treatment>treatments=jpaApi.em().createQuery(sql,Treatment.class).getResultList();
        return ok(views.html.treatment.render(treatments));
    }
}


