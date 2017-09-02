USE webproject

DROP TABLE IF EXISTS T_Ad;
DROP TABLE IF EXISTS T_User;
DROP TABLE IF EXISTS T_Adentity;
DROP TABLE IF EXISTS T_Basket;
DROP TABLE IF EXISTS T_News;
DROP TABLE IF EXISTS T_Newsentity;


INSERT INTO T_USER (id , email, username, password, F_Role) VALUES (1, "Mina_2@mail.ru","Mina", "$2a$04$CHvIDGMJ23S7Iw0.1vINGOFyYeby7M9AqtW7Kfp8h4rpAn/PpWhZG", "ROLE_Admin");
INSERT INTO T_USER (id , email, username, password, F_Role) VALUES (2, "Mina2@mail.ru","SuperMina", "$2a$06$GinVnk4PrzVq7atvgtiUlOe4Bxf/JrEWdvO9U3LpepAZP/8WafhqG", "ROLE_Superadmin");
INSERT INTO T_NEWS (id, date, FK_USer, text, fk_NewsEntity, title) VALUES (1, 25-08-2017, 1, NULL , NULL , NULL );


CREATE TABLE t_user (`id` int(11) NOT NULL AUTO_INCREMENT, `email` varchar(255) DEFAULT NULL, `username` varchar(255)
                                           DEFAULT NULL,`password` varchar(255) DEFAULT NULL,`F_Role` varchar(15) DEFAULT NULL, PRIMARY KEY (`id`)
);

CREATE TABLE t_ad (`id` int(11) NOT NULL AUTO_INCREMENT, `bodyStyle` varchar(255) DEFAULT NULL, `F_CARDESCRIPTION` varchar(2000) DEFAULT NULL,
                   `color` varchar(255) DEFAULT NULL, `engine` varchar(255) DEFAULT NULL, `markAuto` varchar(255) DEFAULT NULL,
                   `mileAge` int(11) DEFAULT NULL, `modelAuto` varchar(255) DEFAULT NULL, `price` int(6) DEFAULT NULL,`transmission` varchar(255) DEFAULT NULL,
                   `yearOfIssue` int(11) DEFAULT NULL, `fk_User` int(11) NOT NULL, `date` varchar(255) DEFAULT NULL, PRIMARY KEY (`id`),
  CONSTRAINT  FOREIGN KEY (`fk_User`) REFERENCES `t_user` (`id`),
  CONSTRAINT  FOREIGN KEY (`fk_User`) REFERENCES `t_user` (`id`)
) ;

CREATE TABLE t_adentity (id int(11) NOT NULL AUTO_INCREMENT, F_FileName varchar(255) DEFAULT NULL, F_FilePath varchar(255) DEFAULT NULL,
                         `FK_Ad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

CREATE TABLE t_basket ( `id` int(11) NOT NULL AUTO_INCREMENT, `loggedUserId` int(11) DEFAULT NULL, `fk_Ad` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),

  CONSTRAINT  FOREIGN KEY (`fk_Ad`) REFERENCES `t_ad` (`id`)
);

CREATE TABLE t_news (`id` int(11) NOT NULL,  `date` varchar(255) DEFAULT NULL, `fk_User` int(11) DEFAULT NULL,
                     `text` varchar(20000) DEFAULT NULL, `title` varchar(255) DEFAULT NULL, `FK_NewsEntity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE t_newsentity (  `id` int(11) NOT NULL AUTO_INCREMENT, `F_FileName` varchar(255) DEFAULT NULL, `F_FilePath` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);









