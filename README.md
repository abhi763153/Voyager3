# Voyager3 - Web Browser

A lightweight web browser built using JavaFX, with a clean and simple UI that allows users to browse the web. This project demonstrates the use of WebView and WebEngine components in JavaFX, as well as basic web navigation controls like back, forward, reload, and home.

Features : 
  - Basic Web Navigation: Navigate to any URL, including support for back, forward, and reload buttons.
  - Home Page Setting: Default homepage with easy redirection to home.
  - Responsive Address Bar: Input URLs directly and see them update dynamically as you navigate.
  - Minimal UI Design: Simple, easy-to-use interface focusing on the essentials of browsing.

Screenshots
![]([images/screenshot.png](https://github.com/abhi763153/Voyager3/blob/9f30dbe4df79bb82a545d7090f3ce1454eb85bac/Voyager3.png))



Getting Started

Prerequisites :
Java Development Kit (JDK): Ensure that JDK 17 or higher is installed.
JavaFX SDK: JavaFX libraries for running JavaFX applications.

Installation
Clone this repository:
bash
Copy code
git clone https://github.com/abhi76315314/Voyager3.git
Open the project in your IDE (e.g., IntelliJ IDEA).
Ensure all JavaFX dependencies are correctly configured (see pom.xml if using Maven).
Running the Application
To run the web browser:

Open the terminal in your project directory.
Use the following Maven command:
bash
Copy code
mvn javafx:run
Or simply run the main class in your IDE.

How It Works
The project is built using JavaFX's WebView and WebEngine classes to display and render web content. The browser interface includes:

Address Bar: Enter URLs here to load new pages.
Navigation Buttons: Buttons for "Back," "Forward," "Reload," and "Home."
Status Bar: Displays the current URL and page load status.
Technologies Used
JavaFX: For building the user interface.
Maven: For dependency management.
Future Improvements
Bookmark Management: Save and organize favorite sites.
History Tracking: Keep a history of visited pages.
Tab Functionality: Multi-tab browsing experience.
Contributing
Contributions are welcome! Please open an issue to discuss improvements or new features before submitting a pull request.
