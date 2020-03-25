package com.yicj.property.aware;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Flag {
    private boolean canOperate = true ;
}
