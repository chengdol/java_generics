package arrays;

import java.util.Arrays;

public class demo
{
	public static void main(String[] args)
	{
		Integer[] ints = new Integer[] {1,2,3,4,5};
		Number[] nums = ints; // ti's ok since Integer[] is subtype of Number[]
		// will be a exception
		// caught at run time
		nums[0] = 1.91;
		assert Arrays.toString(nums).equals("[1.99, 2, 3, 4, 5]");

	}
}
