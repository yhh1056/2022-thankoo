package com.woowacourse.thankoo.common.schedule;

import static com.woowacourse.thankoo.meeting.domain.MeetingStatus.ON_PROGRESS;

import com.woowacourse.thankoo.alarm.AlarmMessage;
import com.woowacourse.thankoo.alarm.support.AlarmMessageRequest;
import com.woowacourse.thankoo.alarm.support.Alarm;
import com.woowacourse.thankoo.alarm.support.AlarmManager;
import com.woowacourse.thankoo.coupon.domain.CouponRepository;
import com.woowacourse.thankoo.coupon.domain.CouponStatus;
import com.woowacourse.thankoo.meeting.domain.Meeting;
import com.woowacourse.thankoo.meeting.domain.MeetingRepository;
import com.woowacourse.thankoo.meeting.domain.MeetingStatus;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class MeetingScheduleTask {

    public static final Long DAY = 1L;

    private final MeetingRepository meetingRepository;
    private final CouponRepository couponRepository;

    @Scheduled(cron = "0 0 2 * * *")
    @Transactional
    public void executeCompleteMeeting() {
        List<Meeting> meetings = meetingRepository.findAllByMeetingStatusAndTimeUnit_Date(
                ON_PROGRESS, LocalDate.now().minusDays(DAY));

        List<Long> meetingIds = getMeetingIds(meetings);
        List<Long> couponIds = getCouponIds(meetings);

        meetingRepository.updateMeetingStatus(MeetingStatus.FINISHED, meetingIds);
        couponRepository.updateCouponStatus(CouponStatus.USED, couponIds);
    }

    private List<Long> getMeetingIds(final List<Meeting> meetings) {
        return meetings.stream()
                .map(Meeting::getId)
                .collect(Collectors.toList());
    }

    private List<Long> getCouponIds(final List<Meeting> meetings) {
        return meetings.stream()
                .map(meeting -> meeting.getCoupon().getId())
                .collect(Collectors.toList());
    }

    @Alarm
    @Scheduled(cron = "0 0 9 * * *")
    public void executeMeetingMessage() {
        List<Meeting> meetings = meetingRepository.findAllByTimeUnit_Date(LocalDate.now());
        List<String> emails = getEmails(meetings);
        AlarmManager.setResources(new AlarmMessageRequest(emails, AlarmMessage.MEETING));
        AlarmManager.clear();
    }

    private List<String> getEmails(final List<Meeting> meetings) {
        return meetings.stream()
                .map(meeting -> meeting.getMeetingMembers().getMeetingMembers())
                .flatMap(Collection::stream)
                .map(meetingMember -> meetingMember.getMember().getEmail().getValue())
                .distinct()
                .collect(Collectors.toList());
    }
}
