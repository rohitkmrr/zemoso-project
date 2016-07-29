package controllers;

import views.html.*;

import com.avaje.ebean.Ebean;

//import play.db.ebean.Model;

import com.avaje.ebean.Model;
import models.*;
import java.util.*;

import play.mvc.Controller;
import play.mvc.Result;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class LoginController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result Loginindex() {
        List<User_Data> user = getNotes();
        return ok(login.render(user,new play.twirl.api.Html("It <em>finally</em> works!")));
    }
    
    public List<User_Data> getNotes() {
        // get all notes of a given user    
      //  List<User_Data> all_notes_for_user= new Model.Finder(String.class,  User_Data.class).all();
        List<User_Data> all_notes_for_user=Ebean.find(User_Data.class).where().eq("state",1).findList();

        return all_notes_for_user;
    }
    public Result getArchiveNotes() {
        List<User_Data> user = getArchiveNotess();
        return ok(archive.render(user,new play.twirl.api.Html("It <em>finally</em> works!")));
    }
    
    public List<User_Data> getArchiveNotess() {
        // get all notes of a given user    
      //  List<User_Data> all_notes_for_user= new Model.Finder(String.class,  User_Data.class).all();
        List<User_Data> all_notes_for_user=Ebean.find(User_Data.class).where().eq("state",0).findList();

        return all_notes_for_user;
    }
    
    public Result getAllNotes() {
        List<User_Data> user = getNotes();
        return ok(home.render(user,new play.twirl.api.Html("It <em>finally</em> works!")));
    } 

}