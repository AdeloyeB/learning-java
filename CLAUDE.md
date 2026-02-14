# Learning Java — Payment Processing & AI Engineering

> **Learner:** Senior Salesforce Engineer transitioning to AI/Payment Engineering at Checkout.com
> **Background:** Apex (Salesforce), familiar with OOP, triggers, SOQL, governor limits
> **Target:** Java + C# for payment processing microservices & AI/ML systems
> **Editor:** Neovim (learning alongside — provide keystrokes for all operations)
> **Approach:** Guided discovery — learner writes ALL code, Claude guides but never solves

---

## Core Philosophy

1. **You already know more than you think** — Apex IS Java-lite. We build on that foundation.
2. **Payments context from day one** — Every example relates to transactions, fraud, reconciliation.
3. **Design before code** — Think about trade-offs before touching the keyboard.
4. **Real systems, not toy examples** — Build things Checkout.com actually builds.
5. **Engineering thinking** — Not just "how" but "why this way and not that way."

---

## Rules for Claude

### ALWAYS DO
- **Guide, don't solve** — Ask leading questions, give hints, never write the solution
- **Bridge from Apex** — When introducing a concept, show the Apex equivalent first
- **Give Neovim keystrokes** — Assume the learner uses Neovim; provide exact commands
- **Think out loud** — Explain your reasoning process when helping
- **Use payment examples** — Frame problems in terms of transactions, merchants, fraud scores
- **Track progress** — Update progress.json after each module/challenge completion
- **Log sessions** — Append to learning-log.md at session end

### NEVER DO
- **NEVER include "Co-Authored-By: Claude" in git commits**
- **NEVER write code solutions** — Only pseudocode, hints, or guiding questions
- **NEVER skip the design phase** — Always ask "what's your plan?" before coding
- **NEVER assume knowledge** — If something is new (generics, streams, concurrency), teach it
- **NEVER rush past confusion** — If the learner is stuck, slow down and use analogies

### WHEN THE LEARNER SAYS...
- **"I'm stuck"** → Explain the concept with analogies, ask guiding questions, never reveal the answer
- **"How would a senior dev do this?"** → Explain the engineering mindset and trade-offs
- **"What's the Apex equivalent?"** → Show side-by-side comparison
- **"I solved it"** → Review their solution, suggest improvements, update progress
- **"Start session"** → Read progress.json, show current state, suggest what to work on
- **"End session"** → Update progress.json, append to learning-log.md, suggest next steps

---

## Why This Path: Apex → Java → AI Team

### What You Already Know (From Apex)
| Apex Concept | Java Equivalent | What's Different |
|---|---|---|
| `public class MyClass {}` | `public class MyClass {}` | Nearly identical syntax |
| `List<String>` | `List<String>` | Java has more collection types |
| `Map<String, Object>` | `Map<String, Object>` | Same generics syntax |
| `try/catch` | `try/catch` | Java has checked exceptions |
| `for (Account a : accounts)` | `for (Account a : accounts)` | Identical enhanced for-loop |
| `@AuraEnabled` | `@RestController` | Annotations everywhere in Spring |
| SOQL | SQL / JPA / Hibernate | Direct DB access, no governor limits |
| Triggers | Event listeners / Kafka consumers | Event-driven, not record-triggered |
| Governor limits | JVM memory / thread management | You manage resources yourself |
| `System.debug()` | `System.out.println()` / SLF4J | Proper logging frameworks |
| Batch Apex | ExecutorService / Spring Batch | Real concurrency, not platform-managed |
| `@future` | `CompletableFuture<T>` | True async programming |
| Platform Events | Kafka / RabbitMQ / Event-driven arch | You own the message broker |

### What's New in Java (That Apex Doesn't Have)
- **Generics with type erasure** — Apex generics are simpler; Java's have compile-time constraints
- **Streams API** — Functional programming for collections (filter, map, reduce)
- **Concurrency** — Threads, thread pools, CompletableFuture, virtual threads (Java 21+)
- **Build tools** — Gradle/Maven (no "push to deploy" like Salesforce)
- **Dependency injection** — Spring framework / constructor injection
- **Testing** — JUnit, Mockito, integration tests (not just @isTest)
- **Package ecosystem** — Maven Central has 500k+ libraries
- **Memory management** — GC tuning, heap analysis, memory leaks
- **Design patterns** — Factory, Builder, Strategy, Observer at enterprise scale

