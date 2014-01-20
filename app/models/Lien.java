package models;

import java.util.Date;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Lien extends Model {

	@Id
	public Long id;
	public String lien1;
	public String lien2;
	public Date date;
	
	public static Model.Finder<Long,Lien> find =new Model.Finder(Long.class, Lien.class);

	public static void delete5(Long id) {
		find.ref(id).delete();
	}
	
	
}
