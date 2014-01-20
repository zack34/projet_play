package models;

import java.util.Date;
import java.util.List;

import play.db.ebean.Model;
import scala.reflect.internal.Trees.If;

import javax.persistence.*;

@Entity
public class Commentaire extends Model {

	@Id
	public Long id;
	public String commentaire;
	public Date date;
	public String cible;
	public String user;

	

	public static Finder<Long, Commentaire> find = new Finder<Long, Commentaire>(
			Long.class, Commentaire.class);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void delete1(Long id) {
		find.ref(id).delete();
	}
	public static void modfier(String commentaire ){ 
		//commentaire.replaceAll(commentaire, "remplcer iccciiii");
		commentaire.replaceAll(commentaire,"ffffffffffffffff");
		}
	
	public static List<Commentaire> findByUsername(String username) {
		return find.where().eq("username", username).findList();
	}

	/*
	 * public static Commentaire create(Commentaire tweet) { tweet.creationDate
	 * = new Date(); tweet.save(); return tweet; }
	 */
	/*
	 * public static List<Commentaire> findAllbyNom(String Nom) { return
	 * find.where().eq("user", Nom).all(); }
	 */
}
