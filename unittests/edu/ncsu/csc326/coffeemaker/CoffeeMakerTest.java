package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class CoffeeMakerTest
{

	private CoffeeMaker cm;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	private Recipe r5;
	private Recipe r6;
	private Recipe r7;
	private Recipe r8;
	private Recipe r9;
	private Recipe r10;
	private Recipe r11;
	private Recipe r12;
	private Recipe r13;

	@Before
	public void setUp() throws Exception
	{
		cm = new CoffeeMaker();

		//Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee1");
		r1.setAmtChocolate("1");
		r1.setAmtCoffee("2");
		r1.setAmtMilk("3");
		r1.setAmtSugar("4");
		r1.setPrice("5");

		//Set up for r2
		r2 = new Recipe();
		r2.setName("Coffee2");
		r2.setAmtChocolate("6");
		r2.setAmtCoffee("7");
		r2.setAmtMilk("8");
		r2.setAmtSugar("9");
		r2.setPrice("10");
		
		//Set up for r4
				r4 = new Recipe();
				r4.setName("Coffee4");
				r4.setAmtChocolate("8");
				r4.setAmtCoffee("9");
				r4.setAmtMilk("10");
				r4.setAmtSugar("11");
				r4.setPrice("20");
				
				//Set up for r5
				r5 = new Recipe();
				r5.setName("Coffee5");
				r5.setAmtChocolate("0");
				r5.setAmtCoffee("3");
				r5.setAmtMilk("3");
				r5.setAmtSugar("1");
				r5.setPrice("100");
				
				//Set up for r6
				r6 = new Recipe();
				r6.setName("Coffee6");
				r6.setAmtChocolate("4");
				r6.setAmtCoffee("0");
				r6.setAmtMilk("1");
				r6.setAmtSugar("1");
				r6.setPrice("65");

				//Set up for r7
				r7 = new Recipe();
				r7.setName("Coffee7");
				r7.setAmtChocolate("0");
				r7.setAmtCoffee("0");
				r7.setAmtMilk("0");
				r7.setAmtSugar("0");
				r7.setPrice("0");
				
				//Set up for r8
				r8 = new Recipe();
				r8.setName("Coffee8");
				r8.setAmtChocolate("4");
				r8.setAmtCoffee("0");
				r8.setAmtMilk("1");
				r8.setAmtSugar("1");
				r8.setPrice("65");
				
				//Set up for r9
				r9 = new Recipe();
				r9.setName("Coffee9");
				r9.setAmtChocolate("6");
				r9.setAmtCoffee("12");
				r9.setAmtMilk("9");
				r9.setAmtSugar("4");
				r9.setPrice("85");
				
				//Set up for r10
				r10 = new Recipe();
				r10.setName("Coffee10");
				r10.setAmtChocolate("8");
				r10.setAmtCoffee("7");
				r10.setAmtMilk("5");
				r10.setAmtSugar("4");
				r10.setPrice("45");
				
				//Set up for r11
				r11 = new Recipe();
				r11.setName("Coffee11");
				r11.setAmtChocolate("8");
				r11.setAmtCoffee("7");
				r11.setAmtMilk("5");
				r11.setAmtSugar("4");
				r11.setPrice("6");
				
				//Set up for r12
				r12 = new Recipe();
				r12.setName(null);
				r12.setAmtChocolate("8");
				r12.setAmtCoffee("7");
				r12.setAmtMilk("5");
				r12.setAmtSugar("4");
				r12.setPrice("6");
				
				//Set up for r13
				r13 = new Recipe();
				r13.setName("Coffee11");
				r13.setAmtChocolate("8");
				r13.setAmtCoffee("7");
				r13.setAmtMilk("5");
				r13.setAmtSugar("4");
				r13.setPrice("6");

		cm.addRecipe(r1);
		cm.addRecipe(r1);
		cm.addRecipe(r2);

	} // End of setUp method


	// -------------------------------------------------------------------
	// tests addInventory & checkInventory methods in CoffeeMaker class
	// -------------------------------------------------------------------
	@Test
	public void testAddInventory() throws InventoryException {
		cm.addInventory("4","7","0","9");
	}
	
	@Test
	public void testAddInventory1() throws InventoryException {
		cm.addInventory("2","7","0","9");
	}
		
	@Test(expected = InventoryException.class)
	public void testAddInventoryException() throws InventoryException {
		cm.addInventory("4", "1", "abcd", "3");
	}
	
	@Test
	public void addInventoryTest()
	{
		String inv = cm.checkInventory();

		System.out.println("");
		System.out.println("Initial Inventory");
		System.out.println(inv);

		int initialCoffee = getIngredientCount(inv,"Coffee");
		int initialMilk = getIngredientCount(inv,"Milk");
		int initialSugar = getIngredientCount(inv,"Sugar");
		int initialChocolate = getIngredientCount(inv,"Chocolate");

		try
		{
			cm.addInventory("0","0","0","0");
		}
		catch (InventoryException e)
		{
			fail("InventoryException should not be thrown");
    		}

 		inv = cm.checkInventory();
		System.out.println("Final Inventory");
		System.out.println(inv);

		int finalCoffee = getIngredientCount(inv,"Coffee");
		int finalMilk = getIngredientCount(inv,"Milk");
		int finalSugar = getIngredientCount(inv,"Sugar");
		int finalChocolate = getIngredientCount(inv,"Chocolate");

		assertEquals((initialCoffee),finalCoffee );
		assertEquals((initialMilk), finalMilk );
		assertEquals((initialSugar), finalSugar );
		assertEquals((initialChocolate), finalChocolate );

	} // End of addInventoryTest method	
	
	@Test
	public void addInventoryTest1() 
	{
		String inv = cm.checkInventory();

		System.out.println("");
		System.out.println("Initial Inventory");
		System.out.println(inv);

		int initialCoffee = getIngredientCount(inv,"Coffee");
		int initialMilk = getIngredientCount(inv,"Milk");
		int initialSugar = getIngredientCount(inv,"Sugar");
		int initialChocolate = getIngredientCount(inv,"Chocolate");

		try
		{
			cm.addInventory("1","2","3","4");
		}
		catch (InventoryException e)
		{
			fail("InventoryException should not be thrown");
    		}

 		inv = cm.checkInventory();
		System.out.println("Final Inventory");
		System.out.println(inv);

		int finalCoffee = getIngredientCount(inv,"Coffee");
		int finalMilk = getIngredientCount(inv,"Milk");
		int finalSugar = getIngredientCount(inv,"Sugar");
		int finalChocolate = getIngredientCount(inv,"Chocolate");

		assertEquals((initialCoffee+1),finalCoffee );
		assertEquals((initialMilk+2), finalMilk );
		assertEquals((initialSugar+3), finalSugar );
		assertEquals((initialChocolate+4), finalChocolate );

	} // End of addInventoryTest method
	
	
	private int getIngredientCount(String inventory, String searchIngred)
	{
		int rv = -1;

		String[] allIngred = inventory.split("\n");

		for (int i = 0; i < allIngred.length; i ++)
		{
			if (allIngred[i].contains(searchIngred) && allIngred[i].contains(":"))
			{
				String[] singleIngred = allIngred[i].split(":");
				rv = Integer.parseInt(singleIngred[1].trim());
			} // End of if - finding our ingredient and setting return
		} // End of for looping through ingredients

		return rv;

	} // End of getIngredientCount method


	// -------------------------------------------------------------------
	// tests addRecipe method in CoffeeMaker class
	// -------------------------------------------------------------------
	@Test
	public void testAddRecipe() throws RecipeException {
		cm.addRecipe(r4);
	}
	
	@Test
	public void testAddRecipe1() throws RecipeException {
		cm.addRecipe(r5);
	}

	@Test
	public void testAddRecipe2() throws RecipeException {
		assertTrue(cm.addRecipe(r6));

		assertFalse(cm.addRecipe(r6));
	}
	
	@Test
	public void addRecipeTest() throws Exception
	{
		Recipe [] recipeArray = cm.getRecipes();

		assertEquals(recipeArray[0].getName(),"Coffee1" );
		assertEquals(recipeArray[0].getAmtChocolate(),1);
		assertEquals(recipeArray[0].getAmtCoffee(),2);
		assertEquals(recipeArray[0].getAmtMilk(),3);
		assertEquals(recipeArray[0].getAmtSugar(),4); 
		assertEquals(recipeArray[0].getPrice(),5);

		assertEquals(recipeArray[1].getName(),"Coffee2" );
		assertEquals(recipeArray[1].getAmtChocolate(),6);
		assertEquals(recipeArray[1].getAmtCoffee(),7);
		assertEquals(recipeArray[1].getAmtMilk(),8);
		assertEquals(recipeArray[1].getAmtSugar(),9);
		assertEquals(recipeArray[1].getPrice(),10);
				
	} // End of addRecipeTest method


	// -------------------------------------------------------------------
	// tests deleteRecipe method & getRecipes methods in CoffeeMaker class
	// -------------------------------------------------------------------
	@Test
	public void testDeleteRecipe() throws RecipeException {
		cm.deleteRecipe(0);
	}
	
	@Test
	public void testDeleteRecipe1() throws RecipeException {
		cm.deleteRecipe(1);
	}
	
	@Test
	public void testDeleteRecipe2() throws RecipeException {
		cm.deleteRecipe(-1);
	}
	
	@Test
	public void testDeleteRecipe3() throws RecipeException {
		cm.deleteRecipe(3);
	}

	@Test
	public void deleteRecipeTest() throws Exception
	{
		Recipe [] recipeArray = cm.getRecipes();

		// Ensure that the recipe does exist prior to deleting it
		assertEquals(recipeArray[0].getName(),"Coffee1");

		cm.deleteRecipe(0);	
		
		recipeArray = cm.getRecipes();
		assertEquals(recipeArray[0].getName(),"");

	} // End of deleteRecipeTest method


	// -------------------------------------------------------------------
	// tests editRecipe method in CoffeeMaker class
	// -------------------------------------------------------------------
	@Test
	public void testEditRecipe() throws RecipeException {
		cm.editRecipe(-2,r4);
	}
	
	@Test
	public void testEditRecipe1() throws RecipeException {
		cm.editRecipe(8,r4);
	}
	
	@Test(expected = RecipeException.class)
	public void testEditRecipeException1() throws RecipeException {
		//addRecipes();
				Recipe [] recipeArray = cm.getRecipes();

				// Ensure that the recipe does exist prior to editing it
				assertEquals(recipeArray[0].getName(),"Coffee1" );

				//Set up for r3
				r1 = new Recipe();
				r1.setName("Coffee3");
				r1.setAmtChocolate("4");
				r1.setAmtCoffee("3");
				r1.setAmtMilk("2");
				r1.setAmtSugar("1");
				r1.setPrice("a");

				cm.editRecipe(0, r1);

				recipeArray = cm.getRecipes();
				assertEquals(recipeArray[0],r1);

				// Ensure that the new recipe does exist
				//assertEquals(recipeArray[0].getName(),"Coffee3" );
	}
	
	@Test(expected = RecipeException.class)
	public void testEditRecipeException2() throws RecipeException {
		//addRecipes();
				Recipe [] recipeArray = cm.getRecipes();

				// Ensure that the recipe does exist prior to editing it
				assertEquals(recipeArray[0].getName(),"Coffee1" );

				//Set up for r3
				r1 = new Recipe();
				r1.setName("Coffee3");
				r1.setAmtChocolate("4");
				r1.setAmtCoffee("3");
				r1.setAmtMilk("2");
				r1.setAmtSugar("1");
				r1.setPrice("-10");

				cm.editRecipe(0, r1);

				recipeArray = cm.getRecipes();
				assertEquals(recipeArray[0],r1);

				// Ensure that the new recipe does exist
				//assertEquals(recipeArray[0].getName(),"Coffee3" );
	}
	
	@Test
	public void editRecipeTest() throws Exception
	{
		//addRecipes();
		Recipe [] recipeArray = cm.getRecipes();

		// Ensure that the recipe does exist prior to editing it
		assertEquals(recipeArray[0].getName(),"Coffee1" );

		//Set up for r3
		r3 = new Recipe();
		r3.setName("Coffee3");
		r3.setAmtChocolate("4");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("2");
		r3.setAmtSugar("1");
		r3.setPrice("10");

		cm.editRecipe(0, r3);

		recipeArray = cm.getRecipes();
		assertEquals(recipeArray[0],r3);

		// Ensure that the new recipe does exist
		//assertEquals(recipeArray[0].getName(),"Coffee3" );

	} // End of editRecipeTest

	// -------------------------------------------------------------------
	// tests makeCoffee method in CoffeeMaker class
	// -------------------------------------------------------------------
	@Test
	public void makeCoffeeTest() throws Exception
	{
		int result;

		// Recipe does not exist return money entered
		result = cm.makeCoffee(2,20);
		assertEquals(result,20);
		
		// Recipe is in negative return money entered
		result = cm.makeCoffee(-2,20);
		assertEquals(result,20);
		
		// Recipe entered is not there return money entered
		result = cm.makeCoffee(20,20);
		assertEquals(result,20);
		
		// Enough money supplied. Make coffee and return the change. Price is 10
		result = cm.makeCoffee(1,20);
		assertEquals(result,10);

		// Not enough money given, return money entered - Price is 10
		result = cm.makeCoffee(1,1);
		assertEquals(result,1);

		// Enough money supplied, but we ran out of sugar so refund the amount
		result = cm.makeCoffee(1,20);
		assertEquals(result,20);
		

	} // End of makeCoffeeTest

} // End of CoffeeMakerTest class

