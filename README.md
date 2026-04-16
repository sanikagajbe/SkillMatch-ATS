# 🚀 SkillMatch ATS: Intelligent Resume Screening System

SkillMatch is a full-stack Applicant Tracking System (ATS) designed to eliminate the inefficiency of manual resume screening. Built with a robust Java Spring Boot backend and an H2 in-memory database, the application provides a dual-portal interface for candidates and recruiters. 

The system utilizes a rule-based parsing engine to instantly compare candidate skills against specific job requirements, generating a real-time percentage match, suitability ranking (Strong, Moderate, Weak), and a breakdown of missing competencies. By automating this initial evaluation phase, SkillMatch significantly reduces time-to-hire and delivers a data-driven workflow for modern recruitment.

---

## 🛠️ Technologies Used
* **Backend:** Java 17, Spring Boot (Web, Data JPA)
* **Database:** H2 In-Memory Database
* **Frontend:** HTML5, CSS3, Vanilla JavaScript (Fetch API)
* **Build Tool:** Maven
* **Architecture:** RESTful API, MVC Pattern, Object-Oriented Design

---

## 📂 Internal Architecture & Code Structure
The backend is designed using a strict, layered architecture to ensure separation of concerns, utilizing core OOP principles like Abstraction and Encapsulation.

* `model/`: Defines the data entities. Includes the `Candidate` class marked with `@Entity` to automatically map Java objects to database tables.
* `repository/`: The data access layer. Utilizes Spring Data JPA interfaces to handle database operations without writing boilerplate SQL.
* `service/`: The "brain" of the application. Contains the `MatcherService`, which executes the core algorithm to parse text, calculate match percentages, and determine suitability rankings.
* `utils/`: Contains the `TextProcessor` to sanitize, lowercase, and tokenize messy string inputs.
* `controller/`: The API routing layer. `ResumeController` exposes REST endpoints (`/api/v1/candidates` and `/api/v1/analyze`) to connect the frontend web pages to the backend logic.

---

## 💻 How to Run Locally

Follow these steps to run the ATS on your local machine:

**1. Clone the repository**
```bash
git clone [https://github.com/sanikagajbe/SkillMatch-ATS.git](https://github.com/sanikagajbe/SkillMatch-ATS.git)
cd SkillMatch-ATS
