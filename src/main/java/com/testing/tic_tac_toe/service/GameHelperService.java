package com.testing.tic_tac_toe.service;

import com.testing.tic_tac_toe.domain.entity.GameEntity;
import org.springframework.stereotype.Service;

@Service
public interface GameHelperService {

    Boolean isValidMove(GameEntity gameEntity, Integer row, Integer column);

    String updateBoard(String board, Integer row, Integer column, Integer boardWidth, Character symbol);

    Boolean checkWinner(String board, int row, int col, int boardWidth, int boardHeight, char symbol);

    Boolean isBoardFull(String board);

}
