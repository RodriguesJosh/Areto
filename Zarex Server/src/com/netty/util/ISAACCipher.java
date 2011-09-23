package com.netty.util;

/**
 * 
 * @author Joshua Rodrigues
 * @since Sep 21, 2011 12:02:41 PM
 */
public class ISAACCipher {

	/**
	 * 
	 */
	public static final int RATIO = 0x9e3779b9;

	/**
	 * 
	 */
	public static final int SIZE_LOG = 8;

	/**
	 * 
	 */
	public static final int SIZE = 1 << ISAACCipher.SIZE_LOG;

	/**
	 * 
	 */
	public static final int MASK = (ISAACCipher.SIZE - 1) << 2;

	/**
	 * 
	 */
	private int count = 0;

	/**
	 * 
	 */
	private int results[] = new int[ISAACCipher.SIZE];

	/**
	 * 
	 */
	private int memory[] = new int[ISAACCipher.SIZE];

	/**
	 * 
	 */
	private int a;

	/**
	 * 
	 */
	private int b;

	/**
	 * 
	 */
	private int c;

	/**
	 * 
	 * @param seed
	 * 			The id to set.
	 */
	public ISAACCipher(int[] seed) {
		for (int i = 0; i < seed.length; i++) {
			this.results[i] = seed[i];
		}
		this.init(true);
	}

	/**
	 * 
	 * @return
	 * 			The id to set.
	 */
	public int getNextValue() {
		if (this.count-- == 0) {
			this.isaac();
			this.count = ISAACCipher.SIZE - 1;
		}
		return this.results[this.count];
	}

	/**
	 * 
	 */
	public void isaac() {
		int i, j, x, y;
		this.b += ++this.c;
		for (i = 0, j = ISAACCipher.SIZE / 2; i < ISAACCipher.SIZE / 2;) {
			x = this.memory[i];
			this.a ^= this.a << 13;
			this.a += this.memory[j++];
			this.memory[i] = y = this.memory[(x & ISAACCipher.MASK) >> 2] + this.a + this.b;
			this.results[i++] = this.b = this.memory[((y >> ISAACCipher.SIZE_LOG) & ISAACCipher.MASK) >> 2] + x;

			x = this.memory[i];
			this.a ^= this.a >>> 6;
	this.a += this.memory[j++];
	this.memory[i] = y = this.memory[(x & ISAACCipher.MASK) >> 2] + this.a + this.b;
	this.results[i++] = this.b = this.memory[((y >> ISAACCipher.SIZE_LOG) & ISAACCipher.MASK) >> 2] + x;

	x = this.memory[i];
	this.a ^= this.a << 2;
	this.a += this.memory[j++];
	this.memory[i] = y = this.memory[(x & ISAACCipher.MASK) >> 2] + this.a + this.b;
	this.results[i++] = this.b = this.memory[((y >> ISAACCipher.SIZE_LOG) & ISAACCipher.MASK) >> 2] + x;

	x = this.memory[i];
	this.a ^= this.a >>> 16;
	this.a += this.memory[j++];
	this.memory[i] = y = this.memory[(x & ISAACCipher.MASK) >> 2] + this.a + this.b;
	this.results[i++] = this.b = this.memory[((y >> ISAACCipher.SIZE_LOG) & ISAACCipher.MASK) >> 2] + x;
		}
		for (j = 0; j < ISAACCipher.SIZE / 2;) {
			x = this.memory[i];
			this.a ^= this.a << 13;
			this.a += this.memory[j++];
			this.memory[i] = y = this.memory[(x & ISAACCipher.MASK) >> 2] + this.a + this.b;
			this.results[i++] = this.b = this.memory[((y >> ISAACCipher.SIZE_LOG) & ISAACCipher.MASK) >> 2] + x;

			x = this.memory[i];
			this.a ^= this.a >>> 6;
			this.a += this.memory[j++];
			this.memory[i] = y = this.memory[(x & ISAACCipher.MASK) >> 2] + this.a + this.b;
			this.results[i++] = this.b = this.memory[((y >> ISAACCipher.SIZE_LOG) & ISAACCipher.MASK) >> 2] + x;

			x = this.memory[i];
			this.a ^= this.a << 2;
			this.a += this.memory[j++];
			this.memory[i] = y = this.memory[(x & ISAACCipher.MASK) >> 2] + this.a + this.b;
			this.results[i++] = this.b = this.memory[((y >> ISAACCipher.SIZE_LOG) & ISAACCipher.MASK) >> 2] + x;

			x = this.memory[i];
			this.a ^= this.a >>> 16;
			this.a += this.memory[j++];
			this.memory[i] = y = this.memory[(x & ISAACCipher.MASK) >> 2] + this.a + this.b;
			this.results[i++] = this.b = this.memory[((y >> ISAACCipher.SIZE_LOG) & ISAACCipher.MASK) >> 2] + x;
		}
	}

