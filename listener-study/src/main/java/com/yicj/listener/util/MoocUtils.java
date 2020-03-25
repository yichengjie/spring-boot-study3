package com.yicj.listener.util;

import com.yicj.listener.bean.NewResult;
import com.yicj.listener.bean.NewResultModel;
import com.yicj.listener.bean.OldResultModel;
import com.yicj.listener.component.FastJsonSerialize;
import com.yicj.listener.component.JacksonSerialize;
import com.yicj.listener.component.MoocSpringContainer;
import com.yicj.listener.component.SerializedInterface;

public class MoocUtils {

    public static final String FAST_JSON = "fastjson" ;
    public static final String JACKSON = "jackson" ;

    public static NewResultModel convert(OldResultModel oldResultModel){
        NewResultModel newResultModel = new NewResultModel() ;
        NewResult newResult = new NewResult() ;
        newResult.setNewAge(oldResultModel.getOldResult().getOldAge());
        newResult.setNewName(oldResultModel.getOldResult().getOldName());
        newResult.setNewSex(oldResultModel.getOldResult().getOldSex());
        newResultModel.setNewResult(newResult);
        MoocSpringContainer container = MoocSpringContainer.getInstance();
        SerializedInterface serialize = container.getBean(FastJsonSerialize.class);
        if(FAST_JSON.equals(oldResultModel.getType())){
            serialize = container.getBean(FastJsonSerialize.class);
        }else {
            serialize = container.getBean(JacksonSerialize.class) ;
        }
        newResultModel.setOldResultDesc(serialize.serialize(oldResultModel.getOldResult()));
        return newResultModel ;
    }


}
