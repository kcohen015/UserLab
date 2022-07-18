drop table USERS;

create table USERS(
uID int,
uName varchar(10) primary key ,
pWord varchar(10)
);

INSERT into USERS (uid, uName, pWord) values (1, "User123", "pw123456!");
INSERT into USERS (uid, uName, pWord) values (2, "User456", "pw457d!");
INSERT into USERS (uid, uName, pWord) values (3, "User789", "P75w23@!");
INSERT into USERS (uid, uName, pWord) values (4, "User012", "4klK45#");

select * from USERS;