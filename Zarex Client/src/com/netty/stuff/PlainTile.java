package com.netty.stuff;

public class PlainTile {

	public PlainTile(int i, int j, int k, int l, int i1, int j1, boolean flag) {
		this.flat = true;
		this.colourA = i;
		this.colourB = j;
		this.colourD = k;
		this.colourC = l;
		this.texture = i1;
		this.colourRGB = j1;
		this.flat = flag;
	}

	public int colourA;
	public int colourB;
	public int colourD;
	public int colourC;
	public int texture;
	public boolean flat;
	public int colourRGB;
}