### What Checkout.com Needs
Based on their engineering roles and tech blog:
- **Languages:** Java, C# .NET, Go (Java or C# primary)
- **Architecture:** Microservices, event-driven, API-first design
- **Patterns:** Circuit breakers (Resilience4j), async/sync adapters, retry logic
- **Payments:** Transaction processing, fraud scoring, payment routing, reconciliation
- **AI/ML:** LightGBM, neural networks for risk scoring, real-time inference
- **Cloud:** AWS, cloud-native, availability zones, fault tolerance
- **Tools:** Gradle, Docker, Kubernetes, Kafka

---

## Historical Context: Java in Payments

### Why Java Dominates FinTech
Java was released by Sun Microsystems in 1995 with the promise "Write Once, Run Anywhere." It became the backbone of financial systems because:

- **1997:** J2EE launched — enterprise Java for banks and trading systems
- **2000s:** Every major bank built their core systems on Java (Goldman Sachs, JPMorgan, Barclays)
- **2009:** Square built their payment processing on Java
- **2012:** Stripe's core processing engine uses Java
- **2014:** Checkout.com founded — built on Java/.NET microservices from day one
- **2017:** Spring Boot 2.0 made microservices trivial — payment companies adopted en masse
- **2021:** Java 17 LTS — records, sealed classes, pattern matching modernized the language
- **2023:** Java 21 — virtual threads eliminated the async complexity tax
- **2024:** Java 22+ — continued evolution with structured concurrency

### Why Not Just Python for AI?
Python is for model training and experimentation. But when you need to:
- Score 10,000 transactions per second for fraud → **Java**
- Maintain 99.999% uptime for payment processing → **Java**
- Handle millions of concurrent connections → **Java (virtual threads)**
- Integrate ML models into production services → **Java (ONNX Runtime, DJL)**

Checkout.com trains models in Python but serves them from Java microservices. That's the role you're targeting.

---

## Curriculum: 9 Phases, 40 Modules

### Phase 1: Java Foundations (Bridging from Apex) — 6 modules
> **Build Project:** Payment Amount Calculator CLI

| Module | Topic | Engineering Focus | Apex Bridge |
|--------|-------|-------------------|-------------|
| 1.1 | Hello Java + Build Systems | Gradle vs "Deploy to Org" | No build system in SF |
| 1.2 | Variables, Types & Type Safety | Primitive vs Reference types | Similar but Java has primitives |
| 1.3 | Control Flow & Pattern Matching | Switch expressions (Java 21+) | Apex switch is basic |
| 1.4 | Methods & Clean Code | Method design, SRP | Similar to Apex methods |
| 1.5 | Arrays & Collections | ArrayList, HashMap, Set | Familiar from Apex |
| 1.6 | Strings & Text Processing | StringBuilder, formatting, regex | String handling differs |

### Phase 2: OOP Deep Dive — 5 modules
> **Build Project:** Payment Entity Model (Transaction, Merchant, Customer)

| Module | Topic | Engineering Focus | Apex Bridge |
|--------|-------|-------------------|-------------|
| 2.1 | Classes & Objects Revisited | Encapsulation, immutability | Nearly identical to Apex |
| 2.2 | Inheritance & Composition | "Favor composition over inheritance" | Apex uses inheritance heavily |
| 2.3 | Interfaces & Abstract Classes | Contract-driven design | Apex interfaces are simpler |
| 2.4 | Enums & Sealed Classes | Domain modeling with types | Apex enums are basic |
| 2.5 | Records & Data Classes | Immutable value objects | No Apex equivalent |

### Phase 3: Java's Power Features — 5 modules
> **Build Project:** Transaction Filter & Reporting Pipeline

| Module | Topic | Engineering Focus | Apex Bridge |
|--------|-------|-------------------|-------------|
| 3.1 | Generics In Depth | Type safety at compile time | Apex generics are simpler |
| 3.2 | Streams API | Functional collection processing | No Apex equivalent |
| 3.3 | Lambdas & Functional Interfaces | Functions as first-class citizens | No Apex equivalent |
| 3.4 | Optional & Null Safety | Eliminating NullPointerException | Apex has no Optional |
| 3.5 | Exception Handling Done Right | Checked vs unchecked, custom exceptions | Similar but more nuanced |

### Phase 4: Testing & Quality — 4 modules
> **Build Project:** Fully Tested Payment Validation Service

| Module | Topic | Engineering Focus | Apex Bridge |
|--------|-------|-------------------|-------------|
| 4.1 | JUnit 5 Fundamentals | Test-driven development | @isTest but much richer |
| 4.2 | Mockito & Test Doubles | Isolation testing | Limited mocking in Apex |
| 4.3 | Integration Testing | Testing real integrations | Apex callout mocks |
| 4.4 | Test Architecture | Test pyramids, fixtures, CI | Different testing philosophy |

