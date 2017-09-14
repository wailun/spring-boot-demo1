package com.wm.service.rocksdb;


import com.wm.model.VectorModel;
import com.wm.service.ShardSupplier;
import com.wm.service.Sign;
import com.wm.service.VectorReader;
import lombok.Builder;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * TODO: comment here
 */
@Builder
public class RocksDBVectorReader implements VectorReader {
	private final static int SHARD_FACTOR = 65537;

	@Override
	public VectorModel readVectorModel(Sign sign, ShardSupplier shardSupplier) {
		return null;
	}

	@Override
	public List<VectorModel> readVectorModels(List<Sign> signList, ShardSupplier shardSupplier) {
		return Lists;
	}
}
