create database session10;
use session10;

create table account(
    id int primary key auto_increment,
    username varchar(100) not null,
    password varchar(255) not null,
    email varchar(255)
);

create table Document(
    id int primary key auto_increment,
    title varchar(100) not null ,
    description varchar(255),
    file varchar(255)
);

create table FileUpload(
    id int primary key auto_increment,
    file varchar(255),
    description varchar(255)
);

create table Project(
    id int primary key auto_increment,
    name varchar(150) not null,
    description varchar(255),
    document varchar(255)
);
DELIMITER //
create procedure addAccount(
    username_in varchar(100),
    password_in varchar(255),
    email_in varchar(255)
)
begin
    insert into account(username,password,email)
        values (username_in,password_in,email_in);
end //
DELIMITER ;

DELIMITER //
create procedure uploadDocument(
    title_in varchar(100),
    description_in varchar(255),
    file_in varchar(255)
)
begin
    insert into Document(title, description, file)
        values (title_in, description_in, file_in);
end //
DELIMITER ;

DELIMITER //
create procedure uploadFile(
    file_in varchar(255),
    description_in varchar(255)
)
begin
    insert into FileUpload(file, description)
        values (file_in,description_in);
end //
DELIMITER ;

DELIMITER //
create procedure addProject(
    name_in varchar(150),
    description_in varchar(255),
    document_in varchar(255)
)
begin
    insert into Project(name, description, document)
        values (name_in, description_in, document_in);
end //
DELIMITER ;

DELIMITER //
create procedure updateProject(
    id_in int,
    name_in varchar(150),
    description_in varchar(255),
    document_in varchar(255)
)
begin
    update Project
        set name = name_in,
            description = description_in,
            document = document_in
    where id = id_in;
end //
DELIMITER ;

DELIMITER //
create procedure delProject(id_in int)
begin
    delete from Project where id = id_in;
end //
DELIMITER ;

DELIMITER //
create procedure getProject()
begin
    select *from Project;
end //
DELIMITER ;