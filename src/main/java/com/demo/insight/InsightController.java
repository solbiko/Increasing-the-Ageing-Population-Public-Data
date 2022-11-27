package com.demo.insight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
public class InsightController {

    @Autowired
    private TestService testService;

    @GetMapping("/getTest")
    public List<Map<String, Object>> getTest() {
        return testService.getTest();
    }

    // thymeleaf(타임리프) 일반 호출 예제
    @RequestMapping("/samplethymeleaf")
    public ModelAndView sampleThymeleaf(Model model) {
        ModelAndView mav = new ModelAndView("SampleThymeleaf");
        String text = "타임리프에 전달되는 데이터 입니다." ;
        mav.addObject("text", text);
        return mav;
    }



}
