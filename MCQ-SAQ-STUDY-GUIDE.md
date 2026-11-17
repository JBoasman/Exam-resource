# COMP2100 MCQ and short-answer study guide

An extended reference for the concepts in the **29 available MCQs and seven written/open-ended questions** in this repository. It also explains the coding examples that those questions rely on. The missing 2019 MCQ application is outside this coverage because its questions were not supplied. This is a study guide, not an official marking key.

Read this Markdown file in a text editor or IDE; no HTML viewer or extra software is required. Use Ctrl+F for a term, or start with the question-to-concept map at the end. Explanations use the question's definitions where they differ from everyday Java practice.

## Contents

- [1. Software construction and quality](#construction)
- [2. Java objects, interfaces, and contracts](#java)
- [3. SOLID principles](#solid)
- [4. Design patterns and how to choose them](#patterns)
- [5. Code smells, domain modelling, and refactoring](#refactoring)
- [6. UML relationships and multiplicities](#uml)
- [7. Software testing and assertions](#testing)
- [8. Branch coverage, short-circuiting, and minimum inputs](#coverage)
- [9. Trees, BST operations, and traversals](#bst)
- [10. AVL insertion and rotations](#avl)
- [11. Red-black insertion and recolouring](#rbt)
- [12. Tokenisation, grammars, parsing, and ASTs](#parsing)
- [13. CSV, JSON, XML, persistence, and sharding](#persistence)
- [14. Git, merges, and commit graphs](#git)
- [15. Android lifecycle, UI, and localisation](#android)
- [16. Design by contract, Javadoc, and JML](#jml)
- [17. Intellectual property and licensing](#ip)
- [18. Ethics, performance, and strong written answers](#synthesis)
- [19. Every available MCQ and SAQ mapped to concepts](#question-map)

<a id="construction"></a>
## 1. Software construction and quality

Software construction turns a design into working software through detailed design, coding, integration, testing, and debugging. It includes decisions that make code understandable and verifiable: naming, modularity, exception handling, reuse, coding standards, and appropriate tools. Construction is broader than typing source code.

Distinguish the activities by their questions. Requirements ask **what problem and behaviour are needed**. Architecture asks **which major components and dependencies will provide them**. Detailed design and construction decide **how those components work**, implement them, and verify their interactions. Maintenance includes later correction, adaptation, and improvement. These activities can overlap rather than forming a strict one-way sequence.

**Scope trap in 2024-1 MCQ1:** it is reasonable to distinguish initial problem definition and overall project planning from construction. However, construction-specific planning, such as integration order and verification work, belongs within the broader SWEBOK treatment of construction. Consequently, “planning” without qualification is ambiguous; do not memorise “all planning is excluded.” [SWEBOK Guide](https://ieeecs-media.computer.org/media/education/swebok/swebok-v4.pdf)

Quality attributes are related but different:

| Attribute | Meaning | Concrete evidence |
|---|---|---|
| Correctness | Behaviour meets the stated requirements | An insertion preserves the ordering invariant |
| Reliability | Service remains dependable under its operating conditions | Failure rate, recovery behaviour, fault-injection results |
| Performance | Time and resource use meet workload needs | Latency, throughput, memory and CPU measurements |
| Maintainability | Changes can be understood and implemented safely | Focused modules, clear interfaces, useful regression tests |
| Testability | Behaviour and faults can be exercised and observed | Injectable dependencies, deterministic logic, observable results |
| Security and privacy | Data and capabilities are protected appropriately | Authorisation checks, minimised collection, tested failure paths |

**High cohesion** means a module's responsibilities belong together. **Low coupling** means modules depend on few details of one another. A payment calculator that only computes amounts is cohesive. One that computes amounts, writes files, displays screens, and contacts banks has unrelated reasons to change. A client depending on a small `PaymentStrategy` interface is less coupled than one depending on every gateway implementation.

Reuse has two directions. **Construction with reuse** consumes existing components. **Construction for reuse** creates components that others can safely consume, requiring stable contracts, documentation, and tests. Neither guarantees quality: a reused library may be unsuitable or incorrectly licensed, while an overly general reusable framework can add needless complexity.

For a reliability/performance/maintenance SAQ, connect mechanisms to outcomes: explicit interfaces isolate changes; isolated components are easier to test; regression tests support safe refactoring; profiling identifies the real bottleneck; a measured data-structure change improves performance without guessing. A list of disconnected buzzwords does not establish that reasoning.

<a id="java"></a>
## 2. Java objects, interfaces, and contracts

### Classes, interfaces, and abstract classes

A class defines object state and behaviour. An **interface** expresses a role or capability that clients can use independently of implementation. An **abstract class** can combine a shared contract with shared state or implementation. Java classes `extend` a class and `implement` interfaces; “implement the Person class” is incorrect Java terminology.

```java
interface PaymentStrategy {
    void pay(double amount);
}

final class CardPayment implements PaymentStrategy {
    @Override public void pay(double amount) {
        // Perform the card-specific payment operation.
    }
}
```

An interface variable can refer to any conforming implementation. Dynamic dispatch selects the object's overridden implementation when a method is called. This allows the caller to request a capability without selecting behaviour through a long type or string conditional.

An interface does not make every implementation behaviourally compatible. If a method promises a non-null collection of photos and one implementation returns null, the common method signature alone does not preserve the contract. This distinction matters in the Penguinologist SAQ and the Liskov substitution principle.

### Encapsulation and visibility

Encapsulation protects a representation behind operations that preserve its rules. A private field is not directly accessible to unrelated client code. Subclasses can use inherited accessible methods, but cannot directly access a superclass's private fields merely because they inherit from it. A public getter can expose a value without making the field public.

Returning a mutable internal list can still break encapsulation: the caller may insert invalid elements without going through the owning object's checks. A read-only view, defensive copy, or narrower operation may be appropriate. The correct choice depends on whether callers should observe later changes.

### Constructors, static members, and identity

Constructors establish valid initial state. In the Java 21 environment used for verification here, a `super(...)` constructor call must be first in a constructor; compute defaults in its arguments, for example `super(age == null ? 1 : age, level == null ? 2 : level)`. Do not generalise exam compiler rules to every later Java language version.

`static` associates a member with a class rather than a particular instance. A static singleton instance field is shared; an ordinary instance field belongs separately to each object. A private constructor prevents ordinary external calls to `new`.

For objects, `==` checks **identity**: whether references denote the same object. `equals` checks the class's chosen notion of **equality**. Two distinct objects can be equal. `assertSame(a,b)` tests identity; `assertEquals(a,b)` normally uses equality. Without an overridden `equals`, ordinary object equality is identity-based.

When overriding `equals`, define a compatible `hashCode`: equal objects must have equal hashes. Unequal objects may share a hash. A field used by equality should not change while an object is being used as a key in a hash-based collection. In the Markdown-token SAQ, consider whether indentation and item number belong to identity rather than assuming the existing equality is complete.

### Immutability, null, and arithmetic

An immutable object's externally visible state does not change after construction. Final fields help but do not make referenced collections immutable. Immutable AVL insertion returns a new root, and callers must keep that returned root. Ignoring it loses the updated tree.

Null is not an empty collection, an empty string, zero, or a special instance. Check the intended contract. The location-loader task distinguishes a missing population from population zero; the former becomes null. Fail explicitly when invalid inputs are prohibited rather than allowing an unrelated null dereference later.

Integer arithmetic has important boundaries. Division truncates toward zero; dividing an integer by zero throws `ArithmeticException`. Ordinary `int` addition and multiplication can overflow silently. `Math.addExact`, `subtractExact`, and `multiplyExact` detect overflow. `BigInteger` supports arbitrary-size integers; fractional arithmetic requires an appropriate different type and rounding policy.

Exponentiation must handle zero and one deliberately. A basic non-negative integer power starts with result 1 and multiplies by the base, not by the loop index. Negative powers generally cannot be represented by an integer result. State what happens for `0^0` instead of leaving the convention accidental.

<a id="solid"></a>
## 3. SOLID principles

SOLID is a set of design principles for controlling change and preserving usable contracts. Explain the actual dependency or responsibility problem before choosing a principle.

| Principle | Core idea | Repository-related diagnosis | Concrete improvement |
|---|---|---|---|
| SRP: Single Responsibility | A module should have one coherent reason to change | List-item data and extensible display formatting change for different reasons | Separate the model from a renderer |
| OCP: Open/Closed | Extend behaviour without repeatedly modifying stable client logic | Every new payment method adds another branch to one processor | Introduce independently implementable payment strategies |
| LSP: Liskov Substitution | Subtypes preserve the behavioural expectations of the supertype | A subtype cannot supply an operation the base contract promises | Change the abstraction or separate incompatible capabilities |
| ISP: Interface Segregation | Clients should depend only on capabilities they need | Research-only users must implement photo access | Split `ResearchAccess` and `PhotoAccess` |
| DIP: Dependency Inversion | High-level policy and low-level details depend on abstractions | Import workflow directly constructs format-specific parsers | Inject a `DataImporter` interface |

### SRP is about reasons to change

Counting methods does not identify SRP violations. A class can have many methods that all maintain one domain abstraction. Conversely, a small method can mix business calculation with persistence and presentation. A debugging `toString()` is not automatically a serious SRP violation; it becomes a stronger concern when that method is the application's changeable rendering system.

For `MDToken`, a useful argument is that list-item semantics and output-format policy evolve independently. Changing indentation or adding HTML output should not force changes to the parsed lexical model. A renderer accepts the model and controls presentation.

### OCP is relative to an expected extension

You cannot make code closed to every imaginable change. Identify the likely variation: new payment gateways, input formats, recipe renderers, or list-item kinds. A suitable interface allows another implementation while stable orchestration remains unchanged. A factory may still need registration for a new implementation; the benefit is localising that selection rather than eliminating all edits.

Enums and conditionals are not automatically bad. An enum representing a fixed set of compass directions can be clear. An enum plus many scattered type conditionals becomes awkward when adding new variants is a routine requirement. In the Markdown example, an ordered item's number is meaningful while an unordered item has no number; separate variants can avoid irrelevant or invalid state.

### LSP is about behaviour, not just inheritance syntax

A subtype should not require stronger preconditions or provide weaker postconditions than its supertype promises. It should preserve relevant invariants. If clients expect a usable photo collection, returning null from a subclass breaks that expectation. Returning an empty collection is only valid if “no photos” truthfully satisfies the contract; it is not a universal repair for an unsupported capability.

For `Vector2` and `Vector3`, adding a coordinate is not enough to justify substitutability. A two-dimensional operation may intentionally ignore all other dimensions; a three-dimensional operation may need the z coordinate to compute length. A shared abstraction can express truly common operations while each dimension maintains correct semantics. Making fields final prevents mutation but does not repair an incorrect behavioural relationship.

### ISP and DIP address different dependencies

ISP asks whether an interface is too broad for its clients and implementations. DIP asks whether policy depends directly on implementation details. A small importer interface can support both: clients see only the import operation they need, and the workflow depends on an abstraction rather than `JsonImporter` specifically.

For the penguin application, put account identity/authentication apart from research and photo capabilities. Let `PhotoViewer` accept `PhotoAccess`, not a broad `User` that forces unrelated research functions. A user role can implement both capabilities when that is meaningful.

<a id="patterns"></a>
## 4. Design patterns and how to choose them

A pattern supplies a reusable arrangement of responsibilities. Naming it is less valuable than describing which classes change and why.

| Pattern | Recognise the situation | Main mechanism | Common confusion |
|---|---|---|---|
| Singleton | One shared instance is required | Controlled construction and shared accessor | A public constructor defeats ordinary creation control |
| Strategy | Several interchangeable algorithms implement the same task | Context delegates to a supplied strategy | The caller normally selects the algorithm |
| State | An object's response changes with its current state | Context delegates to a state; transitions change that state | It is not merely a fixed externally selected strategy |
| Observer | Multiple dependants must learn about events | Subject registers observers and notifies them | Notifications need correct subject/event information |
| Factory Method | Subclasses decide what concrete product to create | Overridden creation method | It need not be a giant static conditional |
| Template Method | A workflow is fixed but some steps vary | Base method calls overridable hooks | It differs from constructing an entire algorithm externally |
| Adapter | An existing API does not match the API the client needs | Wrapper translates calls and data | It changes compatibility, not necessarily the underlying algorithm |
| Facade | Clients need a simpler entry point to a subsystem | Small coordinating API | It does not require hiding every subsystem class |
| Iterator | Traverse a collection without exposing representation | `hasNext`/`next` or equivalent traversal object | Its contract may differ from Java's standard iterator |

### Singleton

```java
final class Registry {
    private static final Registry INSTANCE = new Registry();
    private Registry() {}
    public static Registry getInstance() { return INSTANCE; }
}
```

This eager form has straightforward construction and class-initialisation safety. The lazy starter form `if (instance == null) instance = new ...` works in the supplied single-threaded examples but is not automatically thread-safe. A singleton does not prove the rest of the application's state is thread-safe. It can also create hidden global dependencies, so use it when the required sharing is justified.

### Strategy: payment and delivery calculations

Keep common orchestration in `PaymentProcessor`, such as validating the amount and recording an outcome. Put gateway-specific processing behind `PaymentStrategy.pay(amount)`. Choose and inject `CardPayment`, `PayPalPayment`, or `BankTransferPayment` at the caller or a composition point. This makes each gateway independently testable and avoids editing the processor for every new method.

For delivery quotes, a company can implement its own rate calculation while sharing validation of prohibited items. Respect the actual tariff: progressive bands apply different rates to portions of the weight. A rate for the final band does not necessarily apply to the whole parcel. If distance beyond a radius triggers a charge on the full distance, do not charge only the excess unless the question says so.

### State: game characters, cooking, and help

The context stores a state and delegates input handling. A concrete state decides the response and any next state. In the game example, `StandState` handles DOWN by changing to `LieProneState`; RESET returns to standing from every state. Unspecified inputs usually leave the state unchanged when the state diagram defines no transition.

Read arrows and labels rather than inferring transitions from state names. Validate the context and event before dispatch. A singleton state can be shared when it contains no per-character mutable state; storing each character's changing data inside that singleton would accidentally share it across characters.

The escape-room example combines states with events: in progress checks an answer, help solves a selected riddle and returns to the appropriate state, and escaped rejects another solve request. Asking for help and successfully escaping are separate events for observers.

### Observer

A subject keeps observer registrations and notifies them at the event specified by the contract. The observer should track the particular participant or item; a single global `hasEscaped` boolean cannot answer whether one selected participant escaped. Decide whether repeated registration is allowed, whether removal is supported, and whether notifications happen before or after the state update. An observer reading the subject normally needs the updated state.

The pattern does not guarantee delivery across a network, exactly-once processing, or thread safety. Those would require additional design. For a small in-memory exam question, concentrate on correct registration, event conditions, and subject identity.

### Factory Method, Template Method, and importers

In the animal example, `AnimalCreator.createAnimalTemplate()` controls the shared workflow: generate an ID, obtain a name, and create a product. `DogCreator` and `PenguinCreator` supply type-specific names and product construction. The workflow is a Template Method; the overridden construction hook is a Factory Method. Defaults must be assigned before the product is created, and name counters should have the sharing scope required by the task.

For JSON/XML/CSV/bespoke importers, Strategy expresses interchangeable importing behaviour. A factory can select an importer, and an Adapter can wrap an existing parser whose API differs. These patterns can coexist, but each should solve a specific problem. They are not interchangeable labels for any helper class.

### Iterator and Facade

An iterator hides whether a collection is stored as an array, list, or tree. Its state records the next position or pending nodes. `hasNext()` should not unexpectedly consume a result. Repeated `hasNext()` calls should preserve the next result under the ordinary iterator contract. Standard Java `Iterator.next()` throws `NoSuchElementException` when exhausted; some custom exam interfaces use a different rule, so read that interface.

A calculator facade can present `add`, `subtract`, `multiply`, and `divide` while delegating to operation objects. This reduces client knowledge of the subsystem. It does not, by itself, solve overflow, divide-by-zero, or a requirement to support new operations without editing the facade.

<a id="refactoring"></a>
## 5. Code smells, domain modelling, and refactoring

Refactoring changes internal structure while preserving observable behaviour. Fixing a wrong arithmetic result changes behaviour and is a bug fix, even if it happens alongside refactoring. Keep that distinction clear in an SAQ.

| Smell | Why it causes trouble | Specific possible response |
|---|---|---|
| Duplicated logic / DRY violation | One rule must be updated in several places | Extract the shared calculation, retaining distinct data |
| Long parameter list | Calls are difficult to read and parameters are easy to misorder | Introduce a coherent parameter object or collection |
| Hardcoded domain data | New data or configurations require source edits | Move appropriate data into objects/configuration |
| Mysterious names | A reader must inspect implementation to infer purpose | Rename to state the domain operation |
| Dead code | Unused behaviour increases maintenance and confusion | Remove it after checking usage and requirements |
| Repeated conditional dispatch | New variants require changing central control logic | Delegate through a suitable interface/Strategy |
| Primitive obsession | Unstructured strings/integers carry domain rules implicitly | Introduce an enum or value object where useful |
| Mixed responsibilities | Changes in unrelated concerns touch the same class | Separate calculation, storage, orchestration, and UI |

DRY means a rule has a single authoritative representation, not “never write two similar-looking lines.” Extracting unrelated logic merely because it looks similar can create a misleading abstraction. A hardcoded value is not automatically wrong: a mathematical constant or fixed protocol token can belong in code. The concern is representing changeable domain information as scattered unexplained constants.

In `RecipeManager`, replace ingredient1 through ingredient6 with a collection of ingredient values. A calorie function can sum the calories of a recipe's ingredients rather than duplicating one block per recipe. An unused vaguely named method can contribute both dead code and mysterious naming. Also inspect whether a sample call has the right argument count; a code-quality question can contain a compilation problem as well as design problems.

For the Player/Team/Match example, a position enum restricts supported positions more clearly than arbitrary strings when the set is fixed. A `Location` value object can hold address/venue information. Do not make `players` public to simplify access: provide operations that preserve team rules. Match statistics can belong to the relevant domain objects, while drawing charts or screens is a separate presentation concern.

For `MDToken`, possible improvements are immutable item variants, validated construction, a separate renderer, and compatible equality/hash behaviour. Do not claim a subclass hierarchy is always superior to an enum; justify it using the expected extension, such as adding checked task-list items with additional data.

**Safe sequence:** establish the behaviour and useful tests, make one focused structural change, rerun relevant checks, and examine the diff for accidental behaviour changes. Tests that only assert private implementation details may resist harmless refactoring. Prefer public contracts while retaining focused internal checks for important invariants.

<a id="uml"></a>
## 6. UML relationships and multiplicities

Read the arrow, endpoint symbols, member visibility, and multiplicity independently. Similar-looking connecting lines have different meanings.

| Notation | Meaning | Example |
|---|---|---|
| Solid line with hollow triangle toward parent | Generalisation / inheritance | Car is a Vehicle |
| Dashed line with hollow triangle toward interface | Realisation | A class implements a capability interface |
| Plain association line | Objects are related | A viewer displays photos associated with a user |
| Hollow diamond at whole | Shared aggregation | A whole groups parts whose lifetime need not be owned by it |
| Filled diamond at whole | Composition | Whole has strong ownership of parts in the model |
| Dashed dependency arrow | A client uses a supplier | A method accepts another type temporarily |

In the parking diagram, the filled diamond is at Floor, so Floor is the composite whole and Spot is the part. It is not at Spot. The hollow diamond at ParkingLot represents aggregation of floors. Car and Motorcycle generalise to Vehicle: this is inheritance, not aggregation.

Multiplicity at an endpoint says how many objects at **that endpoint** may be related to one object at the opposite endpoint. `0..*` permits zero or many. `1..*` requires at least one. `1` means exactly one. A ParkingLot linked to `0..*` Floor objects may have no floors; do not read the `1` at the ParkingLot end as “exactly one floor.”

Visibility notation is `+` public, `-` private, `#` protected, and `~` package visibility. Private `name` and `color` attributes in Vehicle remain private even when Car inherits its public getters. Underlining denotes static members in standard class-diagram notation; italics may denote an abstract classifier or operation.

Composition expresses domain ownership/lifetime, not an automatic Java garbage-collector instruction. Losing a reference to Floor does not execute a magical destructor on every Spot. Explain the intended model relationship separately from implementation mechanisms.

<a id="testing"></a>
## 7. Software testing and assertions

A useful test supplies an input, performs an operation, and checks an expected result derived independently from the requirement. Running code without an assertion can miss incorrect output. A green test suite can also be misleading when a parameter table is empty and zero test cases execute.

| Test kind | Purpose | Repository example |
|---|---|---|
| Unit | Exercise a focused class or function | Price calculation for a selected member/quantity |
| Integration | Exercise interactions between components | Tokeniser to parser to XML storage |
| Regression | Detect behaviour that has changed unexpectedly | Recheck parsing after a refactor |
| Black-box | Derive cases from the specification | Correct hash for a stated size/material/name |
| White-box | Derive cases from internal control flow | Exercise both outcomes of a branch |
| Boundary-value | Challenge transitions at domain boundaries | Sizes 0,1,2,30,31,32 for a valid range 1..31 |
| Exception | Check specified failure behaviour | Null event throws the required exception |
| Mutation-oriented | Distinguish correct from deliberately faulty implementations | Reject incorrect HashingBoxes without rejecting the correct ones |

Black-box and white-box describe the information used to select tests, not separate JUnit frameworks. A parameterized test runs the same assertion logic over several data rows. Each row must include a meaningful expected outcome, not an outcome calculated by calling the implementation under test.

Use `assertEquals(expected, actual)` for values and `assertSame` for shared object identity. Floating-point calculations normally need an appropriate tolerance when exact representation is not guaranteed. Use `assertThrows(ExpectedException.class, () -> operation())` when available, or the version-specific equivalent. Do not let an unrelated exception satisfy a broadly specified exception test.

An equivalence partition is a set of inputs expected to behave similarly. For a valid quantity range, consider below range, within range, and above range; then test boundaries where behaviour changes. For a name hash, partitions may include empty names, fewer than six characters, exactly six, more than six, mixed letter/digit/punctuation, and uppercase/lowercase characters.

The HashingBox task combines several independent rules: the largest prime at or below size (with size 1 specially mapped to 2); only English letters among the first six character positions; the full name length; and the material/shape product. “First six characters” is not “first six letters.” For `1aaaa1aaaa`, only the four a characters in positions 2..5 contribute to the ASCII sum, but all ten characters contribute to length.

Some exercises intentionally produce red tests. The supplied SampleAVLTree does not balance correctly, so tests that reject its rotation cases demonstrate useful detection. In the HashingBox task, incorrect implementations should fail while correct implementations pass. Changing tests so every implementation turns green defeats the task.

<a id="coverage"></a>
## 8. Branch coverage, short-circuiting, and minimum inputs

Coverage measures what was exercised, not whether it was specified correctly. It is possible to execute every branch and assert the wrong requirement, or to omit a relevant input-domain boundary while reaching every decision outcome.

| Coverage | What must be exercised | What it does not establish |
|---|---|---|
| Statement | Every executable statement at least once | Both outcomes of a decision |
| Decision / source branch | Each decision outcome | Each operand's independent evaluation |
| Condition | Each atomic condition true and false when evaluated | Every combined decision outcome in all forms |
| Path | Each relevant control-flow path | Feasibility of infinitely many loop paths |
| MC/DC | Each condition independently changes its decision outcome | All possible combinations or paths |

For ordinary deterministic code, complete branch coverage generally entails statement coverage, but statement coverage does not entail branch coverage. Full path coverage can be infeasible or unbounded with loops. Do not substitute path-complete for branch-complete.

### Short-circuit evaluation

Java evaluates `A && B` by evaluating B only if A is true. It evaluates `A || B` by evaluating B only if A is false. Three evaluation patterns are relevant to each expression:

| Expression | Patterns |
|---|---|
| `A && B` | A false/B skipped; A true/B false; A true/B true |
| `A || B` | A true/B skipped; A false/B false; A false/B true |

For `input.matches("\\d+") && Integer.parseInt(input) == answer`, test a non-numeric string, a numeric wrong answer, and a numeric correct answer. The non-numeric input verifies that parsing is skipped; it is different from a numeric wrong answer even though both combined results are false.

### Counting the riddle example

The 2024 riddle method has seven source-level `if` decisions: three type checks, three answer checks, and a final solved check. Counting their true/false outcomes gives 14 source decision branches. If the extra evaluation caused by the numeric short-circuit AND is represented as another decision in the control-flow graph, the count is 16. Coverage tools and course conventions may report these differently.

The minimum source-decision input set includes text correct/incorrect, numeric correct/incorrect, anagram correct/incorrect, and a null/unmatched type: seven inputs. Adding the numeric non-numeric case gives eight to exercise the extra short-circuit outcome. The null type matters because it allows the last type check to be false; with only the three non-null enum values, that false edge is unreachable in the intended input domain. State the domain and counting convention when explaining an answer.

### Finding a minimum set systematically

List the required outcomes, then determine which can occur together in one execution. A chain of mutually exclusive choices requires separate executions for its different true edges. Independent sequential chains can often be covered in the same runs; multiply counts only when all combinations are actually required.

In the 2025-1 graph, the y chain requires y=1,2,3,4 and some other value: at least five runs. Assign x=1,2,3 and another value among those same runs. Five cover the needed edges; 4×5 would count combinations rather than minimum branch coverage.

For nested `if` statements, a false outer condition prevents inner execution. At least one input must enter the outer branch before either inner outcome can be covered. For loops, consider no iterations when feasible, at least one iteration, and eventual exit; the exact requirement follows the chosen coverage definition.

In pricing, a null quantity is converted to 1 and reaches an early return. You can exercise multiple member-ID evaluation paths there, but changes to the intermediate discount do not affect the returned price. An assertion must follow the actual specified control flow rather than assuming every assigned discount influences the result. Use distinct tests for quantity 4, special member pricing at quantity at least 5, and the bulk adjustment boundary at 6.

**SAQ habit:** write a compact outcome table beside your inputs. If asked for the minimum, justify a lower bound from mutually exclusive outcomes and show that your proposed set achieves it. Counting assertions or `@Test` methods is not the same as counting distinct inputs.

<a id="bst"></a>
## 9. Trees, BST operations, and traversals

A rooted tree has a root, parent-child relationships, and no cycles. A binary tree has at most two children per node. A binary search tree adds an ordering invariant. In the usual convention, every key in a node's left subtree is smaller and every key in its right subtree is larger; duplicate handling must be specified separately.

The restriction applies to **every descendant**, not only immediate children. A node can be smaller than its parent yet still violate an ancestor's lower bound. Validate the whole tree using inherited lower/upper bounds, adjusting inclusivity for the duplicate rule.

The FamilyTree question reverses the usual orientation: greater IDs go left and smaller or equal IDs go right. Its search, insertion, and validation must all use that same convention. Do not paste an ascending BST algorithm without changing the comparisons.

### Height and complexity

When height counts edges, a leaf has height 0 and an empty tree is commonly assigned -1. Some questions count nodes instead, giving a leaf height 1. State the convention. A plain BST is not automatically balanced: sorted insertion can produce height n-1. Search, insertion, and deletion take O(h), so they are O(log n) for a balanced tree and O(n) for a degenerate one.

For the 2024 insertion order `80,97,49,2,20,52,25,9,27,76`, the longest path is `80 -> 49 -> 2 -> 20 -> 25 -> 27`: five edges and six nodes. Height is not the total number of nodes or the number of nodes in a traversal.

### Search, insert, and delete

Search compares the target with the current key, follows the appropriate subtree, and returns success on equality. An absent child or empty-tree sentinel terminates unsuccessfully. Insertion follows the same route to an available position. Equality needs an explicit policy: ignore a duplicate, update an associated value, keep a count, or place it on a specified side. An insertion loop that neither advances nor returns on equality can run forever.

Deletion has three structural cases. A leaf is removed. A node with one child is replaced by that child. A node with two children can be replaced by its inorder successor, the smallest node in its right subtree under the usual ordering, then that successor is deleted from its former location. The successor has no left child but can have a right child. Update the root when deleting the root; modifying only a local reference does not necessarily update the tree.

### Traversals

| Traversal | Visit order | Typical use |
|---|---|---|
| Preorder | Node, left, right | Parent-first output |
| Inorder | Left, node, right | Sorted output for an ordinary ascending BST |
| Postorder | Left, right, node | Children before their parent |
| Inverted preorder | Node, right, left | The order explicitly requested by several tasks |
| Level order / BFS | One depth at a time using a queue | Breadth-first output |

For stack-based preorder, push the right child before the left so the left is popped first. For inverted preorder, push left before right. In BFS, enqueue children in the requested within-level order. Some repository tasks require right-to-left BFS, so enqueue right before left. Skip null/sentinel leaves rather than printing them as data nodes.

For an n-ary tree, preorder visits a node followed by its children in their stored order. Markdown indentation determines parentage; the text value does not sort the tree. A stack or ancestor list tracks the parent for each level. Exclude the synthetic root when the task requests only list items.

### Child count and decision trees

“Odd nodes” in several questions means nodes with an odd **number of direct children**, not odd-valued keys. In a binary tree that means exactly one child. An even number of direct children means zero or two. Read the noun being qualified before filtering a traversal.

A decision tree is not necessarily a BST. Internal nodes test properties and leaves carry outcomes. Classification follows exactly one path. Maximum decisions is the greatest number of internal tests along a root-to-leaf route. Choosing the locally most balanced split does not guarantee a globally minimum-height classifier; exploring candidate property splits and comparing their optimal subtrees can find a better tree. Memoisation can avoid resolving the same subset repeatedly.

<a id="avl"></a>
## 10. AVL insertion and rotations

An AVL tree is a BST in which each node's left and right subtree heights differ by at most one. With balance factor `height(left) - height(right)`, a positive factor is left-heavy and a negative factor is right-heavy. Some implementations reverse the sign; use the class's definition.

Insert as in a BST, update/check ancestors, and rebalance where needed. A rotation changes local parent-child structure while preserving inorder order. The returned top node may be a new subtree root, so reconnect it to the former parent or retain it as the overall root.

| Imbalance route from the unbalanced node | Minimal insertion sequence | Repair |
|---|---|---|
| LL: left then left | 3,2,1 | Right rotation |
| RR: right then right | 1,2,3 | Left rotation |
| LR: left then right | 3,1,2 | Left rotation of left child, then right rotation |
| RL: right then left | 1,3,2 | Right rotation of right child, then left rotation |

All four minimal examples finish with root 2, left child 1, right child 3, so preorder is `[2,1,3]`. The names describe the insertion route, not the first rotation direction. This is why “LL” requires a right rotation.

In the 2025-1 MCQ, root 7 has left child 3 and right child 9; 3 has children 2 and 5. Insert 6 to the right of 5. At 7, the insertion is in its left child's right subtree: LR. Rotate 3 left, then 7 right. Merely noticing that the last edge points right is insufficient; identify the first unbalanced ancestor and classify relative to it.

Immutable AVL implementations create replacement nodes instead of editing existing nodes. Test both the new tree and the unchanged original. A useful deeper test checks ordering and balance at every subtree after a sequence of insertions, because a correct-looking top-level traversal on three nodes does not demonstrate all ancestor updates.

The repository's supplied SampleAVLTree is an intentionally faulty test subject. For an actual insertion example, use `ReferenceAVLTree`, not the sample being rejected by the tests.

<a id="rbt"></a>
## 11. Red-black insertion and recolouring

A red-black tree is a BST with colouring constraints that bound its height logarithmically. In the conventional form used by these questions:

1. Every data node is red or black.
2. The root is black.
3. Null/NIL leaves are black.
4. A red node has no red child.
5. Every path from a node to a descendant NIL leaf has the same number of black nodes.

The last quantity is black-height; it is not the ordinary height. Define whether the starting node is included when calculating a numerical black-height. The equal-count invariant is the essential idea. A tree may satisfy the BST ordering rule while violating the colouring invariants.

Insert a new key in BST position as red, then repair a possible red-red parent-child conflict. A red new node does not increase the black count on one path, which is why insertion does not simply start every node black.

### Repair cases

If the parent is black, no red-red conflict arises. If the parent is red, inspect the parent's sibling, the **uncle**, relative to the grandparent.

- **Red uncle:** recolour parent and uncle black and grandparent red; continue checking upward from the grandparent. Restore a black root.
- **Black/NIL uncle, triangle:** rotate at the parent to convert LR into LL, or RL into RR.
- **Black/NIL uncle, line:** rotate at the grandparent and recolour the new local parent black and former grandparent red. Mirror left/right cases appropriately.

Do not rotate automatically whenever a red-red pair appears: the red-uncle case can be repaired by recolouring alone. Track parent links and the actual root as rotations occur. If NIL nodes are explicit sentinel objects, their keys are not ordinary stored data.

### Worked recolouring example

The 2025-2 starting tree has 30 black at the root, 20 black on the left, 34 black on the right, and red children 10 and 23 beneath 20. Insert 25 as red to the right of 23. Parent 23 and uncle 10 are red. Recolour 23 and 10 black and 20 red. Its parent 30 is black, so the process stops without a rotation. The red data nodes are 20 and 25. The longest data-node path has three edges: `30 -> 20 -> 23 -> 25`.

For the 2024 sequence `16,34,18,40,57,15`, conventional insertion ends with root 18 black; left 16 black with red left child 15; right 40 black with red children 34 and 57. Postorder is `15,16,34,57,40,18`, with colours attached to those final nodes. Traversal order and recolouring are separate steps: finish insertion repair before deriving the traversal.

<a id="parsing"></a>
## 12. Tokenisation, grammars, parsing, and ASTs

Separate three operations. **Tokenisation** recognises meaningful units in characters. **Parsing** checks grammatical structure and builds a representation. **Evaluation/execution** computes a result or performs an action. A lexer identifying `1`, `+`, and `2` does not thereby calculate 3.

A token has a type and often a value or original lexeme. For text `30`, `NUMBER` is the type and `30` is the value/lexeme. Calling “number” the sample's token value confuses these levels. Some fixed punctuation tokens need no additional stored value because their type already identifies them.

### Context-free grammars

A CFG has terminals, nonterminals, production rules, and a start symbol. Terminals are literal symbols; nonterminals describe replaceable syntactic categories. Epsilon means the empty sequence, not a space character. Derivation starts at the designated start symbol, so a parse tree's root represents that symbol.

```text
S -> Modifier Type Identifier ; | Type Identifier ;
Modifier -> public | private | protected
Type -> int | boolean
Identifier -> a | b
```

Here `private int a;` and `boolean b;` derive from S. `final int a;` and `int longName;` do not. A familiar-looking string is not valid unless this grammar can derive it. Conversely, a grammar can accept strings Java would reject: the MCQ grammar's inclusion of `void` does not make it a complete Java declaration grammar.

In `fetch name, age in Person having id = -12`, the equals sign must occur because it is a terminal in the command rule. Whether -12 is permitted depends on the definition of the integer token, not a preference for positive identifiers. Always distinguish a missing required terminal from a value-domain assumption.

### Recognising tokens correctly

Whitespace handling is part of the specification. A lexer can ignore spaces, preserve newlines as separators, or treat indentation as structural data. Trimming the whole input is wrong for a language in which leading spaces determine list nesting. Case sensitivity is also a language choice; lowercase variable tokens do not imply uppercase variables are accepted.

Choose the appropriate token length. The word-processor task treats each English letter as one TYPE token, but consecutive digits form one candidate OCCURRENCES token. If the maximum is 999, `2000` is invalid as a whole; it should not be split into several smaller valid numbers. Recognise longer reserved forms before shorter prefixes where necessary, such as FORWARD_TO_END before FORWARD.

Starter APIs differ: `next()` can mean look ahead, advance current token, or consume and return a token. Inspect the constructor and `takeNext()`/`current()` methods before implementing. Removing the same token in both `next()` and `takeNext()` skips input. A lookahead operation should not accidentally advance the buffer.

### Recursive descent and associativity

Recursive descent uses methods corresponding to grammar productions, consuming terminals and recursively parsing nonterminals. Check expected token types, missing operands, closing symbols, and leftover input. Parsing a valid prefix is insufficient when the contract requires the entire input to be valid.

The repository's mathematical grammar is right-recursive:

```text
SingleExp -> Value OP SingleExp | Value
```

Therefore `3-2-1` becomes `3-(2-1)`, not `(3-2)-1`. With the same single nonterminal for all three operators, the grammar does not express ordinary multiplication precedence: `x+y*5+2` becomes `x+(y*(5+2))`. Follow the supplied grammar rather than imposing conventional arithmetic rules. A grammar with separate expression/term/factor levels can encode precedence.

An AST keeps semantic structure without every punctuation token. `IntExp`, `VarExp`, `OpExp`, and `SeqExp` represent values, binary operations, and a list of expressions. A parse tree, by contrast, can retain grammar nonterminals and terminals. Evaluation is a further operation over that structure; the parser does not need to perform it.

Directly translating left-recursive rules, such as `X -> X something`, into recursive descent can recurse without consuming input. Rewrite the grammar where permitted, or use an appropriate parsing technique. The odd/even grammar example can be recognised using a chart over substrings rather than uncontrolled mutual recursion.

### Examples beyond arithmetic

In the sentence MCQ, the start symbol is sentence; “chase” is the main verb, and the “that talk to...” relative clause belongs inside a noun phrase. The root is not merely a Verb token.

In the knowledge-graph task, tokenisation can recognise a SELECT token and individual WHERE tokens even when their combination is grammatically wrong. The parser then rejects, for example, a subject variable occupying the predicate position. Filtering requires all stated conditions to hold, and selecting subjects is different from selecting whole triples.

For wildcard patterns with at most one `*`, match the prefix before the wildcard and suffix after it, ensuring the key is long enough to avoid an impossible overlap. Without a wildcard, require equality. If regex is forbidden by the question, using `startsWith`, `endsWith`, and lengths expresses that rule directly.

<a id="persistence"></a>
## 13. CSV, JSON, XML, persistence, and sharding

Persistence stores data beyond one execution. An importer parses an external representation into a domain model; an exporter produces the representation. Validate required fields and choose deliberate handling for missing, blank, malformed, or duplicate data. None of those cases is automatically equivalent to zero or an empty object.

| Format | Strength | Important limitation |
|---|---|---|
| CSV / delimited text | Compact tabular records; convenient row processing | Quoting, escaping, delimiters, headers, types, and encoding need rules |
| JSON | Structured arrays/objects and nested data | Not automatically a sequence of independent lines; duplicate policy is application-specific |
| XML | Hierarchical elements, attributes, text, and schemas | Whitespace nodes and descendant searches can complicate traversal |
| Java serialization | Object representation for compatible Java code | Versioning, compatibility, and trust need care; not a general interoperability format |
| Bespoke format | Can express a domain-specific syntax | Requires its own documented grammar and parser |

### CSV and delimited input

The repository CSV exercise uses semicolons, not commas. It skips one header line and parses each later row according to fixed field positions. `split(";", -1)` retains trailing empty fields. Without the negative limit, Java's split can discard them, changing the record's apparent structure.

A raw split is appropriate only for the specified simple format. General CSV may contain quoted delimiters, escaped quotes, and embedded newlines, requiring a real CSV parser or an explicitly implemented quoting state machine. Do not mistake “file extension is CSV” for “all cells can be split on commas.” Preserve text fields and convert numeric fields with controlled error handling.

### JSON and merging duplicates

Gson can map JSON into a class structure and serialise objects back to JSON. Loading does not implement business rules such as merging employees with the same name. For that, group by the chosen key, union the associated skill/course values, and choose a stable output order if tests or consumers require it.

A `LinkedHashMap` retains the first-seen key order. A `LinkedHashSet` removes repeated values while retaining their insertion order. A name-based merge assumes that equal names identify the same entity; in production that assumption may be wrong, so a stable ID can be more appropriate. Use the exercise's stated key in the exam.

### XML DOM

DOM represents the document as nodes. `Document` owns the document tree; `Element` represents a tagged element; text nodes carry content. Attributes are separate from child elements: `<City name="Hobart"/>` stores name as an attribute, while `<Population>100</Population>` stores population as child text.

`getChildNodes()` can include whitespace text nodes. Filter for elements before treating children as locations or records. `getElementsByTagName()` finds descendants, not just immediate children, so it may accidentally read a grandchild's population as its ancestor's population. Direct-child traversal is essential when hierarchy matters.

For the flat location task, each direct root child is one record and an optional Population child supplies an integer or null. For the hierarchical task, each named element becomes a Location, its direct named element children become its children, and an unnamed element is skipped with its subtree as specified. The tag identifies the location type, and population is an optional attribute in this version. The two XML tasks intentionally use different representations.

Creating XML requires one root element. Create each child with the owning document, append it to its parent, set attributes or text, and transform the resulting document to the output file. Do not confuse creating an unattached element with adding it to the tree. Round-trip tests should compare the loaded domain data, and separately verify external format requirements when exact interoperability matters.

### Sharding and format boundaries

Sharding partitions a data set so operations can work on smaller independent portions, potentially in parallel. Splitting at arbitrary byte positions is not a valid general sharding algorithm. A shard must retain enough structure and metadata to be parsed correctly.

CSV records are naturally convenient boundaries, although quoted multiline records complicate a simplistic newline split. XML and JSON can also be sharded by producing a valid document for each subset of records, with necessary root/container structure. They are not inherently unsuitable. Neither XML attributes nor Gson automatically provide a complete sharding system. There is no general 128-byte size limit enabling Java object serialization.

Parallel access improves performance only when the bottleneck and storage behaviour permit it. Skewed partitions, coordination overhead, shared output contention, and consistency requirements can reduce the gain. Explain those constraints when connecting persistence with performance.

<a id="git"></a>
## 14. Git, merges, and commit graphs

Git records commits and their parent relationships. A branch name is a movable reference to a commit. HEAD usually names the currently checked-out branch. A remote-tracking name such as `origin/main` records the local repository's knowledge of a branch on a remote; it is not a live network query.

| Operation | Main effect |
|---|---|
| `git add` | Stage selected working-tree changes in the index |
| `git commit` | Record the staged snapshot in a new commit |
| `git fetch` | Obtain remote objects and update relevant remote-tracking refs |
| `git merge` | Integrate another history into the current branch |
| `git pull` | Fetch, then integrate according to configuration/options |
| `git push` | Request updates to remote refs from local history |
| `git clone` | Create a local repository from a remote and check out a branch |

Committing does not automatically push. Fetching does not normally merge remote changes into the current branch or resolve a working-tree conflict. A conflict requires a resolution reflecting both intended changes, followed by the appropriate staging and completion of the merge.

In a graph where merge commit A has parents C and B, and both descend from D, D is the common older ancestor. A is the merge, not B. A commit normally has one parent; an ordinary two-way merge commit has two. Graph edges establish ancestry, but author identity cannot be inferred solely from branch layout.

The 2025 question shows `HEAD -> my_branch` at A and `origin/my_branch` at B. That depicts the local tracking reference still at B. Its narrative's completed push and displayed stale reference should not be treated as a universal description of tracking-ref updates. Judge what is plausible from the shown ancestry and labels rather than inventing an author for every node.

A fast-forward integration can simply move a branch reference when no divergent commit needs a merge node. Divergence is the important distinction. `git log --graph --oneline` helps show it, but the visual left/right position is not a chronological or author ordering rule.

<a id="android"></a>
## 15. Android lifecycle, UI, and localisation

### Activity lifecycle

An Activity is managed through callbacks rather than a user-defined application `main` loop. The core sequence for a newly displayed instance is `onCreate -> onStart -> onResume`. Leaving foreground interaction calls `onPause`; becoming fully hidden leads to `onStop`. Returning from stopped uses `onRestart -> onStart -> onResume`. An instance that is finishing or being recreated can receive `onDestroy`; process termination does not guarantee that callback. [Android lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle)

| Callback | Useful exam description |
|---|---|
| `onCreate` | Initialise the new instance and restore saved state if present |
| `onStart` | Instance becomes visible |
| `onResume` | Foreground interaction begins/resumes |
| `onPause` | Foreground interaction is being lost; keep work brief |
| `onStop` | Instance is no longer visible |
| `onRestart` | A stopped instance is about to start again |
| `onDestroy` | Instance is being destroyed through the normal callback route |

Paused does not mean destroyed, and can still mean visible. Use saved-instance-state support for transient UI restoration; persist durable data through an appropriate storage design. Do not claim that essential data is safe merely because it is written only in `onDestroy`. Overriding `onStart` is not universally mandatory; the MCQ's claim about a mandatory callback pair is incorrect. [Android activity introduction](https://developer.android.com/guide/components/activities/intro-activities)

### Tasks, back stack, and intents

In the ordinary default task behaviour, starting B from A puts B above A in the back stack. A pauses and, if completely hidden, stops; it is not automatically destroyed immediately. Going back normally removes the top activity and returns to the previous one. Launch modes, flags, and other platform behaviours can alter that default. [Tasks and back stack](https://developer.android.com/guide/components/activities/tasks-and-back-stack)

An explicit intent identifies the intended component. An implicit intent expresses an action/data request that eligible components may handle. Do not confuse an intent with the Activity instance itself or assume starting another Activity erases the existing task.

### Permissions, listeners, layouts, and feedback

Permissions declare or control access to protected capabilities. Missing internet permission is not a Java compile-time type error: an app can compile while its network operation fails at runtime. Permission needs and runtime consent behaviour depend on the permission and platform rules; do not extrapolate one dangerous permission's process to every permission.

Listeners register reactions to events. They are not limited in principle to buttons and text fields: event/callback mechanisms cover many components and interactions. Registering a callback is different from calling it immediately.

ConstraintLayout positions views through constraints to other views and/or the parent; it is not restricted to fixed absolute screen coordinates. A Toast supplies short-lived user feedback, not a persistent data record or a durable error-handling mechanism. UI feedback does not by itself prove that the underlying operation succeeded.

### Localisation

Keep user-facing text in resources. Provide default strings in `res/values/strings.xml` and translations in folders such as `res/values-es/strings.xml`; refer to strings through resource identifiers. Locale-based resource selection avoids language-specific conditionals scattered across views. Maintain default resources for fallback, and consider translated length and text direction when designing layouts. [Language and culture support](https://developer.android.com/training/basics/supporting-devices/languages)

Copying entire layouts per language is usually unnecessary for a text-only difference. Translation is not accomplished merely by putting several languages' values into one unqualified file and choosing them manually. Separate resource concerns from business logic so language changes do not require editing payment, parsing, or storage algorithms.

<a id="jml"></a>
## 16. Design by contract, Javadoc, and JML

Design by contract makes obligations explicit. A **precondition** states what a caller must establish before a call. A **postcondition** states what the method guarantees after the specified kind of completion. An **invariant** constrains valid object states at the relevant visible boundaries. Runtime validation and formal specification can express related intentions but are not interchangeable mechanisms.

For array swapping, preconditions include a non-null array and in-range indices. Postconditions describe the exchanged elements and preservation of other positions. An invariant might constrain the valid state of the collection object owning the array, rather than being a precondition on every unrelated utility method.

```java
/**
 * Exchanges two array positions.
 * @param i the first index
 * @param j the second index
 */
//@ requires a != null && 0 <= i && i < a.length;
//@ requires 0 <= j && j < a.length;
//@ assignable a[i], a[j];
//@ ensures a[i] == \old(a[j]) && a[j] == \old(a[i]);
static void swap(int[] a, int i, int j) {
    int saved = a[i];
    a[i] = a[j];
    a[j] = saved;
}
```

This illustrates `requires`, `ensures`, a frame condition (`assignable`), and `\old` for pre-call values. Exact checking depends on the JML/OpenJML tool and supported syntax. Preconditions and normal postconditions are distinct; a normal postcondition applies when the method returns normally. [OpenJML preconditions](https://www.openjml.org/tutorial/Preconditions), [postconditions](https://www.openjml.org/tutorial/Postconditions), [invariants](https://www.openjml.org/tutorial/Invariants)

The ordinary `@param i The first index.` form is **Javadoc informal documentation**, not a mathematical JML precondition. JML annotations can support static verification and runtime assertion checking through tools. Merely writing annotations does not cause plain `javac` to prove the program. Nor does JML become an XML processing library: DOM and other XML APIs perform that job. [OpenJML overview](https://www.openjml.org/about/)

Contracts connect to LSP: a replacement implementation must accept the inputs promised by its supertype and supply at least the promised guarantees. They connect to testing by supplying oracles, but tests only sample executions. Formal checking is also limited by what was specified and by the assumptions under which verification was performed.

<a id="ip"></a>
## 17. Intellectual property and licensing

### Copyright and moral rights

In Australia, copyright protection is generally automatic for qualifying original works; it is not created merely by adding a copyright notice or registering a repository. It concerns protected expression such as code, rather than granting ownership of every underlying idea or algorithm. The Copyright Act also recognises non-economic moral rights. Copying someone else's work is different from independently creating a similar work. [Attorney-General's Department: copyright owners](https://www.ag.gov.au/rights-and-protections/copyright/copyright-owners)

Be careful with the MCQ statement that “others can reproduce the same work.” It must not be read as a general permission to copy protected code. Independent creation, permission, and applicable legal exceptions are different bases and should not be blurred.

### A public repository is not a reuse licence

If code is publicly visible without a licence, visibility alone does not provide the broad rights to modify and redistribute it that an open-source licence would grant. Attribution alone is not a substitute for permission. Seek an applicable licence or authorisation, or use another implementation. A licence does not have to be named “exclusive” for default copyright restrictions to matter. [No licence explanation](https://choosealicense.com/no-license/)

### Permissive and copyleft licences

MIT is a permissive licence: it is not copyleft. It allows broad use subject to its conditions, including preservation of the required copyright and permission notice. Do not summarise permissive licensing as “there are no obligations.” [MIT licence text](https://opensource.org/license/mit)

Copyleft licences use copyright permissions and conditions to preserve specified freedoms for recipients, including obligations in relevant redistribution situations. “Free software” concerns freedoms rather than a compulsory price of zero. Copyleft does not prohibit charging for distribution; the exact obligations depend on the chosen licence and how the software is used or distributed. [GNU on selling free software](https://www.gnu.org/philosophy/selling.html)

Compare the actual licence terms before combining third-party components. Preserve notices, track provenance, and ensure contributors have authority to license their contributions. Do not assume that every licence has identical source-sharing triggers or that all privately used modifications must automatically be published.

### Patents and software

Patents protect qualifying inventions under requirements that are different from copyright. Software-related inventions can be patentable, but a claim must meet applicable patentable-subject-matter and other requirements. Describing a business idea as innovative or running it on a standard computer is not, on its own, enough. [IP Australia: computer-related inventions](https://www.ipaustralia.gov.au/patents/what-are-patents/what-computer-related-inventions-can-be-patented)

For the calculator SAQ, identify whether code was copied, what licence applies, and what conditions the intended distribution must satisfy. There is no need to assert a patent exists for ordinary addition or exponentiation without evidence. The relevant engineering response is a provenance/licence review, appropriate notices, and a clear licence for the project's own authorised contributions.

<a id="synthesis"></a>
## 18. Ethics, performance, and strong written answers

### Ethical reasoning

The software engineering ethics framework addresses public interest, clients/employers, product quality, professional judgment, management, the profession, colleagues, and continuing personal learning. The principles must be interpreted together; employer benefit does not automatically override public safety or honest judgment. [IEEE-CS/ACM Software Engineering Code of Ethics](https://www.computer.org/education/code-of-ethics)

For a scenario, identify affected people, potential harm, information known to the engineer, and available actions. Then connect a concrete mitigation to the relevant obligation. In a surveillance example, consider consent, proportionality, access restrictions, abuse, and whether the intended use is compatible with privacy. In a known-vulnerability example, a responsible reporting and mitigation process is more precise than treating immediate public disclosure or complete concealment as the only choices.

Secret data collection is not justified merely because it might improve marketing. Nor does telling users about known bugs make all unsafe releases acceptable. Explain the severity and preventability of harm, the limits of the evidence, and the reason for escalation, remediation, or refusing the work.

### Performance analysis

Measure a specified workload before optimising. **Latency** is time for one operation; **throughput** is completed operations per unit time. They can improve or worsen independently. **Profiling** identifies where resources are spent; a **benchmark** compares measured behaviour under a chosen workload. A microbenchmark can fail to represent actual file I/O, warm-up, caching, or concurrent use.

If a fraction p of runtime is sped up by factor s, the ideal overall speedup is `1 / ((1-p) + p/s)`. If only 10% is optimised, even eliminating its cost cannot yield more than about 1.11× overall speedup. This illustrates why optimising an irrelevant loop may do little while the application waits on disk or the network.

Choose data structures for the operations needed. A balanced tree supports ordered lookup and traversal; a hash map is useful for exact-key access; a list may be simpler for a small sequential workload. Caching trades memory and invalidation complexity for avoided work. Parallelism trades coordination and contention for potential simultaneous execution. Recheck correctness after changes and report the workload in which the improvement was observed.

### Reliability and maintainability reinforce verification

Make quality requirements measurable, define clear component responsibilities and contracts, use suitable structures, automate checks, review changes, and monitor operating behaviour. Integration tests matter because individually correct modules can disagree about file formats, null conventions, or token-consumption rules. Refactoring can make dependencies explicit and tests easier to write, while regression tests supply evidence that behaviour was preserved.

Testing and refactoring also have ethical implications. Claiming a payment change is safe while knowingly omitting refund and failure paths misrepresents the evidence and can cause loss. A responsible response identifies those gaps, tests the affected paths, and explains any unresolved risk before release. Environmental arguments should similarly name a mechanism, such as reducing repeated parsing or unnecessary network requests, rather than asserting every optimisation is automatically greener.

### SAQ answer structure

Use **claim -> code-specific evidence -> consequence -> change -> justification**. For example: repeated payment conditionals require editing the same processor for each gateway; that couples orchestration to gateway details and makes isolated testing harder; introduce an injected PaymentStrategy and move each branch to its own implementation; now new gateways extend the system without altering the stable processing workflow.

For “two topics and their relationship,” explain each separately, then describe a real interaction. Testing supplies a behavioural safety net for refactoring; refactoring toward explicit dependencies improves testability. Add a concrete example and state the limit: passing a regression suite is evidence about its assertions, not proof of every requirement.

For “identify two SOLID violations,” do not count two restatements of the same problem as independent analyses. SRP can concern model versus presentation responsibilities; OCP can concern adding a new item kind. If the question's design admits several interpretations, state the extension scenario and contract you rely on.

Respect the word/sentence limit. Spend words on the causal explanation rather than defining every nearby term. A specific method name, one example of an invalid configuration, and a clear redesign are usually more informative than a long list of patterns.

<a id="question-map"></a>
## 19. Every available MCQ and SAQ mapped to concepts

### MCQs

| Paper and question | Main concepts | Guide sections |
|---|---|---|
| 2024-1 MCQ1 | Construction scope, tools, reuse, planning | 1 |
| 2024-1 MCQ2 | Counting branches, numeric short-circuiting | 7-8 |
| 2024-1 MCQ3 | Minimum riddle inputs, branch versus condition coverage | 8 |
| 2024-1 MCQ4 | Copyright, moral rights, copyleft, MIT, patents | 17 |
| 2024-1 MCQ5 | Plain BST insertion, height convention | 9 |
| 2024-1 MCQ6 | RBT insert, rotations, colours, postorder | 9, 11 |
| 2024-1 MCQ7 | Token type/value, lexer versus evaluator | 12 |
| 2024-1 MCQ8 | Ethics, public interest, privacy, product quality | 18 |
| 2024-1 MCQ9 | UML inheritance, composition, aggregation, visibility | 2, 6 |
| 2024-1 MCQ10 | OCP, interfaces, extension, recipe displays | 3-5 |
| 2024-1 MCQ11 | DRY, hardcoding, naming, dead code, parameter lists | 5 |
| 2024-1 MCQ12 | Android permission, lifecycle, listeners, layouts, Toast | 15 |
| 2024-1 MCQ13 | CFG derivations, terminals, optional modifier | 12 |
| 2024-1 MCQ14 | Domain modelling, enum, encapsulation, responsibilities | 2, 5 |
| 2025-1 MCQ1 | Git graph, fetch, merge, remote-tracking refs | 14 |
| 2025-1 MCQ2 | Singleton constructor and sharing | 2, 4 |
| 2025-1 MCQ3 | Control-flow graph, minimum branch-complete runs | 8 |
| 2025-1 MCQ4 | AVL insertion and LR repair | 10 |
| 2025-1 MCQ5 | Android localisation and resources | 15 |
| 2025-1 MCQ6 | Start symbol, sentence parse tree, relative clause | 12 |
| 2025-1 MCQ7 | CSV, JSON/XML boundaries, sharding, serialization | 13 |
| 2025-1 MCQ8 | LSP, Vector2/Vector3, shared abstraction | 2-3 |
| 2025-1 MCQ9 | Javadoc @param versus JML contracts | 16 |
| 2025-1 MCQ10 | Public unlicensed code and reuse rights | 17 |
| 2025-2 MCQ1 | RBT red uncle, recolouring, height, traversal | 9, 11 |
| 2025-2 MCQ2 | Android tasks, back stack, pause/stop | 15 |
| 2025-2 MCQ3 | Query grammar, mandatory equals terminal | 12 |
| 2025-2 MCQ4 | JML capabilities and XML distinction | 13, 16 |
| 2025-2 MCQ5 | Private constructor, singleton, assertions | 2, 4, 7 |

### Written / short-answer questions

| Question | What the answer must connect | Guide sections |
|---|---|---|
| 2021-2 Q4 | Reliability, performance, maintainability, design and verification | 1, 3-5, 7-13, 16, 18 |
| 2021-2 Q5 | Activity callbacks, timing, recreation, state restoration | 15 |
| 2022-1 Q4 | Calculator correctness, arithmetic contract, extensibility and IP | 2-5, 7, 16-18 |
| 2023-1 Q3 | MDToken responsibilities, extensibility, two SOLID principles, redesign | 2-5 |
| 2023-2 Q3a | Importer interfaces, Strategy/Factory/Adapter, data formats | 3-4, 13 |
| 2023-2 Q3b | Broad User interface, ISP, substitutability, capability separation | 2-3, 6 |
| 2024-2 Q4 | Two course topics, relationship, example, ethical consequence | All topic sections; especially 18 |
| 2025-2 Q3 | Payment code smell, exact location, impact, pattern and refactoring plan | 3-5, 18 |

Q3a and Q3b above are two parts of one written question, giving seven written questions overall. The coding-oriented testing questions are additionally supported by sections 7-8. For runnable examples and the original prompts, use the repository locator alongside this guide.

### Ambiguities to remember

- Construction planning can be included within construction; generic “planning” is ambiguous.
- Branch counts depend on whether compound conditions are expanded in the control-flow graph.
- Minimum coverage inputs depend on the allowed input domain, including whether null types are permitted.
- Software/business innovation alone does not settle patent eligibility.
- Public code is not automatically licensed; “all rights reserved” is more accurate than assuming an unnamed exclusive licence.
- A match can own domain statistics while its UI rendering belongs elsewhere.
- XML/JSON can be sharded into valid documents; the incorrect MCQ explanations are not universal limitations of those formats.
- A deliberately faulty test subject should be rejected; not every red JUnit result means the test answer is wrong.
