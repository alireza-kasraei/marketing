CREATE USER docker;
ALTER USER docker WITH PASSWORD 'docker';
CREATE DATABASE "authorization";
GRANT ALL PRIVILEGES ON DATABASE "authorization" TO docker;

CREATE DATABASE "sample_db";
GRANT ALL PRIVILEGES ON DATABASE "sample_db" TO docker;