public class CoffeeMakerTest
{

	private CoffeeMaker cm;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;

	@Before
	public void setUp() throws Exception
	{
		cm = new CoffeeMaker();

		//Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee1");
		r1.setAmtChocolate("1");
		r1.setAmtCoffee("2");
		r1.setAmtMilk("3");
		r1.setAmtSugar("4");
		r1.setPrice("5");

		//Set up for r2
		r2 = new Recipe();
		r2.setName("Coffee2");
		r2.setAmtChocolate("6");
		r2.setAmtCoffee("7");
		r2.setAmtMilk("8");
		r2.setAmtSugar("9");
		r2.setPrice("10");

		cm.addRecipe(r1);
		cm.addRecipe(r2);

	} // End of setUp method


	// -------------------------------------------------------------------
	// tests addInventory & checkInventory methods in CoffeeMaker class
	// -------------------------------------------------------------------
	@Test
	public void addInventoryTest()
	{
		String inv = cm.checkInventory();

		System.out.println("");
		System.out.println("Initial Inventory");
		System.out.println(inv);

		int initialCoffee = getIngredientCount(inv,"Coffee");
		int initialMilk = getIngredientCount(inv,"Milk");
		int initialSugar = getIngredientCount(inv,"Sugar");
		int initialChocolate = getIngredientCount(inv,"Chocolate");

		try
		{
			cm.addInventory("1","2","3","4");
		}
		catch (InventoryException e)
		{
			fail("InventoryException should not be thrown");
    		}

 		inv = cm.checkInventory();
		System.out.println("Final Inventory");
		System.out.println(inv);

		int finalCoffee = getIngredientCount(inv,"Coffee");
		int finalMilk = getIngredientCount(inv,"Milk");
		int finalSugar = getIngredientCount(inv,"Sugar");
		int finalChocolate = getIngredientCount(inv,"Chocolate");

		assertEquals((initialCoffee + 1),finalCoffee );
		assertEquals((initialMilk + 2), finalMilk );
		assertEquals((initialSugar + 3), finalSugar );
		assertEquals((initialChocolate + 4), finalChocolate );

	} // End of addInventoryTest method


