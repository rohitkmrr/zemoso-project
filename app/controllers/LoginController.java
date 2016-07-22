package controllers;

import play.mvc.*;

import views.html.*;

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
        return ok(index2.render("Your new application is ready."));
    }
    public Result myHome() {
        return ok(index_for_homePage.render("Your new application is ready."));
    }
}