	/**
	 * 
	 * @param flag
	 * 			The id to set.
	 */
	public void init(boolean flag) {
		int i;
		int a, b, c, d, e, f, g, h;
		a = b = c = d = e = f = g = h = ISAACCipher.RATIO;
		for (i = 0; i < 4; ++i) {
			a ^= b << 11;
			d += a;
			b += c;
			b ^= c >>> 2;
			e += b;
			c += d;
			c ^= d << 8;
			f += c;
			d += e;
			d ^= e >>> 16;
			g += d;
			e += f;
			e ^= f << 10;
			h += e;
			f += g;
			f ^= g >>> 4;
			a += f;
			g += h;
			g ^= h << 8;
			b += g;
			h += a;
			h ^= a >>> 9;
			c += h;
			a += b;
		}
		for (i = 0; i < ISAACCipher.SIZE; i += 8) {
			if (flag) {
				a += this.results[i];
				b += this.results[i + 1];
				c += this.results[i + 2];
				d += this.results[i + 3];
				e += this.results[i + 4];
				f += this.results[i + 5];
				g += this.results[i + 6];
				h += this.results[i + 7];
			}
			a ^= b << 11;
			d += a;
			b += c;
			b ^= c >>> 2;
			e += b;
			c += d;
			c ^= d << 8;
			f += c;
			d += e;
			d ^= e >>> 16;
			g += d;
			e += f;
			e ^= f << 10;
			h += e;
			f += g;
			f ^= g >>> 4;
			a += f;
			g += h;
			g ^= h << 8;
			b += g;
			h += a;
			h ^= a >>> 9;
			c += h;
			a += b;
			this.memory[i] = a;
			this.memory[i + 1] = b;
			this.memory[i + 2] = c;
			this.memory[i + 3] = d;
			this.memory[i + 4] = e;
			this.memory[i + 5] = f;
			this.memory[i + 6] = g;
			this.memory[i + 7] = h;
		}
		if (flag) {
			for (i = 0; i < ISAACCipher.SIZE; i += 8) {
				a += this.memory[i];
				b += this.memory[i + 1];
				c += this.memory[i + 2];
				d += this.memory[i + 3];
				e += this.memory[i + 4];
				f += this.memory[i + 5];
				g += this.memory[i + 6];
				h += this.memory[i + 7];
				a ^= b << 11;
				d += a;
				b += c;
				b ^= c >>> 2;
				e += b;
				c += d;
				c ^= d << 8;
				f += c;
				d += e;
				d ^= e >>> 16;
				g += d;
				e += f;
				e ^= f << 10;
				h += e;
				f += g;
				f ^= g >>> 4;
				a += f;
				g += h;
				g ^= h << 8;
				b += g;
				h += a;
				h ^= a >>> 9;
				c += h;
				a += b;
				this.memory[i] = a;
				this.memory[i + 1] = b;
				this.memory[i + 2] = c;
				this.memory[i + 3] = d;
				this.memory[i + 4] = e;
				this.memory[i + 5] = f;
				this.memory[i + 6] = g;
				this.memory[i + 7] = h;
			}
		}
		this.isaac();
		this.count = ISAACCipher.SIZE;
	}
}