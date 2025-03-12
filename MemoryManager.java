import java.util.*;

public class MemoryManager {

	private MemoryBlock[] memoryBlocks;

	public MemoryManager(int[] blocks) {
		memoryBlocks = new MemoryBlock[blocks.length];
		int start = 0;
		for (int i = 0; i < blocks.length; i++) {
			memoryBlocks[i] = new MemoryBlock(blocks[i], start);

			start += blocks[i];
		}
	}

	public void allocateMemory(String processID, int size, int strategy) {
		// Implement First-Fit, Best-Fit, Worst-Fit logic based on 'strategy' parameter
		switch (strategy) {
		case 1: // first-fit //TODO: leena
			boolean allocated = false;
			for (int i = 0; i < memoryBlocks.length; i++) {
				if (!memoryBlocks[i].isAllocated && memoryBlocks[i].size >= size) {
					memoryBlocks[i].processID = processID;
					memoryBlocks[i].isAllocated = true;
					memoryBlocks[i].internalFragmentation = memoryBlocks[i].size - size;
					allocated = true;
					break;
				}
				if(!allocated)
					System.out.println("ERROR: there is no suitable memory block!!");
			}

			break;

		case 2: // Best-fit //TODO: almaha

			break;

		case 3: // Worst-fit //TODO shahad
			MemoryBlock WorstBlock = null;

			for (int i = 0; i < memoryBlocks.length; i++)
				if (!memoryBlocks[i].isAllocated && (WorstBlock == null || memoryBlocks[i].size > WorstBlock.size))
					WorstBlock = memoryBlocks[i];

			if (WorstBlock != null && WorstBlock.size >= size) {
				WorstBlock.processID = processID;
				WorstBlock.isAllocated = true;
				WorstBlock.internalFragmentation = WorstBlock.size - size;
			} else
				System.out.println("ERROR: There is NO available Memory Block large enough.");

			break;
		default:
			System.out.println("ERROR: invalid Strategy!!");
			System.exit(0);

		}
	}

	public void deallocateMemory(String pID) { // TODO: ghaida
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
		System.out.println("============================================\n" + //
				"Block#	 size	 start-end	 status\n" + //
				"============================================");
		for (int i = 0; i < memoryBlocks.length; i++) {
			System.out.println("Block" + i + "	 " + memoryBlocks[i].size + "	 " + memoryBlocks[i].startAddress + "-"
					+ memoryBlocks[i].endAddress + "	 " + ((memoryBlocks[i].isAllocated) ? "allocated" : "free"));
		}
		System.out.println("============================================");

	}

	public void printMemoryStatus() {
		// Display block details
		System.out.println("Memory blocks:");
		System.out.println("===============================================================================\n" + //
				"Block#  size   start-end	 status  ProcessID  InternalFragmentation\n" + //
				"===============================================================================");
		for (int i = 0; i < memoryBlocks.length; i++) {
			System.out.println("Block" + i + "	 " + memoryBlocks[i].size + "	 " + memoryBlocks[i].startAddress + "-"
					+ memoryBlocks[i].endAddress + ((memoryBlocks[i].isAllocated) ? "     allocated" : "\t free")
					+ "	 " + memoryBlocks[i].processID + " 		" + memoryBlocks[i].internalFragmentation);
		}
		System.out.println("===============================================================================");

	}

}
