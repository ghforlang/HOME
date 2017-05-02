package com.edu.nbu.collection.list;

public class TestSort {
	public static void main(String[] args) {
		int[] a = { 4, 5, 6, 3, 2, 1 };
		sort(a, 0, a.length - 1);
		for (int i : a) {
			 System.out.print( ","+i);
		}
		System.out.println();
		System.out.println(binarySearch0(a, 0, a.length-1, 5));
	}

	public static void sort(int[] a, int left, int right) {
		for (int i = left, j = i; i < right; j = ++i) {
			int ai = a[i + 1];
			while (ai < a[j]) {
				a[j + 1] = a[j];
				if (j-- == left) {
					break;
				}
			}
			a[j + 1] = ai;
		}
	}

	private static int binarySearch0(int[] a, int fromIndex, int toIndex,
			int key) {
		int low = fromIndex;
		int high = toIndex;

		while (low <= high) {
			int mid = (low + high) >>> 1;
			int midVal = a[mid];

			if (midVal < key)
				low = mid + 1;
			else if (midVal > key)
				high = mid - 1;
			else
				return mid; // key found
		}
		return -(low + 1); // key not found.
	}
}
