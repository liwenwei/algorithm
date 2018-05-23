#include <stdint.h>

/*

// byte[] to uint
b = new byte[] {0xfe, 0x5a, 0x11, 0xfa};
u = (uint)(b[0] | b[1] << 8 | b[2] << 16 | b[3] << 24);

// int to byte[]
b[0] = (byte)(u);
b[1] = (byte)(u >> 8);
b[2] = (byte)(u >> 16);
b[3] = (byte)(u >> 24);

*/
