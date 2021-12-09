# ddd-jdbc
spring data jdbc, Doesn't work as expected and does not guarantee the consistency of the aggregate root.

According to the source code logic, only the entities directly related to the aggregate root are updated, but the related entities of the entities are not updated.

I don't know if I abused the framework or the framework missed this possibility.
