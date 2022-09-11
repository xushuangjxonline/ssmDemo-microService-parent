package com.jxonline.sword.mapper;

import com.jxonline.sword.entity.UserInfoModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xs
 * @date 2022/9/11
 **/
@Repository
public interface TestMapper {

    List<UserInfoModel> selectUserInfoModel();

}
