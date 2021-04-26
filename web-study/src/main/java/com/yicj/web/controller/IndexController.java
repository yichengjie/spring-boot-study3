package com.yicj.web.controller;

import com.yicj.web.model.ExportMemberVo;
import com.yicj.web.view.excel.ExcelView;
import com.yicj.web.view.excel.UserInfoExcelView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class IndexController {

    @GetMapping("/excel")
    public ModelAndView download() {
        List<ExportMemberVo> list = new ArrayList<ExportMemberVo>();
        for (int i = 0; i < 5; i++) {
            ExportMemberVo exportMemberVo = new ExportMemberVo();
            exportMemberVo.setName("Kent" + i);
            @SuppressWarnings("unchecked")
            int gender = ThreadLocalRandom.current().nextInt(0, 2);
            exportMemberVo.setGender(gender);
            exportMemberVo.setPhone("182xxxxxxxx");
            exportMemberVo.setBankName("建设银行");
            list.add(exportMemberVo);
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("members", list);
        map.put("name", "魅力城市");
        ExcelView excelView = new UserInfoExcelView();
        return new ModelAndView(excelView, map);
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello/world" ;
    }
}
