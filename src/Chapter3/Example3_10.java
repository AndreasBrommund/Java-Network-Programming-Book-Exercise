package Chapter3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Example3_10{
	public static int max(int[] data) throws InterruptedException, ExecutionException{
		if(data.length == 1){
			return data[0];
		}else if(data.length == 0){
			throw new IllegalArgumentException();
		}
		
		//Split the job into 2 pieces
		Example3_9 task1 = new Example3_9(data, 0, data.length/2);
		Example3_9 task2 = new Example3_9(data, data.length/2, data.length);
	
		//Spawn two threads 
		ExecutorService service = Executors.newFixedThreadPool(2);
		
		Future<Integer> future1 = service.submit(task1);
		Future<Integer> future2 = service.submit(task2);
		
		//The future2.get() (thread 2)  wait till the future1.get() (thread 1) is finished 
		
		return Math.max(future1.get(), future2.get()); 
	}
	
	public static void main(String[] args) {
		int[] ints = {1,2,3,4,5,56,43,11,31,3,3,4,3,2,423,4,4,5,352,1};
		try {
			System.out.println(max(ints));
		} catch (InterruptedException | ExecutionException e) { 
			e.printStackTrace();
		}
		
	}
}
