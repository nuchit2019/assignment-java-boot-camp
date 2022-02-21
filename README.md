# JANAWAT E-Commerce System
### Process 
```mermaid
flowchart LR
    A0((START)) --> A1
    A1["1.Search product by name"] -->|"ระบุช่องค้นหา = Adidas NMD"| B[/"กดปุ่มค้นหา"/]
    B --> B1{"มีสินค้า"}
    B1 -->|NO| B2["แสดงข้อความ ไม่มีสินค้า"]
    B1 -->|YES| B3[\"แสดงรายการสินค้า 5 รายการ"/]

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
    H1 --> H2["customer fullName"]
    H1 --> H3["shipping Address detail"] 
    H1 --> H4["SummarOrder"] 
    H1 --> H5["ListOrderDetail"] 
    H --> I0["Select Payment method"] 
    I0--> I[9. Confirm to order]
    I -->I1[[Show Shiipping detail]] 
    I1 --> I2["customer fullName"]
    I1 --> I3["shipping Address detail"] 
    I1 --> I4["SummarOrder"] 
    I1 --> I5["ListOrderDetail"] 
    I --> J["10. Summary"] 
    J --> J1[["Show PaySlip Detail"]] 
    J --> J2["Show Amount"] 
    B2 --> X{{End}} 
    J--> X{{End}} 
   
    classDef plain fill:#ddd,stroke:#fff,color:#000;
    classDef ja fill:#326ce5,stroke:#fff,color:#fff;    
    class A0,A1,B,B1,B3,C,C1,D,E,F,G,H,I0,I,J ja;
```
### Architecture
JANAWAT E-Commerce System architecture
```mermaid
    graph LR;
    client([client])-. HTTP Request<br>  .->Controller[Controller];
    Controller-->|routing rule|service[Service];
    subgraph JANAWAT-Service
    Controller;
    service-->pod1[Repository];
    service-->pod2[Gateway];
    pod1-->H2[H2.Database];
    end
    classDef plain fill:#ddd,stroke:#fff,stroke-width:4px,color:#000;
    classDef ja fill:#326ce5,stroke:#fff,stroke-width:4px,color:#fff;
    classDef JANAWAT-Service fill:#fff,stroke:#bbb,stroke-width:2px,color:#326ce5;
    class Controller,service,pod1,pod2,Repository,H2 ja;
    class client plain;
    class JANAWAT-Service JANAWAT-Service;
```
#### Entity Relationship Diagram
```mermaid
   erDiagram
   USER ||--o{ CUSTOMER : owns
   USER {        
        int id       
        string userName
        string password
        string email
   }   
   SHIPPING_ADDRESS ||--o{ CUSTOMER : places
   SHIPPING_ADDRESS {  
        int id      
        string houseNo       
        string district
        string province
        string postcode
   }
   CUSTOMER_ADDRESS_MAPPING ||--o{ CUSTOMER : places
   CUSTOMER_ADDRESS_MAPPING ||--o{ SHIPPING_ADDRESS : places
   CUSTOMER_ADDRESS_MAPPING {  
        int id      
        int customerId       
        int shippingAddressId
        string addressType
   }
   
   SHIPPING_ADDRESS ||--|{ ORDER_DETAIL : contains
   CUSTOMER ||--o{ ORDER : places
   CUSTOMER {
        int id 
        int userId
        string firstName
        string lastName
        string phone
   }
   ORDER ||--|{ ORDER_DETAIL : contains
   ORDER {
        int id
        int customerId
        int shippingAddressId
        datetime createdDate
        string typeShipping
        string paymentMethod        
   }
   ORDER_DETAIL {
        int orderId
        int productAttributeId
        int qty
        double price
        double sumprice
   }
   SHOPPINCARD ||--o{ CUSTOMER : places
   SHOPPINCARD {
        int id
        int customerId
        int shippingId
        datetimt createdDate
        datetimt updatedDate       
        
   }
   SHOPPINCARD_DETAIL ||--o{ SHOPPINCARD : places
   SHOPPINCARD_DETAIL {
        int shoppingCardId
        int productAttributeId
        int qty
        double price         
   }
   PRODUCT_CATEGORY ||--|{ PRODUCT : contains   
   PRODUCT_CATEGORY {
        int id
        string categoryName
   }
   
   PRODUCT ||--|{ ORDER_DETAIL : contains  
   PRODUCT {
        int id
        string productName
        double price
        double oldprice
             
   }
   PRODUCT_ATTRIBUTE ||--|{ PRODUCT : contains
   PRODUCT_ATTRIBUTE ||--|{ SHOPPINCARD_DETAIL : contains
   PRODUCT_ATTRIBUTE {
        int id
        int productId
        string color
        string size
        double price
        double oldprice
        int qtyInStock
        int qtyTotall
        int qtyMinimum  
   }
   
   PRODUCT_IMAGE_LIST ||--|{ PRODUCT : contains
   PRODUCT_IMAGE_LIST {
        int id
        int productId
        string imageName
        string urlImage
   }
```
**Test cases**

|   | Story | Insert | Total | Selected | Got item? | Change |
|---|-------|------------------|------------|-----------|----------|------------|
| 1 |User insert 10 baht and 5 baht coins and select Pepsi Max|10, 5|15|Pepsi Max|true|-|
| 2 |User insert 10 baht, 5 baht, 2 baht and 1 baht coins and select Pepsi Max|10, 5, 2, 1|18|Pepsi Max|true|2, 1|
| 3 |User insert 10 baht and 2 baht coins and select Pepsi Max but can't select it because user don't have enough money|10, 2|12|Pepsi Max|false|-|
| 4 |User insert 10 baht and 2 baht coins and select Coke Vanilla (S) but can't select it because this product isn't available|10, 2|12|Coke Vanilla (S)|false|-|
| 6 |User insert 10 baht (2 coins) and 2 baht (1 coin) but user would like to refund|10, 10, 2|22|-|false|10, 10, 2|

Product listing
---

| API | Endpoint | Method |
|-----|----------|--------|
|Product listing|https://www.mocky.io/v2/5c77c5b330000051009d64c9|GET|

Acceptance agreement
---

1. Fork this github project.
2. Open `issue` feature in your repository (Options > Features > Checked on
   Issues) [#Reference](https://softwareengineering.stackexchange.com/questions/179468/forking-a-repo-on-github-but-allowing-new-issues-on-the-fork)
3. Put your code in `exercise` folder.
4. Publish your project on hosting, cloud or something that we can play it :) (DigitalOcean, Firebase Hosting, Heroku)

Any question?
---
Open your issue from this link below

https://github.com/igeargeek/fullstackdev-internship-challenge/issues
