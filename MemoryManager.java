
public class MemoryManager {

	private MemoryBlock[] memoryBlocks;

	public MemoryManager(int[] blocks) {
		memoryBlocks = new MemoryBlock[blocks.length];
		int start = 0;
		for (int i = 0; i < blocks.length; i++) {
			memoryBlocks[i] = new MemoryBlock(blocks[i], start); //creating the memory blocks

			start += blocks[i];
		}
	}

	public void allocateMemory(String processID, int size, int strategy) {
		// Implement First-Fit, Best-Fit, Worst-Fit logic based on 'strategy' parameter
		switch (strategy) {

		case 1: // first-fit strategy

			boolean allocated = false;
			for (int i = 0; i < memoryBlocks.length; i++) { //finding the first available and large enough memory block size to allocate the process 
				if (!memoryBlocks[i].isAllocated && memoryBlocks[i].size >= size) {
					memoryBlocks[i].processID = processID;
					memoryBlocks[i].isAllocated = true;
					memoryBlocks[i].internalFragmentation = memoryBlocks[i].size - size;
					allocated = true;
					break;
				}}
				if(!allocated) //when there is no available blocke "all memory blocks are allocated or there is no block larger enough"
					System.out.println("ERROR: there is no suitable memory block!!");
			

		break;

		case 2: // Best-fit strategy

		MemoryBlock BestBlock = null;

			for(int i = 0; i < memoryBlocks.length; i++) //finding and store the best memory block "the minimum enough block"
				if (!memoryBlocks[i].isAllocated && (memoryBlocks[i].size >= size) && (BestBlock == null || memoryBlocks[i].size < BestBlock.size))
				BestBlock = memoryBlocks[i];

			if(BestBlock != null){ //allocate the process to the best block 
			BestBlock.processID = processID;
			BestBlock.isAllocated = true;
			BestBlock.internalFragmentation = BestBlock.size - size;
				}else //when there is no available block "all memory blocks are allocated or there is no block larger enough" 
					System.out.println("ERROR: There is NO available Memory Block large enough.");
		break;

		case 3: // Worst-fit strategy

			MemoryBlock WorstBlock = null;

			for (int i = 0; i < memoryBlocks.length; i++) //finding and store the worst memory block "the largest enough block"
				if (!memoryBlocks[i].isAllocated && (WorstBlock == null || memoryBlocks[i].size > WorstBlock.size))
					WorstBlock = memoryBlocks[i];

			if (WorstBlock != null && WorstBlock.size >= size) { //allocate the process to the worst block 
				WorstBlock.processID = processID;
				WorstBlock.isAllocated = true;
				WorstBlock.internalFragmentation = WorstBlock.size - size;
			} else //when there is no available block "all memory blocks are allocated or there is no block larger enough" 
				System.out.println("ERROR: There is NO available Memory Block large enough.");

		break;
		
		default:
			System.out.println("ERROR: invalid Strategy!!"); // when the user entered other value to strategy number "in MemorySimulator class"
			System.exit(0);

		}
	}

	public void deallocateMemory(String pID) { 
		// Find the process and mark the block as free
		for (int i = 0; i < memoryBlocks.length; i++) {
			if (memoryBlocks[i].processID != null && memoryBlocks[i].processID.equals(pID)) {
				memoryBlocks[i].internalFragmentation = 0;
				memoryBlocks[i].isAllocated = false;
				memoryBlocks[i].processID = null;
			}
		}
	}

	public void printFirstMemoryStatus() {
		// Display block details
		System.out.println("Memory blocks:");
		System.out.println("============================================");
		System.out.println("Block#   Size    Start-End       Status");
		System.out.println("============================================");
	
		// Loop through each memory block and print its status
		for (int i = 0; i < memoryBlocks.length; i++) {
			String status = memoryBlocks[i].isAllocated ? "allocated" : "free";
			
			// Format and print the block details
			System.out.printf("Block%-4d %-6d %-15s %-8s\n", 
					i, 
					memoryBlocks[i].size, 
					memoryBlocks[i].startAddress + "-" + memoryBlocks[i].endAddress, 
					status);
		}
		System.out.println("============================================");
	}

	public void printMemoryStatus() {
		// Display block details
		System.out.println("Memory blocks:");
		System.out.println("===============================================================================\n" +
		"Block#  Size   Start-End   Status      ProcessID   InternalFragmentation\n" +
		"===============================================================================");

				
				for (int i = 0; i < memoryBlocks.length; i++) {
					// Format the output for better alignment
					String status = memoryBlocks[i].isAllocated ? "allocated" : "free";
					String processID = memoryBlocks[i].isAllocated ? memoryBlocks[i].processID : "null";
					int internalFragmentation = memoryBlocks[i].isAllocated ? memoryBlocks[i].internalFragmentation : 0;
			
					System.out.printf("Block%-3d %-6d %-10s%-12s%-12s %-5d\n",
							i, 
							memoryBlocks[i].size, 
							memoryBlocks[i].startAddress + "-" + memoryBlocks[i].endAddress, 
							status, 
							processID,
							internalFragmentation);
				}
			
				System.out.println("===============================================================================");
			}

}
