package deliverable4;

import org.apache.commons.lang3.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/*
 * Important to note that the value of 100000 was used to improve performance.
*/
public class arraysTest {
	//ArrayList with all arrays
	static ArrayList<int[]> arrays = new ArrayList<int[]>();
	static int numOfArrays = 100;
	@BeforeClass
	public static void fillArrays() {
		Random random = new Random();
		int size = random.nextInt(Integer.MAX_VALUE/100000);
		int value;
		//Edge cases below
		
		//Empty array edge case
		int edge1[] = new int[0];
		arrays.add(edge1);
		
		//Single element edge case
		int edge2[] = new int[1];
		arrays.add(edge2);
		
		//Negative array edge case
		int edge3[] = new int[size];
		for(int i = 0; i<size; i++){
			value = random.nextInt(Integer.MAX_VALUE)*-1;
			edge3[i] = value;
		}
		arrays.add(edge3);
		
		//Same element edge case
		size = random.nextInt(Integer.MAX_VALUE/100000);
		value = random.nextInt(Integer.MAX_VALUE/100000);
		int edge4[] = new int[size];
		for(int i=0; i<size; i++){
			edge4[i] = value;
		}
		arrays.add(edge4);
		
		//Already sorted array case
		size = random.nextInt(Integer.MAX_VALUE/100000);
		int edge5[] = new int[size];
		value = random.nextInt(Integer.MAX_VALUE/100000);
		for(int i =0; i<size; i++){
			edge5[i] = (value*2)+1;
		}
		arrays.add(edge5);
		
		//Max int array case
		size = random.nextInt(Integer.MAX_VALUE/100000);
		value = Integer.MAX_VALUE;
		int edge6[] = new int[size];
		for(int i =0; i<size; i++){
			edge6[i] = value;
		}
		arrays.add(edge6);
		
		//Reverse sorted array case
		size = random.nextInt(Integer.MAX_VALUE/100000);
		value = random.nextInt(Integer.MAX_VALUE/100000);
		int edge7[] = new int[size];
		for(int i =0; i<size; i++){
			edge7[i] = (value/2)-1;
		}
		arrays.add(edge7);
		
		//the rest of the arrays being populated with random values.
		for(int i=0; i<numOfArrays; i++)
		{
			size = random.nextInt(Integer.MAX_VALUE/100000);
			int temp[] = new int[size];
			for(int j = 0; j<size; j++){
				value = random.nextInt();
				temp[j] = value; 
			}
			arrays.add(temp);
		}
		
	}
	@Test
	public void sizeTest(){
		for(int i =0; i<numOfArrays; i++){
			int array[] = arrays.get(i);
			int sizeBefore = array.length;
			Arrays.sort(array);
			int sizeAfter = array.length;
			assertEquals(sizeBefore, sizeAfter);
		}
	}	
	@Test
	public void identicalSort(){
		for(int i = 0; i<numOfArrays; i++){
			int array[] = arrays.get(i);
			int copy[] = array;
			Arrays.sort(array);
			Arrays.sort(copy);
			assertEquals(array, copy);
		}
	}
	@Test
	public void sameElements(){
		for(int i =0; i<numOfArrays; i++){
			int array[] = arrays.get(i);
			int copy[] = array;
			Arrays.sort(array);
			for(int j=0; j<array.length; j++){
				if(!ArrayUtils.contains(copy, array[j])){
					fail("Not the same elements!");
				}
			}
		}
		assertTrue(true);
	}
		
	
}
