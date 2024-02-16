--liquibase formatted sql

--changeset loite:2
    create table biscuit (
        id  varchar(40) not null,
        flavour varchar(255),
        created_by varchar(255),
        created_on timestamptz,
        modified_by varchar(255),
        modified_on timestamptz,
        deleted_by varchar(255),
        deleted_on timestamptz,
        is_deleted varchar(10),
        primary key (id)
    );
