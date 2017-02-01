CREATE TABLE TSEQUENCE(
	seq_name VARCHAR(10) ,
	seq_acount INTEGER
)ENGINE=InnoDB;



CREATE TABLE ITEM (
  item_id INTEGER NOT NULL ,
  description VARCHAR(100),
  features VARCHAR(250),
  unit_price DECIMAL(10,2),
  stock INTEGER,
  active VARCHAR(1),
  PRIMARY KEY(item_id)
) ENGINE=InnoDB;