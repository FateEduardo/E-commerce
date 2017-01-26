

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
  name VARCHAR(100),
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



//Item primero y carrito

CREATE TABLE ITEM_ORDER(
	item_order_id INTEGER NOT NULL,
	item_id INTEGER,
	cart_id INTEGER,
	quantity INTEGER,
	PRIMARY KEY(item_order_id),
	INDEX idx_item_order_item_id(item_id),
	INDEX idx_item_order_cart_id(cart_id),
	CONSTRAINT fk_item_item_order
	    FOREIGN KEY(item_id)
	    REFERENCES (item_id)
	    ON DELETE RESTRICT
	    ON UPDATE CASCADE,
    CONSTRAINT fk_cart_item_order
	    FOREIGN KEY(cart_id)
	    REFERENCES user(cart_id)
	    ON DELETE RESTRICT
	    ON UPDATE CASCADE
)





