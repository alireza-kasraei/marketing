INSERT INTO clients (id, register_date, update_date, client_name, secret) VALUES (51, NULL, NULL, 'client2', '$2a$10$4ChqlVM1BlPw02/87IEDlOuZxj/4EF8XYuvB/xM5XikUG7HqoAa2.');
INSERT INTO clients (id, register_date, update_date, client_name, secret) VALUES (50, NULL, NULL, 'client1', '$2a$10$ez3F2v6tjlzf1NHfjnTth.m5Zu6YZinOyv8Yri82p0KQzSRW1KFnm');


INSERT INTO authorities (id, register_date, update_date, authority_name, description, client_id) VALUES (50, NULL, NULL, 'ROLE_ADMIN', 'Admin Authority', NULL);
INSERT INTO authorities (id, register_date, update_date, authority_name, description, client_id) VALUES (51, NULL, NULL, 'ROLE_CLIENT', 'Client Authority', NULL);

INSERT INTO authorities_clients (authority_id, client_id) VALUES (50, 50);
INSERT INTO authorities_clients (authority_id, client_id) VALUES (51, 51);

INSERT INTO client_grant_types (id, register_date, update_date, type_name, client_id) VALUES (50, NULL, NULL, 'AUTHORIZATION_CODE', 50);
INSERT INTO client_grant_types (id, register_date, update_date, type_name, client_id) VALUES (51, NULL, NULL, 'REFRESH_TOKEN', 50);
INSERT INTO client_grant_types (id, register_date, update_date, type_name, client_id) VALUES (52, NULL, NULL, 'PASSWORD', 50);
INSERT INTO client_grant_types (id, register_date, update_date, type_name, client_id) VALUES (53, NULL, NULL, 'AUTHORIZATION_CODE', 51);
INSERT INTO client_grant_types (id, register_date, update_date, type_name, client_id) VALUES (54, NULL, NULL, 'REFRESH_TOKEN', 51);


INSERT INTO scopes (id, register_date, update_date, scope_name, description) VALUES (50, NULL, NULL, 'SCOPE1', 'READ PERSON');
INSERT INTO scopes (id, register_date, update_date, scope_name, description) VALUES (51, NULL, NULL, 'SCOPE2', 'WRITE PERSON');

INSERT INTO scopes_clients (scope_id, client_id, register_date, update_date, auto_approved) VALUES (50, 50, NULL, NULL, 1);
INSERT INTO scopes_clients (scope_id, client_id, register_date, update_date, auto_approved) VALUES (51, 50, NULL, NULL, 0);
INSERT INTO scopes_clients (scope_id, client_id, register_date, update_date, auto_approved) VALUES (51, 51, NULL, NULL, 1);


INSERT INTO redirects (id, register_date, update_date, redirect_url, description, client_id) VALUES (50, NULL, NULL, 'http://redirect', NULL, 50);