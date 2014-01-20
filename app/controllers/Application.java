package controllers;

import static play.data.Form.form;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import play.*;
import play.mvc.*;
import views.html.*;
import models.Commentaire;
import models.Lien;
import models.SousCommentaire;
import models.User;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

/*
 * @Security c'est pour assurer qu'on se connecte pas une page d'autofication
 */
@Security.Authenticated(Secured.class)
public class Application extends Controller {

	
	public static Result index() {
		return ok(index.render("Your new application is ready.",
				Commentaire.find.findList(),
				User.find.byId(request().username()),
				SousCommentaire.find.findList()));
	}
	
	public static Result index1() {
		return ok(index1.render("Your new application is ready.",
				Commentaire.find.findList(),
				User.find.byId(request().username()),
				SousCommentaire.find.findList()));
	}
	
	public static Result recherche() {
		// List<String> aa;
		// aa=Commentaire.find.where().eq("cible",
		// Tweet1.recherche1()).findList();
		System.out.println(" la liste :");
		return ok(index.render("Your new application is ready.",
				Commentaire.find.where().eq("user", Tweet1.recherche1())
						.findList(), User.find.byId(request().username()),
				SousCommentaire.find.findList()));
		// Bookmark.find.fetch("category").orderBy("title").findList()
	}

	public static Result doReview() {
		return ok(index.render("Your new application is ready.",
				Commentaire.find.orderBy("commentaire").findList(),
				User.find.byId(request().username()),
				SousCommentaire.find.findList()));
	}
	
	public static Result doReview1() {
		return ok(index.render("Your new application is ready.",
				Commentaire.find.orderBy("id").findList(),
				User.find.byId(request().username()),
				SousCommentaire.find.findList()));
	}
	
	
	
	

	public static Result SeeProfil(String user) {
		System.out.println("  " + user + "    "
				+ User.find.where().eq("NAME", user).findUnique());
		return ok(Profile.render("je suis ds la page d'un profil", User.find
				.where().eq("name", user).findUnique(),
				User.find.byId(request().username()), Lien.find.findList()));
	}
	public static Result delete3(Long id) {
		// condition si c le user courant sinon pa possible
		Lien.delete5(id);
		return redirect(routes.Application.index());
	}

	
	/*public static Result upload() throws IOException  {
		  MultipartFormData body = request().body().asMultipartFormData();
		  FilePart picture = body.getFile("picture");
		  if (picture != null) {
		    String fileName = picture.getFilename();
		    String contentType = picture.getContentType(); 
		    File file = picture.getFile();
		    routes.Assets.at("images/"+fileName).url();
		    File photofile = new File(routes.Assets.at("images/"+fileName).url());
			FileUtils.copyFile(file, photofile);
		    return ok("File uploaded");
		  } else {
		    flash("error", "Missing file");
		    return redirect(routes.Application.index());    
		  }
		}*/


}
