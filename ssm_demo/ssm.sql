CREATE DATABASE ssm;
USER ssm;
CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
	email VARCHAR(50),
	username VARCHAR(50),
	PASSWORD VARCHAR(50),
	phoneNum VARCHAR(20),
	STATUS INT
)

CREATE TABLE role(
	id INT PRIMARY KEY AUTO_INCREMENT,
	roleName VARCHAR(50),
	roleDesc VARCHAR(50)
)

CREATE TABLE users_role(
	userId INT,
	roleId INT,
	PRIMARY KEY(userId,roleId),
	FOREIGN KEY (userId) REFERENCES users(id),
	FOREIGN KEY (roleId) REFERENCES role(id)
)

CREATE TABLE permission(
	id INT PRIMARY KEY AUTO_INCREMENT,
	permissionName VARCHAR(50),
	url VARCHAR(50)
)

CREATE TABLE orders(
	id INT PRIMARY KEY AUTO_INCREMENT,
	orderNum VARCHAR(20),
	orderTime DATE,
	perple INT,
	orderDesc VARCHAR(20),
	payType INT,
	orderStatus INT,
	productId INT,
	memberId INT
)

CREATE TABLE member(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	nickname VARCHAR(20),
	phoneNum VARCHAR(20),
	email VARCHAR(20)
)

CREATE TABLE product(
	id INT PRIMARY KEY AUTO_INCREMENT,
	productNum VARCHAR(20),
	productName VARCHAR(20),
	cityName VARCHAR(20),
	departureTime DATE,
	productPrice INT,
	productDesc VARCHAR(20),
	productStatus INT
)

CREATE TABLE sysLog(
	id INT PRIMARY KEY AUTO_INCREMENT,
	visiteTime DATE,
	username VARCHAR(20),
	ip VARCHAR(20),
	url VARCHAR(20),
	executionTime INT,
	method VARCHAR(100)
)

CREATE TABLE traveller(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	sex VARCHAR(20),
	phoneNum INT,
	credentialsType INT,
	credentialsNum VARCHAR(50),
	traveller INT
)

CREATE TABLE role_permission(
	roleId INT,
	permissionId INT,
	PRIMARY KEY(roleId,permissionId),
	FOREIGN KEY (roleId) REFERENCES role(id),
	FOREIGN KEY (permissionId) REFERENCES permission(id)
)

CREATE TABLE order_traveller(
	orderId INT,
	travellerId INT,
	PRIMARY KEY(orderId,travellerId),
	FOREIGN KEY (orderId) REFERENCES orders(id),
	FOREIGN KEY (travellerId) REFERENCES traveller(id)
)