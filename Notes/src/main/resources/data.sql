insert into user (id, username, password) values (101, 'angela', 'angela');
insert into user (id, username, password) values (102, 'user1', 'password');

insert into note (id, title, content, user_id) values (1, 'Book', 'Pride and Prejudice', 101);
insert into note (id, title, content, user_id) values (2, 'Magazines', 'Vogue', 102);

insert into tag (id, name, user_id) values (10,'literature', 101);
insert into tag (id, name, user_id) values (11, 'news', 102);

insert into note_tags(note_id, tags_id) values(1, 10);