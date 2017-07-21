package com.collectionexample.map;

import java.util.WeakHashMap;
// it is use for cache data
public class WeakHashMapExample {
	public static void main(String[] args) {
		// -- Fill a weak hash map with one entry
		WeakHashMap<Data, String> map = new WeakHashMap<Data, String>();
		Data someDataObject = new Data("foo");
		map.put(someDataObject, someDataObject.value);
		System.out.println("map contains someDataObject ? "	+ map.containsKey(someDataObject));

		// -- now make someDataObject elligible for garbage collection...
		someDataObject = null;

		for (int i = 0; i < 10000; i++) {
			if (map.size() != 0) {
				System.out
						.println("At iteration "
								+ i
								+ " the map still holds the reference on someDataObject");
			} else {
				System.out
						.println("somDataObject has finally been garbage collected at iteration "
								+ i + ", hence the map is now empty");
				break;
			}
		}
	}

	static class Data {
		String value;
		Data(String value) {
			this.value = value;
		}
	}

}
