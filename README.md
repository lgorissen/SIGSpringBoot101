# SIG Spring Boot 101
This repo contains the labs for the AMIS SIG Spring Boot 101, April 5th 2018


## Outline:

| Lab                                                | Description                                                     |
|----------------------------------------------------|-----------------------------------------------------------------|
| 1. REST web service in Spring Boot                  | Create a REST web service in Spring Boot |
| 2. REST web service documented with Swagger        | Add Swagger documentation to a Spring Boot REST web service |
| 3. REST web service - contract first - SwaggerHub  | Use SwaggerHub to generate a SpringBoot REST web service |
| 4. REST web service in a Docker container          | Run a Spring Boot REST web service in a Docker container |
| 5. Test your SpringBoot REST web service           | Test your Spring Boot REST web service  |
| 6. REST web service and data access in JPA         | Make the REST service store its data in a PostgreSQL DB|
| 7. SOAP web service | Create a SOAP web service in SpringBoot |
| 8. REST web service in Oracle ACCS | Run a SpringBoot REST web service in the Oracle Application Container Cloud Service: ACCS |


## Requirements:

The labs will use the following tooling:

- Eclipse with Spring Tool Suite (STS)
- mvn
- Docker CE (Community Edition)
- Postman, curl
- PostgreSQL and Adminer
- SoapUI

All required tooling will be available on the provided VirtualBox image.

## Getting started

To get started with the labs, first have a look at the **Lab_start_notes** document: it explains how to set-up the VirtualBox machine.

The VirtualBox machine will have all required tooling. However, remember to run a git pull command to refresh the Labs to the latest status!

## Lab structure

In the VirtualBox machine, the labs can be found in directory

`/home/developer/projects/SIGSpringBoot101`

The structure of the labs is (example: lab 6):

    dronebuzzers
    dronebuzzers-completed
    input
    Lab_6_notes.docx
    postman
    README.md


With the contents of the directories:


| Directory             | Contents                                             | 
|---------------------- |----------------------------------------------------- |
| dronebuzzers          | The start project for the lab                        |
| dronebuzzers-completed| The completed end result of the lab                  |
| input                 | All the code parts and other files needed for the lab|
| Lab_6_notes.docx      | The lab guide                                        |
| postman               | A Postman collection for testing the lab results     |
| README.md             | A MarkDown file that describes the content of the lab|








