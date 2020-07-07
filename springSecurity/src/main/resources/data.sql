INSERT INTO users (username, password, enabled)
    values ('user',
    'pass',
    true);

INSERT INTO users (username, password, enabled)
    values ('admin',
    'pass',
    true);

INSERT INTO users (username, password, enabled)
    values ('hani',
    '123456',
    true);

INSERT INTO authorities (username, authority)
    values ('user', 'ROLE_USER');

INSERT INTO authorities (username, authority)
    values ('admin', 'ROLE_ADMIN');

INSERT INTO authorities (username, authority)
    values ('hani', 'ROLE_USER');