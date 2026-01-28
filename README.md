# Memory Fragmentation Simulator / operating systems course project
Memory management is a crucial aspect of modern computing, ensuring efficient utilization of available resources. This report presents the implementation of a Memory Fragmentation Simulation, which demonstrates different memory allocation strategies used in operating systems. The goal of this simulation is to allocate and deallocate memory blocks dynamically while analyzing internal fragmentation.
 
In this project, we implemented three well-known memory allocation strategies:


• First-Fit: Allocates the first available block that is large enough.
• Best-Fit: Allocates the smallest block that can accommodate the process, minimizing waste.
• Worst-Fit: Allocates the largest available block, potentially leaving larger free spaces.

The simulation allows users to:
1. Initialize memory by defining a fixed number of blocks with user-specified sizes.
2. Allocate memory based on the selected strategy.
3. Deallocate memory by freeing up previously allocated blocks.
4. Generate a memory status report showing block details, allocated processes, and fragmentation.
