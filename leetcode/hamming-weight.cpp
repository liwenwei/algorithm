#include <stdint.h>

const uint64_t m1  = 0x5555555555555555; //binary: 0101...
const uint64_t m2  = 0x3333333333333333; //binary: 00110011..
const uint64_t m4  = 0x0f0f0f0f0f0f0f0f; //binary:  4 zeros,  4 ones ...
const uint64_t m8  = 0x00ff00ff00ff00ff; //binary:  8 zeros,  8 ones ...
const uint64_t m16 = 0x0000ffff0000ffff; //binary: 16 zeros, 16 ones ...
const uint64_t m32 = 0x00000000ffffffff; //binary: 32 zeros, 32 ones
const uint64_t hff = 0xffffffffffffffff; //binary: all ones
const uint64_t h01 = 0x0101010101010101; //the sum of 256 to the power of 0,1,2,3...

int popcount64(uint64_t x)
{
    x = (x & m1) + ((x >> 1) & m1); //put count of each  2 bits into those  2 bits 
    x = (x & m2) + ((x >> 2) & m2); //put count of each  4 bits into those  4 bits 
    x = (x & m4) + ((x >> 4) & m4); //put count of each  8 bits into those  8 bits 
    x = (x & m8) + ((x >> 8) & m8); //put count of each 16 bits into those 16 bits 
    x = (x & m16) + ((x >> 16) & m16); //put count of each 32 bits into those 32 bits 
    x = (x & m32) + ((x >> 32) & m32); //put count of each 64 bits into those 64 bits 
    return x;
}

// As Wegner(1960) described, [8] the bitwise and of x with x − 1 differs from x only in zeroing out the 
// least significant nonzero bit : subtracting 1 changes the rightmost string of 0s to 1s, 
// and changes the rightmost 1 to a 0. If x originally had n bits that were 1, then after only n iterations of this operation, 
// x will be reduced to zero.
// Paper: "A technique for counting ones in a binary computer"
int popcount(uint64_t x)
{
    int count = 0;
    for (count; x; count++)
        x &= x - 1;
    return count;
}