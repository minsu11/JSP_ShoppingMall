use ShoppingMall;
DROP TABLE IF EXISTS `Categories`;

CREATE TABLE `Categories` (
                              `category_id`	INT	NOT NULL auto_increment,
                              `CategoryName`	varchar(50)	NOT NULL,
                              primary key(`category_id`)
);

CREATE TABLE `Products` (
                            `product_id`	INT	NOT NULL auto_increment,
                            `product_number`	nvarchar(10)	NOT NULL unique ,
                            `product_name`	nvarchar(120)	NOT NULL,
                            `unit_cost`	int	NOT NULL,
                            `description`	text	NOT NULL,
                            `product_inventory` INT NOT NULL default 0,
                            `product_created_at` datetime NOT NULL default now(),
                            primary key(`product_id`)
);

CREATE TABLE `Reviews` (
                           `review_id`	int	NOT NULL auto_increment,
                           `rating`	int	NOT NULL,
                           `comments`	text	NOT NULL,
                           `product_id`	INT	NULL,
                           `user_id`	int	NOT NULL	COMMENT '아이디',
                           primary key(`review_id`)
);

CREATE TABLE `Orders` (
                          `order_id`	int	NOT NULL,
                          `order_date`	Datetime	NOT NULL	DEFAULT now(),
                          `ship_date`	Datetime	NOT NULL,
                          `user_id`	int	NOT NULL	COMMENT '아이디',
                          `order_address`	varchar(50)	NOT NULL,
                          primary key(`order_id`)
);

DROP TABLE IF EXISTS `OrderDetails`;

CREATE TABLE `OrderDetails` (
                                `order_detail_id` INT NOT NULL auto_increment,
                                `product_id`	INT	NOT NULL,
                                `order_id`	int	NOT NULL,
                                `quantity`	int	NOT NULL,
                                `unit_cost`	decimal(15)	NOT NULL,
                                primary key(`order_detail_id`)
);

CREATE TABLE `users` (
                         `user_id`	int	NOT NULL auto_increment,
                         `user_input_id`	varchar(50)	NOT NULL unique,
                         `user_name`	varchar(50)	NOT NULL	COMMENT '이름',
                         `user_password`	varchar(200)	NOT NULL	COMMENT 'mysql password 사용',
                         `user_birth`	varchar(8)	NOT NULL	COMMENT '생년월일 : 19840503',
                         `user_auth`	varchar(10)	NOT NULL	COMMENT '권한: ROLE_ADMIN,ROLE_USER',
                         `user_point`	int	NOT NULL	COMMENT 'default : 1000000',
                         `created_at`	datetime	NOT NULL	COMMENT '가입일자',
                         `latest_login_at`	datetime	NULL	DEFAULT NULL	COMMENT '마지막 로그인 일자',
                         primary key(`user_id`)
);

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
                           `payment_id`	INT	NOT NULL auto_increment,
                           `order_id`	int	NOT NULL COMMENT '주문 아이디',
                           `user_id`	int	NOT NULL	COMMENT '아이디',
                           primary key(`payment_id`)

);

DROP TABLE IF EXISTS `ShoppingCart`;

CREATE TABLE `ShoppingCart` (
                                `record_id`	int	NOT NULL auto_increment,
                                `cart_id`	nvarchar(150)	NOT NULL,
                                `quantity`	int	NOT NULL,
                                `shopping_cart_created_at`	Datetime	NOT NULL	DEFAULT Now(),
                                `product_id`	INT	NOT NULL,
                                primary key(`record_id`)
);



CREATE TABLE `point_history` (
                                 `point_history_id`	int	NOT NULL auto_increment,
                                 `date`	DATE	NOT NULL,
                                 `type`	Tinyint(1)	NOT NULL COMMENT '적립 또는 사용',
                                 `detail`	VARCHAR(100)	NOT NULL,
                                 `used_points`	DATE	NOT NULL,
                                 `points_detail`	INTEGER	NOT NULL,
                                 `remaining_points`	integer	NOT NULL,
                                 `user_id`	int	NOT NULL	COMMENT '아이디',
                                 primary key(`point_history_id`)
);

