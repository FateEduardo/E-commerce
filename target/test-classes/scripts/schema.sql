

CREATE TABLE USER_ROLE (
  user_role_id VARCHAR(5) NOT NULL,
  description VARCHAR(20),

  PRIMARY KEY(user_role_id)
) ENGINE=InnoDB;

CREATE TABLE USER(
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20),
  name VARCHAR(100),
  user_role_id VARCHAR(5) NOT NULL,  
  active VARCHAR(1),

  PRIMARY KEY(username),
  INDEX idx_user_user_role_id(user_role_id),
  CONSTRAINT fk_user_role_user
    FOREIGN KEY(user_role_id)
    REFERENCES user_role(user_role_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE SHIP_TO (
  ship_to_id INTEGER NOT NULL,
  user VARCHAR(20) NOT NULL,
  address VARCHAR(250),
  zip_code INTEGER,
  phone VARCHAR(20),

  PRIMARY KEY(ship_to_id),
  INDEX idx_ship_to_user(user),
  CONSTRAINT fk_user_ship_to
    FOREIGN KEY(user)
    REFERENCES user(username)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE PAYMENT_METHOD (
  payment_method_id VARCHAR(5) NOT NULL,
  description VARCHAR(100),

  PRIMARY KEY(payment_method_id)
) ENGINE=InnoDB;

CREATE TABLE CATEGORY(
	category_id INTEGER NOT NULL,
	description VARCHAR(100),
    
PRIMARY KEY(category_id)


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

CREATE TABLE CATEGORY_ITEM(
	category_id INTEGER NOT NULL,
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
  cart_id INTEGER NOT NULL ,
  shipping_amount DECIMAL(10,2),
  cart_amount DECIMAL(10,2),
  ship_to_id INTEGER,
  active VARCHAR(2),
  create_date DATETIME,
  update_date DATETIME,

  PRIMARY KEY(cart_id),
  INDEX idx_cart_ship_to_id(ship_to_id),
  CONSTRAINT fk_ship_to_cart
    FOREIGN KEY(ship_to_id)
    REFERENCES ship_to(ship_to_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;

CREATE TABLE ITEM_ORDER(
	item_order_id INTEGER NOT NULL,
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


CREATE TABLE TSEQUENCE(
	seq_name VARCHAR(10) ,
	seq_acount INTEGER
)ENGINE=InnoDB;





