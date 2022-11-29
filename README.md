## JPA (@DynamicInsert and @DynamicUpdate)
- Use both annotation on Entity Level

### For @DynamicInsert
- It will only insert that column which has value , see Hibernate log

`  curl --location --request POST 'localhost:8080/products' \
  --header 'Content-Type: application/json' \
  --data-raw '{
  "name": "Dell",
  "price": 100,
  "description": null,
  "productType": "LAPTOP"
  }'`

    Hibernate:
    insert into product (name, price, product_type, id) values (?, ?, ?, null);


### For @DynamicUpdate
- It will only update modified column. We are now inserting the 'description' column. Rest of the field values are same. See hibernate query

`    curl --location --request PUT 'localhost:8080/products/1' \
    --header 'Content-Type: application/json' \
    --data-raw '{
    "name": "Dell",
    "price": 100.0,
    "description": "Dell 8 gb 512 ssd",
    "productType": "LAPTOP"
    }'`

    Hibernate:
    update product set description=? where id=?