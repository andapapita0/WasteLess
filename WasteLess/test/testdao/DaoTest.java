package testdao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import org.junit.Assert;
import org.junit.Test;

import dao.FoodItemDao;
import persistent.FoodItem;


public class DaoTest {
	private FoodItemDao foodDao;
	
	@Test
	@Transactional
	public void testAddFood() throws ParseException {
		foodDao = new FoodItemDao();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdformat.parse("2020-03-28");
        Date d2 = sdformat.parse("2020-04-04");
        Date d3 = sdformat.parse("2020-04-03");
		FoodItem foodItem = new FoodItem("sparanghel", 500, 1000, d1, d2, d3);
		
		foodDao.addFoodItem(foodItem);
		
		List<FoodItem> groceryList = foodDao.getAlldata();
		Assert.assertEquals(foodItem.getName(), groceryList.get(groceryList.size()-1).getName());
	}
	
	@Test
	@Transactional
	public void testDeleteFood() throws ParseException {
		foodDao = new FoodItemDao();
		FoodItem foodItem = new FoodItem();
		List<FoodItem> groceryList = foodDao.getAlldata();
		int id = groceryList.size()-1;
		foodItem.setId(id);
		foodDao.deleteFoodItem(foodItem);
		Assert.assertNotEquals(groceryList.get(groceryList.size()-1).getId(), id);
	}
	
	@Test
	@Transactional
	public void testUpdateFood() throws ParseException {
		foodDao = new FoodItemDao();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdformat.parse("2020-03-28");
        Date d2 = sdformat.parse("2020-04-04");
        Date d3 = sdformat.parse("2020-04-03");
        FoodItem foodItem = new FoodItem("sparanghel", 500, 1000, d1, d2, d3);
        List<FoodItem> groceryList = foodDao.getAlldata();
        int id=groceryList.size()-1;
        foodItem.setId(id);
		foodDao.updateFoodItem(foodItem);
		Assert.assertEquals(foodItem.getConsumption_date(), groceryList.get(0).getConsumption_date());
	}


}
