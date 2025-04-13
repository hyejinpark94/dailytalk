# Dailytalk Project

## Overview

This project built using Spring Boot for the backend and React for the frontend. The application replicates the core functionality of requiring users to log in before accessing specific content, with features such as user authentication, redirection after login, and support for various login methods.

## Features

-   **User Authentication**: Secure user login using Spring Security.
-   **Social Login**: Integration with Kakao login for seamless user authentication.
-   **Custom Login Page**: Replicates the custom login page design of the original site, built with React.
-   **Login Redirection**: After successful login, users are redirected to the originally requested page.
-   **RESTful API**: Spring Boot provides a RESTful API for user authentication and data retrieval.
-   **Responsive Design**: React components are designed to be responsive and adaptable to various screen sizes.

## Technologies Used

-   **Backend**:
    -   Spring Boot
    -   Spring Security
    -   Spring Data JPA (optional, for database interaction)
    -   RESTful API design
-   **Frontend**:
    -   React
    -   React Router (for handling client-side routing)
    -   Axios (for making HTTP requests to the backend)
    -   Material-UI or similar component library (for UI components)
-   **Database** (optional):
    -   MySQL, PostgreSQL, or any other database supported by Spring Data JPA
-   **Build Tools**:
    -   Maven or Gradle (for backend)
    -   npm or yarn (for frontend)

## Setup Instructions

### Prerequisites

-   Java 11 or higher
-   Node.js and npm
-   A Kakao Developer account for Kakao Login integration
-   A suitable IDE (e.g., IntelliJ IDEA, VS Code)

### Backend Setup (Spring Boot)

1.  **Clone the repository:**

    ```bash
    git clone [repository-url]
    cd [backend-directory]
    ```
2.  **Configure the application:**
    -   Update the `application.properties` or `application.yml` file with your database settings, Kakao API keys, and other necessary configurations.
    -   Example:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/your_database
        spring.datasource.username=your_username
        spring.datasource.password=your_password
        kakao.client.id=your_kakao_client_id
        kakao.redirect.uri=http://localhost:8080/api/auth/kakao
        ```
3.  **Build and run the application:**

    ```bash
    ./mvnw spring-boot:run
    ```
    or

    ```bash
    ./gradlew bootRun
    ```
    The backend server will start on `http://localhost:8080`.

### Frontend Setup (React)

1.  **Navigate to the frontend directory:**

    ```bash
    cd [frontend-directory]
    ```
2.  **Install dependencies:**

    ```bash
    npm install
    ```
    or

    ```bash
    yarn install
    ```
3.  **Configure environment variables:**
    -   Create a `.env` file in the frontend directory and add the necessary environment variables, such as the backend API URL.
    -   Example:
        ```env
        REACT_APP_API_BASE_URL=http://localhost:8080/api
        ```
4.  **Start the development server:**

    ```bash
    npm start
    ```
    or

    ```bash
    yarn start
    ```
    The frontend application will start on `http://localhost:3000`.

## Kakao Login Setup

1.  **Create a Kakao Developer account** at [https://developers.kakao.com/](https://developers.kakao.com/).
2.  **Create a new application** and obtain the **REST API Key** and **Client Secret**.
3.  **Configure the Redirect URI** in the Kakao Developer Console to match the backend endpoint for handling the authorization code (e.g., `http://localhost:8080/api/auth/kakao`).
4.  **Update the application's configuration** with the obtained keys and redirect URI.

## Code Structure

-   **Backend (Spring Boot)**:
    -   `src/main/java`: Contains the source code for the backend application.
        -   `controller`: REST API controllers.
        -   `service`: Business logic services.
        -   `model`: Data models (entities).
        -   `repository`: Data access repositories.
        -   `config`: Configuration files (e.g., Spring Security).
-   **Frontend (React)**:
    -   `src`: Contains the source code for the frontend application.
        -   `components`: Reusable React components.
        -   `pages`: React components representing different pages of the application.
        -   `services`: API service functions for making HTTP requests.
        -   `App.js`: Main application component.
        -   `index.js`: Entry point for the React application.

## API Endpoints

-   `POST /api/auth/login`: Logs in an existing user.
-   `POST /api/auth/register`: Registers a new user.
-   `GET /api/auth/kakao`: Handles Kakao login callback.
-   `GET /api/content`: Retrieves content (requires authentication).

## Contributing
Contributions are welcome! Please follow these steps:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Implement your changes.
4.  Write tests to ensure the functionality works as expected.
5.  Submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

hyejin.park - dpebfsoeb@gmial.com

## Acknowledgments

-   Thanks to the Spring Boot and React communities for providing excellent documentation and resources.

