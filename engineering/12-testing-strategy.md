# Testing Strategy

## Objectives
Ensure reliability, correctness, and maintainability through a layered testing approach.

## Test Pyramid
- Unit tests: fast, isolated tests for business logic (scoring engine, validation).
- Integration tests: DB interactions, API endpoints.
- End-to-end (E2E) tests: simulate user flows via the UI.
- Smoke tests: basic health checks post-deploy.

## Test Types & Tools
- Unit: Jest / pytest depending on stack.
- Integration: testcontainers/local DB or CI-managed staging DB.
- E2E: Playwright or Cypress for UI flows.
- Load testing: k6 for performance benchmarks.

## Coverage Goals
- Unit: 80%+ for core modules.
- Integration: Critical endpoints covered.
- E2E: Key user journeys (intake, scoring, export).

## CI Integration
- Run unit and lint on every PR.
- Run integration tests on merges to `develop`/`staging`.
- E2E runs nightly against staging.

## Test Data & Isolation
- Use fixtures and factory methods to create test data.
- Ensure tests clean-up and use disposable resources.

## Failure Handling
- Flaky tests are quarantined and investigated.
- Alerts for regression test failures in CI.

---
Generated: 12-testing-strategy.md
