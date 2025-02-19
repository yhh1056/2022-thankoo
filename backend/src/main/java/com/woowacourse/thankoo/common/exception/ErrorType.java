package com.woowacourse.thankoo.common.exception;

import lombok.Getter;

@Getter
public enum ErrorType {

    NOT_AUTHENTICATED(1001, "인증되지 않았습니다."),
    ALREADY_AUTHENTICATED(1002, "이미 인증정보가 존재합니다."),
    INVALID_TOKEN(1003, "유효하지 않은 토큰입니다."),
    FORBIDDEN(1004, "권한이 없습니다."),

    NOT_FOUND_MEMBER(2001, "존재하지 않는 회원입니다."),
    INVALID_MEMBER_NAME(2002, "올바르지 않은 이름입니다."),
    INVALID_MEMBER_EMAIL(2003, "올바르지 않은 이메일 형식입니다."),
    INVALID_MEMBER(2004, "올바르지 않은 회원입니다."),

    INVALID_COUPON_TYPE(3001, "존재하지 않는 쿠폰 타입입니다."),
    INVALID_COUPON_TITLE(3002, "잘못된 쿠폰 제목입니다."),
    INVALID_COUPON_MESSAGE(3003, "잘못된 쿠폰 내용입니다."),
    INVALID_COUPON_STATUS(3004, "잘못된 쿠폰 상태입니다."),
    NOT_FOUND_COUPON(3005, "존재하지 않는 쿠폰입니다."),

    INVALID_RESERVATION_TIME(4001, "유효하지 않은 일정입니다."),
    INVALID_RESERVATION_MEMBER_MISMATCH(4002, "예약을 요청할 수 없는 회원입니다."),
    INVALID_RESERVATION_COUPON_STATUS(4003, "예약 요청이 불가능한 쿠폰입니다."),
    NOT_FOUND_RESERVATION(4004, "존재하지 않는 예약입니다."),
    NOT_FOUND_RESERVATION_STATUS(4005, "존재하지 않는 예약 상태입니다."),
    CAN_NOT_CHANGE_RESERVATION_STATUS(4006, "예약 상태를 변경할 수 없습니다."),

    INVALID_MEETING_MEMBER(5001, "잘못된 미팅 참여자입니다."),
    INVALID_MEETING_MEMBER_COUNT(5002, "미팅 참여자는 두 명이어야 합니다."),
    NOT_FOUND_MEETING(5003, "존재하지 않는 미팅입니다."),
    INVALID_MEETING_TIME_ZONE(5004, "잘못된 타임존입니다."),
    INVALID_MEETING_STATUS(5005, "완료할 수 없는 상태입니다."),
    INVALID_MEETING_TIME(5006, "유효하지 않은 일정입니다."),

    REQUEST_EXCEPTION(6001, "http 요청 에러입니다."),

    NOT_FOUND_SLACK_USER(9001, "알람이 불가능한 이메일입니다. 관리자에게 문의주세요."),
    NOT_FOUND_ALARM_REQUEST(9002, "전송하려는 알람이 존재하지 않습니다."),
    UNHANDLED_EXCEPTION(9999, "예상치 못한 예외입니다.");

    private final int code;
    private final String message;

    ErrorType(final int code, final String message) {
        this.code = code;
        this.message = message;
    }
}
