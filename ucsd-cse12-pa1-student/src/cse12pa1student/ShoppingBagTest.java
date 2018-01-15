package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ShoppingBagTest {

	public static Collection<Object[]> BAGNUMS = Arrays.asList(
			new Object[][] { { 0 }, { 1 }, { 2 }, { 3 }, { 4 }, { 5 }, { 6 }, { 7 }, { 8 }, { 9 }, { 10 }, { 11 } });
	private int bagType;

	public ShoppingBagTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Bag{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}

	private ShoppingBag makeBag() {
		switch (this.bagType) {
		case 0:
			return new Bag0();
		case 1:
			return new Bag1();
		case 2:
			return new Bag2();
		case 3:
			return new Bag3();
		case 4:
			return new Bag4();
		case 5:
			return new Bag5();
		case 6:
			return new Bag6();
		case 7:
			return new Bag7();
		case 8:
			return new Bag8();
		case 9:
			return new Bag9();
		case 10:
			return new Bag10();
		case 11:
			return new Bag11();
		}
		return null;
	}

	@Test
	public void addedHasCount1() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		bagToTest.add(i);
		assertEquals(bagToTest.totalCount(), 1);
	}

	@Test
	public void addDuplicate() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Shampoo", 5);
		bagToTest.add(i);
		bagToTest.add(j);
		bagToTest.add(new Item("Lotion", 10));
		bagToTest.add(new Item("Lotion", 10));
		assertEquals(bagToTest.itemCount(i), 2);
		assertEquals(bagToTest.totalCount(), 4);
	}

	@Test
	public void addALot() {
		ShoppingBag bagToTest = makeBag();

		Item[] itemList = { new Item("Shampoo", 5), new Item("Lotion", 10), new Item("Cream", 20),
				new Item("Conditioner", 15), new Item("Toothpaste", 3) };
		for (int i = 0; i < itemList.length; i++) {
			for (int j = 0; j < 10000; j++) {
				bagToTest.add(itemList[i]);
			}
		}
		assertEquals(bagToTest.itemCount(new Item("Shampoo", 5)), 10000);
		assertEquals(bagToTest.totalCount(), 50000);
	}

	@Test
	public void singleRemoval() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		bagToTest.add(i);
		bagToTest.add(i);
		assertEquals(bagToTest.removeOne(new Item("Lotion", 10)), false);
		assertEquals(bagToTest.removeOne(i), true);
		assertEquals(bagToTest.itemCount(i), 1);
		assertEquals(bagToTest.removeOne(i), true);
		assertEquals(bagToTest.totalCount(), 0);
	}

	@Test
	public void removeNonExist() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		assertEquals(bagToTest.removeOne(i), false);
		assertEquals(bagToTest.removeAll(i), false);
	}

	@Test
	public void removeAll() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		bagToTest.add(i);
		bagToTest.add(i);
		boolean test = bagToTest.removeAll(i);
		assertEquals(bagToTest.removeAll(new Item("Lotion", 10)), false);
		assertEquals(bagToTest.itemCount(i), 0);
		assertEquals(test, true);
		assertEquals(bagToTest.totalCount(), 0);
	}

	@Test
	public void empty() {
		ShoppingBag bagToTest = makeBag();

		Item[] itemList = { new Item("Shampoo", 5), new Item("Lotion", 10), new Item("Cream", 20),
				new Item("Conditioner", 15), new Item("Toothpaste", 3) };
		for (int i = 0; i < itemList.length; i++) {
			for (int j = 0; j < 5; j++) {
				bagToTest.add(itemList[i]);
			}
		}
		bagToTest.empty();
		assertEquals(bagToTest.totalCount(), 0);
	}

	@Test
	public void totalPrice() {
		ShoppingBag bagToTest = makeBag();

		bagToTest.add(new Item("Shampoo", 5));
		bagToTest.add(new Item("Shampoo", 5));
		bagToTest.add(new Item("Lotion", 10));
		assertEquals(bagToTest.totalPrice(), 20);
	}

	@Test
	public void emptyBag() {
		ShoppingBag emptyBag = makeBag();

		assertEquals(emptyBag.totalCount(), 0);
		/*
		 * assertEquals(emptyBag.totalPrice(), 0);
		 * assertEquals(emptyBag.itemCount(new Item("Shampoo", 5)), 0);
		 */
	}

	@Test
	public void extortionatePrice() {
		ShoppingBag bagToTest = makeBag();

		bagToTest.add(new Item("estate", 1000000));
		assertEquals(bagToTest.totalPrice(), 1000000);
	}

	@Test
	public void removeNull() {
		ShoppingBag bagToTest = makeBag();

		Item i = null;
		bagToTest.add(i);
		assertEquals(bagToTest.totalCount(), 0);
	}

	@Test
	public void addAndRemove() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		bagToTest.add(i);
		bagToTest.removeOne(i);
		bagToTest.add(i);
		bagToTest.removeOne(i);
		bagToTest.add(i);
		assertEquals(bagToTest.itemCount(i), 1);
	}

	@Test
	public void removeAll2() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Lotion", 10);
		bagToTest.add(i);
		bagToTest.add(i);
		bagToTest.add(j);
		bagToTest.removeAll(i);
		assertEquals(bagToTest.itemCount(j), 1);
	}

	@Test
	public void itemCount() {
		ShoppingBag bagToTest = makeBag();

		Item i = new Item("Shampoo", 5);
		Item j = new Item("Lotion", 10);
		Item k = new Item("Cream", 20);
		bagToTest.add(i);
		bagToTest.add(i);
		bagToTest.add(j);
		bagToTest.add(j);
		assertEquals(bagToTest.itemCount(k), 0);
	}

	
}
