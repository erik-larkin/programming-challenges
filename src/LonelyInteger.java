/*
 *  https://www.hackerrank.com/challenges/one-week-preparation-kit-lonely-integer/problem
 *  August 29th 2023
 *  By Erik Larkin
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyInteger {

	public static int lonelyinteger(List<Integer> a) {
    	
		Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();

		for (int number : a) {
			int newFrequency = 1;

			if (frequencies.containsKey(number)) {
				newFrequency += frequencies.get(number);
			}

			frequencies.put(number, newFrequency);
		}

		for (int key : frequencies.keySet()) {
			if (frequencies.get(key) == 1) {
				return key;
			}
		}

		return -1;
    }
}
