# User Stories and Acceptance Criteria

> Note: filename uses `.dm` as provided. Content follows standard user-story format.

## Epic: Candidate Intake

- As a clinician, I want to create a candidate profile so that I can submit them for review.
  - Acceptance Criteria:
    - Form validates required fields (name, DOB, contact, case details).
    - On submit, status becomes `Submitted` and an event is logged.

- As an admin, I want to bulk import candidate CSV so that I can onboard historical data.
  - Acceptance Criteria:
    - CSV template is downloadable and validates on upload.
    - Errors are surfaced with row-level messages.

## Epic: Scoring and Review

- As a clinician, I want to apply a scoring template to a candidate so I can rate suitability.
  - Acceptance Criteria:
    - Scores persist to the candidate record with timestamp and reviewer ID.
    - Score breakdown and computed total are visible.

- As an admin, I want to define scoring weights so that the scoring engine reflects policy.
  - Acceptance Criteria:
    - Weights are saved and affect subsequent score computations.
    - Changes are versioned and auditable.

## Epic: Reporting

- As an admin, I want to export candidate lists filtered by status so I can share them with stakeholders.
  - Acceptance Criteria:
    - Export respects filters and includes score and key metadata.

## Epic: Security & Access

- As a system, I must restrict actions by user role so that users only see permitted data.
  - Acceptance Criteria:
    - RBAC enforced on all endpoints and UI actions.

## Formatting Notes
- Each story follows: Role / Action / Benefit + Acceptance Criteria.
- Stories are prioritized per MVP: Intake > Scoring > Reporting > Admin features.

---
Generated: 02-user-stories-and-acceptance-criteria.dm
