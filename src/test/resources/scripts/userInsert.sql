ALTER TABLE USER_ROLE CHANGE user_role_id user_role_id VARCHAR(20);
ALTER TABLE USER CHANGE user_role_id user_role_id VARCHAR(20);

INSERT INTO USER_ROLE(user_role_id, description) VALUES('ROLE_ADMIN','Admin');
INSERT INTO USER_ROLE(user_role_id, description) VALUES('ROLE_USR','Registered User');


INSERT INTO USER(username, password, name, user_role_id, active) VALUES('admin','admin','Adminstrator','ROLE_ADMIN','S');
INSERT INTO USER(username, password, name, user_role_id, active) VALUES('jorge.gonzalez','jorge.gonzalez','Jorge Gonzalez','ROLE_USR','S');
INSERT INTO USER(username, password, name, user_role_id, active) VALUES('carlos.fuentes','carlos.fuentes','Carlos Fuentes','ROLE_USR','S');
INSERT INTO USER(username, password, name, user_role_id, active) VALUES('dani','dani','dani','ROLE_USR','S');


INSERT INTO CATEGORY(category_id,description) VALUES(1,'SHOES');
INSERT INTO CATEGORY(category_id,description) VALUES(2,'SWEATER');

INSERT INTO TSEQUENCE(seq_name,seq_acount) VALUES('ITEM',2);
INSERT INTO TSEQUENCE(seq_name,seq_acount) VALUES('CART',1);

INSERT INTO ITEM(item_id,description,features,unit_price,stock,active) VALUES(1,'WHITE COLOR','SIZE 10',15.0,4,'S');

INSERT INTO CATEGORY_ITEM(category_id,item_id) VALUES(1,1);