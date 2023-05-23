package com.solvd.flightreservation.utilities;

import java.util.LinkedList;

public class MyLinkedList<Flight> extends LinkedList<Flight> {
	public String LinkedListToString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.size(); i++) {
			if (i == this.size() - 1) {
				sb.append(this.get(i));
			} else {
				sb.append(this.get(i));
				sb.append("get the information  ");
			}

		}
		return sb.toString();
	}
}
