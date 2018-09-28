
package controllers;

import models.Treatment;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class TreatmentController extends Controller
{
    private JPAApi jpaApi;
    @Inject
    public TreatmentController(JPAApi jpaApi)
    {
        this.jpaApi = jpaApi;
    }
    @Transactional(readOnly = true)
    public Result getTreatment()
    {
        String sql="SELECT t FROM Treatment t ORDER BY treatmentId";

        List<Treatment> treatments = jpaApi.em().createQuery(sql,Treatment.class).getResultList();
        return ok(views.html.treatment.render(treatments));
    }
}



