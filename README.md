# TableCalories

sql table
login root
password root
hostname:127.0.0.1
port 3306

TABLES:
Product(name, calories, nutrion_info.id)
NutritionInfo( proteins, fats and carbohydrates)
IntakeReport(userId, dateTime, product,dishes, weight)
Dishes (Product, weight)


## SQL

# 1.
CREATE TABLE nutrion_info (
id INT PRIMARY KEY AUTO_INCREMENT,
proteins FLOAT,
fats FLOAT,
carbohydrates FLOAT
);

# 2.
CREATE TABLE product (
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255),
calories INT,
nutrition_info_id INT,
FOREIGN KEY (nutrition_info_id) REFERENCES nutrion_info(id)
);

# 3.

CREATE TABLE dish (
id INT PRIMARY KEY AUTO_INCREMENT,
total_weight_id INT
);

# 4.
CREATE TABLE component_of_dish (
id INT PRIMARY KEY AUTO_INCREMENT,
product_id INT,
product_weight DECIMAL(10,2),
dish_id INT,
FOREIGN KEY (product_id) REFERENCES product(id),
FOREIGN KEY (dish_id) REFERENCES dish(id)
);
