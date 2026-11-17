# Using this repository on a Linux exam computer

## What works without setup?

The Markdown notes can be read immediately after extraction in a text editor or IDE. Use `LOCATOR.md` to find a topic and read its repository-relative file path. The HTML readers and document-generation tools have been removed.

The Java source and supplied JUnit/Gson JARs are portable in principle. The existing verification was performed on Windows with OpenJDK 21, not on the university Linux image. Use JDK 21 if available. An IDE's configured Java SDK can differ from the `java` command in its terminal.

These are many independent exercises, not a single application. Repeated class names such as `BST`, `Parser`, and `Q1Test` are intentional. Compile/run one question at a time, or configure separate IDE modules/source roots. Do not compile every Java file in the repository together.

## 1. Check the available commands

Open a terminal and run:

```bash
command -v unzip
command -v jar
git --version
java -version
javac -version
```

`unzip` is commonly installed on Linux desktops, but it is not a guaranteed built-in shell command. A desktop archive manager may also offer Extract Here/Extract To. `jar` is normally supplied with a JDK and can extract an ordinary ZIP if `unzip` is missing. Do not assume you can install packages during the exam.

## 2. Extract one complete ZIP

Assume the download is `~/Downloads/exam-notes.zip`. Substitute its actual name; quote paths containing spaces.

First inspect its structure:

```bash
unzip -l "$HOME/Downloads/exam-notes.zip"
```

Then extract into a dedicated folder:

```bash
mkdir -p "$HOME/exam-notes"
unzip "$HOME/Downloads/exam-notes.zip" -d "$HOME/exam-notes"
cd "$HOME/exam-notes"
ls
```

If you see a wrapper folder such as `PE V2` or a GitLab archive folder, enter that folder as well. The repository root is the directory containing **`LOCATOR.md`, `past-exams`, and `misc-questions`**. The outer extraction directory is not necessarily the repository root.

An archive retains the relative paths stored inside it. Hundreds of files do not require hundreds of extraction commands. Do not use `unzip -j`, which flattens the directory layout and would mix the independent questions together.

### JDK fallback when unzip is unavailable

Use a fresh empty destination:

```bash
mkdir -p "$HOME/exam-notes-fallback"
cd "$HOME/exam-notes-fallback"
jar xf "$HOME/Downloads/exam-notes.zip"
ls
```

The `jar` extraction command writes into the current directory. Again, enter any wrapper folder before opening the repository.

## 3. If there are several download files

### Several ordinary, independent ZIPs

For example, you might attach `notes.zip`, `past-exams.zip`, and `misc-questions.zip` because of an attachment-size limit. Arrange them before the exam so their stored paths reconstruct the same repository root:

```text
notes.zip:           LOCATOR.md, MCQ-SAQ-STUDY-GUIDE.md, other root notes
past-exams.zip:      past-exams/...
misc-questions.zip:  misc-questions/...
```

Extract all three into the same destination:

```bash
mkdir -p "$HOME/exam-notes"
unzip "$HOME/Downloads/notes.zip" -d "$HOME/exam-notes"
unzip "$HOME/Downloads/past-exams.zip" -d "$HOME/exam-notes"
unzip "$HOME/Downloads/misc-questions.zip" -d "$HOME/exam-notes"
```

Use the actual filenames and inspect each archive first. If their top-level folders differ, extracting to one destination does not automatically merge those folders into one repository. Avoid overlapping copies that prompt you to overwrite different versions of the same file.

### One archive split into numbered pieces

Files such as `notes.z01` plus `notes.zip`, or `notes.zip.001`, are parts of a multipart archive, not independent ZIPs. Extraction support depends on the tool and split format. Do not run the ordinary multi-ZIP instructions against them or blindly concatenate them. For this exam, several self-contained standard ZIPs are easier to prepare and rehearse.

## 4. Does the extracted folder need to be a Git repository?

**No.** Reading notes, opening code, compiling Java, and running tests do not require Git metadata. Open the extracted root folder in the IDE or use its files directly.

A ZIP that omits `.git` is a snapshot of the files, not the repository's existing history or remote configuration. If you specifically want local version tracking, run this once from the reconstructed root:

```bash
git init
git status
```

That creates a new local Git repository; it does not retrieve the original history or connect to GitLab. You do not need to initialise each question or each extracted file separately. There is no need to commit merely to read or run the examples. If `.git` was included, check `git status` instead of creating a second nested repository.

