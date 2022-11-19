grant all privileges on musicdb to 'admin'@'localhost';
flush privileges;
set global time_zone='+3:00';

use musicdb;

create table SINGER (
    ID int not null auto_increment,
    FIRST_NAME varchar(60) not null,
    LAST_NAME varchar(40) not null,
    BIRTH_DATE date,
    unique UQ_SINGER_1 (FIRST_NAME, LAST_NAME),
    primary key(ID)
);

create table ALBUM (
    ID int not null auto_increment,
    SINGER_ID int not null,
    TITLE varchar(100) not null,
    RELEASE_DATE date,
    unique UQ_SINGER_ALBUM_1 (SINGER_ID, TITLE),
    primary key (ID),
    constraint FK_ALBUM foreign key(SINGER_ID) references SINGER (ID)
);