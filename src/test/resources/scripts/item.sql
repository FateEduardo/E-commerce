CREATE TABLE TSEQUENCE(
	seq_name VARCHAR(10) ,
	seq_acount INTEGER
);

CREATE TABLE CATEGORY(
	category_id INTEGER NOT NULL,
	description VARCHAR(100),
    
PRIMARY KEY(category_id)


);

CREATE TABLE ITEM (
  item_id INTEGER NOT NULL ,
  description VARCHAR(100),
  features VARCHAR(250),
  unit_price DECIMAL(10,2),
  stock INTEGER,
  active VARCHAR(1),
  PRIMARY KEY(item_id)
) ;
CREATE TABLE CATEGORY_ITEM(
	category_id INTEGER NOT NULL,
	item_id INTEGER NOT NULL,
    
PRIMARY KEY(category_id,item_id),
  CONSTRAINT fk_category_category_item
    FOREIGN KEY(category_id)
    REFERENCES category(category_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_item_category_item
    FOREIGN KEY(item_id)
    REFERENCES item(item_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE

);