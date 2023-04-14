CREATE TABLE `fabbrica_treno`.`vagone` (
	id INT NOT NULL AUTO_INCREMENT,
    peso DOUBLE,
    PRIMARY KEY (id)
);

CREATE TABLE `fabbrica_treno`.`locomotiva` (
	id INT NOT NULL AUTO_INCREMENT,
    massa_trainata DOUBLE,
    peso DOUBLE,
    PRIMARY KEY (id)
);

CREATE TABLE `fabbrica_treno`.`treno` (
	id INT NOT NULL AUTO_INCREMENT,
    locomotiva_id INT,
    vagone_id INT,
    PRIMARY KEY (id)
);