	private int getIngredientCount(String inventory, String searchIngred)
	{
		int rv = -1;

		String[] allIngred = inventory.split("\n");

		for (int i = 0; i < allIngred.length; i ++)
		{
			if (allIngred[i].contains(searchIngred) && allIngred[i].contains(":"))
			{
				String[] singleIngred = allIngred[i].split(":");
				rv = Integer.parseInt(singleIngred[1].trim());
			} // End of if - finding our ingredient and setting return
		} // End of for looping through ingredients

		return rv;

	} // End of getIngredientCount method


	// -------------------------------------------------------------------
	// tests addRecipe method in CoffeeMaker class
	// -------------------------------------------------------------------
	@Test
	public void addRecipeTest() throws Exception
	{
		Recipe [] recipeArray = cm.getRecipes();

		assertEquals(recipeArray[0].getName(),"Coffee1" );
		assertEquals(recipeArray[0].getAmtChocolate(),1);
		assertEquals(recipeArray[0].getAmtCoffee(),2);
		assertEquals(recipeArray[0].getAmtMilk(),3);
		assertEquals(recipeArray[0].getAmtSugar(),4);
		assertEquals(recipeArray[0].getPrice(),5);

		assertEquals(recipeArray[1].getName(),"Coffee2" );
		assertEquals(recipeArray[1].getAmtChocolate(),6);
		assertEquals(recipeArray[1].getAmtCoffee(),7);
		assertEquals(recipeArray[1].getAmtMilk(),8);
		assertEquals(recipeArray[1].getAmtSugar(),9);
		assertEquals(recipeArray[1].getPrice(),10);

	} // End of addRecipeTest method


