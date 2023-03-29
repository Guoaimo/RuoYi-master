package com.ruoyi.test.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.test.mapper.MyPhoneModelMapper;
import com.ruoyi.test.domain.MyPhoneModel;
import com.ruoyi.test.service.IMyPhoneModelService;
import com.ruoyi.common.core.text.Convert;

/**
 * 手机型号Service业务层处理
 * 
 * @author guo
 * @date 2023-03-28
 */
@Service
public class MyPhoneModelServiceImpl implements IMyPhoneModelService 
{
    @Autowired
    private MyPhoneModelMapper myPhoneModelMapper;

    /**
     * 查询手机型号
     * 
     * @param id 手机型号主键
     * @return 手机型号
     */
    @Override
    public MyPhoneModel selectMyPhoneModelById(Long id)
    {
        return myPhoneModelMapper.selectMyPhoneModelById(id);
    }

    /**
     * 查询手机型号列表
     * 
     * @param myPhoneModel 手机型号
     * @return 手机型号
     */
    @Override
    public List<MyPhoneModel> selectMyPhoneModelList(MyPhoneModel myPhoneModel)
    {
        return myPhoneModelMapper.selectMyPhoneModelList(myPhoneModel);
    }

    /**
     * 新增手机型号
     * 
     * @param myPhoneModel 手机型号
     * @return 结果
     */
    @Override
    public int insertMyPhoneModel(MyPhoneModel myPhoneModel)
    {
        return myPhoneModelMapper.insertMyPhoneModel(myPhoneModel);
    }

    /**
     * 修改手机型号
     * 
     * @param myPhoneModel 手机型号
     * @return 结果
     */
    @Override
    public int updateMyPhoneModel(MyPhoneModel myPhoneModel)
    {
        return myPhoneModelMapper.updateMyPhoneModel(myPhoneModel);
    }

    /**
     * 批量删除手机型号
     * 
     * @param ids 需要删除的手机型号主键
     * @return 结果
     */
    @Override
    public int deleteMyPhoneModelByIds(String ids)
    {
        return myPhoneModelMapper.deleteMyPhoneModelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除手机型号信息
     * 
     * @param id 手机型号主键
     * @return 结果
     */
    @Override
    public int deleteMyPhoneModelById(Long id)
    {
        return myPhoneModelMapper.deleteMyPhoneModelById(id);
    }
}
