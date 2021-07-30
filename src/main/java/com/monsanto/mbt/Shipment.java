package com.monsanto.mbt;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shipment {

	/*
	 * This method sorts the widget list based on searchparam and maximum size
	 */
	public List<Widget> sortByCriteria(List<Widget> widgetList, int size, String searchParam) {

		if (widgetList != null) {

			if (searchParam.equalsIgnoreCase("color"))
				Collections.sort(widgetList, new Comparator<Widget>() {

					public int compare(Widget obj1, Widget obj2) {	
						return obj1.getColor().toUpperCase().compareTo(obj2.getColor().toUpperCase());
					}
				});

			else if (searchParam.equalsIgnoreCase("prodDate"))
				Collections.sort(widgetList, new Comparator<Widget>() {

					public int compare(Widget obj1, Widget obj2) {
						return obj1.getProductionDate().compareTo(obj2.getProductionDate());
					}
				}

				);
			return widgetList.subList(0, size >= widgetList.size() ? widgetList.size() : size);
		}
		return null;

	}
}