### HTTPS clone alternative

If GitLab access is available and permitted in the exam environment:

```bash
git clone --depth 1 https://gitlab.comp.anu.edu.au/u8201749/exam-practice-questions.git exam-notes
cd exam-notes
```

This already creates a Git repository, so do not run `git init` afterward. It downloads the files committed and pushed to the remote, not uncommitted files on your Windows computer. A private repository requires authentication. Keep the ZIP route usable independently of that network/login dependency.

## 5. Read notes or run one question

To read a Markdown file in a terminal:

```bash
less LOCATOR.md
less MCQ-SAQ-STUDY-GUIDE.md
```

In `less`, type `/BST` to search, `n` for the next result, and `q` to quit. An IDE/text editor is also fine.

### Example: a standalone BST question

From the repository root, first retain its absolute location:

```bash
REPO_ROOT="$PWD"
cd "$REPO_ROOT/misc-questions/q9-bst"
JUNIT="$REPO_ROOT/past-exams/2025-2/libraries/JUnit4/junit-4.13.jar"
HAMCREST="$REPO_ROOT/past-exams/2025-2/libraries/JUnit4/hamcrest-core-1.3.jar"
mkdir -p build
javac -encoding UTF-8 -cp "$JUNIT:$HAMCREST" -d build *.java
java -cp "build:$JUNIT:$HAMCREST" org.junit.runner.JUnitCore BSTTest
```

The shell expands `*.java` to that question's Java files. Linux classpaths use **colons (`:`)** between entries; Windows commands commonly use semicolons. Quoting keeps paths with spaces together. `javac -d build` places compiled classes under a separate output folder while preserving package structure.

### Example: a question with relative XML data paths

Q4 in 2025-2 expects `src/Q4/data/...` relative to the exam folder, so run it from `past-exams/2025-2`, not from `src/Q4` or the overall repository root:

```bash
cd "$REPO_ROOT/past-exams/2025-2"
mkdir -p build/q4
javac -encoding UTF-8 -cp "$JUNIT:$HAMCREST" -d build/q4 src/Q4/*.java
java -cp "build/q4:$JUNIT:$HAMCREST" org.junit.runner.JUnitCore Q4Test
```

The variables above remain available in the same terminal. In an IDE, set the run configuration's working directory to this exam folder. The 2023-1 Markdown reader instead expects `Q2/data/...`, so its working directory is `past-exams/2023-1`.

Most tests use JUnit 4; the 2019-1 Q4 tests use JUnit 5, whose standalone runner is also supplied under `past-exams/2025-2/libraries/JUnit5`. JSON examples additionally need the supplied Gson JAR on their compile/runtime classpath. Package declarations determine fully qualified test names, such as `Q2.MDFileReaderTest`, rather than the folder name alone.

## Linux details that matter

- Filename case matters: `Q1` and `q1`, and `Tokeniser` and `Tokenizer`, are different names. Preserve the exact archive structure and names.
- Forward-slash relative paths used by the Java exercises work on Linux. The path audit found no hardcoded Windows-drive paths in the Java source. Correct working directories still matter.
- Use Java source and the supplied library JARs. Recompile locally instead of relying on Windows-generated `out/` class files or local IDE SDK settings.
- Markdown is ordinary UTF-8 text. It does not require the removed HTML readers, Node, Python, or a server to read.
- Some tests intentionally reject faulty AVL/hash implementations; see `VERIFICATION.md`. Those failures are part of the test-writing exercise.
- The repository has no single root build configuration that imports every exercise cleanly as one Java application. Configure/run the question you need.

## What to put in the exam attachments

Include the root Markdown documents, `past-exams/`, and `misc-questions/`, including their data, diagrams, and required JARs. Exclude `.git/`, `.idea/`, and `out/` for a small study snapshot unless you specifically need something from them. Archive the current working files after your final edits; a Git archive/download only contains the committed version it was made from.

Before the exam, rehearse downloading every attachment, reconstructing the folder layout, locating one note, and running one representative test on a university Linux machine. This checks the exact JDK, tools, IDE configuration, and data paths that cannot be established from this Windows session.

References: [Ubuntu unzip manual](https://manpages.ubuntu.com/manpages/noble/man1/unzip.1.html), [Git init](https://git-scm.com/docs/git-init), and [Git clone](https://git-scm.com/docs/git-clone).
