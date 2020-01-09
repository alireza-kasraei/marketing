INSERT INTO roles (id, register_date, update_date, role_name, description) VALUES (50, NULL, NULL, 'ADMIN', 'blah blah');
INSERT INTO roles (id, register_date, update_date, role_name, description) VALUES (51, NULL, NULL, 'USER', 'blah blah');

INSERT INTO groups (id, register_date, update_date, group_name, description) VALUES (50, NULL, NULL, 'group1', 'blah blah');
INSERT INTO groups (id, register_date, update_date, group_name, description) VALUES (51, NULL, NULL, 'group2', 'blah blah');


INSERT INTO roles_groups (group_id, role_id) VALUES (50, 50);
INSERT INTO roles_groups (group_id, role_id) VALUES (50, 51);
INSERT INTO roles_groups (group_id, role_id) VALUES (51, 51);

INSERT INTO users (id, register_date, update_date, user_name, pass_word, email, mobile_number, first_name, last_name, exp_date, cre_exp_date, enabled, locked) VALUES (50, NULL, NULL, 'koorosh01', '$2a$10$668UtBc3OSmlYShPYmmVzuROGj.TIC3Lnx4f8DbVWfeWl/i.xlI1y', 'kasraei.ar@gmail.com', '00989123853840', 'alireza', 'kasraei', '2021-01-01 00:00:00', '2021-01-01 00:00:00', 1, 0);
INSERT INTO users (id, register_date, update_date, user_name, pass_word, email, mobile_number, first_name, last_name, exp_date, cre_exp_date, enabled, locked) VALUES (51, NULL, NULL, 'sample', '$2a$10$668UtBc3OSmlYShPYmmVzuROGj.TIC3Lnx4f8DbVWfeWl/i.xlI1y', 'sample@gmail.com', '0046548498431', 'sample', 'sample', '2021-01-01 00:00:00', '2021-01-01 00:00:00', 1, 0);

INSERT INTO users_groups (user_id, group_id) VALUES (50, 50);
INSERT INTO users_groups (user_id, group_id) VALUES (51, 51);