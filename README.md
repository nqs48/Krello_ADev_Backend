  # Krello Management Tasks: Backend
Demo project where developments a website is carried out, based on the popular activity management tool **trello**. Activities such as creating, deleting and updating boards, task management based on the canva model are emulated.

---

<!-- ABOUT THE PROJECT -->
## About The Project

Responsive design of a dynamic web page, where you can manage activities and tasks associated with a board.

- Key frontend and backend concepts
- Rest API with SpringBoot
- API consumption from the frontend using Fetch
- Landing page with JavaScript Vanilla


<p align="center">
<img src="https://img.shields.io/badge/Click to webpage-219ebc?style=for-the-badge" width="20%"/>
</p>

---

# PROJECT REVIEW:

### UI Index Web Page

Responsive design of a dynamic web page with the available boards.

<p align="center">
<img src="https://res.cloudinary.com/adev48/image/upload/v1659336926/Sofka%20Assets/Training%20Leagues/API%20SpringBoot-JavaScript/GetBoards_y7rgjz.png" width="70%"> 

</p>

---

### Create board

Board and task creation with a name field, and event control.

<p align="center">
<img src="https://res.cloudinary.com/adev48/image/upload/v1667322645/Sofka%20Assets/Training%20Leagues/API%20SpringBoot-JavaScript/board_form_h4c0sq.jpg" width="70%"> 

</p>

---

### Update Task

See the details of the task and updade it.

<p align="center">
<img src="https://res.cloudinary.com/adev48/image/upload/v1659336926/Sofka%20Assets/Training%20Leagues/API%20SpringBoot-JavaScript/UpdateTask_oin6r5.png" width="70%"> 

</p>

---


### Delivery date

Status to validate the new date to delivery task.

<p align="center">
<img src="https://res.cloudinary.com/adev48/image/upload/v1659336926/Sofka%20Assets/Training%20Leagues/API%20SpringBoot-JavaScript/UpdateTaskCalendar_bwxilc.png" width="70%"> 

</p>

### State Task

You can update the state of the task, choosing the new column name.

<p align="center">
<img src="https://res.cloudinary.com/adev48/image/upload/v1659336926/Sofka%20Assets/Training%20Leagues/API%20SpringBoot-JavaScript/UpdateTaskColumn_chl7is.png" width="70%"> 

</p>

---

### Delete Board

Deleting a board that has activities or not.

<p align="center">
<img src="https://res.cloudinary.com/adev48/image/upload/v1659336926/Sofka%20Assets/Training%20Leagues/API%20SpringBoot-JavaScript/RenderBoard_qx6mod.png" width="70%"> 

</p>

---

## Built With

This section contains the platforms that were used for the project.


### Frontend
* [JavaScript](https://developer.mozilla.org/es/docs/Web/JavaScript)
* [Local Storage](https://developer.mozilla.org/es/docs/Web/API/Window/localStorage)
* [Tailwind CSS](https://tailwindui.com/)
* [JS OOP](https://www.freecodecamp.org/espanol/news/programacion-orientada-a-objectos-en-javascript-explicado-con-ejemplos/)

### Backend
* [IntelliJ Idea](https://www.jetbrains.com/es-es/idea/)
* [Java JDK 17 Version ](https://www.oracle.com/java/technologies/downloads/)
* [Java Springboot](https://start.spring.io/)
* [MySQLWorkbench](https://www.mysql.com/products/workbench/)
* [JPA Java Persistance Application](https://start.spring.io/)

---

### Installation for **Backend Project**

Install each one the pieces of software previously mentioned (Git).


1. Clone the repo

      - HTTPS
         ```
         $ git clone https://github.com/nqs48/Krello_ADev_Backend.git
         ```


      - SSH
         ```
         $ git clone git@github.com:nqs48/Krello_ADev_Backend.git
         ```
   
2. Open the project with IntelliJIdea IDE (In the backend directory)

   ```
   $ idea .
   ```
   
3.  Run script [`my-krello.sql`](https://github.com/nqs48/Krello_ADev_Frontend/blob/main/assets/db/my-krello.sql) in a management database (Workbench).
     ```
     $ run my-krello.sql
     ```
   
4. Configure your datasource, user and password in aplication properties file.

   ```
    spring.datasource.url=jdbc:mysql://localhost:{yourPort}/{yourDatabase}
    
    spring.datasource.username={yourUser}
    
    spring.datasource.password={yourPassword}
   ```

   
4. Run the project with te IDE.

   ```
   $ run MyKrelloApplication 
   ```   
---

### Installation for **Frontend Project**

Install each one the pieces of software previously mentioned (Git).

1. Clone the repo

      - HTTPS
         ```
         $ git clone https://github.com/nqs48/Krello_ADev_Frontend.git
         ```


      - SSH
         ```
         $ git clone git@github.com:nqs48/Krello_ADev_Frontend.git
         ```
         
2. Open the project with VisualStudio Code (In the root proyect directory)

   ```
   $ code .
   ```
   
3. Install Extension for VsCode <Live Server>

   ```
   https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer
   ```
   
4. Click on live server option (down in the window) 

   ```
   The browser will be open automatically
   ```
   
5. Open the localhost port 5500 in your preference browser

   ```
   http://localhost:5500/
   ```

---

<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

---

<!-- CONTACT -->
## Collaborators
```
Nestor Quiroga Suarez
Jr. FrontEnd Developer

Julian Camilo Escobar
Jr. Backend Developer

Julian Lasso
Technical Coach

```
<br>

<p align="center">
<br>
<a href="https://www.linkedin.com/in/nqs48/"><img src="https://img.shields.io/badge/linkedin-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white" alt="LinkedIn" /></a>&nbsp;&nbsp;
<a href="https://api.whatsapp.com/send/?phone=573102095353&text=Hola+Nestea%2C+vi+tu+perfil+de+github+y+me+encanto+el+trabajo+que+haces%21%21&type=phone_number&app_absent=0"><img src="https://img.shields.io/badge/what's app-2d572c?style=for-the-badge&logo=whatsapp" alt="whats app" /></a>&nbsp;&nbsp;
<a href="https://www.instagram.com/nqs48/"><img src="https://img.shields.io/badge/instagram-white?style=for-the-badge&logo=instagram" alt="Instagram"/>&nbsp;&nbsp;
<a href="mailto:nqs48@hotmail.com"><img src="https://img.shields.io/badge/outlook-blue?&style=for-the-badge&logo=microsoft-outlook&logoColor=white" alt="outlook"/></a>
</a>
</p>
<br>
<p align='center'>
  <a href="#top"><img src="https://img.shields.io/badge/Back to Top-black?" alt="back to top"/></a>
</p>

