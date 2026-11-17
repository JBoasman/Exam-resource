# Exam locator

Read a topic and use the displayed repository-relative path to open the file manually in your editor. Paths are relative to the folder containing this file. The HTML viewer and file-opening tools have been removed.

Extended explanations: `MCQ-SAQ-STUDY-GUIDE.md`. MCQ answers and caveats: `MCQ-NOTES.md`. Linux extraction and setup: `LINUX-SETUP.md`. Previous Java test results: `VERIFICATION.md`.

Use Ctrl+F for terms such as `CSV`, `Interfaces`, `BST-find`, `AVL-insert`, `RBT-balanced`, or `MCQ`. The topic sublists retain within-document navigation; file entries below show plain paths.

## Fast examples

| Find this | Open this file |
|---|---|
| CSV parsing; semicolon; skip header; XML export | `past-exams/2020-2/Q3/Application.java` |
| JSON load/save; merge duplicate names | `misc-questions/q1-json/Company.java` |
| XML optional attributes/elements; round-trip | `misc-questions/q14-xml/StudentCollection.java` |
| XML recursive hierarchy; DOM children; validation | `past-exams/2025-2/src/Q4/LocationLoader.java` |
| BST-find; iterative search | `past-exams/2022-1/q3/BST.java` |
| BST-delete; successor; zero/one/two children | `past-exams/2019-2/Q2/BST.java` |
| BST one-child / odd-children sum | `misc-questions/q9-bst/BST.java` |
| BST reversed ordering; duplicates; validate invariant | `past-exams/2025-1/src/Q2/FamilyTree.java` |
| AVL-insert; LL/RR/LR/RL; immutable; correct reference | `past-exams/2024-1/src/Q2/MockClasses/ReferenceAVLTree.java` |
| AVL black-box rotation tests; faulty subject expected to fail | `past-exams/2024-1/src/Q2/AVLTreeTest.java` |
| RBT-balanced; insert; rotations; recolour | `misc-questions/q3-rbtree/RBTree.java` |
| BFS; level-order; right-to-left; sentinel leaves | `past-exams/2020-2/Q3/RBTree.java` |
| Recursive descent; AST; right-associative arithmetic | `past-exams/2025-1/src/Q3/Parser.java` |
| CFG validation; Git commands | `past-exams/2024-2/src/Q3/Parser.java` |
| Nested Markdown lists; indentation; n-ary tree | `past-exams/2023-1/Q2/MDParser.java` |
| Wildcard match without regex; BST memory interpreter | `past-exams/2022-1/q3/Executor.java` |
| Interfaces; State; Singleton; null exceptions | `past-exams/2022-1/q1/State.java` |
| Interfaces; Iterator; filtering collection | `misc-questions/q13-iterator/GreenGrocery.java` |
| Interfaces; Observer; register; notify; per-person tracking | `past-exams/2023-1/Q1/Participant.java` |
| Factory Method; abstract class; super; Template Method | `past-exams/2024-1/src/Q1/AnimalCreator.java` |
| Strategy; conditional code smell; refactoring answer | `past-exams/2025-2/src/Q3/Q3Answers.java` |
| Branch-complete; parameterized; null; short-circuit | `past-exams/2025-2/src/Q2/CalculatePriceTest.java` |
| Black-box tests; hashing; prime; ASCII; expected failures | `past-exams/2024-2/src/Q2/Q2Test.java` |
| MCQ by topic; worked answers; ambiguity notes | `MCQ-NOTES.md` |

## Cheat sheets

- `past-exams/CheatSheets/CheatSheet for BST.md`
- `past-exams/CheatSheets/CheatSheet for Design.md`
- `past-exams/CheatSheets/CheatSheet for Parsing.md`
- `past-exams/CheatSheets/CheatSheet for Testing.md`

## Topic sublists

### Trees: BST, AVL, RBT, traversals

