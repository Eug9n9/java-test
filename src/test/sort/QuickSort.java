package test.sort;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 1, 12, 5, 26, 7, 14, 3, 7, 2 };
		QuickSort qs = new QuickSort();
		qs.sort(arr, 0, arr.length - 1);
		qs.print(arr);
	}

	private void sort(int[] a, int start, int end) {
		print(a);
		int i = start;
		int j = end;
		int p = (j + i)/2;
		int pivot = a[p];
		System.out.println("Pivot: a[" + p + "] = " + pivot);

		while (i <= j) {
			while (a[i] < pivot) {
				// move i
				i++;
			}
			while (a[j] > pivot) {
				// move j
				j--;
			}

			if (i <= j) {
				System.out.println("Swapping: a[" + i + "], a[" + j + "]");

				int z = a[i];
				a[i] = a[j];
				a[j] = z;

				i++;
				j--;

				print(a);
			}
		}
		System.out.println("Pivot: a[" + p + "] ended");

		if (i > start + 1) {
			sort(a, start, i - 1);
		}
		if (i < end) {
			sort(a, i, end);
		}
	}

	private void print(int[] a) {
		System.out.print("{");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i != a.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}
}
