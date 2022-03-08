JANAWAT E-Commerce System
---
Process
---
```mermaid
graph TD
    A0((START)) --> A1
    A1["1.Search product by name"] -->|"Enter= Adidas NMD"| B[/"Submite Find button"/]
    B --> B1{"Is Product in stock"}    
    B1 -->|YES| B3[\"Display Product 5 Items"/]
    B1 -->|NO| B2["Find not found"]
    db[[H2.Database]] -->B3
    B3-->B11[[Product Detail]]
    B11 --> |Product Name|B51((.))
    B11 --> |Product Price|B52((.))
    B11 --> |Product Old Price|B53((.))
    B11 --> |"Product % discount"|B54((.))
    B3 -->C[/2. Choose a product item/]    
    C --> C1[/"3. Show product detail"/]
    C1-->C11[[Product Detail]]
    C11 --> |Product Image list|C2(("."))
    C11 --> |Product Attribute|C3((.))
    C11 --> |Product Attribute|C4((.))
    C11 --> |"Show OldPrice"|C5((.))
    C1 --> |Select Product Item|D[/"4. Add Product to basket"/]
    D --> E[\"5. Show data in basket"/]
    E-->E11[[Product Detail]]
    E11 --> |Product Image list|E2(("."))
    E11 --> |Product Attribute|E3((.))
    E11 --> |Product Attribute|E4((.))
    E11 --> |"Show OldPrice"|E5((.))
    E --> F[/"6. Check out"/] 
    F--> F11[[Product Detail]]
    F11 --> |Product Image list|F2(("."))
    F11 --> |Product Attribute|F3((.))
    F11 --> |Product Attribute|F4((.))
    F11 --> |"Show OldPrice"|F5((.))    
    F -->|Submite Check out button| G[/"7. Shipping"/] 
    G --> G1[["Show Shiipping Address"]]
    G1 --> |email|G2(("."))
    G1 --> |fullName|G3((.))
    G1 --> |address|G5((.))
    G1 --> |poscode|G6((.))
    G1 --> |province|G7((.))
    G1 --> |phone|G8((.))
    G --> H[/"8. Payment"/] 
    H -->H1[[Show Shiipping detail]] 
    H1 --> |customer fullName|H2(("."))
    H1 --> |shipping Address detail|H3((".")) 
    H1 --> |SummarOrder|H4((".")) 
    H1 --> |ListOrderDetail|H5((".")) 
    H --> I0["Select Payment method=PayPal/Amex"] 
    I0--> I[/9. Confirm to order/]
    I -->I1[[Show Shiipping detail]] 
    I1 --> |customer fullName|I2(("."))
    I1 --> |shipping Address detail|I3((".")) 
    I1 --> |SummarOrder|I4((".")) 
    I1 --> |ListOrderDetail|I5(("."))   
    JJ1 -->|YES| J[\"Display Product 5 Items"/]
    JJ1 -->|NO| X   
    I --> JJ1{"Is Confirm to order"}    
    J --> J1[["Show PaySlip Detail"]] 
    J --> J2[["Show Amount"]] 
    B2 --> X{{End}} 
    J--> X{{End}}    
    classDef plain fill:#ddd,stroke:#fff,color:#000;
    classDef ja fill:#326ce5,stroke:#fff,color:#fff;    
    class A0,A1,B,B1,B3,C,C1,D,E,F,G,H,I0,I,J,JJ1 ja;
```

