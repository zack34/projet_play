package controllers;

import java.util.Date;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import models.Commentaire;
import models.Lien;
import models.SousCommentaire;
import models.User;
import views.html.*;
import views.*;

public class Tweet1 extends Controller {

	public static Result add() {
		final Form<Commentaire> CommentaireForm = Form.form(Commentaire.class)
				.bindFromRequest();
		final Commentaire Commentaire1 = CommentaireForm.get();
		Commentaire1.date = new Date();
		Commentaire1.save();
		return redirect(routes.Application.index());
	}

	public static Result addSC() {

		final Form<SousCommentaire> SCommentaireForm = Form.form(
				SousCommentaire.class).bindFromRequest();
		final SousCommentaire Commentaire1 = SCommentaireForm.get();
		Commentaire1.date1 = new Date();
		Commentaire1.save();
		return redirect(routes.Application.index());
		// return TODO;
	}

	public static Result AddAMIS(String ami1, String ami2) {

		final Form<Lien> LienForm = Form.form(Lien.class).bindFromRequest();
		final Lien Lien1 = LienForm.get();
		Lien1.lien1 = ami1;
		Lien1.lien2 = ami2;
		Lien1.date = new Date();
		Lien1.save();
		return redirect(routes.Application.index());
		// return TODO;
	}

	public static Result delete(Long id) {
		// condition si c le user courant sinon pa possible
		Commentaire.delete1(id);
		return redirect(routes.Application.index());
	}
	public static Result delete2(Long id) {
		// condition si c le user courant sinon pa possible
		SousCommentaire.delete3(id);
		return redirect(routes.Application.index());
	}
	public static Result Editer (String commentaire ){
		Commentaire.modfier(commentaire);
		return redirect(routes.Application.index()); }

	public static String recherche1() {
		final Form<Commentaire> CommentaireForm = Form.form(Commentaire.class)
				.bindFromRequest();
		final Commentaire Commentaire1 = CommentaireForm.get();
		String Nom = Commentaire1.cible;
		// Commentaire1.refresh();
		// String Nom= null;
		System.out
				.println("***********************************************************");
		System.out.println("Cible :" + Nom + "cc " + Commentaire1.user);
		System.out
				.println("***********************************************************");
		return Nom;
	}

	/*
	 * public static Commentaire create(Commentaire tweet) { tweet.creationDate
	 * = new Date(); tweet.save(); return tweet; }
	 */

	// ------------------------------------------------------------------------------------------------
	public static Result Inscription() {
		return ok(Inscription.render("Inscription"));
	}

	public static Result SubmitInscription() {
		final Form<User> CommentaireForm = Form.form(User.class)
				.bindFromRequest();
		final User User1 = CommentaireForm.get();
		User1.save();
		return redirect(routes.Application.index());
	}

	// -------------------------------------------------------------------------------------------------

}