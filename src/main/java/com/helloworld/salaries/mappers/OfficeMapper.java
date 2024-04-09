package com.helloworld.salaries.mappers;

import com.helloworld.salaries.model.Office;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface OfficeMapper {
    @Select("SELECT * FROM office")
    List<Office> findAllOffices();
}