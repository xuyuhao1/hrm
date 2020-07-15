package com.hrm.controller;

import com.hrm.common.entity.Result;
import com.hrm.common.entity.ResultCode;
import com.hrm.domain.company.Company;
import com.hrm.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//解决跨域问题
@CrossOrigin
@RestController
@RequestMapping(value = "/company/")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    //保存企业
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Result save(@RequestBody Company company){
        //业务操作
        companyService.add(company);
        return new Result(ResultCode.SUCCESS);
    }
    //更具id更新企业
    @RequestMapping(value = "/{id}",method =RequestMethod.PUT)
    public Result update(@PathVariable(value = "id") String id,@RequestBody Company company){
    //业务操作
        company.setId(id);
        companyService.update(company);
        return new Result(ResultCode.SUCCESS);
    }
    //根据id删除企业
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public Result delete(@PathVariable(value ="id") String id){
        companyService.delete(id);
        return new Result(ResultCode.SUCCESS);
    }
    //根据id查询企业
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id)throws Exception{
    return null;
    }
    //查询全部企业列表
    @RequestMapping(value = "",method = RequestMethod.GET)
    public Result findAll(){
        int i=1/0;
        List<Company> list=companyService.findAll();
        Result result=new Result(ResultCode.SUCCESS);
        result.setData(list);
        return result;
        }

}
