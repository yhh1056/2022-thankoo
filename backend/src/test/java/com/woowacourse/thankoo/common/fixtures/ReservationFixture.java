package com.woowacourse.thankoo.common.fixtures;

import com.woowacourse.thankoo.coupon.domain.Coupon;
import com.woowacourse.thankoo.common.domain.TimeUnit;
import com.woowacourse.thankoo.member.domain.Member;
import com.woowacourse.thankoo.reservation.domain.Reservation;
import com.woowacourse.thankoo.reservation.domain.ReservationStatus;
import com.woowacourse.thankoo.reservation.domain.TimeZoneType;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReservationFixture {

    public static final String ACCEPT = "accept";
    public static final String DENY = "deny";

    /**
     * member must have id
     * coupon status is not used
     *
     * @param reservationId
     * @param receiver
     * @param coupon
     * @return
     */
    public static Reservation createReservation(final Long reservationId, final Member receiver, final Coupon coupon) {
        return new Reservation(reservationId,
                new TimeUnit(LocalDate.now().plusDays(1L),
                        LocalDateTime.now().plusDays(1L),
                        TimeZoneType.ASIA_SEOUL.getId()),
                ReservationStatus.WAITING,
                receiver.getId(),
                coupon);
    }
}
