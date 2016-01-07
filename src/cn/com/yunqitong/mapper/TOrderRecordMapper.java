package cn.com.yunqitong.mapper;

import cn.com.yunqitong.domain.TOrderRecord;
import cn.com.yunqitong.domain.TOrderRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TOrderRecordMapper {
    int countByExample(TOrderRecordExample example);

    int deleteByExample(TOrderRecordExample example);

    int deleteByPrimaryKey(String oid);

    int insert(TOrderRecord record);

    int insertSelective(TOrderRecord record);

    List<TOrderRecord> selectByExample(TOrderRecordExample example);

    TOrderRecord selectByPrimaryKey(String oid);

    int updateByExampleSelective(@Param("record") TOrderRecord record, @Param("example") TOrderRecordExample example);

    int updateByExample(@Param("record") TOrderRecord record, @Param("example") TOrderRecordExample example);

    int updateByPrimaryKeySelective(TOrderRecord record);

    int updateByPrimaryKey(TOrderRecord record);
}