package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	public static Result index() {

		int rowCount = 0 ;// models.system.Catagory.find.findRowCount();

		return ok(index.render("Yourdfdf new application is ready. row count: "
				+ rowCount));
	}

}
