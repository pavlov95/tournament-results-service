package com.tournamenttrail.results.fixtures;

import com.tournamenttrail.results.games.dtos.GameResponse;
import com.tournamenttrail.results.games.enums.GameResult;
import com.tournamenttrail.results.games.enums.WinCondition;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class GameResponseFixture {
    public static int TEST_ROUND_NUMBER = 1;
    public static int TEST_BOARD_NUMBER = 1;
    public static int TEST_TOTAL_MOVES = 42;
    public static String TEST_WHITE_PLAYER_USERNAME = "TEST WHITE PLAYER";
    public static String TEST_BLACK_PLAYER_USERNAME = "TEST BLACK PLAYER";
    public static String TEST_ORGANISER_NOTE = "TEST ORGANISER NOTE";

    public static GameResponse create() {
        LocalDateTime now = LocalDateTime.now();
        return GameResponse.builder()
                .id(UUID.randomUUID())
                .tournamentId(UUID.randomUUID())
                .roundNumber(TEST_ROUND_NUMBER)
                .boardNumber(TEST_BOARD_NUMBER)
                .whitePlayerId(UUID.randomUUID())
                .whitePlayerUsername(TEST_WHITE_PLAYER_USERNAME)
                .blackPlayerId(UUID.randomUUID())
                .blackPlayerUsername(TEST_BLACK_PLAYER_USERNAME)
                .result(GameResult.BLACK_WIN)
                .whitePoints(BigDecimal.ZERO)
                .blackPoints(BigDecimal.ONE)
                .totalMoves(TEST_TOTAL_MOVES)
                .winCondition(WinCondition.RESIGNATION)
                .organiserNotes(TEST_ORGANISER_NOTE)
                .playedOn(now.minusHours(1))
                .createdOn(now)
                .updatedOn(now)
                .build();
    }


}
