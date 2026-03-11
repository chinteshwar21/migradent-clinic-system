# Information Architecture

## Goals
Define how data, content, and navigation are organized to support the product workflows and ensure discoverability and security.

## Top-level Entities
- Candidate
- Case (a specific review instance tied to candidate)
- User (Admin, Clinician, Viewer)
- Scoring Template
- Document (files associated with candidate/case)
- AuditEvent

## Entity Relationships (high-level)
- Candidate 1..* -> Case
- Candidate 1..* -> Document
- Case 1 -> ScoringTemplate (applied)
- User 1..* -> AuditEvent

## Navigation Structure (UI)
- Dashboard: summaries, alerts, pending reviews
- Candidates: list, search, filters, create
- Cases: open reviews, history
- Scoring: templates, engine configuration
- Admin: users, roles, integrations, system settings
- Reports: exports, scheduled reports

## Data Flow
1. Candidate submission: intake -> validation -> persist -> enqueue scoring (optional)
2. Review workflow: clinician fetches candidate -> applies scores -> completes case -> triggers notifications
3. Audit logging: every state change and score save creates an AuditEvent

## Metadata & Indexing
- Searchable fields: name, email, case id, status, score range, tags
- Use secondary indexes for status and score to enable fast filters

## Retention & Archival
- Candidate records: active + archived flag; archive after 2 years of inactivity
- Audit events: retained for 1 year (configurable)

---
Generated: 03-information-architecture.md
