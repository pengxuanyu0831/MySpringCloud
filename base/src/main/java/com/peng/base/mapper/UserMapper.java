package com.peng.base.mapper;


import com.peng.base.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserVo> seletByUserId(String userid);
}
