# Aula 3 - MongoDB - Prática

Este repositório contém a solução do exercício prático sobre MongoDB.

- ## POST ``/api/turns``
    - criação de um turno para um dentista
    - body request:
    ```
    {
        "patient": {
            "firstName": "Rodrigo",
            "lastName": "Igo",
            "age": 23,
            "gender": "M"
        },
        "doctor": {
            "firstName": "Roberto",
            "lastName": "Menezes",
            "speciality": "Canal"
        },
        "date": "23/07/2021",
        "status": "CONCLUIDO"
    }
    ```
    - body response (`200`):
    ```
    {
        "id": "60fb32c48afdba629dda1c87",
        "patient": {
            "firstName": "Rodrigo",
            "lastName": "Igo",
            "age": 23,
            "gender": "M"
        },
        "dentist": {
            "firstName": "Roberto",
            "lastName": "Menezes",
            "speciality": "Canal"
        },
        "date": "23/07/2021",
        "status": "CONCLUIDO"
    }
    ```
  
- ## GET ``/api/turns``
    - retorna uma lista com todos os turnos armazenados
    - body response (`200`):
    ```
    [
        {
            "id": "60fb32c48afdba629dda1c87",
            "patient": {
                "firstName": "Rodrigo",
                "lastName": "Igo",
                "age": 23,
                "gender": "M"
            },
            "dentist": {
                "firstName": "Roberto",
                "lastName": "Menezes",
                "speciality": "Canal"
            },
            "date": "23/07/2021",
            "status": "CONCLUIDO"
        }
    ]
    ```
  
- ## GET ``/api/turns/status/{status}``
    -  retorna uma lista com todos os turnos que possuem um determinado status
    - body response (`200`):
    ```
    [
        {
            "id": "60fb32c48afdba629dda1c87",
            "patient": {
                "firstName": "Rodrigo",
                "lastName": "Igo",
                "age": 23,
                "gender": "M"
            },
            "dentist": {
                "firstName": "Roberto",
                "lastName": "Menezes",
                "speciality": "Canal"
            },
            "date": "23/07/2021",
            "status": "CONCLUIDO"
        }
    ]
    ```
  
- ## GET ``/api/turns/dentist/{dentistLastName}``
    - retorna uma lista com todos os turnos de um determinado dentista
    a partir de seu sobrenome
    - body response (`200`):
    ```
    [
        {
            "id": "60fb32ae8afdba629dda1c84",
            "patient": {
                "firstName": "Wellington",
                "lastName": "Faria",
                "age": 23,
                "gender": "M"
            },
            "dentist": {
                "firstName": "Roberta",
                "lastName": "Berta",
                "speciality": "Canal"
            },
            "date": "22/07/2021",
            "status": "REMARCADO"
        }
    ]
    ```
  
- ## PUT ``/api/turns/{id}``
    - atualiza um determinado turno pelo seu id
    - body request:
    ```
     {
        "id": "60fb32ae8afdba629dda1c84",
        "patient": {
            "firstName": "Wellington",
            "lastName": "Faria",
            "age": 24,
            "gender": "M"
        },
        "dentist": {
            "firstName": "Roberta",
            "lastName": "Berta",
            "speciality": "Cirurgia"
        },
        "date": "21/07/2021",
        "status": "REMARCADO"
    }
    ```
    - Caso o id exista, a consulta será atualizada e será retornado o status
    `200`
    - Caso o id da consulta não exista, é retornado o status `404` com o 
    seguinte body:
    ```
    {
        "message": "Consulta não encontrada."
    }
    ```  
  
- ## DELETE ``/api/turns``
    - Remove uma consulta do banco, caso ela exista
    - body request:
    ```
    {
        "id": "60fb32c48afdba629dda1c87",
        "patient": {
            "firstName": "Rodrigo",
            "lastName": "Igo",
            "age": 23,
            "gender": "M"
        },
        "dentist": {
            "firstName": "Roberto",
            "lastName": "Menezes",
            "speciality": "Canal"
        },
        "date": "23/07/2021",
        "status": "CONCLUIDO"
    }
    ```
    - Caso a consulta exista, será retornado o código `200`
