## Clean Architecture Web Demo
Added a web app on top of the existing enrolment manager.
Modified the Student entity to make it work as a model in Spring Boot,
then added a use case class and controllers to define actions that users of our
API can do with the Student entities. No views (presenters) were created since this API
will respond with JSON data, and Spring Boot has an implementation of this
right out of thew box.

Then, we create a simple front-end with HTML, CSS, and JavaScript to consume the API
and display a list of students.

If you want to run this, you will need to set up a PostgreSQL database on your machine. You can find
many online tutorials about how to do this.

## From the Original README:

A course enrolment manager with almost no features. A work in progress toward the Clean Architecture.

Clone, compile, and run this program. You will be prompted for several pieces of information, and then be enrolled in a course. Then the program exits.

The UI (the command line, so System.in and System.out) has been separated into another layer and injected into the run method. That way, other UIs can be injected, and as an example, there is a test case that uses an implementation that reads from a String array instead of from the keyboard, and saves output to another String array so that it can be checked for correctness in the test case.