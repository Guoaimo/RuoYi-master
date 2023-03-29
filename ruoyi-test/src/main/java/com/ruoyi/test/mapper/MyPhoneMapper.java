package com.ruoyi.test.mapper;

import java.util.List;
import com.ruoyi.test.domain.MyPhone;
import org.apache.ibatis.annotations.Mapper;

/**
 * 手机Mapper接口
 * 
 * @author guo
 * @date 2023-03-28
 */
@Mapper
public interface MyPhoneMapper 
{
    /**
     * 查询手机
     * 
     * @param id 手机主键
     * @return 手机
     */
    public MyPhone selectMyPhoneById(Long id);

    /**
     * 查询手机列表
     * 
     * @param myPhone 手机
     * @return 手机集合
     */
    public List<MyPhone> selectMyPhoneList(MyPhone myPhone);

    /**
     * 新增手机
     * 
     * @param myPhone 手机
     * @return 结果
     */
    public int insertMyPhone(MyPhone myPhone);

    /**
     * 修改手机
     * 
     * @param myPhone 手机
     * @return 结果
     */
    public int updateMyPhone(MyPhone myPhone);

    /**
     * 删除手机
     * 
     * @param id 手机主键
     * @return 结果
     */
    public int deleteMyPhoneById(Long id);

    /**
     * 批量删除手机
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyPhoneByIds(String[] ids);
}
