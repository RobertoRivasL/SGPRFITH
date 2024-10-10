# Usa una imagen base de Tomcat 9 (versión corregida)
FROM tomcat:9.0.65-jdk11-openjdk

# Establecer el directorio de trabajo dentro del contenedor (opcional)
WORKDIR /usr/local/tomcat

# Copiar el archivo WAR en el directorio webapps de Tomcat


# Exponer el puerto que Tomcat usará
EXPOSE 8080

# Iniciar Tomcat cuando el contenedor se inicie
CMD ["catalina.sh", "run"]