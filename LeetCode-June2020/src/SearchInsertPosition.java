
public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		int index = 0;
		int resultPos = 0;
		while (index < nums.length) {
			if (target == nums[index]) {
				return index;
			} else {
				if (target < nums[index]) {
					return index;
				}
			}
			index++;
		}
		resultPos = nums.length;
		return resultPos;
	}

	public static void main(String[] args) {
		SearchInsertPosition sInsertPos = new SearchInsertPosition();
		int nums[] = { 1, 3, 5, 6 };
		int target = 2;
		System.out.println(sInsertPos.searchInsert(nums, target));
	}
}
