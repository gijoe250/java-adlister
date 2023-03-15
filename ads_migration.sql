USE adlister_db;

DROP TABLE IF EXISTS ads;

CREATE TABLE ads (
                        id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                        title VARCHAR(100),
                        description VARCHAR(100),
                        PRIMARY KEY (id),
                        UNIQUE artist_name (artist, name)
);