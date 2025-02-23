create table T_PLAYER
(
    ID   UUID not null,
    NAME CHARACTER VARYING,
    constraint T_PLAYER_PK
        primary key (ID)
);

create table t_move
(
    id        UUID,
    id_game   UUID,
    id_player UUID,
    rw        INTEGER,
    cl        INTEGER,
    symbol    CHARACTER,
    constraint t_move_pk
        primary key (id)
);

create table t_game
(
    id                UUID,
    player1_id        UUID,
    player2_id        UUID,
    rw                INTEGER,
    cl                INTEGER,
    board_state       VARCHAR,
    current_player_id UUID,
    is_game_over      BOOLEAN,
    constraint t_game_pk
        primary key (id)
);

