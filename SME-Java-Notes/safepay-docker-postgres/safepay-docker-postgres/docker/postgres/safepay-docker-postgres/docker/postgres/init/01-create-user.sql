-- app user, quoted because of the hyphen
CREATE ROLE "safepay-api" WITH LOGIN PASSWORD 'admin';
ALTER DATABASE safepay OWNER TO "safepay-api";

-- switch into the safepay database
\c safepay

-- allow the app to create and use its tables
GRANT ALL ON SCHEMA public TO "safepay-api";
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON TABLES TO "safepay-api";
ALTER DEFAULT PRIVILEGES IN SCHEMA public GRANT ALL ON SEQUENCES TO "safepay-api";