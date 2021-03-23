ALTER TABLE shares ADD CONSTRAINT fk_shares_ssn foreign key(ssn) references customer(ssn);
ALTER TABLE shares ADD CONSTRAINT fk_shares_symbol foreign key(symbol) references stock(symbol);
desc shares;
SELECT * FROM customer;
DELETE FROM customer WHERE ssn='777-777'; -- 에러 남...FK ON DELETE CASCADE 필요함
ALTER TABLE shares DROP CONSTRAINT fk_shares_ssn;
ALTER TABLE shares DROP CONSTRAINT fk_shares_symbol;
ALTER TABLE shares ADD CONSTRAINT fk_shares_ssn foreign key(ssn) references customer(ssn) ON DELETE CASCADE;
ALTER TABLE shares ADD CONSTRAINT fk_shares_symbol foreign key(symbol) references stock(symbol) ON DELETE CASCADE;
SELECT * FROM customer;
DELETE FROM customer WHERE ssn='777-777'; -- 이제 제대로 됨
SELECT * FROM customer;
