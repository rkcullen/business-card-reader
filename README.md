## business-card-reader

### Build Requirements
To sucsessfully compile and run this exercise the following is required to run in a command shell: 
- JDK (Java Development Kit) 1.8 or higher
- Maven

### Build the Application 
After cloning the repository, use maven to build the exercise by running the following command in a command shell:<br/><br/>
`mvn clean verify` 

### Run the Application
This application parses out the name, phone number and email address from a sample business card text.<br/>
The exercise requires a single String argument with line breaks surrounded by open/closed quotes, for example:<br/>

> "Foobar Technologies<br/>
> Analytic Developer<br/>
> Lisa Haung<br/>
> 1234 Sentry Road<br/>
> Columbia, MD 12345<br/>
> Phone: (410) 555-1234<br/>
> Fax: 410-555-4321<br/>
> lisa.haung@foobartech.com"<br/> 

To run the exercise, pass the String argument to the command line as follows:<br/><br/>
`java -cp target/business-card-parser-1.0.jar org.fivelands.parser.Main` "Foobar Technologies<br/> 
&gt;Analytic Developer <br/>
&gt;Lisa Haung <br/>
&gt;1234 Sentry Road <br/> 
&gt;Columbia, MD 12345 <br/>
&gt;Phone: (410) 555-1234<br/> 
&gt;Fax: 410-555-4321 <br/>
&gt;lisa.haung@foobartech.com" 
