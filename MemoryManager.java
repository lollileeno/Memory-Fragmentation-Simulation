
import java.util.*;
public class MemoryManager {
	
	 private MemoryBlock [] memoryBlocks;
	
	 public MemoryManager(int[] blocks) {
		memoryBlocks = new MemoryBlock[blocks.length];
	        int start = 0;
	        for(int i =0 ; i<blocks.length ; i++) {
	       memoryBlocks[i] = new MemoryBlock(start,blocks[i]);
	           
	            start += blocks[i];
	        }
	    }
	 
	   public void allocateMemory(String processID, int size, int strategy) {
	        // Implement First-Fit, Best-Fit, Worst-Fit logic based on 'strategy' parameter
		   switch(strategy) {
		   case 1:  //first-fit
			 
			   
			   break;
			   
		   case 2:   //Best-fit
			   
			   break;
			   
		   case 3:   //Worst-fit
			   
			   break;
			   
			   default:
				   
		   
		   }
	    }

	    public void deallocateMemory(String processID) {
	        // Find the process and mark the block as free
	    }
	    
	    public void printFirstMemoryStatus() {
	        // Display block details
	    }
	

	    public void printMemoryStatus() {
	        // Display block details
	    }
	
	

}
