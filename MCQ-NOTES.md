# MCQ locator and reasoning

These are worked study answers, not an official marking key. Items with wording or counting ambiguities are called out below. Syntax tests validate formatting, not whether an answer is correct.

## 2024 semester 1

[Questions](past-exams/2024-1/src/Q4/Q4README.md) · [Answers](past-exams/2024-1/src/Q4/Q4Answers.txt)

| MCQ | Topic / keywords | Answer | Reasoning |
|---|---|---|---|
| 1 | Software construction, scope, planning | E,G | Intended course distinction: problem definition and overall project planning precede construction. Construction-specific planning can fall within construction, so G depends on the course definition. |
| 2 | Testing, branch-count, short-circuit AND | F | Counting each evaluated boolean decision gives 16 outcomes: seven if predicates plus the extra short-circuit test inside the numeric AND. Counting only source-level if outcomes gives 14 (D). |
| 3 | Testing, branch coverage, minimum inputs | D | Eight inputs cover text correct/incorrect, numeric correct/wrong/non-numeric, anagram correct/incorrect, and null type. Under source-level decision coverage alone, seven (C) suffice. |
| 4 | Copyright, copyleft, MIT, patents, moral rights | A,B | Provisional: independent creation and moral rights are the intended ideas. A must not be read as permission to copy someone else's work. E is overbroad because business innovation alone is insufficient for patentability. C and D are false: copyleft allows charging and MIT is permissive. Check lecture wording for this ambiguous item. |
| 5 | BST-height, insertion order | B | Longest path is 80 → 49 → 2 → 20 → 25 → 27, five edges. |
| 6 | RBT-insert, recolour, rotation, post-order | B | Root is 18 black; left is 16 black with 15 red; right is 40 black with children 34 red and 57 red. Post-order is 15,16,34,57,40,18. |
| 7 | Tokenisation vs evaluation, token type/value | A,C | Evaluation is separate from tokenisation; number and word describe types rather than the sample token values. |
| 8 | Ethics, public interest, privacy | D | Refusing privacy-infringing surveillance is consistent with public-interest obligations. The other options excuse concealment, nonconsensual collection, or unsafe release. |
| 9 | UML-inheritance, aggregation, composition | B | Car and Motorcycle inherit from Vehicle; inheritance is not aggregation. |
| 10 | SOLID-OCP, interfaces, subclasses | B,C | New implementations can extend display behaviour without repeatedly editing a central conditional. |
| 11 | DRY, hardcoding, mysterious names, dead code, long parameter list | A,B,C,D,E,G,H | Treat A as identifying violation of DRY (duplication). An ingredient collection and reusable calorie calculation reduce duplication and parameter explosion; the unused vaguely named method contributes dead code and mysterious naming. |
| 12 | Android-permissions, onCreate, listeners, layouts, Toast | A,C,E | Missing internet permission is not a compilation failure; the claimed mandatory callback pair is wrong; listeners are not restricted to only the listed controls. |
| 13 | CFG, terminals, optional modifier | A,D | Modifier is optional and both sample declarations derive from S. The grammar does not define a method signature, arbitrary identifiers, or final. |
| 14 | Refactoring, encapsulation, enum, domain model | B,D,E | Location and position types improve the domain model; match statistics belong with the relevant match data. Keep visual presentation separate if a UI is introduced. A incorrectly says implement a class; C removes encapsulation. E has a presentation/responsibility ambiguity. |

## 2025 semester 1

[Paper](past-exams/2025-1/src/Q4/MC_Questions_2025_S1.pdf) · [Answers](past-exams/2025-1/src/Q4/Q4Answers.txt)

| MCQ | Topic / keywords | Answer | Reasoning |
|---|---|---|---|
| 1 | Git-fetch, merge, commit graph, remote-tracking | D | A is the merge of local C and remote B, descending from D; Bernardo could have authored B and D. The displayed remote-tracking pointer is B, not C. The narrative's completed push versus stale remote pointer is simplified. |
| 2 | Singleton, private constructor | B | A private constructor controls external creation. |
| 3 | Branch coverage, CFG, minimum paths | B | Five runs cover y=1,2,3,4 and another value; distribute x=1,2,3 and another value among those runs. Four cannot cover the four y-true edges and final y-false edge. |
| 4 | AVL-insert, LR, left-right rotation | A | Inserting 6 follows 7-left to 3-right to 5-right. Rebalance 7 by left rotation at 3 then right rotation at 7. |
| 5 | Android-localisation, string resources | C | Use locale-specific values folders and string resources. |
| 6 | Parsing, start symbol, sentence tree | A | Root is sentence with main verb chase; the relative clause belongs inside the object noun phrase. |
| 7 | CSV, sharding, persistence | A | CSV rows are independent of open hierarchical tags. XML/JSON can be deliberately partitioned into valid documents too, but the other options' stated reasons are false. |
| 8 | SOLID-LSP, Vector2, Vector3, abstraction | A | A shared abstraction can express the common valid contract without claiming a 3D value is a 2D value. Immutability alone does not repair a violated contract. |
| 9 | Javadoc, JML, param | C | @param i The first index. is Javadoc's informal parameter documentation syntax. |
| 10 | IP, unlicensed public repository, copyright | A | Closest intended option: public visibility does not grant general reuse rights. More precisely it is all-rights-reserved by default, rather than an explicitly granted exclusive license. Seek permission or an applicable license. |

## 2025 semester 2

[Paper](past-exams/2025-2/src/Q1/MCQQuestions.pdf) · [Answers](past-exams/2025-2/src/Q1/Q1Answers.txt)

| MCQ | Topic / keywords | Answer | Reasoning |
|---|---|---|---|
| 1 | RBT-insert, red uncle, recolour, height | B,C | Insert 25 as 23's red right child. Parent 23 and uncle 10 become black; grandparent 20 becomes red. No rotation is needed. Red nodes are 20 and 25, and longest root-to-node path has three edges, excluding null leaves. |
| 2 | Android-activity, back stack, onPause | B | The previous activity is retained and paused; if fully hidden it also stops. |
| 3 | CFG, missing equals, SQL-like query | C | The instruction omits the required equals terminal before id value 2. |
| 4 | JML, contracts, XML | E | JML specifies contracts and supports checking; XML processing requires Java XML libraries. |
| 5 | Singleton, private constructor, identity | C | The private constructor cannot be invoked directly outside Universe. Repeated getInstance calls return the same instance in this single-threaded example. |

## Sources for terminology and caveats

- [Android lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle): paused versus stopped activities and lifecycle callbacks.
- [No license](https://choosealicense.com/no-license/): public code without a license does not automatically permit reuse.
- [IP Australia: computer-related inventions](https://www.ipaustralia.gov.au/patents/what-are-patents/what-computer-related-inventions-can-be-patented): software patentability is subject to substantive requirements.
- [GNU: selling free software](https://www.gnu.org/philosophy/selling.html): free software licenses permit charging for distribution.

Older 2019 papers refer to a separate MultipleChoice.jar that is absent from this repository. Its unseen questions cannot be answered here.
