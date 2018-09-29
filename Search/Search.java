import java.util.Arrays;
import java.lang.Math;
public class Search {
  public static boolean BinarySearch(int[] lst, int target) {
    if(lst.length == 1) {
      return lst[0] == target;
    }
    // find median
    int median = (int)Math.ceil(lst.length / 2);
    // check if number is ==
    if(lst[median] == target) {
      return true;
    }
    // check if number is >
    else if(target > lst[median]) {
      //split right half
      return BinarySearch(Arrays.copyOfRange(lst, median, lst.length), target);
    }
    // check if number is <
    else {
      //split left half
      return BinarySearch(Arrays.copyOfRange(lst, 0, median), target);
    }
  }
}