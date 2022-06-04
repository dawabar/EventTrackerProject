# EventTrackerProject

### Description

This project is designed to show learning about REST API calls.  For this project, we created a simple database, created Java-based Repositories, Services, Service Implementations, and Controllers to execute CRUD operations using Spring Data JPA and REST.

The database tracks chores. One table contains a list of chores with their associated payments for completion. A second table is the ledger, where a user makes an entry for the name of the person who completed the chore, the ID associated with the chore (for a many-to-one lookup), and the amount paid (which can be higher if the chore is based on hours worked).

Both tables have API calls that allow for the user to:
- query for a single Chore or Entry (READ)
- query for all Chores or Entries (READ)
- CREATE a new Chore or Entry
- DELETE a Chore or Entry
- UPDATE (modify) a Chore or Entry

Below is a list of recommended inputs to perform API request tests using Postman.

| **HTTP** | **API Path** | **Inputs** |




### Topics covered in Week 12:

- RESTful Services
- Spring Data JPA
- JavaScript (not used in this project)

### Technologies Used

- MySQL
- MySQL Workbench (for creating the database and populating basic content)
- Java
- Spring Tool Suite
- Spring Data JPA (Java Persistence API), which replaced our previous work on JPA using Data Access Objects (DAO)
- Postman (for HTTP request testing)
- JSON (JavaScript Object Notation, for formatting data within Postman)
- Git
- GitHub
- Markdown (for README.md)
- Slack
- Zoom
- Browser (Chrome-focused)
- Unix/Linux Terminal
- AWS (Amazon Web Services)

## Other Technologies Studied Recently

- Java Persistence API (JPA)
- Java Server Pages (JSP)
- JSTL (JSP Standard Tag Library)
- HTML & CSS (Cascading Style Sheets)
- Trello
- Figma

### Lessons Learned

After reading about RESTful design for years, it's exciting to finally be learning how it all works.  The simplicity and consistency of RESTful interfaces makes it clear why this has remained a dominant web communication paradigm for so many years.  I have tried to absorb as much as I can about this material, knowing that it will be critical for web deployment in my future.

After our midterm project, I am missing the front-end part of programming. Since early childhood I have focused on ergonomics and usability in team dynamics, environments, and tools.  Quality UI design scratched that itch for me.  REST lacks some of that sparkle.  At the same time, I recognize the meat-and-potatoes nature of REST and effective CRUD operations for creating a quality application.  These are the workhorse skills that pay the bills.

Spring Data JPA abstracts away a lot of the complexity of creating a full-stack Java-based application.  I appreciate the slow and steady walk from basic Java programming towards more complex frameworks.  It allows us, as students, to understand more clearly what is happening under the hood of these frameworks that use libraries to turn dozens of lines of code into just two or three lines of code.  This matches with the advice I see from so many programmers, that if you want to understand the technology better you have to go back to the original documentation and start understanding how things work in the hardware or behind the scenes.  The last 11 weeks have given us that foundation.  Now, learning faster and easier methods for rapidly producing fully-functional REST queries -- just a week after working with a team to create a fully-functional web site in less than 10 days -- provides me with a confidence that I might achieve the speed of execution that allows programmers like Notch to create applications like Minecraft during a single weekend hackathon.  That's where I want to be, and I feel myself getting there.

I have gotten to the point that I can clearly understand what code is doing when I read it.  I am also at the point that my biggest problems are the smallest mistakes.  In this case, placing a slash at the end of a URL path or having square brackets instead of curly braces around my JSON object. These were the small errors that caused the most issues in the last 24 hours of programming this project.  But that's exciting, because it means that I'm finally learning the common grammar mistakes of programming -- the there/their/they're of code.  These revelations will make it easier to proofread code in the future during code review or debugging.
