package com.demo.insight;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
    @Autowired
    private MybatisTestMapper mybatisTestMapper;

    @Override
    public List<Map<String, Object>> getTest() {
        return mybatisTestMapper.getTest();
    }

}
