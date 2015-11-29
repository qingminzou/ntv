package test.services.system;

import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.running;

import java.util.Date;
import java.util.List;

import junit.framework.Assert;
import models.system.Catagory;

import org.fest.assertions.Fail;
import org.junit.Test;

import services.system.CatagoryService;
import services.system.vo.CatagoryCriteria;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.PagingList;

public class TestCatagoryService {

	@Test
	public void testFindAll() {

		running(fakeApplication(), new Runnable() {
			public void run() {
				CatagoryService catagory = new CatagoryService();

				List<Catagory> list = catagory.findAll();

				Assert.assertNotNull(list);
			}
		});

	}

	@Test
	public void testCreate() {
		running(fakeApplication(), new Runnable() {

			@Override
			public void run() {
				try {
					CatagoryService service = new CatagoryService();

					// configurate root catagory
					Catagory root = new Catagory();
					root.name = "ROOT";
					root.description = "Root";
					root.lft = 1;
					root.rgt = 2;
					root.createdAt = new Date();
					root.createdBy = "0";
					root.lastUpdatedBy = "0";
					root.lastUpdatedAt = new Date();
					Ebean.save(root);

					Catagory mc = new Catagory();
					mc.name = "ROOT";
					mc.description = "Root";
					mc.lft = 1;
					mc.rgt = 2;
					mc.createdAt = new Date();
					mc.createdBy = "0";
					mc.lastUpdatedBy = "0";
					mc.lastUpdatedAt = new Date();

					service.createCatagory(mc, root.id);

					root = Ebean.find(Catagory.class, root.id);
					Assert.assertNotNull(mc.id);
					Assert.assertEquals(1, root.lft);
					Assert.assertEquals(4, root.rgt);

					Assert.assertEquals(2, mc.lft);
					Assert.assertEquals(3, mc.rgt);
				} catch (Exception e) {
					e.printStackTrace();
					Fail.fail("unknow error occured!");
				}
			}

		});
	}

	@Test
	public void testSearch() {
		running(fakeApplication(), new Runnable() {

			@Override
			public void run() {
				CatagoryService service = new CatagoryService();

				// configurate root catagory
				Catagory root = new Catagory();
				root.name = "ROOT";
				root.description = "Root";
				root.lft = 1;
				root.rgt = 2;
				root.createdAt = new Date();
				root.createdBy = "0";
				root.lastUpdatedBy = "0";
				root.lastUpdatedAt = new Date();
				Ebean.save(root);

				Catagory mc = new Catagory();
				mc.name = "coco tea";
				mc.description = "very good!";
				mc.lft = 1;
				mc.rgt = 2;
				mc.createdAt = new Date();
				mc.createdBy = "0";
				mc.lastUpdatedBy = "0";
				mc.lastUpdatedAt = new Date();

				service.createCatagory(mc, root.id);

				root = Ebean.find(Catagory.class, root.id);
				Assert.assertNotNull(mc.id);
				Assert.assertEquals(1, root.lft);
				Assert.assertEquals(4, root.rgt);

				Assert.assertEquals(2, mc.lft);
				Assert.assertEquals(3, mc.rgt);

				CatagoryCriteria catagoryCriteria = new CatagoryCriteria();
				PagingList<Catagory> catagories = service
						.searchCatagories(catagoryCriteria);
				Assert.assertEquals(2, catagories.getAsList().size());

				catagoryCriteria.setName("coco tea");
				catagories = service.searchCatagories(catagoryCriteria);
				Assert.assertEquals(1,
						catagories.getAsList().size());
				Assert.assertEquals("coco tea",
						catagories.getAsList().get(0).name);

				catagoryCriteria.setName("co te");
				catagories = service.searchCatagories(catagoryCriteria);
				Assert.assertEquals(1,
						catagories.getAsList().size());
				Assert.assertEquals("coco tea",
						catagories.getAsList().get(0).name);

			}

		});
	}

}
