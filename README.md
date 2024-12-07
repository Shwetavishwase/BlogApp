# BlogApp

spring.application.name=BlogApp


server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/Blog_App
spring.datasource.username=root
spring.datasource.password=Shwet@15
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.servlet.multipart.max-file-size=10MB
spring.servlet.multipart.max-request-size=10 MB

project.image=images/


logging.level.org.springframework.security=DEBUG

spring.security.user.name=shweta

spring.security.user.password=Shweta15

spring.security.user.roles=ADMIN