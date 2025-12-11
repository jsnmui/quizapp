# Use official Tomcat with JDK 17
FROM tomcat:10.1-jdk17

# Remove default ROOT app
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy the WAR built by Maven to Tomcat/webapps
COPY target/quizapp-0.0.1-SNAPSHOT.war  /usr/local/tomcat/webapps/ROOT.war

# Expose port
EXPOSE 8080

# Run Tomcat
CMD ["catalina.sh", "run"]
