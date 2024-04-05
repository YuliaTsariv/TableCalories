CREATE TABLE nutrition_info (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              proteins FLOAT,
                              fats FLOAT,
                              carbohydrates FLOAT
);


CREATE TABLE product (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255),
                         calories INT,
                         nutrition_info_id INT,
                         FOREIGN KEY (nutrition_info_id) REFERENCES nutrition_info(id)
);


CREATE TABLE user_order (
                            id               BIGINT PRIMARY KEY AUTO_INCREMENT,
                            user_id          BIGINT,
                            product_id       BIGINT,
                            weight           BIGINT,
                            date     DATETIME  NOT NULL,
                            FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE INDEX idx_order_user_id ON user_order(user_id, date);
