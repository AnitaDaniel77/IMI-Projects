# small official Postgres image
FROM postgres:16-alpine

# database created on first start
ENV POSTGRES_DB=safepay

# scripts in this folder run once, on an empty database
COPY init/ /docker-entrypoint-initdb.d/