# CRROG

[![license](https://img.shields.io/github/license/george-chou/CRROG.svg)](https://github.com/george-chou/CRROG/blob/master/LICENSE)
[![Java CI with Maven](https://github.com/george-chou/CRROG/workflows/Java%20CI%20with%20Maven/badge.svg?branch=master)](https://github.com/george-chou/CRROG/actions)
<!--[![Github All Releases](https://img.shields.io/github/downloads/george-chou/CRROG/total.svg)](https://github.com/george-chou/CRROG/releases)

Customised realtime resume online generator

## Environment establishment

Spring Tool Suite 4 + JDK + Apache-tomcat 9.0.33 + XAMPP;

## Build

Open XAMPP to run the PHPMyAdmin with MySQL; Open STS, select a workspace and follow the operations below:

<b>Step1</b>: `File`->`Import`->`Maven`->`Existing Maven Projects`->`Select the source code`;

<b>Step2</b>: `Right click the project`->`Maven`->`Update project...`->`Force Update of Snapshots/Releases`->`OK`;

<b>Step3</b>: `Window`->`Show View`->`Other...`->`Server/Servers`;

<b>Step4</b>: `No servers are available. Click this link to create a new server...`->`Apache/Tomcat v9.0 Server`->`Next>`->`Browse...`->`The directory where you installed Apache-tomcat 9.0.33`->`JRE:`->`Add All>>`->`Finish`;

<b>Step5</b>: `Right click the project`->`Debug As`->`1 Debug on Server`.

## MySQL

To check database structures, please refer to domain codes (_User.java_ and _Company.java_); Please set the username and password of the source code corresponding with your MySQL.

## Deployment

Please put your private key at the same path of _README.md_ and update your public DNS in _.circleci/config.yml_; Connect GitHub to CircleCI and create a building label for deployment on _README.md._

## DEV MANUAL

### 1 Introduction

Customized Real-time Resume Online Generator (CRROG) is a web application for students of the University of Sydney (USYD) to simulate a job search platform. On the one hand, it allows people to create perfect resumes with their preferred styles. Customers can add, edit, or remove resume contents in real-time to assist themselves in improving work efficiency. On the other hand, enterprise users can search for suitable staff for our application.

This project has three roles, administrator, user, and enterprise user, including a registration interface and a resume production interface. On the registration interface, users can create personal accounts by school email. After logging into the account, users can add information, edit personalized functions, and generate resumes. The data can also be modified and deleted. A variety of customized themes can also be selected, which can help customers demonstrate their personality. The user can choose whether to start the resume to be viewed. In the process of use, users can give feedback on this project through the dashboard.

#### 1.1 Overview

The model view controller (MVC) is a typical design pattern in UI design. It decouples business logic from UIs by separating the roles of the model, view, and controller in an application. Our project is a spring application based on MVC design pattern. It dedicates to help customers quickly generate their resumes. The resume can comprehensively display customer information in videos, dynamic pictures, datasheets, assisting customers in creating perfect resumes.

Enterprise users can register according to enterprise information. After manual examination, they can log in to the system. In the method, enterprises can search all student resumes according to keywords, assess the interviewed students, collect resumes, and grade CVs. Enterprise users can also reverse our system on the dashboard.

Managers can log in to the admin interface. Upload new style templates, audit users, and ban users. The framework for Java programming is Spring, and the framework for system architecture bases on object-relational mapping (ORM).

#### 1.2 Aims

Our project aims to enable more students to have the opportunity to have a bright and comprehensive resume and help job seekers maximize their chances of taking up new jobs.

#### 1.3 Primary user

a) Students or graduates who are too busy to design resumes;<br>
b) Students or graduates who do not know how to create a resume, like newly graduated university students;<br>
c) Students or graduates who are tired of typing or creating their resumes;<br>
d) Students or graduates whose resumes are frequently updated;<br>
e) Companies looking to recruit students from the University of Sydney;

### 2 Significances

Customized Real-time Resume Online Generator, as its name implies, is essential in its ability to be customized, real-time, automatically generated online, and user wide. In real life, the importance of a personal resume is unquestionable. It says that own resumes are used by people almost everywhere, so it is a humanized operation for users to modify their resumes in real-time and flexible.

Besides, users who don’t know how to make a well-written resume can automatically generate a resume in our system by selecting a satisfactory template, which also helps them.

The above two aspects are the significant advantages of our product in terms of traditional products that require users to perform the deletion, typesetting, concerning each modification manually. Moreover, enterprise as another user who can register an account enjoys a regular and convenient operation when browsing resumes.

### 3 Project outline

#### 3.1 System architecture

We simplify the system architecture of our project based on the Spring MVC framework into _Figure 1_ according to Spring MVC request processing flow.

<div align=center>
    <b>Figure 1: Simplified system architecture based on Spring MVC request processing flow</b>
    <img width="605" src=".circleci/f1.PNG"/>
</div>
 
Our work focuses on blue regions, and we do not need to care about rest structures since they have already got integrated into the program by the framework. The view structure corresponds to JSP files in our project's view path, while the controller part corresponds to JAVA files in the resource path of our project. Besides, we need to design our database structure adaptive for controllers.

#### 3.2 Component division

Each database mentioned in the below forms concludes the hierarchy structure of database tables. Each database table has different access for different users and orders.

##### 3.2.1 Admin component

Admin component includes functions of login, finding the forgotten pass, banning or unbanning user or enterprise accounts, uploading new resume styles, auditing new enterprise accounts, message-board, resume viewing and others. The data streams flow as _Table 1_. Please note that there is only one administrator without sign-in function. The admin user would receive auditing request message if any enterprise user completed or edited the company information.

<div align=center>
    <b>Table 1: Admin component</b><br>
    <img width="605" src=".circleci/t1.PNG"/>
</div>

##### 3.2.2 Enterprise component

Admin component includes the following functions: 

a) login functions;<br>
b) finding the forgotten pass;<br>
c) banning/unbanning user/enterprise accounts;<br>
d) uploading new resume styles;<br>
e) auditing new enterprise accounts;<br>
f) message-board;<br>
g) resume viewing;

