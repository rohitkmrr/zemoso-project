package controllers;

import play.mvc.*;

import views.html.*;
import play.data.Form;

import play.*;
import play.data.*;

//import play.db.ebean.Model;

import com.avaje.ebean.Model;
import models.*;
import views.html.*;
import java.util.*;

import models.User_Registration;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.BodyParser;                     
import play.libs.Json;
import play.libs.Json.*;                        

import static play.libs.Json.toJson;




/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class RegisterController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    public Result handleRegistration() {
        return ok(index.render("this is the sample code change."));
    }
    
    public Result addUser() {
        User_Registration usr=  Form.form(User_Registration.class).bindFromRequest().get();
     
        usr.save();
      
        return redirect(routes.HomeController.index());
    }
    
    public Result showUser() {
        List<User_Registration> user= new Model.Finder(String.class,  User_Registration.class).all();
        return ok(toJson(user));
    }

}
