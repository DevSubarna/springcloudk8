### Project Description
    
    This project has four microservices which are account, orders, payment and product. 

### Account Endpoint: 

    http://192.168.1.104/accounts/register with user information [POST]
    http://192.168.1.104/accounts/login with username and password and get a jwt token [POST]

### Product Endpoint:

    http://192.168.1.101/products with jwt authorization token [GET]
    
### Order Endpoint:

    http://192.168.1.100/orders with jwt token and list of products [POST]
    http://192.168.1.100/orders with jwt token [GET] 

### Payment Endpoint: 

    http://192.168.1.102/orders/id/pay with jwt [POST]

Use kubernetes for service discovery, secret and configmap.


    
