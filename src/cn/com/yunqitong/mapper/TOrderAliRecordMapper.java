package cn.com.yunqitong.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.yunqitong.domain.TOrderAliRecord;
import cn.com.yunqitong.domain.TOrderAliRecordExample;

public interface TOrderAliRecordMapper {
    int countByExample(TOrderAliRecordExample example);

    int deleteByExample(TOrderAliRecordExample example);

    int deleteByPrimaryKey(String aid);

    int insert(TOrderAliRecord record);

    int insertSelective(TOrderAliRecord record);

    List<TOrderAliRecord> selectByExample(TOrderAliRecordExample example);

    TOrderAliRecord selectByPrimaryKey(String aid);

    int updateByExampleSelective(@Param("record") TOrderAliRecord record, @Param("example") TOrderAliRecordExample example);

    int updateByExample(@Param("record") TOrderAliRecord record, @Param("example") TOrderAliRecordExample example);

    int updateByPrimaryKeySelective(TOrderAliRecord record);

    int updateByPrimaryKey(TOrderAliRecord record);
}