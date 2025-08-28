# Dùng Tomcat 9 với JDK 21
FROM tomcat:9.0-jdk21

# Xóa các app mặc định trong Tomcat (ROOT, docs, examples)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy app của bạn vào thư mục webapps
COPY ./ /usr/local/tomcat/webapps/my_web_survey_thinhnp/

# Mở port 8080
EXPOSE 8080

# Chạy Tomcat
CMD ["catalina.sh", "run"]
