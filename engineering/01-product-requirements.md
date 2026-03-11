# Product Requirements

## Overview
This document describes the product requirements for the Migradent MVP — a system to manage, score, and track dental migration cases and candidate assessments. It covers functional and non-functional requirements, constraints, and success metrics.

## Purpose
Provide clear, testable, and prioritized requirements to guide engineering and design for the MVP release.

## Scope
- Candidate intake and profile management
- Scoring engine for candidate evaluations
- Admin UI for case management and scoring rules
- APIs for integration with third-party systems
- Data storage and audit trails

## Primary Users
- Administrators (configure scoring, manage cases)
- Clinicians (review and score candidates)
- Candidates (submit profiles, view status)
- Integrations (external systems using APIs)

## Functional Requirements
1. Candidate Management
   - Create, read, update, delete candidate profiles.
   - Upload and store candidate documents (PDF, images) with metadata.
2. Intake Workflow
   - Multi-step intake form with validation.
   - Status states: Draft, Submitted, Under Review, Completed, Rejected.
3. Scoring Engine
   - Rules-based scoring with configurable weights.
   - Support for manual overrides and audit logging.
4. Reporting
   - Export candidate lists and scoring results (CSV, PDF).
5. Authentication & Authorization
   - Role-based access control (RBAC): Admin, Clinician, Viewer.
6. API
   - RESTful API endpoints for candidate and scoring resources.

## Non-Functional Requirements
- Availability: 99.5% SLA for core services.
- Performance: Candidate retrieval under 300ms for typical queries.
- Security: Data encrypted in transit and at rest; audit logs retained for 1 year.
- Scalability: Handle up to 10k active candidates in initial release.
- Compliance: GDPR-ready data deletion support.

## Constraints & Assumptions
- MVP uses cloud-hosted managed database.
- Authentication via OAuth2 (enterprise SSO added later).
- File storage integrated with cloud blob store.

## Success Metrics
- Ability to onboard 50 clinics in 6 months.
- Average scoring time per candidate under 5 minutes.
- 95% of critical workflows covered by automated tests.

## Open Questions
- Which SSO providers to support for MVP?
- Offline workflows for clinicians?


---
Generated: 01-product-requirements.md
