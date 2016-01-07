package cn.com.yunqitong.mapper;

import cn.com.yunqitong.domain.TWxRecord;
import cn.com.yunqitong.domain.TWxRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWxRecordMapper {
    int countByExample(TWxRecordExample example);

    int deleteByExample(TWxRecordExample example);

    int deleteByPrimaryKey(String id);

    int insert(TWxRecord record);

    int insertSelective(TWxRecord record);

    List<TWxRecord> selectByExample(TWxRecordExample example);

    TWxRecord selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TWxRecord record, @Param("example") TWxRecordExample example);

    int updateByExample(@Param("record") TWxRecord record, @Param("example") TWxRecordExample example);

    int updateByPrimaryKeySelective(TWxRecord record);

    int updateByPrimaryKey(TWxRecord record);
}