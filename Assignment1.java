import java.util.Arrays;
public class Assignment1 
{ 
	public static void main(String[] args) 
	{
		Integer[] array = new Integer[100];

		for (int i = 0; i < 100; i++) 
		{
			array[i] = (int) (Math.random() * ((10000 - 1) + 1)) + 1;
		}
		
		System.out.println("Original Unsorted Order: " + Arrays.toString(array));
		
		MergeSort<Integer> merge = new MergeSort<Integer>(array);
		
	
		merge.start();
		
		
		try {
			merge.join();
		
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			
		}
		
		merge.getSortedValues(array);
		System.out.println("Sorted Order: " + Arrays.toString(array));
	}

}
