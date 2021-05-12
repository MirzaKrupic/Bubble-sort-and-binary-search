package ds.ipaddress.bubblesort;

public class BubbleSort {
	
	static boolean swapped;
	
	public static void sort(IPAddress[] elements) {
		for(int i = 0; i< elements.length; i++) {
			swapped = false;
			
			for(int j = 1; j< elements.length; j++) {
				if(elements[j - 1].compareTo(elements[j]) > 0) {
					swap(elements, j-1, j);
				}
			}
			
			if(swapped == false) {
				break;
			}
		}
	}

	public static void swap(IPAddress[] elements, int a, int b) {
		IPAddress tmp = elements[a];
		elements[a] = elements[b];
		elements[b] = tmp;
		swapped = true;
	}
}
