package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import models.*;
import views.html.*;
import views.*;

public class Authentication extends Controller {

	public static class AuthenticatedUser {
		public String email;
		public String password;

		public String validate() {
			if (User.authenticate(email, password) == null) {
				return 
			"oups! rate! Essaye encore une fois";
			}
			return null;
		}
	}

	public static Result login() {
		return ok(login.render(Form.form(AuthenticatedUser.class)));
	}

	// On recupere les informations de login (quand le user se "signin")
	public static Result authenticate() {
		Form<AuthenticatedUser> loginForm = Form.form(AuthenticatedUser.class)
				.bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {
			session("email", loginForm.get().email);
			return redirect(routes.Application.index());
		}
	}

	// Fermer la session
	public static Result logout() {
		session().clear();
		flash("success", "Vous etes deconnecte(e)");
		return redirect(routes.Authentication.login());
	}
	
	/* 
	 * public static Result Inscription() { return
	 * ok(Inscription.render("Inscription")); }
	 * 
	 * public static Result SubmitInscription() { final Form<User>
	 * CommentaireForm = Form.form(User.class).bindFromRequest(); final User
	 * User1 = CommentaireForm.get(); User1.save(); return
	 * redirect(routes.Application.index()); }
	 */
}
