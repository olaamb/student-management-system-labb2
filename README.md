# student-management-system
Lab assignment in school


STUDENT-MANAGEMENT-SYSTEM SCHOOL PROJECT

ENDPOINTS:

-CREATE (POST-request)- http://localhost:8080/student-management-system/api/v1/students/

Example of student you can create (JSON-format) { "firstname": "Bruno", "lastname": "Brunosson", "email": "Bruno@outlook.com", "phonenumber": "123123" }

-READ (GET-request) http://localhost:8080/student-management-system/api/v1/students/getall List of all students

-READ lastname (GET-request) http://localhost:8080/student-management-system/api/v1/students/query

Example of query -http://localhost:8080/student-management-system/api/v1/students/query?lastname=Brunosson

This gives you a list of all students with lastname "Brunosson"

-PATCH (PATCH-request) http://localhost:8080/student-management-system/api/v1/students/{id}

Example of patch - http://localhost:8080/student-management-system/api/v1/students/2?lastname=Svensson This patches the last name of student with id 2, to have lastname Svensson

-PUT (PUT-request) http://localhost:8080/student-management-system/api/v1/students/

-DELETE (DEL-request) http://localhost:8080/student-management-system/api/v1/students/{id}