- [Red-black tree balancing — misc-questions/q3-rbtree](#question-3) — Trees RBT-insert RBT-balanced rotations recolouring red-uncle black-uncle
- [Character state machine and inverse preorder — misc-questions/q4-state-testing-bst](#question-4) — Design State Singleton Interfaces exceptions null testing Trees BST inverted-pre-order root-right-left
- [DNA search tree and branch coverage — misc-questions/q6-bst-testing](#question-6) — Trees BST-find BST-insert DNA one-child odd-children sum Testing branch-complete
- [Sum nodes with one child — misc-questions/q9-bst](#question-10) — Trees BST oddNodeSum one-child odd-children recursion
- [String-key BST — past-exams/2019-1/Q3](#question-18) — Trees BST-find BST-insert pre-order odd-children printOddNodes
- [Integer BST deletion and child-count sums — past-exams/2019-2/Q2](#question-20) — Trees BST-find BST-delete successor two-children sumEvenNodes even-children
- [Three-colour tree — past-exams/2020-1/Q1](#question-23) — Trees ThreeColourTree insert colour colour-ordering recursion
- [Word tokenization into red-black tree — past-exams/2020-2/Q1](#question-26) — Parsing uppercase lowercase camel-case numbers punctuation Trees RBT-insert word-length grouping
- [CSV to red-black tree to XML — past-exams/2020-2/Q3](#question-28) — Persistence CSV parsing semicolon delimiter header XML DOM Trees RBT level-order BFS right-to-left
- [Parcel ordering and search tree — past-exams/2021-2/q3](#question-31) — Trees BST-find BST-insert traversal filter Comparable compareTo distance parcels
- [BST memory command interpreter — past-exams/2022-1/q3](#question-36) — Trees BST-find inverted-pre-order Parsing LOAD SAVE SUM wildcard pattern no-regex memory interpreter
- [Markdown list parser and n-ary tree — past-exams/2023-1/Q2](#question-39) — Persistence file-reading Markdown Parsing Tokenizer indentation ordered-list unordered-list Trees n-ary pre-order stack
- [Minimum-height decision tree — past-exams/2023-2/src/Q2](#question-42) — Trees decision-tree classify recursion height Design Factory polymorphism optimal memoization
- [AVL rotations and black-box tests — past-exams/2024-1/src/Q2](#question-46) — Trees AVL-insert AVL-balanced LL LR RL RR leftRotate rightRotate immutable Testing parameterized mutation intentionally-faulty-SampleAVLTree
- [Fourteen MCQs — past-exams/2024-1/src/Q4](#question-48) — MCQ Software-Construction Testing branch-count IP Trees BST-height RBT-insert Parsing Ethics UML SOLID OCP Refactoring Android CFG
- [BST custom iterator — past-exams/2024-2/src/Q1](#question-49) — Trees BST-insert BST-find iteration Design Iterator Interfaces collection traversal
- [Reverse-order family tree — past-exams/2025-1/src/Q2](#question-54) — Trees BST-find BST-insert reverse-order duplicates ordering-invariant height family-labels display EmptyTree

### Parsing, tokenisers, grammars, interpreters

- [Single-digit arithmetic grammar — misc-questions/q2-parsing](#question-2) — Parsing Tokeniser recursive-descent arithmetic CFG validation
- [Balanced parentheses grammar — misc-questions/q5-grammars](#question-5) — Parsing CFG parentheses balanced-brackets nested concatenation
- [Mutually recursive odd/even grammar — misc-questions/q10-parsing](#question-11) — Parsing CFG chart-parsing dynamic-programming odd even left-recursion
- [LOGO turtle parsing and Makefile — past-exams/2019-1/Q2](#question-17) — Parsing Tokenizer turtle LOGO FORWARD BACK PENUP PENDOWN screen trace Makefile build
- [LOGO boundary movement — past-exams/2019-2/Q4](#question-22) — Parsing Tokenizer turtle LOGO FORWARD_TO_END BACK_TO_END screen trace
- [SQL INSERT and XML customer table — past-exams/2020-1/Q4](#question-25) — Parsing SQL INSERT VALUES columns validation Persistence XML DOM load save optional-elements
- [Word tokenization into red-black tree — past-exams/2020-2/Q1](#question-26) — Parsing uppercase lowercase camel-case numbers punctuation Trees RBT-insert word-length grouping
- [LOAD/SAVE XML command interpreter — past-exams/2021-2/q2](#question-30) — Parsing CFG LOAD FROM SAVE TO commands Design Singleton Persistence XML DOM database
- [BST memory command interpreter — past-exams/2022-1/q3](#question-36) — Trees BST-find inverted-pre-order Parsing LOAD SAVE SUM wildcard pattern no-regex memory interpreter
- [Markdown list parser and n-ary tree — past-exams/2023-1/Q2](#question-39) — Persistence file-reading Markdown Parsing Tokenizer indentation ordered-list unordered-list Trees n-ary pre-order stack
- [Knowledge graph query — past-exams/2023-2/src/Q1](#question-41) — Parsing SELECT WHERE CFG token-validation Persistence XML DOM triples subject predicate object filtering
- [Word-processor token validation — past-exams/2024-1/src/Q3](#question-47) — Parsing Tokeniser TYPE UNDO REDO OCCURRENCES CAPITALISE invalid-input
- [Fourteen MCQs — past-exams/2024-1/src/Q4](#question-48) — MCQ Software-Construction Testing branch-count IP Trees BST-height RBT-insert Parsing Ethics UML SOLID OCP Refactoring Android CFG
- [Git command grammar — past-exams/2024-2/src/Q3](#question-51) — Parsing Tokeniser git add commit push paths separators invalid-input
- [Right-recursive expression AST — past-exams/2025-1/src/Q3](#question-55) — Parsing Tokeniser recursive-descent CFG AST expression-tree right-associative operators sequence invalid-input
- [Ten MCQs — past-exams/2025-1/src/Q4](#question-56) — MCQ Git merge graph Singleton Testing branch-coverage AVL-insert Android-localisation Parsing CSV sharding SOLID LSP JML IP

### Persistence: CSV, JSON, XML, files

- [Company JSON merge — misc-questions/q1-json](#question-1) — Persistence JSON Gson load save duplicate-employees merge-skills
- [Tree collection XML round-trip — misc-questions/q7-xml](#question-7) — Persistence XML DOM attributes optional-elements dimension serialization load save
- [College JSON merge — misc-questions/q11-json](#question-12) — Persistence JSON Gson load save duplicate-students merge-courses
- [Students and courses XML — misc-questions/q14-xml](#question-15) — Persistence XML DOM attributes optional-elements courses grade load save
- [SQL INSERT and XML customer table — past-exams/2020-1/Q4](#question-25) — Parsing SQL INSERT VALUES columns validation Persistence XML DOM load save optional-elements
- [CSV to red-black tree to XML — past-exams/2020-2/Q3](#question-28) — Persistence CSV parsing semicolon delimiter header XML DOM Trees RBT level-order BFS right-to-left
- [LOAD/SAVE XML command interpreter — past-exams/2021-2/q2](#question-30) — Parsing CFG LOAD FROM SAVE TO commands Design Singleton Persistence XML DOM database
- [Game state and XML transition log — past-exams/2022-1/q1](#question-34) — Design State Singleton Interfaces game transitions null exceptions Persistence XML DOM state-log Testing
- [Markdown list parser and n-ary tree — past-exams/2023-1/Q2](#question-39) — Persistence file-reading Markdown Parsing Tokenizer indentation ordered-list unordered-list Trees n-ary pre-order stack
- [Knowledge graph query — past-exams/2023-2/src/Q1](#question-41) — Parsing SELECT WHERE CFG token-validation Persistence XML DOM triples subject predicate object filtering
- [Flat and hierarchical XML locations — past-exams/2025-2/src/Q4](#question-60) — Persistence XML DOM recursive tree attributes optional-population validation missing-name

### Design patterns, interfaces, OOP

- [Character state machine and inverse preorder — misc-questions/q4-state-testing-bst](#question-4) — Design State Singleton Interfaces exceptions null testing Trees BST inverted-pre-order root-right-left
- [Parcel transport design patterns — misc-questions/q8-dp-testing/parcel](#question-9) — Design Singleton transport strategy recipient identity state cost time weight
- [Vending machine states — misc-questions/q12-uml-state-testing](#question-13) — Design UML State Singleton Interfaces vending-machine transitions Testing
- [Grocery custom iterator — misc-questions/q13-iterator](#question-14) — Design Iterator Interfaces hasNext next filtering fruits collection
- [Calculator facade — misc-questions/q15-facade](#question-16) — Design Facade Interfaces arithmetic divide-by-zero Operation
- [Repository and singleton testing — past-exams/2020-2/Q2](#question-27) — Testing Design Repository Singleton identity persistence Person SequenceGenerator
- [LOAD/SAVE XML command interpreter — past-exams/2021-2/q2](#question-30) — Parsing CFG LOAD FROM SAVE TO commands Design Singleton Persistence XML DOM database
- [Reliable and efficient software essay — past-exams/2021-2/q4](#question-32) — Written Design Testing performance profiling maintainability refactoring contracts data-structures
- [Game state and XML transition log — past-exams/2022-1/q1](#question-34) — Design State Singleton Interfaces game transitions null exceptions Persistence XML DOM state-log Testing
- [Delivery quote strategies — past-exams/2022-1/q2](#question-35) — Design Strategy Interfaces inheritance quote weight distance ceiling safety illegal-items
- [Calculator design and licensing critique — past-exams/2022-1/q4](#question-37) — Written Design Strategy Interfaces SOLID DIP OCP refactoring overflow exponentiation IP licensing original-flawed-code
- [Escape-room state and observer — past-exams/2023-1/Q1](#question-38) — Design State Observer Interfaces GameMaster HelpState Riddle Testing branch-coverage short-circuit
- [Minimum-height decision tree — past-exams/2023-2/src/Q2](#question-42) — Trees decision-tree classify recursion height Design Factory polymorphism optimal memoization
- [Penguin importers and user interfaces — past-exams/2023-2/src/Q3](#question-43) — Written Design Strategy Factory Adapter Interfaces SOLID ISP LSP DIP OCP JSON XML CSV
- [Animal factory method and template — past-exams/2024-1/src/Q1](#question-45) — Design Factory-Method Template-Method Interfaces abstract-class inheritance super constructor UUID names defaults
- [BST custom iterator — past-exams/2024-2/src/Q1](#question-49) — Trees BST-insert BST-find iteration Design Iterator Interfaces collection traversal
- [Cooking state machine and recipes — past-exams/2025-1/src/Q1](#question-53) — Design State Factory Interfaces cooking food recipes time ingredient
- [Payment strategy refactoring — past-exams/2025-2/src/Q3](#question-59) — Written Design Strategy Interfaces SOLID OCP code-smell conditional-dispatch refactoring
- [Favourites observer notifications — past-exams/2025-2/src/Q5](#question-61) — Design Observer Interfaces subject observers notify singleton item favourite price-change

### Testing and coverage

- [DNA search tree and branch coverage — misc-questions/q6-bst-testing](#question-6) — Trees BST-find BST-insert DNA one-child odd-children sum Testing branch-complete
- [Short-circuit branch testing — misc-questions/q8-dp-testing/branchComplete](#question-8) — Testing branch-coverage OR AND short-circuit minimum-inputs
- [Vending machine states — misc-questions/q12-uml-state-testing](#question-13) — Design UML State Singleton Interfaces vending-machine transitions Testing
- [Integer parser and newline testing — past-exams/2019-1/Q4](#question-19) — Testing statement-coverage branch-coverage exceptions parseInt collapseNewlines JUnit5
- [String utilities coverage — past-exams/2019-2/Q3](#question-21) — Testing parseDouble isMixedCase short-circuit branch-coverage statement-coverage
- [Coverage of number-theory code — past-exams/2020-1/Q3](#question-24) — Testing branch-coverage gcd lcm remainder minimum-inputs
- [Repository and singleton testing — past-exams/2020-2/Q2](#question-27) — Testing Design Repository Singleton identity persistence Person SequenceGenerator
- [Boolean short-circuit testing — past-exams/2021-2/q1](#question-29) — Testing branch-coverage OR AND short-circuit minimum-inputs
- [Reliable and efficient software essay — past-exams/2021-2/q4](#question-32) — Written Design Testing performance profiling maintainability refactoring contracts data-structures
- [Game state and XML transition log — past-exams/2022-1/q1](#question-34) — Design State Singleton Interfaces game transitions null exceptions Persistence XML DOM state-log Testing
- [Escape-room state and observer — past-exams/2023-1/Q1](#question-38) — Design State Observer Interfaces GameMaster HelpState Riddle Testing branch-coverage short-circuit
- [Knowledge-graph tests — past-exams/2023-2/src/Tests](#question-44) — Testing SELECT WHERE triples tokenization query XML
- [AVL rotations and black-box tests — past-exams/2024-1/src/Q2](#question-46) — Trees AVL-insert AVL-balanced LL LR RL RR leftRotate rightRotate immutable Testing parameterized mutation intentionally-faulty-SampleAVLTree
- [Fourteen MCQs — past-exams/2024-1/src/Q4](#question-48) — MCQ Software-Construction Testing branch-count IP Trees BST-height RBT-insert Parsing Ethics UML SOLID OCP Refactoring Android CFG
- [HashingBox black-box tests — past-exams/2024-2/src/Q2](#question-50) — Testing parameterized mutation boundary-values exceptions hash prime ASCII material shape intentionally-faulty-implementations
- [Testing and refactoring essay — past-exams/2024-2/src/Q4](#question-52) — Written Testing Refactoring regression ethics public-interest
- [Ten MCQs — past-exams/2025-1/src/Q4](#question-56) — MCQ Git merge graph Singleton Testing branch-coverage AVL-insert Android-localisation Parsing CSV sharding SOLID LSP JML IP
- [Pricing parameterized coverage — past-exams/2025-2/src/Q2](#question-58) — Testing parameterized branch-coverage OR AND short-circuit null boundary-values discount

### Written answers and SOLID

- [Reliable and efficient software essay — past-exams/2021-2/q4](#question-32) — Written Design Testing performance profiling maintainability refactoring contracts data-structures
- [Android activity lifecycle essay — past-exams/2021-2/q5](#question-33) — Written Android onCreate onStart onResume onPause onStop onRestart onDestroy state-restoration
- [Calculator design and licensing critique — past-exams/2022-1/q4](#question-37) — Written Design Strategy Interfaces SOLID DIP OCP refactoring overflow exponentiation IP licensing original-flawed-code
- [MDToken SOLID critique — past-exams/2023-1/Q3](#question-40) — Written SOLID SRP OCP refactoring rendering immutability equality hashCode
- [Penguin importers and user interfaces — past-exams/2023-2/src/Q3](#question-43) — Written Design Strategy Factory Adapter Interfaces SOLID ISP LSP DIP OCP JSON XML CSV
- [Testing and refactoring essay — past-exams/2024-2/src/Q4](#question-52) — Written Testing Refactoring regression ethics public-interest
- [Payment strategy refactoring — past-exams/2025-2/src/Q3](#question-59) — Written Design Strategy Interfaces SOLID OCP code-smell conditional-dispatch refactoring

### MCQ by topic

- [Fourteen MCQs — past-exams/2024-1/src/Q4](#question-48) — MCQ Software-Construction Testing branch-count IP Trees BST-height RBT-insert Parsing Ethics UML SOLID OCP Refactoring Android CFG
- [Ten MCQs — past-exams/2025-1/src/Q4](#question-56) — MCQ Git merge graph Singleton Testing branch-coverage AVL-insert Android-localisation Parsing CSV sharding SOLID LSP JML IP
- [Five MCQs — past-exams/2025-2/src/Q1](#question-57) — MCQ RBT-insert red-uncle recolouring height Android lifecycle CFG JML Singleton

## Every question and file

Within each question, the statement, answer, tests, data, and diagrams are listed by file path. Java method names supplement the curated topic keywords. Original faulty subjects used for testing/critique are labelled in their question keywords and in VERIFICATION.md.

<a id="question-1"></a>
### misc-questions/q1-json — Company JSON merge

Keywords: Persistence JSON Gson load save duplicate-employees merge-skills

- `misc-questions/q1-json/readme.md`
- `misc-questions/q1-json/Company.java` — `loadFromJsonFile, mergeEmployees, saveToJsonFile, getName, setName, getEmployees, setEmployees, equals`
- `misc-questions/q1-json/company.json`
- `misc-questions/q1-json/company_processed.json`
- `misc-questions/q1-json/CompanyTest.java` — `testLoadFromFile1, testLoadFromFile2, testSaveToFile, testMerge, testAll`
- `misc-questions/q1-json/Employee.java` — `getName, getSkills, setSkills, equals`

<a id="question-2"></a>
### misc-questions/q2-parsing — Single-digit arithmetic grammar

Keywords: Parsing Tokeniser recursive-descent arithmetic CFG validation

- `misc-questions/q2-parsing/readme.md`
- `misc-questions/q2-parsing/Parser.java` — `parseExp`
- `misc-questions/q2-parsing/ParserTest.java` — `testOneDigit, testMathOperation, testChainOfMathOperations, testChainOfMathOperationsMore, testInvalidTokens`
- `misc-questions/q2-parsing/Token.java`
- `misc-questions/q2-parsing/Tokeniser.java` — `next, takeNext, hasNext, isNextValid`

<a id="question-3"></a>
### misc-questions/q3-rbtree — Red-black tree balancing

Keywords: Trees RBT-insert RBT-balanced rotations recolouring red-uncle black-uncle

- `misc-questions/q3-rbtree/readme.md`
- `misc-questions/q3-rbtree/RBTree.java` — `testProp3, checkProp3, insertRecurse, insert, find, search, childrenLeaves, blackParentCount, setColour`
- `misc-questions/q3-rbtree/RBTreeTest.java` — `init, testProp3IsMet, testProp3IsNotMetAddErrorRightLeftNode, testProp3IsNotMetAddErrorLeftNode, testProp3IsNotMetAddErrorRightNode, testProp3IsNotMetAddErrorRightLastNode, testProp3RootRightChildAddError`

<a id="question-4"></a>
### misc-questions/q4-state-testing-bst — Character state machine and inverse preorder

Keywords: Design State Singleton Interfaces exceptions null testing Trees BST inverted-pre-order root-right-left

- `misc-questions/q4-state-testing-bst/readme.md`
- `misc-questions/q4-state-testing-bst/BST.java` — `insert, invertedPreOrder, inverted`
- `misc-questions/q4-state-testing-bst/BSTTest.java` — `init, testEmptyTree, testInvertedPreOrder1, testInvertedPreOrder2`
- `misc-questions/q4-state-testing-bst/Character.java` — `getState, setState`
- `misc-questions/q4-state-testing-bst/exceptions/NullCharacterException.java`
- `misc-questions/q4-state-testing-bst/exceptions/NullKeyEventException.java`
- `misc-questions/q4-state-testing-bst/ExceptionTest.java` — `init, testNullKeyException, testNullCharacterException`
- `misc-questions/q4-state-testing-bst/Graph.pdf`
- `misc-questions/q4-state-testing-bst/Key.java`
- `misc-questions/q4-state-testing-bst/Node.java`
- `misc-questions/q4-state-testing-bst/SquatState.java` — `getInstance, handleInput`
- `misc-questions/q4-state-testing-bst/StandState.java` — `getInstance, handle, handleInput, check`
- `misc-questions/q4-state-testing-bst/State.java` — `handleInput`
- `misc-questions/q4-state-testing-bst/StateTest.java` — `init, testAllStates, testStatesWithRandomKeys1, testStatesWithRandomKeys2`
- `misc-questions/q4-state-testing-bst/SuspendState.java` — `getInstance, handleInput`
- `misc-questions/q4-state-testing-bst/WalkState.java` — `getInstance, handleInput`

<a id="question-5"></a>
### misc-questions/q5-grammars — Balanced parentheses grammar

Keywords: Parsing CFG parentheses balanced-brackets nested concatenation

- `misc-questions/q5-grammars/readme.md`
- `misc-questions/q5-grammars/Parser.java` — `parseExp`
- `misc-questions/q5-grammars/ParserTest.java` — `testEmptyBrackets, testEmptyBracketsWithNextExp, testNonEmptyBrackets, testNonEmptyBracketsWithNextExp, testNestedExpressionsAndInvalidTokens`
- `misc-questions/q5-grammars/Token.java`
- `misc-questions/q5-grammars/Tokeniser.java` — `next, nextNext, takeNext, hasNext, isNextValid`

<a id="question-6"></a>
### misc-questions/q6-bst-testing — DNA search tree and branch coverage

Keywords: Trees BST-find BST-insert DNA one-child odd-children sum Testing branch-complete

- `misc-questions/q6-bst-testing/readme.md`
- `misc-questions/q6-bst-testing/BranchComplete.java` — `DNATreeCalc`
- `misc-questions/q6-bst-testing/BST.java` — `DNAGenerator, printDNA, find, insert, sum`
- `misc-questions/q6-bst-testing/BSTBranchCompleteTest.java` — `test`
- `misc-questions/q6-bst-testing/BSTTest.java` — `isSameIgnoringOrder, init, testNodeWithOddChildren, testNodeWithEvenChildren, testNonexistentNode, testHigherNodeWithOddChildren, testNodeWithNoChildren`
- `misc-questions/q6-bst-testing/example-tree.png`
- `misc-questions/q6-bst-testing/Node.java`

<a id="question-7"></a>
### misc-questions/q7-xml — Tree collection XML round-trip

Keywords: Persistence XML DOM attributes optional-elements dimension serialization load save

- `misc-questions/q7-xml/readme.md`
- `misc-questions/q7-xml/Dimension.java` — `getDiameter, getHeight, equals`
- `misc-questions/q7-xml/Tree.java` — `getKind, withKind, getDimension, withDimension, getColor, withColor, getTypes, addType, equals`
- `misc-questions/q7-xml/TreeCollection.java` — `getTrees, saveToFile, loadFromFile, equals, append`
- `misc-questions/q7-xml/TreesTest.java` — `testSave1, testLoad1, testSave2, testLoad2, testLoad3`

<a id="question-8"></a>
### misc-questions/q8-dp-testing/branchComplete — Short-circuit branch testing

Keywords: Testing branch-coverage OR AND short-circuit minimum-inputs

- `misc-questions/q8-dp-testing/branchComplete/readme.md`
- `misc-questions/q8-dp-testing/branchComplete/BranchComplete.java` — `findSomething`
- `misc-questions/q8-dp-testing/branchComplete/BranchCompleteTest.java` — `test`

<a id="question-9"></a>
### misc-questions/q8-dp-testing/parcel — Parcel transport design patterns

Keywords: Design Singleton transport strategy recipient identity state cost time weight

- `misc-questions/q8-dp-testing/parcel/readme.md`
- `misc-questions/q8-dp-testing/parcel/Parcel.java` — `getWeight, getAllowedDays, getStatus, setStatus, getSender, getRecipient`
- `misc-questions/q8-dp-testing/parcel/ParcelTest.java` — `init, test1, test2, test3, test4, test5, test6`
- `misc-questions/q8-dp-testing/parcel/PostOffice.java` — `registerParcel`
- `misc-questions/q8-dp-testing/parcel/Recipient.java` — `receive`
- `misc-questions/q8-dp-testing/parcel/Sender.java` — `order`
- `misc-questions/q8-dp-testing/parcel/Status.java` — `setStatus, isCalled`
- `misc-questions/q8-dp-testing/parcel/Transport.java`
- `misc-questions/q8-dp-testing/parcel/TransportOffice.java` — `getInstance, transportBy`

<a id="question-10"></a>
### misc-questions/q9-bst — Sum nodes with one child

Keywords: Trees BST oddNodeSum one-child odd-children recursion

- `misc-questions/q9-bst/readme.md`
- `misc-questions/q9-bst/BST.java` — `oddNodeSum, insert`
- `misc-questions/q9-bst/BSTTest.java` — `init, testOddNodeSumTreeSingleRightPath, testOddNodeSumTreeInLeftAndRightPaths, testOddNodeSumTreeInLeftAndRightPathsRootChildren, testOddNodeSumNoOdd, testOddNodeSumOnlyRoot`

<a id="question-11"></a>
### misc-questions/q10-parsing — Mutually recursive odd/even grammar

Keywords: Parsing CFG chart-parsing dynamic-programming odd even left-recursion

- `misc-questions/q10-parsing/readme.md`
- `misc-questions/q10-parsing/Parser.java` — `parseExp`
- `misc-questions/q10-parsing/ParserTest.java` — `testOneDigitNumbers, testOddStartingWithEven, testEvenStartingWithEven, testMoreNumbers, testInvalidTokens`
- `misc-questions/q10-parsing/Token.java`
- `misc-questions/q10-parsing/Tokeniser.java` — `getTokenAt, next, last, takeNext, takeLast, hasNext, isNextOrLastValid`

<a id="question-12"></a>
### misc-questions/q11-json — College JSON merge

Keywords: Persistence JSON Gson load save duplicate-students merge-courses

- `misc-questions/q11-json/readme.md`
- `misc-questions/q11-json/College.java` — `loadFromJsonFile, mergeStudents, saveToJsonFile, getName, setName, getStudents, setStudents, equals`
- `misc-questions/q11-json/college.json`
- `misc-questions/q11-json/college_processed.json`
- `misc-questions/q11-json/CollegeTest.java` — `testLoadFromFile1, testLoadFromFile2, testSaveToFile, testMerge, testAll`
- `misc-questions/q11-json/Student.java` — `getName, getCourses, setCourses, equals`

<a id="question-13"></a>
### misc-questions/q12-uml-state-testing — Vending machine states

Keywords: Design UML State Singleton Interfaces vending-machine transitions Testing

- `misc-questions/q12-uml-state-testing/readme.md`
- `misc-questions/q12-uml-state-testing/diagrams.pdf`
- `misc-questions/q12-uml-state-testing/Event.java`
- `misc-questions/q12-uml-state-testing/Idle.java` — `handle`
- `misc-questions/q12-uml-state-testing/ReadyToCollect.java` — `handle`
- `misc-questions/q12-uml-state-testing/State.java` — `handle, getMachine`
- `misc-questions/q12-uml-state-testing/StateTest.java` — `init, testNormalWorkflow, testCancel1, testCancel2, testTimeout1, testTimeout2`
- `misc-questions/q12-uml-state-testing/VendingMachine.java` — `getState, setState`
- `misc-questions/q12-uml-state-testing/WaitingToDispense.java` — `handle`
- `misc-questions/q12-uml-state-testing/WaitingToPay.java` — `handle`
- `misc-questions/q12-uml-state-testing/WaitingToSelect.java` — `handle`

<a id="question-14"></a>
### misc-questions/q13-iterator — Grocery custom iterator

Keywords: Design Iterator Interfaces hasNext next filtering fruits collection

- `misc-questions/q13-iterator/readme.md`
- `misc-questions/q13-iterator/Fruit.java`
- `misc-questions/q13-iterator/GreenGrocery.java` — `getFruits, restock, getIterator, hasNext, next`
- `misc-questions/q13-iterator/Grocery.java` — `getIterator, restock`
- `misc-questions/q13-iterator/GroceryTest.java` — `test`
- `misc-questions/q13-iterator/Iterator.java` — `hasNext, next`

<a id="question-15"></a>
### misc-questions/q14-xml — Students and courses XML

Keywords: Persistence XML DOM attributes optional-elements courses grade load save

- `misc-questions/q14-xml/readme.md`
- `misc-questions/q14-xml/Course.java` — `getName, setName, getGrade, setGrade, equals`
- `misc-questions/q14-xml/Student.java` — `getName, withName, getAge, withAge, getHeight, withHeight, getWeight, withWeight, getCourses, addCourse, equals`
- `misc-questions/q14-xml/StudentCollection.java` — `getStudents, saveToFile, loadFromFile, equals, append`
- `misc-questions/q14-xml/StudentsTest.java` — `testSave1, testLoad1, testSave2, testLoad2, testLoad3`

<a id="question-16"></a>
### misc-questions/q15-facade — Calculator facade

Keywords: Design Facade Interfaces arithmetic divide-by-zero Operation

- `misc-questions/q15-facade/readme.md`
- `misc-questions/q15-facade/Addition.java` — `evaluate`
- `misc-questions/q15-facade/Calculator.java` — `add, subtract, multiply, divide`
- `misc-questions/q15-facade/CalculatorTest.java` — `test1, test2`
- `misc-questions/q15-facade/Division.java` — `evaluate`
- `misc-questions/q15-facade/Multiplication.java` — `evaluate`
- `misc-questions/q15-facade/Operation.java` — `evaluate`
- `misc-questions/q15-facade/Subtraction.java` — `evaluate`

<a id="question-17"></a>
### past-exams/2019-1/Q2 — LOGO turtle parsing and Makefile

Keywords: Parsing Tokenizer turtle LOGO FORWARD BACK PENUP PENDOWN screen trace Makefile build

- `past-exams/2019-1/Q2/Demo.java` — `main`
- `past-exams/2019-1/Q2/Direction.java`
- `past-exams/2019-1/Q2/OutOfScreenException.java`
- `past-exams/2019-1/Q2/Parser.java` — `parse`
- `past-exams/2019-1/Q2/ParserTest.java` — `_checkVisistedPositions, _checkUnvisistedPositions, testParserWithExampleGivenInExamPaper, testParserWithLotsOfRotation`
- `past-exams/2019-1/Q2/Pointer.java` — `turnLeft, turnRight`
- `past-exams/2019-1/Q2/Position.java`
- `past-exams/2019-1/Q2/Screen.java` — `markVisistedPos, trace, getPointerIcon`
- `past-exams/2019-1/Q2/ScreenTest.java` — `testInitialScreenWithUpwardAndPenUp, testScreenWithMarkedPositionAndInitialPenDownAndDownwardDirection`
- `past-exams/2019-1/Q2/Token.java`
- `past-exams/2019-1/Q2/Tokenizer.java` — `next, takeNext, hasNext`
- `past-exams/2019-1/Q2/TokenizerTest.java` — `testAllCommands`

<a id="question-18"></a>
### past-exams/2019-1/Q3 — String-key BST

Keywords: Trees BST-find BST-insert pre-order odd-children printOddNodes

- `past-exams/2019-1/Q3/BST.java` — `find, insert, printOddNodes`
- `past-exams/2019-1/Q3/BSTTest.java` — `testSimple, testPrintOddNodes`

<a id="question-19"></a>
### past-exams/2019-1/Q4 — Integer parser and newline testing

Keywords: Testing statement-coverage branch-coverage exceptions parseInt collapseNewlines JUnit5

- `past-exams/2019-1/Q4/MyInteger.java` — `parseInt`
- `past-exams/2019-1/Q4/MyIntegerTest.java`
- `past-exams/2019-1/Q4/StringUtil.java` — `collapseNewlines`
- `past-exams/2019-1/Q4/StringUtilTest.java`

<a id="question-20"></a>
### past-exams/2019-2/Q2 — Integer BST deletion and child-count sums

Keywords: Trees BST-find BST-delete successor two-children sumEvenNodes even-children

- `past-exams/2019-2/Q2/BST.java` — `find, delete, sumEvenNodes, insert`
- `past-exams/2019-2/Q2/Task1Test.java` — `constructTree, testFindTrueSimple, testFindFalseSimple, testFindTrueComplex, testFindFalseComplex`
- `past-exams/2019-2/Q2/Task2Test.java` — `preOrderTraversal, constructTree, deleteSimpleTest1, deleteSimpleTest2, deleteComplexTest1, deleteComplexTest2`
- `past-exams/2019-2/Q2/Task3Test.java` — `constructTree, testSimpleSum1, testComplexSum1`

<a id="question-21"></a>
### past-exams/2019-2/Q3 — String utilities coverage

Keywords: Testing parseDouble isMixedCase short-circuit branch-coverage statement-coverage

- `past-exams/2019-2/Q3/MyStringUtil.java` — `isMixedCase`
- `past-exams/2019-2/Q3/MyStringUtilTest.java` — `test`
- `past-exams/2019-2/Q3/MyUtil.java` — `parseDouble`
- `past-exams/2019-2/Q3/MyUtilTest.java` — `test`

<a id="question-22"></a>
### past-exams/2019-2/Q4 — LOGO boundary movement

Keywords: Parsing Tokenizer turtle LOGO FORWARD_TO_END BACK_TO_END screen trace

- `past-exams/2019-2/Q4/Direction.java`
- `past-exams/2019-2/Q4/OutOfScreenException.java`
- `past-exams/2019-2/Q4/Parser.java` — `parse`
- `past-exams/2019-2/Q4/ParserTest.java` — `_checkScreen, testParserWithExampleGivenInExamPaper, testParserWithLotsOfRotation, testParserWithFORWARD`
- `past-exams/2019-2/Q4/Pointer.java` — `turnLeft, turnRight`
- `past-exams/2019-2/Q4/Position.java`
- `past-exams/2019-2/Q4/Screen.java` — `markVisistedPos, trace`
- `past-exams/2019-2/Q4/ScreenTest.java` — `testInitialScreenWithNorthAndPenUp, testScreenWithMarkedPositionAndInitialPenDownAndSouth`
- `past-exams/2019-2/Q4/Token.java`
- `past-exams/2019-2/Q4/Tokenizer.java` — `next, current, hasNext`
- `past-exams/2019-2/Q4/TokenizerTest.java` — `testAllCommands`

<a id="question-23"></a>
### past-exams/2020-1/Q1 — Three-colour tree

Keywords: Trees ThreeColourTree insert colour colour-ordering recursion

- `past-exams/2020-1/Q1/Colour.java`
- `past-exams/2020-1/Q1/ThreeColourTree.java` — `testProp1, checkProp1, testProp2, checkProp2, testProp3, checkProp3, testProp4, checkProp4, testProp5, checkProp5, insertRecurse, insert, find, search, childrenLeaves, colorCount, setColour, toString`
- `past-exams/2020-1/Q1/ThreeColourTreeTest.java` — `init, test1, test2, test3, test4, test5`

<a id="question-24"></a>
### past-exams/2020-1/Q3 — Coverage of number-theory code

Keywords: Testing branch-coverage gcd lcm remainder minimum-inputs

- `past-exams/2020-1/Q3/Something.java` — `method1, method2, method3, someMethod`
- `past-exams/2020-1/Q3/SomethingTest.java` — `test`

<a id="question-25"></a>
### past-exams/2020-1/Q4 — SQL INSERT and XML customer table

Keywords: Parsing SQL INSERT VALUES columns validation Persistence XML DOM load save optional-elements

- `past-exams/2020-1/Q4/Customer.java` — `getId, setId, getName, setName, getAddress, setAddress, getCity, setCity, getPostCode, setPostCode, getCountry, setCountry, equals, toString`
- `past-exams/2020-1/Q4/FileUtil.java` — `getTableFileName`
- `past-exams/2020-1/Q4/Parser.java` — `parseExp`
- `past-exams/2020-1/Q4/ParserTest.java` — `tearDown, testWithOneCommand, testWithTwoCommands, testWithWrongColumnNames`
- `past-exams/2020-1/Q4/Token.java`
- `past-exams/2020-1/Q4/Tokeniser.java` — `next, takeNext, hasNext`
- `past-exams/2020-1/Q4/TokeniserTest.java` — `assertToken, assertNull, testWithPartialColumns, testWithFullColumns, testWithoutBrackets`
- `past-exams/2020-1/Q4/XMLTable.java` — `save, load, insert`
- `past-exams/2020-1/Q4/XMLTableTest.java` — `tearDown, testWithSingleCustomer, testWithMultipleCustomers1, testWithMultipleCustomers2`

<a id="question-26"></a>
### past-exams/2020-2/Q1 — Word tokenization into red-black tree

Keywords: Parsing uppercase lowercase camel-case numbers punctuation Trees RBT-insert word-length grouping

- `past-exams/2020-2/Q1/README.md`
- `past-exams/2020-2/Q1/Color.java`
- `past-exams/2020-2/Q1/MyTokenizer.java` — `next, current, hasNext`
- `past-exams/2020-2/Q1/MyTokenizerTest.java` — `testLowerCaseTokenizer, testShortCamelCaseTokenizer, testLongCamelCaseTokenizer, testUpperCaseTokenizer, testIntegerTokenizer, testNonAlphanumericTokenizer, testSentenceTokenizer`
- `past-exams/2020-2/Q1/Node.java`
- `past-exams/2020-2/Q1/RBTree.java` — `insertRecurse, insert, rotateLeft, rotateRight, find, search, getData`
- `past-exams/2020-2/Q1/Token.java` — `getValue, getType, getLength`
- `past-exams/2020-2/Q1/Tokenizer.java`
- `past-exams/2020-2/Q1/TreeBuilder.java` — `build`
- `past-exams/2020-2/Q1/TreeBuilderTest.java` — `testBuildUpperCase`

<a id="question-27"></a>
### past-exams/2020-2/Q2 — Repository and singleton testing

Keywords: Testing Design Repository Singleton identity persistence Person SequenceGenerator

- `past-exams/2020-2/Q2/README.md`
- `past-exams/2020-2/Q2/Person.java` — `getId, setId, getName, getAge, getOccupation, getDiabetes, getHeartDisease, getHealthInsurancePrice, calcInsurancePrice`
- `past-exams/2020-2/Q2/PersonRepository.java` — `save, findById, setSequenceGenerator`
- `past-exams/2020-2/Q2/PersonRepositoryTest.java` — `before, findByIdTest, setSequenceGeneratorTest, saveTest`
- `past-exams/2020-2/Q2/PersonTest.java` — `setUp, getIdTest, setIDTest, getAgeTest, getNameTest, getOccupationTest, getDiabetesTest, getHeartDiseaseTest, getHealthInsurancePriceTest`
- `past-exams/2020-2/Q2/SequenceGenerator.java` — `nextVal`

<a id="question-28"></a>
### past-exams/2020-2/Q3 — CSV to red-black tree to XML

Keywords: Persistence CSV parsing semicolon delimiter header XML DOM Trees RBT level-order BFS right-to-left

- `past-exams/2020-2/Q3/README.md`
- `past-exams/2020-2/Q3/Application.java` — `createTree, readCsv, saveXML`
- `past-exams/2020-2/Q3/ApplicationTest.java` — `before, testCreateTreeEmptyList, testCreateTree, testReadCsv, testSaveXml`
- `past-exams/2020-2/Q3/Color.java`
- `past-exams/2020-2/Q3/Node.java` — `getKey, getData`
- `past-exams/2020-2/Q3/people.xml`
- `past-exams/2020-2/Q3/Person.java` — `getId, setId, getName, setName, getAge, setAge, getOccupation, setOccupation`
- `past-exams/2020-2/Q3/RBTree.java` — `insertRecurse, insert, rotateLeft, rotateRight, preorder, inorder, postorder, preOrderHelper, inOrderHelper, postOrderHelper, find, search, getData, levelTraversal`
- `past-exams/2020-2/Q3/RBTreeLevelTraversalTest.java` — `emptyTree, singleNodeSkipsSentinelChildren, visitsLevelsFromRightToLeft`

<a id="question-29"></a>
### past-exams/2021-2/q1 — Boolean short-circuit testing

Keywords: Testing branch-coverage OR AND short-circuit minimum-inputs

- `past-exams/2021-2/q1/readme.md`
- `past-exams/2021-2/q1/BranchComplete.java` — `findSomething`
- `past-exams/2021-2/q1/BranchCompleteTest.java` — `test`

<a id="question-30"></a>
### past-exams/2021-2/q2 — LOAD/SAVE XML command interpreter

Keywords: Parsing CFG LOAD FROM SAVE TO commands Design Singleton Persistence XML DOM database

- `past-exams/2021-2/q2/README.md`
- `past-exams/2021-2/q2/Command.java`
- `past-exams/2021-2/q2/DataBase.java` — `getInstance, save, load, clear`
- `past-exams/2021-2/q2/example.xml`
- `past-exams/2021-2/q2/Executor.java` — `execute, saveTo, loadFrom, getCommands`
- `past-exams/2021-2/q2/ExecutorTest.java` — `init, destruct, testSave, testSaveLoad, testComplex, execute, personsCompare`
- `past-exams/2021-2/q2/LoadCommand.java` — `getKey, setKey, getFileName, setFileName`
- `past-exams/2021-2/q2/Parser.java` — `parseCmds, require`
- `past-exams/2021-2/q2/ParserTest.java` — `testLoad, testSave, testComplex`
- `past-exams/2021-2/q2/Person.java` — `getName, getGender, getAge, getOccupation, setName, setGender, setAge, setOccupation, equals`
- `past-exams/2021-2/q2/SaveCommand.java` — `getKey, setKey, getFileName, setFileName`
- `past-exams/2021-2/q2/Token.java` — `getType, getValue, equals`
- `past-exams/2021-2/q2/Tokeniser.java` — `next, current, hasNext`
- `past-exams/2021-2/q2/TokeniserTest.java` — `generalTest, testLoad, testSave, testComplex`

<a id="question-31"></a>
### past-exams/2021-2/q3 — Parcel ordering and search tree

Keywords: Trees BST-find BST-insert traversal filter Comparable compareTo distance parcels

- `past-exams/2021-2/q3/readme.md`
- `past-exams/2021-2/q3/BinarySearchTree.java` — `min, max, find, insert, isEmpty, listToTree, listToTreeDirectInOrder`
- `past-exams/2021-2/q3/EmptyTree.java` — `insert, min, max, find, getHeight, toString, display`
- `past-exams/2021-2/q3/parcel/CartesianCoordinate.java` — `getX, getY, getDistance, toString`
- `past-exams/2021-2/q3/parcel/DistanceFormula.png`
- `past-exams/2021-2/q3/parcel/Parcel.java` — `getId, getWeight, getAllowedDays, getSender, getRecipient, compareTo, toString`
- `past-exams/2021-2/q3/parcel/ParcelExample1.png`
- `past-exams/2021-2/q3/parcel/ParcelExample2.png`
- `past-exams/2021-2/q3/parcel/ParcelGeneral.png`
- `past-exams/2021-2/q3/parcel/Person.java` — `getLocation, setLocation, toString`
- `past-exams/2021-2/q3/parcel/Recipient.java`
- `past-exams/2021-2/q3/parcel/Sender.java`
- `past-exams/2021-2/q3/ParcelBST.java` — `iterator, hasNext, next`
- `past-exams/2021-2/q3/ParcelTreeTest.java` — `getRecipient, getSender, initTestVariables, parcelOrderTest1, parcelOrderTest2, parcelOrderTest3, parcelOrderTest4, parcelOderTest5, parcelOrderTest6, parcelOrderTest7, condenseParcelListToString, iteratorTestHelper, iteratorTest1, iteratorTest2, iteratorTest3, iteratorTest4`
- `past-exams/2021-2/q3/Tree.java` — `min, max, find, insert, insertAll, getHeight, toString, display, inOrder, treeToListInOrder, isEmpty`

<a id="question-32"></a>
### past-exams/2021-2/q4 — Reliable and efficient software essay

Keywords: Written Design Testing performance profiling maintainability refactoring contracts data-structures

- `past-exams/2021-2/q4/readme.md`
- `past-exams/2021-2/q4/answer.md`

<a id="question-33"></a>
### past-exams/2021-2/q5 — Android activity lifecycle essay

Keywords: Written Android onCreate onStart onResume onPause onStop onRestart onDestroy state-restoration

- `past-exams/2021-2/q5/readme.md`
- `past-exams/2021-2/q5/answer.md`

<a id="question-34"></a>
### past-exams/2022-1/q1 — Game state and XML transition log

Keywords: Design State Singleton Interfaces game transitions null exceptions Persistence XML DOM state-log Testing

- `past-exams/2022-1/q1/readme.md`
- `past-exams/2022-1/q1/Character.java` — `getState, setState`
- `past-exams/2022-1/q1/Constants.java`
- `past-exams/2022-1/q1/CrawlState.java` — `getInstance, handleInput`
- `past-exams/2022-1/q1/example.xml`
- `past-exams/2022-1/q1/exceptions/NullCharacterException.java`
- `past-exams/2022-1/q1/exceptions/NullKeyEventException.java`
- `past-exams/2022-1/q1/ExceptionTest.java` — `init, testNullKeyException, testNullCharacterException`
- `past-exams/2022-1/q1/Graph.pdf`
- `past-exams/2022-1/q1/Key.java`
- `past-exams/2022-1/q1/LieProneState.java` — `getInstance, handleInput`
- `past-exams/2022-1/q1/RunState.java` — `getInstance, handleInput`
- `past-exams/2022-1/q1/ShootState.java` — `getInstance, handleInput`
- `past-exams/2022-1/q1/StandState.java` — `getInstance, handleInput`
- `past-exams/2022-1/q1/State.java` — `handleInput`
- `past-exams/2022-1/q1/states.xml`
- `past-exams/2022-1/q1/StateTest.java` — `init, testAllStates, testStatesWithRandomKeys1, testStatesWithRandomKeys2, testWriteXML, testReadXML`
- `past-exams/2022-1/q1/XMLProcessor.java` — `read, write`

<a id="question-35"></a>
### past-exams/2022-1/q2 — Delivery quote strategies

Keywords: Design Strategy Interfaces inheritance quote weight distance ceiling safety illegal-items

- `past-exams/2022-1/q2/readme.md`
- `past-exams/2022-1/q2/CompanyA.java` — `calculateQuote`
- `past-exams/2022-1/q2/CompanyB.java` — `calculateQuote`
- `past-exams/2022-1/q2/ExpressCompany.java` — `handle, safetyCheckOnItems, calculateDistance, calculateQuote`
- `past-exams/2022-1/q2/IllegalParcelItemException.java`
- `past-exams/2022-1/q2/ItemType.java`
- `past-exams/2022-1/q2/Parcel.java` — `getWeight, getDestination, getItems`
- `past-exams/2022-1/q2/ParcelHandler.java` — `safetyCheckOnItems, calculateQuote`
- `past-exams/2022-1/q2/ParcelTest.java` — `init, testBestQuote1, testBestQuote2, testBestQuote3, testIllegalParcelItemException`
- `past-exams/2022-1/q2/Point.java`
- `past-exams/2022-1/q2/Quote.java` — `getCompany, getQuote, equals, toString`
- `past-exams/2022-1/q2/QuoteCalculator.java` — `bestQuote`

<a id="question-36"></a>
### past-exams/2022-1/q3 — BST memory command interpreter

Keywords: Trees BST-find inverted-pre-order Parsing LOAD SAVE SUM wildcard pattern no-regex memory interpreter

- `past-exams/2022-1/q3/readme.md`
- `past-exams/2022-1/q3/BST.java` — `insert, find, invertedPreOrder`
- `past-exams/2022-1/q3/BSTTest.java` — `init, testEmptyTree, testFind, testFindNull, testInvertedPreOrder`
- `past-exams/2022-1/q3/Command.java`
- `past-exams/2022-1/q3/Executor.java` — `execute, load, save, sum, getCommands`
- `past-exams/2022-1/q3/ExecutorTest.java` — `execute, testLoadNull, testSaveLoad1, testSaveLoad2, testSum, testSaveSum, testComplex1, testComplex2, testComplex3, testComplex4`
- `past-exams/2022-1/q3/LoadCommand.java` — `getKey`
- `past-exams/2022-1/q3/Node.java`
- `past-exams/2022-1/q3/NodeCopy.java` — `equals, toString`
- `past-exams/2022-1/q3/Parser.java` — `parseCmds, take`
- `past-exams/2022-1/q3/ParserTest.java` — `testLoad, testSave, testSum, testComplex`
- `past-exams/2022-1/q3/SaveCommand.java` — `getKey, getValue`
- `past-exams/2022-1/q3/SumCommand.java` — `getPattern, getKey`
- `past-exams/2022-1/q3/Token.java` — `getType, getValue, equals`
- `past-exams/2022-1/q3/Tokeniser.java` — `next, current, hasNext`
- `past-exams/2022-1/q3/TokeniserTest.java` — `generalTest, testLoad, testSave, testSum, testComplex`

<a id="question-37"></a>
### past-exams/2022-1/q4 — Calculator design and licensing critique

Keywords: Written Design Strategy Interfaces SOLID DIP OCP refactoring overflow exponentiation IP licensing original-flawed-code

- `past-exams/2022-1/q4/readme.md`
- `past-exams/2022-1/q4/answer.md`
- `past-exams/2022-1/q4/Add.java` — `getA, getB, calculate`
- `past-exams/2022-1/q4/Client.java` — `compute`
- `past-exams/2022-1/q4/Divide.java` — `getA, getB, calculate`
- `past-exams/2022-1/q4/Exponentiate.java` — `getA, getB, calculate`
- `past-exams/2022-1/q4/Multiply.java` — `getA, getB, calculate`
- `past-exams/2022-1/q4/Subtract.java` — `getA, getB, calculate`

<a id="question-38"></a>
### past-exams/2023-1/Q1 — Escape-room state and observer

Keywords: Design State Observer Interfaces GameMaster HelpState Riddle Testing branch-coverage short-circuit

- `past-exams/2023-1/Q1/Q1README.md`
- `past-exams/2023-1/Q1/EscapedState.java` — `solveRiddle`
- `past-exams/2023-1/Q1/GameMaster.java` — `updateHelp, updateEscape, hasAskedForHelp, hasEscaped`
- `past-exams/2023-1/Q1/HelpState.java` — `solveRiddle`
- `past-exams/2023-1/Q1/InProgressState.java` — `solveRiddle`
- `past-exams/2023-1/Q1/Observer.java`
- `past-exams/2023-1/Q1/ObserverTest.java` — `setup, testObserverNotifiedWhenAskingForHelp, testObserverNotNotifiedBeforeEscape, testObserverNotifiedAfterEscape`
- `past-exams/2023-1/Q1/Participant.java` — `registerObserver, askForHelp, solveRiddle, getState, getRiddle`
- `past-exams/2023-1/Q1/ParticipantState.java`
- `past-exams/2023-1/Q1/ParticipantTest.java` — `setup, testSolveRiddle1, testSolveRiddle2, testAskForHelp, testSolveAllRiddles, testCannotSolveRiddleAfterEscape`
- `past-exams/2023-1/Q1/Riddle.java` — `askQuestion, checkAnswer, isSolved, setSolved, getAnswer`
- `past-exams/2023-1/Q1/RiddleCheckAnswerTest.java` — `tests`
- `past-exams/2023-1/Q1/RiddleException.java`
- `past-exams/2023-1/Q1/UML.png`

<a id="question-39"></a>
### past-exams/2023-1/Q2 — Markdown list parser and n-ary tree

Keywords: Persistence file-reading Markdown Parsing Tokenizer indentation ordered-list unordered-list Trees n-ary pre-order stack

- `past-exams/2023-1/Q2/Q2README.md`
- `past-exams/2023-1/Q2/data/data0A.md`
- `past-exams/2023-1/Q2/data/data0B.md`
- `past-exams/2023-1/Q2/data/data1.md`
- `past-exams/2023-1/Q2/data/data2.md`
- `past-exams/2023-1/Q2/data/data3.md`
- `past-exams/2023-1/Q2/ListElementsTree.java` — `insert, preOrderWalk, insertTree, getChildren, getValue`
- `past-exams/2023-1/Q2/ListElementsTreeTest.java` — `testBasicPreOrderWalk0A, testBasicPreOrderWalkData1, testBasicPreOrderWalkData2FLAT`
- `past-exams/2023-1/Q2/MDFileReader.java` — `read`
- `past-exams/2023-1/Q2/MDFileReaderTest.java` — `basicTestData0`
- `past-exams/2023-1/Q2/MDParser.java` — `parse`
- `past-exams/2023-1/Q2/MDParserTest.java` — `indentationDeterminesParentsAndPreorder, blankInputHasNoListItems`
- `past-exams/2023-1/Q2/MDToken.java` — `toString, getLevel, getContent, getTokenType, equals`
- `past-exams/2023-1/Q2/MDTokenizer.java` — `hasNext, next, getCurrent`
- `past-exams/2023-1/Q2/MDTokenizerTest.java` — `testTokenizeData0A, testTokenizeData1, testTokenizeData2`
- `past-exams/2023-1/Q2/MDTokenType.java`
- `past-exams/2023-1/Q2/MDTree_Example.png`
- `past-exams/2023-1/Q2/MDTree_Example_Walk.png`

<a id="question-40"></a>
### past-exams/2023-1/Q3 — MDToken SOLID critique

Keywords: Written SOLID SRP OCP refactoring rendering immutability equality hashCode

- `past-exams/2023-1/Q3/Q3README.md`
- `past-exams/2023-1/Q3/Q3_answer.md`

<a id="question-41"></a>
### past-exams/2023-2/src/Q1 — Knowledge graph query

Keywords: Parsing SELECT WHERE CFG token-validation Persistence XML DOM triples subject predicate object filtering

- `past-exams/2023-2/src/Q1/readme_Q1.md`
- `past-exams/2023-2/src/Q1/assets/graphdb2.png`
- `past-exams/2023-2/src/Q1/assets/triple.png`
- `past-exams/2023-2/src/Q1/assets/triples0.xml`
- `past-exams/2023-2/src/Q1/assets/triples1.xml`
- `past-exams/2023-2/src/Q1/QueryParser.java` — `parse`
- `past-exams/2023-2/src/Q1/QueryToken/QToken.java` — `getqTokenType, getValue, setQTokenType, setElemType, setValue, toString`
- `past-exams/2023-2/src/Q1/QueryToken/QTokenType.java`
- `past-exams/2023-2/src/Q1/QueryTokenizer.java` — `hasNext, getSelectTokenIfValid, whereIsValid, next`
- `past-exams/2023-2/src/Q1/Triples/Triple.java` — `getSubject, getPredicate, getObject, toString, equals, hashCode`
- `past-exams/2023-2/src/Q1/Triples/TripleComponent.java` — `toString, setTripleComponentType, getValue, equals, hashCode`
- `past-exams/2023-2/src/Q1/Triples/TripleReader.java` — `read`

<a id="question-42"></a>
### past-exams/2023-2/src/Q2 — Minimum-height decision tree

Keywords: Trees decision-tree classify recursion height Design Factory polymorphism optimal memoization

- `past-exams/2023-2/src/Q2/readme_Q2.md`
- `past-exams/2023-2/src/Q2/ClassificationTests.java` — `zeroLevelTreeClassification, oneLevelTreeClassification, oneLevelDistractorTreeClassification, twoLevelTreeClassification, degenerateTreeClassification, largeTreeClassification, oneLevelTreeFormatting, twoLevelTreeFormatting, degenerateTreeFormatting, largeTreeFormatting, zeroLevelTreeCreation, oneLevelTreeCreation, oneLevelDistractorTreeCreation, twoLevelTreeCreation, completeTreeCreation, testAllClassifiedCorrectly`
- `past-exams/2023-2/src/Q2/ClassifierFactory.java` — `createClassifier, build`
- `past-exams/2023-2/src/Q2/DecisionNode.java` — `maximumDecisions, classify, toString, describe`
- `past-exams/2023-2/src/Q2/Node.java` — `maximumDecisions, classify`
- `past-exams/2023-2/src/Q2/Spider.java` — `propertyToString, testProperty, toString`
- `past-exams/2023-2/src/Q2/TerminalNode.java` — `maximumDecisions, classify, getOutcome`

<a id="question-43"></a>
### past-exams/2023-2/src/Q3 — Penguin importers and user interfaces

Keywords: Written Design Strategy Factory Adapter Interfaces SOLID ISP LSP DIP OCP JSON XML CSV

- `past-exams/2023-2/src/Q3/readme_Q3.md`
- `past-exams/2023-2/src/Q3/answer_Q3.md`
- `past-exams/2023-2/src/Q3/UML_Example_PenguinologistClass.png`
- `past-exams/2023-2/src/Q3/UML_Q3.png`

<a id="question-44"></a>
### past-exams/2023-2/src/Tests — Knowledge-graph tests

Keywords: Testing SELECT WHERE triples tokenization query XML

- `past-exams/2023-2/src/Tests/QTokenizerTest.java` — `getAllTokens, tokenizeT0selectAll, tokenizeT0selectMatchS, tokenizeT0selectMatchP, tokenizeT1DoubleSubject, tokenizeInvalidOatS`
- `past-exams/2023-2/src/Tests/QueryTest.java` — `parseT0selectAll, parseT0selectMatchS, parseInvalidMultiplePredicates, parseT0selectMatchP, parseT1selectAll, compare, assertStrsEqual`
- `past-exams/2023-2/src/Tests/TripleReaderTest.java` — `readTriples0Size, readTriples0Content, readTriples1Size, readTriples1Content`

<a id="question-45"></a>
### past-exams/2024-1/src/Q1 — Animal factory method and template

Keywords: Design Factory-Method Template-Method Interfaces abstract-class inheritance super constructor UUID names defaults

- `past-exams/2024-1/src/Q1/Q1README.md`
- `past-exams/2024-1/src/Q1/Animal.java` — `getId, getName, getAge, getLevel, toString`
- `past-exams/2024-1/src/Q1/AnimalCreator.java` — `createAnimal, getNextName, createAnimalTemplate, createBatch`
- `past-exams/2024-1/src/Q1/Dog.java` — `speak`
- `past-exams/2024-1/src/Q1/DogCreator.java` — `getNextName, getRandomName, createAnimal`
- `past-exams/2024-1/src/Q1/FactoryTest.java` — `withDogCreator_whenGetNextName_thenReturnsName, withDogCreator_whenGetNextName_thenReturnsName_multiple, withDogCreator_whenCreateAnimal_thenDogHasFieldsSetCorrectly, withDogCreator_whenCreateAnimalWithNullAge_thenDogHasFieldsSetCorrectly, withDogCreator_whenCreateBatch_ThenDogsSetUpCorrectly, withDogCreator_whenCreateAnimalTemplate_ThenDogSetUpCorrectly`
- `past-exams/2024-1/src/Q1/Penguin.java` — `speak`
- `past-exams/2024-1/src/Q1/PenguinCreator.java` — `getNextName, getRandomName, createAnimal`

<a id="question-46"></a>
### past-exams/2024-1/src/Q2 — AVL rotations and black-box tests

Keywords: Trees AVL-insert AVL-balanced LL LR RL RR leftRotate rightRotate immutable Testing parameterized mutation intentionally-faulty-SampleAVLTree

- `past-exams/2024-1/src/Q2/Q2README.md`
- `past-exams/2024-1/src/Q2/AVLTreeTest.java` — `testTreePreorder, data, createTree, createTreeNode`
- `past-exams/2024-1/src/Q2/MockClasses/AVLTree.java` — `leftRotate, rightRotate, createNode, insert, getBalanceFactor, getHeight, toString, display, preOrder, treeToListPreOrder, getValue, setValue`
- `past-exams/2024-1/src/Q2/MockClasses/ReferenceAVLTree.java` — `createNode, insert`
- `past-exams/2024-1/src/Q2/MockClasses/SampleAVLTree.java` — `createNode, insert`
- `past-exams/2024-1/src/Q2/ReferenceAVLTest.java` — `allFourRotationsPreserveOriginal, nestedInsertionKeepsEverySubtreeBalanced, check`
- `past-exams/2024-1/src/Q2/TreeNodeTestRule.java` — `createTreeNode, apply, evaluate`

<a id="question-47"></a>
### past-exams/2024-1/src/Q3 — Word-processor token validation

Keywords: Parsing Tokeniser TYPE UNDO REDO OCCURRENCES CAPITALISE invalid-input

- `past-exams/2024-1/src/Q3/Q3README.md`
- `past-exams/2024-1/src/Q3/InputToken.java` — `getType, getValue, setValue, toString`
- `past-exams/2024-1/src/Q3/Parser.java` — `getAllTokens`
- `past-exams/2024-1/src/Q3/Tokeniser.java` — `getCurrentToken, next, isEmpty`
- `past-exams/2024-1/src/Q3/TokeniserParserTest.java` — `tokenise_TYPE, tokenise_OCCURRENCE, tokenise_UNDO, tokenise_SEPARATOR, tokenise_CAPITALISE, getAllTokens_typing, getAllTokens_typeAndOccurrence, getAllTokens_typeAndUndo, getAllTokens_redo`
- `past-exams/2024-1/src/Q3/TokenType.java` — `getStr`

<a id="question-48"></a>
### past-exams/2024-1/src/Q4 — Fourteen MCQs

Keywords: MCQ Software-Construction Testing branch-count IP Trees BST-height RBT-insert Parsing Ethics UML SOLID OCP Refactoring Android CFG

- `past-exams/2024-1/src/Q4/Q4README.md`
- `past-exams/2024-1/src/Q4/MCQAnswerSyntaxTest.java` — `setUp, testBasicSyntax, testNoRepeatInRange, testAnswersOrdered, parseAnswer`
- `past-exams/2024-1/src/Q4/Q4Answers.txt`
- `past-exams/2024-1/src/Q4/UML-MCQ9.png`

<a id="question-49"></a>
### past-exams/2024-2/src/Q1 — BST custom iterator

Keywords: Trees BST-insert BST-find iteration Design Iterator Interfaces collection traversal

- `past-exams/2024-2/src/Q1/Q1README.md`
- `past-exams/2024-2/src/Q1/BST.java` — `insert, insertAll, createIterator, display, hasNext, next, size`
- `past-exams/2024-2/src/Q1/IterableCollection.java`
- `past-exams/2024-2/src/Q1/Iterator.java`
- `past-exams/2024-2/src/Q1/Q1Test.java` — `createTree, createIterator, test_iterator_values, test_iterator_iter_size`

<a id="question-50"></a>
### past-exams/2024-2/src/Q2 — HashingBox black-box tests

Keywords: Testing parameterized mutation boundary-values exceptions hash prime ASCII material shape intentionally-faulty-implementations

- `past-exams/2024-2/src/Q2/Q2README.md`
- `past-exams/2024-2/src/Q2/ComponentOutOfRangeException.java`
- `past-exams/2024-2/src/Q2/HashingBox.java` — `hash`
- `past-exams/2024-2/src/Q2/HashingBox0.java` — `hash, hashName, hashSize, hashMaterialShape`
- `past-exams/2024-2/src/Q2/HashingBox1.java` — `hashName, hashSize, hashMaterialShape`
- `past-exams/2024-2/src/Q2/HashingBox10.java` — `hashName, hashSize, hashMaterialShape`
- `past-exams/2024-2/src/Q2/HashingBox11.java` — `hashName, hashSize, isPrime, hashMaterialShape`
- `past-exams/2024-2/src/Q2/HashingBox12.java` — `hashName, hashSize, isPrime, hashMaterialShape`
- `past-exams/2024-2/src/Q2/HashingBox2.java` — `hashName, hashSize, hashMaterialShape`
- `past-exams/2024-2/src/Q2/HashingBox3.java` — `hashName, hashSize, hashMaterialShape`
- `past-exams/2024-2/src/Q2/HashingBox4.java` — `hashName, hashSize, hashMaterialShape`
- `past-exams/2024-2/src/Q2/HashingBox5.java` — `hashName, hashSize, hashMaterialShape`
- `past-exams/2024-2/src/Q2/HashingBox6.java` — `hashName, hashSize, findLargestPrime, hashMaterialShape`
- `past-exams/2024-2/src/Q2/HashingBox7.java` — `hashName, case1, hashSize, hashMaterialShape`
- `past-exams/2024-2/src/Q2/HashingBox8.java` — `hashName, hashSize, hashMaterialShape`
- `past-exams/2024-2/src/Q2/HashingBox9.java` — `hashName, hashSize, hashMaterialShape`
- `past-exams/2024-2/src/Q2/Material.java` — `getValue`
- `past-exams/2024-2/src/Q2/Q2Test.java` — `getImplementations, validHashes, rejectsInvalidSizes, exampleTestCase`
- `past-exams/2024-2/src/Q2/Shape.java` — `getValue`
- `past-exams/2024-2/src/Q2/Thing.java` — `getName, getMaterial, getShape, getSize, equals, toString`

<a id="question-51"></a>
### past-exams/2024-2/src/Q3 — Git command grammar

Keywords: Parsing Tokeniser git add commit push paths separators invalid-input

- `past-exams/2024-2/src/Q3/Q3README.md`
- `past-exams/2024-2/src/Q3/GitCommand.java` — `setValue, toString`
- `past-exams/2024-2/src/Q3/GitToken.java` — `getType, getValue, setValue, toString`
- `past-exams/2024-2/src/Q3/GitTokenType.java` — `getStr`
- `past-exams/2024-2/src/Q3/Parser.java` — `parse`
- `past-exams/2024-2/src/Q3/Q3Test.java` — `tokenise_single_git, tokenise_single_separator, tokenise_single_path, tokenise_invalid, tokenise_invalid_partially, tokenise_add_tokens, parse_add, parse_commit, parse_push`
- `past-exams/2024-2/src/Q3/Tokeniser.java` — `getCurrentToken, next, hasNext, isEmpty`

<a id="question-52"></a>
### past-exams/2024-2/src/Q4 — Testing and refactoring essay

Keywords: Written Testing Refactoring regression ethics public-interest

- `past-exams/2024-2/src/Q4/Q4README.md`
- `past-exams/2024-2/src/Q4/Q4Answers.md`

<a id="question-53"></a>
### past-exams/2025-1/src/Q1 — Cooking state machine and recipes

Keywords: Design State Factory Interfaces cooking food recipes time ingredient

- `past-exams/2025-1/src/Q1/Q1README.md`
- `past-exams/2025-1/src/Q1/BurntState.java` — `getState, prepare`
- `past-exams/2025-1/src/Q1/Food.java` — `prepare, checkState, setState, setPrepTimeDone, getIngredient`
- `past-exams/2025-1/src/Q1/FoodFactory.java` — `getFood, getRawFood, getReadyFood, getBurntFood`
- `past-exams/2025-1/src/Q1/FoodState.java`
- `past-exams/2025-1/src/Q1/Ingredient.java` — `getPrepTime`
- `past-exams/2025-1/src/Q1/Kitchen.java` — `readyToCook, readyToServe, ingredientsRequired`
- `past-exams/2025-1/src/Q1/Q1Test.java` — `Q1a_1_readyToCook, Q1a_2_readyToServe, Q1a_3_ingredientsRequired_trivial, Q1a_4_ingredientsRequired_simple, Q1b_1_foodStates_basic, Q1b_2_foodStates_burnt`
- `past-exams/2025-1/src/Q1/RawState.java` — `getState, prepare`
- `past-exams/2025-1/src/Q1/ReadyState.java` — `getState, prepare`
- `past-exams/2025-1/src/Q1/Recipe.java` — `getName, setName, getIngredients, setIngredients`

<a id="question-54"></a>
### past-exams/2025-1/src/Q2 — Reverse-order family tree

Keywords: Trees BST-find BST-insert reverse-order duplicates ordering-invariant height family-labels display EmptyTree

- `past-exams/2025-1/src/Q2/Q2README.md`
- `past-exams/2025-1/src/Q2/EmptyTree.java` — `isOrdered, getLevelAndLabel, show, find, insert`
- `past-exams/2025-1/src/Q2/FamilyTree.java` — `find, isOrdered, orderedHelper, insert, getLevelAndLabel, show`
- `past-exams/2025-1/src/Q2/Node.java` — `getId, getLabel, setLabel`
- `past-exams/2025-1/src/Q2/Person.java` — `toString`
- `past-exams/2025-1/src/Q2/Q2Test.java` — `insert_simple, ordered_simple, ordered_equal, find_simple, label_simple`
- `past-exams/2025-1/src/Q2/Tree.java` — `insert, find, isOrdered, getLevelAndLabel, show, toString, getId`

<a id="question-55"></a>
### past-exams/2025-1/src/Q3 — Right-recursive expression AST

Keywords: Parsing Tokeniser recursive-descent CFG AST expression-tree right-associative operators sequence invalid-input

- `past-exams/2025-1/src/Q3/Q3README.md`
- `past-exams/2025-1/src/Q3/Exp.java` — `show, toString`
- `past-exams/2025-1/src/Q3/IntExp.java` — `show`
- `past-exams/2025-1/src/Q3/OpExp.java` — `show`
- `past-exams/2025-1/src/Q3/Parser.java` — `parse, single`
- `past-exams/2025-1/src/Q3/ParserEdgeTest.java` — `rejectsIncompleteAndInvalidExpressions, followsRightRecursiveGrammarRatherThanConventionalPrecedence`
- `past-exams/2025-1/src/Q3/Q3Test.java` — `tokenise_single_value, tokenise_expression, tokenise_evaluation, parse_value, parse_single_operation, parse_exps_recursive, parse_exps`
- `past-exams/2025-1/src/Q3/SeqExp.java` — `show`
- `past-exams/2025-1/src/Q3/Token.java` — `getType, getValue, setValue, toString`
- `past-exams/2025-1/src/Q3/Tokeniser.java` — `next, takeNext, current, hasNext`
- `past-exams/2025-1/src/Q3/TokenType.java`
- `past-exams/2025-1/src/Q3/VarExp.java` — `show`

<a id="question-56"></a>
### past-exams/2025-1/src/Q4 — Ten MCQs

Keywords: MCQ Git merge graph Singleton Testing branch-coverage AVL-insert Android-localisation Parsing CSV sharding SOLID LSP JML IP

- `past-exams/2025-1/src/Q4/Q4README.md`
- `past-exams/2025-1/src/Q4/MC_Questions_2025_S1.pdf`
- `past-exams/2025-1/src/Q4/MCQAnswerSyntaxTest.java` — `setUp, testBasicSyntax, testNoRepeatInRange, testAnswersOrdered, parseAnswer`
- `past-exams/2025-1/src/Q4/Q4Answers.txt`

<a id="question-57"></a>
### past-exams/2025-2/src/Q1 — Five MCQs

Keywords: MCQ RBT-insert red-uncle recolouring height Android lifecycle CFG JML Singleton

- `past-exams/2025-2/src/Q1/Q1README.md`
- `past-exams/2025-2/src/Q1/MCQAnswerSyntaxTest.java` — `setUp, testBasicSyntax, testNoRepeatInRange, testAnswersOrdered, parseAnswer`
- `past-exams/2025-2/src/Q1/MCQQuestions.pdf`
- `past-exams/2025-2/src/Q1/Q1Answers.txt`

<a id="question-58"></a>
### past-exams/2025-2/src/Q2 — Pricing parameterized coverage

Keywords: Testing parameterized branch-coverage OR AND short-circuit null boundary-values discount

- `past-exams/2025-2/src/Q2/Q2README.md`
- `past-exams/2025-2/src/Q2/CalculatePriceTest.java` — `data, callCalculatePrice, testIsValid`
- `past-exams/2025-2/src/Q2/Pricing.java` — `calculatePrice`

<a id="question-59"></a>
### past-exams/2025-2/src/Q3 — Payment strategy refactoring

Keywords: Written Design Strategy Interfaces SOLID OCP code-smell conditional-dispatch refactoring

- `past-exams/2025-2/src/Q3/Q3README.md`
- `past-exams/2025-2/src/Q3/PaymentProcessor.java` — `processPayment`
- `past-exams/2025-2/src/Q3/Q3Answers.java`
- `past-exams/2025-2/src/Q3/Q3Test.java` — `Q3_1_personal_info, Q3_2_word_count`

<a id="question-60"></a>
### past-exams/2025-2/src/Q4 — Flat and hierarchical XML locations

Keywords: Persistence XML DOM recursive tree attributes optional-population validation missing-name

- `past-exams/2025-2/src/Q4/Q4README.md`
- `past-exams/2025-2/src/Q4/data/a_flat_easy.xml`
- `past-exams/2025-2/src/Q4/data/b_tree_basic.xml`
- `past-exams/2025-2/src/Q4/Element.pdf`
- `past-exams/2025-2/src/Q4/Location.java` — `addChild, equals, hashCode, toString`
- `past-exams/2025-2/src/Q4/LocationLoader.java` — `loadPopulationInfo, loadLocations, documentRoot, elements, location`
- `past-exams/2025-2/src/Q4/Node.pdf`
- `past-exams/2025-2/src/Q4/Q4Test.java` — `Q4a_1_read_simple, Q4b_1_top_location, Q4b_2_hierarchies_exist, find, assertPathExists`

<a id="question-61"></a>
### past-exams/2025-2/src/Q5 — Favourites observer notifications

Keywords: Design Observer Interfaces subject observers notify singleton item favourite price-change

- `past-exams/2025-2/src/Q5/Q5README.md`
- `past-exams/2025-2/src/Q5/FavouriteList.java` — `addItem, removeItem, attach, detach, notify`
- `past-exams/2025-2/src/Q5/Item.java` — `getId, getName`
- `past-exams/2025-2/src/Q5/Main.java` — `main`
- `past-exams/2025-2/src/Q5/NotificationService.java` — `update`
- `past-exams/2025-2/src/Q5/Observer.java` — `update`
- `past-exams/2025-2/src/Q5/Q5Test.java` — `data, testDeclarationExists`
- `past-exams/2025-2/src/Q5/UML_ob.png`
- `past-exams/2025-2/src/Q5/User.java` — `getFavourites, setFavourites, getName`

## Full older exam papers

- `past-exams/2019-1/2019 Semester 1 - Final Examination.pdf`
- `past-exams/2019-2/2019 Semester 2 - Final Examination.pdf`

The 2019 papers reference a separate MCQ program that was not supplied. Those unavailable questions are not represented as solved.
