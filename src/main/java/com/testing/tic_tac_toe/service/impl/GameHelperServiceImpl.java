package com.testing.tic_tac_toe.service.impl;

import com.testing.tic_tac_toe.domain.entity.GameEntity;
import com.testing.tic_tac_toe.service.GameHelperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class GameHelperServiceImpl implements GameHelperService {

    @Override
    public Boolean isValidMove(GameEntity gameEntity, Integer row, Integer column) {
        Integer boardSize = gameEntity.getRw() * gameEntity.getCl();
        Integer index = row * gameEntity.getCl() + column;

        if (row >= gameEntity.getRw() || column >= gameEntity.getCl() || index >= boardSize) {
            return false;
        }

        return gameEntity.getBoardState().charAt(index) == '_';
    }

    @Override
    public String updateBoard(String board, Integer row, Integer column, Integer boardWidth, Character symbol) {
        Integer index = row * boardWidth + column;
        char[] boardArray = board.toCharArray();
        boardArray[index] = symbol;

        return new String(boardArray);
    }

    @Override
    public Boolean checkWinner(String board, int row, int col, int boardWidth, int boardHeight, char symbol) {
        int winLength = 3;

        return checkRow(board, row, boardWidth, symbol, winLength) ||
                checkColumn(board, col, boardWidth, boardHeight, symbol, winLength) ||
                checkDiagonal(board, row, col, boardWidth, boardHeight, symbol, winLength);
    }

    @Override
    public Boolean isBoardFull(String board) {
        return !board.contains("-"); //
    }


    private boolean checkRow(String board, int row, int boardWidth, char symbol, int winLength) {
        int count = 0;
        for (int c = 0; c < boardWidth; c++) {
            if (board.charAt(row * boardWidth + c) == symbol) {
                count++;
                if (count == winLength) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkColumn(String board, int col, int boardWidth, int boardHeight, char symbol, int winLength) {
        int count = 0;
        for (int r = 0; r < boardHeight; r++) {
            if (board.charAt(r * boardWidth + col) == symbol) {
                count++;
                if (count == winLength) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkDiagonal(String board, int row, int col, int boardWidth, int boardHeight, char symbol, int winLength) {
        return checkDiagonalLeftToRight(board, row, col, boardWidth, boardHeight, symbol, winLength) ||
                checkDiagonalRightToLeft(board, row, col, boardWidth, boardHeight, symbol, winLength);
    }

    private boolean checkDiagonalLeftToRight(String board, int row, int col, int boardWidth, int boardHeight, char symbol, int winLength) {
        int count = 0;
        for (int i = -winLength + 1; i < winLength; i++) {
            int r = row + i, c = col + i;
            if (r >= 0 && r < boardHeight && c >= 0 && c < boardWidth && board.charAt(r * boardWidth + c) == symbol) {
                count++;
                if (count == winLength) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkDiagonalRightToLeft(String board, int row, int col, int boardWidth, int boardHeight, char symbol, int winLength) {
        int count = 0;
        for (int i = -winLength + 1; i < winLength; i++) {
            int r = row + i, c = col - i;
            if (r >= 0 && r < boardHeight && c >= 0 && c < boardWidth && board.charAt(r * boardWidth + c) == symbol) {
                count++;
                if (count == winLength) return true;
            } else {
                count = 0;
            }
        }
        return false;
    }

}
