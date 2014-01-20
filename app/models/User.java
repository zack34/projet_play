package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class User extends Model {

	@Id
	@Constraints.Required
	@Formats.NonEmpty
	public String email;
	
	@Constraints.Required
	public String name;
	
	@Constraints.Required
	public String password;
	
	public static Model.Finder<String,User> find =new Model.Finder(String.class, User.class);

	public static List<User> findAll() {
		return find.all();
	}

	public static User findByEmail(String email) {
		return find.where().eq("email", email).findUnique();
	}
	
	
	public static User authenticate(String email, String password) {
		return find.where().eq("email", email).eq("password", password).findUnique();
	}
	
	
	public String toString() {
		return "User(" + email + ").........";
				}
	}