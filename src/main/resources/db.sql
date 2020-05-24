return criteria.createCriteria(A.class)
               .createCriteria("b", "join_between_a_b")
               .createCriteria("c", "join_between_b_c")
               .createCriteria("d", "join_between_c_d")
               .add(Restrictions.eq("some_field_of_D", someValue));




CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
CREATE TABLE `emp122` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `customer` (
  `custid` int(10) NOT NULL,
  `custname` varchar(10),
  `forevenid` int(10) NOT NULL,
  PRIMARY KEY (`custid`)
)

CREATE TABLE `vendor` (
  `vendorId` int(10) NOT NULL,
  `vendorName` varchar(10),
  PRIMARY KEY (`vendorId`)
)


alter table customer
add constraint id_check
foreign key(forevenid)
references vendor(vendorId)
on delete cascade
on update cascade;


CREATE TABLE departments
(
   RECORD_ID  INT   NOT NULL AUTO_INCREMENT,
   NAME       VARCHAR(255),
   PRIMARY KEY (RECORD_ID)
)
ENGINE=InnoDB;
CREATE TABLE employees
(
   RECORD_ID  INT            NOT NULL AUTO_INCREMENT,
   AGE        INT,
   NAME       VARCHAR(255),
   DEPT_ID    INT,
   PRIMARY KEY (RECORD_ID)
)
ENGINE=InnoDB;

ALTER TABLE employees
  ADD CONSTRAINT FK_j1ryo80krj2mrd97datx3hdry FOREIGN KEY (DEPT_ID)
  REFERENCES departments (RECORD_ID)


  CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`category_id`)
);


CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(70) NOT NULL,
  `description` varchar(250) NOT NULL,
  `keywords` varchar(150) NOT NULL,
  `content` text NOT NULL,
  PRIMARY KEY (`article_id`)
);

CREATE TABLE `category_article` (
  `category_id` int(11) NOT NULL,
  `article_id` int(11) NOT NULL,
  PRIMARY KEY (`category_id`,`article_id`),
  UNIQUE KEY `article_id_UNIQUE` (`article_id`),
  KEY `fk_category` (`category_id`),
  KEY `fk_article` (`article_id`),
  CONSTRAINT `fk_article` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`)
);

CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `department` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `account` (
  `acct_id` int(11) NOT NULL AUTO_INCREMENT,
  `acct_no` varchar(45) NOT NULL,
  `emp_id` int(11) NOT NULL,
  PRIMARY KEY (`acct_id`),
  UNIQUE KEY `acct_no_UNIQUE` (`acct_no`),
  KEY `id_idx` (`emp_id`),
  CONSTRAINT `emp_fk` FOREIGN KEY (`emp_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


  CREATE TABLE `Person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `address_id` int(32) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
);
  CREATE TABLE `addressList` (
  `person_Id` int(11),
   `idx` int(11),
  `address` varchar(32)
);