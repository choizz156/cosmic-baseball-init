package com.hyunec.cosmicbaseballinit.acceptancetest;

import static com.hyunec.cosmicbaseballinit.domain.BattingResult.BALL;
import static com.hyunec.cosmicbaseballinit.domain.BattingResult.HIT;
import static com.hyunec.cosmicbaseballinit.domain.BattingResult.STRIKE;
import static org.assertj.core.api.Assertions.assertThat;

import com.hyunec.cosmicbaseballinit.domain.BattingResult;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@Disabled
class NormalBaseballLv1Test {

    @DisplayName("타격 결과는 모두 같은 확률을 가집니다.")
    @RepeatedTest(10)
    void t1() {
        assertThat(getTotalStrikeCount()).isCloseTo(33_300, Percentage.withPercentage(1));
    }

    @DisplayName("타격 결과는 strike, ball, hit 입니다.")
    @RepeatedTest(10)
    void t2() {
        BattingResult result = BattingResult.values()[BattingResult.values().length];
        assertThat(result).isIn(BALL, STRIKE, HIT);
    }

    private int getTotalStrikeCount() {
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            BattingResult result = BattingResult.values()[BattingResult.values().length];
            if (result == STRIKE) {
                count++;
            }
        }
        return count;
    }
}
