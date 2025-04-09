
import java.util.*;

public class MemorySimulator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] blocks;
		int n;
		while (true) {
			System.out.print("Enter the total number of memory blocks: "); //setting the number of memory blocks
			n = input.nextInt();
			if (n > 0) {
				blocks = new int[n];
				break;
			} else {
				System.out.print("invalid input, please enter a positive number: "); //validation
				n = input.nextInt();
			}
		}

		System.out.print("Enter the size of each block in KB:"); //setting the size of each memory block
		for (int i = 0; i < n; i++) {
			blocks[i] = input.nextInt();
		}

		System.out.println("Enter allocation strategy (1 for first-fit, 2 for best-fit, 3 for worst-fit): "); //let the user choosing allocation strategy
		int strategy = input.nextInt();

		MemoryManager manager = new MemoryManager(blocks); //send the array memory blocks to memory manager class

		System.out.println("Memory blocks are created...");
		manager.printFirstMemoryStatus(); //to show the first status of the memory blocks
		int choice;
		do { //menu of the provided services
			System.out.println("\n1) Allocate memory");
			System.out.println("2) Deallocate memory");
			System.out.println("3) Print memory report");
			System.out.println("4) Exit");
			System.out.print("Enter your choice: ");
			choice = input.nextInt();

			switch (choice) { //implementation of the services
			case 1:
				System.out.print("Enter process ID and size: ");
				String processID = input.next();
				int size = input.nextInt();
				manager.allocateMemory(processID, size, strategy);
				break;
			case 2:
				System.out.print("Enter process ID to deallocate: ");
				processID = input.next();
				manager.deallocateMemory(processID);
				break;
			case 3:
				manager.printMemoryStatus();
				break;
			case 4:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		} while (choice != 4);

		input.close();

	}
}
