# Finatra Petstore Example Application

An example finatra application that highlights features of the
[finatra-http](https://github.com/twitter/finatra/tree/master/http) framework.

This example is based off of the [Swagger Petstore API example] (http://petstore.swagger.io/).

Run the example server locally with sbt:
-----------------------------------------------------------

```
$ cd finatra-examples/petstore
$ sbt run
```

The app will be running at [http://localhost:8888](http://localhost:8888).

The database has already been filled with example data, which can be viewed in `PetstoreServer.scala`.
To begin with a completely empty database, replace line 52 with the commented-out line 51.
