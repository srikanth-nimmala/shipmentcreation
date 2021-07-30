package com.monsanto.mbt;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShipmentTest {
	Shipment shipment;
	List<Widget> widgets;
	int maxShipmentSize = 10;

	@Before
	public void init() {
		shipment = new Shipment();
		widgets = WidgetUtils.getSampleWidgets();

	}

	@Test
	public void testShipment_Sorted_By_Color() {

		Shipment shipment = new Shipment();
		widgets = WidgetUtils.getSampleWidgets();

		List<Widget> shipmentSortedByColor = shipment.sortByCriteria(widgets, maxShipmentSize, "color");

		int actualShipmentSize = shipmentSortedByColor.size();

		assertTrue("Shipment size is <=10", actualShipmentSize <= maxShipmentSize);

		List<String> sortedArray = Arrays.asList("Blue", "Blue", "Blue", "Blue", "Blue", "Blue", "Green", "Green",
				"Green", "Green");

		for (int i = 0; i < actualShipmentSize; i++) {
			assertEquals(sortedArray.get(i), shipmentSortedByColor.get(i).getColor());

		}

	}

	@Test
	public void testShipment_Sorted_By_Date() {

		List<Widget> shipmentSortedByProdDate = shipment.sortByCriteria(widgets, maxShipmentSize, "prodDate");

		int actualShipmentSize = shipmentSortedByProdDate.size();

		List<String> sortedArray = Arrays.asList("09-01-2005", "09-01-2005", "01-01-2006", "01-12-2006", "03-09-2006",
				"03-14-2006", "02-03-2007", "02-13-2007", "07-01-2008", "07-01-2008");

		assertTrue("Shipment size is <=10", shipmentSortedByProdDate.size() <= maxShipmentSize);

		for (int i = 0; i < actualShipmentSize; i++) {
			assertEquals(WidgetUtils.stringToDateConverter(sortedArray.get(i)),
					shipmentSortedByProdDate.get(i).getProductionDate());

		}

	}

}
