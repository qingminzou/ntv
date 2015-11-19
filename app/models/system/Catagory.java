package models.system;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.data.format.Formats.DateTime;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model.Finder;

@Entity
public class Catagory {

	@Id
	@Required
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "uuid")
	public long id;

	@Required
	public String name;

	public String description;

	@Required
	public long lft;

	@Required
	public long rgt;

	@DateTime(pattern = "yyyy-MM-dd")
	public Date lastUpdatedAt;

	public String lastUpdatedBy;

	public String createdBy;

	@DateTime(pattern = "yyyy-MM-dd")
	public Date createdAt;

	@ManyToOne
	public Catagory parent;

	public static Finder<Long, Catagory> find = new Finder<Long, Catagory>(
			Long.class, Catagory.class);

}
