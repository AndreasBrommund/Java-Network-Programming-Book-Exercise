package Chapter3;

import java.util.concurrent.Callable;


public class Example3_9 implements Callable<Integer>{

	private int[] data; 
	private int start; 
	private int end; 
	
	public Example3_9(int[] data, int start ,int end) {
		this.data = data;
		this.start = start;
		this.end = end; 
	}

	public Integer call() throws Exception {
		int max = 0; 
		for(int i = start; i < end;i++){
			if(data[i]>max)
				max = data[i];
		}
		return max;
	}
	
}