Architecture
---
JANAWAT E-Commerce System architecture
---
```mermaid
  graph LR;
    client([client])-. HTTP Request<br>  .->Controller[Controller];
    Controller-->|routing rule|service[Service];
    subgraph JANAWAT-E-Commerce
    Controller;
    service-->pod1[Repository];
    service-->pod2[Payment Gateway];
    pod1-->H2[H2.Database];
    end
    classDef plain fill:#ddd,stroke:#fff,stroke-width:4px,color:#000;
    classDef ja fill:#326ce5,stroke:#fff,stroke-width:4px,color:#fff;
    classDef JANAWAT-E-Commerce fill:#fff,stroke:#bbb,stroke-width:2px,color:#326ce5;
    class Controller,service,pod1,pod2,Repository,H2 ja;
    class client plain;
    class JANAWAT-E-Commerce JANAWAT-E-Commerce;
``` 
---
**API Endpoint**
---
| user-controller | Endpoint                                             | Method |
|-----------------|------------------------------------------------------|--------|
| /login          | http://localhost:8080/login | POST   |
---
| product-controller          | Endpoint                                             | Method |
|-----------------------------|------------------------------------------------------|--------|
| /GetProductByName/{productName}            | http://localhost:8080/GetProductByName/{productName} | GET    |
| /GetProductByName/{productName}/{page}              | http://localhost:8080/GetProductByName/{productName}/{page}  | GET    |
| /GetProductById/{productId}               | http://localhost:8080/GetProductById/{productId}  | GET    |
| /GetProductAll/{page}   | http://localhost:8080/GetProductAll/{page}     | GET   |
--- 
| cart-controller | Endpoint                                           | Method |
|---------------|----------------------------------------------------|--------|
| /cart/items    | http://localhost:8080/cart/items  | POST    |
| /cart/paymentMethod   | http://localhost:8080/cart/paymentMethod | PUT    |
| /cart/address   | http://localhost:8080/cart/address | PUT    |
| /cart    | http://localhost:8080/cart  | GET    |
---
**Test Script**
---
1. Start...
2. Login to System 
   - 1.1. Call api post *{host}/login*
   - .... *Body= {"username": username, "password":password}*
   - 
   - .... http://localhost:8080/login
   - .... _Body_ = {"username": "nuchit", "password": "1234"}
   - 1.2 Return tokens
     ![alt text](https://github.com/nuchit2019/assignment-java-boot-camp/blob/main/images/01.jpg?raw=true)
3. Search product by name
   - 3.1 Find Product name=ADIDAS 
     - Call api get *{host}/GetProductByName/{productName}*  
       ![alt text](https://github.com/nuchit2019/assignment-java-boot-camp/blob/main/images/2.jpg?raw=true)
     - ....http://localhost:8080/GetProductByName/ADIDAS
     - Default display page 1, size = 5 item
   - 3.2 You can chang page view ...page default to page ??
   - ...Call api get *{host}/GetProductByName/{productName}/{page}*
   - ...to page 2
   - ... http://localhost:8080/GetProductByName/ADIDAS/2
     ![alt text](https://github.com/nuchit2019/assignment-java-boot-camp/blob/main/images/page2.jpg?raw=true)
   - 
   - ...to page 3
   - ... http://localhost:8080/GetProductByName/ADIDAS/3
     ![alt text](https://github.com/nuchit2019/assignment-java-boot-camp/blob/main/images/page3.jpg?raw=true)
   -    
4. Choose a product
   - 4.1 Select Product by item 2
   - 4.2 Next step
     ![alt text](https://github.com/nuchit2019/assignment-java-boot-camp/blob/main/images/3.jpg?raw=true)
5. Show product detail
   - 5.1 View detail product item 2
   - 5.2 Call api get *{host}/GetProductById/{productId}*  
   - ....http://localhost:8080/GetProductById/2
     ![alt text](https://github.com/nuchit2019/assignment-java-boot-camp/blob/main/images/22.jpg?raw=true)
   - 
6. Add product to basket
   - 6.1 Add product to Card ... order quantity = 2
   - 6.2 call api post *{host}/cart/items* 
   - ....*Bearer Token="{token}"*
   - ....*Body= {"productId":productId, "quantity":quantity}*
     ![alt text](https://github.com/nuchit2019/assignment-java-boot-camp/blob/main/images/5.jpg?raw=true)
   - ....http://localhost:8080/cart/items
   - ....Bearer Token="sample_token nuchit"
   - ....Body= {"productId": 2, "quantity": 2}
   - 6.3 Reduce the InStock of products, *InStock = (InStock-quantity)*
   - ....productsId=2,
     - .... ....InStock before = 15
     - .... ....InStock after  = 13
   - ....productsId=2,InStock=(15-2) = 13
     ![alt text](https://github.com/nuchit2019/assignment-java-boot-camp/blob/main/images/7.jpg?raw=true)
   - 
7. Show data in basket
   - 7.1 Check product in Shopping card
   - 7.2 Call api get = *{host}/cart*
   - ....*Bearer Token={token}*
   - 
   - ....http://localhost:8080/cart
   - ....Bearer Token="sample_token nuchit"
     ![alt text](https://github.com/nuchit2019/assignment-java-boot-camp/blob/main/images/6.jpg?raw=true)
   - 
8. Checkout
   - ...Next step
   - 
9. Shipping
   - 9.1 Display Shipping address
   - 9.2 Update address
   - ....Call api put = *{host}/cart/address*
   - ....*Bearer Token={token}*
   - ....*Body={"addressId": addressId}*
   - 
   - ....http://localhost:8080/cart/address
   - ....Bearer Token="sample_token nuchit"
   - ....Body={"addressId": 1}
   - 
   - 9.3 view shopping card detail
   - ....Call api put = *{host}/cart*
   - ....*Bearer Token={token}*
   - 
   - ....Call api *{GET}* = http://localhost:8080/cart
   - ....Bearer Token="sample_token nuchit"
     ![alt text](https://github.com/nuchit2019/assignment-java-boot-camp/blob/main/images/8.jpg?raw=true)
   - 
10. Payment
    - Select Payment method=creditCard
    - 
11. Confirm to order
    - 11.1 Update payment method
    - call api put *{host}//cart/paymentMethod*
    - ....*Bearer Token={token}*
    - ....*Body={"paymentMethodId": paymentMethodId}*
    - 
    - ....http://localhost:8080/cart/paymentMethod
    - ....Body={"paymentMethodId": 1}
    - ....Bearer Token="sample_token nuchit"
      ![alt text](https://github.com/nuchit2019/assignment-java-boot-camp/blob/main/images/9.jpg?raw=true)
12. Summary 
    - 12.1 Summary Order detail
    - 12.2 Call api get *{host}/cart*
    - .......*Bearer Token={token}*
    - 
    - ....http://localhost:8080/cart
    - ....Bearer Token="sample_token nuchit"
      ![alt text](https://github.com/nuchit2019/assignment-java-boot-camp/blob/main/images/10.jpg?raw=true)
13. The end...
    
Any question?
---
Open your issue from this link below
https://github.com/nuchit2019/assignment-java-boot-camp/issues