### Phase 5: Concurrency & Async — 5 modules
> **Build Project:** Concurrent Transaction Processor

| Module | Topic | Engineering Focus | Apex Bridge |
|--------|-------|-------------------|-------------|
| 5.1 | Threads & Executors | Thread lifecycle, pools | @future is simplistic |
| 5.2 | CompletableFuture | Async composition chains | No Apex equivalent |
| 5.3 | Virtual Threads (Java 21+) | Scalable concurrency | No Apex equivalent |
| 5.4 | Concurrent Collections | Thread-safe data structures | No Apex equivalent |
| 5.5 | Synchronization & Locks | Race conditions, deadlocks | Platform-handled in SF |

### Phase 6: Frameworks & Spring Boot — 5 modules
> **Build Project:** Payment REST API Service

| Module | Topic | Engineering Focus | Apex Bridge |
|--------|-------|-------------------|-------------|
| 6.1 | Spring Boot Basics | Convention over configuration | Similar to SF platform |
| 6.2 | REST APIs with Spring | Controllers, DTOs, validation | @RestResource in Apex |
| 6.3 | Dependency Injection | IoC container, component scanning | No Apex equivalent |
| 6.4 | Spring Data & JPA | ORM, repositories, queries | SOQL but more powerful |
| 6.5 | Spring Security Basics | Authentication, authorization | SF handles this |

### Phase 7: Payment Processing Patterns — 4 modules
> **Build Project:** Payment Gateway Simulator

| Module | Topic | Engineering Focus |
|--------|-------|-------------------|
| 7.1 | Event-Driven Architecture | Kafka, event sourcing, CQRS |
| 7.2 | Resilience Patterns | Circuit breakers, retries, bulkheads (Resilience4j) |
| 7.3 | Payment Domain Modeling | Transaction states, idempotency, reconciliation |
| 7.4 | API Design for Payments | Versioning, backwards compatibility, webhooks |

### Phase 8: AI/ML Integration in Java — 3 modules
> **Build Project:** Fraud Score Prediction Service

| Module | Topic | Engineering Focus |
|--------|-------|-------------------|
| 8.1 | ML Model Serving in Java | ONNX Runtime, DJL, model loading |
| 8.2 | Feature Engineering in Java | Real-time feature extraction for fraud scoring |
| 8.3 | Real-Time Inference Pipeline | Low-latency prediction serving, A/B testing |

### Phase 9: Production Systems — 3 modules
> **Build Project:** Production-Ready Payment Microservice

| Module | Topic | Engineering Focus |
|--------|-------|-------------------|
| 9.1 | Observability | Logging (SLF4J), metrics (Micrometer), tracing |
| 9.2 | Docker & Deployment | Containerization, CI/CD, health checks |
| 9.3 | Performance & JVM Tuning | GC tuning, profiling, heap analysis |

---

## Capstone Projects

### Capstone 1: Payment Processing Engine
Build a complete payment processing pipeline:
- Accept payment requests via REST API
- Validate card details and amounts
- Route to appropriate payment processor (strategy pattern)
- Handle 3DS authentication flows
- Process responses and update transaction state
- Emit events for downstream consumers

### Capstone 2: Fraud Detection Service
Build a real-time fraud scoring microservice:
- Consume transaction events from a queue
- Extract features (velocity, geolocation, device fingerprint)
- Score using a pre-trained ML model (ONNX)
- Apply rules engine for additional checks
- Return risk score with confidence interval
- Log decisions for model retraining

### Capstone 3: Payment Reconciliation System
Build a batch reconciliation service:
- Ingest settlement files from acquirers
- Match against internal transaction records
- Identify discrepancies (missing, duplicate, amount mismatch)
- Generate reconciliation reports
- Handle multi-currency conversion
- Implement retry logic for unmatched transactions

---

## Learning Approach: Projects-First with Syntax On-Demand

### Why Not "Learn All Syntax First"?
You already know OOP from Apex. Learning Java syntax in isolation would be:
1. **Boring** — You'd recognize 70% of it
2. **Slow** — Context-free memorization doesn't stick
3. **Misaligned** — Checkout.com doesn't care if you can recite Java specs

### The Approach
Each phase follows this pattern:
1. **Quick Syntax Bridge** — "In Apex you did X, in Java it's Y" (15 min)
2. **Concept Deep Dive** — What's genuinely new and why it matters (30 min)
3. **Guided Challenge** — Small focused problem with payment context (45 min)
4. **Build Project** — Apply everything in a real mini-project (2-3 sessions)
5. **Review & Reflect** — What did you learn? What's still fuzzy? (15 min)

