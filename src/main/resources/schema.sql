CREATE TABLE USER(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USERNAME VARCHAR(15),
    PASSWORD VARCHAR(500),
    EMAIL VARCHAR(40),
    FIRST_NAME VARCHAR(30),
    LAST_NAME VARCHAR(30)
);