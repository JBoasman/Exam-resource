# Question 4 - Software construction

- Topic 1: Software Testing
- Topic 2: Refactoring

## Q4A - Explanation and examples

Software testing evaluates whether observed behaviour meets specified expectations. A unit test can check a BST deletion with two children by asserting that the successor replaces the deleted key and that the remaining keys are preserved. Boundary tests and exception tests exercise cases that ordinary examples can miss. Branch coverage identifies unexecuted decisions, but a test must contain meaningful assertions to detect incorrect results. Refactoring changes internal structure while preserving externally observable behaviour. Extracting duplicated payment logic into a Strategy interface can separate each gateway from shared payment orchestration. The result is easier to extend and understand because each strategy has a focused responsibility.

## Q4B - Relationship

A regression suite supplies evidence that behaviour is preserved while code is refactored. Refactoring towards smaller modules and explicit dependencies makes those modules easier to test independently. Tests should assert public contracts so harmless internal restructuring does not force extensive test rewrites. After each small change, rerun the relevant tests and inspect failures rather than assuming that unchanged coverage means unchanged correctness.

## Q4C - Ethical issue

A team could claim a payment refactor is safe because all tests pass while knowing that refund failures and accessibility paths are untested. Shipping on that basis can cause financial loss or exclude users. Engineers should report the limits of their evidence, add tests for affected user groups and failure paths, and delay a release when unresolved risks threaten users.
