
CREATE TABLE USER_ROLE (
  user_role_id VARCHAR(5) NOT NULL,
  description VARCHAR(20),

  PRIMARY KEY(user_role_id)
);

CREATE TABLE USER(
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20),
  name VARCHAR(100),
  user_role_id VARCHAR(5) NOT NULL,  
  active VARCHAR(1),

  PRIMARY KEY(username),
  CONSTRAINT fk_user_role_user
    FOREIGN KEY(user_role_id)
    REFERENCES user_role(user_role_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
);