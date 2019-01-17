## business-card-reader

### Build Requirements
To sucsessfully compile this exercise the following is required to run in a command shell: 
- JDK (Java Development Kit) 1.8 or higher
- Maven

### Build Command
Run the following command in a command shell after cloning the repository:<br/>
`mvn clean verify` 

### Run the Application
The exercise requires a single String argument with line breaks surrounded by open/closed quotes, for example:<br/>

> "Foobar Technologies<br/>
> Analytic Developer<br/>
> Lisa Haung<br/>
> 1234 Sentry Road<br/>
> Columbia, MD 12345<br/>
> Phone: (410) 555-1234<br/>
> Fax: 410-555-4321<br/>
> lisa.haung@foobartech.com"<br/> 

Run the exercise and pass the String argument to the command line as follows:<br/>
`java -cp target/business-card-parser-1.0.jar org.fivelands.parser.Main` "Foobar Technologies<br/> 
Analytic Developer <br/>
Lisa Haung <br/>
1234 Sentry Road <br/> 
Columbia, MD 12345 <br/>
Phone: (410) 555-1234one <br/> 
Fax: 410-555-4321 <br/>
lisa.haung@foobartech.com" 
