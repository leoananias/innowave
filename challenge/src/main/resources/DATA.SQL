
CREATE TABLE CHALLENGE.CHANNEL(ID VARCHAR(255) PRIMARY KEY,
                     NAME VARCHAR(255),
                     POSITION INT,
                     CATEGORY VARCHAR(255));

CREATE TABLE CHALLENGE.PROGRAM(ID VARCHAR(255) PRIMARY KEY,
                     CHANNEL_ID VARCHAR(255),
                     IMAGEURL VARCHAR(255),
                     TITLE VARCHAR(255),
                     DESCRIPTION VARCHAR(255),
                     START_TIME DATE,
                     END_TIME DATE);