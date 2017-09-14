package com.wm.model;

import lombok.Builder;
import lombok.Data;

/**
 * vector model
 */
@Data
@Builder
public class VectorModel<T,R> {

	private T sign;
	private R recVector;

	public VectorModel() {
	}

	@Builder
	public VectorModel(T sign, R recVector) {
		this.sign = sign;
		this.recVector = recVector;
	}
}
