public class sorting {

  // O(N^2)-----------------------------------------------------------------
  public int[] insertionSort(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return nums;
    }
    for (int i = 1; i < nums.length; i++) {
      int j = i;
      while (j >= 1 && nums[j] < nums[j - 1]) {
        int temp = nums[j - 1];
        nums[j - 1] = nums[j];
        nums[j] = temp;
        j--;
      }
    }
    return nums;
  }

  // O(N^2), might be faster-----------------------------------------------
  public int[] insertionSort_withBinarySearchForInsertion(int[] nums) {
    if (nums == null || nums.length <= 1) {
      return nums;
    }
    for (int i = 1; i < nums.length; i++) {
      int val = nums[i];
      int index = binarySearch(nums, 0, i, nums[i]);
      for (int j = i; j > index; j--) {
        nums[j] = nums[j - 1];
      }
      nums[index] = val;

    }
    return nums;
  }

  public int binarySearch(int[] arr, int left, int right, int val) {
    if (left >= right) {
      if (arr[left] >= val) {
        return left;
      } else {
        return left + 1;
      }
    }
    if (val <= arr[(left + right) / 2]) {
      return binarySearch(arr, left, (left + right) / 2, val);
    } else {
      return binarySearch(arr, (left + right) / 2 + 1, right, val);
    }
  }

  /**
   * geeks for geeks: int j = Math.abs(Arrays.binarySearch(array, 0, i, x) + 1);
   * 
   * //Shifting array to one location right System.arraycopy(array, j, array, j+1, i-j);
   * 
   * //Placing element at its correct location array[j] = x;
   */


  // O(N*logN)-----------------------------------------------------
  public int[] mergesort(int[] arr, int left, int right) {
    if (left > right) {
      return null;
    }
    if (left == right) {
      return new int[] {arr[left]};
    }
    int lindex = 0, rindex = 0, index = 0;
    int[] re = new int[right - left + 1];
    int[] l = mergesort(arr, left, (left + right) / 2);
    int[] r = mergesort(arr, (left + right) / 2 + 1, right);

    while (l != null || r != null) {
      if (l != null && r != null) {
        if (l[lindex] <= r[rindex]) {
          re[index] = l[lindex];
          lindex++;
          index++;
          if (lindex >= l.length) {
            l = null;
          }
        } else {
          re[index] = r[rindex];
          rindex++;
          index++;
          if (rindex >= r.length) {
            r = null;
          }
        }
      } else if (l != null) {
        re[index] = l[lindex];
        lindex++;
        index++;
        if (lindex >= l.length) {
          l = null;
        }
      } else {
        re[index] = r[rindex];
        rindex++;
        index++;
        if (rindex >= r.length) {
          r = null;
        }
      }
    }


    return re;
  }


}
