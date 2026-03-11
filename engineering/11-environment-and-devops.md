# Environment and DevOps

## Environments
- `local` — developer machines
- `staging` — integration environment for QA
- `production` — customer-facing

## Infrastructure
- Use IaC (Bicep or Terraform) to provision:
  - App service or container hosting
  - Managed Postgres
  - Object storage (Blob/S3)
  - Redis or message queue
  - Monitoring and alerting resources

## CI/CD
- GitHub Actions or Azure DevOps pipelines
- Pipeline stages: lint -> unit tests -> build -> deploy to staging -> e2e tests -> deploy to production (manual approval)

## Secrets and Config
- Store secrets in KeyVault / Secret Manager.
- Use environment-specific configuration with overrides.

## Backups & DR
- Daily DB backups and point-in-time recovery enabled.
- Recovery runbooks documented.

## Observability
- Metrics: request latencies, error rates, queue length, job failures.
- Traces for long-running requests.
- Centralized logs with retention policy.

## Local Dev Setup
- Provide Docker Compose to run DB and local services.
- Developer doc with `pnpm` / `npm` scripts.

---
Generated: 11-environment-and-devops.md
