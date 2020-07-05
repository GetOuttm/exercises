package com.onetomany.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity//声明实体类
@Table(name = "cst_customer")//建立实体类和表的映射关系
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//配置主键的生成策略
    @Column(name = "cust_id")//指定和表中cust_id字段的映射关系
    private Long custId;//客户的主键
    @Column(name = "cust_name")//指定和表中cust_name字段的映射关系
    private String custName;//客户的姓名
    @Column(name = "cust_source")//指定和表中cust_name字段的映射关系
    private String custSource;//客户来源
    @Column(name = "cust_industry")//指定和表中cust_industry字段的映射关系
    private String custIndustry;//客户级别
    @Column(name = "cust_level")//指定和表中cust_level字段的映射关系
    private String custLevel;//客户所属行业
    @Column(name = "cust_address")//指定和表中cust_address字段的映射关系
    private String custAddress;//客户联系方式
    @Column(name = "cust_phone")//指定和表中cust_phone字段的映射关系
    private String custPhone;//客户地址

    //配置客户与联系人之间的关系(一对多   包含关系)
    /**
     * 通过注解配置一对多
     *      1.声明关系，
     *          @OneToMany 配置一对多   targetEntity对方对象的字节妈对象
     *      2.配置外键(中间表)
     *           @JoinColumn   配置外键   多表注解
     *              name                         数据库外键字段名称
     *              referencedColumnName         数据库主表的主键字段名称
     * 在客户实体类上添加了外键设置，所以对于客户而言，也具备了维护外键的作用
     */
//    @OneToMany(targetEntity = LinkMan.class)
//    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")

    /**
     * 放弃外键维护权
     *      mappedBy：对方配置关系的属性名称   不填写会创建中间表
     * cascade : 配置级联（可以配置到设置多表的映射关系的注解上）
     *      CascadeType.ALL        : 所有
     *                  MERGE       ：更新
     *                  PERSIST     ：保存
     *                  REMOVE      ：删除
     *
     * fetch : 配置关联对象的加载方式
     *          EAGER   ：立即加载
     *          LAZY    ：延迟加载

     */
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL/*,fetch = FetchType.LAZY*/)
    private Set<LinkMan> linkManSet = new HashSet<>();

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public Set<LinkMan> getLinkManSet() {
        return linkManSet;
    }

    public void setLinkManSet(Set<LinkMan> linkManSet) {
        this.linkManSet = linkManSet;
    }
}