The data streams flow as _Table 1_. Please note that there is only one administrator without a sign-in function. The admin user would receive an auditing request message if any enterprise user completed or edited the company information.

<div align=center>
    <b>Table 2: Enterprise component</b><br>
    <img width="605" src=".circleci/t2.PNG"/>
</div>

##### 3.2.3 User component

The user component includes functions of sign-in, login, finding the forgotten pass, user information completion, resume editing, API switch, message-board, resume view, and others. The data streams flow as _Table 3_.

<div align=center>
    <b>Table 3: User component</b><br>
    <img width="605" src=".circleci/t3.PNG"/>
</div>

### 4 System data model

<div align=center>
    <b>Figure 2: The class diagram of the system data model</b>
    <img width="605" src=".circleci/f2.PNG"/>
</div>
 
#### 4.1 Register

a) Edit personal information;<br>
b) Choose a resume template and edit resume;<br>
c) Give feedback by Message-board;

#### 4.2 Enterprise

a) Edit enterprise information;<br>
b) Collect resumes;<br>
c) Search users;

#### 4.3 Administrator

a) Upload resume templates;<br>
b) View Message-board (New enterprise alert or user feedback);<br>
c) Audit enterprise information;<br>
d) Ban user or enterprise accounts.

### 5 Conclusion

Traditional resumes do not guarantee real-time performance, and designing resumes could take much time. Therefore, online real-time web resumes are launched to ensure real-time updates, and personalized styles can be selected. We are not only doing real-time resumes, but also a job search platform.

The platform has three levels of users: job seekers, enterprise users, and administrators. We will realize the functions of these three-tier users, namely: the registration of job seekers and the update of the resume information, the registration of enterprise user and browsing as well as the collection of the resume of the job seeker, and the admin review of the resume of the job seeker, updating resume-library and more operations.

We hope that our team can complete the design of the front-end interface associated with the above functions and the underlying implementation of the background function. Some new features can be added by us if time permits. Moreover, after comparison with traditional resumes, this new product is expected to be able to effectively make up for the shortcomings of traditional ones.
