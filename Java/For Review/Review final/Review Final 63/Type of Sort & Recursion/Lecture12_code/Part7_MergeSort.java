import java.util.Arrays;

public class Part7_MergeSort {

	public static void main(String[] args) {
		int[] a = {9, 7, 8, 5, 2, 4, 6, 3, 1};
		System.out.println("Unsorted Array");
		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println("Sorted Array");
		System.out.println(Arrays.toString(a));
	}

	public static void sort (int[] a) {
		if (a.length <= 1)
			return;
		int hSize = a.length / 2;
		int[] lTab = new int[hSize];
		int[] rTab = new int[a.length - hSize];
		System.arraycopy(a, 0, lTab, 0, hSize);
		System.arraycopy(a, hSize, rTab, 0, a.length-hSize);
		sort(lTab);
		sort(rTab);
		merge(a, lTab, rTab);
	}
	
	static void merge (int[] a, int[] l, int[] r) {
		int i = 0; // indexes l
		int j = 0; // indexes r
		int k = 0; // indexes a
		while (i < l.length && j < r.length)
			if (l[i] < r[j])
				a[k++] = l[i++];
			else
				a[k++] = r[j++];
		
		while (i < l.length)
			a[k++] = l[i++];
		while (j < r.length)
			a[k++] = r[j++];
	}
}
