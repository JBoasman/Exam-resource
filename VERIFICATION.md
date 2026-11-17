# Verification and study notes

Verified with OpenJDK 21 and the JUnit/Gson jars already supplied in this repository. Each question is compiled separately to avoid duplicate class names. The supplied tests plus the added parser/AVL regression tests are run; this is not an official marking key or proof against all hidden tests.

Latest run: 54 independently compiled question units.

- COMPILED (no supplied tests): 1
- EXPECTED REJECTIONS: 2
- PASS: 51

## How to use the repository

- Use `LOCATOR.md` to read topic keywords and file paths; open the desired file manually.
- Read `MCQ-SAQ-STUDY-GUIDE.md` for extended explanations and `MCQ-NOTES.md` for worked MCQ answers and caveats.
- Follow `LINUX-SETUP.md` for extraction, optional Git setup, working directories, and Java/JUnit examples.
- The exercises are independent, not one application that can be compiled as a single source tree.
- Preserve the supplied JUnit/Gson libraries under `past-exams/2025-2/libraries` when preparing an offline archive.
- The HTML readers and document-generation/verification scripts have been removed at the user's request. The results below record the earlier Windows/OpenJDK 21 run, not a new Linux run.
- Scratch output is under `out/`; omit it from the study archive. Reading the notes requires no Python, Node, PowerShell, or server.

## Expected failures are part of two test-writing answers

- **2024-1 Q2:** `AVLTreeTest` rejects the supplied `SampleAVLTree` on all four minimal rotation sequences (LL, RR, LR, RL). That sample is deliberately unbalanced. `ReferenceAVLTree` is a separate correct immutable insertion example, and `ReferenceAVLTest` checks the four rotations, immutability, nested ordering, and balance.
- **2024-2 Q2:** the parameterized tests identify `HashingBox7` and `HashingBox10` as passing, and reject boxes 0–6, 8, 9, 11, and 12. The shared base class originally accepted size 0 despite the written 1–31 requirement; its lower-bound check was corrected to make the specification consistent for every implementation. The deliberately faulty subclass algorithms remain intact.
- The recorded verification run labelled these outcomes `EXPECTED REJECTIONS` only when the observed rejected test identifiers match those expected sets. Review the raw output if that changes.

## Scope and limitations

- The available coding stubs, test-writing questions, written-response templates, and the 29 supplied MCQs have worked answers. The original 2022-1 Q4 calculator remains as the intentionally flawed source for the completed critique in its `answer.md`; it is not a safe arithmetic reference.
- The 2019 papers refer to an absent `MultipleChoice.jar`; those unseen MCQs cannot be recovered or answered from the supplied files. No Git history was fabricated to satisfy old exam commit-count instructions.
- [MCQ-NOTES.md](MCQ-NOTES.md) explains each answer and flags ambiguous wording, especially the 2024 construction-scope, branch-count, IP, and domain-refactoring items. The answer selections are reasoned study answers, not instructor-endorsed answers. MCQ syntax tests do not grade the choices.
- Written answers have been reviewed against the supplied prompts and word/sentence limits where specified; they are not automatically graded for substance. Personal name fields are left for you to fill if you reuse an exam template.
- Added regression checks cover nested Markdown tree structure, malformed arithmetic input, and all four AVL rotations with deeper balance invariants. Existing coverage exercises were also strengthened for short-circuit operands; no instrumented coverage percentage is claimed.
- Some Windows sandbox Java runs initially blocked inside entropy initialization for UUID generation. The earlier verification used a temporary launcher to warm that source before individual test timers started. That launcher has now been removed with the other tooling; the exercise code and test timeouts are preserved.
- The 2025-1 expression tokeniser has conflicting starter documentation: `next()` says to remove a token, but supplied `takeNext()` removes it too. The worked implementation makes `next()` look ahead and `takeNext()` consume once, matching the supplied tests and parser.

## Per-question execution results

