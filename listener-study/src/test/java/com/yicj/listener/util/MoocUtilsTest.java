package com.yicj.listener.util;

import com.yicj.listener.ListenerApplication;
import com.yicj.listener.bean.NewResultModel;
import com.yicj.listener.bean.OldResult;
import com.yicj.listener.bean.OldResultModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ListenerApplication.class)
public class MoocUtilsTest {

    @Test
    public void testConvertWithFastJson(){
        OldResultModel oldResultModel = initOldResult(MoocUtils.FAST_JSON);
        NewResultModel newResultModel = MoocUtils.convert(oldResultModel);
        System.out.println(newResultModel);
    }

    @Test
    public void testConvertWithJackson(){
        OldResultModel oldResultModel = initOldResult(MoocUtils.JACKSON);
        NewResultModel newResultModel = MoocUtils.convert(oldResultModel);
        System.out.println(newResultModel);
    }

    private OldResultModel initOldResult(String type){
        OldResult oldResult = new OldResult() ;
        oldResult.setOldAge(13);
        oldResult.setOldName("张三");
        oldResult.setOldSex("男");
        OldResultModel oldResultModel = new OldResultModel(oldResult,type) ;
        return oldResultModel ;
    }
}
