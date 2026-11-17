# Q3 - MDToken: SOLID and refactoring

## 1. Single Responsibility Principle (SRP)

A class should have one coherent responsibility and one reason to change. MDToken stores parsed list-item data but also implements presentation in toString(), including a fixed four-space indentation policy and a particular textual token label. Changes to list-item semantics and changes to display formatting therefore both require editing the class. For example, adding an HTML preview or changing the debug indentation should not require modifying the lexical model. A diagnostic toString() alone is not necessarily a serious SRP violation; the concern here is using it as the extensible rendering mechanism.

## 2. Open/Closed Principle (OCP)

Code should support extension without repeatedly editing stable behaviour. MDToken uses a type enum and constructors to represent several variants in one class; number is meaningful only for an ordered item. Adding a task-list item with a checked flag would require modifying the shared type enum, model fields/constructors, and downstream type-based conditionals. The design creates pressure for modification rather than an independent extension. This is a design limitation in that extension scenario, rather than proof that every enum violates OCP.

## 3. Refactoring

Define an immutable ListItem abstraction exposing content and level. Implement OrderedItem with its required number and UnorderedItem without that field; a later TaskItem can add a checked value without invalid fields on other item types. Validate mandatory values in constructors and expose getters rather than mutable package-visible fields. Model the synthetic tree root separately from actual list items.

Move human-facing formatting into a renderer selected through an interface, such as ItemRenderer, with text and HTML implementations. Let the parser depend on the ListItem abstraction and construct the appropriate concrete item through a factory. Define equality and hashCode together, including whichever fields represent identity, because the current equality ignores level and number and has no matching hashCode implementation. Regression tests should cover mixed lists, ordered numbering, indentation, and the formatting output before and after refactoring.
