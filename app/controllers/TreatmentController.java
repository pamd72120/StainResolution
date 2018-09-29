
package controllers;

import models.Treatment;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class TreatmentController extends Controller
{
    private JPAApi jpaApi;
    private FormFactory formFactory;
    @Inject
    public TreatmentController(FormFactory formFactory, JPAApi jpaApi)
    {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }
    @Transactional(readOnly = true)
    public Result getTreatment()
    {
        DynamicForm form=formFactory.form().bindFromRequest();
        int stainTypeID =
        Integer.parseInt(form.get("stainTypeId"));
        int textileId = Integer.parseInt(form.get("textile"));
        String sql=" SELECT t FROM Treatment t WHERE stainTypeId =:stainTypeId AND "+
                "textileId =:textileId ORDER BY treatmentId";

        List<Treatment> treatments = jpaApi.em().createQuery(sql,Treatment.class)
            .setParameter("stainTypeId", stainTypeID)
            .setParameter("textileId", textileId)
            .getResultList();
        return ok(views.html.treatment.render(treatments));
    }


}