	// -------------------------------------------------------------------
	// tests deleteRecipe method & getRecipes methods in CoffeeMaker class
	// -------------------------------------------------------------------
	@Test
	public void deleteRecipeTest() throws Exception
	{
		Recipe [] recipeArray = cm.getRecipes();

		// Ensure that the recipe does exist prior to deleting it
		assertEquals(recipeArray[0].getName(),"Coffee1");

		String result = cm.deleteRecipe(0);

		// Ensure that the recipe does NOT exist after deleting it
		assertEquals(recipeArray[0].getName(),"");

	} // End of deleteRecipeTest method


	// -------------------------------------------------------------------
	// tests editRecipe method in CoffeeMaker class
	// -------------------------------------------------------------------
	@Test
	public void editRecipeTest() throws Exception
	{
		//addRecipes();
		Recipe [] recipeArray = cm.getRecipes();

		// Ensure that the recipe does exist prior to editing it
		assertEquals(recipeArray[0].getName(),"Coffee1" );

		//Set up for r3
		r3 = new Recipe();
		r3.setName("Coffee3");
		r3.setAmtChocolate("4");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("2");
		r3.setAmtSugar("1");
		r3.setPrice("10");

		String result = cm.editRecipe(0, r3);

		recipeArray = cm.getRecipes();

		// Ensure that the new recipe does exist
		assertEquals(recipeArray[0].getName(),"Coffee3" );

	} // End of editRecipeTest

	// -------------------------------------------------------------------
	// tests makeCoffee method in CoffeeMaker class
	// -------------------------------------------------------------------
	@Test
	public void makeCoffeeTest() throws Exception
	{
		int result;

		// Recipe does not exist return money entered
		result = cm.makeCoffee(2,20);
		assertEquals(result,20);

		// Enough money supplied. Make coffee and return the change. Price is 10
		result = cm.makeCoffee(1,20);
		assertEquals(result,10);

		// Not enough money given, return money entered - Price is 10
		result = cm.makeCoffee(1,1);
		assertEquals(result,1);

		// Enough money supplied, but we ran out of sugar so refund the amount
		result = cm.makeCoffee(1,20);
		assertEquals(result,20);

	} // End of makeCoffeeTest

} // End of CoffeeMakerTest class
