########################################
***Normal Case, SearchText:***
########################################
marklin@marklinux ~/MyWorkspace $ curl http://localhost:8080/counter-api/search -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -d '{"searchText":["Duis", "Sed", "Donec", "Augue", "Pellentesque", "123"]}' -H "Content-Type: application/json" -X POST
*************Result***************
{"Duis":11,"Sed":16,"Donec":8,"Augue":7,"Pellentesque":6,"123":0}

########################################
***Normal Case, top 5:***
########################################
curl http://localhost:8080/counter-api/top/5 -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H "Accept: text/csv"
*************Result***************
VEL	17
EGET	17
SED	16
IN	15
ET	14

########################################
***Normal Case, top 20:***
########################################
curl http://localhost:8080/counter-api/top/20 -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H "Accept: text/csv"
*************Result***************
VEL	17
EGET	17
SED	16
IN	15
ET	14
UT	13
EU	13
SIT	12
AMET	12
NULLA	12
METUS	12
ID	12
AC	12
IPSUM	11
DUIS	11
NEC	11
VITAE	11
AT	11
DOLOR	10
ALIQUAM	10

########################################
***Normal Case, top 10:***
########################################
curl http://localhost:8080/counter-api/top/10 -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H "Accept: text/csv"
*************Result***************
VEL	17
EGET	17
SED	16
IN	15
ET	14
UT	13
EU	13
SIT	12
AMET	12
NULLA	12

########################################
***Invalid Key Case:***
########################################
curl http://localhost:8080/counter-api/search -H "Authorization: Basic c3B0dXM6Y2FuZGlkYXRlcw==" -d '{"searchText":["Duis", "Sed", "Donec", "Augue", "Pellentesque", "123"]}' -H "Content-Type: application/json" -X POST
*************Result***************
{"timestamp":1486290342230,"status":401,"error":"Unauthorized","message":"Bad credentials","path":"/counter-api/search"}


########################################
Commands to test and start spring boot:
########################################
//curl http://localhost:8080/counter-api/search -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -d '{"searchText":["Duis", "Sed", "Donec", "Augue", "Pellentesque", "123"]}' -H "Content-Type: application/json" -X POST
//curl http://localhost:8080/counter-api/top/20 -H "Authorization: Basic b3B0dXM6Y2FuZGlkYXRlcw==" -H "Accept: text/csv"
// cd ~/MyWorkspace/inteliment.rest/; mvn clean spring-boot:run


