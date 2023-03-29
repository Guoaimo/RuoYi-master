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
import com.ruoyi.test.domain.MyPhone;
import com.ruoyi.test.service.IMyPhoneService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 手机Controller
 * 
 * @author guo
 * @date 2023-03-28
 */
@Controller
@RequestMapping("/test/phone")
public class MyPhoneController extends BaseController
{
    private String prefix = "test/phone";

    @Autowired
    private IMyPhoneService myPhoneService;

    @RequiresPermissions("test:phone:view")
    @GetMapping()
    public String phone()
    {
        return prefix + "/phone";
    }

    /**
     * 查询手机列表
     */
    @RequiresPermissions("test:phone:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MyPhone myPhone)
    {
        startPage();
        List<MyPhone> list = myPhoneService.selectMyPhoneList(myPhone);
        return getDataTable(list);
    }

    /**
     * 导出手机列表
     */
    @RequiresPermissions("test:phone:export")
    @Log(title = "手机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MyPhone myPhone)
    {
        List<MyPhone> list = myPhoneService.selectMyPhoneList(myPhone);
        ExcelUtil<MyPhone> util = new ExcelUtil<MyPhone>(MyPhone.class);
        return util.exportExcel(list, "手机数据");
    }

    /**
     * 新增手机
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存手机
     */
    @RequiresPermissions("test:phone:add")
    @Log(title = "手机", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MyPhone myPhone)
    {
        return toAjax(myPhoneService.insertMyPhone(myPhone));
    }

    /**
     * 修改手机
     */
    @RequiresPermissions("test:phone:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MyPhone myPhone = myPhoneService.selectMyPhoneById(id);
        mmap.put("myPhone", myPhone);
        return prefix + "/edit";
    }

    /**
     * 修改保存手机
     */
    @RequiresPermissions("test:phone:edit")
    @Log(title = "手机", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MyPhone myPhone)
    {
        return toAjax(myPhoneService.updateMyPhone(myPhone));
    }

    /**
     * 删除手机
     */
    @RequiresPermissions("test:phone:remove")
    @Log(title = "手机", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(myPhoneService.deleteMyPhoneByIds(ids));
    }
}
