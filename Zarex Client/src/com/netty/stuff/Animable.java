package com.netty.stuff;

import com.netty.game.model.Model;
import com.netty.net.cache.CacheableNode;

public class Animable extends CacheableNode {

	public void method443(int i, int j, int k, int l, int i1, int j1, int k1,  int l1, int i2) {
		Model model = this.getRotatedModel();
		if (model != null) {
			this.modelHeight = model.modelHeight;
			model.method443(i, j, k, l, i1, j1, k1, l1, i2);
		}
	}

	public Model getRotatedModel() {
		return null;
	}

	protected Animable() {
		this.modelHeight = 1000;
	}

	public VertexNormal[] vertexNormals;
	public int modelHeight;
}