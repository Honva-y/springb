package com.user.dao;

import com.user.config.daoAnnotation.MasterDataSource;
import com.user.entity.MccInfo;

import java.util.List;

@MasterDataSource
public interface MccInfoDao {
    List<MccInfo> queryMccInfo();
}
