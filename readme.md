# Especialización en Desarrollo de software - Construcción de Software

Este repositorio contiene marial didactico, desarrollado en el transcurso de la asignatura.

### Variables de entorno necesarias para ejecutar el proyecto

- `SMS_URL`
- `MAIL_FORM_NAME`
- `MAIL_HOST`
- `MAIL_PORT`
- `MAIL_USERNAME`
- `MAIL_PASSWORD`
- `POSTGRES_PASSWORD`
- `POSTGRES_DB`
- `POSTGRES_PORT`
- `POSTGRES_USER`
- `PG_PSW`
- `PG_EMAIL`
- `SERVER_URL`
- `SERVER_USER`
- `SERVER_PASSWORD`
- `SERVER_DB_PROD`
- `URL_BASE_PROD`
- `URL_BASE`
- `VOL_MOUNT_VACANTES`
- `VOL_MOUNT_IMAGENES`
- `VOL_MOUNT_DOCUMENTOS`

### Ejecutar el docker build esto para que el docker tenga en cuenta que debe tomar la caché de las dependencias, \
 en caso de que estas no hayan cambiado 

- `DOCKER_BUILDKIT=1 docker build -t <nameImage> .`