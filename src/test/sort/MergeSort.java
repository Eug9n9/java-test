package test.sort;

public class MergeSort {
	private int[] numbers;
	private int[] helper;

	public static void main(String[] args) {
		int[] arr = { 1, 12, 5, 26, 7, 14, 3, 7, 2 };
		MergeSort ms = new MergeSort();
		ms.print(arr);
		ms.sort(arr);
		ms.print(arr);
	}

	public void sort(int[] values) {
		this.numbers = values;
		this.helper = new int[values.length];
		mergesort(0, values.length - 1);
	}

	private void mergesort(int low, int high) {
		// check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			System.out.println("Pivot: a[" + middle + "] = " + numbers[middle]);
			// Sort the left side of the array
			mergesort(low, middle);
			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
			print(numbers);
		}
	}

	private void merge(int low, int middle, int high) {
		System.out.println("Combining: a[" + middle + "] = " + numbers[middle]);

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = numbers[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				numbers[k] = helper[i];
				System.out.println("Taking left: a[" + i + "] = " + helper[i]);
				i++;
			} else {
				numbers[k] = helper[j];
				System.out.println("Taking right: a[" + j + "] = " + helper[j]);
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			numbers[k] = helper[i];
			System.out.println("Taking the rest: a[" + i + "] = " + helper[i]);
			k++;
			i++;
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
