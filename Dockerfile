# Sử dụng Tomcat 9 với JDK 11 (phù hợp cho Servlet/JSP)
FROM tomcat:9.0-jdk11

# Xóa ứng dụng mặc định của Tomcat (ROOT)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy toàn bộ project (index.html, jsp, WEB-INF/...) vào thư mục ROOT
COPY ./ /usr/local/tomcat/webapps/ROOT/

# Expose port 8080 (Render mặc định sẽ map sang public port)
EXPOSE 8080

# Start Tomcat khi container chạy
CMD ["catalina.sh", "run"]
