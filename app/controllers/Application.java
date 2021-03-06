package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

	public static Result index() {

		
		return ok(index.render());
	}

	public static Result list(){
		
		return ok(list.render());
	}
	
	public static Result media(){
		
		return ok(media.render());
	}
	
	public static Result download(){
		
		return ok(download.render());
	}
	
	public static Result buy(){
		
		return ok(buy.render());
	}
	
	public static Result aboutus(){
		
		return ok(aboutus.render());
	}
	
	public static Result cooperation(){
		
		return ok(cooperation.render());
	}
	

	
}