import java.util.ArrayList;

public class QueueReconstructionHeight {

	public int[][] reconstructQueue(int[][] people) {
		// sort the array with below rules.
		// 1. descending order of h. 2. For same height, k with smaller will come first.
		int[][] tempArr = new int[people.length][2];
		mergeSort(people, tempArr, 0, people.length - 1);
		
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < people.length; i++) {
			int[] arr = people[i];
			list.add(arr[1], arr); // Insert array at kth position.
		}
		int[][] result = new int[people.length][2];
		result = list.toArray(result);
		return result;
	}

	void mergeSort(int arr[][], int tempArr[][], int low, int high) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			mergeSort(arr, tempArr, low, mid);
			mergeSort(arr, tempArr, mid + 1, high);
			merge(arr, tempArr, low, mid, high);
		}
	}

	void merge(int arr[][], int tempArr[][], int low, int mid, int high) {
		int l = low;
		int r = mid + 1;
		int k = low;

		while (l <= mid && r <= high) {
			if (arr[l][0] > arr[r][0]) {
				tempArr[k++] = arr[l++];
			} else if (arr[l][0] < arr[r][0])
				tempArr[k++] = arr[r++];
			else {
				if (arr[l][1] < arr[r][1]) {
					tempArr[k++] = arr[l++];
				} else {
					tempArr[k++] = arr[r++];
				}
			}
		}

		while (l <= mid) {
			tempArr[k++] = arr[l++];
		}

		while (r <= high) {
			tempArr[k++] = arr[r++];
		}

		for (int i = low; i <= high; i++) {
			arr[i] = tempArr[i];
		}
	}

	public static void main(String[] args) {
		QueueReconstructionHeight qReconsHeight = new QueueReconstructionHeight();
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		qReconsHeight.reconstructQueue(people);
	}
}
