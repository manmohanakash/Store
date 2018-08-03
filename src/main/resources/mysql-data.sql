/*
USER TABLE
*/

INSERT INTO `user`(`account_status`, `email`, `last_login`, `password`, `user_name`, `user_type`) VALUES 
("active","akashmanmohan@gmail.com","2008-11-11 13:23:44","password","user","superadmin");

INSERT INTO `user`(`account_status`, `email`, `last_login`, `password`, `user_name`, `user_type`) VALUES 
("active","viraj.karjol@gmail.com","2018-1-11 15:23:44","test","viraj","admin");

INSERT INTO `user`(`account_status`, `email`, `last_login`, `password`, `user_name`, `user_type`) VALUES 
("active","abhay.singh@gmail.com","2018-11-11 15:23:44","test","abhaj","admin");

INSERT INTO `user`(`account_status`, `email`, `last_login`, `password`, `user_name`, `user_type`) VALUES 
("suspended","shubham@gmail.com","2018-7-3 19:11:11","test","shubham","admin");

INSERT INTO `user`(`account_status`, `email`, `last_login`, `password`, `user_name`, `user_type`) VALUES 
("active","user1@gmail.com","2012-7-3 19:11:11","test1","user1","customer");

INSERT INTO `user`(`account_status`, `email`, `last_login`, `password`, `user_name`, `user_type`) VALUES 
("active","user2@gmail.com","2013-7-3 9:11:11","test2","user2","customer");

INSERT INTO `user`(`account_status`, `email`, `last_login`, `password`, `user_name`, `user_type`) VALUES 
("active","user3@gmail.com","2014-7-3 19:1:11","test3","user3","customer");

INSERT INTO `user`(`account_status`, `email`, `last_login`, `password`, `user_name`, `user_type`) VALUES 
("suspended","user4@gmail.com","2015-7-3 00:11:11","test4","user4","customer");

/*
 CUSTOMER TABLE
 */

INSERT INTO `customer`(`address`, `city`, `country`, `door_number`, `first_name`, `last_name`, `phone`, `pincode`, `user_id`) VALUES 
("413 Summit Avenue","Arlington","united states","250","Manmohan","Akash","6822561237","76013",5);

INSERT INTO `customer`(`address`, `city`, `country`, `door_number`, `first_name`, `last_name`, `phone`, `pincode`, `user_id`) VALUES 
("444 Summit Avenue","Arlington","united states","250","test1",null,"6822561237","76013",6);

INSERT INTO `customer`(`address`, `city`, `country`, `door_number`, `first_name`, `last_name`, `phone`, `pincode`, `user_id`) VALUES 
("413 Summit Avenue","Arlington","united states","250","test2",null,"5133561237","76013",7);

INSERT INTO `customer`(`address`, `city`, `country`, `door_number`, `first_name`, `last_name`, `phone`, `pincode`, `user_id`) VALUES 
("413 Summit Avenue","Arlington","united states","250","jordan","test3","1113261237","76013",8);

/*
 UPDATE CUTOMER ID IN USER TABLE
 */

UPDATE `user` SET `customer_id`=1 WHERE user_id=5;
UPDATE `user` SET `customer_id`=2 WHERE user_id=6;
UPDATE `user` SET `customer_id`=3 WHERE user_id=7;
UPDATE `user` SET `customer_id`=4 WHERE user_id=8;

/*
 CATEGORY TABLE
 */

INSERT INTO `category`( `category_name`, `description`) VALUES ("Beverages","Soft drinks, coffees, teas, beers, and ales");
INSERT INTO `category`( `category_name`, `description`) VALUES ("Condiments","Sweet and savory sauces, relishes, spreads, and seasonings");
INSERT INTO `category`( `category_name`, `description`) VALUES ("Confections","Desserts, candies, and sweet breads");
INSERT INTO `category`( `category_name`, `description`) VALUES ("Dairy Products","Cheeses");
INSERT INTO `category`( `category_name`, `description`) VALUES ("Grains/Cereals","Breads, crackers, pasta, and cereal");
INSERT INTO `category`( `category_name`, `description`) VALUES ("Meat/Poultry","Prepared meats");
INSERT INTO `category`( `category_name`, `description`) VALUES ("Produce","Dried fruit and bean curd");
INSERT INTO `category`( `category_name`, `description`) VALUES ("Seafood","Seaweed and fish");

