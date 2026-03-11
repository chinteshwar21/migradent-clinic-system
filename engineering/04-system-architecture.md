# System Architecture

## Overview
High-level architecture for Migradent MVP: a web-based application with a REST API backend, a scoring engine service, cloud storage for documents, and a relational database for core data.

## Components
- Web UI: React single-page app for clinicians and admins.
- Backend API: RESTful service (Node.js/Express or Python/Flask/FastAPI) handling business logic.
- Scoring Engine: separate service or library invoked by backend to compute scores.
- Database: Managed relational DB (Postgres) for core entities.
- Blob Storage: Object store for documents (Azure Blob / S3).
- Auth: OAuth2 / OpenID Connect provider for SSO.
- Worker Queue: Background processing (e.g., Redis + Bull or Celery) for heavy tasks and imports.
- Monitoring & Logging: App insights, centralized logging, alerting.

## Deployment Diagram (conceptual)
- Client (browser) -> CDN -> Web App -> API Gateway -> Backend Service
- Backend -> Database
- Backend -> Blob Storage
- Backend -> Worker Queue -> Scoring Engine/Workers

## Data Flow
- User action -> API -> DB update -> (optionally) enqueue job -> worker -> scoring -> DB update

## Scalability
- Stateless backend horizontally scalable behind load balancer.
- Database scaled vertically initially with read replicas as needed.
- Blob store as highly scalable external service.

## Security
- TLS for all network traffic.
- OAuth2 authentication with RBAC authorization checks.
- Encrypt sensitive fields at rest.
- API rate limiting and WAF for public endpoints.

## Operational Considerations
- Blue/green or rolling deploys for minimal downtime.
- Backup strategy for DB and Blob storage.
- Health checks and readiness probes for services.

---
Generated: 04-system-architecture.md
