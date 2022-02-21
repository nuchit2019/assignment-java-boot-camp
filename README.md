# JANAWAT E-Commerce System
### Process 
```mermaid
 graph TD
A0[Start] --> A2[1. SearchProductByname]
A2 --> A3[Enter = Adidas NMD]
A3 --> A4[Click Find Button]
A4 --> B0[Display Product 5 Item]
B0 --> B1[ProductName] 
B0 --> B2[ProductPrice]
B0 --> B3[ProductOldPrice]
B0 --> B4[Product%Discount]
B0 --> |Select Product Item|C0[2. Choose a product item]
C0 --> C1["3. Show product detail"]
C1 --> C2["Show List Product Image"]
C1 --> C3["Show Product Attribute"]
C1 --> C4["Show Price"]
C1 --> C5["Show OldPrice"]
C1 -->|Select Product Item|D0["4. Add Product to basket"]
D0 --> D1["4.1 Click add to cart button"]
D1 --> D2["Show List Product Image"]
D1 --> D3["Show Product Attribute"]
D1 --> D4["Show Price"]
D1 --> D5["Show OldPrice"]
D1 --> E0["5. Show data in basket"]
E0 --> E1["Show num product in basket"]
E1 --> E2["Show List product detail in basket"]
E1 --> E3["Show product sum price"] 
E0 --> F0["6. Check out"] 
F0 --> F1["Show num product in basket"]
F1 --> F2["Show List product detail in basket"]
F1 --> F3["Show product sum price"]
F1 --> G0["7. Shipping"] 
G0 --> G1["Show Shiipping Address"]
G1 --> G2["Show Order Detail"] 
G0 --> H0["8. Payment"] 
H0 --> H1["Payment Method = PayPal/Amex"] 
H1 --> H2["Show Shiipping Address"]
H1 --> H3["Show Order Detail"] 
H0 --> I0["9. Confirm to order"] 
I0 --> J0["10. Summary"] 
J0 --> J1["Show PaySlip Detail"] 
J0 --> J2["Show Amount"] 
J0 --> J3["END"]
classDef plain fill:#ddd,stroke:#fff,color:#000;
    classDef ja fill:#326ce5,stroke:#fff,color:#fff;    
    class A1,A0,A2,A3,A4,B0,C0,C1,D0,D1,E0,F1,F0,G0,H0,I0,J0 ja;
    
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
