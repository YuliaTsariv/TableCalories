-- liquibase formatted sql


-- changeset tsariv:1 onValidationFail:HALT
CREATE TABLE nutrition_info (
                              id INT PRIMARY KEY AUTO_INCREMENT,
                              proteins FLOAT,
                              fats FLOAT,
                              carbohydrates FLOAT
);


CREATE TABLE product (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(255),
                         calories INT,
                         nutrition_info_id INT,
                         FOREIGN KEY (nutrition_info_id) REFERENCES nutrition_info(id)
);

CREATE TABLE dish (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      total_weight_id INT
);


CREATE TABLE component_of_dish (
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   product_id INT,
                                   product_weight DECIMAL(10,2),
                                   dish_id INT,
                                   FOREIGN KEY (product_id) REFERENCES product(id),
                                   FOREIGN KEY (dish_id) REFERENCES dish(id));