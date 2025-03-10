
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
		   case 1:  //first-fit //TODO: leena
			 for(int i = 0 ; i<memoryBlocks.length ; i++) {
				 if(!memoryBlocks[i].isAllocated && memoryBlocks[i].size >= size) {
					 memoryBlocks[i].processID = processID;
					 memoryBlocks[i].isAllocated = true;
					 memoryBlocks[i].internalFragmentation = memoryBlocks[i].size - size;
					 break;
				 }
			 }
			   
			   break;
			   
		   case 2:   //Best-fit //TODO: almaha
			   
			   break;
			   
		   case 3:   //Worst-fit //TODO shahad
			MemoryBlock WorstBlock = null;
			for(int i = 1 ; i<memoryBlocks.length ; i++)
				 if(!memoryBlocks[i].isAllocated && memoryBlocks[i].size > WorstBlock)
					 WorstBlock = memoryBlocks[i];
			if(WorstBlock.size >= size){
				WorstBlock.processID = processID;
				WorstBlock.isAllocated = true;
				WorstBlock.internalFragmentation = WorstBlock.size - size;
			}
			else
			       System.out.println("ERROR: There is NO available Memory Block size.");	
			
			   break;
			   
			   default:
				   System.out.println("ERROR: invalid Strategy!!");
				   System.exit(0);
				   
		   
		   }
	    }

	    public void deallocateMemory(String processID) { //TODO: ghaida
	        // Find the process and mark the block as free
	    }
	    
	    public void printFirstMemoryStatus() {
	        // Display block details
	    }
	

	    public void printMemoryStatus() {
	        // Display block details
	    }
	
	

}
