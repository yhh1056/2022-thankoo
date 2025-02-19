package com.woowacourse.thankoo.alarm.support;

import com.woowacourse.thankoo.alarm.AlarmMessage;
import java.util.List;
import lombok.Getter;

@Getter
public class AlarmMessageRequest {

    private final List<String> emails;
    private final AlarmMessage alarmMessage;

    public AlarmMessageRequest(final List<String> emails, final AlarmMessage alarmMessage) {
        this.emails = emails;
        this.alarmMessage = alarmMessage;
    }

    public AlarmMessageRequest(final String email, final AlarmMessage alarmMessage) {
        this(List.of(email), alarmMessage);
    }
}
