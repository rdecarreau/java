import java.util.Arrays;

public class Sorting {

  public int[] SelectionSort(int[] lst) {
    int total = 0;
    for(int i=0; i<lst.length; i++) {
      int smallest = lst[i];
      int smallest_idx = i;
      for(int j=i; j<lst.length; j++) {
        if(lst[j] < smallest) {
          smallest = lst[j];
          smallest_idx = j;
        }
        total++;
      }
      total++;
      int temp = lst[i];
      lst[i] = smallest;
      lst[smallest_idx] = temp;
      return lst;
    }
  }

  public static int[] BubbleSort(int[] lst) {
    // This is not exactly bubble sort.
    int j = 0;
    while(j<lst.length) {
      for(int i=0; i<lst.length-1; i++) {
        if(lst[i]>lst[i+1]) {
          // Swap
          int temp = lst[i];
          lst[i] = lst[i+1];
          lst[i+1] = temp;
        }
      }
      j++;
    }
  return lst;
  }

  public static int[] BubbleSort2(int[] lst) {
    boolean swapped;
    do {
      swapped = false;
      for(int i=0; i<lst.length-1; i++) {
        if(lst[i]>lst[i+1]) {
          // Swap
          int temp = lst[i];
          lst[i] = lst[i+1];
          lst[i+1] = temp;
          swapped = true;
        }
        System.out.println(Arrays.toString(lst));
      }
    } while(swapped);
  return lst;
  }

  public static int[] mergeSort(int[] lst) {
    int a = lst.length;
    int[] left = Arrays.copyOfRange(lst, 0, a/2);
    int[] right = Arrays.copyOfRange(lst, left.length, a);
    if (left.length > 2) {
      left = mergeSort(left);
    }
    else {
      left = swap(left);
    }
    if (right.length > 2) {
      right = mergeSort(right);
    }
    else {
      right = swap(right);
    }
    return merge(left, right);
  }
  public static int[] swap(int[] lst) {
    if(lst.length > 1) {
      if(lst[0] > lst[1]) {
        int temp = lst[0];
        lst[0] = lst[1];
        lst[1] = temp;
      }
    }
    return lst;
  }
  public static int[] merge(int[] left, int[] right) {
    int leftLen = left.length;
    int rightLen = right.length;
    int totalLen = leftLen + rightLen;
    int[] outList = new int[totalLen];
    int l = 0, r = 0;
    for(int i=0; i<totalLen; i++) {
      if(l >= leftLen) {
        outList[i] = right[r];
        r++;
      }
      else if(r >= rightLen) {
        outList[i] = left[l];
        l++;
      }
      else if(left[l] < right[r]) {
        outList[i] = left[l];
        l++;
      }
      else {
        outList[i] = right[r];
        r++;
      }
    }
    return outList;
  }
}