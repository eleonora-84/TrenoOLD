
CREATE TABLE IF NOT EXISTS `fabbrica_treno`.`treno` (
    id INT NOT NULL AUTO_INCREMENT,
    locomotiva_id INT,
    vagone_id INT,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `fabbrica_treno`.`vagone` (
	id INT NOT NULL AUTO_INCREMENT,
    peso DOUBLE,
    treno_id INT,
    FOREIGN KEY (treno_id) REFERENCES fabbrica_treno.treno(id),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `fabbrica_treno`.`locomotiva` (
	id INT NOT NULL AUTO_INCREMENT,
    massa_trainata DOUBLE,
    peso DOUBLE,
    treno_id INT,
    FOREIGN KEY (treno_id) REFERENCES fabbrica_treno.treno(id),
    PRIMARY KEY (id)
);

