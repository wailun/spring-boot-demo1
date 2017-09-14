package com.wm.service.rocksdb;

import com.wm.service.Sign;

/**
 * TODO: comment here
 */
public class RocksDBSign implements Sign {

	private byte[] value;
	public RocksDBSign(byte[] value){
		this.value = value;
	}
	@Override
	public byte[] getValue() {
		return value;
	}
}
