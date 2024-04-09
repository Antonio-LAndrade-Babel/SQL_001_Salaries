package com.helloworld.salaries.company.salary.services.impl;

import com.helloworld.salaries.company.salary.services.OfficeService;
import com.helloworld.salaries.mappers.OfficeMapper;
import com.helloworld.salaries.model.Office;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeMapper officeMapper;

    public OfficeServiceImpl(OfficeMapper officeMapper){
        this.officeMapper = officeMapper;
    }

    @Override
    public List<Office> findAllOffices() {
        return officeMapper.findAllOffices();
    }
}
