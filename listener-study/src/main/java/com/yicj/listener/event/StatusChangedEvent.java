package com.yicj.listener.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusChangedEvent {
    private String topic ;
    private String tag ;
    private String content ;
}
