package com.ruoyi.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test.mapper.MyPhoneMapper;
import com.ruoyi.test.domain.MyPhone;
import com.ruoyi.test.service.IMyPhoneService;
import com.ruoyi.common.core.text.Convert;

/**
 * 手机Service业务层处理
 * 
 * @author guo
 * @date 2023-03-28
 */
@Service
public class MyPhoneServiceImpl implements IMyPhoneService 
{
    @Autowired
    private MyPhoneMapper myPhoneMapper;

    /**
     * 查询手机
     * 
     * @param id 手机主键
     * @return 手机
     */
    @Override
    public MyPhone selectMyPhoneById(Long id)
    {
        return myPhoneMapper.selectMyPhoneById(id);
    }

    /**
     * 查询手机列表
     * 
     * @param myPhone 手机
     * @return 手机
     */
    @Override
    public List<MyPhone> selectMyPhoneList(MyPhone myPhone)
    {
        return myPhoneMapper.selectMyPhoneList(myPhone);
    }

    /**
     * 新增手机
     * 
     * @param myPhone 手机
     * @return 结果
     */
    @Override
    public int insertMyPhone(MyPhone myPhone)
    {
        return myPhoneMapper.insertMyPhone(myPhone);
    }

    /**
     * 修改手机
     * 
     * @param myPhone 手机
     * @return 结果
     */
    @Override
    public int updateMyPhone(MyPhone myPhone)
    {
        return myPhoneMapper.updateMyPhone(myPhone);
    }

    /**
     * 批量删除手机
     * 
     * @param ids 需要删除的手机主键
     * @return 结果
     */
    @Override
    public int deleteMyPhoneByIds(String ids)
    {
        return myPhoneMapper.deleteMyPhoneByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除手机信息
     * 
     * @param id 手机主键
     * @return 结果
     */
    @Override
    public int deleteMyPhoneById(Long id)
    {
        return myPhoneMapper.deleteMyPhoneById(id);
    }
}
