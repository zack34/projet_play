package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
public class SousCommentaire extends Model {

	@Id
	public Long idd;
	public String souscommentaire;
	public Date date1;
	public String scommcible;
	public String user;
	
	/*
	 * classe Bookmark
	 */
	 @ManyToOne 
     public Commentaire comm;
	
	
	 public static Finder<Long, SousCommentaire> find = new Finder<Long, SousCommentaire>(Long.class, SousCommentaire.class);

     
	 public static void delete3(Long id) {
        find.ref(id).delete();
	}
}

	

	
    
