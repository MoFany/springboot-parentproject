package com.mofany.mapper.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mofany.entity.Users;
import com.mofany.mapper.UsersMapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author MoFany-J
 * @date 2023/2/6
 * @description UsersMapperImpl
 */
public class UsersMapperImpl implements UsersMapper {
    /**
     * 插入一条记录
     *
     * @param entity 实体对象
     */
    @Override
    public int insert(Users entity) {
        return 0;
    }

    /**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    @Override
    public int deleteById(Serializable id) {
        return 0;
    }

    /**
     * 根据 columnMap 条件，删除记录
     *
     * @param columnMap 表字段 map 对象
     */
    @Override
    public int deleteByMap(Map<String, Object> columnMap) {
        return 0;
    }

    /**
     * 根据 entity 条件，删除记录
     *
     * @param wrapper 实体对象封装操作类（可以为 null）
     */
    @Override
    public int delete(Wrapper<Users> wrapper) {
        return 0;
    }

    /**
     * 删除（根据ID 批量删除）
     *
     * @param idList 主键ID列表(不能为 null 以及 empty)
     */
    @Override
    public int deleteBatchIds(Collection<? extends Serializable> idList) {
        return 0;
    }

    /**
     * 根据 ID 修改
     *
     * @param entity 实体对象
     */
    @Override
    public int updateById(Users entity) {
        return 0;
    }

    /**
     * 根据 whereEntity 条件，更新记录
     *
     * @param entity        实体对象 (set 条件值,可以为 null)
     * @param updateWrapper 实体对象封装操作类（可以为 null,里面的 entity 用于生成 where 语句）
     */
    @Override
    public int update(Users entity, Wrapper<Users> updateWrapper) {
        return 0;
    }

    /**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
    @Override
    public Users selectById(Serializable id) {
        return null;
    }

    /**
     * 查询（根据ID 批量查询）
     *
     * @param idList 主键ID列表(不能为 null 以及 empty)
     */
    @Override
    public List<Users> selectBatchIds(Collection<? extends Serializable> idList) {
        return null;
    }

    /**
     * 查询（根据 columnMap 条件）
     *
     * @param columnMap 表字段 map 对象
     */
    @Override
    public List<Users> selectByMap(Map<String, Object> columnMap) {
        return null;
    }

    /**
     * 根据 entity 条件，查询一条记录
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Override
    public Users selectOne(Wrapper<Users> queryWrapper) {
        return null;
    }

    /**
     * 根据 Wrapper 条件，查询总记录数
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Override
    public Integer selectCount(Wrapper<Users> queryWrapper) {
        return null;
    }

    /**
     * 根据 entity 条件，查询全部记录
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Override
    public List<Users> selectList(Wrapper<Users> queryWrapper) {
        return null;
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<Users> queryWrapper) {
        return null;
    }

    /**
     * 根据 Wrapper 条件，查询全部记录
     * <p>注意： 只返回第一个字段的值</p>
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Override
    public List<Object> selectObjs(Wrapper<Users> queryWrapper) {
        return null;
    }

    /**
     * 根据 entity 条件，查询全部记录（并翻页）
     *
     * @param page         分页查询条件（可以为 RowBounds.DEFAULT）
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
    @Override
    public <E extends IPage<Users>> E selectPage(E page, Wrapper<Users> queryWrapper) {
        return null;
    }

    /**
     * 根据 Wrapper 条件，查询全部记录（并翻页）
     *
     * @param page         分页查询条件
     * @param queryWrapper 实体对象封装操作类
     */
    @Override
    public <E extends IPage<Map<String, Object>>> E selectMapsPage(E page, Wrapper<Users> queryWrapper) {
        return null;
    }
}
