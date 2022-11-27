package com.demo.insight;

import java.util.List;
import java.util.Map;

public interface TestService {

    public List<Map<String, Object>> getTest();

    public List<Map<String, Object>> getGlobalAgingIndex();

    public List<Map<String, Object>> getSupportingExpense();

    public List<Map<String, Object>> getElderlyFacility();
    public List<Map<String, Object>> getOldAgePension();
}
