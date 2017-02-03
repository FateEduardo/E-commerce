

CREATE TABLE USER_ROLE (
  user_role_id VARCHAR(20) NOT NULL,
  description VARCHAR(20),

  PRIMARY KEY(user_role_id)
) ENGINE=InnoDB;

CREATE TABLE USER(
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20),
  name VARCHAR(100),
  user_role_id VARCHAR(20) NOT NULL,  
  active VARCHAR(1),

  PRIMARY KEY(username),
  INDEX idx_user_user_role_id(user_role_id),
  CONSTRAINT fk_user_role_user
    FOREIGN KEY(user_role_id)
    REFERENCES user_role(user_role_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;



CREATE TABLE CATEGORY(
	category_id INTEGER NOT NULL AUTO_INCREMENT,
	description VARCHAR(100),
    
PRIMARY KEY(category_id)


)ENGINE=InnoDB;

CREATE TABLE ITEM (
  item_id INTEGER NOT NULL AUTO_INCREMENT ,
  description VARCHAR(100),
  features VARCHAR(250),
  unit_price DECIMAL(10,2),
  stock INTEGER,
  active VARCHAR(1),
  PRIMARY KEY(item_id)
) ENGINE=InnoDB;

CREATE TABLE CATEGORY_ITEM(
	category_id INTEGER NOT NULL AUTO_INCREMENT,
	item_id INTEGER NOT NULL,
    
PRIMARY KEY(category_id,item_id),
INDEX idx_item_category_id(category_id),
  INDEX idx_category_item_id(item_id),
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

)ENGINE=InnoDB;

CREATE TABLE CART (
  cart_id INTEGER NOT NULL AUTO_INCREMENT,
  shipping_amount DECIMAL(10,2),
  cart_amount DECIMAL(10,2),
  username VARCHAR(20),
  active VARCHAR(2),
  create_date DATETIME,
  update_date DATETIME,

  PRIMARY KEY(cart_id),
  INDEX idx_cart_username(username),
  CONSTRAINT fk_username_cart
    FOREIGN KEY(username)
    REFERENCES user(username)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE ITEM_ORDER(
	item_order_id INTEGER NOT NULL AUTO_INCREMENT,
	item_id INTEGER,
	cart_id INTEGER,
	quantity INTEGER,
    create_date DATETIME,
    update_date DATETIME,
	PRIMARY KEY(item_order_id),
	INDEX idx_item_order_item_id(item_id),
	INDEX idx_item_order_cart_id(cart_id),
	CONSTRAINT fk_item_item_order
	    FOREIGN KEY(item_id)
	    REFERENCES item(item_id)
	    ON DELETE RESTRICT
	    ON UPDATE CASCADE,
    CONSTRAINT fk_cart_item_order
	    FOREIGN KEY(cart_id)
	    REFERENCES cart(cart_id)
	    ON DELETE RESTRICT
	    ON UPDATE CASCADE
)ENGINE=InnoDB;







