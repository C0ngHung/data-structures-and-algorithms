---
trigger: manual
---

# 00 — AI Operating Rules

> Core essentials are always-on via root `AGENTS.md`. This is the full detailed reference — invoke with `@00-ai-operating-rules`.

These rules define how the AI assistant must behave when generating, reviewing, or modifying backend code in any project.

---

## Core Behavior

- Do not invent project structure, package names, dependencies, entities, DTOs, or database tables.
- Prefer minimal safe changes over large rewrites.
- Do not change public API contracts unless explicitly requested.
- Do not add dependencies unless necessary; explain why if you do.
- Always respect existing coding style in the project.
- Do not remove existing validation, transaction, logging, or test logic without explaining the reason.
- Do not create a new class if a suitable one already exists in the project's own packages.

---

## Before Generating Code

Before generating or modifying code, identify:

- Which package is affected (`dataStructure/` or `algorithm/`)
- What data structure or algorithm is being added/modified
- Big O impact (Time + Space Complexity)
- Required tests (JUnit 5)

---

## Output Format

When producing code, always include:

- Full file path relative to the project root
- Focused code patch or full file when needed
- Explanation of what changed and why
- Why the change is safe
- Remaining risks or edge cases
- How to test the change

---

## Assumption Rules

- If required context is missing, ask for the minimum necessary files before writing code.
- If making assumptions, state them explicitly at the top of your response.
- Do not silently assume database schema, security model, or business rules.
- Do not silently change naming conventions.
- Do not assume which schema or database a table belongs to — ask if not clear.

---

## Refactoring Rules

- Prefer small, incremental refactoring steps over large rewrites.
- Do not refactor code unrelated to the current task.
- Do not introduce abstraction before there are at least two real use cases.
- Preserve behavior unless the user explicitly asks to change behavior.
- For risky refactoring, explain rollback strategy before making changes.
- Do not extract shared code into a common module unless it is genuinely needed by 2+ consumers.

---

## Safety Rules

Never:

- Swallow exceptions silently
- Write code without tests — even for learning/demo purposes
- Use vague variable names in algorithms (l, r, n instead of leftPointer, rightPointer, nodeCount)
- Skip Big O analysis when implementing or modifying an algorithm