| Question unit | Outcome | Tests run |
|---|---|---|
| [misc-questions/q1-json](misc-questions/q1-json/) | PASS | 5 |
| [misc-questions/q10-parsing](misc-questions/q10-parsing/) | PASS | 5 |
| [misc-questions/q11-json](misc-questions/q11-json/) | PASS | 5 |
| [misc-questions/q12-uml-state-testing](misc-questions/q12-uml-state-testing/) | PASS | 5 |
| [misc-questions/q13-iterator](misc-questions/q13-iterator/) | PASS | 1 |
| [misc-questions/q14-xml](misc-questions/q14-xml/) | PASS | 5 |
| [misc-questions/q15-facade](misc-questions/q15-facade/) | PASS | 2 |
| [misc-questions/q2-parsing](misc-questions/q2-parsing/) | PASS | 5 |
| [misc-questions/q3-rbtree](misc-questions/q3-rbtree/) | PASS | 6 |
| [misc-questions/q4-state-testing-bst](misc-questions/q4-state-testing-bst/) | PASS | 8 |
| [misc-questions/q5-grammars](misc-questions/q5-grammars/) | PASS | 5 |
| [misc-questions/q6-bst-testing](misc-questions/q6-bst-testing/) | PASS | 6 |
| [misc-questions/q7-xml](misc-questions/q7-xml/) | PASS | 5 |
| [misc-questions/q8-dp-testing/branchComplete](misc-questions/q8-dp-testing/branchComplete/) | PASS | 1 |
| [misc-questions/q8-dp-testing/parcel](misc-questions/q8-dp-testing/parcel/) | PASS | 6 |
| [misc-questions/q9-bst](misc-questions/q9-bst/) | PASS | 5 |
| [past-exams/2019-1/Q2](past-exams/2019-1/Q2/) | PASS | 5 |
| [past-exams/2019-1/Q3](past-exams/2019-1/Q3/) | PASS | 2 |
| [past-exams/2019-1/Q4](past-exams/2019-1/Q4/) | PASS | 2 |
| [past-exams/2019-2/Q2](past-exams/2019-2/Q2/) | PASS | 10 |
| [past-exams/2019-2/Q3](past-exams/2019-2/Q3/) | PASS | 2 |
| [past-exams/2019-2/Q4](past-exams/2019-2/Q4/) | PASS | 6 |
| [past-exams/2020-1/Q1](past-exams/2020-1/Q1/) | PASS | 5 |
| [past-exams/2020-1/Q3](past-exams/2020-1/Q3/) | PASS | 1 |
| [past-exams/2020-1/Q4](past-exams/2020-1/Q4/) | PASS | 9 |
| [past-exams/2020-2/Q1](past-exams/2020-2/Q1/) | PASS | 8 |
| [past-exams/2020-2/Q2](past-exams/2020-2/Q2/) | PASS | 11 |
| [past-exams/2020-2/Q3](past-exams/2020-2/Q3/) | PASS | 7 |
| [past-exams/2021-2/q1](past-exams/2021-2/q1/) | PASS | 1 |
| [past-exams/2021-2/q2](past-exams/2021-2/q2/) | PASS | 9 |
| [past-exams/2021-2/q3](past-exams/2021-2/q3/) | PASS | 11 |
| [past-exams/2022-1/q1](past-exams/2022-1/q1/) | PASS | 7 |
| [past-exams/2022-1/q2](past-exams/2022-1/q2/) | PASS | 4 |
| [past-exams/2022-1/q3](past-exams/2022-1/q3/) | PASS | 21 |
| [past-exams/2022-1/q4](past-exams/2022-1/q4/) | COMPILED (no supplied tests) | 0 |
| [past-exams/2023-1/Q1](past-exams/2023-1/Q1/) | PASS | 9 |
| [past-exams/2023-1/Q2](past-exams/2023-1/Q2/) | PASS | 9 |
| [past-exams/2023-2/src](past-exams/2023-2/src/) | PASS | 29 |
| [past-exams/2024-1/src/Q1](past-exams/2024-1/src/Q1/) | PASS | 6 |
| [past-exams/2024-1/src/Q2](past-exams/2024-1/src/Q2/) | EXPECTED REJECTIONS | 6 |
| [past-exams/2024-1/src/Q3](past-exams/2024-1/src/Q3/) | PASS | 9 |
| [past-exams/2024-1/src/Q4](past-exams/2024-1/src/Q4/) | PASS | 3 |
| [past-exams/2024-2/src/Q1](past-exams/2024-2/src/Q1/) | PASS | 2 |
| [past-exams/2024-2/src/Q2](past-exams/2024-2/src/Q2/) | EXPECTED REJECTIONS | 26 |
| [past-exams/2024-2/src/Q3](past-exams/2024-2/src/Q3/) | PASS | 9 |
| [past-exams/2025-1/src/Q1](past-exams/2025-1/src/Q1/) | PASS | 6 |
| [past-exams/2025-1/src/Q2](past-exams/2025-1/src/Q2/) | PASS | 5 |
| [past-exams/2025-1/src/Q3](past-exams/2025-1/src/Q3/) | PASS | 9 |
| [past-exams/2025-1/src/Q4](past-exams/2025-1/src/Q4/) | PASS | 3 |
| [past-exams/2025-2/src/Q1](past-exams/2025-2/src/Q1/) | PASS | 3 |
| [past-exams/2025-2/src/Q2](past-exams/2025-2/src/Q2/) | PASS | 7 |
| [past-exams/2025-2/src/Q3](past-exams/2025-2/src/Q3/) | PASS | 2 |
| [past-exams/2025-2/src/Q4](past-exams/2025-2/src/Q4/) | PASS | 3 |
| [past-exams/2025-2/src/Q5](past-exams/2025-2/src/Q5/) | PASS | 22 |

Raw compiler/JUnit output: `out/verification-final.txt`. Tests may write small XML fixtures to their question working directories. These generated fixtures are not additional answers.