/*
 PRODUCTS TABLE
 */

INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Joy Security',667,'10 boxes x 20 bags',0,'Chais',18,1);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Fjordustries',1455,'24 - 12 oz bottles',0,'Chang',19,1);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Fjordustries',1481,'12 - 550 ml bottles',0,'Aniseed Syrup',10,2);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('North Star ',1140,'48 - 6 oz jars',0,'Chef Antons Cajun Seasoning',22,2);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('North Star ',1346,'36 boxes',0,'Chef Antons Gumbo Mix',21.35,2);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Moonnetworks',903,'12 - 8 oz jars',0,'Grandmas Boysenberry Spread',25,2);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Griffindustries',402,'12 - 1 lb pkgs.',0,'Uncle Bobs Organic Dried Pears',30,7);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('North Star ',490,'12 - 12 oz jars',0,'Northwoods Cranberry Sauce',40,2);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Griffindustries',1001,'18 - 500 g pkgs.',0,'Mishi Kobe Niku',97,6);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Voidustries',761,'12 - 200 ml jars',0,'Ikura',31,8);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Fjordustries',317,'1 kg pkg.',0,'Queso Cabrales',21,4);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Fjordustries',1080,'10 - 500 g pkgs.',0,'Queso Manchego La Pastora',38,4);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Riverbit',228,'2 kg box',0,'Konbu',6,8);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Joy Security',1420,'40 - 100 g pkgs.',0,'Tofu',23.25,7);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Fjordustries',1057,'24 - 250 ml bottles',0,'Genen Shouyu',15.5,2);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Joy Security',1013,'32 - 500 g boxes',0,'Pavlova',17.45,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Flux Sports',1226,'20 - 1 kg tins',0,'Alice Mutton',39,6);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Griffindustries',410,'16 kg pkg.',0,'Carnarvon Tigers',62.5,8);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Moonnetworks',445,'10 boxes x 12 pieces',0,'Teatime Chocolate Biscuits',9.2,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Joy Security',1006,'30 gift boxes',0,'Sir Rodneys Marmalade',81,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Riverbit',774,'24 pkgs. x 4 pieces',0,'Sir Rodneys Scones',10,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('North Star ',610,'24 - 500 g pkgs.',0,'Gustafs Knäckebröd',21,5);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Joy Security',481,'12 - 250 g pkgs.',0,'Tunnbröd',9,5);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Voidustries',1073,'12 - 355 ml cans',0,'Guaraná Fantástica',4.5,1);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Griffindustries',861,'20 - 450 g glasses',0,'NuNuCa Nuß-Nougat-Creme',14,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Amazonphone',659,'100 - 250 g bags',0,'Gumbär Gummibärchen',31.23,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Griffindustries',1080,'100 - 100 g pieces',0,'Schoggi Schokolade',43.9,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Griffindustries',35,'25 - 825 g cans',0,'Rössle Sauerkraut',45.6,7);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('North Star ',1390,'50 bags x 30 sausgs.',0,'Thüringer Rostbratwurst',123.79,6);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('North Star ',8,'10 - 200 g glasses',0,'Nord-Ost Matjeshering',25.89,8);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Flux Sports',1269,'12 - 100 g pkgs',0,'Gorgonzola Telino',12.5,4);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Griffindustries',335,'24 - 200 g pkgs.',0,'Mascarpone Fabioli',32,4);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('North Star ',235,'500 g',0,'Geitost',2.5,4);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Amazonphone',172,'24 - 12 oz bottles',0,'Sasquatch Ale',14,1);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Voidustries',1300,'24 - 12 oz bottles',0,'Steeleye Stout',18,1);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Amazonphone',174,'24 - 250 g jars',0,'Inlagd Sill',19,8);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Amazonphone',1027,'12 - 500 g pkgs.',0,'Gravad lax',26,8);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Flux Sports',1408,'12 - 75 cl bottles',0,'Côte de Blaye',263.5,1);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Flux Sports',1252,'750 cc per bottle',0,'Chartreuse verte',18,1);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Fjordustries',595,'24 - 4 oz tins',0,'Boston Crab Meat',18.4,8);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Fjordustries',707,'12 - 12 oz cans',0,'Jacks New England Clam Chowder',9.65,8);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Amazonphone',706,'32 - 1 kg pkgs.',0,'Singaporean Hokkien Fried Mee',14,5);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Fjordustries',1260,'16 - 500 g tins',0,'Ipoh Coffee',46,1);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Voidustries',574,'20 - 2 kg bags',0,'Gula Malacca',19.45,2);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Riverbit',1247,'1k pkg.',0,'Røgede sild',9.5,8);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Joy Security',702,'4 - 450 g glasses',0,'Spegesild',12,8);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Moonnetworks',36,'10 - 4 oz boxes',0,'Zaanse koeken',9.5,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Amazonphone',1006,'10 pkgs.',0,'Chocolade',12.75,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Fjordustries',305,'24 - 50 g pkgs.',0,'Maxilaku',20,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Griffindustries',1132,'12 - 100 g bars',0,'Valkoinen suklaa',16.25,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Amazonphone',151,'50 - 300 g pkgs.',0,'Manjimup Dried Apples',53,7);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Joy Security',1028,'16 - 2 kg boxes',0,'Filo Mix',7,5);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Moonnetworks',729,'48 pieces',0,'Perth Pasties',32.8,6);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Joy Security',1447,'16 pies',0,'Tourtière',7.45,6);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Voidustries',971,'24 boxes x 2 pies',0,'Pâté chinois',24,6);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Griffindustries',1491,'24 - 250 g pkgs.',0,'Gnocchi di nonna Alice',38,5);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Joy Security',1361,'24 - 250 g pkgs.',0,'Ravioli Angelo',19.5,5);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Flux Sports',1050,'24 pieces',0,'Escargots de Bourgogne',13.25,8);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Voidustries',530,'5 kg pkg.',0,'Raclette Courdavault',55,4);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('North Star ',1100,'15 - 300 g rounds',0,'Camembert Pierrot',34,4);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Flux Sports',708,'24 - 500 ml bottles',0,'Sirop dérable',28.5,2);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Griffindustries',246,'48 pies',0,'Tarte au sucre',49.3,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Amazonphone',45,'15 - 625 g jars',0,'Vegie-spread',43.9,2);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Riverbit',1217,'20 bags x 4 pieces',0,'Wimmers gute Semmelknödel',33.25,5);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Voidustries',1127,'32 - 8 oz bottles',0,'Louisiana Fiery Hot Pepper Sauce',21.05,2);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Joy Security',1144,'24 - 8 oz jars',0,'Louisiana Hot Spiced Okra',17,2);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('North Star ',5,'24 - 12 oz bottles',0,'Laughing Lumberjack Lager',14,1);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Flux Sports',520,'10 boxes x 8 pieces',0,'Scottish Longbreads',12.5,3);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Riverbit',562,'10 kg pkg.',0,'Gudbrandsdalsost',36,4);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Riverbit',966,'24 - 355 ml bottles',0,'Outback Lager',15,1);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Griffindustries',215,'10 - 500 g pkgs.',0,'Fløtemysost',21.5,4);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Amazonphone',358,'24 - 200 g pkgs.',0,'Mozzarella di Giovanni',34.8,4);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Voidustries',817,'24 - 150 g jars',0,'Röd Kaviar',15,8);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Moonnetworks',911,'5 kg pkg.',0,'Longlife Tofu',10,7);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('North Star ',1317,'24 - 0.5 l bottles',0,'Rhönbräu Klosterbier',7.75,1);
INSERT INTO `product`(`company`, `count`, `description`, `discount`, `name`, `price`, `category_id`) VALUES ('Voidustries',642,'500 ml',0,'Lakkalikööri',18,1);


