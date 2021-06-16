INSERT INTO public.users (login, password, created_on) VALUES ('alex', '123', '2021-06-07 20:57:04.000000');
INSERT INTO public.users (login, password, created_on) VALUES ('bob', '123', '2021-06-07 20:57:16.000000');
INSERT INTO public.users (login, password, created_on) VALUES ('pit', '123', '2021-06-07 20:57:27.000000');
INSERT INTO public.users (login, password, created_on) VALUES ('mike', '123', '2021-06-07 20:57:45.000000');
INSERT INTO public.users (login, password, created_on) VALUES ('jack', '123', '2021-06-07 20:58:02.000000');
INSERT INTO public.users (login, password, created_on) VALUES ('phill', '123', '2021-06-07 20:58:10.000000');
INSERT INTO public.users (login, password, created_on) VALUES ('alan', '123', '2021-06-07 20:58:16.000000');
INSERT INTO public.users (login, password, created_on) VALUES ('mamkin_nagibator_228', '777', '2021-06-07 20:58:45.000000');
INSERT INTO public.users (login, password, created_on) VALUES ('qwerty', '123', '2021-06-07 20:59:05.000000');
INSERT INTO public.users (login, password, created_on) VALUES ('admin', 'admin', '2021-06-07 20:59:16.000000');


INSERT INTO public.rooms (name, ownerid) VALUES ('first_room', 1);
INSERT INTO public.rooms (name, ownerid) VALUES ('second_room', 2);
INSERT INTO public.rooms (name, ownerid) VALUES ('third', 3);
INSERT INTO public.rooms ( name, ownerid) VALUES ('fourth', 4);
INSERT INTO public.rooms (name, ownerid) VALUES ('fifth', 5);
INSERT INTO public.rooms (name, ownerid) VALUES ('sixth', 6);
INSERT INTO public.rooms (name, ownerid) VALUES ('seventh', 7);
INSERT INTO public.rooms (name, ownerid) VALUES ('eighth', 8);
INSERT INTO public.rooms (name, ownerid) VALUES ('ningth', 9);
INSERT INTO public.rooms (name, ownerid) VALUES ('tenth', 10);

INSERT INTO public.messages (author, room, text, date) VALUES (1, 1, 'Hi!', '2021-06-07 21:24:10.000000');
INSERT INTO public.messages (author, room, text, date) VALUES (2, 2, 'Lorem ipsum dolor sit amet', '2021-06-07 21:26:24.000000');
INSERT INTO public.messages (author, room, text, date) VALUES (3, 3, 'consectetuer adipiscing elit.', '2021-06-07 21:27:19.000000');
INSERT INTO public.messages (author, room, text, date) VALUES (4, 4, 'Aenean commodo ligula eget dolo', '2021-06-07 21:27:21.000000');
INSERT INTO public.messages (author, room, text, date) VALUES (5, 5, 'enean massa. Cum sociis natoq', '2021-06-07 21:27:22.000000');
INSERT INTO public.messages (author, room, text, date) VALUES (6, 6, 'penatibus et magnis dis pa', '2021-06-07 21:27:23.000000');
INSERT INTO public.messages (author, room, text, date) VALUES (7, 7, 'turient montes', '2021-06-07 21:27:56.000000');
INSERT INTO public.messages (author, room, text, date) VALUES (8, 8, 'Donec quam felis', '2021-06-07 21:27:57.000000');
INSERT INTO public.messages (author, room, text, date) VALUES (9, 9, 'pellentesque eu', '2021-06-07 21:28:15.000000');
INSERT INTO public.messages (author, room, text, date) VALUES (10, 10, 'Nulla consequat massa quis enim. ', '2021-06-07 21:27:26.000000');

INSERT INTO public.userchatrooms (userid, roomid) VALUES (1, 1);
INSERT INTO public.userchatrooms (userid, roomid) VALUES (2, 1);
INSERT INTO public.userchatrooms (userid, roomid) VALUES (3, 1);
INSERT INTO public.userchatrooms (userid, roomid) VALUES (4, 1);
INSERT INTO public.userchatrooms (userid, roomid) VALUES (5, 1);
INSERT INTO public.userchatrooms (userid, roomid) VALUES (6, 2);
INSERT INTO public.userchatrooms (userid, roomid) VALUES (7, 2);
INSERT INTO public.userchatrooms (userid, roomid) VALUES (8, 2);
INSERT INTO public.userchatrooms (userid, roomid) VALUES (9, 2);
INSERT INTO public.userchatrooms (userid, roomid) VALUES (10, 2);

INSERT INTO public.usercreatedrooms (userid, roomid) VALUES (1, 1);
INSERT INTO public.usercreatedrooms (userid, roomid) VALUES (1, 2);
INSERT INTO public.usercreatedrooms (userid, roomid) VALUES (1, 3);
INSERT INTO public.usercreatedrooms (userid, roomid) VALUES (1, 4);
INSERT INTO public.usercreatedrooms (userid, roomid) VALUES (1, 5);
INSERT INTO public.usercreatedrooms (userid, roomid) VALUES (1, 6);
INSERT INTO public.usercreatedrooms (userid, roomid) VALUES (1, 7);
INSERT INTO public.usercreatedrooms (userid, roomid) VALUES (1, 8);
INSERT INTO public.usercreatedrooms (userid, roomid) VALUES (1, 9);
INSERT INTO public.usercreatedrooms (userid, roomid) VALUES (1, 10);

INSERT INTO public.userroommessages (messageid, roomid) VALUES (1, 1);
INSERT INTO public.userroommessages (messageid, roomid) VALUES (2, 1);
INSERT INTO public.userroommessages (messageid, roomid) VALUES (3, 1);
INSERT INTO public.userroommessages (messageid, roomid) VALUES (4, 1);
INSERT INTO public.userroommessages (messageid, roomid) VALUES (5, 1);
INSERT INTO public.userroommessages (messageid, roomid) VALUES (6, 2);
INSERT INTO public.userroommessages (messageid, roomid) VALUES (7, 2);
INSERT INTO public.userroommessages (messageid, roomid) VALUES (8, 2);
INSERT INTO public.userroommessages (messageid, roomid) VALUES (9, 2);
INSERT INTO public.userroommessages (messageid, roomid) VALUES (10, 2);
