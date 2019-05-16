import java.util.Arrays;
public class MergeSort<AnyType extends Comparable<? super AnyType>> extends Thread
{
	private AnyType[] v;

	public MergeSort(AnyType[] items)
	{
		v = Arrays.copyOfRange(items, 0, items.length);
	}	

	public void getSortedValues(AnyType[] items)
	{
		
		for (int i = 0; i < items.length; i++) 
			items[i] = v[i];
	}
	
	public void run()
	{  
		int  mid;
		AnyType[] v1, v2;
	
		if (v.length <= 1) 
			return;
		
		mid = ( v.length / 2);
		

		v1 = Arrays.copyOfRange(v, 0, mid);
		v2 = Arrays.copyOfRange(v, mid, v.length);
		
		MergeSort<AnyType> thrd1 = new MergeSort<AnyType>(v1);
		MergeSort<AnyType> thrd2 = new MergeSort<AnyType>(v2);
		
		thrd1.start();
		thrd2.start();
		
		try {
			thrd1.join();
			thrd2.join();
	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
		merge(thrd1.v, thrd2.v);
		
	}
	
	private void merge(AnyType[] v1, AnyType[] v2)
	{
		int i, j, n1, n2;
		i = 0;               
		j = 0;				 
		n1 = v1.length;		
		n2 = v2.length;

		int r = 0;
		while( i < n1 && j < n2 )
		{   
			if( v1[i].compareTo(v2[j]) < 0 ) 
				v[r++] = v1[i++];
			
			else if( v2[j].compareTo(v1[i]) < 0 ) 
				v[r++] = v2[j++];
			else 
				v[r++] = v1[i++];
		}   
		
		while( i < n1)
		{
			v[r++] = v1[i++];
		}        

		while( j < n2)
	    {
			v[r++] = v2[j++];
		}        
		
	}
}
