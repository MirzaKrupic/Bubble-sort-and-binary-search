package ds.ipaddress.binarysearch;

import ds.ipaddress.bubblesort.IPAddress;

public class BinarySearch {
	

	public static int search(IPAddress[] elements, long key) {
		int low = 0;
		int high = elements.length - 1;	
		
		while (low <= high) {		
			int mid = low + (high - low) / 2;	
			if(key>= elements[mid].getIpFrom() && key<=elements[mid].getIpTo()) {
				return mid;
			}
			else if (key<elements[mid].getIpFrom()) {
				high = mid -1;
			}else low = mid + 1;
		}
		return -1;								
	}
}
