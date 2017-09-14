package com.wm.service;


import com.wm.model.VectorModel;

import java.util.List;

/**
 * Vector reader
 */
public interface VectorReader {

	VectorModel readVectorModel(Sign sign, ShardSupplier shardSupplier);

	List<VectorModel> readVectorModels(List<Sign> signList, ShardSupplier shardSupplier);
}
