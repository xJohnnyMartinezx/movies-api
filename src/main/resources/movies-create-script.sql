# 1. go get the json file from glitch
# 2. copypasta into a new json file under /resources

# --> You may need to establish a connection to your localhost db here

# 3. create the movies_db
CREATE DATABASE IF NOT EXISTS movies_db;

# 4. use the movies_db
USE movies_db;


# 5. drop the table(s) to which no other tables are dependent (none at first)
DROP TABLE IF EXISTS movies;
DROP TABLE IF EXISTS directors;

# 6. map the json movie properties to movies table columns
# --> start with just a movies table with all the columns found in the movie json properties

CREATE TABLE IF NOT EXISTS directors
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(120),
    PRIMARY KEY (id)

);

CREATE TABLE IF NOT EXISTS movies
(
    id       INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title    VARCHAR(120),
    year     CHAR(4),
    plot     TEXT,
    poster   TEXT,
    rating   CHAR(1),
    director VARCHAR(120),
    director_id INT UNSIGNED NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (director_id) REFERENCES directors(id)
);


# 6a. Run the script to make sure it works

DESCRIBE movies;

# 7. refactor to extract the directors to a new table with just an id and name


# --> change the movies table to reference the directors table via Foreign Key
# --> now that movies is dependent on directors, you need to move directors above movies in the script

# 8. Go add DROP IF EXIST statements for movies and directors

# 9. RUN IT!




