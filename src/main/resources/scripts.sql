CREATE TABLE product
(
  productId            BIGINT       NOT NULL
    PRIMARY KEY AUTO_INCREMENT,
  product_category     VARCHAR(255) NULL,
  product_condition    VARCHAR(255) NULL,
  product_description  VARCHAR(255) NULL,
  product_manufacturer VARCHAR(255) NULL,
  product_name         VARCHAR(255) NULL,
  product_price        DOUBLE       NULL,
  product_status       VARCHAR(255) NULL,
  unit_in_stock        INT          NULL,
  INDEX (productId)
);

CREATE TABLE user
(
  id             BIGINT       NOT NULL
    PRIMARY KEY AUTO_INCREMENT,
  user_email     VARCHAR(255) NULL,
  user_name      VARCHAR(255) NULL,
  password       VARCHAR(255) NULL,
  customer_phone VARCHAR(255) NULL,
  INDEX (id)
);


CREATE TABLE role
(
  id   BIGINT       NOT NULL
    PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NULL,
  INDEX (id)
);

CREATE TABLE user_role
(
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user (id),
  FOREIGN KEY (role_id) REFERENCES role (id)
);

CREATE TABLE billing_address
(
  id               BIGINT       NOT NULL
    PRIMARY KEY AUTO_INCREMENT,
  apartment_number VARCHAR(255) NULL,
  city             VARCHAR(255) NULL,
  country          VARCHAR(255) NULL,
  state            VARCHAR(255) NULL,
  street_name      VARCHAR(255) NULL,
  zip_code         VARCHAR(255) NULL,
  user_id          BIGINT       NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user (id),
  INDEX (id)
);

CREATE TABLE payment_info
(
  id           BIGINT       NOT NULL
    PRIMARY KEY AUTO_INCREMENT,
  card_number  VARCHAR(255) NULL,
  cvv          VARCHAR(255) NULL,
  first_name   VARCHAR(255) NULL,
  last_name    VARCHAR(255) NULL,
  phone_number VARCHAR(255) NULL,
  user_id      BIGINT       NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user (id),
  INDEX (id)
);


CREATE TABLE shipping_address
(
  id               BIGINT       NOT NULL
    PRIMARY KEY AUTO_INCREMENT,
  apartment_number VARCHAR(255) NULL,
  city             VARCHAR(255) NULL,
  country          VARCHAR(255) NULL,
  state            VARCHAR(255) NULL,
  street_name      VARCHAR(255) NULL,
  zip_code         VARCHAR(255) NULL,
  user_id          BIGINT       NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user (id),
  INDEX (id)
);

CREATE TABLE cart
(
  id      BIGINT NOT NULL
    PRIMARY KEY AUTO_INCREMENT,
  user_id BIGINT NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user (id),
  INDEX (id)
);

CREATE TABLE cart_item
(
  id         BIGINT NOT NULL
    PRIMARY KEY AUTO_INCREMENT,
  quantity   INT    NULL,
  cart_id    BIGINT NOT NULL,
  product_id BIGINT NULL,

  FOREIGN KEY (cart_id) REFERENCES cart (id),
  FOREIGN KEY (product_id) REFERENCES product (productId)
);

CREATE TABLE customer_order
(
  id                BIGINT      NOT NULL
    PRIMARY KEY AUTO_INCREMENT,
  date              DATETIME(6) NULL,
  total             FLOAT       NULL,
  billingAddressId  BIGINT      NULL,
  payment_info_id   BIGINT      NOT NULL,
  shippingAddressId BIGINT      NULL,
  customerId        BIGINT      NULL,
  FOREIGN KEY (billingAddressId) REFERENCES billing_address (id),
  FOREIGN KEY (payment_info_id) REFERENCES payment_info (id),
  FOREIGN KEY (shippingAddressId) REFERENCES shipping_address (id),
  FOREIGN KEY (customerId) REFERENCES user (id),
  INDEX (id)
);


