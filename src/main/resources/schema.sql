DROP TABLE IF EXISTS PRICES;
CREATE TABLE PRICES (
    PRICE_ID long,
    BRAND_ID int,
    START_DATE datetime,
    END_DATE datetime,
    PRICE_LIST int,
    PRODUCT_ID int,
    PRIORITY int,
    PRICE decimal(5,2),
    CURR varchar(255)
);