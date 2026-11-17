# Q3 - Penguin application design

## Q3a - Importing several formats

Define a DataImporter interface with an importData source operation returning a common domain model. Implement JsonImporter, XmlImporter, CsvImporter, and BespokeImporter; each owns its parsing, validation, and mapping into that model. The application depends on DataImporter rather than file-format details. A factory can select an importer from an explicit format or validated file metadata; dependency injection supplies it to the importing workflow.

This uses Strategy for interchangeable parsing algorithms and Factory for their creation. Adapter is also applicable when wrapping an existing parser with a different API. Adding a format requires a new importer rather than changing the core workflow, supporting OCP. A single importer has one responsibility, and depending on its interface supports DIP. Test each format using small fixtures and test the workflow with a fake importer. Keep malformed input handling consistent across implementations.

## Q3b - Interface Segregation Principle (ISP)

User requires both accessResearch() and getPhotos(), although the user roles need different capabilities. The supplied Penguinologist implements getPhotos() by returning null, showing that it is forced to provide behaviour it does not support. PhotoViewer depends on the broad User abstraction even though it needs only photos, which can cause a null failure when handed a Penguinologist. The broad contract also creates a Liskov substitution problem if getPhotos() promises a usable collection.

Separate account identity/authentication from ResearchAccess and PhotoAccess interfaces. Penguinologist implements ResearchAccess, while BasicUser implements PhotoAccess; a role that supports both can implement both. Make PhotoViewer accept PhotoAccess so unsupported users cannot be passed to it. Move shared login functionality into an account service or small base class, and avoid dummy methods returning null. This exposes capabilities explicitly and prevents clients from depending on operations they never use.
