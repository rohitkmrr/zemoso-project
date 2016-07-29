package controllers;

import play.data.Form;

import com.avaje.ebean.Model;

import java.util.*;
import models.User_Registration;

import play.mvc.Controller;
import play.mvc.Result;
import play.Logger;
import com.fasterxml.jackson.databind.JsonNode;


import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlUpdate;
import java.util.List;
import models.User_Data;
import views.html.index;

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
    
    public Result registerUser() {
        User_Registration usr=  Form.form(User_Registration.class).bindFromRequest().get();
     
        usr.save();
      
        return redirect(routes.HomeController.index());
    }
    
    
     public Result addNote() {
        User_Data usr=  new User_Data();
        usr.title = Form.form().bindFromRequest().get("title");
        usr.description = Form.form().bindFromRequest().get("description");
        //Form.form(User_Data.class).bindFromRequest().get();
        Logger.info("ggggggggggggggggggggggg" + usr.title);
                Logger.info("ggggggggggggggggggggggg" + Form.form().bindFromRequest().get("description"));
        
        usr.save();
        Logger.info("iiiiiiiiiiddd" + usr.note_id);
        return ok(index.render("this is the sample code change."));
    }
    

    public Result showUser() {
        List<User_Registration> user= new Model.Finder(String.class,  User_Registration.class).all();
        return ok(toJson(user));
    }
    
     public Result updateNote() {
       
        String title = Form.form().bindFromRequest().get("title");
        String note_id = Form.form().bindFromRequest().get("note_id");
        String description = Form.form().bindFromRequest().get("description");
        Date Modified_on=new Date();
        Logger.info("batmannnnnnnn"+title + "  "+ note_id +"  "+ description);
        String s = "UPDATE user_data set title = :title, description = :description, Modified_on= :Modified_on where note_id = :note_id";
        SqlUpdate update = Ebean.createSqlUpdate(s);
        update.setParameter("note_id", note_id);
        update.setParameter("description", description);
        update.setParameter("title", title);
         update.setParameter("Modified_on", Modified_on);
        int modifiedCount = Ebean.execute(update);

        //Logger.info(note_id + title + description);
        return ok(index.render("this is the sample code change."));
        
        
    }
    
     public Result deleteNote() {
          String note_id = Form.form().bindFromRequest().get("note_id");
           Logger.info("here we are deleteing <<<<<<<<<<<<,,,,>>>>>>>>>>>>>>>>>>>." + "  "+ note_id );
          String s =("DELETE FROM user_data WHERE note_id = :note_id");
          SqlUpdate down = Ebean.createSqlUpdate(s);
          down.setParameter("note_id", note_id);
         int modifiedCount = Ebean.execute(down);
           return ok(index.render("this is the sample code change."));
         
     }
     
     public Result archiveNote() {
          String note_id = Form.form().bindFromRequest().get("note_id");
          int state=0;
           Logger.info("here we are archiving <<<<<<<<<<<<,,,,>>>>>>>>>>>>>>>>>>>." + "  "+ note_id );
        String s = "UPDATE user_data set state = :state where note_id = :note_id";
          SqlUpdate update = Ebean.createSqlUpdate(s);
        update.setParameter("state", state);
        update.setParameter("note_id", note_id);
        int modifiedCount = Ebean.execute(update);

        //Logger.info(note_id + title + description);
        return ok(index.render("this is the sample code change."));
         
     }
     
       public Result recoverarchiveNote() {
          String note_id = Form.form().bindFromRequest().get("note_id");
          int state=1;
           Logger.info("here we are archiving <<<<<<<<<<<<,,,,>>>>>>>>>>>>>>>>>>>." + "  "+ note_id );
        String s = "UPDATE user_data set state = :state where note_id = :note_id";
          SqlUpdate update = Ebean.createSqlUpdate(s);
        update.setParameter("state", state);
        update.setParameter("note_id", note_id);
        int modifiedCount = Ebean.execute(update);

        //Logger.info(note_id + title + description);
        return ok(index.render("this is the sample code change."));
         
     }
    
}




