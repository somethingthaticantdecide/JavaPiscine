CREATE TABLE IF NOT EXISTS public.users (
    id BIGSERIAL PRIMARY KEY,
	login VARCHAR ( 50 ) UNIQUE NOT NULL,
	password VARCHAR ( 50 ) NOT NULL,
	created_on TIMESTAMP
);

CREATE TABLE IF NOT EXISTS public.rooms (
    id BIGSERIAL PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
	ownerId bigint REFERENCES users (Id)
);

CREATE TABLE IF NOT EXISTS public.messages (
    id BIGSERIAL PRIMARY KEY,
	author bigint REFERENCES users (Id),
	room bigint REFERENCES rooms (Id),
	text text,
	date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS public.userCreatedRooms(
    UserId BIGSERIAL NOT NULL,
    RoomId BIGSERIAL NOT NULL,
    FOREIGN KEY (UserId) REFERENCES users(id),
    FOREIGN KEY (RoomId) REFERENCES rooms(id),
    UNIQUE (UserId, RoomId)
);

CREATE TABLE IF NOT EXISTS public.userChatRooms(
    UserId BIGSERIAL NOT NULL,
    RoomId BIGSERIAL NOT NULL,
    FOREIGN KEY (UserId) REFERENCES users(id),
    FOREIGN KEY (RoomId) REFERENCES rooms(id),
    UNIQUE (UserId, RoomId)
);

CREATE TABLE IF NOT EXISTS public.userRoomMessages(
    MessageId BIGSERIAL NOT NULL,
    RoomId BIGSERIAL NOT NULL,
    FOREIGN KEY (MessageId) REFERENCES messages(id),
    FOREIGN KEY (RoomId) REFERENCES rooms(id),
    UNIQUE (MessageId, RoomId)
);

ALTER USER postgres WITH LOGIN PASSWORD 'psql'