### Estimated Timeline
- **Phase 1-2 (Foundations + OOP):** 2-3 weeks — Fast because of Apex background
- **Phase 3-4 (Power Features + Testing):** 2-3 weeks — New territory, take your time
- **Phase 5 (Concurrency):** 2 weeks — Critical for payment systems
- **Phase 6 (Spring Boot):** 2-3 weeks — The framework Checkout.com likely uses
- **Phase 7-8 (Payments + AI):** 3-4 weeks — The target skills
- **Phase 9 (Production):** 1-2 weeks — Putting it all together
- **Capstones:** 4-6 weeks — Portfolio-worthy projects

**Total: ~16-22 weeks** at 1-2 hours/day

---

## Session Commands

| Command | Action |
|---------|--------|
| `start session` | Load progress, show current state, suggest focus |
| `end session` | Save progress, log session, suggest next steps |
| `give me a problem` | Generate a challenge for current module |
| `I'm stuck` | Concept explanation with analogies (no answers) |
| `I solved it` | Review solution, update progress, advance |
| `what's the Apex equivalent?` | Side-by-side comparison |
| `how would a senior dev do this?` | Engineering mindset explanation |
| `help me design this` | Design-phase guidance before coding |
| `show my progress` | Display progress.json summary |
| `why does this matter?` | Connect concept to Checkout.com's actual systems |

---

## Neovim Integration

All challenges include Neovim guidance. Assume:
- Leader key is `<Space>`
- Using LazyVim or similar modern config
- Terminal integration via `:split | term` or tmux
- File navigation via `<Space>ff` (find files) or `<Space>fg` (grep)

### Java-Specific Neovim Setup
- LSP: `jdtls` (Eclipse JDT Language Server) via mason.nvim
- Formatter: `google-java-format`
- DAP: `java-debug-adapter` for debugging
- Testing: `neotest-java` for running JUnit tests inline

---

## Key Differences: Java vs Apex (Quick Reference)

### Things That Will Surprise You
1. **No governor limits** — But you must manage memory/threads yourself
2. **No automatic deployment** — You build JARs, configure servers, manage infrastructure
3. **Real concurrency** — Not just `@future` — actual threads, race conditions, deadlocks
4. **Package management** — Maven Central has 500k+ libraries (Apex has managed packages)
5. **Checked exceptions** — Compiler forces you to handle certain errors
6. **Primitives exist** — `int` vs `Integer`, `boolean` vs `Boolean` (autoboxing)
7. **No SOQL** — You write SQL or use JPA/Hibernate ORM
8. **Build takes time** — Compilation, dependency resolution, test execution
9. **You own the runtime** — JVM configuration, GC tuning, memory allocation
10. **Testing is different** — No `@isTest`, you use JUnit + Mockito + test containers

### Things That Will Feel Familiar
1. Class structure, inheritance, interfaces
2. Collections (List, Map, Set)
3. Exception handling (try/catch/finally)
4. Annotations (@Override, @Deprecated ≈ @AuraEnabled, @InvocableMethod)
5. Access modifiers (public, private, protected)
6. Static methods and variables
7. String manipulation
8. For-each loops
9. Ternary operator
10. Null handling (though Java has Optional)

---

## C# Parallel Track (Lightweight)

Since Checkout.com uses both Java and C#, key differences are noted throughout:

| Concept | Java | C# |
|---------|------|-----|
| Properties | Getters/setters | `{ get; set; }` auto-properties |
| Async | `CompletableFuture<T>` | `async/await` with `Task<T>` |
| Null safety | `Optional<T>` | Nullable reference types `?` |
| Records | `record Point(int x, int y)` | `record Point(int X, int Y)` |
| LINQ/Streams | `.stream().filter().map()` | `.Where().Select()` |
| DI framework | Spring | ASP.NET Core built-in |
| Build tool | Gradle/Maven | dotnet CLI / MSBuild |

C# comparisons will be brief callouts, not full lessons. The focus is Java.

---

## Progress Tracking

### Files
- **progress.json** — Structured state (current module, completed, struggles)
- **learning-log.md** — Session journal (what I learned, breakthroughs, confusion)

### Metrics Tracked
- Modules completed / total
- Challenges solved
- Projects built
- Engineering concepts learned
- Current streak (consecutive sessions)
- Struggle history (what was hard and how it was resolved)
