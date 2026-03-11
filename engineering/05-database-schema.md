# Database Schema

## Core Tables (relational model)

### users
- id (PK, uuid)
- email (unique)
- name
- role (enum: admin, clinician, viewer)
- created_at
- updated_at

### candidates
- id (PK, uuid)
- first_name
- last_name
- dob (date)
- contact_email
- contact_phone
- status (enum)
- created_by (FK users.id)
- created_at
- updated_at
- archived (boolean)

### cases
- id (PK, uuid)
- candidate_id (FK candidates.id)
- assigned_to (FK users.id)
- status (enum)
- summary
- created_at
- updated_at

### documents
- id (PK, uuid)
- candidate_id (FK candidates.id) nullable
- case_id (FK cases.id) nullable
- file_key (blob storage path)
- file_name
- content_type
- uploaded_by (FK users.id)
- uploaded_at

### scoring_templates
- id (PK)
- name
- description
- rules (jsonb)
- version
- created_at

### scores
- id (PK)
- case_id (FK cases.id)
- template_id (FK scoring_templates.id)
- reviewer_id (FK users.id)
- raw_scores (jsonb)
- total_score (numeric)
- created_at

### audit_events
- id (PK)
- entity_type
- entity_id
- action
- actor_id
- metadata (jsonb)
- created_at

## Indexing Recommendations
- Index on `candidates(status, updated_at)` for list filters.
- GIN index on jsonb fields used for querying (e.g. `rules`, `raw_scores`).

## Migration Notes
- Use migration tooling (Flyway/DbMate/Knex/ Alembic) to version schema.
- Data retention handled by scheduled jobs.

---
Generated: 05-database-schema.md
