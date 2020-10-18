# springboot-websocket-chatroom

## Update dependencies and build
mvn clean install

## Run
mvn spring-boot:run

## Test API with curl

### Sign-up

```
curl -H "Content-Type: application/json" -X POST -d '{
    "username": "admin",
    "password": "password"
}' http://localhost:8080/api/v1/users/sign-up
```

### Login
```
curl -i -H "Content-Type: application/json" -X POST -d '{
    "username": "admin",
    "password": "password"
}' http://localhost:8080/login
```
Copy the "Authorization: Bearer <token>" header from the response and include in all the following requests. 

### List Users
Replace the token from the '<token>' by the one received in the login response:
```
curl -H "Authorization: Bearer <token>" http://localhost:8080/api/v1/users
```
    
### Retrieve a specific user   
Replace the token from the '<token>' by the one received in the login response and '<id>' by the user's id:
```
curl -H "Authorization: Bearer <token>" http://localhost:8080/api/v1/users/<id>
```
