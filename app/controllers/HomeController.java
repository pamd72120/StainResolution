package controllers;

import models.User;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.welcome;

import javax.inject.Inject;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller
{

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    private JPAApi jpaApi;
    private FormFactory formFactory;
    private List<models.StainType> StainType;

    @Inject
    public HomeController(JPAApi jpaApi, FormFactory formFactory)
    {
        this.jpaApi = jpaApi;
        this.formFactory = formFactory;
    }

    public Result index()
    {
        return ok(welcome.render("Welcome to the DIY Spot Removal App!"));
    }

    @Transactional
    public Result postNewUser()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String userName = form.get("user");
        String result;

        if (userName != null)
        {
            User newUser = new User();
            newUser.setUserName(userName);
            jpaApi.em().persist(newUser);
            result = "saved";
        } else
        {
            result = "not saved";
        }
        return redirect("/staintype.css");
    }

    public Result nextPage()
    {
        return ok(views.html.StainType.render(StainType));
    }
}