DROP DATABASE koala;

CREATE DATABASE koala
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Russian_Russia.1251'
       LC_CTYPE = 'Russian_Russia.1251'
       CONNECTION LIMIT = -1;

DROP SEQUENCE inc_category_seq;
DROP SEQUENCE inc_income_seq;
DROP SEQUENCE exp_tag_seq;
DROP SEQUENCE exp_expense_seq;
DROP SEQUENCE exp_expense_tags_seq;
DROP TABLE exp_expense_tags;
DROP TABLE exp_expense;
DROP TABLE inc_income;
DROP TABLE exp_tag;
DROP TABLE inc_category;

CREATE TABLE inc_category
(
	ic_id bigint NOT NULL,
	title varchar(100) NOT NULL,
	CONSTRAINT pk_inc_category PRIMARY KEY(ic_id)
)
WITHOUT OIDS;

CREATE TABLE inc_income
(
	inc_id bigint NOT NULL,
	ic_id bigint NOT NULL,
	occured timestamptz NOT NULL,
	amount bigint NOT NULL,
	description varchar(200),
	CONSTRAINT positive_inc_income_amount CHECK (amount > 0),
	CONSTRAINT pk_inc_income PRIMARY KEY(inc_id),
	CONSTRAINT fk_inc_income_category FOREIGN KEY(ic_id)
		REFERENCES inc_category(ic_id) ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITHOUT OIDS;

CREATE TABLE exp_expense
(
	exp_id bigint NOT NULL,
	occured timestamptz NOT NULL,
	amount bigint NOT NULL,
	description varchar(200),
	CONSTRAINT positive_exp_expense_amount CHECK (amount > 0),
	CONSTRAINT pk_exp_expense PRIMARY KEY(exp_id)
)
WITHOUT OIDS;

CREATE TABLE exp_tag
(
	et_id bigint NOT NULL,
	title varchar(100) NOT NULL,
	CONSTRAINT pk_exp_tag PRIMARY KEY(et_id)
)
WITHOUT OIDS;

CREATE TABLE exp_expense_tags
(
	eet_id bigint NOT NULL,
	exp_id bigint NOT NULL,
	et_id bigint NOT NULL,
	CONSTRAINT pk_exp_expense_tags PRIMARY KEY(eet_id),
	CONSTRAINT fk_exp_expense_tags_expense FOREIGN KEY(exp_id)
		REFERENCES exp_expense(exp_id) ON UPDATE RESTRICT ON DELETE RESTRICT,
	CONSTRAINT fk_exp_expense_tags_tag FOREIGN KEY(et_id)
		REFERENCES exp_tag(et_id) ON UPDATE RESTRICT ON DELETE RESTRICT
)
WITHOUT OIDS;

CREATE SEQUENCE exp_tag_seq
	INCREMENT 1
	MINVALUE 1
	START 1;

CREATE SEQUENCE exp_expense_seq
	INCREMENT 1
	MINVALUE 1
	START 1;

CREATE SEQUENCE exp_expense_tags_seq
	INCREMENT 1
	MINVALUE 1
	START 1;

CREATE SEQUENCE inc_category_seq
	INCREMENT 1
	MINVALUE 1
	START 1;

CREATE SEQUENCE inc_income_seq
	INCREMENT 1
	MINVALUE 1
	START 1;