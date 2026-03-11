# API Contracts

All endpoints follow REST conventions, return JSON, and use standard HTTP status codes.

## Authentication
- Use `Authorization: Bearer <token>` header with OAuth2 JWT tokens.

## Endpoints (selected)

### GET /api/v1/candidates
- Query params: `status`, `page`, `page_size`, `q` (search)
- Response: 200 OK
  - `{ "items": [ {candidate}, ... ], "meta": {"total": 123, "page": 1, "page_size": 25 } }

### POST /api/v1/candidates
- Body: `{ first_name, last_name, dob, contact_email, contact_phone, metadata? }`
- Response: 201 Created with created candidate.

### GET /api/v1/candidates/{id}
- Response: 200 OK with candidate details and linked cases.

### PUT /api/v1/candidates/{id}
- Body: updatable candidate fields
- Response: 200 OK with updated candidate.

### POST /api/v1/cases/{case_id}/scores
- Body: `{ template_id, raw_scores: {...} }`
- Response: 201 Created with computed `total_score` and score record.

### GET /api/v1/scoring-templates
- Response: list of templates

### POST /api/v1/uploads
- Multipart/form-data: `file`, `candidate_id?`, `case_id?`
- Response: 201 Created, `{ file_id, file_key }`

## Error format
- 4xx/5xx responses:
  - `{ "error": { "code": "INVALID_INPUT", "message": "Description", "details": {...} } }

## Pagination & Filtering
- Use cursor or page-based pagination. Start with page-based for MVP.

## Versioning
- All endpoints under `/api/v1/` for first release.

---
Generated: 06-api-contracts.md
