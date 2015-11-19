package services.system;

import java.util.List;

import models.system.Catagory;

import org.h2.util.StringUtils;

import services.system.vo.CatagoryCriteria;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.PagingList;
import com.avaje.ebean.Query;

public class CatagoryService {

	/**
	 * Create catagory under the supplied parent catagory
	 * 
	 * @param catagory
	 * @param parentId
	 * 
	 * @throws IllegalArgumentException
	 *             if catagory is null or name is empty
	 * @throws IllegalArgumentException
	 *             if parent catagory should't found
	 */
	public void createCatagory(Catagory catagory, long parentId) {

		if (null == catagory || StringUtils.isNullOrEmpty(catagory.name)) {
			throw new IllegalArgumentException(
					"catagory or catagory's name is null [or name is empty!] !");
		}

		Catagory parentCatagory = Catagory.find.byId(parentId);

		if (null == parentCatagory) {
			throw new IllegalArgumentException(
					"Parent catagory could't found by id: " + parentId);
		}

		catagory.parent = parentCatagory;

		catagory.lft = parentCatagory.rgt;
		catagory.rgt = parentCatagory.rgt + 1;

		int i = Ebean
				.createUpdate(Catagory.class,
						"UPDATE Catagory c SET c.rgt=c.rgt+2 WHERE c.rgt>=:rgt")
				.setParameter("rgt", parentCatagory.rgt).execute();
		System.out.println("Execute result: " + i);
		Ebean.save(catagory);
	}

	public PagingList<Catagory> searchCatagories(
			CatagoryCriteria catagoryCriteria) {

		Query<Catagory> query = Ebean.find(Catagory.class);
		ExpressionList<Catagory> expression = query.where();

		if (null != catagoryCriteria) {
			if (!StringUtils.isNullOrEmpty(catagoryCriteria.getName())) {
				expression.like("name", "%" + catagoryCriteria.getName() + "%");
			}
			if (!StringUtils.isNullOrEmpty(catagoryCriteria.getDescription())) {
				expression.like("description",
						"%" + catagoryCriteria.getDescription() + "%");
			}
			if (!StringUtils.isNullOrEmpty(catagoryCriteria.getDescription())) {
				expression.eq("parent.name", catagoryCriteria.getParentName());
			}
		}

		return query.findPagingList(10);
	}

	/**
	 * fech all catagories if null return an empty list object
	 * 
	 * @return
	 */
	public List<Catagory> findAll() {

		return Catagory.find.all();
	}
}
