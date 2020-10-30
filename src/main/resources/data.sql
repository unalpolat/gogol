INSERT INTO customer(status, first_name, last_name, email, phone_number, created_at, last_updated_at) VALUES
    ('ACTIVE', 'Unal', 'Polat', 'unalpolaatt@gmail.com', '5551955145', current_timestamp(), current_timestamp());

INSERT INTO "order"(customer_id, active, status, last_update_operation, last_updater_id, note, total_item_price,
delivery_price, address_id, address_details, delivery_date, created_at, last_updated_at) VALUES
    (1, true, 'IN_DELIVERY', null, null, 'Zili calmayin', 13999,
    350, 1, 'Bla bla sokak no:3', current_timestamp(), current_timestamp(), current_timestamp());

INSERT INTO order_item(order_id, product_id, price, quantity, note, created_at, last_updated_at) VALUES
    (1, 1, 13000, 1, null, current_timestamp(), current_timestamp()),
    (1, 2, 999, 1, null, current_timestamp(), current_timestamp());

INSERT INTO product(name, description, price, stock_quantity, created_at, last_updated_at) VALUES
    ('Suc ve Ceza', 'Anne eli degmis gibi', 13000, 100, current_timestamp(), current_timestamp()),
    ('Satranc', null, 999, 10, current_timestamp(), current_timestamp());