DROP TABLE IF EXISTS `ProductCategory`;

CREATE TABLE `ProductCategory` (
                                   `product_id`	INT	NOT NULL,
                                   `category_id`	INT	NOT NULL,
    primary key (`product_id`,`category_id`)
);

DROP TABLE IF EXISTS `Address`;

CREATE TABLE `Address` (
                           `address_id`	int	NOT NULL auto_increment,
                           `user_id`	int	NOT NULL	COMMENT '아이디',
                           `address_name`	varchar(50)	NOT NULL,
                           primary key(`address_id`)
);

CREATE TABLE `Image` (
                         `image_id`	int	NOT NULL auto_increment,
                         `product_id`	INT	NOT NULL,
                         `image_path`	varchar(200)	NOT NULL,
                         `image_created_at`	datetime	NOT NULL,
                         primary key(`image_id`)
);

create index `user_created_date_index` on `users`(created_at);


ALTER TABLE `Reviews` ADD CONSTRAINT `FK_Products_TO_Reviews_1` FOREIGN KEY (
                                                                             `product_id`
    )
    REFERENCES `Products` (
                           `product_id`
        );

ALTER TABLE `Reviews` ADD CONSTRAINT `FK_users_TO_Reviews_1` FOREIGN KEY (
                                                                          `user_id`
    )
    REFERENCES `users` (
                        `user_id`
        );

ALTER TABLE `Orders` ADD CONSTRAINT `FK_users_TO_Orders_1` FOREIGN KEY (
                                                                        `user_id`
    )
    REFERENCES `users` (
                        `user_id`
        );

ALTER TABLE `OrderDetails` ADD CONSTRAINT `FK_Products_TO_OrderDetails_1` FOREIGN KEY (
                                                                                       `product_id`
    )
    REFERENCES `Products` (
                           `product_id`
        );

ALTER TABLE `OrderDetails` ADD CONSTRAINT `FK_Orders_TO_OrderDetails_1` FOREIGN KEY (
                                                                                     `order_id`
    )
    REFERENCES `Orders` (
                         `order_id`
        );

ALTER TABLE `payment` ADD CONSTRAINT `FK_Orders_TO_payment_1` FOREIGN KEY (
                                                                           `order_id`
    )
    REFERENCES `Orders` (
                         `order_id`
        );

ALTER TABLE `payment` ADD CONSTRAINT `FK_users_TO_payment_1` FOREIGN KEY (
                                                                          `user_id`
    )
    REFERENCES `users` (
                        `user_id`
        );

ALTER TABLE `ShoppingCart` ADD CONSTRAINT `FK_Products_TO_ShoppingCart_1` FOREIGN KEY (
                                                                                       `product_id`
    )
    REFERENCES `Products` (
                           `product_id`
        );

ALTER TABLE `point_history` ADD CONSTRAINT `FK_users_TO_point_history_1` FOREIGN KEY (
                                                                                      `user_id`
    )
    REFERENCES `users` (
                        `user_id`
        );

ALTER TABLE `ProductCategory` ADD CONSTRAINT `FK_Products_TO_ProductCategory_1` FOREIGN KEY (
                                                                                             `product_id`
    )
    REFERENCES `Products` (
                           `product_id`
        );

ALTER TABLE `ProductCategory` ADD CONSTRAINT `FK_Categories_TO_ProductCategory_1` FOREIGN KEY (
                                                                                               `category_id`
    )
    REFERENCES `Categories` (
                             `category_id`
        );

ALTER TABLE `Address` ADD CONSTRAINT `FK_users_TO_Address_1` FOREIGN KEY (
                                                                          `user_id`
    )
    REFERENCES `users` (
                        `user_id`
        );

ALTER TABLE `Image` ADD CONSTRAINT `FK_Products_TO_Image_1` FOREIGN KEY (
                                                                         `product_id`
    )
    REFERENCES `Products` (
                           `product_id`
        );

