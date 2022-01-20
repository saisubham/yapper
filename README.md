# yapper
A comment system which supports unlimited nested replies

## To build
```
git clone https://github.com/saisubham/yapper.git
cd yapper
./mvnw package
```

Before running the server, start a MySQL service and create a database. Modify MySQL username, password and URL in `src/main/resources/application.yml`.
The property `url: jdbc:mysql://localhost:3306/commentdb` should be changed to `url: jdbc:mysql://localhost:3306/<your_db_name>`,

## Running the server
```
java -jar --server.port=8081 ./target/comment-system-0.0.1-SNAPSHOT.jar
```

## Todo
- [ ] Authentication
- [ ] Implement likes
- [ ] Implement fetch limit to replies
- [ ] Implement tagging users by username
- [ ] Notify by email a user is tagged / gets replied (maybe using AWS Lambda)
- [ ] Implement this as a microservice
- [ ] Provide analytics
