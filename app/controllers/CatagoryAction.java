//package controllers;
//
//import play.data.Form;
//import play.mvc.Controller;
//import play.mvc.Result;
//import services.system.vo.CatagoryCriteria;
//
//public class CatagoryAction extends Controller {
//
//	public static Result list() {
//
//		Form<CatagoryCriteria> catagoryForm = form(CatagoryCriteria.class);
//		System.out.println("list ");
//		return ok(catagory.render("list", catagoryForm));
//	}
//
//	public static Result show(String id) {
//		Form<CatagoryCriteria> catagoryForm = form(CatagoryCriteria.class);
//		System.out.println("show " + id);
//		if (null != id && !id.equals("")) {
//			CatagoryCriteria dbCt = new CatagoryCriteria();
//			dbCt.setName("from db name .");
//			dbCt.setDescription("from db description .");
//
//			catagoryForm = catagoryForm.fill(dbCt);
//		}
//		return ok(catagory.render("show :" + id, catagoryForm));
//	}
//
//	public static Result add() {
//		Form<CatagoryCriteria> catagoryForm = form(CatagoryCriteria.class);
//		CatagoryCriteria ct = catagoryForm.bindFromRequest().get();
//		System.out.println("@@ name:" + ct.getName() + " desc: "
//				+ ct.getDescription());
//
//		return ok(catagory.render("add ", catagoryForm));
//	}
//
//	public static Result modify() {
//		Form<CatagoryCriteria> catagoryForm = form(CatagoryCriteria.class);
//		System.out.println("modify ");
//		return ok(catagory.render("modify ", catagoryForm));
//	}
//}