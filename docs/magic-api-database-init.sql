CREATE TABLE magic_api_file
(
    file_path    varchar(512) NOT NULL,
    file_content clob,
    PRIMARY KEY (file_path)
);

CREATE TABLE magic_api_backup
(
    id          varchar(32) NOT NULL,
    create_date number(19) NOT NULL,
    tag         varchar(32) DEFAULT NULL,
    type        varchar(32) DEFAULT NULL,
    name        varchar(64) DEFAULT NULL,
    content     blob,
    create_by   varchar(64) DEFAULT NULL,
    PRIMARY KEY (id, create_date)
);

COMMENT
ON COLUMN magic_api_backup.id is '原对象ID';
COMMENT
ON COLUMN magic_api_backup.create_date is '备份时间';
COMMENT
ON COLUMN magic_api_backup.tag is '标签';
COMMENT
ON COLUMN magic_api_backup.type is '类型';
COMMENT
ON COLUMN magic_api_backup.name is '原名称';
COMMENT
ON COLUMN magic_api_backup.content is '备份内容';
COMMENT
ON COLUMN magic_api_backup.create_by is '操作人';
