package controllers;
import models.User;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class UserController extends Controller
{
    private JPAApi jpaApi;
    private FormFactory formFactory;
    private User newPassWord;

    @Inject
    public UserController(JPAApi jpaApi, FormFactory formFactory)
    {
        this.jpaApi = jpaApi;
        this.formFactory = formFactory;
    }

    public Result getNewUser()
    {
        return ok(views.html.user.render());
    }

    @Transactional
    public Result postNewUser()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String userName = form.get("user");
        String passWord = form.get("passWord");
        String result;

        if (userName != null)
        {
            System.out.println("USERNAME: " + userName);
            User newUser = new User();
            newUser.setUserName(userName);
            newUser.setPassWord(passWord);
            
            jpaApi.em().persist(newUser);
            result = "saved";
        } else
        {
            result = "not saved";
        }
        return redirect("/staintype.css");
    }

   

    
}

