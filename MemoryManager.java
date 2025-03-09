
import java.util.*;
public class MemoryManager {
	
	 private List<MemoryBlock> memoryBlocks;
	
	 public MemoryManager(int[] blocks) {
		 this.memoryBlocks = new ArrayList<>();
	        int start = 0;
	        for (int size : blocks) {
	            memoryBlocks.add(new MemoryBlock(size, start));
	            start += size;
	        }
	    }
	 
	   public void allocateMemory(String processID, int size, int strategy) {
	        // Implement First-Fit, Best-Fit, Worst-Fit logic based on 'strategy' parameter
		   switch(strategy) {
		   case 1:  //first-fit"leena"
			   
			   break;
			   
		   case 2:   //Best-fit"Almaha"
			   
			   break;
			   
		   case 3:   //Worst-fit"Shahad"
			   
			   break;
			   
			   default:
				   
		   
		   }
	    }

	    public void deallocateMemory(String processID) {//ghaida
	        // Find the process and mark the block as free
	    }
	    
	    public void printFirstMemoryStatus() {//ghaida
	        // Display block details
	    }
	

	    public void printMemoryStatus() {//ghaida
	        // Display block details
	    }
	
	

}
