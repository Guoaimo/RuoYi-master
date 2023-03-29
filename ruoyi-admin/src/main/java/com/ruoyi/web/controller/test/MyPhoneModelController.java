package com.ruoyi.web.controller.test;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.test.domain.MyPhoneModel;
import com.ruoyi.test.service.IMyPhoneModelService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 手机型号Controller
 * 
 * @author guo
 * @date 2023-03-28
 */
@Controller
@RequestMapping("/test/model")
public class MyPhoneModelController extends BaseController
{
    private String prefix = "test/model";

    @Autowired
    private IMyPhoneModelService myPhoneModelService;

    @RequiresPermissions("test:model:view")
    @GetMapping()
    public String model()
    {
        return prefix + "/model";
    }

    /**
     * 查询手机型号列表
     */
    @RequiresPermissions("test:model:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MyPhoneModel myPhoneModel)
    {
        startPage();
        List<MyPhoneModel> list = myPhoneModelService.selectMyPhoneModelList(myPhoneModel);
        return getDataTable(list);
    }

    /**
     * 导出手机型号列表
     */
    @RequiresPermissions("test:model:export")
    @Log(title = "手机型号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MyPhoneModel myPhoneModel)
    {
        List<MyPhoneModel> list = myPhoneModelService.selectMyPhoneModelList(myPhoneModel);
        ExcelUtil<MyPhoneModel> util = new ExcelUtil<MyPhoneModel>(MyPhoneModel.class);
        return util.exportExcel(list, "手机型号数据");
    }

    /**
     * 新增手机型号
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存手机型号
     */
    @RequiresPermissions("test:model:add")
    @Log(title = "手机型号", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MyPhoneModel myPhoneModel)
    {
        return toAjax(myPhoneModelService.insertMyPhoneModel(myPhoneModel));
    }

    /**
     * 修改手机型号
     */
    @RequiresPermissions("test:model:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MyPhoneModel myPhoneModel = myPhoneModelService.selectMyPhoneModelById(id);
        mmap.put("myPhoneModel", myPhoneModel);
        return prefix + "/edit";
    }

    /**
     * 修改保存手机型号
     */
    @RequiresPermissions("test:model:edit")
    @Log(title = "手机型号", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MyPhoneModel myPhoneModel)
    {
        return toAjax(myPhoneModelService.updateMyPhoneModel(myPhoneModel));
    }

    /**
     * 删除手机型号
     */
    @RequiresPermissions("test:model:remove")
    @Log(title = "手机型号", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(myPhoneModelService.deleteMyPhoneModelByIds(ids));
    }
}
