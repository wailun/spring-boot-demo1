package com.wm.config;

import com.wm.service.VectorReader;
import com.wm.service.rocksdb.RocksDBVectorReader;

/**
 * TODO: comment here
 */
public class VectorReaderFactory {
	private static final String ROCKSDB_SERVICE_PREFIX = "rocksdb-service-";

	public static VectorReader getRocksDBVectorReader(ModelTemplateProperty modelTemplateProperty) {
		RocksdbClientProperties rocksdbClientProperties=new RocksdbClientProperties();
		RocksdbClientProperty rocksdbClientProperty = new RocksdbClientProperty();
		String datasource = modelTemplateProperty.getBizType() + modelTemplateProperty.getModelName();
		String serviceName = ROCKSDB_SERVICE_PREFIX + datasource;
		rocksdbClientProperty.setDatasource(datasource);
		rocksdbClientProperty.setServiceName(serviceName);
		rocksdbClientProperties.setProperties(Lists.newArrayList(rocksdbClientProperty));
		RocksdbClientFactory rocksdbClientFactory = new RocksdbClientFactory(rocksdbClientProperties);
		SmartRocksdbClient smartRocksdbClient = SmartRocksdbClient.builder().datasource(datasource)
				.serviceName(serviceName).rocksdbClientFactory(rocksdbClientFactory).build();
		return RocksDBVectorReader.builder().rocksdbClient(smartRocksdbClient).build();
	}
}
