package com.taotao.manage.service;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.manage.pojo.BasePojo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public abstract class BaseService <T extends BasePojo>{
    @Autowired
    private Mapper<T> mapper;
   /* public abstract mapper<T> mapper;*/
    /*
    * 根据id查询数据
    * */
    public T queryById(Long id){
        return this.mapper.selectByPrimaryKey(id);
    }
    /*
    * 查询所有数据
    * */
    public List<T> queryAll(){
        return this.mapper.select(null);
    }
    /*
    * 根据条件查询一条数据
    * */
    public T queryOne(T record){
        return this.mapper.selectOne(record);
    }
    /*
    * 根据条件查询多条数据
    * */
    public List<T> queryListByWhere(T record){
        return this.mapper.select(record);
    }
    /*
    * 根据条件分页查询数据
    * */
    public PageInfo<T> queryPageListByWhere(T record,Integer page,Integer rows ){
        PageHelper.startPage(page,rows);
        List<T> list = this.mapper.select(record);
        return new PageInfo<T>(list);
    }
    /*
    * 新增数据
    * */
    public Integer save(T t){
        t.setCreated(new Date());
        t.setUpdated(t.getCreated());
        return this.mapper.insert(t);
    }
    /*
    * 选着不为null的字段作为插入数据
    * */
    public Integer saveSelective(T t){
        return this.mapper.insertSelective(t);
    }
    /*
   * 更新数据
   * */
    public Integer update(T t){
        t.setUpdated(new Date());
        return this.mapper.updateByPrimaryKey(t);
    }
    /*
    * 选着不为null的字段作为更新数据数据
    * */
    public Integer updateSelective(T t){
        t.setUpdated(new Date());
        t.setCreated(null);//强制设置创建时间为null，
        return this.mapper.updateByPrimaryKeySelective(t);
    }
    /*
    * 根据主键id删除
    * */
    public Integer deleteById(Long id){
        return this.mapper.deleteByPrimaryKey(id);
    }
    /*
    * 批量删除数据
    * */
    public Integer deleteByIds(List<Object> ids,Class<T> clazz,String property){
        Example example = new Example(clazz);
        example.createCriteria().andIn(property,ids);
        return this.mapper.deleteByExample(example);
    }
    /*
    * 根据条件删除
    * */
    public Integer deleteByWhere(T record){
        return this.mapper.delete(record);
    }
}
