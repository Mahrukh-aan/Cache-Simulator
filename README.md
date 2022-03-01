# Cache-Simulator
A direct mapped cache simulator keeping track of hit and miss rates.

The simulator is able to handle the following characteristics:
Cache Size: 1024
Block size: 16 bytes
Main memory address: 16 bits (216 bytes  memory)

The cache simulator keeps track of misses and hit rates. 
The input to the program is be a sequence of addresses. 
For simplicity, we randomly generate 512 addresses. For each address, a read from the cache is simulated.
Therefore, given an address we first check to see if it is contained in the cache. If it isn't, we increment the number of misses and update the cache.
