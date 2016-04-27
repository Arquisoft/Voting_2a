package es.uniovi.asw.rest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RecuentoPieRestTest {

	private RecuentoPieRest rpr = new RecuentoPieRest();
	private RecuentoPieRest rpr1 = new RecuentoPieRest("Label1", "Value1");

	@Test
	public void testValue() {

		rpr.setValue("Value1");
		assertTrue(rpr.getValue().equals("Value1"));
		assertFalse(rpr.getValue() == null);

		rpr.setValue(null);
		assertFalse(rpr.getValue().equals(null));
		assertTrue(rpr.getValue().equals("Value1"));

		rpr.setValue("Value2");
		assertTrue(rpr.getValue().equals("Value2"));
		assertFalse(rpr.getValue().equals("Value1"));
		assertFalse(rpr.getValue().equals(null));

		rpr.setValue("");
		assertFalse(rpr.getValue().equals(""));
		assertTrue(rpr.getValue().equals("Value2"));
		assertFalse(rpr.getValue().equals("Value1"));
		assertFalse(rpr.getValue().equals(null));

	}

	@Test
	public void testLabel() {

		rpr.setLabel("Label2");
		assertTrue(rpr.getLabel().equals("Label2"));
		assertFalse(rpr.getLabel().equals(null));

		rpr.setLabel(null);
		assertTrue(rpr.getLabel().equals("Label2"));
		assertFalse(rpr.getLabel().equals(null));

		rpr.setLabel("Label4");
		assertTrue(rpr.getLabel().equals("Label4"));
		assertFalse(rpr.getLabel().equals("Label2"));
		assertFalse(rpr.getLabel().equals(null));

		rpr.setLabel("");
		assertFalse(rpr.getLabel().equals(""));
		assertTrue(rpr.getLabel().equals("Label4"));
		assertFalse(rpr.getLabel().equals("Label2"));
		assertFalse(rpr.getLabel().equals(null));

	}

	@Test
	public void testConstructor() {

		assertTrue(rpr1.getLabel().equals("Label1"));
		assertFalse(rpr1.getLabel().equals("Label3"));
		assertFalse(rpr1.getLabel().equals(null));
		assertFalse(rpr1.getLabel().equals(""));

		assertTrue(rpr1.getValue().equals("Value1"));
		assertFalse(rpr1.getValue().equals("Value2"));
		assertFalse(rpr1.getValue().equals(null));
		assertFalse(rpr1.getValue().equals(""));

	}

}
