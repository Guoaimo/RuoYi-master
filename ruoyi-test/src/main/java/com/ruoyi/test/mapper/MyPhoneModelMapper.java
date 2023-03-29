package com.ruoyi.test.mapper;

import java.util.List;
import com.ruoyi.test.domain.MyPhoneModel;

/**
 * 手机型号Mapper接口
 * 
 * @author guo
 * @date 2023-03-28
 */
public interface MyPhoneModelMapper 
{
    /**
     * 查询手机型号
     * 
     * @param id 手机型号主键
     * @return 手机型号
     */
    public MyPhoneModel selectMyPhoneModelById(Long id);

    /**
     * 查询手机型号列表
     * 
     * @param myPhoneModel 手机型号
     * @return 手机型号集合
     */
    public List<MyPhoneModel> selectMyPhoneModelList(MyPhoneModel myPhoneModel);

    /**
     * 新增手机型号
     * 
     * @param myPhoneModel 手机型号
     * @return 结果
     */
    public int insertMyPhoneModel(MyPhoneModel myPhoneModel);

    /**
     * 修改手机型号
     * 
     * @param myPhoneModel 手机型号
     * @return 结果
     */
    public int updateMyPhoneModel(MyPhoneModel myPhoneModel);

    /**
     * 删除手机型号
     * 
     * @param id 手机型号主键
     * @return 结果
     */
    public int deleteMyPhoneModelById(Long id);

    /**
     * 批量删除手机型号
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyPhoneModelByIds(String[] ids);
}
