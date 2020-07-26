package com.my.monitor.quartz.controller;

import com.my.monitor.base.controller.BaseController;
import com.my.monitor.base.domain.AjaxResult;
import com.my.monitor.base.page.TableDataInfo;
import com.my.monitor.domain.Job;
import com.my.monitor.exception.TaskException;
import com.my.monitor.service.IJobService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 调度任务信息操作处理
 * 
 * @author ruoyi
 */
@Controller
@RequestMapping("/quartz/job")
public class JobController extends BaseController
{

    @Autowired
    private IJobService jobService;

    @GetMapping()
    public String job()
    {
        return "job";
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Job job)
    {
        startPage();
        List<Job> list = jobService.selectJobList(job);
        return getDataTable(list);
    }


    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) throws SchedulerException
    {
        jobService.deleteJobByIds(ids);
        return success();
    }


    @GetMapping("/detail/{jobId}")
    public String detail(@PathVariable("jobId") Long jobId, ModelMap mmap)
    {
        mmap.put("name", "job");
        mmap.put("job", jobService.selectJobById(jobId));
        return "/detail";
    }

    /**
     * 任务调度状态修改
     */
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(Job job) throws SchedulerException
    {
        Job newJob = jobService.selectJobById(job.getJobId());
        newJob.setStatus(job.getStatus());
        return toAjax(jobService.changeStatus(newJob));
    }

    /**
     * 任务调度立即执行一次
     */
    @PostMapping("/run")
    @ResponseBody
    public AjaxResult run(Job job) throws SchedulerException
    {
        jobService.run(job);
        return success();
    }

    /**
     * 新增调度
     */
    @GetMapping("/add")
    public String add()
    {
        return "/add";
    }

    /**
     * 新增保存调度
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Validated Job job) throws SchedulerException, TaskException
    {
        return toAjax(jobService.insertJob(job));
    }

    /**
     * 修改调度
     */
    @GetMapping("/edit/{jobId}")
    public String edit(@PathVariable("jobId") Long jobId, ModelMap mmap)
    {
        mmap.put("job", jobService.selectJobById(jobId));
        return "/edit";
    }

    /**
     * 修改保存调度
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@Validated Job job) throws SchedulerException, TaskException
    {
        return toAjax(jobService.updateJob(job));
    }

    /**
     * 校验cron表达式是否有效
     */
    @PostMapping("/checkCronExpressionIsValid")
    @ResponseBody
    public boolean checkCronExpressionIsValid(Job job)
    {
        return jobService.checkCronExpressionIsValid(job.getCronExpression());
    }
}
