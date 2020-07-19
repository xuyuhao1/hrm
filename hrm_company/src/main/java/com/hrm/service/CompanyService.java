package com.hrm.service;

import com.hrm.common.utils.IdWorker;
import com.hrm.dao.CompanyDao;
import com.hrm.domain.company.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private IdWorker idWorker;
    /***
     * 保存企业
     * 1.配置idWorker到工程
     * 2.在service中注入idworker
     * 3.通过idworker生成id
     * 4.保存企业
     */
    public void add(Company company){
        //基本属性的设置
        String id=idWorker.nextId()+"";
        company.setId(id);
        company.setAuditState("0");
        company.setState(1);
        company.setCreateTime(new Date());
        companyDao.save(company);
    }

    /***
     * 更新
     * 根据id查询企业对象
     * 修改属性
     * 调用dao完成更新
     * @param company
     */
    public void update(Company company){
        Company temp = companyDao.findById(company.getId()).get();
        temp.setName(company.getName());
        temp.setCompanyPhone(company.getCompanyPhone());
        companyDao.save(company);
    }
    /***
     * 删除企业
     */
    public void delete(String id){
        companyDao.deleteById(id);
    }

    /***
     * 根据id查询属性
     * @param id
     * @return
     */
    public Company findById(String id){
        return companyDao.findById(id).get();

    }
    /***
     * 查询企业列表
     *
     */
    public List<Company> findAll(){
        return companyDao.findAll();
    }
}
