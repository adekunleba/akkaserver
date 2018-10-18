## This is an implementation of Akka-http with Redis for building an api

## Key Implementation:
Install Redis Database.
Once you start the Database, it should run on "localhost" port: 6379

Run the main method and send in a post request as thus

 `curl -v -H "Content-Type: application/json" -X POST http://127.0.0.1:8080/sampleroute -d '{"id":"someString", "value": "someData"}`

 You can run a GET Method as thus

`curl -v http://127.0.0.1:8080/sampleroute/{keytosearch}`