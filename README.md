## business-card-reader

### Build Requirements
To sucsessfully compile this exercise the following is required to run in a command shell: 
- JDK (Java Development Kit) 1.8 or higher
- Maven

### Build Command
Run the following command in a command shell after cloning the repository: 
`mvn clean verify` 

### Run the Application
The exercise requires a single String argument with line breaks surro<br/>unded by open/closed quotes, for example: 

> "Foobar Technologies
> Analytic Developer
> Lisa Haung
> 1234 Sentry Road
> Columbia, MD 12345
> Phone: (410) 555-1234
> Fax: 410-555-4321
> lisa.haung@foobartech.com" 

Run the exercise and pass the String argument to the command line as follows: 
`java -cp target/business-card-parser-1.0.jar org.fivelands.parser.Main` "Foobar Technologies 
Analytic Developer 
Lisa Haung 
1234 Sentry Road 
Columbia, MD 12345 
Phone: (410) 555-1234one 
Fax: 410-555-4321 
lisa.haung@foobartech.com" 
