CREATE TABLE movie (
	id BIGINT NOT NULL AUTO_INCREMENT,
	title varchar(255) NOT NULL,
	genre varchar(255) NOT NULL,
	rating varchar(255) NOT NULL,
	PRIMARY KEY (id)
);

insert into movie (title, genre, rating) values ('IT','Horror','18');