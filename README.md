# Descripción:
Aplicación rest java8, configurada para ser ejecutada en los servidores de google app engine

# Instrucciones:
1. Cree un metodo "POST" en su plataforma preferida (postman, SoapUI, Jmeter, ...)
2. Ingrese el endPoint "https://mutantidentifier.rj.r.appspot.com/rest/services/mutant"
3. Configure el body como aplicación JSON e ingrese el siguiente RQ:
```html
{
  "mutantIdentifierRQ": {
    "dna": [
      "ATGCGA",
      "CATGCC",
      "TTGGGC",
      "AGTTGT",
      "TTCCTA",
      "TCATTG"
    ]
  }
}
```

# Nota:
La respuesta retornata dos posbiles estados http:
1. 200, quiere decir que la cadena ingresada es de un mutante
2. 403, puede ser por posibles casos
  + Error parseando objeto de entrada MU_1
  + La matriz ingresada no es cuadrada, en este caso en el JSON de respuesta vendrá el código de error MU_2
  + Caracteres de entrada no validos retornará MU_3
  + Los datos de entrada son validos pero la cadena de ADN no pertenece a mutante MU_4

# Comandos utiles:
+ gcloud init -> iniciar appEngine
+ gcloud components install app-engine-java -> instalar componente necesarios para app java
+ gcloud app logs tail -s default -> ver logs
+ gcloud app versions list -> ver lista de versiones
+ gcloud app versions delete v1 -> borrar version de app
+ gcloud app versions stop v1 -> detener app
+ mvn package appengine:deploy -Dapp.deploy.projectId=mutantidentifier -> desplegar app

# Consola administrativa de google cloud
https://console.cloud.google.com/appengine/versions?project=mutantidentifier
