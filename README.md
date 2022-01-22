# ShopifyChallenge
Shopify Production Engineering Intern Challenge - Summer 2022
Challenge link: https://docs.google.com/document/d/1wir0XQuviR6p-uNEUPzsGvMFwqgMsY8sEjGUx74lNrg/edit

This project creates a simple inventory tracking web app with basic CRUD functionality using Spring boot. 
The additional feature chosen for this challenge is: Push a button export product to a CSV.

For the simplicity of the project, all CRUD functions are displayed within the index/main page.
H2, JDBC and JPA are used for the database for this project, the edit and delete functions are executed by retrieving IDs for the chosen items.

Possible future improvements should include:
+ Add more parameters into the Item class since an inventory system includes other things such as price, description, category, etc.
+ Navigation to different pages for each functions
+ Security 
+ Filter option for different types of item
+ Add UI

Install the followings to run the project. 
+ JAVA JDK: 
To avoid incompatibility with Spring Boot, JDK 11 is used for this project. 
Navigate to https://adoptium.net/?variant=openjdk11 , and  download and run the OpenJDK 11 (LTS) Installer. Choose default installation options. Then reboot
+ Eclipse: 
Download Eclipse IDE through: https://eclipse.org/downloads/, choose the latest Eclipse Installer. After executing the installer package, choose Eclipse IDE for Enterprise Java Developers.
+ Spring tools: 
From eclipse, navigate to Help -> Eclipse Marketplace to install Spring Tools 4. 
+ NPM: 
Navigate to https://nodejs.org/en/download/ and download the Node.JS installer for your system.

To run the project:
1.	Open Eclipse IDE and navigate to the project
2.	Run as Spring Boot app
3.	Open browser -> localhost:8080

