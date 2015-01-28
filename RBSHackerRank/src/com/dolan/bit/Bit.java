package com.dolan.bit;

public class Bit {
	public static void main(String args[]) {
		getIntegerComplement(100);
	}
	
    static int getIntegerComplement(int n) {
        System.out.println(Integer.toBinaryString(n));
        int maskSize = Integer.toBinaryString(n).length();
        int mask = (1 << 7) - 1;
        n = ~n & mask;
        System.out.println(Integer.toBinaryString(n));
        return n;

    }
}
